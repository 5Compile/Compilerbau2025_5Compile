package AST;

import TypedAST.TypedClasses.TypedBlock;
import TypedAST.TypedClasses.TypedMethodDecl;
import TypedAST.TypedClasses.TypedMiniJava;
import TypedAST.TypedClasses.Visitor;

import java.util.List;

public record Block(List<Statement> statements) implements MiniJava {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
