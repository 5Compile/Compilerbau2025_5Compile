package compiler.ast;

import java.util.Optional;

public record If(Expression condition, Block thenBranch, Optional<Block> elseBranch) implements Statement {
}
