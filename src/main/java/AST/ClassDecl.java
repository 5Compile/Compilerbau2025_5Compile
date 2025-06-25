package AST;

import TypedAST.TypedClasses.Visitor;

import java.util.List;
import java.util.Optional;

public record ClassDecl(String name,
                        List<FieldDecl> fields,
                        List<MethodDecl> methods,
                        Optional<MainMethodDecl> mainMethod) implements MiniJava {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
