package AST;

import codegen.MethodContext;
import java.util.List;

public record New(String className, List<Expression> arguments) implements Statement, Expression {

    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement object creation
        for (Expression arg : arguments) {
            arg.codeGen(methodContext);
        }
    }
}