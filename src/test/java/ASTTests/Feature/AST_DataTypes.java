package ASTTests.Feature;

import AST.*;

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
                        Type.INT,
                        "integer",
                        List.of(new Param(Type.INT, "a")),
                        new Block(List.of(
                            new Assign("a", new IntExpr(1)),
                            new Return(new VarExpr("a"))
                        ))
                    ),
                    // public boolean bool(boolean b) { b = true; return b; }
                    new MethodDecl(
                        Type.BOOL,
                        "bool",
                        List.of(new Param(Type.BOOL, "b")),
                        new Block(List.of(
                            new Assign("b", new BoolExpr(true)),
                            new Return(new VarExpr("b"))
                        ))
                    ),
                    // public char character(char c) { c = 'c'; return c; }
                    new MethodDecl(
                        Type.CHAR,
                        "character",
                        List.of(new Param(Type.CHAR, "c")),
                        new Block(List.of(
                            new Assign("c", new CharExpr('c')),
                            new Return(new VarExpr("c"))
                        ))
                    )
                ),
                Optional.empty() // keine main-Methode
            )
        ));
    }
}
