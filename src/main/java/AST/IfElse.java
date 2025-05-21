package AST;

public record IfElse(Expression cond, Block ifBlock, Block elseBlock) implements Statement{
}
