package TypedAST.TypedClasses;

import AST.UnaryOperator;
import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedUnary implements TypedExpression, CodeGen {
    private TypedExpression operand;
    private UnaryOperator operator;
    private Type type;
    
    public TypedUnary() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedUnary(TypedExpression operand, UnaryOperator operator, Type type) {
        this.operand = operand;
        this.operator = operator;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Generate operand first
        operand.codeGen(context);
        
        switch (operator) {
            case NEG -> {
                // Arithmetic negation: -x
                context.getMethodVisitor().visitInsn(Opcodes.INEG);
                // Stack unchanged (one value in, one value out)
            }
            case NOT -> {
                // Logical negation: !x
                Label trueLabel = context.createLabel();
                Label endLabel = context.createLabel();
                
                // If operand is 0 (false), jump to true label
                context.jumpIf(Opcodes.IFEQ, trueLabel);
                
                // Operand was true, return false
                context.loadConstant(false);
                context.jumpIf(Opcodes.GOTO, endLabel);
                
                // True label: operand was false, return true
                context.visitLabel(trueLabel);
                context.loadConstant(true);
                
                context.visitLabel(endLabel);
            }
        }
    }
}
