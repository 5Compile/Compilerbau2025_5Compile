package TypedASTTests.Feature;

import AST.*;
import TypedAST.*;
import com.sun.jdi.ClassType;

import java.util.List;
import java.util.Optional;

public class TypedAST_ControlFlow {
    public static Program get() {
        return new Program(List.of(
                new ClassDecl(
                        "ControlFlow",

                        // Fields
                        List.of(
                                new FieldDecl(Type.INT.toString(), "counter")
                        ),

                        // Methods
                        List.of(
                                // Constructor
                                new MethodDecl(
                                        "ControlFlow",
                                        Type.VOID.toString(),
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
                                        Type.VOID.toString(),
                                        List.of(),
                                        new Block(List.of(
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
                        Optional.of(new MainMethodDecl(
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
                        ))
                )
        ));
    }
}
