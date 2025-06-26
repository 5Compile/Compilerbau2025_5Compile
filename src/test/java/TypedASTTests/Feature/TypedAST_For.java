package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_For {

    public static TypedProgram get() {

        // Methode ForTest mit drei Schleifen
        TypedMethodDecl method = new TypedMethodDecl(
                "ForTest",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of(
                        // for (int i = 0; i < 10; i = i + 1)
                        new TypedLocalVarDecl("i", Type.INT),
                        new TypedAssign(new TypedLocalOrFieldVar("i", Type.INT), new TypedIntLiteral(0)),
                        new TypedWhile(
                                new TypedBinary(new TypedLocalOrFieldVar("i", Type.INT), new TypedIntLiteral(10), TypedBinaryOperator.LT, Type.BOOL),
                                new TypedBlock(List.of(
                                        new TypedAssign(
                                                new TypedLocalOrFieldVar("i", Type.INT),
                                                new TypedBinary(new TypedLocalOrFieldVar("i", Type.INT), new TypedIntLiteral(1), TypedBinaryOperator.PLUS, Type.INT)
                                        )
                                ))
                        ),

                        // for (int j = 0; j < 10; j += 1)
                        new TypedLocalVarDecl("j", Type.INT),
                        new TypedAssign(new TypedLocalOrFieldVar("j", Type.INT), new TypedIntLiteral(0)),
                        new TypedWhile(
                                new TypedBinary(new TypedLocalOrFieldVar("j", Type.INT), new TypedIntLiteral(10), TypedBinaryOperator.LT, Type.BOOL),
                                new TypedBlock(List.of(
                                        new TypedAssign(
                                                new TypedLocalOrFieldVar("j", Type.INT),
                                                new TypedBinary(new TypedLocalOrFieldVar("j", Type.INT), new TypedIntLiteral(1), TypedBinaryOperator.PLUS, Type.INT)
                                        )
                                ))
                        ),

                        // for (int k = 0; k < 10; k++)
                        new TypedLocalVarDecl("k", Type.INT),
                        new TypedAssign(new TypedLocalOrFieldVar("k", Type.INT), new TypedIntLiteral(0)),
                        new TypedWhile(
                                new TypedBinary(new TypedLocalOrFieldVar("k", Type.INT), new TypedIntLiteral(10), TypedBinaryOperator.LT, Type.BOOL),
                                new TypedBlock(List.of(
                                        new TypedAssign(
                                                new TypedLocalOrFieldVar("k", Type.INT),
                                                new TypedBinary(new TypedLocalOrFieldVar("k", Type.INT), new TypedIntLiteral(1), TypedBinaryOperator.PLUS, Type.INT)
                                        )
                                ))
                        )
                )),
                Type.VOID
        );

        // Konstruktor
        TypedMethodDecl constructor = new TypedMethodDecl(
                "For",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of()),
                Type.VOID
        );

        // Klasse For
        TypedClassDecl clazz = new TypedClassDecl(
                "For",
                List.of(),
                List.of(method, constructor),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
