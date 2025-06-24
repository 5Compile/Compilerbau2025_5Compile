package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedCharLiteral implements TypedExpression {
    char value;
    Type type;

    TypedCharLiteral(char value, Type type){
        this.value = value;
        this.type = type;
    }
}
