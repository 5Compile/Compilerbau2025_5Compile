package compiler.ast;

public record While(Expression condition, Block body) implements Statement {
}
