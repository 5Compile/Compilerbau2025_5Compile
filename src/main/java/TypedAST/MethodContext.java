package TypedAST;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * Context for method-level bytecode generation.
 * Tracks local variables, stack depth, and provides utilities for code generation.
 */
public class MethodContext {
    private final MethodVisitor methodVisitor;
    private final String className;
    private final Map<String, LocalVariable> localVariables = new HashMap<>();
    private int nextLocalIndex = 0;
    private int maxStack = 0;
    private int currentStack = 0;
    private boolean isStatic;
    
    public static class LocalVariable {
        public final int index;
        public final Type type;
        
        public LocalVariable(int index, Type type) {
            this.index = index;
            this.type = type;
        }
    }
    
    public MethodContext(MethodVisitor methodVisitor, String className, boolean isStatic) {
        this.methodVisitor = methodVisitor;
        this.className = className;
        this.isStatic = isStatic;
        
        // Reserve slot 0 for 'this' reference in non-static methods
        if (!isStatic) {
            nextLocalIndex = 1;
        }
    }
    
    public MethodVisitor getMethodVisitor() {
        return methodVisitor;
    }
    
    public String getClassName() {
        return className;
    }
    
    /**
     * Adds a local variable to the context
     */
    public void addLocalVariable(String name, Type type) {
        localVariables.put(name, new LocalVariable(nextLocalIndex, type));
        nextLocalIndex += getSlotCount(type);
    }
    
    /**
     * Gets the local variable by name
     */
    public LocalVariable getLocalVariable(String name) {
        return localVariables.get(name);
    }
    
    /**
     * Returns the number of JVM slots a type occupies
     */
    private int getSlotCount(Type type) {
        // All our types occupy 1 slot (int, bool, char, references)
        return 1;
    }
    
    /**
     * Updates the stack depth tracking
     */
    public void pushStack(int count) {
        currentStack += count;
        maxStack = Math.max(maxStack, currentStack);
    }
    
    public void popStack(int count) {
        currentStack -= count;
    }
    
    /**
     * Generates a load instruction for the given type
     */
    public void loadLocal(Type type, int index) {
        if (type.isPrimitive()) {
            switch (type.getKind()) {
                case INT, BOOL, CHAR -> methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
                default -> methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
            }
        } else {
            // Reference types use ALOAD
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
        pushStack(1);
    }
    
    /**
     * Generates a store instruction for the given type
     */
    public void storeLocal(Type type, int index) {
        if (type.isPrimitive()) {
            switch (type.getKind()) {
                case INT, BOOL, CHAR -> methodVisitor.visitVarInsn(Opcodes.ISTORE, index);
                default -> methodVisitor.visitVarInsn(Opcodes.ASTORE, index);
            }
        } else {
            // Reference types use ASTORE
            methodVisitor.visitVarInsn(Opcodes.ASTORE, index);
        }
        popStack(1);
    }
    
    /**
     * Loads a constant value onto the stack
     */
    public void loadConstant(Object value) {
        if (value instanceof Integer intValue) {
            if (intValue >= -1 && intValue <= 5) {
                methodVisitor.visitInsn(Opcodes.ICONST_0 + intValue);
            } else if (intValue >= Byte.MIN_VALUE && intValue <= Byte.MAX_VALUE) {
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, intValue);
            } else if (intValue >= Short.MIN_VALUE && intValue <= Short.MAX_VALUE) {
                methodVisitor.visitIntInsn(Opcodes.SIPUSH, intValue);
            } else {
                methodVisitor.visitLdcInsn(intValue);
            }
        } else if (value instanceof Character charValue) {
            int charCode = (int) charValue;
            if (charCode >= 0 && charCode <= 5) {
                methodVisitor.visitInsn(Opcodes.ICONST_0 + charCode);
            } else if (charCode <= 127) {
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, charCode);
            } else {
                methodVisitor.visitIntInsn(Opcodes.SIPUSH, charCode);
            }
        } else if (value instanceof Boolean boolValue) {
            methodVisitor.visitInsn(boolValue ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
        } else {
            methodVisitor.visitLdcInsn(value);
        }
        pushStack(1);
    }
    
    /**
     * Creates a new label for control flow
     */
    public Label createLabel() {
        return new Label();
    }
    
    /**
     * Visits a label
     */
    public void visitLabel(Label label) {
        methodVisitor.visitLabel(label);
    }
    
    /**
     * Generates a jump instruction
     */
    public void jumpIf(int opcode, Label label) {
        methodVisitor.visitJumpInsn(opcode, label);
        popStack(opcode == Opcodes.GOTO ? 0 : 1);
    }
    
    /**
     * Generates a conditional jump for two-value comparison
     */
    public void jumpIfCmp(int opcode, Label label) {
        methodVisitor.visitJumpInsn(opcode, label);
        popStack(2);
    }
    
    /**
     * Finalizes the method generation
     */
    public void wrapUp() {
        methodVisitor.visitMaxs(maxStack, nextLocalIndex);
        methodVisitor.visitEnd();
    }
    
    public boolean isStatic() {
        return isStatic;
    }
}