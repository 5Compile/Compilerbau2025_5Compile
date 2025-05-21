package AST;

import java.lang.reflect.Type;
import java.util.List;

public record New(Type type, List<Expression> arguments) implements StatementExpression, Expression {}
