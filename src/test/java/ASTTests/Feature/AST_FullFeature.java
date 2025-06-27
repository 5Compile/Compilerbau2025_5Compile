package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_FullFeature {
    public static Program get() {
        return new Program(List.of(
                new ClassDecl(
                        "FullFeature",

                        // Fields
                        List.of(
                                new FieldDecl("int", "x"),
                                new FieldDecl("boolean", "flag"),
                                new FieldDecl("char", "symbol")
                        ),

                        // Methods
                        List.of(
                                // Constructor
                                new MethodDecl(
                                        "FullFeature",
                                        "void",
                                        List.of(),
                                        new Block(List.of(
                                                new Assign(
                                                        new LocalOrFieldVar("x"),
                                                        new IntLiteral(10)
                                                ),
                                                new Assign(
                                                        new LocalOrFieldVar("flag"),
                                                        new BoolLiteral(true)
                                                )
                                        ))
                                ),

                                // doStuff(int a, boolean b)
                                new MethodDecl(
                                        "doStuff",
                                        "void",
                                        List.of(
                                                new Parameter("int", "a"),
                                                new Parameter("boolean", "b")
                                        ),
                                        new Block(List.of(
                                                new LocalVarDecl("int", "result"),
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
                                        "void",
                                        List.of(),
                                        new Block(List.of(
                                                new LocalVarDecl("FullFeature", "f"),
                                                new Assign(
                                                        new LocalOrFieldVar("f"),
                                                        new New("FullFeature", List.of())
                                                ),
                                                new MethodCall(
                                                        new LocalOrFieldVar("f"),
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
                                                new LocalVarDecl("FullFeature", "obj"),
                                                new Assign(
                                                        new LocalOrFieldVar("obj"),
                                                        new New("FullFeature", List.of())
                                                ),
                                                new MethodCall(
                                                        new LocalOrFieldVar("obj"),
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
