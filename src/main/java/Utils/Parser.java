package Utils;

import AST.*;
import TypedAST.TypedClasses.TypeCheckVisitor;
import TypedAST.TypedClasses.TypedClassDecl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.MiniJavaLexer;
import parser.MiniJavaParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Parser {

    public static byte[] generateBytecodeFromFile(String pathToFile) throws IOException {
        // Java-Datei einlesen
        CharStream input = CharStreams.fromPath(Path.of(pathToFile));

        // Lexer & Parser
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);

        // Parse → AST → TypedAST → Bytecode
        MiniJavaParser.ClassContext tree = parser.class_();
        ClassDecl decl = ASTGenerator.generateAST(tree);

        // Klassennamen aus dem AST lesen
        String className = decl.name(); // <-- automatisch ausgelesen

        TypeCheckVisitor visitor = new TypeCheckVisitor();
        TypedClassDecl typed = visitor.visit(decl);
        typed.setName(className);
        typed.setMainMethod(Optional.empty());

        // Bytecode generieren
        return typed.codeGen();
    }

    public static ClassDecl generateAST(MiniJavaParser.ClassContext ctx) {
        String className = ctx.IDENT().getText();

        // Felder
        List<FieldDecl> fields = new ArrayList<>();
        for (var fieldCtx : ctx.field()) {
            fields.add(generateField(fieldCtx));
        }

        // Methoden
        List<MethodDecl> methods = new ArrayList<>();
        for (var methodCtx : ctx.method()) {
            methods.add(generateMethod(methodCtx));
        }

        // Main-Methode
        Optional<MainMethodDecl> mainMethod = Optional.empty();
        if (ctx.main() != null) {
            mainMethod = Optional.of(generateMain(ctx.main()));
        }

        return new ClassDecl(className, fields, methods, mainMethod);
    }

}
