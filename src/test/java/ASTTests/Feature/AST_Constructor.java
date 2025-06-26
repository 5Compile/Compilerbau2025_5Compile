package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_Constructor {

    /**
     *  public class Constructor{
     *      public Constructor() {
     *          // Leerer Konstruktor mit expliziter Deklaration
     *      }
     *  }
     */
    public static Program get() {
        // Expliziter Konstruktor (diesmal nicht implizit vom AST-Generator hinzugefügt)
        MethodDecl constructor = new MethodDecl(
            "Constructor",
            "void",
            List.of(),                        // keine Parameter
            new Block(List.of())              // leerer Block
        );

        // Klasse mit explizitem Konstruktor
        ClassDecl clazz = new ClassDecl(
            "Constructor",
            List.of(),                        // keine Felder
            List.of(constructor),             // expliziter Konstruktor
            Optional.empty()                  // keine main-Methode
        );

        return new Program(List.of(clazz));
    }
}
