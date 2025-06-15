package AST;

import TypedAST.TypedClasses.Visitor;

import java.util.List;

public record Block(List<Statement> statements) implements MiniJava {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
