package ASTTests.Feature;

import AST.*;

import java.util.List;
import java.util.Optional;

public class AST_CompAssign {

    /**
     *  public class CompAssign{
     *      public int increase(int a){
     *          a += 1;
     *          return a;
     *      }
     *      public int decrease(int a){
     *          a-= 1;
     *      }
     *  }
     */
    public static Program get() {
            // Methode increase
            List<Parameter> increaseParams = List.of(
                new Parameter("int", "a")
            );

            // Die zusammengesetzte Zuweisung a += 1 wird offenbar vom ASTGenerator als einfache Zuweisung umgewandelt
            List<Statement> increaseStatements = List.of(
                new Assign(
                    new LocalOrFieldVar("a"), 
                    new IntLiteral(1)
                ),
                new Return(new LocalOrFieldVar("a"))
            );

            MethodDecl increaseMethod = new MethodDecl(
                "increase",
                "int",
                increaseParams,
                new Block(increaseStatements)
            );

            // Methode decrease
            List<Parameter> decreaseParams = List.of(
                new Parameter("int", "a")
            );

            // Die zusammengesetzte Zuweisung a -= 1 wird offenbar vom ASTGenerator als einfache Zuweisung umgewandelt
            List<Statement> decreaseStatements = List.of(
                new Assign(
                    new LocalOrFieldVar("a"),
                    new IntLiteral(1)
                )
                // Hinweis: Es fehlt die return-Anweisung, obwohl ein Rückgabetyp int deklariert wurde
            );

            MethodDecl decreaseMethod = new MethodDecl(
                "decrease",
                "int",
                decreaseParams,
                new Block(decreaseStatements)
            );

            // Leerer Konstruktor - wird vom ASTGenerator am Ende hinzugefügt
            MethodDecl constructor = new MethodDecl(
                "CompAssign",
                "void",
                List.of(),
                new Block(List.of())
            );

            ClassDecl clazz = new ClassDecl(
                "CompAssign",
                List.of(),                                // keine Felder
                List.of(increaseMethod, decreaseMethod, constructor), // Reihenfolge wie im generierten AST
                Optional.empty()                          // keine main-Methode
        );

        return new Program(List.of(clazz));
    }
}
