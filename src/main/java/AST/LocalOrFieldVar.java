package AST;

import codegen.MethodContext;

public record LocalOrFieldVar(String name) implements Expression {
    @Override
    public void codeGen(MethodContext methodContext) {
        // Check if it's a local variable
        int localIndex = methodContext.getVariableIndex(name);

        if (localIndex >= 0) {
            // Load local variable
            methodContext.getMethodVisitor().visitVarInsn(org.objectweb.asm.Opcodes.ILOAD, localIndex);
        } else {
            // Assume it's a field - load this.fieldName
            methodContext.getMethodVisitor().visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 0); // load 'this'
            methodContext.getMethodVisitor().visitFieldInsn(
                    org.objectweb.asm.Opcodes.GETFIELD,
                    methodContext.getClassContext().getName(),
                    name,
                    "I" // assume int field for now
            );
        }
        methodContext.pushStack();
    }
}