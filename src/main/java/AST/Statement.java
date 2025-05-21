package AST;

public sealed interface Statement extends MiniJava permits
        Block,
        Break,
        Continue,
        Declaration,
        DoWhile,
        For,
        If,
        Print,
        Return,
        While {}
