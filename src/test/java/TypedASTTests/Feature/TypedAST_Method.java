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
                                "Method",
                                List.of(),
                                List.of(
                                        new TypedMethodDecl(
                                                "void",
                                                "method",
                                                List.of(),
                                                new Block(List.of()),
                                                Type.VOID
                                        )
                                ),
                                Optional.empty(),
                                Type.REFERENCE("Method")
                        )
                ),
                null
        );
    }
}
