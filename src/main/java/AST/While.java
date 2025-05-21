package AST;

public record While(Expression condition, Block body) implements Statement {
}
