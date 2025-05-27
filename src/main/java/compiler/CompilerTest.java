package compiler;

import java.io.IOException;

public class CompilerTest {

    public static void main(String[] args) {
        MiniJavaCompiler compiler = new MiniJavaCompiler();

        System.out.println("=== Testing MiniJava Compiler ===\n");

        // Test 1: Empty class from string
        testEmptyClassFromString(compiler);

        // Test 2: Simple class from string
        testSimpleClassFromString(compiler);

        // Test 3: Compile from file (if files exist)
        testFromFile(compiler);
    }

    private static void testEmptyClassFromString(MiniJavaCompiler compiler) {
        System.out.println("Test 1: Empty Class from String");
        System.out.println("--------------------------------");

        String emptyClass = """
            class TestEmpty {
            }
            """;

        try {
            compiler.compileString(emptyClass, "./output");
            System.out.println("✓ Empty class compilation successful!\n");
        } catch (IOException e) {
            System.err.println("✗ Empty class compilation failed: " + e.getMessage() + "\n");
        }
    }

    private static void testSimpleClassFromString(MiniJavaCompiler compiler) {
        System.out.println("Test 2: Simple Class with Field and Methods");
        System.out.println("------------------------------------------");

        String simpleClass = """
            class TestSimple {
                int number;
                
                public void setNumber(int value) {
                }
                
                public static void main(String[] args) {
                }
            }
            """;

        try {
            compiler.compileString(simpleClass, "./output");
            System.out.println("✓ Simple class compilation successful!\n");
        } catch (IOException e) {
            System.err.println("✗ Simple class compilation failed: " + e.getMessage() + "\n");
        }
    }

    private static void testFromFile(MiniJavaCompiler compiler) {
        System.out.println("Test 3: Compile from File");
        System.out.println("-------------------------");

        try {
            compiler.compileFile("test-files/EmptyClass.java", "./output");
            System.out.println("✓ File compilation successful!\n");
        } catch (IOException e) {
            System.err.println("✗ File compilation failed: " + e.getMessage() + "\n");
        }
    }
}