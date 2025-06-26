package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;


import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_Comment {

    /**
     *  public class Comment {
     *      // nur Kommentare …
     *  }
     */
    public static Program get() {
        // Leerer Konstruktor
        MethodDecl constructor = new MethodDecl(
                "Comment",
                "void",
                List.of(),                        // keine Parameter
                new Block(List.of())              // leerer Block
        );

        // Klasse mit Konstruktor
        ClassDecl clazz = new ClassDecl(
                "Comment",          // Klassenname
                List.of(),          // keine Felder
                List.of(constructor),          // nur Konstruktor
                Optional.empty()    // keine main-Methode
        );

        return new Program(List.of(clazz));
    }
}
