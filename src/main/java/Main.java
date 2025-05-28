import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromString("public class testClass {}");
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        MiniJavaParser.ClassContext tree = parser.class_(); //Parsen
        //ExpressionCalculator calc = new ExpressionCalculator();
        //int ergebnis = calc.calculate(tree.expr()); // initiate walk of tree with listener
        tree.fieldDecl();

    }


}