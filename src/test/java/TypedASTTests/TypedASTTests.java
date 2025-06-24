package java.TypedASTTests;

import TypedAST.TypedClasses.TypedProgram;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.ASTTests.Feature.*;

public class TypedASTTests {

    // Für jeden Test gilt:
    // Wandelt mithilfe der generateTypedASTFromAst Methode den entsprechenden AST in TypedAST um
    // Prüft ob generierter TypedAST übereinstimmt mit händisch übersetzter typed abstrakter Syntax

    @Test
    public void testBreak() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_Break.get());
        assertEquals(TypedAST_Break.get(), resultTypedAst);
    }
    @Test
    public void testClassDecl() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_ClassDecl.get());
        assertEquals(TypedAST_ClassDecl.get(), resultTypedAst);
    }
    @Test
    public void testComment() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_Comment.get());
        assertEquals(TypedAST_Comment.get(), resultTypedAst);
    }
    @Test
    public void testCompAssign() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_CompAssign.get());
        assertEquals(TypedAST_CompAssign.get(), resultTypedAst);
    }
    @Test
    public void testConstructor() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_Constructor.get());
        assertEquals(TypedAST_Constructor.get(), resultTypedAst);
    }
    @Test
    public void testDataTypes() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_DataTypes.get());
        assertEquals(TypedAST_DataTypes.get(), resultTypedAst);
    }
    @Test
    public void testFieldDecl() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_FieldDecl.get());
        assertEquals(TypedAST_FieldDecl.get(), resultTypedAst);
    }
    @Test
    public void testFor() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_For.get());
        assertEquals(TypedAST_For.get(), resultTypedAst);
    }
    @Test
    public void testIf() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_If.get());
        assertEquals(TypedAST_If.get(), resultTypedAst);
    }
    @Test
    public void testIncDec() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_IncDec.get());
        assertEquals(TypedAST_IncDec.get(), resultTypedAst);
    }
    @Test
    public void testExprLogic() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_ExprLogic.get());
        assertEquals(TypedAST_ExprLogic.get(), resultTypedAst);
    }
    @Test
    public void testMain() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_Main.get());
        assertEquals(TypedAST_Main.get(), resultTypedAst);
    }
    @Test
    public void testMethod() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_Method.get());
        assertEquals(TypedAST_Method.get(), resultTypedAst);
    }
    @Test
    public void testMethodCall() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_MethodCall.get());
        assertEquals(TypedAST_MethodCall.get(), resultTypedAst);
    }
    @Test
    public void testOperators() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_Operators.get());
        assertEquals(TypedAST_Operators.get(), resultTypedAst);
    }
    @Test
    public void testMethodReturn() {
        TypedProgram resultTypedAst = Compiler.generateTypedASTFromAst(AST_MethodReturn.get());
        assertEquals(TypedAST_MethodReturn.get(), resultTypedAst);
    }

}
