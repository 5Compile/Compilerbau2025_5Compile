package TypedASTTests.Feature;

import AST.*;
import TypedAST.Type;
import TypedAST.TypedClasses.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_DataTypes {

    /**
     * public class DataTypes {
     *     public int integer(int a) {
     *         a = 1;
     *         return a;
     *     }
     *     public boolean bool(boolean b) {
     *         b = true;
     *         return b;
     *     }
     *     public char character(char c) {
     *         c = 'c';
     *         return c;
     *     }
     * }
     */
    public static TypedProgram get() {
        return new TypedProgram(
                List.of(
                        new TypedClassDecl(
                                "DataTypes",
                                List.of(), // keine Felder
                                List.of(
                                        new TypedMethodDecl(
                                                Type.INT,
                                                "integer",
                                                List.of(new Parameter(Type.INT.toString(), "a")),
                                                new TypedBlock(
                                                        new Block(List.of(
                                                                new Assign(new LocalOrFieldVar("a"), new IntLiteral(1))
                                                                new Return(new TypedLocalOrFieldVar("a", Type.INT))
                                                        ))
                                                ),
                                                Type.INT
                                        ),
                                        new TypedMethodDecl(
                                                Type.BOOL,
                                                "bool",
                                                List.of(new Parameter(Type.BOOL.toString(), "b")),
                                                new TypedBlock(
                                                        new Block(List.of(
                                                                new Assign("b", new BoolLiteral(true)),
                                                                new Return(new TypedLocalOrFieldVar("b", Type.BOOL))
                                                        ))
                                                ),
                                                Type.BOOL
                                        ),
                                        new TypedMethodDecl(
                                                Type.CHAR,
                                                "character",
                                                List.of(new Parameter(Type.CHAR.toString(), "c")),
                                                new TypedBlock(
                                                        new Block(List.of(
                                                                new Assign("c", new CharLiteral('c')),
                                                                new Return(new TypedLocalOrFieldVar("c", Type.CHAR))
                                                        ))
                                                ),
                                                Type.CHAR
                                        )
                                ),
                                Optional.empty(), // keine main-Methode
                                Type.REFERENCE("DataTypes")
                        )
                )
        );
    }
}
