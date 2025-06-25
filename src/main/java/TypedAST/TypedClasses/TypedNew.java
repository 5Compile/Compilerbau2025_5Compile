package TypedAST.TypedClasses;

import TypedAST.Type;

import java.util.List;

public class TypedNew implements TypedStatement, TypedExpression {
    String className;
    List<TypedExpression> arguments;
    Type type;

    TypedNew(String className, List<TypedExpression> arguments, Type type){
        this.className = className;
        this.arguments = arguments;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
