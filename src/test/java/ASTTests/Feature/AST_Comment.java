package ASTTests.Feature;

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

        ClassDecl clazz = new ClassDecl(
                "Comment",          // Klassenname
                List.of(),          // keine Felder
                List.of(),          // keine Methoden
                Optional.empty()    // keine main-Methode
        );

        return new Program(List.of(clazz));
    }
}
