package AST;

import codegen.ClassContext;
import codegen.CodeGenUtils;
import codegen.MethodContext;
import codegen.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Optional;

public record ClassDecl(String name,
                        List<FieldDecl> fields,
                        List<MethodDecl> methods,
                        Optional<MainMethodDecl> mainMethod) implements MiniJava {

    public byte[] codeGen() {
        ClassContext classContext = new ClassContext(name);

        // Start class definition
        classContext.getClassWriter().visit(
                Opcodes.V11,
                Opcodes.ACC_PUBLIC,
                CodeGenUtils.getInternalName(name),
                null,
                "java/lang/Object",
                null
        );

        // Generate default constructor
        generateDefaultConstructor(classContext);

        // Generate fields
        for (FieldDecl field : fields) {
            field.codeGen(classContext);
        }

        // Generate methods
        for (MethodDecl method : methods) {
            method.codeGen(classContext);
        }

        // Generate main method if present
        if (mainMethod.isPresent()) {
            mainMethod.get().codeGen(classContext);
        }

        classContext.getClassWriter().visitEnd();
        return classContext.toByteArray();
    }

    private void generateDefaultConstructor(ClassContext classContext) {
        MethodVisitor mv = classContext.getClassWriter().visitMethod(
                Opcodes.ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null
        );

        MethodContext methodContext = new MethodContext(mv, Type.VOID, classContext, false);

        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }
}