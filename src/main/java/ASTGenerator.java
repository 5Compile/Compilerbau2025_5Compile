import AST.FieldDecl;
import AST.MethodDecl;
import AST.Block;
import AST.Parameter;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ASTGenerator {
    public static AST.ClassDecl generateAST (MiniJavaParser.ClassContext ctx) {
        List<FieldDecl> FieldDecl = new ArrayList<AST.FieldDecl>();
        if(ctx.fieldDecl() != null) {
            FieldDecl = ctx.fieldDecl().stream().map(ASTGenerator::generateFieldDecl).toList();
        }
        List<MethodDecl> MethodDecl = new ArrayList<>();

        return new AST.ClassDecl(ctx.name().IDENTIFIER().getText(), FieldDecl, MethodDecl,null, null);
    }

    public static AST.FieldDecl generateFieldDecl (MiniJavaParser.FieldDeclContext ctx) {
        String type = getType(ctx.type());
        return new FieldDecl(getType(ctx.type()), ctx.name().IDENTIFIER().getText());
    }


    public static String getType (MiniJavaParser.TypeContext ctx) {
        if(ctx.INT() != null) {
            return "INT";
        }
        if(ctx.CHAR() != null) {
            return "CHAR";
        }
        if(ctx.BOOL() != null) {
            return  "BOOL";
        }
        if(ctx.name() != null) {
            return ctx.name().getText();
        }
        return null;
    } //TODO Type in den AST --> Wie das mit name




}
