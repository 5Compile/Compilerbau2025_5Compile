grammar MiniJava;

program
    : classDeclaration+ EOF
    ;

classDeclaration
    : 'class' IDENTIFIER '{' '}'
    ;

    expr : expr '+' expr #add
    | expr'.'IDENTIFIER'(' ')' #call
    | 'true' #bool;


IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;
WS         : [ \t\r\n]+ -> skip ;