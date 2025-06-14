package TypedAST.TypedClasses;

public class TypedCharLiteral implements TypedExpression {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
