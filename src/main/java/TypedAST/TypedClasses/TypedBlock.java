package TypedAST.TypedClasses;

import AST.Block;
import AST.Statement;

import java.util.List;

public class TypedBlock {
    public List<TypedStatement> statements;

    public TypedBlock(Block untypedBlock){
        for (Statement stmt: untypedBlock.statements())
        {
            //statements.add();
        }
    }
}
