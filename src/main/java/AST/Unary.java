package AST;

import TypedAST.TypedClasses.Visitor;

public record Unary(Expression operand, UnaryOperator operator) implements Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
