package TypedAST.TypedClasses;

import AST.Block;
import AST.MainMethodDecl;
import TypedAST.Type;

import java.util.Optional;

public class TypedMainMethodDecl implements TypedMiniJava {
    TypedBlock body;

    TypedMainMethodDecl(TypedBlock body){
        this.body = body;
    }
}
