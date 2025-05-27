package AST;

import codegen.ClassContext;
import codegen.CodeGenUtils;
import codegen.MethodContext;
import codegen.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public record MethodDecl(String name,
                         String returnType,
                         List<Parameter> parameters,
                         Block body) implements MiniJava {

    public void codeGen(ClassContext classContext) {
        Type returnTypeObj = Type.fromString(returnType);
        List<Type> paramTypes = parameters.stream()
                .map(param -> Type.fromString(param.type()))
                .toList();

        String descriptor = CodeGenUtils.generateMethodDescriptor(paramTypes, returnTypeObj);

        MethodVisitor mv = classContext.getClassWriter().visitMethod(
                Opcodes.ACC_PUBLIC,
                name,
                descriptor,
                null,
                null
        );

        MethodContext methodContext = new MethodContext(mv, returnTypeObj, classContext, false);

        // Allocate parameter variables
        for (Parameter param : parameters) {
            methodContext.allocateLocalVariable(param.name(), Type.fromString(param.type()));
        }

        mv.visitCode();
        if (body != null) {
            body.codeGen(methodContext);
        }

        // Add default return for void methods
        if (returnTypeObj.getKind() == Type.Kind.VOID) {
            mv.visitInsn(Opcodes.RETURN);
        }

        mv.visitMaxs(0, methodContext.getLocalVarIndex());
        mv.visitEnd();
    }
}