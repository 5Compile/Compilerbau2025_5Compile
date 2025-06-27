package Utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import AST.ASTGenerator;
import AST.ClassDecl;
import TypedAST.TypedClasses.TypeCheckVisitor;
import TypedAST.TypedClasses.TypedClassDecl;
import parser.MiniJavaLexer;
import parser.MiniJavaParser;

public class ParserUtil {
    /**
     * Liest den Inhalt einer übergebenen Datei ein, parst ihn,
     * generiert das TypedAST und gibt es aus.
     *
     * @param filePath Pfad zur Testdatei
     */
    public static void parseAndPrintTypedAST(String filePath) {
        try {
            // Dateiinhalt lesen
            CharStream input = CharStreams.fromPath(Path.of(filePath));

            // Lexer und Parser erzeugen
            MiniJavaLexer lexer = new MiniJavaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniJavaParser parser = new MiniJavaParser(tokens);

            // Parse-Baum erzeugen
            MiniJavaParser.ClassContext tree = parser.class_();

            // AST erzeugen
            ClassDecl decl = ASTGenerator.generateAST(tree);

            System.out.println("AST erzeugt!");

            // TypedAST erzeugen
            TypeCheckVisitor visitor = new TypeCheckVisitor();
            TypedClassDecl typed = visitor.visit(decl);

            // TypedAST ausgeben
            System.out.println("TypedAST erzeugt für: " + typed.getClass().getSimpleName());
            System.out.println(typed);

        } catch (Exception e) {
            System.err.println("Fehler beim Parsen oder Generieren des TypedAST:");
            e.printStackTrace();
        }
    }
}