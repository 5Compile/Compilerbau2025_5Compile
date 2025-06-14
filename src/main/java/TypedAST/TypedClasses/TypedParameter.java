package TypedAST.TypedClasses;

import AST.Parameter;
import TypedAST.Type;

public class TypedParameter implements TypedMiniJava {
    public String name;
    public Type type;

    TypedParameter(Parameter untypedParameter){
        this.name = untypedParameter.name();
        switch (untypedParameter.name()){
            case "int":
                type = Type.INT;
                break;
            case "boolean":
                type = Type.BOOL;
                break;
            case "char":
                type = Type.CHAR;
                break;
            default:
                throw new RuntimeException("Error on defining Type of Parameter");
        }
    }

    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
