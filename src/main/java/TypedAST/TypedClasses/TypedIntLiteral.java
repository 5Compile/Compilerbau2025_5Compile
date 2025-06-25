package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedIntLiteral implements TypedExpression {
    int value;
    Type type = Type.INT;

    TypedIntLiteral(int value){
        this.value = value;
    }

    @Override
    public Type getType() {
        return type;
    }
}
