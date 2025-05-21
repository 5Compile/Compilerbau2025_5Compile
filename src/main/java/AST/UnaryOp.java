package AST;

public record UnaryOp(Expression var, UnaryOp op) implements Expression{
}
