package TypedAST.TypedClasses;

public interface TVisitor {
    void visit(TypedAssign typedAssign);
    void visit(TypedBinary typedBinary);
    void visit(TypedBinaryOperator typedBinaryOperator);
    void visit(TypedBlock typedBlock);
    void visit(TypedBoolLiteral typedBoolLiteral);
    void visit(TypedCharLiteral typedCharLiteral);
    void visit(TypedClassDecl typedClassDecl);
    void visit(TypedFieldDecl typedFieldDecl);
    void visit(TypedIf typedIf);
    void visit(TypedInstVar typedInstVar);
    void visit(TypedIntLiteral typedIntLiteral);
    void visit(TypedLocalOrFieldVar typedLocalOrFieldVar);
    void visit(TypedLocalVarDecl typedLocalVarDecl);
    void visit(TypedMainMethodDecl typedMainMethodDecl);
    void visit(TypedMethodCall typedMethodCall);
    void visit(TypedMethodDecl typedMethodDecl);
    void visit(TypedNew typedNew);
    void visit(TypedNullLiteral typedNullLiteral);
    void visit(TypedParameter typedParameter);
    void visit(TypedPrintStmt typedPrintStmt);
    void visit(TypedProgram typedProgram);
    void visit(TypedReturn typedReturn);
    void visit(TypedUnary typedUnary);
    void visit(TypedUnaryOperator typedUnaryOperator);
    void visit(TypedWhile typedWhile);
}
