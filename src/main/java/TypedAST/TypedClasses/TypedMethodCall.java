package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

import java.util.List;

public class TypedMethodCall implements TypedStatement, TypedExpression {
    Expression target;
    String methodName;
    List<Expression> arguments;
    Type type;
}
