package TypedAST.TypedClasses;


import TypedAST.Type;

public class TypedBoolLiteral implements TypedExpression {
    boolean value;
    Type type = Type.BOOL;

    TypedBoolLiteral(boolean value){
        this.value = value;
    }

    @Override
    public Type getType() {
        return type;
    }
}
