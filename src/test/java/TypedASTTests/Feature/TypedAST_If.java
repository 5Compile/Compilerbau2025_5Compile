package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_If {

    public static TypedProgram get() {

        // Methode mit If-Statements
        TypedMethodDecl method = new TypedMethodDecl(
                "testIf",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of(
                        // Variablen deklarieren
                        new TypedLocalVarDecl("x", Type.INT),
                        new TypedLocalVarDecl("y", Type.INT),
                        new TypedLocalVarDecl("z", Type.INT),

                        // Initialisierung
                        new TypedAssign(new TypedLocalOrFieldVar("x", Type.INT), new TypedIntLiteral(5)),
                        new TypedAssign(new TypedLocalOrFieldVar("y", Type.INT), new TypedIntLiteral(10)),

                        // if (x < y) { z = 1; } else { z = 2; }
                        new TypedIf(
                                new TypedBinary(
                                        new TypedLocalOrFieldVar("x", Type.INT),
                                        new TypedLocalOrFieldVar("y", Type.INT),
                                        TypedBinaryOperator.LT,
                                        Type.BOOL
                                ),
                                new TypedBlock(List.of(
                                        new TypedAssign(new TypedLocalOrFieldVar("z", Type.INT), new TypedIntLiteral(1))
                                )),
                                Optional.of(new TypedBlock(List.of(
                                        new TypedAssign(new TypedLocalOrFieldVar("z", Type.INT), new TypedIntLiteral(2))
                                )))
                        ),

                        // if (true) { x = 20; }
                        new TypedIf(
                                new TypedBoolLiteral(true),
                                new TypedBlock(List.of(
                                        new TypedAssign(new TypedLocalOrFieldVar("x", Type.INT), new TypedIntLiteral(20))
                                )),
                                Optional.empty()
                        ),

                        // Verschachteltes if: if (x > 15) { if (y < 20) { z = 3; } }
                        new TypedIf(
                                new TypedBinary(
                                        new TypedLocalOrFieldVar("x", Type.INT),
                                        new TypedIntLiteral(15),
                                        TypedBinaryOperator.GT,
                                        Type.BOOL
                                ),
                                new TypedBlock(List.of(
                                        new TypedIf(
                                                new TypedBinary(
                                                        new TypedLocalOrFieldVar("y", Type.INT),
                                                        new TypedIntLiteral(20),
                                                        TypedBinaryOperator.LT,
                                                        Type.BOOL
                                                ),
                                                new TypedBlock(List.of(
                                                        new TypedAssign(new TypedLocalOrFieldVar("z", Type.INT), new TypedIntLiteral(3))
                                                )),
                                                Optional.empty()
                                        )
                                )),
                                Optional.empty()
                        )
                )),
                Type.VOID
        );

        // Konstruktor
        TypedMethodDecl constructor = new TypedMethodDecl(
                "If",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of()),
                Type.VOID
        );

        // Klasse If
        TypedClassDecl clazz = new TypedClassDecl(
                "If",
                List.of(),
                List.of(method, constructor),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
