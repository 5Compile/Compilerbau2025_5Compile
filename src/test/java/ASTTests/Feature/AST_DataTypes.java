package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_DataTypes {

    public static Program get() {

        // Methode 1: int integer(int a) { a = 1; return a; }
        MethodDecl integerMethod = new MethodDecl(
                "integer",
                "int",
                List.of(new Parameter("int", "a")),
                new Block(List.of(
                        new Assign(new LocalOrFieldVar("a"), new IntLiteral(1)),
                        new Return(new LocalOrFieldVar("a"))
                ))
        );

        // Methode 2: boolean bool(boolean b) { b = true; return b; }
        MethodDecl boolMethod = new MethodDecl(
                "bool",
                "boolean",
                List.of(new Parameter("boolean", "b")),
                new Block(List.of(
                        new Assign(new LocalOrFieldVar("b"), new BoolLiteral(true)),
                        new Return(new LocalOrFieldVar("b"))
                ))
        );

        // Methode 3: char character(char c) { c = 'c'; return c; }
        MethodDecl charMethod = new MethodDecl(
                "character",
                "char",
                List.of(new Parameter("char", "c")),
                new Block(List.of(
                        new Assign(new LocalOrFieldVar("c"), new CharLiteral('c')),
                        new Return(new LocalOrFieldVar("c"))
                ))
        );

        // Konstruktor (automatisch generiert von ASTGenerator)
        MethodDecl constructor = new MethodDecl(
                "DataTypes",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Klasse
        ClassDecl clazz = new ClassDecl(
                "DataTypes",
                List.of(), // keine Felder
                List.of(integerMethod, boolMethod, charMethod, constructor),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}
