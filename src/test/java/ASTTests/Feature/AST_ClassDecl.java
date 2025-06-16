package ASTTests.Feature;

import AST.ClassDecl;

import java.util.List;
import java.util.Optional;

public class AST_ClassDecl {
    public static ClassDecl get() {
        return new ClassDecl(
                "ClassDecl",          // Klassenname
                List.of(),            // leere Felder
                List.of(),            // leere Methoden
                Optional.empty()
        );
    }
}
