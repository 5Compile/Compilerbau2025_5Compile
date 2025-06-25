package AST;

import TypedAST.TypedClasses.Visitor;

public record While(Expression condition, Block body) implements Statement {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
