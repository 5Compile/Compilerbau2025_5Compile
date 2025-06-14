package TypedAST.TypedClasses;

public class TypedNew implements TypedStatement, TypedExpression {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
