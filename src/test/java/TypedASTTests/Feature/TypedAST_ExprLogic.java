package TypedASTTests.Feature;

import AST.BinaryOperator;
import TypedAST.Type;
import TypedAST.TypedClasses.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_ExprLogic {

    public static TypedProgram get() {

        // Methoden
        TypedMethodDecl test1 = new TypedMethodDecl("test1", List.of(), createIntCompareBlock(BinaryOperator.LT), Type.BOOL);
        TypedMethodDecl test2 = new TypedMethodDecl("test2", List.of(), createIntCompareBlock(BinaryOperator.GT), Type.BOOL);
        TypedMethodDecl test3 = new TypedMethodDecl("test3", List.of(), createIntCompareBlock(BinaryOperator.EQ), Type.BOOL);
        TypedMethodDecl test4 = new TypedMethodDecl("test4", List.of(), createIntCompareBlock(BinaryOperator.NEQ), Type.BOOL);
        TypedMethodDecl test5 = new TypedMethodDecl("test5", List.of(), createBoolLogicBlock(BinaryOperator.OR), Type.BOOL);
        TypedMethodDecl test6 = new TypedMethodDecl("test6", List.of(), createBoolLogicBlock(BinaryOperator.AND), Type.BOOL);

        TypedMethodDecl constructor = new TypedMethodDecl("ExprLogic", List.of(), new TypedBlock(List.of()), Type.VOID);

        TypedClassDecl clazz = new TypedClassDecl("ExprLogic", List.of(),
                List.of(test1, test2, test3, test4, test5, test6, constructor),
                Optional.empty());

        return new TypedProgram(List.of(clazz));
    }

    // <-- Diese Methoden stehen AUßERHALB von get()!

    private static TypedBlock createIntCompareBlock(BinaryOperator op) {
        return new TypedBlock(List.of(
                new TypedLocalVarDecl("a", Type.INT),
                new TypedAssign(
                    new TypedLocalOrFieldVar("a", true,Type.INT),
                    new TypedIntLiteral(10),
                    Type.INT
                ),
                new TypedLocalVarDecl("b", Type.INT),
                new TypedAssign(
                    new TypedLocalOrFieldVar("b", true,Type.INT),
                    new TypedIntLiteral(11),
                    Type.INT
                ),
                new TypedReturn(
                    new TypedBinary(
                            new TypedLocalVarDecl("a", Type.INT),
                        new TypedLocalOrFieldVar("b", true, Type.INT),
                        op,
                        Type.BOOL
                    ),
                    Type.BOOL
                )
        ), Type.BOOL);
    }

    private static TypedBlock createBoolLogicBlock(BinaryOperator op) {
        return new TypedBlock(List.of(
                new TypedLocalVarDecl("a", Type.BOOL),
                new TypedAssign(
                    new TypedLocalOrFieldVar("a", true, Type.BOOL),
                    new TypedBoolLiteral(true),
                    Type.BOOL
                ),
                new TypedLocalVarDecl("b", Type.BOOL),
                new TypedAssign(
                    new TypedLocalOrFieldVar("b", true, Type.BOOL),
                    new TypedBoolLiteral(false),
                    Type.BOOL
                ),
                new TypedReturn(
                    new TypedBinary(
                        new TypedLocalOrFieldVar("a", true, Type.BOOL),
                        new TypedLocalOrFieldVar("b", true),
                        op,
                        Type.BOOL
                    ),
                    Type.BOOL
                )
        ), Type.BOOL);
    }
}
