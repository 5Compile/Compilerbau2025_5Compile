package TypedAST.TypedClasses;

import AST.Block;
import AST.MethodDecl;
import AST.Parameter;

import java.util.List;

public class TypedMethodDecl {
    String returnType;
    List<TypedParameter> parameters;
    Block body;

    TypedMethodDecl(MethodDecl untypedMethodDecl){
        this.returnType = untypedMethodDecl.returnType();
        for (Parameter parameter: untypedMethodDecl.parameters())
        {
           // this.parameters.add(new TypedParameter(parameter));
        }
        // this.body = new TypedBlock(untypedMethodDecl.body());
    }
}
