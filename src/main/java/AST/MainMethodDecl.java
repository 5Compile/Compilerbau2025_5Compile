package AST;

import TypedAST.TypedClasses.Visitor;

public record MainMethodDecl(Block body) implements MiniJava {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
