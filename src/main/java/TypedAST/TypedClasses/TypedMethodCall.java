package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

import java.util.List;

public class TypedMethodCall implements TypedStatement, TypedExpression {
    TypedExpression target;
    String methodName;
    List<TypedExpression> arguments;
    Type type;

    TypedMethodCall(TypedExpression target, String methodName, List<TypedExpression> arguments, Type type){
        this.target = target;
        this.methodName = methodName;
        this.arguments = arguments;
        this.type = type;
    }
}
