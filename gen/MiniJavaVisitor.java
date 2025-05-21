// Generated from C:/Users/sean0/IdeaProjects/Compilerbau2025_5Compile/src/main/java/MiniJava.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(MiniJavaParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(MiniJavaParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assignSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSign(MiniJavaParser.AssignSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#returntype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturntype(MiniJavaParser.ReturntypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#meth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeth(MiniJavaParser.MethContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mainmeth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainmeth(MiniJavaParser.MainmethContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(MiniJavaParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(MiniJavaParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(MiniJavaParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVar(MiniJavaParser.LocalVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVarWithInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarWithInitialization(MiniJavaParser.LocalVarWithInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MiniJavaParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MiniJavaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(MiniJavaParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MiniJavaParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhile}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(MiniJavaParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(MiniJavaParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(MiniJavaParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVarDec}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDec(MiniJavaParser.LocalVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVarDecWithInitialization}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecWithInitialization(MiniJavaParser.LocalVarDecWithInitializationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpressionstmt}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionstmt(MiniJavaParser.StatementExpressionstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MiniJavaParser#stmtexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code New}
	 * labeled alternative in {@link MiniJavaParser#stmtexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(MiniJavaParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperation(MiniJavaParser.UnaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MiniJavaParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(MiniJavaParser.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpressionexpr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionexpr(MiniJavaParser.StatementExpressionexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#binaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(MiniJavaParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(MiniJavaParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#fieldVarAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldVarAccess(MiniJavaParser.FieldVarAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#incrDecr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrDecr(MiniJavaParser.IncrDecrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#incr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncr(MiniJavaParser.IncrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#decr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecr(MiniJavaParser.DecrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethCall(MiniJavaParser.MethCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(MiniJavaParser.NewCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#recipient}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecipient(MiniJavaParser.RecipientContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethName(MiniJavaParser.MethNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MiniJavaParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCall(MiniJavaParser.IfCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#elseIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(MiniJavaParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MiniJavaParser.IdContext ctx);
}