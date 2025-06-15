package AST;

import TypedAST.TypedClasses.Visitor;

public record InstVar(Expression target, String fieldName) implements Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
