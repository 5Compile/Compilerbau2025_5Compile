package TypedAST.TypedClasses;

import AST.Block;
import AST.MethodDecl;
import AST.Parameter;
import TypedAST.Type;

import java.util.List;

public class TypedMethodDecl implements TypedMiniJava {
    String name;
    List<TypedParameter> parameters;
    List<TypedLocalVarDecl> localVars;
    TypedBlock body;
    Type type;

    TypedMethodDecl(String name, List<TypedParameter> typedParameterList, List<TypedLocalVarDecl> localVars, TypedBlock typedBody, Type type){
        this.name = name;
        this.parameters = typedParameterList;
        this.localVars = localVars;
        this.body = typedBody;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
