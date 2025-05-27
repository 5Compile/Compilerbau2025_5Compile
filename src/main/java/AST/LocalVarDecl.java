package AST;

import codegen.MethodContext;
import codegen.Type;

public record LocalVarDecl(String type, String name) implements Statement {

    @Override
    public void codeGen(MethodContext methodContext) {
        Type varType = Type.fromString(type);
        methodContext.allocateLocalVariable(name, varType);
    }
}