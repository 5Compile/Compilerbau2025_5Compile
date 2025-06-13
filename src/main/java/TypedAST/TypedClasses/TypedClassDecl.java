package TypedAST.TypedClasses;

import AST.ClassDecl;
import AST.FieldDecl;
import AST.MethodDecl;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class TypedClassDecl implements TypedMiniJava {
    private String name;
    private List<TypedFieldDecl> fields;
    private List<TypedMethodDecl> methods;
    private Optional<TypedMainMethodDecl> mainMethod;
    private Type type;

    TypedClassDecl(ClassDecl untypedClass){
        this.name = untypedClass.name();
        for (FieldDecl fieldDecl: untypedClass.fields())
        {
            this.fields.add(new TypedFieldDecl(fieldDecl));
        }
        for (MethodDecl methodDecl: untypedClass.methods())
        {
            this.methods.add(new TypedMethodDecl(methodDecl));
        }
        if(untypedClass.mainMethod().isPresent()){
            this.mainMethod = Optional.of(new TypedMainMethodDecl(untypedClass.mainMethod()));
        }
        //checks ob alles passt hier --> für leere Klasse erstmal hier übersprungen
    }

    @Override
    public void accept(TVisitor tVisitor) {

    }
}
