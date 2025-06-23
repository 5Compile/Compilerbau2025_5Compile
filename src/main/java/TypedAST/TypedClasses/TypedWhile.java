package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedWhile implements TypedStatement {
    Expression condition;
    TypedBlock body;
    Type type;
}
