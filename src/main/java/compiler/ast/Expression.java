package compiler.ast;

public sealed interface Expression extends MiniJava permits LocalOrFieldVar, InstVar,
        Unary, Binary, IntLiteral, BoolLiteral, CharLiteral, NullLiteral,
        Assign, New, MethodCall {
}
