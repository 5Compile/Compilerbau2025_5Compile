package compiler.ast;

import java.util.List;

public record New(String className, List<Expression> arguments) implements Statement, Expression {
}
