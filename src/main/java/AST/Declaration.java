package AST;

import java.lang.reflect.Type;

public record Declaration(Type type, String name) implements Statement{
}
