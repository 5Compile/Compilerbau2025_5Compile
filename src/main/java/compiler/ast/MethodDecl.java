package compiler.ast;

import java.util.List;

public record MethodDecl(String name,
                         String returnType,
                         List<Parameter> parameters,
                         Block body) implements MiniJava {
}
