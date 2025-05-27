package AST;

import codegen.MethodContext;

public record Assign(Expression target, Expression value) implements Statement, Expression {

    @Override
    public void codeGen(MethodContext methodContext) {
        // For field assignment: this.field = value
        if (target instanceof LocalOrFieldVar fieldVar) {
            // Load 'this' reference
            methodContext.getMethodVisitor().visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 0);

            // Generate code for the value to assign
            if (value != null) {
                value.codeGen(methodContext);
            }

            // Store in field - assume it's an int field for now
            methodContext.getMethodVisitor().visitFieldInsn(
                    org.objectweb.asm.Opcodes.PUTFIELD,
                    methodContext.getClassContext().getName(),
                    fieldVar.name(),
                    "I" // int descriptor
            );
        } else {
            // Fallback: generate both expressions
            if (value != null) {
                value.codeGen(methodContext);
            }
            if (target != null) {
                target.codeGen(methodContext);
            }
        }
    }
}