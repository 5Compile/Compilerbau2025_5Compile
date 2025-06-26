package ASTTests;

import AST.Program;
import org.junit.Test;

import ASTTests.Feature.*;
import java.util.List;
import AST.ASTGenerator;


import static org.junit.Assert.assertEquals;

public class ASTTests {
        // Für jeden Test gilt:
        // Wandelt mithilfe der generateAST Methode die entsprechende Klasse in AST um
        // Prüft ob generierter AST übereinstimmt mit händisch übersetzter abstrakter Syntax

    /*
     @Test
    public void testBreak() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/Break.java"));
        assertEquals(AST_Break.get(), resultAst);
    }
    */
    @Test
    public void testClassDecl() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/ClassDecl.java"));
        assertEquals(AST_ClassDecl.get(), resultAst);
    }

    @Test
    public void testComment() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/Comment.java"));
        assertEquals(AST_Comment.get(), resultAst);
    }

    @Test
    public void testCompAssign() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/CompAssign.java"));
        assertEquals(AST_CompAssign.get(), resultAst);
    }

    @Test
    public void testConstructor() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/Constructor.java"));
        assertEquals(AST_Constructor.get(), resultAst);
    }


    @Test
    public void testDataTypes() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/DataTypes.java"));
        assertEquals(AST_DataTypes.get(), resultAst);
    }

    @Test
    public void testFieldDecl() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/FieldDecl.java"));
        assertEquals(AST_FieldDecl.get(), resultAst);
    }
/*
    @Test
    public void testFor() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/For.java"));
        assertEquals(AST_For.get(), resultAst);
    }
    */


    @Test
    public void testIf() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/If.java"));
        assertEquals(AST_If.get(), resultAst);
    }
/*

/*
    @Test
    public void testIncDec() {
        Program resultAst = Compiler.generateASTFromFiles(List.of("src/test/testing_Files/IncDec.java"));
        assertEquals(AST_IncDec.get(), resultAst);
    }

 */

    @Test
    public void testExprLogic() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/ExprLogic.java"));
        System.out.println(resultAst);
        assertEquals(AST_ExprLogic.get(), resultAst);
    }
/*
    @Test
    public void testMain() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/Main.java"));
        assertEquals(AST_Main.get(), resultAst);
    }

 */

    @Test
    public void testMethod() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/Method.java"));
        assertEquals(AST_Method.get(), resultAst);
    }

    @Test
    public void testMethodCall() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/MethodCall.java"));
        System.out.println(resultAst);
        assertEquals(AST_MethodCall.get(), resultAst);
    }
/*
    @Test
    public void testOperators() {
        Program resultAst = Compiler.generateASTFromFiles(List.of("src/test/testing_Files/Operators.java"));
        assertEquals(AST_Operators.get(), resultAst);
    }
/*

    @Test
    public void testMethodReturn() {
        Program resultAst = ASTGenerator.generateASTFromFiles(List.of("src/test/testing_Files/MethodReturn.java"));
        assertEquals(AST_MethodReturn.get(), resultAst);
    }
 */




}
