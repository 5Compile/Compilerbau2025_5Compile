package TypedAST.TypedClasses;

public class TypedLocalVarDecl implements TypedStatement {
    @Override
    public void accept(TVisitor tVisitor) {
        tVisitor.visit(this);
    }
}
