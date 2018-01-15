WS          :   [ \t\f] ->skip
            ;

LETTER      :   [a-zA-Z_]
            ;

DIGIT       :   [0-9]
            ;

HEXDIGIT    :   {DIGIT}
            |   [a-f]
            |   [A-F]
            ;

BIT         :   "0"
            |   "1"
            ;

INTEGER     |   (-?{DIGIT}+)
            ;

INTCONST    |   {INTEGER}
            ;

BVCONST     |   "#x"{HEXDIGIT}+
            |   "#b"{BIT}+
            ;

REALCONST   |   (-?{DIGIT}+"."{DIGIT}+)
            ;

SYMBOLCC    |   [a-z]
            |   [A-Z]
            |   "_"
            |   "+"
            |   "-"
            |   "*"
            |   "&"
            |   "|"
            |   "!"
            |   "~"
            |   "<"
            |   ">"
            |   "="
            |   "/"
            |   "%"
            |   "?"
            |   "."
            |   "$"
            |   "^"
            ;

SYMBOL      |   {SYMBOLCC}({SYMBOLCC}|{DIGIT})*
            ;
QUOTEDLIT   |   "\""([a-z]|[A-Z]|{DIGIT}|".")+"\""
            ;