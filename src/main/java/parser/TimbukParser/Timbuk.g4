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

transition	:	SYMBOL ('(' state (',' state)* ')')? '->' state
		;


WS          :   [ \t\r\n\u000C]+ -> skip
            ;
fragment
DIGIT       :   [0-9]
            ;
fragment
INTEGER     :   '-'? DIGIT+
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

SYMBOL      :   (SYMBOLCC | DIGIT)+
            ;
