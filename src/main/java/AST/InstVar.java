package AST;

public record InstVar(Expression target, String fieldName) implements Expression {
}
