package TypedAST.TypedClasses;

import AST.Block;
import AST.Statement;
import java.util.List;

public class TypedBlock implements TypedMiniJava {
    public List<TypedStatement> statements;

    TypedBlock(Block untypedBlock){
        for (Statement stmt: untypedBlock.statements())
        {
            //statements.add();
        }
    }
}
