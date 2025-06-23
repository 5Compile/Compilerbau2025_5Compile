package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedPrintStmt implements TypedStatement {
    Expression expression;
    Type type;
}
