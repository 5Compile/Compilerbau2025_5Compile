package TypedAST.TypedClasses;

public class TypedInstVar implements TypedExpression {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
