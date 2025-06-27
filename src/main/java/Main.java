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
        if (args.length == 0) {
            System.err.println("Usage: java -jar 5compile.jar <source-file>");
            System.exit(1);
        }
        
        String sourceFile = args[0];
        String input1 = Files.readString(Path.of(sourceFile));
        
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

        // Extract class name from AST or use default
        String className = (typed.getName() != null) ? typed.getName() : "GeneratedClass";
        
        // Ensure mainMethod is initialized
        if (typed.getMainMethod() == null) {
            typed.setMainMethod(Optional.empty());
        }
        
        byte[] bytecode = typed.codeGen(); // erzeugt mit ASM
        Files.write(Path.of(className + ".class"), bytecode);
        System.out.println("✅ " + className + ".class wurde erzeugt!");

    }
}