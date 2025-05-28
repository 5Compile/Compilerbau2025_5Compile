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