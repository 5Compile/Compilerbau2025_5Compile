package compiler.ast;

public record Binary(Expression left, Expression right, BinaryOperator operator) implements Expression {
}
