package AST;

import TypedAST.TypedClasses.Visitor;

public sealed interface Statement extends MiniJava permits LocalVarDecl, Return, While, If,
        PrintStmt, Assign, New, MethodCall {
    public <T> T accept(Visitor<T> visitor);
}
