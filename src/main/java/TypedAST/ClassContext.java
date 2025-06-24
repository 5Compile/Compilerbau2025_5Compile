package TypedAST;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * Context for class-level bytecode generation.
 * Wraps ASM ClassWriter and maintains class metadata.
 */
public class ClassContext {
    private final ClassWriter classWriter;
    private final String className;
    private final Map<String, Type> fields = new HashMap<>();
    
    public ClassContext(String className) {
        this.className = className;
        this.classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        
        // Generate class header
        classWriter.visit(
            Opcodes.V1_8,                    // Java 8 bytecode version
            Opcodes.ACC_PUBLIC,              // public class
            className,                       // class name
            null,                           // signature (for generics)
            "java/lang/Object",             // superclass
            null                            // interfaces
        );
    }
    
    public ClassWriter getClassWriter() {
        return classWriter;
    }
    
    public String getClassName() {
        return className;
    }
    
    /**
     * Adds a field to the class
     */
    public void addField(String name, Type type) {
        fields.put(name, type);
        classWriter.visitField(
            Opcodes.ACC_PRIVATE,            // private field
            name,                           // field name
            type.getDescriptor(),           // field type descriptor
            null,                           // signature (for generics)
            null                            // default value
        ).visitEnd();
    }
    
    /**
     * Gets the type of a field
     */
    public Type getFieldType(String fieldName) {
        return fields.get(fieldName);
    }
    
    /**
     * Creates a new method in the class
     */
    public MethodContext createMethod(String methodName, Type returnType, Type[] parameterTypes, boolean isStatic) {
        String descriptor = createMethodDescriptor(returnType, parameterTypes);
        int access = Opcodes.ACC_PUBLIC;
        if (isStatic) {
            access |= Opcodes.ACC_STATIC;
        }
        
        MethodVisitor methodVisitor = classWriter.visitMethod(
            access,                         // access flags
            methodName,                     // method name
            descriptor,                     // method descriptor
            null,                          // signature (for generics)
            null                           // exceptions
        );
        
        methodVisitor.visitCode();
        return new MethodContext(methodVisitor, className, isStatic);
    }
    
    /**
     * Creates the main method with proper signature: public static void main(String[] args)
     */
    public MethodContext createMainMethod() {
        MethodVisitor methodVisitor = classWriter.visitMethod(
            Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,  // public static
            "main",                                    // method name
            "([Ljava/lang/String;)V",                 // String[] args -> void
            null,                                     // signature
            null                                      // exceptions
        );
        
        methodVisitor.visitCode();
        return new MethodContext(methodVisitor, className, true);
    }
    
    /**
     * Creates the default constructor for the class
     */
    public MethodContext createConstructor() {
        MethodVisitor methodVisitor = classWriter.visitMethod(
            Opcodes.ACC_PUBLIC,             // public constructor
            "<init>",                       // constructor name
            "()V",                          // no parameters, void return
            null,                          // signature
            null                           // exceptions
        );
        
        methodVisitor.visitCode();
        MethodContext context = new MethodContext(methodVisitor, className, false);
        
        // Call super constructor: super();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);  // load 'this'
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/Object",
            "<init>",
            "()V",
            false
        );
        context.pushStack(1);
        context.popStack(1);
        
        return context;
    }
    
    /**
     * Creates a method descriptor string from return type and parameter types
     */
    private String createMethodDescriptor(Type returnType, Type[] parameterTypes) {
        StringBuilder descriptor = new StringBuilder("(");
        
        for (Type paramType : parameterTypes) {
            descriptor.append(paramType.getDescriptor());
        }
        
        descriptor.append(")");
        descriptor.append(returnType.getDescriptor());
        
        return descriptor.toString();
    }
    
    /**
     * Finalizes the class generation and returns bytecode
     */
    public byte[] getBytecode() {
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }
}