package AST;

import codegen.MethodContext;

public record Binary(Expression left, Expression right, BinaryOperator operator) implements Expression {
    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement Binary
    }
}