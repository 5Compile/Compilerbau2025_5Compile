package TypedASTTests.Feature;

import TypedAST.Type;
import TypedAST.TypedClasses.*;

import java.util.List;
import java.util.Optional;

public class TypedAST_CompAssign {

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
    public static TypedProgram get() {
        // Methode increase
        List<TypedParameter> increaseParams = List.of(
                new TypedParameter("a", Type.INT)
        );

        List<TypedStatement> increaseStatements = List.of(
                new TypedAssign(
                        new TypedLocalOrFieldVar("a", true, Type.INT),
                        new TypedIntLiteral(1),
                        Type.INT
                ),
                new TypedReturn(
                        Optional.of(new TypedLocalOrFieldVar("a", true, Type.INT)),
                        Type.INT
                )
        );

        TypedMethodDecl increaseMethod = new TypedMethodDecl(
                "increase",
                increaseParams,
                new TypedBlock(increaseStatements),
                Type.INT
        );

        // Methode decrease
        List<TypedParameter> decreaseParams = List.of(
                new TypedParameter("a", Type.INT)
        );

        List<TypedStatement> decreaseStatements = List.of(
                new TypedAssign(
                        new TypedLocalOrFieldVar("a", true, Type.INT),
                        new TypedIntLiteral(1),
                        Type.INT
                )
                // Rückgabe fehlt (int-Rückgabetyp), sollte evtl. ergänzt werden!
        );

        TypedMethodDecl decreaseMethod = new TypedMethodDecl(
                "decrease",
                decreaseParams,
                new TypedBlock(decreaseStatements),
                Type.INT
        );

        // Leerer Konstruktor
        TypedMethodDecl constructor = new TypedMethodDecl(
                "CompAssign",
                List.of(),
                new TypedBlock(List.of()),
                Type.VOID
        );

        TypedClassDecl clazz = new TypedClassDecl(
                "CompAssign",
                List.of(),
                List.of(increaseMethod, decreaseMethod, constructor),
                Optional.empty()
        );

        return new TypedProgram(List.of(clazz));
    }
}
