package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

import java.util.Optional;

@Getter
@Setter
public class TypedReturn implements TypedStatement, CodeGen {
    private Optional<TypedExpression> value;
    private Type type;
    
    public TypedReturn() {
        // Default constructor for TypeCheckVisitor
        this.type = Type.VOID;
        this.value = Optional.empty();
    }
    
    public TypedReturn(Optional<TypedExpression> value, Type type) {
        this.value = value;
        this.type = type;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        if (value.isPresent()) {
            // Generate the return value
            value.get().codeGen(context);
            
            // Return with value based on type
            switch (type.getKind()) {
                case INT, BOOL, CHAR -> context.getMethodVisitor().visitInsn(Opcodes.IRETURN);
                case VOID -> context.getMethodVisitor().visitInsn(Opcodes.RETURN);
                default -> context.getMethodVisitor().visitInsn(Opcodes.ARETURN); // Object return
            }
        } else {
            // Void return
            context.getMethodVisitor().visitInsn(Opcodes.RETURN);
        }
    }
}
