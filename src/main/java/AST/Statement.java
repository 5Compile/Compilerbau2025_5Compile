package AST;

import codegen.MethodContext;

public sealed interface Statement extends MiniJava permits LocalVarDecl, Return, While, If,
        PrintStmt, Assign, New, MethodCall {

    void codeGen(MethodContext methodContext);
}