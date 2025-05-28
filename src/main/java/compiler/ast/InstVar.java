package compiler.ast;

public record InstVar(Expression target, String fieldName) implements Expression {
}
