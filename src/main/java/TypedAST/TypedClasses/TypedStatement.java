package TypedAST.TypedClasses;

import TypedAST.Type;

public interface TypedStatement extends TypedMiniJava {
    Type type = null;

    public Type getType();
}
