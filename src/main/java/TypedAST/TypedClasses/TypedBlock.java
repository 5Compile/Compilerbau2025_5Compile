package TypedAST.TypedClasses;

import AST.Block;
import AST.Statement;
import TypedAST.Type;

import java.util.List;

public class TypedBlock implements TypedMiniJava {
    public List<TypedStatement> statements;
    Type type;
}
