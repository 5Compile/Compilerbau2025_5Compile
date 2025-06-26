package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_MethodReturn {

    public static Program get() {
        ClassDecl clazz = new ClassDecl(
                "MethodReturn",
                List.of(),
                List.of(
                        new MethodDecl(
                                "returnInt",
                                "int",
                                List.of(),
                                new Block(List.of(
                                        new Return(new IntLiteral(10))
                                ))
                        ),
                        new MethodDecl(
                                "returnVoid",
                                "void",
                                List.of(),
                                new Block(List.of(
                                        new Return(null) // <- wichtig!
                                ))
                        ),
                        new MethodDecl(
                                "returnBool",
                                "boolean",
                                List.of(),
                                new Block(List.of(
                                        new Return(new BoolLiteral(true))
                                ))
                        ),
                        new MethodDecl(
                                "returnChar",
                                "char",
                                List.of(),
                                new Block(List.of(
                                        new Return(new CharLiteral('a'))
                                ))
                        ),
                        new MethodDecl(
                                "returnMethod",
                                "MethodReturn",
                                List.of(),
                                new Block(List.of(
                                        new Return(new New("MethodReturn", List.of()))
                                ))
                        )
                ),
                Optional.empty()
        );

        return new Program(List.of(clazz));
    }
}
