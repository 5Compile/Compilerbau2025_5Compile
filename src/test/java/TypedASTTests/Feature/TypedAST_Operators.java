package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.TypedExpressions.*;
import TypedAST.TypedLiterals.*;
import TypedAST.TypedStatements.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_Operators {

    public static TypedProgram get() {
        // Methode: public int add(int a, int b){return a + b;}
        TypedMethodDecl addMethod = new TypedMethodDecl(
                "add",
                Type.INT,
                List.of(
                        new TypedParamDecl("a", Type.INT),
                        new TypedParamDecl("b", Type.INT)
                ),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedBinary(
                                new TypedLocalOrFieldVar("a", Type.INT, true),
                                new TypedLocalOrFieldVar("b", Type.INT, true),
                                TypedBinaryOperator.PLUS,
                                Type.INT
                        ), Type.INT)
                )),
                Type.INT
        );

        // Methode: public int sub(int a, int b){return a - b;}
        TypedMethodDecl subMethod = new TypedMethodDecl(
                "sub",
                Type.INT,
                List.of(
                        new TypedParamDecl("a", Type.INT),
                        new TypedParamDecl("b", Type.INT)
                ),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedBinary(
                                new TypedLocalOrFieldVar("a", Type.INT, true),
                                new TypedLocalOrFieldVar("b", Type.INT, true),
                                TypedBinaryOperator.MINUS,
                                Type.INT
                        ), Type.INT)
                )),
                Type.INT
        );

        // Methode: public int mul(int a, int b){return a * b;}
        TypedMethodDecl mulMethod = new TypedMethodDecl(
                "mul",
                Type.INT,
                List.of(
                        new TypedParamDecl("a", Type.INT),
                        new TypedParamDecl("b", Type.INT)
                ),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedBinary(
                                new TypedLocalOrFieldVar("a", Type.INT, true),
                                new TypedLocalOrFieldVar("b", Type.INT, true),
                                TypedBinaryOperator.TIMES,
                                Type.INT
                        ), Type.INT)
                )),
                Type.INT
        );

        // Methode: public int div(int a, int b){return a/b;}
        TypedMethodDecl divMethod = new TypedMethodDecl(
                "div",
                Type.INT,
                List.of(
                        new TypedParamDecl("a", Type.INT),
                        new TypedParamDecl("b", Type.INT)
                ),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedBinary(
                                new TypedLocalOrFieldVar("a", Type.INT, true),
                                new TypedLocalOrFieldVar("b", Type.INT, true),
                                TypedBinaryOperator.DIV,
                                Type.INT
                        ), Type.INT)
                )),
                Type.INT
        );

        // Methode: public int mod(int a, int b){return a%b;}
        TypedMethodDecl modMethod = new TypedMethodDecl(
                "mod",
                Type.INT,
                List.of(
                        new TypedParamDecl("a", Type.INT),
                        new TypedParamDecl("b", Type.INT)
                ),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedBinary(
                                new TypedLocalOrFieldVar("a", Type.INT, true),
                                new TypedLocalOrFieldVar("b", Type.INT, true),
                                TypedBinaryOperator.MOD,
                                Type.INT
                        ), Type.INT)
                )),
                Type.INT
        );

        // Methode: public int brackets(int a, int b){return (a+b)*a;}
        TypedMethodDecl bracketsMethod = new TypedMethodDecl(
                "brackets",
                Type.INT,
                List.of(
                        new TypedParamDecl("a", Type.INT),
                        new TypedParamDecl("b", Type.INT)
                ),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedBinary(
                                new TypedBinary(
                                        new TypedLocalOrFieldVar("a", Type.INT, true),
                                        new TypedLocalOrFieldVar("b", Type.INT, true),
                                        TypedBinaryOperator.PLUS,
                                        Type.INT
                                ),
                                new TypedLocalOrFieldVar("a", Type.INT, true),
                                TypedBinaryOperator.TIMES,
                                Type.INT
                        ), Type.INT)
                )),
                Type.INT
        );

        // Impliziter Default-Konstruktor
        TypedMethodDecl constructor = new TypedMethodDecl(
                "Operators",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of()),
                Type.VOID
        );

        // Klasse Operators
        TypedClassDecl clazz = new TypedClassDecl(
                "Operators",
                List.of(),
                List.of(addMethod, subMethod, mulMethod, divMethod, modMethod, bracketsMethod, constructor),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));

        // Methoden für Vergleichsoperatoren
        TypedMethodDecl eqMethod = createComparisonMethod("equals", TypedBinaryOperator.EQ);
        TypedMethodDecl neqMethod = createComparisonMethod("notEquals", TypedBinaryOperator.NEQ);
        TypedMethodDecl ltMethod = createComparisonMethod("lessThan", TypedBinaryOperator.LT);
        TypedMethodDecl gtMethod = createComparisonMethod("greaterThan", TypedBinaryOperator.GT);
        TypedMethodDecl leMethod = createComparisonMethod("lessEquals", TypedBinaryOperator.LE);
        TypedMethodDecl geMethod = createComparisonMethod("greaterEquals", TypedBinaryOperator.GE);

        // Methoden für logische Operatoren
        TypedMethodDecl andMethod = createLogicalMethod("and", TypedBinaryOperator.AND);
        TypedMethodDecl orMethod = createLogicalMethod("or", TypedBinaryOperator.OR);

        // Konstruktor
        TypedMethodDecl constructor = new TypedMethodDecl(
                "Operators",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of()),
                Type.VOID
        );

        // Klasse Operators
        TypedClassDecl clazz = new TypedClassDecl(
                "Operators",
                List.of(),
                List.of(
                    addMethod, subMethod, mulMethod, divMethod, modMethod,
                    eqMethod, neqMethod, ltMethod, gtMethod, leMethod, geMethod,
                    andMethod, orMethod, constructor
                ),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
