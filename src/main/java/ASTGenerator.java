import AST.FieldDecl;
import AST.MethodDecl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ASTGenerator {
    public static AST.ClassDecl generateAST (MiniJavaParser.ClassContext ctx) {
        List<FieldDecl> FieldDecl = new ArrayList<AST.FieldDecl>();
        if(ctx.fieldDecl() != null) {

        }

        List<MethodDecl> MethodDecl = new ArrayList<AST.MethodDecl>();

        return new AST.ClassDecl(ctx.name().IDENTIFIER().getText(), FieldDecl, MethodDecl, null);

    }

    public static AST.FieldDecl generateFieldDecl (MiniJavaParser.FieldDeclContext ctx) {
        Type type = AST.getType(ctx.type());
        return new FieldDecl(ctx.name().IDENTIFIER().getText(), getType(ctx.type()));
    }

    public static Type getType (MiniJavaParser.TypeContext ctx) {
        if(ctx.INT() != null) {
            return type.INT;
        }
        if(ctx.CHAR() != null) {
            return type.CHAR;
        }
        if(ctx.BOOL() != null) {
            return  type.BOOL;
        }
        if(ctx.name() != null) {
            return type.REFERENCE(ctx.name().getText());
        }
        return null;
    }
}
