package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedCharLiteral implements TypedExpression, CodeGen {
    private char value;
    private Type type;
    
    public TypedCharLiteral() {
        this.type = Type.CHAR;
    }
    
    public TypedCharLiteral(char value) {
        this.value = value;
        this.type = Type.CHAR;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        context.loadConstant(value);
    }
}
