package AST;

import java.util.List;

public record Block(List<Statement> statements) implements MiniJava {
}
