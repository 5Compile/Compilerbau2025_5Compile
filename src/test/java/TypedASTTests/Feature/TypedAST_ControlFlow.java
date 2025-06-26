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
                                        Types.VOID,
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
                                        Type.VOID,
                                        List.of(),
                                        new Block(List.of(
                                                new While(
                                                        new Binary(
                                                                new LocalOrFieldVar("counter"),
                                                                new IntLiteral(5),
                                                                BinaryOperator.LT,
                                                                Type.BOOL
                                                        ),
                                                        new Block(List.of(
                                                                new Assign(
                                                                        new LocalOrFieldVar("counter"),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("counter"),
                                                                                new IntLiteral(1),
                                                                                BinaryOperator.PLUS,
                                                                                Type.INT
                                                                        )
                                                                )
                                                        ))
                                                ),
                                                new If(
                                                        new Binary(
                                                                new LocalOrFieldVar("counter", Types.INT),
                                                                new IntLiteral(5),
                                                                BinaryOperator.EQ,
                                                                Types.BOOL
                                                        ),
                                                        new Block(List.of(
                                                                new Assign(
                                                                        new LocalOrFieldVar("counter", Types.INT),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("counter", Types.INT),
                                                                                new IntLiteral(1),
                                                                                BinaryOperator.PLUS,
                                                                                Types.INT
                                                                        )
                                                                )
                                                        )),
                                                        Optional.of(new Block(List.of(
                                                                new Assign(
                                                                        new LocalOrFieldVar("counter", Types.INT),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("counter", Types.INT),
                                                                                new IntLiteral(1),
                                                                                BinaryOperator.MINUS,
                                                                                Types.INT
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
                                                new LocalOrFieldVar("c", new ClassType("ControlFlow")),
                                                new New("ControlFlow", List.of())
                                        ),
                                        new MethodCall(
                                                new LocalOrFieldVar("c", new ClassType("ControlFlow")),
                                                "loopIt",
                                                List.of()
                                        )
                                ))
                        ))
                )
        ));
    }
}
