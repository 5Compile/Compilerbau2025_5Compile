package AST;

public record FieldOrLocalVarAcc(Boolean isField, Expression recursiveOwnerChain, String name) implements Expression {
}
