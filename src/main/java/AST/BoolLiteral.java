package AST;

import TypedAST.TypedClasses.Visitor;

public record BoolLiteral(boolean value) implements Expression {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
