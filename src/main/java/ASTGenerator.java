import AST.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ASTGenerator {

    public static ClassDecl generateAST(MiniJavaParser.ClassContext ctx) {
        String className = ctx.name().IDENTIFIER().getText();

        List<FieldDecl> fieldDecls = new ArrayList<>();
        if (ctx.fieldDecl() != null) {
            fieldDecls = ctx.fieldDecl().stream()
                    .map(ASTGenerator::generateFieldDecl)
                    .toList();
        }

        List<MethodDecl> methodDecls = new ArrayList<>();
        if (ctx.methodDecl() != null) {
            methodDecls = ctx.methodDecl().stream()
                    .map(ASTGenerator::generateMethodDecl)
                    .toList();
        }

        boolean hasConstructor = methodDecls.stream().anyMatch(m ->
                m.name().equals(className)
                        && m.returnType().equals("void")
                        && (m.parameters() == null || m.parameters().isEmpty())
        );

        // Konstruktor hinzufügen, falls keiner existiert
        if (!hasConstructor) {
            MethodDecl constructor = new MethodDecl(
                    className,
                    "void",
                    new ArrayList<>(),
                    new Block(new ArrayList<>())
            );
            methodDecls = new ArrayList<>(methodDecls);
            methodDecls.add(constructor);
        }

        // Nur die erste Main-Methode wird übernommen
        Optional<MainMethodDecl> mainMethod = Optional.empty();
        if (ctx.mainmethodDecl() != null && !ctx.mainmethodDecl().isEmpty()) {
            if (ctx.mainmethodDecl().size() > 1) {
                System.out.println("Warnung: Mehrere Main-Methoden gefunden – es wird nur die erste verwendet.");
            }
            mainMethod = Optional.of(generateMainMethodDecl(ctx.mainmethodDecl(0)));
        }

        return new ClassDecl(className, fieldDecls, methodDecls, mainMethod);
    }

    public static FieldDecl generateFieldDecl(MiniJavaParser.FieldDeclContext ctx) {
        String type = getType(ctx.type());
        String name = ctx.name().IDENTIFIER().getText();
        return new FieldDecl(type, name);
    }

    public static MethodDecl generateMethodDecl(MiniJavaParser.MethodDeclContext ctx) {
        String returnType = getType(ctx.returntype());
        String methodName = ctx.name().IDENTIFIER().getText();

        List<Parameter> parameters = new ArrayList<>();
        if (ctx.parameters() != null) {
            for (MiniJavaParser.ParameterContext paramCtx : ctx.parameters().parameter()) {
                String type = getType(paramCtx.type());
                String name = paramCtx.name().IDENTIFIER().getText();
                parameters.add(new Parameter(type, name));
            }
        }

        Block body = generateBlock(ctx.block());

        return new MethodDecl(methodName, returnType, parameters, body);
    }

    public static MainMethodDecl generateMainMethodDecl(MiniJavaParser.MainmethodDeclContext ctx) {
        Block body = generateBlock(ctx.block());
        return new MainMethodDecl(body);
    }

    public static Block generateBlock(MiniJavaParser.BlockContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (MiniJavaParser.StatementContext stmtCtx : ctx.statement()) {
            statements.addAll(generateStatement(stmtCtx));
        }

        if (ctx.return_() != null && ctx.return_().expr() != null) {
            Expression returnExpr = generateExpr(ctx.return_().expr());
            statements.add(new Return(returnExpr));
        }

        return new Block(statements);
    }

    public static List<Statement> generateStatement(MiniJavaParser.StatementContext ctx) {
        List<Statement> result = new ArrayList<>();

        // If-Zweig – unterstützt mehrere Blöcke durch else-if, nimmt aber nur else-Block direkt mit
        if (ctx.ifCall() != null) {
            var ifCtx = ctx.ifCall();
            Expression condition = generateExpr(ifCtx.expr());
            Block thenBlock = generateBlock(ifCtx.block(0));
            Optional<Block> elseBlock = Optional.empty();
            if (ifCtx.ELSE() != null && ifCtx.block().size() > 1) {
                elseBlock = Optional.of(generateBlock(ifCtx.block(1)));
            }
            result.add(new If(condition, thenBlock, elseBlock));
            return result;
        }

        // While-Schleife – expr + block
        if (ctx.getText().startsWith("while")) {
            Expression condition = generateExpr(ctx.expr());
            Block body = generateBlock(ctx.block());
            result.add(new While(condition, body));
            return result;
        }

        // Variable ohne Initialisierung
        if (ctx.localVariable() != null) {
            String type = getType(ctx.localVariable().type());
            String name = ctx.localVariable().name().IDENTIFIER().getText();
            result.add(new LocalVarDecl(type, name));
            return result;
        }

        // Variable mit Initialisierung – wird in zwei Statements umgesetzt
        if (ctx.localVariableWithInitialization() != null) {
            String type = getType(ctx.localVariableWithInitialization().type());
            String name = ctx.localVariableWithInitialization().name().IDENTIFIER().getText();
            Expression value = generateExpr(ctx.localVariableWithInitialization().expr());
            result.add(new LocalVarDecl(type, name));
            result.add(new Assign(new LocalOrFieldVar(name), value));
            return result;
        }

        // Zuweisung oder ++/-- auf Variable
        if (ctx.assign() != null) {
            if (ctx.assign() != null && !ctx.assign().isEmpty()) {
                MiniJavaParser.AssignContext assign = ctx.assign().get(0);

                if (assign.fieldVarAccess() != null && assign.expr() != null) {
                    Expression target = generateFieldVarAccess(assign.fieldVarAccess());
                    Expression value = generateExpr(assign.expr());
                    result.add(new Assign(target, value));
                    return result;
                }

                if (assign.incrDecr() != null) {
                    var fva = assign.incrDecr().fieldVarAccess();
                    Expression target = generateFieldVarAccess(fva);
                    Expression one = new IntLiteral(1);

                    if (assign.incrDecr().incr() != null) {
                        result.add(new Assign(target, new Binary(target, one, BinaryOperator.PLUS)));
                        return result;
                    } else if (assign.incrDecr().decr() != null) {
                        result.add(new Assign(target, new Binary(target, one, BinaryOperator.MINUS)));
                        return result;
                    }
                }
            }
        }

        if (ctx.getText().startsWith("print")) {
            result.add(new PrintStmt(generateExpr(ctx.expr())));
            return result;
        }

        if (ctx.statementexpr() != null) {
            if (ctx.statementexpr().methodCall() != null) {
                result.add(generateMethodCall(ctx.statementexpr().methodCall()));
                return result;
            }
            if (ctx.statementexpr().newCall() != null) {
                result.add(generateNew(ctx.statementexpr().newCall()));
                return result;
            }
        }

        // leeres Statement oder unbekannter Fall
        return result;
    }


    public static Expression generateFieldVarAccess(MiniJavaParser.FieldVarAccessContext ctx) {
        if (ctx.name() != null) {
            return new LocalOrFieldVar(ctx.name().IDENTIFIER().getText());
        }
        return null;
    }

    public static Expression generateExpr(MiniJavaParser.ExprContext ctx) {
        if (ctx instanceof MiniJavaParser.ConstantContext c) {
            if (c.literal().NUMBER() != null) {
                return new IntLiteral(Integer.parseInt(c.literal().NUMBER().getText()));
            }
            if (c.literal().BOOLEANLITERAL() != null) {
                return new BoolLiteral(Boolean.parseBoolean(c.literal().BOOLEANLITERAL().getText()));
            }
            if (c.literal().CHARLITERAL() != null) {
                char ch = c.literal().CHARLITERAL().getText().charAt(1);
                return new CharLiteral(ch);
            }
        }

        if (ctx.getText().equals("null")) {
            return new NullLiteral();
        }

        if (ctx instanceof MiniJavaParser.UnaryOperationContext u) {
            Expression operand = generateExpr(u.expr());
            UnaryOperator op = switch (u.unaryOp().getText()) {
                case "-" -> UnaryOperator.NEG;
                case "!" -> UnaryOperator.NOT;
                default -> throw new RuntimeException("Unknown unary operator: " + u.unaryOp().getText());
            };
            return new Unary(operand, op);
        }

        if (ctx instanceof MiniJavaParser.GroupedExprContext g) {
            return generateExpr(g.expr());
        }

        if (ctx instanceof MiniJavaParser.BinaryOperationContext b) {
            Expression left = generateExpr(b.expr(0));
            Expression right = generateExpr(b.expr(1));
            BinaryOperator op = switch (b.binaryOp().getText()) {
                case "+" -> BinaryOperator.PLUS;
                case "-" -> BinaryOperator.MINUS;
                case "*" -> BinaryOperator.TIMES;
                case "/" -> BinaryOperator.DIV;
                case "%" -> BinaryOperator.MOD;
                case "==" -> BinaryOperator.EQ;
                case "!=" -> BinaryOperator.NEQ;
                case "<" -> BinaryOperator.LT;
                case "<=" -> BinaryOperator.LTE;
                case ">" -> BinaryOperator.GT;
                case ">=" -> BinaryOperator.GTE;
                case "&&" -> BinaryOperator.AND;
                case "||" -> BinaryOperator.OR;
                default -> throw new RuntimeException("Unknown binary operator: " + b.binaryOp().getText());
            };
            return new Binary(left, right, op);
        }

        if (ctx instanceof MiniJavaParser.FieldAccessContext f) {
            return new LocalOrFieldVar(f.fieldVarAccess().name().IDENTIFIER().getText());
        }

        if (ctx instanceof MiniJavaParser.ExprStatementContext e) {
            if (e.statementexpr().methodCall() != null)
                return generateMethodCall(e.statementexpr().methodCall());
            if (e.statementexpr().newCall() != null)
                return generateNew(e.statementexpr().newCall());
        }

        return null;
    }

    public static MethodCall generateMethodCall(MiniJavaParser.MethodCallContext ctx) {
        String methodName = ctx.methName().name().IDENTIFIER().getText();
        List<Expression> args = new ArrayList<>();
        if (ctx.methName().args() != null) {
            for (var arg : ctx.methName().args().expr()) {
                args.add(generateExpr(arg));
            }
        }
        return new MethodCall(null, methodName, args);
    }

    public static New generateNew(MiniJavaParser.NewCallContext ctx) {
        String className = getType(ctx.type());
        List<Expression> args = new ArrayList<>();
        if (ctx.args() != null) {
            for (var arg : ctx.args().expr()) {
                args.add(generateExpr(arg));
            }
        }
        return new New(className, args);
    }

    public static String getType(MiniJavaParser.TypeContext ctx) {
        if (ctx.INT() != null) return "int";
        if (ctx.CHAR() != null) return "char";
        if (ctx.BOOL() != null) return "boolean";
        if (ctx.name() != null) return ctx.name().IDENTIFIER().getText();
        return null;
    }

    public static String getType(MiniJavaParser.ReturntypeContext ctx) {
        if (ctx.VOID() != null) return "void";
        return getType(ctx.type());
    }
}
