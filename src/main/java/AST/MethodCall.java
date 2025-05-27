package AST;

import codegen.MethodContext;
import java.util.List;

public record MethodCall(Expression target, String methodName,
                         List<Expression> arguments) implements Statement, Expression {

    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement method call
        if (target != null) {
            target.codeGen(methodContext);
        }
        for (Expression arg : arguments) {
            arg.codeGen(methodContext);
        }
    }
}