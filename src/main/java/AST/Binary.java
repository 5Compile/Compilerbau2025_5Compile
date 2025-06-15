package AST;

import TypedAST.TypedClasses.Visitor;

public record Binary(Expression left, Expression right, BinaryOperator operator) implements Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
