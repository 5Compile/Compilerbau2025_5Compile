package AST;

public record Assign(Expression target, Expression value) implements Statement, Expression {
}
