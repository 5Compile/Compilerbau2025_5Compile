package AST;

import codegen.MethodContext;

public sealed interface Expression extends MiniJava permits LocalOrFieldVar, InstVar,
        Unary, Binary, IntLiteral, BoolLiteral, CharLiteral, NullLiteral,
        Assign, New, MethodCall {

    void codeGen(MethodContext methodContext);
}