package TypedAST.TypedClasses;

import AST.ClassDecl;
import AST.Program;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TypedProgram implements TypedMiniJava {
    List<TypedClassDecl> classes;
    Type type = Type.VOID;

    TypedProgram(List<TypedClassDecl> classes){
        this.classes = classes;
    }

    @Override
    public Type getType() {
        return type;
    }
}
