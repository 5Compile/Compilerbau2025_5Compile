package TypedAST.TypedClasses;

import AST.ClassDecl;
import AST.Program;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TypedProgram {
    List<TypedClassDecl> classes;

    TypedProgram(Program untypedProgram){
        for (ClassDecl classDecl: untypedProgram.classes())
        {
            this.classes.add(new TypedClassDecl(classDecl));
        }
        checkForDoubleClasses();

    }

    public void checkForDoubleClasses(){

        for (TypedClassDecl currentClass : classes)
        {
            for(TypedClassDecl compareClass  : classes){
                if(currentClass == compareClass){
                    return;
                }else if(currentClass.getName().equals(compareClass.getName())){
                    throw new RuntimeException("Class Name " + currentClass.getName() + " is declared multiple times!");
                }
            }
        }
    }
}
