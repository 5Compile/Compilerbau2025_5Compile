package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedNullLiteral implements TypedExpression {
    Type type;

    TypedNullLiteral(Type type){
        this.type = type;
    }
}
