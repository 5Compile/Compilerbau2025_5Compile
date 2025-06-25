package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedLocalVarDecl implements TypedStatement {
    String name;
    Type type;

    TypedLocalVarDecl(String name, Type type){
        this.name = name;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
