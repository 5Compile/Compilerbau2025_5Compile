package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedCharLiteral implements TypedExpression {
    char value;
    Type type = Type.CHAR;

    TypedCharLiteral(char value){
        this.value = value;
    }

    @Override
    public Type getType() {
        return type;
    }
}
