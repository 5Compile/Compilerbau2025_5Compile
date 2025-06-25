package TypedAST.TypedClasses;

import AST.Block;
import AST.Statement;
import TypedAST.Type;

import java.util.List;

public class TypedBlock implements TypedMiniJava {
    public List<TypedStatement> statements;
    Type type;

    TypedBlock(List<TypedStatement> statements, Type type){
        this.statements = statements;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
