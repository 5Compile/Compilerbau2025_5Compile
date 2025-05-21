// Generated from C:/Users/sean0/IdeaProjects/Compilerbau2025_5Compile/src/main/java/MiniJava.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link MiniJavaParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(MiniJavaParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(MiniJavaParser.FieldContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#meth}.
	 * @param ctx the parse tree
	 */
	void enterMeth(MiniJavaParser.MethContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#meth}.
	 * @param ctx the parse tree
	 */
	void exitMeth(MiniJavaParser.MethContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mainmeth}.
	 * @param ctx the parse tree
	 */
	void enterMainmeth(MiniJavaParser.MainmethContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mainmeth}.
	 * @param ctx the parse tree
	 */
	void exitMainmeth(MiniJavaParser.MainmethContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MiniJavaParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MiniJavaParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MiniJavaParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MiniJavaParser.ParamContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#localVar}.
	 * @param ctx the parse tree
	 */
	void enterLocalVar(MiniJavaParser.LocalVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVar}.
	 * @param ctx the parse tree
	 */
	void exitLocalVar(MiniJavaParser.LocalVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#localVarWithInitialization}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarWithInitialization(MiniJavaParser.LocalVarWithInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVarWithInitialization}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarWithInitialization(MiniJavaParser.LocalVarWithInitializationContext ctx);
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
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf(MiniJavaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf(MiniJavaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code For}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor(MiniJavaParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code For}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor(MiniJavaParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MiniJavaParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MiniJavaParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhile}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(MiniJavaParser.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhile}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(MiniJavaParser.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Break}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak(MiniJavaParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak(MiniJavaParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue(MiniJavaParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue(MiniJavaParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVarDec}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDec(MiniJavaParser.LocalVarDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVarDec}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDec(MiniJavaParser.LocalVarDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVarDecWithInitialization}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecWithInitialization(MiniJavaParser.LocalVarDecWithInitializationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVarDecWithInitialization}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecWithInitialization(MiniJavaParser.LocalVarDecWithInitializationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpressionstmt}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionstmt(MiniJavaParser.StatementExpressionstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpressionstmt}
	 * labeled alternative in {@link MiniJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionstmt(MiniJavaParser.StatementExpressionstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MiniJavaParser#stmtexpr}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MiniJavaParser#stmtexpr}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code New}
	 * labeled alternative in {@link MiniJavaParser#stmtexpr}.
	 * @param ctx the parse tree
	 */
	void enterNew(MiniJavaParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code New}
	 * labeled alternative in {@link MiniJavaParser#stmtexpr}.
	 * @param ctx the parse tree
	 */
	void exitNew(MiniJavaParser.NewContext ctx);
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
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by the {@code StatementExpressionexpr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionexpr(MiniJavaParser.StatementExpressionexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpressionexpr}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionexpr(MiniJavaParser.StatementExpressionexprContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#methCall}.
	 * @param ctx the parse tree
	 */
	void enterMethCall(MiniJavaParser.MethCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methCall}.
	 * @param ctx the parse tree
	 */
	void exitMethCall(MiniJavaParser.MethCallContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#elseIf}.
	 * @param ctx the parse tree
	 */
	void enterElseIf(MiniJavaParser.ElseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#elseIf}.
	 * @param ctx the parse tree
	 */
	void exitElseIf(MiniJavaParser.ElseIfContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MiniJavaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MiniJavaParser.IdContext ctx);
}