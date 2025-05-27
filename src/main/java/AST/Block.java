package AST;

import codegen.MethodContext;
import java.util.List;

public record Block(List<Statement> statements) implements MiniJava {

    public void codeGen(MethodContext methodContext) {
        for (Statement statement : statements) {
            statement.codeGen(methodContext);
        }
    }
}
