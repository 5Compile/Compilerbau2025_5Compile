package AST;

public record DoWhile(Block block, Expression condition) implements Statement {
}
