package AST;

import java.util.List;

public record Constructor(String className, List<Parameter> params, Block block) implements MiniJava {
}
