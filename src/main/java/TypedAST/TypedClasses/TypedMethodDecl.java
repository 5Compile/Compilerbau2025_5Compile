package TypedAST.TypedClasses;

import AST.MethodDecl;
import AST.Parameter;

import java.util.List;

public class TypedMethodDecl implements TypedMiniJava {
    String returnType;
    List<TypedParameter> parameters;
    TypedBlock body;

    TypedMethodDecl(MethodDecl untypedMethodDecl){
        this.returnType = untypedMethodDecl.returnType();
        for (Parameter parameter: untypedMethodDecl.parameters())
        {
           this.parameters.add(new TypedParameter(parameter));
        }
        this.body = new TypedBlock(untypedMethodDecl.body());
    }

    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
