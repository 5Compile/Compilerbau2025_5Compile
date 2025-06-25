package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;
import org.objectweb.asm.Opcodes;

@Getter
@Setter
public class TypedPrintStmt implements TypedStatement, CodeGen {
    private TypedExpression expression;
    private Type type;
    
    public TypedPrintStmt() {
        this.type = Type.VOID;
    }
    
    public TypedPrintStmt(TypedExpression expression) {
        this.expression = expression;
        this.type = Type.VOID;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        // Get System.out
        context.getMethodVisitor().visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        );
        context.pushStack(1);
        
        // Generate the expression to print
        expression.codeGen(context);
        
        // Determine the print method based on expression type
        String descriptor = switch (expression.getType().getKind()) {
            case INT -> "(I)V";
            case BOOL -> "(Z)V";
            case CHAR -> "(C)V";
            default -> "(Ljava/lang/Object;)V";
        };
        
        // Call println method
        context.getMethodVisitor().visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            descriptor,
            false
        );
        context.popStack(2); // PrintStream reference + value consumed
    }
}
