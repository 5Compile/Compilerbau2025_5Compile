package TypedAST.TypedClasses;

import AST.BinaryOperator;
import AST.Expression;
import TypedAST.Type;

public class TypedBinary implements TypedExpression {
    AST.Expression left;
    Expression right;
    BinaryOperator operator;
    Type type;
}
