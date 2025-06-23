package AST;

import TypedAST.TypedClasses.Visitor;

import java.util.List;

public record MethodDecl(String name,
                         String returnType,
                         List<Parameter> parameters,
                         Block body) implements MiniJava {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
