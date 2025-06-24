package TypedAST.TypedClasses;


import TypedAST.Type;

public class TypedBoolLiteral implements TypedExpression {
    boolean value;
    Type type;

    TypedBoolLiteral(boolean value, Type type){
        this.value = value;
        this.type = type;
    }
}
