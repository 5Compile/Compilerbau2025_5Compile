package TypedAST.TypedClasses;

import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedFieldDecl implements TypedMiniJava {
    private String name;
    private Type type;

    public TypedFieldDecl(String name, Type type){
        this.name = name;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
