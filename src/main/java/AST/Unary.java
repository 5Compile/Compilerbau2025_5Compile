package AST;

public record Unary(Expression operand, UnaryOperator operator) implements Expression {
}
