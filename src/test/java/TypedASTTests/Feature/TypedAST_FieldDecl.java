package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_FieldDecl {

    public static TypedProgram get() {

        // Feld 1: int a;
        TypedFieldDecl fieldA = new TypedFieldDecl("a", Type.INT);

        // Feld 2: char c;
        TypedFieldDecl fieldC = new TypedFieldDecl("c", Type.CHAR);

        // Methode: void fieldAccess() {
        //   this.c = 'c';
        //   this.a = 1;
        // }
        TypedMethodDecl method = new TypedMethodDecl(
                "fieldAccess",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of(
                        new TypedAssign(new TypedLocalOrFieldVar("c", Type.CHAR), new TypedCharLiteral('c')),
                        new TypedAssign(new TypedLocalOrFieldVar("a", Type.INT), new TypedIntLiteral(1))
                )),
                Type.VOID
        );

        // Konstruktor (automatisch generiert)
        TypedMethodDecl constructor = new TypedMethodDecl(
                "FieldDecl",
                Type.VOID,
                List.of(),
                new TypedBlock(List.of()),
                Type.VOID
        );

        // Klasse
        TypedClassDecl clazz = new TypedClassDecl(
                "FieldDecl",
                List.of(fieldA, fieldC),
                List.of(method, constructor),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
