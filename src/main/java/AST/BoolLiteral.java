package AST;

import codegen.MethodContext;
import org.objectweb.asm.Opcodes;

public record BoolLiteral(boolean value) implements Expression {

    @Override
    public void codeGen(MethodContext methodContext) {
        int intValue = value ? 1 : 0;
        methodContext.getMethodVisitor().visitLdcInsn(intValue);
        methodContext.pushStack();
    }
}
