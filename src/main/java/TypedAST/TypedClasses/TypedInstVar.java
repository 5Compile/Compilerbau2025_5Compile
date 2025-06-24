package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedInstVar implements TypedExpression {
    TypedExpression target;
    String fieldName;
    Type type;

    TypedInstVar(TypedExpression target, String fieldName, Type type){
        this.target = target;
        this.fieldName = fieldName;
        this.type = type;
    }
}
