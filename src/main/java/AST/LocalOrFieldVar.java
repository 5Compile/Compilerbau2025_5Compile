package AST;

import TypedAST.TypedClasses.Visitor;

public record LocalOrFieldVar(String name) implements Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
