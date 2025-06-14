package TypedAST.TypedClasses;


public class TypedBoolLiteral implements TypedExpression {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
