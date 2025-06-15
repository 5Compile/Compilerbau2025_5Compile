package AST;

import TypedAST.TypedClasses.Visitor;

public sealed interface Expression extends MiniJava permits LocalOrFieldVar, InstVar,
        Unary, Binary, IntLiteral, BoolLiteral, CharLiteral, NullLiteral,
        Assign, New, MethodCall {
    public <T> T toTyped(Visitor<T> visitor);
}
