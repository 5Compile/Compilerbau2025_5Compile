package AST;

import TypedAST.TypedClasses.Visitor;

public record Assign(Expression target, Expression value) implements Statement, Expression {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
