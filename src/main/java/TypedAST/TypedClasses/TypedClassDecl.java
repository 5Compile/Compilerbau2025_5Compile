package TypedAST.TypedClasses;

import TypedAST.ClassContext;
import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class TypedClassDecl implements TypedMiniJava, CodeGen {
    private String name;
    private List<TypedFieldDecl> fields;
    private List<TypedMethodDecl> methods;
    private Optional<TypedMainMethodDecl> mainMethod;
    private Type type;
    
    public TypedClassDecl() {
        this.type = Type.REFERENCE("Object"); // Default to Object type
    }
    
    public TypedClassDecl(String name, List<TypedFieldDecl> fields, List<TypedMethodDecl> methods, Optional<TypedMainMethodDecl> mainMethod) {
        this.name = name;
        this.fields = fields;
        this.methods = methods;
        this.mainMethod = mainMethod;
        this.type = Type.REFERENCE(name); // Class type is reference to itself
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // This method is not used for classes - use codeGen() instead
        throw new UnsupportedOperationException("Use codeGen() without parameters for class generation");
    }
    
    /**
     * Generates bytecode for the entire class
     * @return the bytecode as byte array
     */
    public byte[] codeGen() {
        ClassContext classContext = new ClassContext(name);
        
        // Add fields to the class
        if (fields != null) {
            for (TypedFieldDecl field : fields) {
                classContext.addField(field.getName(), field.getType());
            }
        }
        
        // Generate default constructor
        MethodContext constructorContext = classContext.createConstructor();
        
        // Initialize fields to default values
        if (fields != null) {
            for (TypedFieldDecl field : fields) {
                constructorContext.getMethodVisitor().visitVarInsn(Opcodes.ALOAD, 0); // load 'this'
                constructorContext.pushStack(1);
                
                // Load default value based on type
                Type fieldType = field.getType();
                if (fieldType.isPrimitive()) {
                    switch (fieldType.getKind()) {
                        case INT -> constructorContext.loadConstant(0);
                        case BOOL -> constructorContext.loadConstant(false);
                        case CHAR -> constructorContext.loadConstant('\0');
                        default -> {
                            constructorContext.getMethodVisitor().visitInsn(Opcodes.ACONST_NULL);
                            constructorContext.pushStack(1);
                        }
                    }
                } else {
                    // Reference types get null as default
                    constructorContext.getMethodVisitor().visitInsn(Opcodes.ACONST_NULL);
                    constructorContext.pushStack(1);
                }
                
                // Store in field
                constructorContext.getMethodVisitor().visitFieldInsn(
                    Opcodes.PUTFIELD,
                    name,
                    field.getName(),
                    field.getType().getDescriptor()
                );
                constructorContext.popStack(2); // 'this' reference + value consumed
            }
        }
        
        // Return from constructor
        constructorContext.getMethodVisitor().visitInsn(Opcodes.RETURN);
        constructorContext.wrapUp();
        
        // Generate regular methods
        if (methods != null) {
            for (TypedMethodDecl method : methods) {
                method.codeGen(classContext);
            }
        }
        
        // Generate main method if present
        if (mainMethod.isPresent()) {
            mainMethod.get().codeGen(classContext);
        }
        
        return classContext.getBytecode();
    }
}
