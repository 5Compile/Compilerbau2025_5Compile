package AST;

import TypedAST.TypedClasses.Visitor;

import java.util.Optional;

public record If(Expression condition, Block thenBranch, Optional<Block> elseBranch) implements Statement {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
