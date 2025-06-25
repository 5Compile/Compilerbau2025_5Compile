package AST;

public sealed interface Statement extends MiniJava permits Assign, Break, Continue, DoWhile, For, If, LocalVarDecl, MethodCall, New, PrintStmt, Return, While {
}
