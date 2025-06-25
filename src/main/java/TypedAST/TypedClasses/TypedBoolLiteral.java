package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedBoolLiteral implements TypedExpression, CodeGen {
    private boolean value;
    private Type type;
    
    public TypedBoolLiteral() {
        this.type = Type.BOOL;
    }
    
    public TypedBoolLiteral(boolean value) {
        this.value = value;
        this.type = Type.BOOL;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        context.loadConstant(value);
    }
}
