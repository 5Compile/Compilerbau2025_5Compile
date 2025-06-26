import AST.ClassDecl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        String input1 = "public class ComplexTest { int x; boolean flag; public ComplexTest() { this.x = 10; flag = true; } public void compute(int a, int b) { int result; result = a + b * 2; if (result > 10) { print(result); } else { result = result - 1; } while (a < b) { a = a + 1; } do { result = result - 1; } while (result > 0); for (int i = 0; i < 5; i = i + 1) { print(i); } a++; b++; new ComplexTest(); someMethod(); return 123; } public static void main(String[] args) { print(42); } }";


        List<ClassDecl> classes = new ArrayList<>();
        CharStream input = CharStreams.fromString(input1);
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        MiniJavaParser.ClassContext tree = parser.class_(); //Parsen
        classes.add(ASTGenerator.generateAST(tree));
    }
}