package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

import java.util.List;

@Getter
@Setter
public class TypedNew implements TypedStatement, TypedExpression, CodeGen {
    private String className;
    private List<TypedExpression> arguments;
    private Type type;
    
    public TypedNew() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedNew(String className, List<TypedExpression> arguments, Type type) {
        this.className = className;
        this.arguments = arguments;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Create new object instance
        context.getMethodVisitor().visitTypeInsn(Opcodes.NEW, className);
        context.pushStack(1);
        
        // Duplicate reference for constructor call
        context.getMethodVisitor().visitInsn(Opcodes.DUP);
        context.pushStack(1);
        
        // Load constructor arguments
        if (arguments != null) {
            for (TypedExpression arg : arguments) {
                arg.codeGen(context);
            }
        }
        
        // Create constructor descriptor
        StringBuilder descriptor = new StringBuilder("(");
        if (arguments != null) {
            for (TypedExpression arg : arguments) {
                descriptor.append(arg.getType().getDescriptor());
            }
        }
        descriptor.append(")V"); // Constructor always returns void
        
        // Call constructor
        context.getMethodVisitor().visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            className,
            "<init>",
            descriptor.toString(),
            false
        );
        
        // Update stack: duplicated reference + arguments consumed, original reference remains
        int stackConsumed = 1; // duplicated reference
        if (arguments != null) {
            stackConsumed += arguments.size();
        }
        context.popStack(stackConsumed);
        
        // Original object reference remains on stack as result
    }
}
