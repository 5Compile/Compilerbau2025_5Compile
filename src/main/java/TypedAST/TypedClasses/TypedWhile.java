package TypedAST.TypedClasses;

public class TypedWhile implements TypedStatement {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
