package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_Operators {

    public static Program get() {
        // Methode: public int add(int a, int b){return a + b;}
        MethodDecl addMethod = new MethodDecl(
                "add",
                "int",
                List.of(
                        new Parameter("int", "a"),
                        new Parameter("int", "b")
                ),
                new Block(List.of(
                        new Return(new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                BinaryOperator.PLUS
                        ))
                ))
        );

        // Methode: public int sub(int a, int b){return a - b;}
        MethodDecl subMethod = new MethodDecl(
                "sub",
                "int",
                List.of(
                        new Parameter("int", "a"),
                        new Parameter("int", "b")
                ),
                new Block(List.of(
                        new Return(new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                BinaryOperator.MINUS
                        ))
                ))
        );

        // Methode: public int mul(int a, int b){return a * b;}
        MethodDecl mulMethod = new MethodDecl(
                "mul",
                "int",
                List.of(
                        new Parameter("int", "a"),
                        new Parameter("int", "b")
                ),
                new Block(List.of(
                        new Return(new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                BinaryOperator.TIMES
                        ))
                ))
        );

        // Methode: public int div(int a, int b){return a/b;}
        MethodDecl divMethod = new MethodDecl(
                "div",
                "int",
                List.of(
                        new Parameter("int", "a"),
                        new Parameter("int", "b")
                ),
                new Block(List.of(
                        new Return(new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                BinaryOperator.DIV
                        ))
                ))
        );

        // Methode: public int mod(int a, int b){return a%b;}
        MethodDecl modMethod = new MethodDecl(
                "mod",
                "int",
                List.of(
                        new Parameter("int", "a"),
                        new Parameter("int", "b")
                ),
                new Block(List.of(
                        new Return(new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                BinaryOperator.MOD
                        ))
                ))
        );

        // Methode: public int brackets(int a, int b){return (a+b)*a;}
        MethodDecl bracketsMethod = new MethodDecl(
                "brackets",
                "int",
                List.of(
                        new Parameter("int", "a"),
                        new Parameter("int", "b")
                ),
                new Block(List.of(
                        new Return(new Binary(
                                new Binary(
                                        new LocalOrFieldVar("a"),
                                        new LocalOrFieldVar("b"),
                                        BinaryOperator.PLUS
                                ),
                                new LocalOrFieldVar("a"),
                                BinaryOperator.TIMES
                        ))
                ))
        );

        // Impliziter Default-Konstruktor
        MethodDecl constructor = new MethodDecl(
                "Operators",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Klasse Operators
        ClassDecl clazz = new ClassDecl(
                "Operators",
                List.of(),
                List.of(addMethod, subMethod, mulMethod, divMethod, modMethod, bracketsMethod, constructor),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}