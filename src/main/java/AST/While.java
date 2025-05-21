package AST;

public record While(Expression condition, Block block) implements Statement{
}
