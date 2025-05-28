import AST.ClassDecl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<ClassDecl> classes = new ArrayList<>();
        CharStream input = CharStreams.fromString("public class testClass {int testdecl;}");
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        MiniJavaParser.ClassContext tree = parser.class_(); //Parsen
        classes.add(ASTGenerator.generateAST(tree));
    }
}