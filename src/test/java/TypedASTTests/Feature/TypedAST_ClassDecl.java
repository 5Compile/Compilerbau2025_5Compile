package TypedASTTests.Feature;

import TypedAST.TypedClasses.TypedBlock;
import TypedAST.TypedClasses.TypedClassDecl;
import TypedAST.TypedClasses.TypedMainMethodDecl;
import TypedAST.TypedClasses.TypedProgram;

import java.util.List;
import java.util.Optional;

public class TypedAST_ClassDecl {
    public static TypedProgram get() {
        return new TypedProgram(
                List.of(
                        new TypedClassDecl(
                                "ClassDecl",
                                List.of(), // leere Felder
                                List.of(), // leere Methoden
                                Optional.of(
                                        new TypedMainMethodDecl(
                                                new TypedBlock(
                                                        List.of() // leere Statements
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
