package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_ClassDecl {

    /**
     *  public class ClassDecl { }
     */
    public static Program get() {
        // Leerer Konstruktor
        MethodDecl constructor = new MethodDecl(
                "ClassDecl",
                "void",
                List.of(),                        // keine Parameter
                new Block(List.of())              // leerer Block
        );

        // Klasse mit Konstruktor
        ClassDecl clazz = new ClassDecl(
                "ClassDecl",
                List.of(),                        // keine Felder
                List.of(constructor),             // genau 1 Konstruktor
                Optional.empty()                  // keine main-Methode
        );

        return new Program(List.of(clazz));
    }
}
