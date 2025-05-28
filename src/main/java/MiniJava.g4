grammar MiniJava;


class : 'class' name '{' '}';

name : IDENTIFIER;

IDENTIFIER : ([a-zA-Z]+[0-9]*)+;
WS : [ \t\r\n] -> skip;
