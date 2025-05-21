package AST;

public sealed interface Expression permits BinaryOp, BoolLiteral, CharLiteral, FieldOrLocalVarAcc, IntLiteral, MethodCall, New, UnaryOp {
}
