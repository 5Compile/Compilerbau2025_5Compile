grammar MiniJava;


class : PUBLIC 'class' id '{' (field | meth | mainmeth | constructor)* '}';

field : PUBLIC? type id ';';
assignSign : ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | MOD_ASSIGN | DIV_ASSIGN;
returntype : type | VOID;
type : INT | BOOL | CHAR | id;

meth : PUBLIC returntype id '(' params? ')' block;
mainmeth : PUBLIC 'static' 'void' 'main' '(' 'String[] args' ')' block;
constructor: PUBLIC id '(' params? ')' block;
params : param (',' param)*;
param : type id;

block : '{' (stmt)* return? '}';
localVar : type id;
localVarWithInitialization: type id '=' expr;
return:     'return' expr ';'
            | 'return' ';'
;


stmt : ifCall  #If
    | 'for' '(' (assign | localVarWithInitialization) ';' expr ';' assign ')' block  #For
    | 'while' '(' expr ')' block                #While
    | 'do' block 'while' '(' expr ')' ';'?      #DoWhile
    | 'break' ';'                               #Break
    | 'continue' ';'                            #Continue
    | localVar ';'                              #LocalVarDec
    | localVarWithInitialization ';'            #LocalVarDecWithInitialization
    | assign ';'                                #Assignment
    | 'print' '(' expr ')' ';'                  #Print
    | stmtexpr ';'                              #StatementExpressionstmt
    ;

stmtexpr : methCall                             #MethodCall
    | newCall                                   #New
    ;

expr : expr binaryOp expr   #BinaryOperation
    | unaryOp expr          #UnaryOperation
    | literal               #Constant
    | '(' expr ')'          #Expression
    | fieldVarAccess        #Identifier
    | stmtexpr              #StatementExpressionexpr
;

binaryOp : ADD | SUB | MUL | DIV | MOD | GT | LT | GE | LE | EQ | NE | AND | OR;
unaryOp : SUB | NOT;

fieldVarAccess : ((THIS '.')|(newCall '.'))? (recipient '.')* id;

assign : fieldVarAccess assignSign expr | incrDecr;
incrDecr : fieldVarAccess incr | fieldVarAccess decr;
incr : '++';
decr: '--';
methCall : ((THIS '.')|(newCall '.'))? (recipient '.')* methName;
newCall: NEW type '(' args? ')';

recipient : methName | id;
methName : id '(' args? ')';
args : expr (',' expr)*;

ifCall: IF '(' expr ')' block (elseIf)* (ELSE block)? ;
elseIf: ELSE IF '('expr')' block;

literal : NUMBER | BOOLEANLITERAL | CHARLITERAL;

id : IDENTIFIER;


PUBLIC : 'public';
NEW : 'new';
NULL : 'null';
THIS : 'this';

IF : 'if';
ELSE: 'else';

SUB : '-';
ADD : '+';
MUL : '*';
DIV : '/';
MOD : '%';
GT : '>';
LT : '<';
GE : '>=';
LE : '<=';
EQ : '==';
NE : '!=';
AND : '&&';
OR : '||';

ASSIGN : '=';
ADD_ASSIGN : '+=';
SUB_ASSIGN : '-=';
MUL_ASSIGN : '*=';
MOD_ASSIGN : '%=';
DIV_ASSIGN : '/=';

NOT : '!';

INT : 'int';
BOOL : 'boolean';
VOID : 'void';
CHAR : 'char';

BOOLEANLITERAL : 'true' | 'false' ;
CHARLITERAL : ['][a-zA-Z]['];
IDENTIFIER : ([a-zA-Z]+[0-9]*)+;
NUMBER : [0-9]+;
WS : [ \t\r\n] -> skip;
COMMENT
    : '/*' .*? '*/' -> skip
;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
;