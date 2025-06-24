package TypedAST.TypedClasses;

import AST.Block;
import AST.Expression;
import TypedAST.Type;

import java.util.Optional;

public class TypedIf implements TypedStatement {
    TypedExpression condition;
    TypedBlock thenBranch;
    Optional<TypedBlock> elseBranch;
    Type type;

    TypedIf(TypedExpression condition, TypedBlock thenBranch, Optional<TypedBlock> elseBranch, Type type){
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
        this.type = type;
    }
}
