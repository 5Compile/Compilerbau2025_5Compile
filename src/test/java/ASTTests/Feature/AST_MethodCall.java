package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_MethodCall {

    public static Program get() {
        // Methode: int method() { return 1; }
        MethodDecl method = new MethodDecl(
                "method",
                "int",
                List.of(),
                new Block(List.of(
                        new Return(new IntLiteral(1))
                ))
        );

        // Konstruktor: MethodCall() { } ← leerer Body, wie vom Parser geliefert
        MethodDecl constructor = new MethodDecl(
                "MethodCall",
                "void",
                List.of(),
                new Block(List.of()) // ← leer!
        );

        // Klasse MethodCall
        ClassDecl clazz = new ClassDecl(
                "MethodCall",
                List.of(),
                List.of(method, constructor),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}
