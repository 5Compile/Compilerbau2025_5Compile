package codegen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CodeGenUtils {

    public static String generateMethodDescriptor(List<Type> parameterTypes, Type returnType) {
        StringBuilder descriptor = new StringBuilder("(");
        for (Type paramType : parameterTypes) {
            descriptor.append(paramType.getDescriptor());
        }
        descriptor.append(")");
        descriptor.append(returnType.getDescriptor());
        return descriptor.toString();
    }

    public static void writeClassFile(byte[] bytecode, String className, String outputDir) throws IOException {
        Path outputPath = Path.of(outputDir, className + ".class");
        Files.createDirectories(outputPath.getParent());
        Files.write(outputPath, bytecode);
    }

    public static String getInternalName(String className) {
        return className.replace('.', '/');
    }
}