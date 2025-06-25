package AST;

public record LocalOrFieldVar(Boolean field, Expression recursiveOwnerChain, String name) implements Expression {
}
