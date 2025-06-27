package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.TypedBlock;
import TypedAST.TypedClasses.TypedClassDecl;
import TypedAST.TypedClasses.TypedMethodDecl;
import TypedAST.TypedClasses.TypedProgram;

import java.util.List;
import java.util.Optional;

public class TypedAST_Comment {

    /**
     *  public class Comment {
     *      // nur Kommentare …
     *  }
     */
    public static TypedProgram get() {
        // Leerer Konstruktor mit TypedBlock
        TypedMethodDecl constructor = new TypedMethodDecl(
                "Comment",
                List.of(),                        // keine Parameter
                new TypedBlock(List.of()),  // leerer Block mit VOID-Typ
                Type.VOID                         // void Rückgabetyp
        );

        // Klasse mit Konstruktor
        TypedClassDecl clazz = new TypedClassDecl(
                "Comment",          // Klassenname
                List.of(),          // keine Felder
                List.of(constructor),          // nur Konstruktor
                Optional.empty()    // keine main-Methode
        );

        return new TypedProgram(List.of(clazz));
    }
}
