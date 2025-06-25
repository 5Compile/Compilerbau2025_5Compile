package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedWhile implements TypedStatement {
    TypedExpression condition;
    TypedBlock body;
    Type type;

    TypedWhile(TypedExpression condition, TypedBlock body, Type type){
        this.condition = condition;
        this.body = body;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
