package AST;

import TypedAST.TypedClasses.Visitor;

public record PrintStmt(Expression expression) implements Statement {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
