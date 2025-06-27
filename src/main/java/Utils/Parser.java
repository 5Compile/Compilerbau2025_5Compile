package Utils;

import AST.*;
import TypedAST.TypedClasses.TypeCheckVisitor;
import TypedAST.TypedClasses.TypedClassDecl;
import TypedAST.TypedClasses.TypedProgram;
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

import static AST.ASTGenerator.*;

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
        String className = ctx.name().IDENTIFIER().getText();

        List<FieldDecl> fields = new ArrayList<>();
        if (ctx.fieldDecl() != null) {
            for (var fieldCtx : ctx.fieldDecl()) {
                fields.add(generateFieldDecl(fieldCtx));
            }
        }

        List<MethodDecl> methods = new ArrayList<>();
        if (ctx.methodDecl() != null) {
            for (var methodCtx : ctx.methodDecl()) {
                methods.add(generateMethodDecl(methodCtx));
            }
        }

        Optional<MainMethodDecl> mainMethod = Optional.empty();
        if (ctx.mainmethodDecl() != null && !ctx.mainmethodDecl().isEmpty()) {
            mainMethod = Optional.of(generateMainMethodDecl(ctx.mainmethodDecl(0)));
        }

        return new ClassDecl(className, fields, methods, mainMethod);
    }

    public static TypedProgram generateTypedASTFromAst(Program ast) {
        TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor();
        List<TypedClassDecl> typedClasses = new ArrayList<>();

        // Jeder Klassenknoten des AST wird besucht und in einen TypedAST-Knoten konvertiert
        for (ClassDecl classDecl : ast.classes()) {
            TypedClassDecl typedClass = typeCheckVisitor.visit(classDecl);
            typedClasses.add(typedClass);
        }

        // Ein neues TypedProgram mit den generierten TypedClassDecl-Knoten zurückgeben
        return new TypedProgram(typedClasses);
    }




}
