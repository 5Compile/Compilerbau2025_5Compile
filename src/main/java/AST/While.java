package AST;

import codegen.MethodContext;

public record While(Expression condition, Block body) implements Statement {

    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement while loop
        if (condition != null) {
            condition.codeGen(methodContext);
        }
        if (body != null) {
            body.codeGen(methodContext);
        }
    }
}