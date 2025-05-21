package AST;

public sealed interface MiniJava permits
        Program, Class, FieldOrLocalVarAcc, Method,
        MainMethod, Parameter, Block {}
