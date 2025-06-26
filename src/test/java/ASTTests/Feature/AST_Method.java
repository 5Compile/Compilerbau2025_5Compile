package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_Method {

    public static Program get() {
        // Deine Methode: void method() {}
        MethodDecl method = new MethodDecl(
                "method",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Automatisch generierter leerer Konstruktor: Method()
        MethodDecl constructor = new MethodDecl(
                "Method",
                "void",
                List.of(),
                new Block(List.of())
        );

        // Klasse Method mit beidem
        ClassDecl clazz = new ClassDecl(
                "Method",
                List.of(),                   // keine Felder
                List.of(method, constructor),// 2 Methoden
                Optional.empty()             // kein main
        );

        return new Program(List.of(clazz));
    }
}
