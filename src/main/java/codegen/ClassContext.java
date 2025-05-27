package codegen;

import org.objectweb.asm.ClassWriter;

public class ClassContext {
    private final String name;
    private final Type type;
    private final ClassWriter classWriter;

    public ClassContext(String name) {
        this.name = name;
        this.type = Type.reference(name);
        this.classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public ClassWriter getClassWriter() {
        return classWriter;
    }

    public byte[] toByteArray() {
        return classWriter.toByteArray();
    }
}