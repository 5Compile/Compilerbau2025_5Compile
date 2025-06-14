package TypedAST.TypedClasses;

import AST.Block;
import AST.MainMethodDecl;

import java.util.Optional;

public class TypedMainMethodDecl implements TypedMiniJava {
    Block body;

    TypedMainMethodDecl(Optional<MainMethodDecl> mainMethod){

    }

    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
