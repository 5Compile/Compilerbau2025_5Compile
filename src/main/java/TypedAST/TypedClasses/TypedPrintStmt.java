package TypedAST.TypedClasses;

import AST.Expression;
import TypedAST.Type;

public class TypedPrintStmt implements TypedStatement {
    TypedExpression expression;
    Type type = Type.VOID;

    TypedPrintStmt(TypedExpression expression){
        this.expression = expression;
    }

    @Override
    public Type getType() {
        return type;
    }
}
