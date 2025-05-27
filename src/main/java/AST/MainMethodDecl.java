package AST;

import codegen.ClassContext;
import codegen.MethodContext;
import codegen.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public record MainMethodDecl(Block body) implements MiniJava {

    public void codeGen(ClassContext classContext) {
        MethodVisitor mv = classContext.getClassWriter().visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                "main",
                "([Ljava/lang/String;)V",
                null,
                null
        );

        MethodContext methodContext = new MethodContext(mv, Type.VOID, classContext, true);

        mv.visitCode();
        if (body != null) {
            body.codeGen(methodContext);
        }
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 1);
        mv.visitEnd();
    }
}