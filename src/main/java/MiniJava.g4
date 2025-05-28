grammar MiniJava;


class : 'class' name '{' fieldDecl* '}';

name : IDENTIFIER;

fieldDecl : IDENTIFIER IDENTIFIER ';';

IDENTIFIER : ([a-zA-Z]+[0-9]*)+;
WS : [ \t\r\n] -> skip;


