package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;
import TypedAST.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_MethodReturn {

    public static TypedProgram get() {
        TypedClassDecl clazz = new TypedClassDecl(
                "MethodReturn",
                List.of(),
                List.of(
                        new TypedMethodDecl(
                                "returnInt",
                                Type.INT,
                                List.of(),
                                new TypedBlock(List.of(
                                        new TypedReturn(new TypedIntLiteral(10), Type.INT)
                                )),
                                Type.INT
                        ),
                        new TypedMethodDecl(
                                "returnVoid",
                                Type.VOID,
                                List.of(),
                                new TypedBlock(List.of(
                                        new TypedReturn(null, Type.VOID) // <- wichtig!
                                )),
                                Type.VOID
                        ),
                        new TypedMethodDecl(
                                "returnBool",
                                Type.BOOL,
                                List.of(),
                                new TypedBlock(List.of(
                                        new TypedReturn(new TypedBoolLiteral(true), Type.BOOL)
                                )),
                                Type.BOOL
                        ),
                        new TypedMethodDecl(
                                "returnChar",
                                Type.CHAR,
                                List.of(),
                                new TypedBlock(List.of(
                                        new TypedReturn(new TypedCharLiteral('a'), Type.CHAR)
                                )),
                                Type.CHAR
                        ),
                        new TypedMethodDecl(
                                "returnMethod",
                                Type.CLASS,
                                List.of(),
                                new TypedBlock(List.of(
                                        new TypedReturn(new TypedNew("MethodReturn", List.of(), Type.CLASS), Type.CLASS)
                                )),
                                Type.CLASS
                        )
                ),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
