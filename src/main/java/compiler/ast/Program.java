package compiler.ast;

import java.util.List;

public record Program(List<ClassDecl> classes) implements MiniJava {
    @Override
    public String toString() {
        return classes().toString();
    }
}

