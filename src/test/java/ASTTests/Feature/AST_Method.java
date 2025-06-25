package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_Method {
    public static Program get() {
        return new Program(
                List.of(
                        new ClassDecl(
                                "Method",                        // Klassenname
                                List.of(),                       // keine Felder
                                List.of(
                                        new MethodDecl(
                                                "void",                  // Rückgabetyp
                                                "method",                // Methodenname
                                                List.of(),               // keine Parameter
                                                new Block(List.of())     // leerer Block
                                        )
                                ),
                                Optional.empty()                 // keine Main-Methode
                        )
                )
        );
    }
}

