package AST;

public sealed interface StatementExpression permits Assignment, New, MethodCall {}