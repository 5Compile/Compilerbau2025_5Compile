package AST;

import java.util.List;

public record Block(List<Statement> stmts) implements Statement{

}
