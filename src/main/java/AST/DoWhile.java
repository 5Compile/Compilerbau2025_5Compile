package AST;

public record DoWhile(Expression cond, Block block) implements Statement{
}
