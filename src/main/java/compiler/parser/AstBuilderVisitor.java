package compiler.parser;

import gen.MiniJavaParser;
import gen.MiniJavaBaseVisitor;
import compiler.ast.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.List;

public class AstBuilderVisitor extends MiniJavaBaseVisitor<compiler.ast.MiniJava> {

    @Override
    public MiniJava visitProgram(MiniJavaParser.ProgramContext ctx) {
        var classDecls = ctx.classDeclaration().stream()
                .map(this::visitClassDeclaration)
                .map(c -> (ClassDecl) c)
                .toList();
        return new Program(classDecls);
    }

    @Override
    public MiniJava visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.IDENTIFIER().getText();
        return new ClassDecl(className, List.of(), List.of());
    }
}
