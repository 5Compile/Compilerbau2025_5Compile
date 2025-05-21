package AST;

import java.util.List;

public record Program(List<ClassDecl> classes) implements MiniJava {
}
