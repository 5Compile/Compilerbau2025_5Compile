package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedAssign implements TypedStatement, TypedExpression, CodeGen {
    private TypedExpression target;
    private TypedExpression value;
    private Type type;
    
    public TypedAssign() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedAssign(TypedExpression target, TypedExpression value, Type type) {
        this.target = target;
        this.value = value;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Handle assignment target
        if (target instanceof TypedLocalOrFieldVar localOrFieldVar) {
            if (localOrFieldVar.isLocal()) {
                // Local variable assignment
                // For expression semantics duplicate value before storing
                value.codeGen(context);
                context.getMethodVisitor().visitInsn(org.objectweb.asm.Opcodes.DUP);
                context.pushStack(1);
                
                MethodContext.LocalVariable localVar = context.getLocalVariable(localOrFieldVar.getName());
                if (localVar != null) {
                    context.storeLocal(type, localVar.index);
                }
            } else {
                // Field assignment: this.field = value
                context.getMethodVisitor().visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 0); // load 'this'
                context.pushStack(1);
                
                // Generate code for the value
                value.codeGen(context);
                
                // For expression semantics duplicate value before storing
                context.getMethodVisitor().visitInsn(org.objectweb.asm.Opcodes.DUP_X1);
                context.pushStack(1);
                
                // Store in field
                context.getMethodVisitor().visitFieldInsn(
                    org.objectweb.asm.Opcodes.PUTFIELD,
                    context.getClassName(),
                    localOrFieldVar.getName(),
                    type.getDescriptor()
                );
                context.popStack(2);
            }
        }
    }
}
