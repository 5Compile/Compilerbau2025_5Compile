package TypedAST.TypedClasses;

import TypedAST.ClassContext;
import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedMainMethodDecl implements TypedMiniJava, CodeGen {
    private TypedBlock body;
    private Type type;
    
    public TypedMainMethodDecl() {
        // Default constructor for TypeCheckVisitor
        this.type = Type.VOID;
    }
    
    public TypedMainMethodDecl(TypedBlock body) {
        this.body = body;
        this.type = Type.VOID;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // This method is not used for main method - use codeGen(ClassContext) instead
        throw new UnsupportedOperationException("Use codeGen(ClassContext) for main method generation");
    }
    
    /**
     * Generates the main method bytecode
     * @param classContext The class context
     */
    public void codeGen(ClassContext classContext) {
        // Create main method: public static void main(String[] args)  
        // We need to manually create this since our type system doesn't model String[]
        MethodContext methodContext = classContext.createMainMethod();
        
        // Generate the method body
        if (body != null) {
            body.codeGen(methodContext);
        }
        
        // Ensure method returns properly
        methodContext.getMethodVisitor().visitInsn(Opcodes.RETURN);
        
        // Finalize the method
        methodContext.wrapUp();
    }
}
