package TypedAST.TypedClasses;

import AST.ClassDecl;
import AST.FieldDecl;
import AST.MethodDecl;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

public class TypedClassDecl implements TypedMiniJava {
    String name;
    List<TypedFieldDecl> fields;
    List<TypedMethodDecl> methods;
    Optional<TypedMainMethodDecl> mainMethod;
    Type type = Type.VOID;

    TypedClassDecl(String name, List<TypedFieldDecl> fields, List<TypedMethodDecl> methods, Optional<TypedMainMethodDecl> mainMethod){
        this.name = name;
        this.fields = fields;
        this.methods = methods;
        this.mainMethod = mainMethod;
    }

    @Override
    public Type getType() {
        return type;
    }
}
