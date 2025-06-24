package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedLocalVarDecl implements TypedStatement, CodeGen {
    private String name;
    private Type type;
    
    public TypedLocalVarDecl() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedLocalVarDecl(String name, Type type) {
        this.name = name;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Add the local variable to the method context
        context.addLocalVariable(name, type);
        
        // Initialize local variable with default value
        // This is necessary for bytecode verification and matches Java semantics
        // where local variables must be initialized before use
        MethodContext.LocalVariable localVar = context.getLocalVariable(name);
        if (localVar != null) {
            if (type.isPrimitive()) {
                switch (type.getKind()) {
                    case INT -> context.loadConstant(0);
                    case BOOL -> context.loadConstant(false);
                    case CHAR -> context.loadConstant('\0');
                    default -> {
                        // Should not happen for primitives
                        context.getMethodVisitor().visitInsn(org.objectweb.asm.Opcodes.ACONST_NULL);
                        context.pushStack(1);
                    }
                }
            } else {
                // For reference types, initialize with null
                context.getMethodVisitor().visitInsn(org.objectweb.asm.Opcodes.ACONST_NULL);
                context.pushStack(1);
            }
            context.storeLocal(type, localVar.index);
        }
    }
}
