package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedReturn implements TypedStatement {
    Expression value;
    Type type;
}
