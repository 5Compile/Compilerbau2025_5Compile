package AST;

import TypedAST.TypedClasses.Visitor;

public record LocalVarDecl(String type, String name) implements Statement {
    @Override
    public <T> T toTyped(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
