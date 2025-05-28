grammar MiniJava;


class : PUBLIC 'class' name '{' (fieldDecl)* '}';

methodDecl : PUBLIC returntype name '(' parameters? ')' block;
mainmethodDecl : PUBLIC 'static' 'void' 'main' '(' 'String[] args' ')' block;
constructor: PUBLIC name '(' parameters ')' block;

parameters : parameter (',' parameter)*;
parameter : type name ;
localVariable : type name;
localVariableWithInitialization: type name '=' expr;

block: '{' (statement)* return? ')';
return: 'return' expr ';'
        | 'return' ';' ;

assign : 'todo';
statementexpr : 'todo';
newCall : 'todo';
methodCall: 'todo';

ifCall: IF '(' expr ')' block (elseIF)* (ELSE block)?;
elseIF: ELSE IF '(' expr ')' block;

fieldDecl : PUBLIC? type name ';';
type : INT | BOOL | CHAR | name;
returntype : type | VOID;

statement : ifCall
        | 'for' '(' (assign | localVariableWithInitialization) ';' expr ';' assign ')' block
        | 'while' '(' expr ')' block
        | 'do' block 'while' '(' expr ')' ';'?
        | 'break' ';'
        | 'continue' ';'
        | localVariable ';'
        | localVariableWithInitialization ';'
        | assign ';'
        | 'printStmt' '(' expr ')' ';'
        | statementexpr ';';

statemtexpr : methodCall
        | newCall ;

expr : expr binaryOp expr
        | unaryOp expr
        | literal
        | '(' expr ')'
        | statemtexpr ;

binaryOp : ADD | SUB | MUL | DIV | MOD | GT | LT | GE | LE | EQ | EQ | NE | AND | OR ;
unaryOp : SUB | NOT ;

literal : NUMBER | BOOLEANLITERAL | CHARLITEARAL ;

name : IDENTIFIER;


BOOL : 'boolean';
CHAR : 'char';
INT : 'int';
VOID : 'Void';

PUBLIC : 'public';
NEW: 'new';
NULL: 'null';
THIS: 'this';

IF : 'if';
ELSE : 'else';

SUB : '-' ;
ADD : '+' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
GT : '>' ;
LT : '<' ;
GE : '>=' ;
LE : '<=' ;
EQ : '==' ;
NE : '!=' ;
AND : '&&' ;
OR : '||' ;

ASSIGN : '=' ;
ADD_ASSIGN : '+=' ;
SUB_ASSIGN : '-=' ;
MUL_ASSIGN : '*=' ;
MOD_ASSIGN : '%=' ;
DIV_ASSIGN : '/=' ;

NOT : '!' ;

BOOLEANLITERAL : 'true' | 'false';
CHARLITEARAL : ['][a-zA-Z]['];
IDENTIFIER : ([a-zA-Z]+[0-9]*)+;
NUMBER : [0-9]+;
WS : [ \t\r\n] -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;



