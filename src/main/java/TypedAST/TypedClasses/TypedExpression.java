package TypedAST.TypedClasses;

public interface TypedExpression extends TypedMiniJava {
    void accept(TVisitor tVisitor);
}
