package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedAssign implements TypedStatement, TypedExpression {
    TypedExpression target;
    TypedExpression value;
    Type type;

    TypedAssign(TypedExpression target, TypedExpression value, Type type){
        this.target = target;
        this.value = value;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
