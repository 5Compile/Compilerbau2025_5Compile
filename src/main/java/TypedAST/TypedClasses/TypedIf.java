package TypedAST.TypedClasses;

public class TypedIf implements TypedStatement {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
