package TypedAST.TypedClasses;

import AST.*;

public interface Visitor<T> {
    T visit(Assign assign);
    T visit(Binary binary);
    T visit(Block block);
    T visit(BoolLiteral boolLiteral);
    T visit(CharLiteral charLiteral);
    T visit(ClassDecl classDecl);
    T visit(FieldDecl fieldDecl);
    T visit(If ifStmt);
    T visit(InstVar instVar);
    T visit(IntLiteral intLiteral);
    T visit(LocalOrFieldVar localOrFieldVar);
    T visit(LocalVarDecl localVarDecl);
    T visit(MainMethodDecl mainMethodDecl);
    T visit(MethodCall methodCall);
    T visit(MethodDecl methodDecl);
    T visit(New newStmt);
    T visit(NullLiteral nullLiteral);
    T visit(Parameter parameter);
    T visit(PrintStmt printStmt);
    T visit(Program program);
    T visit(Return returnStmt);
    T visit(Unary unary);
    T visit(While whileStmt);
}
