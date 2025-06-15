package AST;

import TypedAST.TypedClasses.Visitor;

public record Return(Expression value) implements Statement {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
