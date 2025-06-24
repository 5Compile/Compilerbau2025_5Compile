package TypedAST.TypedClasses;

import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedNullLiteral implements TypedExpression {
    private Type type;
    
    public TypedNullLiteral() {
        // Default constructor for TypeCheckVisitor
        // Null literals have Object type (using java/lang/Object as default)
        this.type = Type.REFERENCE("java/lang/Object");
    }
    
    public TypedNullLiteral(Type type) {
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Load null reference onto the stack
        context.getMethodVisitor().visitInsn(Opcodes.ACONST_NULL);
        context.pushStack(1);
    }
}
