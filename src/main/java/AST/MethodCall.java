package AST;

import java.util.List;

public record MethodCall(FieldOrLocalVarAcc target, String name, List<Expression> args) implements StatementExpression, Expression {}
