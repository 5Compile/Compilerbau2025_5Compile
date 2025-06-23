package TypedAST.TypedClasses;

import TypedAST.Type;

import java.util.List;

public class TypedNew implements TypedStatement, TypedExpression {
    String className;
    List<TypedExpression> arguments;
    Type type;
}
