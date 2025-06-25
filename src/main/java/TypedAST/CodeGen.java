package TypedAST;

/**
 * Interface for AST nodes that can generate bytecode.
 * All typed AST nodes should implement this interface.
 */
public interface CodeGen {
    /**
     * Generates bytecode for this AST node.
     * @param context The method context for bytecode generation
     */
    void codeGen(MethodContext context);
}