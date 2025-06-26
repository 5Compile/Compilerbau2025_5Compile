package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_For {

    public static Program get() {

        // Methode ForTest mit drei Schleifen
        MethodDecl method = new MethodDecl(
                "ForTest",
                "void",
                List.of(),
                new Block(List.of(
                        // for (int i = 0; i < 10; i = i + 1)
                        new LocalVarDecl("int", "i"),
                        new Assign(new LocalOrFieldVar("i"), new IntLiteral(0)),
                        new While(
                                new Binary(new LocalOrFieldVar("i"), new IntLiteral(10), BinaryOperator.LT),
                                new Block(List.of(
                                        new Assign(
                                                new LocalOrFieldVar("i"),
                                                new Binary(new LocalOrFieldVar("i"), new IntLiteral(1), BinaryOperator.PLUS)
                                        )
                                ))
                        ),

                        // for (int j = 0; j < 10; j += 1)
                        new LocalVarDecl("int", "j"),
                        new Assign(new LocalOrFieldVar("j"), new IntLiteral(0)),
                        new While(
                                new Binary(new LocalOrFieldVar("j"), new IntLiteral(10), BinaryOperator.LT),
                                new Block(List.of(
                                        new Assign(
                                                new LocalOrFieldVar("j"),
                                                new Binary(new LocalOrFieldVar("j"), new IntLiteral(1), BinaryOperator.PLUS)
                                        )
                                ))
                        ),

                        // for (int k = 0; k < 10; k++)
                        new LocalVarDecl("int", "k"),
                        new Assign(new LocalOrFieldVar("k"), new IntLiteral(0)),
                        new While(
                                new Binary(new LocalOrFieldVar("k"), new IntLiteral(10), BinaryOperator.LT),
                                new Block(List.of(
                                        new Assign(
                                                new LocalOrFieldVar("k"),
                                                new Binary(new LocalOrFieldVar("k"), new IntLiteral(1), BinaryOperator.PLUS)
                                        )
                                ))
                        )
                ))
        );

        // Konstruktor
        MethodDecl constructor = new MethodDecl(
                "For",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Klasse For
        ClassDecl clazz = new ClassDecl(
                "For",
                List.of(),
                List.of(method, constructor),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}
