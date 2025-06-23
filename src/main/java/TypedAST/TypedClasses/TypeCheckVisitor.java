package TypedAST.TypedClasses;

import AST.*;
import TypedAST.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckVisitor implements Visitor<TypedMiniJava> {
    TypeCheckVisitor TCVisitor;
    @Override
    public TypedAssign visit(Assign assign) {

        return new TypedAssign();
    }

    @Override
    public TypedBinary visit(Binary binary) {
        return new TypedBinary();
    }

    @Override
    public TypedBlock visit(Block block) {
        return new TypedBlock();
    }

    @Override
    public TypedBoolLiteral visit(BoolLiteral boolLiteral) {
        return new TypedBoolLiteral();
    }

    @Override
    public TypedCharLiteral visit(CharLiteral charLiteral) {
        return new TypedCharLiteral();
    }

    @Override
    public TypedClassDecl visit(ClassDecl classDecl) {
        return new TypedClassDecl();
    }

    @Override
    public TypedFieldDecl visit(FieldDecl fieldDecl) {

        Type type;
        switch (fieldDecl.type()) {
            case "int":
                type = Type.INT;
                break;
            case "boolean":
                type = Type.BOOL;
                break;
            case "char":
                type = Type.CHAR;
                break;
            default:
                throw new RuntimeException("Error on defining Type of FieldDecl");
        }
        return new TypedFieldDecl(fieldDecl.name(), type);
    }

    @Override
    public TypedIf visit(If ifStmt) {
        return new TypedIf();
    }

    @Override
    public TypedInstVar visit(InstVar instVar) {
        return new TypedInstVar();
    }

    @Override
    public TypedIntLiteral visit(IntLiteral intLiteral) {
        return new TypedIntLiteral();
    }

    @Override
    public TypedLocalOrFieldVar visit(LocalOrFieldVar localOrFieldVar) {
        return new TypedLocalOrFieldVar();
    }

    @Override
    public TypedLocalVarDecl visit(LocalVarDecl localVarDecl) {
        return new TypedLocalVarDecl();
    }

    @Override
    public TypedMainMethodDecl visit(MainMethodDecl mainMethodDecl) {
        return new TypedMainMethodDecl();
    }

    @Override
    public TypedMethodCall visit(MethodCall methodCall) {
        return new TypedMethodCall();
    }

    @Override
    public TypedMethodDecl visit(MethodDecl methodDecl) {
        List<TypedParameter> typedParameterList = new ArrayList<>();
        Type type;
        switch (methodDecl.returnType()) {
            case "int":
                type = Type.INT;
                break;
            case "boolean":
                type = Type.BOOL;
                break;
            case "char":
                type = Type.CHAR;
                break;
            default:
                throw new RuntimeException("Error on defining Type of Method return Type");
        }
        for (Parameter parameter: methodDecl.parameters())
        {
            typedParameterList.add( (TypedParameter) parameter.accept(TCVisitor));
        }
        return new TypedMethodDecl(methodDecl.name(), typedParameterList, (TypedBlock) methodDecl.body().accept(TCVisitor), type);
    }

    @Override
    public TypedNew visit(New newStmt) {
        return new TypedNew();
    }

    @Override
    public TypedNullLiteral visit(NullLiteral nullLiteral) {
        return new TypedNullLiteral();
    }

    @Override
    public TypedParameter visit(Parameter parameter) {
        Type paramType;
        switch (parameter.name()){
            case "int":
                paramType = Type.INT;
                break;
            case "boolean":
                paramType = Type.BOOL;
                break;
            case "char":
                paramType = Type.CHAR;
                break;
            default:
                throw new RuntimeException("Error on defining Type of Parameter");
        }
        return new TypedParameter();
    }

    @Override
    public TypedPrintStmt visit(PrintStmt printStmt) {
        return new TypedPrintStmt();
    }

    @Override
    public TypedProgram visit(Program program) {

        /* check for double classes
        for (TypedClassDecl currentClass : classes)
        {
            for(TypedClassDecl compareClass  : classes){
                if(currentClass == compareClass){
                    return;
                }else if(currentClass.getName().equals(compareClass.getName())){
                    throw new RuntimeException("Class Name " + currentClass.getName() + " is declared multiple times!");
                }
            }
        } */
        return new TypedProgram();
    }

    @Override
    public TypedReturn visit(Return returnStmt) {
        return new TypedReturn();
    }

    @Override
    public TypedUnary visit(Unary unary) {
        return new TypedUnary();
    }

    @Override
    public TypedWhile visit(While whileStmt) {
        return new TypedWhile();
    }
}
