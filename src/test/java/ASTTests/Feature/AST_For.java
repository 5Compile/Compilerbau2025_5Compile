package ASTTests.Feature;

import AST.*;
import TypedAST.Type;

import java.util.List;
import java.util.Optional;

public class AST_For {

    /**
     * public class For {
     *     public void forLoop() {
     *         int i;
     *         for (i = 0; i < 10; i = i + 1) {
     *             // Schleifenkörper
     *         }
     *     }
     * }
     */
    public static Program get() {
        // Methode forLoop mit einer For-Schleife
        MethodDecl forLoopMethod = new MethodDecl(
                Type.VOID.toString(),
                "forLoop",
                List.of(),  // keine Parameter
                new Block(List.of(
                        // int i;  (Deklaration vor der Schleife)
                        new LocalVarDecl(Type.INT.toString(), "i"),

                        // for (i = 0; i < 10; i = i + 1) { ... }
                        new For(
                                // Initialisierung: i = 0
                                new Assign(new LocalOrFieldVar("i"), new IntLiteral(0)),

                                // Bedingung: i < 10
                                new Binary(
                                        new LocalOrFieldVar("i"),
                                        new IntLiteral(10),
                                        BinaryOperator.LT
                                ),

                                // Update: i = i + 1
                                new Assign(
                                        new LocalOrFieldVar("i"),
                                        new Binary(
                                                new LocalOrFieldVar("i"),
                                                new IntLiteral(1),
                                                BinaryOperator.PLUS
                                                )
                                ),

                                // Schleifenkörper (leer in diesem Beispiel)
                                new Block(List.of())
                        )
                ))
        );

        // Klasse zusammensetzen
        ClassDecl clazz = new ClassDecl(
                "For",
                List.of(),                      // keine Felder
                List.of(forLoopMethod),        // nur die forLoop Methode
                Optional.empty()               // keine main-Methode
        );

        // Program-Root
        return new Program(List.of(clazz));
    }
}
