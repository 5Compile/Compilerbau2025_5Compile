package AST;

public record Assignment(FieldOrLocalVarAcc target, Expression value) implements StatementExpression {}
