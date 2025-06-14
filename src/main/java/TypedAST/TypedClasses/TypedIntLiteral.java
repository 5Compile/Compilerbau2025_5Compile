package TypedAST.TypedClasses;

public class TypedIntLiteral implements TypedExpression {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
