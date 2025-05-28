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
	 * Visit a parse tree produced by {@link MiniJavaParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MiniJavaParser.NameContext ctx);
}