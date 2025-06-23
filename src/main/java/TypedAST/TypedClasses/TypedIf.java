package TypedAST.TypedClasses;

import AST.Block;
import AST.Expression;
import TypedAST.Type;

import java.util.Optional;

public class TypedIf implements TypedStatement {
    Expression condition;
    Block thenBranch;
    Optional<AST.Block> elseBranch;
    Type type;
}
