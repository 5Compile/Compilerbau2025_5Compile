package TypedAST.TypedClasses;

import AST.Block;
import AST.MethodDecl;
import AST.Parameter;
import TypedAST.Type;

import java.util.List;

public class TypedMethodDecl implements TypedMiniJava {
    String name;
    List<TypedParameter> parameters;
    TypedBlock body;
    Type type;

    TypedMethodDecl(String name, List<TypedParameter> typedParameterList, TypedBlock typedBody, Type type){
        this.name = name;
        this.parameters = typedParameterList;
        this.body = typedBody;
        this.type = type;
    }
}
