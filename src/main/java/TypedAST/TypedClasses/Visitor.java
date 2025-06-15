package TypedAST.TypedClasses;

import AST.*;

public interface Visitor<T> {
    T visit(Assign typedAssign);
    T visit(Binary typedBinary);
    T visit(BinaryOperator typedBinaryOperator);
    T visit(Block typedBlock);
    T visit(BoolLiteral typedBoolLiteral);
    T visit(CharLiteral typedCharLiteral);
    T visit(ClassDecl typedClassDecl);
    T visit(FieldDecl typedFieldDecl);
    T visit(If typedIf);
    T visit(InstVar typedInstVar);
    T visit(IntLiteral typedIntLiteral);
    T visit(LocalOrFieldVar typedLocalOrFieldVar);
    T visit(LocalVarDecl typedLocalVarDecl);
    T visit(MainMethodDecl typedMainMethodDecl);
    T visit(MethodCall typedMethodCall);
    T visit(MethodDecl typedMethodDecl);
    T visit(New typedNew);
    T visit(NullLiteral typedNullLiteral);
    T visit(Parameter typedParameter);
    T visit(PrintStmt typedPrintStmt);
    T visit(Program typedProgram);
    T visit(Return typedReturn);
    T visit(Unary typedUnary);
    T visit(UnaryOperator typedUnaryOperator);
    T visit(While typedWhile);
}
