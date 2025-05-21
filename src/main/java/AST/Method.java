package AST;

import java.lang.reflect.Type;
import java.util.List;

public record Method(Type type, String name, List<Parameter> params, Block block) implements MiniJava{
}
