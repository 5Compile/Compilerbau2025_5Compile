// Generated from C:/Users/schuh/IdeaProjects/Compilerbau2025_5Compile/src/main/antlr/MiniJava.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mainmethodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainmethodDecl(MiniJavaParser.MainmethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(MiniJavaParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MiniJavaParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariable(MiniJavaParser.LocalVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVariableWithInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableWithInitialization(MiniJavaParser.LocalVariableWithInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MiniJavaParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statementexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementexpr(MiniJavaParser.StatementexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(MiniJavaParser.NewCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCall(MiniJavaParser.IfCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#elseIF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIF(MiniJavaParser.ElseIFContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(MiniJavaParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#returntype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturntype(MiniJavaParser.ReturntypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statemtexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemtexpr(MiniJavaParser.StatemtexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MiniJavaParser.ExprContext ctx);
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
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MiniJavaParser.NameContext ctx);
}