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

}
