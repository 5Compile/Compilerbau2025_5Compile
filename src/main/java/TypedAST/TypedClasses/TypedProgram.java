package TypedAST.TypedClasses;

import AST.ClassDecl;
import AST.Program;

import java.util.List;

public class TypedProgram {
    List<TypedClassDecl> classes;

    TypedProgram(Program untypedProgram){
        for (ClassDecl classDecl: untypedProgram.classes())
        {
            this.classes.add(new TypedClassDecl(classDecl));
        }

    }
}
