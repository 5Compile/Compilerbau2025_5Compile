package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedNullLiteral implements TypedExpression {
    Type type = Type.VOID;

    TypedNullLiteral(){

    }

    @Override
    public Type getType() {
        return type;
    }
}
