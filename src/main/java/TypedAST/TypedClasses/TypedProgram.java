package TypedAST.TypedClasses;

import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TypedProgram implements TypedMiniJava {
    private List<TypedClassDecl> classes;
    private Type type;
    
    public TypedProgram() {
        // Default constructor for TypeCheckVisitor
        this.type = Type.VOID;
    }
    
    public TypedProgram(List<TypedClassDecl> classes) {
        this.classes = classes;
        this.type = Type.VOID;
    }
}
