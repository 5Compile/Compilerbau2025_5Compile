package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_FieldDecl {

    public static Program get() {

        // Feld 1: int a;
        FieldDecl fieldA = new FieldDecl("int", "a");

        // Feld 2: char c;
        FieldDecl fieldC = new FieldDecl("char", "c");

        // Methode: void fieldAccess() {
        //   this.c = 'c';
        //   this.a = 1;
        // }
        MethodDecl method = new MethodDecl(
                "fieldAccess",
                "void",
                List.of(),
                new Block(List.of(
                        new Assign(new LocalOrFieldVar("c"), new CharLiteral('c')),
                        new Assign(new LocalOrFieldVar("a"), new IntLiteral(1))
                ))
        );

        // Konstruktor (automatisch generiert)
        MethodDecl constructor = new MethodDecl(
                "FieldDecl",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Klasse
        ClassDecl clazz = new ClassDecl(
                "FieldDecl",
                List.of(fieldA, fieldC),
                List.of(method, constructor),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}
