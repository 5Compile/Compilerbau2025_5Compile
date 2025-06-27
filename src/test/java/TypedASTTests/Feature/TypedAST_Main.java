package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_Main {

    public static TypedProgram get() {
        // Inhalt der main-Methode
        TypedBlock body = new TypedBlock(List.of(
                new TypedLocalVarDecl("i", Type.INT),
                new TypedAssign(new TypedLocalOrFieldVar("i", Type.INT), new TypedIntLiteral(0))
        ));

        // MainMethod erstellen
        TypedMainMethodDecl mainMethod = new TypedMainMethodDecl(body);

        // Klasse ohne Methoden (also kein Konstruktor!)
        TypedClassDecl clazz = new TypedClassDecl(
                "Main",
                List.of(),           // keine Felder
                List.of(),           // keine Methoden
                Optional.of(mainMethod)
        );

        return new TypedProgram(List.of(clazz));
    }
}
