package AST;

public record BinaryOp(Expression expL, Operator op, Expression expR) implements Expression{

}
