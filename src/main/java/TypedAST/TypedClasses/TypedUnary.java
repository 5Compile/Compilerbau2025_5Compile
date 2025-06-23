package TypedAST.TypedClasses;

import AST.Expression;
import AST.UnaryOperator;
import TypedAST.Type;

public class TypedUnary implements TypedExpression {
    Expression operand;
    UnaryOperator operator;
    Type type;
}
