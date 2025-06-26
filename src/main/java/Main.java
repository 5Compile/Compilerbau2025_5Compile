import AST.ASTGenerator;
import AST.ClassDecl;
import TypedAST.ClassContext;
import TypedAST.TypedClasses.TypeCheckVisitor;
import TypedAST.TypedClasses.TypedClassDecl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.MiniJavaParser;
import parser.MiniJavaLexer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {

        String input1 = "public class Berechnung {}";


        List<ClassDecl> classes = new ArrayList<>();
        CharStream input = CharStreams.fromString(input1);
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        MiniJavaParser.ClassContext tree = parser.class_(); //Parsen
        ClassDecl decl = ASTGenerator.generateAST(tree);
        System.out.println("AST erzeugt!");

        TypeCheckVisitor visitor = new TypeCheckVisitor();
        TypedClassDecl typed = visitor.visit(decl);
        System.out.println("TypedAST erzeugt für: " + typed.getClass().getSimpleName());

        typed.setName("Berechnung");
        typed.setMainMethod(Optional.empty());

        byte[] bytecode = typed.codeGen(); // erzeugt mit ASM
        Files.write(Path.of("Berechnung.class"), bytecode);
        System.out.println("✅ Berechnung.class wurde erzeugt!");

    }
}