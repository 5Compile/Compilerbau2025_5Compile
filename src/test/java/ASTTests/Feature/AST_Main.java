package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_Main {

    public static Program get() {
        // Inhalt der main-Methode
        Block body = new Block(List.of(
                new LocalVarDecl("int", "i"),
                new Assign(new LocalOrFieldVar("i"), new IntLiteral(0))
        ));

        // MainMethod erstellen
        MainMethodDecl mainMethod = new MainMethodDecl(body);

        // Klasse ohne Methoden (also kein Konstruktor!)
        ClassDecl clazz = new ClassDecl(
                "Main",
                List.of(),           // keine Felder
                List.of(),           // keine Methoden
                Optional.of(mainMethod)
        );

        return new Program(List.of(clazz));
    }
}
