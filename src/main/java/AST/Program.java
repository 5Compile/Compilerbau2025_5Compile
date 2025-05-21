package AST;

import java.util.List;

public record Program(List<Class> classes) implements MiniJava{}