package AST;

import TypedAST.TypedClasses.Visitor;

import java.util.List;

public record Program(List<ClassDecl> classes) implements MiniJava {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
