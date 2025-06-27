package TypedAST.TypedClasses;

import AST.*;
import TypedAST.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TypeCheckVisitor implements Visitor<TypedMiniJava> {
    List<TypedLocalVarDecl> localVarDecls = new ArrayList<>();
    List<TypedFieldDecl> fieldDecls = new ArrayList<>();
    List<TypedMethodDecl> declaredMethods = new ArrayList<>();
    Type currentMethodType = null;
    String currentMethodName = "";
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
    } //done

    @Override
    public TypedBinary visit(Binary binary) {
        TypedExpression typedLeft = (TypedExpression) binary.left().accept(TCVisitor);
        TypedExpression typedRight = (TypedExpression) binary.right().accept(TCVisitor);
        BinaryOperator operator = binary.operator();
        if (operator == BinaryOperator.PLUS || operator == BinaryOperator.MINUS || operator == BinaryOperator.TIMES || operator == BinaryOperator.MOD || operator == BinaryOperator.DIV) {
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
        }
        throw new RuntimeException("Unkown operator at binary operation");
    } //done

    @Override
    public TypedBlock visit(Block block) {

        boolean gotReturn = false;
        List<TypedStatement> typedList = new ArrayList<>();
        for(Statement stmt : block.statements()){
            typedList.add((TypedStatement) stmt.accept(TCVisitor));
        }

        for(TypedStatement typedStmt : typedList){
            if (typedStmt instanceof TypedLocalVarDecl){
                localVarDecls.add( (TypedLocalVarDecl) typedStmt);
            }
        }

        for(TypedStatement typedStmt : typedList){
            if (typedStmt instanceof TypedLocalVarDecl){
                localVarDecls.add(((TypedLocalVarDecl) typedStmt));
            } else if(typedStmt instanceof TypedAssign) {
                if(((TypedAssign) typedStmt).getTarget() instanceof TypedLocalVarDecl){
                    localVarDecls.add(((TypedLocalVarDecl) ((TypedAssign) typedStmt).getTarget()));
                }
            }
        }

        for(TypedStatement typedStmt : typedList){
            if (typedStmt instanceof TypedReturn){
                if(gotReturn){
                    throw new RuntimeException("detected 2 return statements in one block");
                }else
                    gotReturn = true;
            }
        }
        localVarDecls = new ArrayList<>();
        return new TypedBlock(typedList);
    } //maybe

    @Override
    public TypedBoolLiteral visit(BoolLiteral boolLiteral) {
        return new TypedBoolLiteral(boolLiteral.value());
    } //done

    @Override
    public TypedCharLiteral visit(CharLiteral charLiteral) {
        return new TypedCharLiteral(charLiteral.value());
    } //done

    @Override
    public TypedClassDecl visit(ClassDecl classDecl) {
        List<TypedMethodDecl> typedMethods = new ArrayList<>();
        for(FieldDecl fieldDecl : classDecl.fields()){
            fieldDecls.add( (TypedFieldDecl) fieldDecl.accept(TCVisitor));
        }
        for(TypedFieldDecl typedFieldDecl : fieldDecls){
            for(TypedFieldDecl iteratedFieldDecl : fieldDecls){
                if(typedFieldDecl != iteratedFieldDecl){
                    if(Objects.equals(typedFieldDecl.getName(), iteratedFieldDecl.getName())){
                        throw  new RuntimeException("Two fields have been declared with the same name");
                    }
                }
            }
        }
        for(MethodDecl methodDecl : classDecl.methods()){
            typedMethods.add( (TypedMethodDecl) methodDecl.accept(TCVisitor));
        }

        //hier wird kontrolliert, ob es Methoden mit gleichem Namen und Signatur gibt
        for(TypedMethodDecl typedMethodDecl : typedMethods){
            for(TypedMethodDecl iteratedMethodDecl : typedMethods){
                if(typedMethodDecl != iteratedMethodDecl){
                    if(Objects.equals(typedMethodDecl.getName(), iteratedMethodDecl.getName())){
                        if(typedMethodDecl.getParameters().size() == iteratedMethodDecl.getParameters().size()){
                            List<TypedParameter> remainParams = typedMethodDecl.getParameters();
                            for(TypedParameter remainParam : remainParams){
                                boolean hasBeenRemoved = false;
                                for(TypedParameter compareParameter : typedMethodDecl.getParameters()){
                                    if(!hasBeenRemoved){
                                        if(remainParam.getType() == compareParameter.getType()){
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
            return new TypedClassDecl(classDecl.name(), fieldDecls, typedMethods, typedMainMethodDecl);
        }else {
            return new TypedClassDecl(classDecl.name(), fieldDecls, typedMethods, null);
        }
    } //maybe

    @Override
    public TypedFieldDecl visit(FieldDecl fieldDecl) {

        Type type = switch (fieldDecl.type()) {
            case "int" -> Type.INT;
            case "boolean" -> Type.BOOL;
            case "char" -> Type.CHAR;
            default -> throw new RuntimeException("Error on defining Type of FieldDecl");
        };
        return new TypedFieldDecl(fieldDecl.name(), type);
    } //done

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
    } //maybe

    @Override
    public TypedInstVar visit(InstVar instVar) {
        return new TypedInstVar();
    } //(done)

    @Override
    public TypedIntLiteral visit(IntLiteral intLiteral) {
        return new TypedIntLiteral(intLiteral.value());
    } //done

    @Override
    public TypedLocalOrFieldVar visit(LocalOrFieldVar localOrFieldVar) {
        boolean isLocal = false;
        Type fittingType = null;
        for(TypedLocalVarDecl localDecl : localVarDecls){
            if(Objects.equals(localOrFieldVar.name(), localDecl.getName())){
                isLocal = true;
                fittingType = localDecl.getType();
            }
        }
        if(!isLocal){
            for(TypedFieldDecl fieldDecl : fieldDecls){
                if(Objects.equals(localOrFieldVar.name(), fieldDecl.getName())){
                    fittingType = fieldDecl.getType();
                }
            }
        }
        if(fittingType == null){
            throw new RuntimeException("A variable has been used that is not declared");
        }
        return new TypedLocalOrFieldVar(localOrFieldVar.name(), isLocal, fittingType);
    } //done

    @Override
    public TypedLocalVarDecl visit(LocalVarDecl localVarDecl) {
        Type type = switch (localVarDecl.type()) {
            case "int" -> Type.INT;
            case "boolean" -> Type.BOOL;
            case "char" -> Type.CHAR;
            default -> throw new RuntimeException("Error on defining Type of Method return Type");
        };
        return new TypedLocalVarDecl(localVarDecl.name(), type);
    } //done

    @Override
    public TypedMainMethodDecl visit(MainMethodDecl mainMethodDecl) {
        currentMethodType = Type.VOID;
        currentMethodName = "Main";
        TypedBlock typedBlock = (TypedBlock) mainMethodDecl.body().accept(TCVisitor);
        currentMethodType = null;
        currentMethodName = "";
        return new TypedMainMethodDecl(typedBlock);
    } //maybe

    @Override
    public TypedMethodCall visit(MethodCall methodCall) {
        List<TypedExpression> typedExpressions = new ArrayList<>();
        TypedMethodDecl match = null;
        for(TypedMethodDecl existingMethod : declaredMethods){
            if(Objects.equals(existingMethod.getName(), methodCall.methodName())){
                if(existingMethod.getParameters().size() == methodCall.arguments().size()){
                    boolean foundMatch = true;
                    for(int i = 0; i < existingMethod.getParameters().size(); i++){
                        Type declaredType = existingMethod.getParameters().get(i).getType();
                        Type actualType = methodCall.arguments().get(i).accept(TCVisitor).getType();

                        if (!declaredType.equals(actualType)) {
                            foundMatch = false;
                            break;
                        }
                    }
                    if(foundMatch){
                        match = existingMethod;
                        break;
                    }
                }

            }
        }
        if(match == null){
            throw new RuntimeException("Method " + methodCall.methodName() + " has never been declared");
        }
        for(Expression expression : methodCall.arguments()){
            typedExpressions.add( (TypedExpression) expression.accept(TCVisitor));
        }
        return new TypedMethodCall( (TypedExpression) methodCall.target().accept(TCVisitor), methodCall.methodName(), typedExpressions, match.getType());
    } //maybe

    @Override
    public TypedMethodDecl visit(MethodDecl methodDecl) {
        TypedMethodDecl typedMethodDecl;
        List<TypedParameter> typedParameterList = new ArrayList<>();
        Type type = switch (methodDecl.returnType()) {
            case "int" -> Type.INT;
            case "boolean" -> Type.BOOL;
            case "char" -> Type.CHAR;
            default -> throw new RuntimeException("Error on defining Type of Method return Type");
        };
        currentMethodType = type;
        currentMethodName = methodDecl.name();
        for (Parameter parameter: methodDecl.parameters())
        {
            typedParameterList.add( (TypedParameter) parameter.accept(TCVisitor));
        }
        if(type != methodDecl.body().accept(TCVisitor).getType()){
            throw new RuntimeException("Method " + methodDecl.name() +  " does not return the same type as its defined return");
        }
        typedMethodDecl = new TypedMethodDecl(methodDecl.name(), typedParameterList, (TypedBlock) methodDecl.body().accept(TCVisitor), type);
        currentMethodType = null;
        currentMethodName = "";
        declaredMethods.add(typedMethodDecl);
        return typedMethodDecl;
    } //maybe

    @Override
    public TypedNew visit(New newStmt) {
        throw new RuntimeException("New can not be Used");
    } //(done)

    @Override
    public TypedNullLiteral visit(NullLiteral nullLiteral) {
        return new TypedNullLiteral(Type.VOID);
    } //done

    @Override
    public TypedParameter visit(Parameter parameter) {
        Type paramType = switch (parameter.name()) {
            case "int" -> Type.INT;
            case "boolean" -> Type.BOOL;
            case "char" -> Type.CHAR;
            default -> throw new RuntimeException("Error on defining Type of Parameter");
        };
        return new TypedParameter(parameter.name(), paramType);
    } //done

    @Override
    public TypedPrintStmt visit(PrintStmt printStmt) {
        return new TypedPrintStmt( (TypedExpression) printStmt.expression().accept(TCVisitor));
    } //done

    @Override
    public TypedProgram visit(Program program) {
        List<TypedClassDecl> typedClasses = new ArrayList<>();
        //check for double classes
        for (ClassDecl classDecl : program.classes())
        {
            typedClasses.add( (TypedClassDecl) classDecl.accept(TCVisitor));
        }
        for(TypedClassDecl typedClassDecl : typedClasses){
            for(TypedClassDecl compareClassDecl : typedClasses){
                if(typedClassDecl != compareClassDecl){
                    if(Objects.equals(typedClassDecl.getName(), compareClassDecl.getName())){
                        throw new RuntimeException("Classname " + typedClassDecl.getName() + " has been declared twice");
                    }
                }
            }
        }
        return new TypedProgram(typedClasses);
    } //done

    @Override
    public TypedReturn visit(Return returnStmt) {
        Type retType;
        if(returnStmt.value() == null){
            retType = Type.VOID;
        }else{
            retType = returnStmt.value().accept(TCVisitor).getType();
        }
        if(retType == currentMethodType){
            if(retType == Type.VOID){
                return new TypedReturn();
            }else{
                return new TypedReturn(Optional.of( (TypedExpression) returnStmt.value().accept(TCVisitor)), returnStmt.value().accept(TCVisitor).getType());
            }
        }
        if (Objects.equals(currentMethodName, "Main")){
            throw new RuntimeException("Main Method must return void");
        }
        throw new RuntimeException("Return Type " + retType + " does not equal return type " + currentMethodType + " of method " + currentMethodName);
    } //done

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
    } //done

    @Override
    public TypedWhile visit(While whileStmt) {
        if(whileStmt.condition().accept(TCVisitor).getType() != Type.BOOL){
            throw new RuntimeException("No boolean type in while loop");
        }
        return new TypedWhile( (TypedExpression) whileStmt.condition().accept(TCVisitor), (TypedBlock) whileStmt.body().accept(TCVisitor));
    } //done
}
