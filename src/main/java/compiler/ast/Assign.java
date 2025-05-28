package compiler.ast;

public record Assign(Expression target, Expression value) implements Statement, Expression {
}
