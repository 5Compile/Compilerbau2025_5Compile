package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedLocalOrFieldVar implements TypedExpression {
    String name;
    boolean isLocal;
    Type type;

    TypedLocalOrFieldVar(String name, boolean isLocal, Type type){
        this.name = name;
        this.isLocal = isLocal;
        this.type = type;
    }
}
