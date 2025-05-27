package AST;

import codegen.MethodContext;
import org.objectweb.asm.Opcodes;

public record Return(Expression value) implements Statement {

    @Override
    public void codeGen(MethodContext methodContext) {
        if (value != null) {
            value.codeGen(methodContext);
        }

        switch (methodContext.getReturnType().getKind()) {
            case INT, BOOL, CHAR -> methodContext.getMethodVisitor().visitInsn(Opcodes.IRETURN);
            case REFERENCE -> methodContext.getMethodVisitor().visitInsn(Opcodes.ARETURN);
            case VOID -> methodContext.getMethodVisitor().visitInsn(Opcodes.RETURN);
        }
    }
}