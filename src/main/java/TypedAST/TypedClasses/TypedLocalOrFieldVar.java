package TypedAST.TypedClasses;

import TypedAST.Type;

public class TypedLocalOrFieldVar implements TypedExpression {
    String name;
    boolean isLocal;
    Type type;
}
