package TypedAST.TypedClasses;

import AST.*;

public class TypeCheckVisitor implements Visitor {
    @Override
    public TypedAssign visit(Assign typedAssign) {

        return new TypedAssign();
    }

    @Override
    public TypedBinary visit(Binary typedBinary) {
        return new TypedBinary();
    }

    @Override
    public TypedBinaryOperator visit(BinaryOperator typedBinaryOperator) {
        return new TypedBinaryOperator();
    }

    @Override
    public TypedBlock visit(Block typedBlock) {
        return new TypedBlock();
    }

    @Override
    public TypedBoolLiteral visit(BoolLiteral typedBoolLiteral) {
        return new TypedBoolLiteral();
    }

    @Override
    public TypedCharLiteral visit(CharLiteral typedCharLiteral) {
        return new TypedCharLiteral();
    }

    @Override
    public TypedClassDecl visit(ClassDecl typedClassDecl) {
        return new TypedClassDecl();
    }

    @Override
    public TypedFieldDecl visit(FieldDecl typedFieldDecl) {
        return new TypedFieldDecl();
    }

    @Override
    public TypedIf visit(If typedIf) {
        return new TypedIf();
    }

    @Override
    public TypedInstVar visit(InstVar typedInstVar) {
        return new TypedInstVar();
    }

    @Override
    public TypedIntLiteral visit(IntLiteral typedIntLiteral) {
        return new TypedIntLiteral();
    }

    @Override
    public TypedLocalOrFieldVar visit(LocalOrFieldVar typedLocalOrFieldVar) {
        return new TypedLocalOrFieldVar();
    }

    @Override
    public TypedLocalVarDecl visit(LocalVarDecl typedLocalVarDecl) {
        return new TypedLocalVarDecl();
    }

    @Override
    public TypedMainMethodDecl visit(MainMethodDecl typedMainMethodDecl) {
        return new TypedMainMethodDecl();
    }

    @Override
    public TypedMethodCall visit(MethodCall typedMethodCall) {
        return new TypedMethodCall();
    }

    @Override
    public TypedMethodDecl visit(MethodDecl typedMethodDecl) {
        return new TypedMethodDecl();
    }

    @Override
    public TypedNew visit(New typedNew) {
        return new TypedNew();
    }

    @Override
    public TypedNullLiteral visit(NullLiteral typedNullLiteral) {
        return new TypedNullLiteral();
    }

    @Override
    public TypedParameter visit(Parameter typedParameter) {
        return new TypedParameter();
    }

    @Override
    public TypedPrintStmt visit(PrintStmt typedPrintStmt) {
        return new TypedPrintStmt();
    }

    @Override
    public TypedProgram visit(Program typedProgram) {
        return new TypedProgram();
    }

    @Override
    public TypedReturn visit(Return typedReturn) {
        return new TypedReturn();
    }

    @Override
    public TypedUnary visit(Unary typedUnary) {
        return new TypedUnary();
    }

    @Override
    public TypedUnaryOperator visit(UnaryOperator typedUnaryOperator) {
        return new TypedUnaryOperator();
    }

    @Override
    public TypedWhile visit(While typedWhile) {
        return new TypedWhile();
    }
}
