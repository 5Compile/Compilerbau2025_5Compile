package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_ExprLogic {

    public static Program get() {

        // Methoden
        MethodDecl test1 = new MethodDecl("test1", "boolean", List.of(), createIntCompareBlock(BinaryOperator.LT));
        MethodDecl test2 = new MethodDecl("test2", "boolean", List.of(), createIntCompareBlock(BinaryOperator.GT));
        MethodDecl test3 = new MethodDecl("test3", "boolean", List.of(), createIntCompareBlock(BinaryOperator.EQ));
        MethodDecl test4 = new MethodDecl("test4", "boolean", List.of(), createIntCompareBlock(BinaryOperator.NEQ));
        MethodDecl test5 = new MethodDecl("test5", "boolean", List.of(), createBoolLogicBlock(BinaryOperator.OR));
        MethodDecl test6 = new MethodDecl("test6", "boolean", List.of(), createBoolLogicBlock(BinaryOperator.AND));

        MethodDecl constructor = new MethodDecl("ExprLogic", "void", List.of(), new Block(List.of()));

        ClassDecl clazz = new ClassDecl("ExprLogic", List.of(),
                List.of(test1, test2, test3, test4, test5, test6, constructor),
                Optional.empty());

        return new Program(List.of(clazz));
    }

    // <-- Diese Methoden stehen AUßERHALB von get()!

    private static Block createIntCompareBlock(BinaryOperator op) {
        return new Block(List.of(
                new LocalVarDecl("int", "a"),
                new Assign(new LocalOrFieldVar("a"), new IntLiteral(10)),
                new LocalVarDecl("int", "b"),
                new Assign(new LocalOrFieldVar("b"), new IntLiteral(11)),
                new Return(new Binary(
                        new LocalOrFieldVar("a"),
                        new LocalOrFieldVar("b"),
                        op
                ))
        ));
    }

    private static Block createBoolLogicBlock(BinaryOperator op) {
        return new Block(List.of(
                new LocalVarDecl("boolean", "a"),
                new Assign(new LocalOrFieldVar("a"), new BoolLiteral(true)),
                new LocalVarDecl("boolean", "b"),
                new Assign(new LocalOrFieldVar("b"), new BoolLiteral(false)),
                new Return(new Binary(
                        new LocalOrFieldVar("a"),
                        new LocalOrFieldVar("b"),
                        op
                ))
        ));
    }
}
