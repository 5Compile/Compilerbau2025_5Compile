package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_ClassDecl {

    /**
     *  public class ClassDecl { }
     */
    public static Program get() {
        // leere Klasse
        ClassDecl clazz = new ClassDecl(
                "ClassDecl",
                List.of(),            // keine Felder
                List.of(),            // keine Methoden
                Optional.empty()      // keine main-Methode
        );

        // vollständiges Programm (genau eine Klasse)
        return new Program(List.of(clazz));
    }
}
