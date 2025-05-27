package AST;

import codegen.MethodContext;

public record InstVar(Expression target, String fieldName) implements Expression {
    @Override
    public void codeGen(MethodContext methodContext) {
        // Generate code for target object
        if (target != null) {
            target.codeGen(methodContext);
        }

        // Access field on the target object
        methodContext.getMethodVisitor().visitFieldInsn(
                org.objectweb.asm.Opcodes.GETFIELD,
                "java/lang/Object", // TODO: should get actual type from target
                fieldName,
                "I" // assume int field for now
        );
        methodContext.pushStack();
    }
}