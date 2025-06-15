package java.ASTTests;

import AST.Program;
import org.junit.Test;

import java.ASTTests.Feature.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ASTTests {

    @Test
    public void testClass(){
        // Wandelt mithilfe einer generateAST Methode leere Klasse in AST um
        Program resultAst = Compiler.generateASTFromFiles(List.of("src/test/java/testing_Files/Class.java"));
        // Prüft ob generierter AST übereinstimmt mit händisch übersetzter abstrakter Syntax
        assertEquals(AST_ClassDecl.get(), resultAst);
    }

}
