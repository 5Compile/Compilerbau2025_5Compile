package TypedAST.TypedClasses;

import AST.FieldDecl;
import TypedAST.Type;

public class TypedFieldDecl implements TypedMiniJava {
    public String name;
    public Type type;

    TypedFieldDecl(String name, Type type){
        this.name = name;
        this.type = type;
    }
}
