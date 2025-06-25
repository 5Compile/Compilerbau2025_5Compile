package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedInstVar implements TypedExpression, CodeGen {
    private TypedExpression target;
    private String fieldName;
    private Type type;
    
    public TypedInstVar() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedInstVar(TypedExpression target, String fieldName, Type type) {
        this.target = target;
        this.fieldName = fieldName;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Load target object
        if (target != null) {
            target.codeGen(context);
        } else {
            // Implicit 'this' reference
            context.getMethodVisitor().visitVarInsn(Opcodes.ALOAD, 0);
            context.pushStack(1);
        }
        
        // Get field from object
        String targetClassName = context.getClassName();
        context.getMethodVisitor().visitFieldInsn(
            Opcodes.GETFIELD,
            targetClassName,
            fieldName,
            type.getDescriptor()
        );
        
        // Update stack: object reference consumed, field value produced
        context.popStack(1);
        context.pushStack(1);
    }
}
