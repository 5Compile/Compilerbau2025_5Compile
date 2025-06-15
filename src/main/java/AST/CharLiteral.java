package AST;

import TypedAST.TypedClasses.Visitor;

public record CharLiteral(char value) implements Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
