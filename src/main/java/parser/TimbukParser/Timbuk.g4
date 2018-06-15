grammar Timbuk;

file	:	'Ops' label_list automaton
	;

label_list	:	(label_decl)*
		;

label_decl	:	SYMBOL ':' INTEGER
		;

automaton	:	'Automaton' SYMBOL 'States' state_list 'Final States' state_list 'Transitions' transition_list
		;


state_list     	: 	(state)*
		;

state		:	SYMBOL
		;


transition_list	: 	(transition)*
		;

transition	:	SYMBOL ('(' (state)+ ')')? '->' state
		;


WS          :   [ \t\r\n\u000C]+ -> skip
            ;
fragment
LETTER      :   [a-zA-Z_]
            ;
fragment
DIGIT       :   [0-9]
            ;
fragment
HEXDIGIT    :   DIGIT
            |   [a-f]
            |   [A-F]
            ;
fragment
BIT         :   '0'
            |   '1'
            ;
fragment
INTEGER     :   '-'? DIGIT+
            ;

INTCONST    :   INTEGER
            ;

BVCONST     :   '#x'HEXDIGIT+
            |   '#b'BIT+
            ;

REALCONST   :   '-'? DIGIT+ '.' DIGIT+
            ;

fragment
SYMBOLCC    :   [a-z]
            |   [A-Z]
            |   '_'
            |   '+'
            |   '-'
            |   '*'
            |   '&'
            |   '|'
            |   '!'
            |   '~'
            |   '<'
            |   '>'
            |   '='
            |   '/'
            |   '%'
            |   '?'
            |   '.'
            |   '$'
            |   '^'
            ;

SYMBOL      :   SYMBOLCC (SYMBOLCC | DIGIT)*
            ;

QUOTEDLIT   :   '\'' ([a-z] | [A-Z] | DIGIT | '.') + '\''
            ;
