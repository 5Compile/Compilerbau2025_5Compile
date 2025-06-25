grammar MiniJava;

class : PUBLIC 'class' name '{' (fieldDecl | methodDecl | mainmethodDecl | constructor)* '}';

methodDecl : PUBLIC returntype name '(' parameters? ')' block;
mainmethodDecl : PUBLIC 'static' 'void' 'main' '(' 'String[] args' ')' block;
constructor : PUBLIC name '(' parameters? ')' block;

parameters : parameter (',' parameter)*;
parameter : type name;

block : '{' statement* return? '}';
return:     'return' expr ';'
            | 'return' ';'
;

statement : ifCall
    | 'for' '(' (assign | localVariableWithInitialization) ';' expr ';' assign ')' block
    | 'while' '(' expr ')' block
    | 'do' block 'while' '(' expr ')' ';'?
    | 'break' ';'
    | 'continue' ';'
    | localVariable ';'
    | localVariableWithInitialization ';'
    | assign ';'
    | 'print' '(' expr ')' ';'
    | statementexpr ';'
    ;

localVariable : type name;
localVariableWithInitialization : type name '=' expr;

statementexpr : methodCall
       | newCall
       ;

assign : fieldVarAccess assignSign expr | incrDecr;
assignSign : ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | MOD_ASSIGN | DIV_ASSIGN;

incrDecr : fieldVarAccess incr | fieldVarAccess decr;
incr : '++';
decr : '--';

methodCall : ((THIS '.') | (newCall '.'))? (recipient '.')* methName;
newCall : NEW type '(' args? ')';
args : expr (',' expr)*;

methName : name '(' args? ')';
recipient : methName | name;

ifCall : IF '(' expr ')' block (elseIF)* (ELSE block)?;
elseIF : ELSE IF '(' expr ')' block;

fieldVarAccess : ((THIS '.') | (newCall '.'))? (recipient '.')* name;

expr : expr binaryOp expr     #BinaryOperation
    | unaryOp expr           #UnaryOperation
    | literal                #Constant
    | '(' expr ')'           #GroupedExpr
    | fieldVarAccess         #FieldAccess
    | statementexpr          #ExprStatement
    ;

binaryOp : ADD | SUB | MUL | DIV | MOD | GT | LT | GE | LE | EQ | NE | AND | OR;
unaryOp : SUB | NOT;

literal : NUMBER | BOOLEANLITERAL | CHARLITERAL;

fieldDecl : PUBLIC? type name ';';
type : INT | BOOL | CHAR | name;
returntype : type | VOID;

name : IDENTIFIER;

BOOL : 'boolean';
CHAR : 'char';
INT : 'int';
VOID : 'void';

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
CHARLITERAL : '\'' [a-zA-Z] '\'';
IDENTIFIER : ([a-zA-Z]+[0-9]*)+;
NUMBER : [0-9]+;

WS : [ \t\r\n] -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;