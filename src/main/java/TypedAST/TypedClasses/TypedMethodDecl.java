package TypedAST.TypedClasses;

import TypedAST.ClassContext;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

import java.util.List;

@Getter
@Setter
public class TypedMethodDecl implements TypedMiniJava {
    private String name;
    private List<TypedParameter> parameters;
    private TypedBlock body;
    private Type type;

    public TypedMethodDecl() {
        // Default constructor for TypeCheckVisitor
    }

    public TypedMethodDecl(String name, List<TypedParameter> typedParameterList, TypedBlock typedBody, Type type){
        this.name = name;
        this.parameters = typedParameterList;
        this.body = typedBody;
        this.type = type;
    }
    
    /**
     * Generates bytecode for this method within the given class context
     */
    public void codeGen(ClassContext classContext) {
        // Create parameter type array
        Type[] parameterTypes = new Type[parameters != null ? parameters.size() : 0];
        if (parameters != null) {
            for (int i = 0; i < parameters.size(); i++) {
                parameterTypes[i] = parameters.get(i).getType();
            }
        }
        
        // Create method context
        MethodContext methodContext = classContext.createMethod(name, type, parameterTypes, false);
        
        // Add parameters as local variables
        if (parameters != null) {
            for (TypedParameter param : parameters) {
                methodContext.addLocalVariable(param.getName(), param.getType());
            }
        }
        
        // Generate method body
        if (body != null) {
            body.codeGen(methodContext);
        }
        
        // Add return instruction if method doesn't end with one
        if (type.getKind() == Type.Kind.VOID) {
            methodContext.getMethodVisitor().visitInsn(Opcodes.RETURN);
        } else {
            // For non-void methods, add default return value if no explicit return
            if (type.isPrimitive()) {
                switch (type.getKind()) {
                    case INT, BOOL, CHAR -> {
                        methodContext.loadConstant(0);
                        methodContext.getMethodVisitor().visitInsn(Opcodes.IRETURN);
                    }
                }
            } else {
                // Reference types return null by default
                methodContext.getMethodVisitor().visitInsn(Opcodes.ACONST_NULL);
                methodContext.pushStack(1);
                methodContext.getMethodVisitor().visitInsn(Opcodes.ARETURN);
                methodContext.popStack(1);
            }
        }
        
        // Finalize method
        methodContext.wrapUp();
    }
}
