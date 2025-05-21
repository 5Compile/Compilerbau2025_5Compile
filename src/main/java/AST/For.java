package AST;

public record For(Assignment var, Expression cond, Assignment increment, Block block) implements Statement{
}
