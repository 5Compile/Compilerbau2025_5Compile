package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedPrintStmt implements TypedStatement {
    TypedExpression expression;
    Type type;

    TypedPrintStmt(TypedExpression expression, Type type){
        this.expression = expression;
        this.type = type;
    }
}
