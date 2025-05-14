package AST;

public record Assignment(Expression target, Expression value) implements StatementExpression {}
