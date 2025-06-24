package TypedAST.TypedClasses;

import AST.Parameter;
import TypedAST.Type;

public class TypedParameter implements TypedMiniJava {
    public String name;
    public Type type;

    TypedParameter(String name, Type type){
        this.name = name;
        this.type = type;
    }
}
