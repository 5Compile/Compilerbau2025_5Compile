package AST;

import TypedAST.TypedClasses.Visitor;

public record Parameter(String type, String name) implements MiniJava {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
