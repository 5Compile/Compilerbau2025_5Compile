package TypedAST.TypedClasses;

import TypedAST.CodeGen;
import TypedAST.MethodContext;
import TypedAST.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TypedBlock implements TypedMiniJava, CodeGen {
    private List<TypedStatement> statements;
    private Type type;
    
    public TypedBlock() {
        this.type = Type.VOID;
    }
    
    public TypedBlock(List<TypedStatement> statements) {
        this.statements = statements;
        this.type = Type.VOID;
    }
    
    @Override
    public void codeGen(MethodContext context) {
        if (statements != null) {
            for (TypedStatement statement : statements) {
                if (statement instanceof CodeGen codeGenStatement) {
                    codeGenStatement.codeGen(context);
                }
            }
        }
    }

    @Override
    public Type getType() {
        return type;
    }
}
