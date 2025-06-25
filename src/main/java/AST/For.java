package AST;

public record For(Assign assign, Expression cond, Assign inc, Block block) implements Statement {
}
