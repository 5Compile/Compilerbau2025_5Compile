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
public class TypedMethodCall implements TypedStatement, TypedExpression, CodeGen {
    private TypedExpression target;
    private String methodName;
    private List<TypedExpression> arguments;
    private Type type;
    
    public TypedMethodCall() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedMethodCall(TypedExpression target, String methodName, List<TypedExpression> arguments, Type type) {
        this.target = target;
        this.methodName = methodName;
        this.arguments = arguments;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Load target object (receiver)
        if (target != null) {
            target.codeGen(context);
        } else {
            // Static method call or 'this' implied
            context.getMethodVisitor().visitVarInsn(Opcodes.ALOAD, 0); // load 'this'
            context.pushStack(1);
        }
        
        // Load method arguments
        if (arguments != null) {
            for (TypedExpression arg : arguments) {
                arg.codeGen(context);
            }
        }
        
        // Create method descriptor
        StringBuilder descriptor = new StringBuilder("(");
        if (arguments != null) {
            for (TypedExpression arg : arguments) {
                descriptor.append(arg.getType().getDescriptor());
            }
        }
        descriptor.append(")");
        descriptor.append(type.getDescriptor());
        
        // Generate method call
        String targetClassName = context.getClassName();
        context.getMethodVisitor().visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            targetClassName,
            methodName,
            descriptor.toString(),
            false
        );
        
        // Update stack: receiver + arguments consumed, return value (if any) produced
        int stackConsumed = 1; // receiver
        if (arguments != null) {
            stackConsumed += arguments.size();
        }
        context.popStack(stackConsumed);
        
        if (type != Type.VOID) {
            context.pushStack(1); // return value
        }
    }
}
