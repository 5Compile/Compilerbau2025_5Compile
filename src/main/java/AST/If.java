package AST;

import codegen.MethodContext;
import java.util.Optional;

public record If(Expression condition, Block thenBranch, Optional<Block> elseBranch) implements Statement {

    @Override
    public void codeGen(MethodContext methodContext) {
        // TODO: Implement if statement
        if (condition != null) {
            condition.codeGen(methodContext);
        }
        if (thenBranch != null) {
            thenBranch.codeGen(methodContext);
        }
        if (elseBranch.isPresent()) {
            elseBranch.get().codeGen(methodContext);
        }
    }
}