package ASTTests.Feature;

import AST.*;
import TypedAST.Type;  // Add this import

import java.util.List;
import java.util.Optional;

public class AST_CompAssign {

    public static Program get() {

        /* ────────────── increase(int a) ────────────── */
        MethodDecl increase = new MethodDecl(
                "int",                        // Rückgabetyp
                "increase",
                List.of( new Parameter(Type.INT.toString(), "a") ),
                new Block(List.of(
                        /* a = a + 1;   (compound  +=  aufgelöst) */
                        new Assign(
                                new LocalOrFieldVar("a"),
                                new Binary(
                                        new LocalOrFieldVar("a"),       // left (Expression)
                                        new IntLiteral(1),             // right (Expression)
                                        BinaryOperator.PLUS           // operator
                                )

                        ),
                        /* return a; */
                        new Return(
                                new LocalOrFieldVar("a")
                        )
                ))
        );

        /* ────────────── decrease(int a) ────────────── */
        MethodDecl decrease = new MethodDecl(
                "int",
                "decrease",
                List.of( new Parameter(Type.INT.toString(), "a") ),
                new Block(List.of(
                        /* a = a - 1;   (compound  -=  aufgelöst) */
                        new Assign(
                                new LocalOrFieldVar("a"),
                                new Binary(
                                        new LocalOrFieldVar("a"),
                                        new IntLiteral(1),
                                        BinaryOperator.MINUS     // a - 1
                                )
                        ),
                        /* return a; */
                        new Return(
                                new LocalOrFieldVar("a")
                        )
                ))
        );

        /* ────────────── Klasse zusammensetzen ────────────── */
        ClassDecl clazz = new ClassDecl(
                "CompAssign",
                List.of(),                         // keine Felder
                List.of(increase, decrease),       // beide Methoden
                Optional.empty()                   // keine main-Methode
        );

        /* ────────────── Program-Root ────────────── */
        return new Program(List.of(clazz));
    }
}
