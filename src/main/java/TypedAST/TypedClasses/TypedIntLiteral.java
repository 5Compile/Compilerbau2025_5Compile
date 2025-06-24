package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedIntLiteral implements TypedExpression {
    int value;
    Type type;

    TypedIntLiteral(int value, Type type){
        this.value = value;
        this.type = type;
    }
}
