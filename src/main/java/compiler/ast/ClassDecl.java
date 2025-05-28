package compiler.ast;

import java.util.List;

public record ClassDecl(String name,
                        List<FieldDecl> fields,
                        List<MethodDecl> methods
) implements MiniJava {
    @Override
    public String toString() {
        return "class " + name() + " { }";
    }
}

