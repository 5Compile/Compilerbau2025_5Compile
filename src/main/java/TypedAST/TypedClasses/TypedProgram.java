package TypedAST.TypedClasses;

import AST.ClassDecl;
import AST.Program;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TypedProgram implements TypedMiniJava {
    List<TypedClassDecl> classes;
    Type type;

    TypedProgram(List<TypedClassDecl> classes, Type type){
        this.classes = classes;
        this.type = type;
    }
}
