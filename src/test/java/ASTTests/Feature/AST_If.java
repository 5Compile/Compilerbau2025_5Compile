package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_If {

    public static Program get() {
        // if (false) {} else {}

        Statement ifStatement = new If(
                new BoolLiteral(false),
                new Block(List.of()),
                Optional.of(new Block(List.of())) // einfache else-Branch ohne nested if
        );

        // Methode IfTest
        MethodDecl ifTest = new MethodDecl(
                "IfTest",
                "void",
                List.of(),
                new Block(List.of(ifStatement))
        );

        // Leerer Konstruktor
        MethodDecl constructor = new MethodDecl(
                "If",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Klasse If
        ClassDecl clazz = new ClassDecl(
                "If",
                List.of(),
                List.of(ifTest, constructor),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}
