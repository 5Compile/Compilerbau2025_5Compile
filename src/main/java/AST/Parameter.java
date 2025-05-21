package AST;

import java.lang.reflect.Type;

public record Parameter(Type type, String name) implements MiniJava{
}
