package AST;

import codegen.MethodContext;

public record CharLiteral(char value) implements Expression {
    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement CharLiteral
    }
}