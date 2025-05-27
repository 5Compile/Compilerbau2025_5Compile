package AST;

import codegen.CodeGenUtils;
import java.io.IOException;
import java.util.List;

public record Program(List<ClassDecl> classes) implements MiniJava {

    public void codeGen(String outputDir) throws IOException {
        for (ClassDecl classDecl : classes) {
            byte[] bytecode = classDecl.codeGen();
            CodeGenUtils.writeClassFile(bytecode, classDecl.name(), outputDir);
        }
    }
}