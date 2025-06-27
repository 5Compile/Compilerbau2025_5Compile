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

        String input1 = "public class ComplexExample {\n" +
                "\n" +
                "    int counter;\n" +
                "    boolean active;\n" +
                "    char name;\n" +
                "\n" +
                "    public static void main(String[] args){\n" +
                "        counter = 0;\n" +
                "        active = true;\n" +
                "        name = 'C';\n" +
                "    }\n" +
                "\n" +
                "    public int getCounter() {\n" +
                "        return counter;\n" +
                "    }\n" +
                "\n" +
                "    public void incrementCounter() {\n" +
                "        counter++;\n" +
                "    }\n" +
                "\n" +
                "    public boolean isActive() {\n" +
                "        return active;\n" +
                "    }\n" +
                "\n" +
                "    public void deactivate() {\n" +
                "        active = false;\n" +
                "    }\n" +
                "\n" +
                "    public char getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void updateName(char newName) {\n" +
                "        name = newName;\n" +
                "    }\n" +
                "\n" +
                "    public int calculateArea(int width, int height) {\n" +
                "        return width * height;\n" +
                "    }\n" +
                "}";


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