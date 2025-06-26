package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedWhile implements TypedStatement, CodeGen {
    private TypedExpression condition;
    private TypedBlock body;
    private Type type;
    
    public TypedWhile() {
        // Default constructor for TypeCheckVisitor
        this.type = Type.VOID;
    }
    
    public TypedWhile(TypedExpression condition, TypedBlock body) {
        this.condition = condition;
        this.body = body;
        this.type = Type.VOID;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        Label startLabel = context.createLabel();
        Label endLabel = context.createLabel();
        
        // Start of loop
        context.visitLabel(startLabel);
        
        // Generate condition
        condition.codeGen(context);
        
        // Jump to end if condition is false (0)
        context.jumpIf(Opcodes.IFEQ, endLabel);
        
        // Generate loop body
        if (body != null) {
            body.codeGen(context);
        }
        
        // Jump back to start
        context.jumpIf(Opcodes.GOTO, startLabel);
        
        // End of loop
        context.visitLabel(endLabel);
    }

    @Override
    public Type getType() {
        return type;
    }
}
