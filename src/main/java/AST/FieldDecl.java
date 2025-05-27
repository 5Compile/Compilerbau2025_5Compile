package AST;

import codegen.ClassContext;
import codegen.Type;
import org.objectweb.asm.Opcodes;

public record FieldDecl(String type, String name) implements MiniJava {

    public void codeGen(ClassContext classContext) {
        Type fieldType = Type.fromString(type);
        classContext.getClassWriter().visitField(
                Opcodes.ACC_PUBLIC,
                name,
                fieldType.getDescriptor(),
                null,
                null
        );
    }
}