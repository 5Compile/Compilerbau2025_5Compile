package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.Type;

public interface TypedExpression extends TypedMiniJava, CodeGen {
    Type getType();
}
