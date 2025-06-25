package TypedAST.TypedClasses;

import AST.*;
import TypedAST.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TypeCheckVisitor implements Visitor<TypedMiniJava> {
    TypeCheckVisitor TCVisitor;
    @Override
    public TypedAssign visit(Assign assign) {
        TypedExpression typedTarget = (TypedExpression) assign.target().accept(TCVisitor);
        TypedExpression typedValue = (TypedExpression) assign.value().accept(TCVisitor);
        Type type;
        if(typedTarget.getType() == typedValue.getType() && typedTarget.getType() != null){
            type = typedTarget.getType();
        }else{
            throw new RuntimeException("The 2 Types used in an Assign are not Equal");
        }
        return new TypedAssign(typedTarget, typedValue, type);
    }

    @Override
    public TypedBinary visit(Binary binary) {
        TypedExpression typedLeft = (TypedExpression) binary.left().accept(TCVisitor);
        TypedExpression typedRight = (TypedExpression) binary.right().accept(TCVisitor);
        BinaryOperator operator = binary.operator();
        if (operator == BinaryOperator.PLUS || operator == BinaryOperator.MINUS || operator == BinaryOperator.TIMES) {
            if (typedLeft.getType() == Type.INT && typedRight.getType() == Type.INT) {
                return new TypedBinary(typedLeft, typedRight, operator, typedLeft.getType());
            } else {
                throw new RuntimeException(typedLeft.getType() + "does not equal" + typedRight.getType() + "or does not work with operator" + operator);
            }
        } else if (operator == BinaryOperator.GT || operator == BinaryOperator.LT || operator == BinaryOperator.GTE || operator == BinaryOperator.LTE) {
            if (typedLeft.getType() == typedRight.getType() && typedRight.getType() == Type.INT) {
                return new TypedBinary(typedLeft, typedRight, operator, Type.BOOL);
            } else {
                throw new RuntimeException(typedLeft.getType() + "does not equal" + typedRight.getType() + "or does not work with operator" + operator);
            }
        } else if (operator == BinaryOperator.EQ || operator == BinaryOperator.NEQ ) {
            if (typedLeft.getType() == typedRight.getType() && typedRight.getType() == Type.INT || typedLeft.getType() == typedRight.getType() && typedRight.getType() == Type.BOOL
                    || typedLeft.getType() == typedRight.getType() && typedRight.getType() == Type.CHAR) {
                return new TypedBinary(typedLeft, typedRight, operator, Type.BOOL);
            } else {
                throw new RuntimeException(typedLeft.getType() + "does not equal" + typedRight.getType() + "or does not work with operator" + operator);
            }
        } else if (operator == BinaryOperator.AND || operator == BinaryOperator.OR ){
            if (typedLeft.getType() == typedRight.getType() && typedRight.getType() == Type.BOOL) {
                return new TypedBinary(typedLeft, typedRight, operator, typedRight.getType());
            } else {
                throw new RuntimeException(typedLeft.getType() + "does not equal" + typedRight.getType() + "or does not work with operator" + operator);
            }
        } else if (operator == BinaryOperator.MOD || operator == BinaryOperator.DIV ){
            if (typedLeft.getType() == typedRight.getType() && typedRight.getType() == Type.INT) {
                return new TypedBinary(typedLeft, typedRight, operator, typedRight.getType());
            } else {
                throw new RuntimeException(typedLeft.getType() + "does not equal" + typedRight.getType() + "or does not work with operator" + operator);
            }
        }
        throw new RuntimeException("Unkown operator at binary operation");
    }

    @Override
    public TypedBlock visit(Block block) {
        Type posType = null;
        boolean gotReturn = false;
        List<TypedStatement> typedList = new ArrayList<>();
        for(Statement stmt : block.statements()){
            typedList.add((TypedStatement) stmt.accept(TCVisitor));
        }
        for(TypedStatement typedStmt : typedList){
            if (typedStmt instanceof TypedReturn){
                if(gotReturn){
                    throw new RuntimeException("detected 2 return statements in one block");
                }else
                    gotReturn = true;
                posType = typedStmt.getType();
            }
        }
        return new TypedBlock(typedList, posType);
    }

    @Override
    public TypedBoolLiteral visit(BoolLiteral boolLiteral) {
        return new TypedBoolLiteral(boolLiteral.value());
    }

    @Override
    public TypedCharLiteral visit(CharLiteral charLiteral) {
        return new TypedCharLiteral(charLiteral.value());
    }

    @Override
    public TypedClassDecl visit(ClassDecl classDecl) {
        List<TypedFieldDecl> typedFields = new ArrayList<>();
        List<TypedMethodDecl> typedMethods = new ArrayList<>();
        for(FieldDecl fieldDecl : classDecl.fields()){
            typedFields.add( (TypedFieldDecl) fieldDecl.accept(TCVisitor));
        }
        for(TypedFieldDecl typedFieldDecl : typedFields){
            for(TypedFieldDecl iteratedFieldDecl : typedFields){
                if(typedFieldDecl != iteratedFieldDecl){
                    if(Objects.equals(typedFieldDecl.name, iteratedFieldDecl.name)){
                        throw  new RuntimeException("Two fields have been declared with the same name");
                    }
                }
            }
        }
        for(MethodDecl methodDecl : classDecl.methods()){
            typedMethods.add( (TypedMethodDecl) methodDecl.accept(TCVisitor));
        }

        //hier wird kontrolliert, ob es Klassen mit gleichem Namen und Signatur gibt
        for(TypedMethodDecl typedMethodDecl : typedMethods){
            for(TypedMethodDecl iteratedMethodDecl : typedMethods){
                if(typedMethodDecl != iteratedMethodDecl){
                    if(Objects.equals(typedMethodDecl.name, iteratedMethodDecl.name)){
                        if(typedMethodDecl.parameters.size() == iteratedMethodDecl.parameters.size()){
                            List<TypedParameter> remainParams = typedMethodDecl.parameters;
                            for(TypedParameter remainParam : remainParams){
                                boolean hasBeenRemoved = false;
                                for(TypedParameter compareParameter : typedMethodDecl.parameters){
                                    if(!hasBeenRemoved){
                                        if(remainParam.type == compareParameter.type){
                                            remainParams.remove(remainParam);
                                            hasBeenRemoved = true;
                                        }
                                    }
                                }
                            }
                            if(remainParams.isEmpty()){
                                throw  new RuntimeException("Two methods have been declared with the same name and signature");
                            }
                        }
                    }
                }
            }
        }
        if (classDecl.mainMethod().isPresent()){
            Optional<TypedMainMethodDecl> typedMainMethodDecl = Optional.ofNullable( (TypedMainMethodDecl) classDecl.mainMethod().get().accept(TCVisitor));
            return new TypedClassDecl(classDecl.name(), typedFields, typedMethods, typedMainMethodDecl); //TODO unsicher ob void passt
        }else {
            return new TypedClassDecl(classDecl.name(), typedFields, typedMethods, null); //TODO unsicher ob void passt
        }
    }

    @Override
    public TypedFieldDecl visit(FieldDecl fieldDecl) {

        Type type = switch (fieldDecl.type()) {
            case "int" -> Type.INT;
            case "boolean" -> Type.BOOL;
            case "char" -> Type.CHAR;
            default -> throw new RuntimeException("Error on defining Type of FieldDecl");
        };
        return new TypedFieldDecl(fieldDecl.name(), type);
    }

    @Override
    public TypedIf visit(If ifStmt) {
        TypedExpression typedCond = (TypedExpression) ifStmt.condition().accept(TCVisitor);
        if(typedCond.getType() != Type.BOOL){
            throw new RuntimeException("No boolean in if stmt detected");
        }
        if (ifStmt.elseBranch().isPresent()){
            Optional<TypedBlock> typedElseBlock = Optional.ofNullable( (TypedBlock) ifStmt.elseBranch().get().accept(TCVisitor));
            return new TypedIf(typedCond, (TypedBlock) ifStmt.thenBranch().accept(TCVisitor), typedElseBlock);
        }else {
            return new TypedIf(typedCond, (TypedBlock) ifStmt.thenBranch().accept(TCVisitor), null);
        }
    }

    @Override
    public TypedInstVar visit(InstVar instVar) {
        TypedExpression = instVar.target()
        return new TypedInstVar();
    }

    @Override
    public TypedIntLiteral visit(IntLiteral intLiteral) {
        return new TypedIntLiteral(intLiteral.value());
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
        return new TypedMainMethodDecl( (TypedBlock) mainMethodDecl.body().accept(TCVisitor));
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
        return new TypedParameter(parameter.name(), paramType);
    }

    @Override
    public TypedPrintStmt visit(PrintStmt printStmt) {
        return new TypedPrintStmt( (TypedExpression) printStmt.expression().accept(TCVisitor));
    }

    @Override
    public TypedProgram visit(Program program) {
        List<TypedClassDecl> typedClasses = new ArrayList<>();
        //check for double classes
        program.classes();
        for (ClassDecl classDecl : program.classes())
        {
            typedClasses.add( (TypedClassDecl) classDecl.accept(TCVisitor));
        }
        for(TypedClassDecl typedClassDecl : typedClasses){
            for(TypedClassDecl compareClassDecl : typedClasses){
                if(typedClassDecl != compareClassDecl){
                    if(Objects.equals(typedClassDecl.name, compareClassDecl.name)){
                        throw new RuntimeException("Classname " + typedClassDecl.name + " has been declared twice");
                    }
                }
            }
        }
        return new TypedProgram(typedClasses);
    }

    @Override
    public TypedReturn visit(Return returnStmt) {
        return new TypedReturn( (TypedExpression) returnStmt.value().accept(TCVisitor), ((TypedExpression) returnStmt.value().accept(TCVisitor)).getType());
    }

    @Override
    public TypedUnary visit(Unary unary) {
        if (unary.operator() == UnaryOperator.NOT) {
            if (unary.operand().accept(TCVisitor).getType() != Type.BOOL) {
                throw new RuntimeException(unary.operator() + "does not fit with" + unary.operand());
            }
            return new TypedUnary( (TypedExpression) unary.operand().accept(TCVisitor), unary.operator(), Type.BOOL);
        }

        if (unary.operator() == UnaryOperator.NEG) {
            if (unary.operand().accept(TCVisitor).getType() != Type.INT) {
                throw new RuntimeException(unary.operator() + "does not fit with" + unary.operand());
            }
            return new TypedUnary( (TypedExpression) unary.operand().accept(TCVisitor), unary.operator(), Type.BOOL);
        }
        throw new RuntimeException("Unknown unary operator");
    }

    @Override
    public TypedWhile visit(While whileStmt) {
        return new TypedWhile();
    }
}
