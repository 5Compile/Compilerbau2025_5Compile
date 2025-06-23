package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedInstVar implements TypedExpression {
    Expression target;
    String fieldName;
    Type type;
}
