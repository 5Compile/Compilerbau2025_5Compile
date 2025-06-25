package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import java.util.Optional;

@Getter
@Setter
public class TypedIf implements TypedStatement, CodeGen {
    private TypedExpression condition;
    private TypedBlock thenBranch;
    private Optional<TypedBlock> elseBranch;
    private Type type;
    
    public TypedIf() {
        // Default constructor for TypeCheckVisitor
        this.type = Type.VOID;
    }
    
    public TypedIf(TypedExpression condition, TypedBlock thenBranch, Optional<TypedBlock> elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
        this.type = Type.VOID;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        Label elseLabel = context.createLabel();
        Label endLabel = context.createLabel();
        
        // Generate condition
        condition.codeGen(context);
        
        // Jump to else if condition is false (0)
        context.jumpIf(Opcodes.IFEQ, elseLabel);
        
        // Generate then branch
        if (thenBranch != null) {
            thenBranch.codeGen(context);
        }
        
        // Jump to end (skip else branch)
        context.jumpIf(Opcodes.GOTO, endLabel);
        
        // Else label
        context.visitLabel(elseLabel);
        
        // Generate else branch if present
        if (elseBranch.isPresent()) {
            elseBranch.get().codeGen(context);
        }
        
        // End label
        context.visitLabel(endLabel);
    }
}
