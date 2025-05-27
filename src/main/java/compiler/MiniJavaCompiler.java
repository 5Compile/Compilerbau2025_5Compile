package compiler;

import AST.Program;
import parser.MiniJavaParser;

import java.io.IOException;
import java.nio.file.Path;

public class MiniJavaCompiler {

    private final MiniJavaParser parser;

    public MiniJavaCompiler() {
        this.parser = new MiniJavaParser();
    }

    public void compileFile(String javaFilePath, String outputDir) throws IOException {
        System.out.println("Compiling: " + javaFilePath);

        // Parse Java source file to AST
        Program program = parser.parseFile(javaFilePath);
        System.out.println("✓ Parsing completed");

        // Generate bytecode
        program.codeGen(outputDir);
        System.out.println("✓ Code generation completed");

        System.out.println("Compilation successful! Output directory: " + outputDir);
    }

    public void compileString(String javaCode, String outputDir) throws IOException {
        System.out.println("Compiling Java code...");

        // Parse Java source string to AST
        Program program = parser.parseContent(javaCode);
        System.out.println("✓ Parsing completed");

        // Generate bytecode
        program.codeGen(outputDir);
        System.out.println("✓ Code generation completed");

        System.out.println("Compilation successful! Output directory: " + outputDir);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java compiler.MiniJavaCompiler <input.java> [output_dir]");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputDir = args.length > 1 ? args[1] : ".";

        MiniJavaCompiler compiler = new MiniJavaCompiler();

        try {
            compiler.compileFile(inputFile, outputDir);
        } catch (IOException e) {
            System.err.println("Compilation failed: " + e.getMessage());
            System.exit(1);
        }
    }
}