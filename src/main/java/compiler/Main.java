package compiler;

import compiler.ast.MiniJava;
import compiler.parser.AstBuilderVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import gen.MiniJavaLexer;
import gen.MiniJavaParser;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = Files.readString(Path.of("examples/HelloWorld.java"));

        CharStream charStream = CharStreams.fromString(input);
        MiniJavaLexer lexer = new MiniJavaLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);

        ParseTree tree = parser.program();

        AstBuilderVisitor visitor = new AstBuilderVisitor();
        MiniJava ast = visitor.visit(tree);

        System.out.println(ast); // Muss toString() im AST sinnvoll überschreiben
    }
}