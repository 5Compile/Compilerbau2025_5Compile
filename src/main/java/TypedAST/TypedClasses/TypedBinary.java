package TypedAST.TypedClasses;

import AST.BinaryOperator;
import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedBinary implements TypedExpression, CodeGen {
    private TypedExpression left;
    private TypedExpression right;
    private BinaryOperator operator;
    private Type type;
    
    public TypedBinary() {
        // Default constructor for TypeCheckVisitor
    }
    
    public TypedBinary(TypedExpression left, TypedExpression right, BinaryOperator operator, Type type) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        switch (operator) {
            case PLUS -> {
                left.codeGen(context);
                right.codeGen(context);
                context.getMethodVisitor().visitInsn(Opcodes.IADD);
                context.popStack(1);
            }
            case MINUS -> {
                left.codeGen(context);
                right.codeGen(context);
                context.getMethodVisitor().visitInsn(Opcodes.ISUB);
                context.popStack(1);
            }
            case TIMES -> {
                left.codeGen(context);
                right.codeGen(context);
                context.getMethodVisitor().visitInsn(Opcodes.IMUL);
                context.popStack(1);
            }
            case DIV -> {
                left.codeGen(context);
                right.codeGen(context);
                context.getMethodVisitor().visitInsn(Opcodes.IDIV);
                context.popStack(1);
            }
            case MOD -> {
                left.codeGen(context);
                right.codeGen(context);
                context.getMethodVisitor().visitInsn(Opcodes.IREM);
                context.popStack(1);
            }
            case EQ -> generateComparison(context, Opcodes.IF_ICMPEQ);
            case NEQ -> generateComparison(context, Opcodes.IF_ICMPNE);
            case LT -> generateComparison(context, Opcodes.IF_ICMPLT);
            case LTE -> generateComparison(context, Opcodes.IF_ICMPLE);
            case GT -> generateComparison(context, Opcodes.IF_ICMPGT);
            case GTE -> generateComparison(context, Opcodes.IF_ICMPGE);
            case AND -> generateLogicalAnd(context);
            case OR -> generateLogicalOr(context);
        }
    }
    
    private void generateComparison(MethodContext context, int compareOpcode) {
        Label trueLabel = context.createLabel();
        Label endLabel = context.createLabel();
        
        // Generate operands
        left.codeGen(context);
        right.codeGen(context);
        
        // Compare and jump to true label if condition is met
        context.jumpIfCmp(compareOpcode, trueLabel);
        
        // Push false (0) and jump to end
        context.loadConstant(false);
        context.jumpIf(Opcodes.GOTO, endLabel);
        
        // True label: push true (1)
        context.visitLabel(trueLabel);
        context.loadConstant(true);
        
        // End label
        context.visitLabel(endLabel);
    }
    
    private void generateLogicalAnd(MethodContext context) {
        Label falseLabel = context.createLabel();
        Label endLabel = context.createLabel();
        
        // Generate left operand
        left.codeGen(context);
        
        // If left is false, jump to false label
        context.jumpIf(Opcodes.IFEQ, falseLabel);
        
        // Generate right operand
        right.codeGen(context);
        
        // If right is false, jump to false label
        context.jumpIf(Opcodes.IFEQ, falseLabel);
        
        // Both are true: push true
        context.loadConstant(true);
        context.jumpIf(Opcodes.GOTO, endLabel);
        
        // False label: push false
        context.visitLabel(falseLabel);
        context.loadConstant(false);
        
        // End label
        context.visitLabel(endLabel);
    }
    
    private void generateLogicalOr(MethodContext context) {
        Label trueLabel = context.createLabel();
        Label endLabel = context.createLabel();
        
        // Generate left operand
        left.codeGen(context);
        
        // If left is true, jump to true label
        context.jumpIf(Opcodes.IFNE, trueLabel);
        
        // Generate right operand  
        right.codeGen(context);
        
        // If right is true, jump to true label
        context.jumpIf(Opcodes.IFNE, trueLabel);
        
        // Both are false: push false
        context.loadConstant(false);
        context.jumpIf(Opcodes.GOTO, endLabel);
        
        // True label: push true
        context.visitLabel(trueLabel);
        context.loadConstant(true);
        
        // End label
        context.visitLabel(endLabel);
    }
}
