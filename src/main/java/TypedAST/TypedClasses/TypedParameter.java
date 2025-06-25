package TypedAST.TypedClasses;

import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedParameter implements TypedMiniJava {
    private String name;
    private Type type;
    
    public TypedParameter() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedParameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
