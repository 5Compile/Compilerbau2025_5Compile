package ASTTests.Feature;

import AST.*;
import TypedAST.Type;

import java.util.List;
import java.util.Optional;

public class AST_DataTypes {
    public static Program get() {
        return new Program(List.of(
            new ClassDecl(
                "DataTypes",
                List.of(), // keine Felder
                List.of(
                    // public int integer(int a) { a = 1; return a; }
                    new MethodDecl(
                        Type.INT.toString(),
                        "integer",
                        List.of(new Parameter(Type.INT.toString(), "a")),
                        new Block(List.of(
                            new Assign(new CharLiteral('a'), new IntLiteral(1)),
                            new Return(new LocalOrFieldVar("a"))
                        ))
                    ),
                    // public boolean bool(boolean b) { b = true; return b; }
                    new MethodDecl(
                        Type.BOOL.toString(),
                        "bool",
                        List.of(new Parameter(Type.BOOL.toString(), "b")),
                        new Block(List.of(
                            new Assign(new CharLiteral('b'), new BoolLiteral(true)),
                            new Return(new LocalOrFieldVar("b"))
                        ))
                    ),
                    // public char character(char c) { c = 'c'; return c; }
                    new MethodDecl(
                        Type.CHAR.toString(),
                        "character",
                        List.of(new Parameter(Type.CHAR.toString(), "c")),
                        new Block(List.of(
                            new Assign(new CharLiteral('c'), new CharLiteral('c')),
                            new Return(new LocalOrFieldVar("c"))
                        ))
                    )
                ),
                Optional.empty() // keine main-Methode
            )
        ));
    }
}
