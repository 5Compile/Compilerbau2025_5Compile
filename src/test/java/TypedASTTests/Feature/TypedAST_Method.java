package TypedASTTests.Feature;

import AST.Block;
import AST.ClassDecl;
import AST.MethodDecl;
import TypedAST.Type;
import TypedAST.TypedClasses.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_Method {
    public static TypedProgram get() {
        return new TypedProgram(
                List.of(
                        new TypedClassDecl(
                                "Method",              // Klassenname
                                List.of(),            // keine Felder
                                List.of(
                                        new TypedMethodDecl(
                                                new MethodDecl(
                                                        "void",
                                                        "method",
                                                        List.of(),
                                                        new Block(List.of())
                                                )
                                        )
                                )
                                ,
                                Optional.empty(),     // keine Main-Methode
                                Type.REFERENCE("Method") // eigener Klassentyp
                        )
                ),
                null // z.B. globale Funktionen, falls du die verwendest
        );
    }
}
