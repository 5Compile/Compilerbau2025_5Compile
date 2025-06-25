package TypedAST.TypedClasses;

import AST.BinaryOperator;
import AST.Expression;
import TypedAST.Type;

public class TypedBinary implements TypedExpression {
    TypedExpression left;
    TypedExpression right;
    BinaryOperator operator;
    Type type;

    TypedBinary(TypedExpression left, TypedExpression right, BinaryOperator operator, Type type){
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
