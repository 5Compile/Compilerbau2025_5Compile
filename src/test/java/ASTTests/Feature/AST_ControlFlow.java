package ASTTests.Feature;

import AST.*;
import java.util.List;
import java.util.Optional;

public class AST_ControlFlow {
    public static Program get() {
        return new Program(List.of(
                new ClassDecl(
                        "ControlFlow",

                        // Fields
                        List.of(
                                new FieldDecl("int", "counter")
                        ),

                        // Methods
                        List.of(
                                // Constructor
                                new MethodDecl(
                                        "ControlFlow",
                                        "void",
                                        List.of(),
                                        new Block(List.of(
                                                new Assign(
                                                        new LocalOrFieldVar("counter"),
                                                        new IntLiteral(0)
                                                )
                                        ))
                                ),

                                // loopIt()
                                new MethodDecl(
                                        "loopIt",
                                        "void",
                                        List.of(),
                                        new Block(List.of(
                                                // while (counter < 5)
                                                new While(
                                                        new Binary(
                                                                new LocalOrFieldVar("counter"),
                                                                new IntLiteral(5),
                                                                BinaryOperator.LT
                                                        ),
                                                        new Block(List.of(
                                                                new Assign(
                                                                        new LocalOrFieldVar("counter"),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("counter"),
                                                                                new IntLiteral(1),
                                                                                BinaryOperator.PLUS
                                                                        )
                                                                )
                                                        ))
                                                ),

                                                // if (counter == 5)
                                                new If(
                                                        new Binary(
                                                                new LocalOrFieldVar("counter"),
                                                                new IntLiteral(5),
                                                                BinaryOperator.EQ
                                                        ),
                                                        new Block(List.of(
                                                                new Assign(
                                                                        new LocalOrFieldVar("counter"),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("counter"),
                                                                                new IntLiteral(1),
                                                                                BinaryOperator.PLUS
                                                                        )
                                                                )
                                                        )),
                                                        Optional.of(new Block(List.of(
                                                                new Assign(
                                                                        new LocalOrFieldVar("counter"),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("counter"),
                                                                                new IntLiteral(1),
                                                                                BinaryOperator.MINUS
                                                                        )
                                                                )
                                                        )))
                                                )
                                        ))
                                )
                        ),

                        // Main
                        Optional.of(
                                new MainMethodDecl(
                                        new Block(List.of(
                                                new LocalVarDecl("ControlFlow", "c"),
                                                new Assign(
                                                        new LocalOrFieldVar("c"),
                                                        new New("ControlFlow", List.of())
                                                ),
                                                new MethodCall(
                                                        new LocalOrFieldVar("c"),
                                                        "loopIt",
                                                        List.of()
                                                )
                                        ))
                                )
                        )
                )
        ));
    }
}
