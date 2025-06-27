// Generated from C:/Users/Bernhard/IdeaProjects/Compilerbau2025_5Compile/src/main/antlr/MiniJava.g4 by ANTLR 4.13.2

package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(MiniJavaParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(MiniJavaParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mainmethodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMainmethodDecl(MiniJavaParser.MainmethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mainmethodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMainmethodDecl(MiniJavaParser.MainmethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(MiniJavaParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(MiniJavaParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MiniJavaParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MiniJavaParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MiniJavaParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MiniJavaParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#localVariable}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariable(MiniJavaParser.LocalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVariable}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariable(MiniJavaParser.LocalVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#localVariableWithInitialization}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableWithInitialization(MiniJavaParser.LocalVariableWithInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVariableWithInitialization}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableWithInitialization(MiniJavaParser.LocalVariableWithInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statementexpr}.
	 * @param ctx the parse tree
	 */
	void enterStatementexpr(MiniJavaParser.StatementexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statementexpr}.
	 * @param ctx the parse tree
	 */
	void exitStatementexpr(MiniJavaParser.StatementexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assignSign}.
	 * @param ctx the parse tree
	 */
	void enterAssignSign(MiniJavaParser.AssignSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assignSign}.
	 * @param ctx the parse tree
	 */
	void exitAssignSign(MiniJavaParser.AssignSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#incrDecr}.
	 * @param ctx the parse tree
	 */
	void enterIncrDecr(MiniJavaParser.IncrDecrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#incrDecr}.
	 * @param ctx the parse tree
	 */
	void exitIncrDecr(MiniJavaParser.IncrDecrContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#incr}.
	 * @param ctx the parse tree
	 */
	void enterIncr(MiniJavaParser.IncrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#incr}.
	 * @param ctx the parse tree
	 */
	void exitIncr(MiniJavaParser.IncrContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#decr}.
	 * @param ctx the parse tree
	 */
	void enterDecr(MiniJavaParser.DecrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#decr}.
	 * @param ctx the parse tree
	 */
	void exitDecr(MiniJavaParser.DecrContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(MiniJavaParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(MiniJavaParser.NewCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MiniJavaParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MiniJavaParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methName}.
	 * @param ctx the parse tree
	 */
	void enterMethName(MiniJavaParser.MethNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methName}.
	 * @param ctx the parse tree
	 */
	void exitMethName(MiniJavaParser.MethNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#recipient}.
	 * @param ctx the parse tree
	 */
	void enterRecipient(MiniJavaParser.RecipientContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#recipient}.
	 * @param ctx the parse tree
	 */
	void exitRecipient(MiniJavaParser.RecipientContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#ifCall}.
	 * @param ctx the parse tree
	 */
	void enterIfCall(MiniJavaParser.IfCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#ifCall}.
	 * @param ctx the parse tree
	 */
	void exitIfCall(MiniJavaParser.IfCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#elseIF}.
	 * @param ctx the parse tree
	 */
	void enterElseIF(MiniJavaParser.ElseIFContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#elseIF}.
	 * @param ctx the parse tree
	 */
	void exitElseIF(MiniJavaParser.ElseIFContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#fieldVarAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldVarAccess(MiniJavaParser.FieldVarAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#fieldVarAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldVarAccess(MiniJavaParser.FieldVarAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(MiniJavaParser.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(MiniJavaParser.UnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MiniJavaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MiniJavaParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(MiniJavaParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(MiniJavaParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStatement}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MiniJavaParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStatement}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MiniJavaParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(MiniJavaParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(MiniJavaParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupedExpr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpr(MiniJavaParser.GroupedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupedExpr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpr(MiniJavaParser.GroupedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(MiniJavaParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(MiniJavaParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(MiniJavaParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(MiniJavaParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(MiniJavaParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(MiniJavaParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#returntype}.
	 * @param ctx the parse tree
	 */
	void enterReturntype(MiniJavaParser.ReturntypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#returntype}.
	 * @param ctx the parse tree
	 */
	void exitReturntype(MiniJavaParser.ReturntypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(MiniJavaParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(MiniJavaParser.NameContext ctx);
}