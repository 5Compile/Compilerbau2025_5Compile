package AST;

import TypedAST.TypedClasses.Visitor;

public record CharLiteral(char value) implements Expression {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
