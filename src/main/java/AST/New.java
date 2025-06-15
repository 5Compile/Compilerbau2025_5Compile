package AST;

import TypedAST.TypedClasses.Visitor;

import java.util.List;

public record New(String className, List<Expression> arguments) implements Statement, Expression {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
