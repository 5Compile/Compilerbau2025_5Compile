package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedIntLiteral implements TypedExpression, CodeGen {
    private int value;
    private Type type;
    
    public TypedIntLiteral() {
        // Default constructor for TypeCheckVisitor
        this.type = Type.INT;
    }
    
    public TypedIntLiteral(int value) {
        this.value = value;
        this.type = Type.INT;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        context.loadConstant(value);
    }
}
