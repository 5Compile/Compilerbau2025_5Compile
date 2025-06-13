package TypedAST.TypedClasses;

public class TypedAssign implements TypedStatement, TypedExpression {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
