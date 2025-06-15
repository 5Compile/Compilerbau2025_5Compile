package AST;

import TypedAST.TypedClasses.Visitor;

public sealed interface MiniJava permits Block, ClassDecl, Expression, FieldDecl, MainMethodDecl, MethodDecl, Parameter, Program, Statement {
    public <T> T toTyped(Visitor<T> visitor);
}
