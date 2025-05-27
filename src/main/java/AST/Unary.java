package AST;

import codegen.MethodContext;

public record Unary(Expression operand, UnaryOperator operator) implements Expression {
    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement Unary
    }
}