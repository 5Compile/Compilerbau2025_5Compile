package TypedASTTests.Feature;

import AST.*;
import TypedAST.*;
import com.sun.jdi.ClassType;

import java.util.List;
import java.util.Optional;

public class TypedAST_FullFeature {
    public static Program get() {
        return new Program(List.of(
                new ClassDecl(
                        "FullFeature",

                        // Fields
                        List.of(
                                new FieldDecl(Type.INT.toString(), "x"),
                                new FieldDecl(Type.BOOL.toString(), "flag"),
                                new FieldDecl(Type.CHAR.toString(), "symbol")
                        ),

                        // Methods
                        List.of(
                                // Constructor
                                new MethodDecl(
                                        "FullFeature",
                                        Type.VOID,
                                        List.of(),
                                        new Block(List.of(
                                                new Assign(
                                                        new LocalOrFieldVar("x", Type.INT),
                                                        new IntLiteral(10)
                                                ),
                                                new Assign(
                                                        new LocalOrFieldVar("flag", Type.BOOL),
                                                        new BoolLiteral(true)
                                                )
                                        ))
                                ),

                                // doStuff(int a, boolean b)
                                new MethodDecl(
                                        "doStuff",
                                        Type.VOID,
                                        List.of(
                                                new Parameter(Type.INT.toString(), "a"),
                                                new Parameter(Type.BOOL.toString(), "b")
                                        ),
                                        new Block(List.of(
                                                new LocalVarDecl(Type.INT.toString(), "result"),
                                                new Assign(
                                                        new LocalOrFieldVar("result"),
                                                        new Binary(
                                                                new LocalOrFieldVar("a"),
                                                                new Binary(
                                                                        new IntLiteral(5),
                                                                        new Binary(
                                                                                new LocalOrFieldVar("x"),
                                                                                new IntLiteral(2),
                                                                                BinaryOperator.MINUS
                                                                        ),
                                                                        BinaryOperator.TIMES
                                                                ),
                                                                BinaryOperator.PLUS
                                                        )
                                                ),
                                                new If(
                                                        new Binary(
                                                                new LocalOrFieldVar("b"),
                                                                new LocalOrFieldVar("flag"),
                                                                BinaryOperator.AND
                                                        ),
                                                        new Block(List.of(
                                                                new PrintStmt(
                                                                        new LocalOrFieldVar("result")
                                                                )
                                                        )),
                                                        Optional.of(new Block(List.of(
                                                                new PrintStmt(
                                                                        new IntLiteral(0)
                                                                )
                                                        )))
                                                )
                                        ))
                                ),

                                // anotherMethod()
                                new MethodDecl(
                                        "anotherMethod",
                                        Type.VOID,
                                        List.of(),
                                        new Block(List.of(
                                                new LocalVarDecl(new ClassType("FullFeature"), "f"),
                                                new Assign(
                                                        new LocalOrFieldVar("f", new ClassType("FullFeature")),
                                                        new New("FullFeature", List.of())
                                                ),
                                                new MethodCall(
                                                        new LocalOrFieldVar("f", new ClassType("FullFeature")),
                                                        "doStuff",
                                                        List.of(
                                                                new IntLiteral(7),
                                                                new BoolLiteral(false)
                                                        )
                                                )
                                        ))
                                )
                        ),

                        // Main
                        Optional.of(
                                new MainMethodDecl(
                                        new Block(List.of(
                                                new LocalVarDecl(new ClassType("FullFeature"), "obj"),
                                                new Assign(
                                                        new LocalOrFieldVar("obj", new ClassType("FullFeature")),
                                                        new New("FullFeature", List.of())
                                                ),
                                                new MethodCall(
                                                        new LocalOrFieldVar("obj", new ClassType("FullFeature")),
                                                        "doStuff",
                                                        List.of(
                                                                new IntLiteral(3),
                                                                new BoolLiteral(true)
                                                        )
                                                )
                                        ))
                                )
                        )
                )
        ));
    }
}
