import AST.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ASTGenerator {

    public static ClassDecl generateAST(MiniJavaParser.ClassContext ctx) {
        String className = ctx.name().IDENTIFIER().getText();

        // Felder
        List<FieldDecl> fieldDecls = new ArrayList<>();
        if (ctx.fieldDecl() != null) {
            fieldDecls = ctx.fieldDecl().stream()
                    .map(ASTGenerator::generateFieldDecl)
                    .toList();
        }

        // Methoden
        List<MethodDecl> methodDecls = new ArrayList<>();
        if (ctx.methodDecl() != null) {
            methodDecls = ctx.methodDecl().stream()
                    .map(ASTGenerator::generateMethodDecl)
                    .toList();
        }

        // Konstruktor hinzufügen falls nötig
        boolean hasConstructor = methodDecls.stream().anyMatch(m ->
                m.name().equals(className)
                        && m.returnType().equals("void")
                        && (m.parameters() == null || m.parameters().isEmpty())
        );

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

        // Main-Methode
        Optional<MainMethodDecl> mainMethod = Optional.empty();
        if (ctx.mainmethodDecl() != null && !ctx.mainmethodDecl().isEmpty()) {
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
            Statement s = generateStatement(stmtCtx);
            if (s != null) {
                statements.add(s);
            }
        }

        if (ctx.return_() != null && ctx.return_().expr() != null) {
            Expression returnExpr = generateExpr(ctx.return_().expr());
            statements.add(new Return(returnExpr));
        }

        return new Block(statements);
    }

    public static Statement generateStatement(MiniJavaParser.StatementContext ctx) {
        if (ctx.getText().startsWith("print")) {
            return new PrintStmt(generateExpr(ctx.expr()));
        }

        // Platzhalter für weitere Statementarten
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

        // Platzhalter für weitere Expr-Arten
        return null;
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
