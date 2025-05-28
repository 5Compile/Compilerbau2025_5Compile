package compiler.ast;

public record Unary(Expression operand, UnaryOperator operator) implements Expression {
}
