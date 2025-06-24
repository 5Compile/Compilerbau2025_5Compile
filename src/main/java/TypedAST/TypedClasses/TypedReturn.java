package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedReturn implements TypedStatement {
    TypedExpression value;
    Type type;

    TypedReturn(TypedExpression value, Type type){
        this.value = value;
        this.type = type;
    }
}
