package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedAssign implements TypedStatement, TypedExpression {
    Expression target;
    Expression value;
    Type type;
}
