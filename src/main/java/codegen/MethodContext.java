package codegen;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.*;

public class MethodContext {
    private final MethodVisitor methodVisitor;
    private final Type returnType;
    private final ClassContext classContext;
    private int localVarIndex;
    private final Map<String, Integer> variableIndex;
    private final Deque<Integer> stack;
    private final Deque<Label> breakLabels;
    private final Deque<Label> continueLabels;

    public MethodContext(MethodVisitor methodVisitor, Type returnType, ClassContext classContext, boolean isStatic) {
        this.methodVisitor = methodVisitor;
        this.returnType = returnType;
        this.classContext = classContext;
        this.localVarIndex = isStatic ? 0 : 1; // 0 for static, 1 for instance (this)
        this.variableIndex = new HashMap<>();
        this.stack = new ArrayDeque<>();
        this.breakLabels = new ArrayDeque<>();
        this.continueLabels = new ArrayDeque<>();
    }

    public MethodVisitor getMethodVisitor() {
        return methodVisitor;
    }

    public Type getReturnType() {
        return returnType;
    }

    public ClassContext getClassContext() {
        return classContext;
    }

    public int allocateLocalVariable(String name, Type type) {
        int index = localVarIndex;
        variableIndex.put(name, index);
        localVarIndex += getTypeSize(type);
        return index;
    }

    public int getVariableIndex(String name) {
        return variableIndex.getOrDefault(name, -1);
    }

    public void pushStack() {
        stack.push(1);
    }

    public void popStack() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public void pushBreakLabel(Label label) {
        breakLabels.push(label);
    }

    public void popBreakLabel() {
        if (!breakLabels.isEmpty()) {
            breakLabels.pop();
        }
    }

    public Label getCurrentBreakLabel() {
        return breakLabels.isEmpty() ? null : breakLabels.peek();
    }

    public void pushContinueLabel(Label label) {
        continueLabels.push(label);
    }

    public void popContinueLabel() {
        if (!continueLabels.isEmpty()) {
            continueLabels.pop();
        }
    }

    public Label getCurrentContinueLabel() {
        return continueLabels.isEmpty() ? null : continueLabels.peek();
    }

    public int getLocalVarIndex() {
        return localVarIndex;
    }

    private int getTypeSize(Type type) {
        return switch (type.getKind()) {
            case INT, BOOL, CHAR, REFERENCE -> 1;
            case VOID -> 0;
        };
    }
}