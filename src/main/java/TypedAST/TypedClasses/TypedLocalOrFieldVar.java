package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedLocalOrFieldVar implements TypedExpression, CodeGen {
    private String name;
    private boolean isLocal;
    private Type type;
    
    public TypedLocalOrFieldVar() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedLocalOrFieldVar(String name, boolean isLocal, Type type) {
        this.name = name;
        this.isLocal = isLocal;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        if (isLocal) {
            // Load local variable
            MethodContext.LocalVariable localVar = context.getLocalVariable(name);
            if (localVar != null) {
                context.loadLocal(type, localVar.index);
            }
        } else {
            // Load field: this.fieldName
            context.getMethodVisitor().visitVarInsn(Opcodes.ALOAD, 0); // load 'this'
            context.pushStack(1);
            
            // Get field
            context.getMethodVisitor().visitFieldInsn(
                Opcodes.GETFIELD,
                context.getClassName(),
                name,
                type.getDescriptor()
            );
            context.popStack(1); // 'this' consumed
            context.pushStack(1); // field value produced
        }
    }
}
