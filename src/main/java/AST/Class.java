package AST;

import java.util.List;

public record Class(String name, Method mainMeth, List<Method> classMeths, List<Declaration> classDecs) implements MiniJava{
    public Class(String name, List<Method> classMeths, List<Declaration> classDecs) {
        this(name, null, classMeths, classDecs);
    }
}
