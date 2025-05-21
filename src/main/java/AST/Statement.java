package AST;

public sealed interface Statement extends MiniJava permits LocalVarDecl, Return, While, If,
        PrintStmt, Assign, New, MethodCall {
}
