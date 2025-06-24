package TypedAST.TypedClasses;

import AST.Expression;
import AST.UnaryOperator;
import TypedAST.Type;

public class TypedUnary implements TypedExpression {
    TypedExpression operand;
    UnaryOperator operator;
    Type type;

    TypedUnary(TypedExpression operand, UnaryOperator operator, Type type){
        this.operand = operand;
        this.operator = operator;
        this.type = type;
    }
}
