package AST;

import codegen.MethodContext;

public record PrintStmt(Expression expression) implements Statement {

    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement print statement
        if (expression != null) {
            expression.codeGen(methodContext);
        }
    }
}