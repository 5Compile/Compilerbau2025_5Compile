package AST;

import codegen.MethodContext;
import org.objectweb.asm.Opcodes;

public record IntLiteral(int value) implements Expression {

    @Override
    public void codeGen(MethodContext methodContext) {
        methodContext.getMethodVisitor().visitLdcInsn(value);
        methodContext.pushStack();
    }
}