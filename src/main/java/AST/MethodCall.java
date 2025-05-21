package AST;

import java.util.List;

public record MethodCall(Expression target, String methodName,
                         List<Expression> arguments) implements Statement, Expression {
}
