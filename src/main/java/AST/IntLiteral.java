package AST;

import TypedAST.TypedClasses.Visitor;

public record IntLiteral(int value) implements Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
