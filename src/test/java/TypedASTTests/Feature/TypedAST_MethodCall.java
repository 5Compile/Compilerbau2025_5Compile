package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_MethodCall {

    public static TypedProgram get() {
        // Methode: int method() { return 1; }
        TypedMethodDecl method = new TypedMethodDecl(
                "method",
                Type.INT,
                List.of(),
                new TypedBlock(List.of(
                        new TypedReturn(new TypedIntLiteral(1), Type.INT)
                )),
                Type.INT
        );

        // Konstruktor: MethodCall() { } ← leerer Body, wie vom Utils.Parser geliefert
        TypedMethodDecl constructor = new TypedMethodDecl(
                "MethodCall",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of()), // ← leer!
                Type.VOID
        );

        // Klasse MethodCall
        TypedClassDecl clazz = new TypedClassDecl(
                "MethodCall",
                List.of(),
                List.of(method, constructor),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
