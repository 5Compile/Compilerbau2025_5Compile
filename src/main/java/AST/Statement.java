package AST;

public sealed interface Statement permits Block, Break, Continue, Declaration, DoWhile, For, IfElse, Print, Return, While {
}
