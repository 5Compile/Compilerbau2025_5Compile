package AST;

import codegen.MethodContext;

public record NullLiteral() implements Expression {
    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement NullLiteral
    }
}