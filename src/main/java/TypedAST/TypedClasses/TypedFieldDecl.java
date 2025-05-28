package TypedAST.TypedClasses;

import AST.FieldDecl;
import TypedAST.Type;

public class TypedFieldDecl {
    public String name;
    public Type type;

    TypedFieldDecl(FieldDecl untypedFieldDecl) {
        this.name = untypedFieldDecl.name();
        switch (untypedFieldDecl.type()){
            case "int":
                type = Type.INT;
                break;
            case "boolean":
                type = Type.BOOL;
                break;
            case "char":
                type = Type.CHAR;
                break;
            default:
                throw new RuntimeException("Error on defining Type of FieldDecl");
        }

    }
}
