package java.TypedASTTests;

import AST.Block;
import TypedAST.TypedClasses.TypedBlock;
import TypedAST.TypedClasses.TypedClassDecl;
import TypedAST.TypedClasses.TypedMainMethodDecl;
import TypedAST.Type;
import TypedAST.TypedClasses.TypedProgram;

import java.util.List;
import java.util.Optional;

public class TypedAST_ClassDecl {
    public static TypedProgram get() {
        return new TypedProgram(
                List.of(
                        new TypedClassDecl(
                                "ClassDecl",         // Klassenname
                                List.of(),           // leere Felder
                                List.of(),           // leere Methoden
                                Optional.of(
                                        new TypedBlock(
                                                new Block(
                                                        List.of()
                                                )
                                        )

                                ),
                                Type.REFERENCE("ClassDecl")
                        )
                ),
                null // falls dein TypedProgram noch was 2. braucht (z. B. globale Funktionen)
        );
    }
}
