grammar QSygusParser;

start       :   prog
            ;

prog        :   setWeightCmd (setLogicCmd cmdPlus | cmdPlus)
            ;

setLogicCmd :   '(' 'set-logic' Symbol ')'
            ;

cmdPlus     :   cmdPlus cmd
            |   cmd
            ;

cmd         :   funDefCmd
            |   funDeclCmd
            |   synthFunCmd
            |   checkSynthCmd
            |   constraintCmd
            |   sortDefCmd
            |   setOptsCmd
            |   weightConstraintCmd
            |   weightOptimizationCmd
            |   varDeclCmd
            ;

varDeclCmd  :   '(' 'declare-var' SYMBOL sortExpr ')'
            ;

sortDefCmd  :   '(' 'define-sort' SYMBOL sortExpr ')'
            ;

sortExpr    :   '(' 'BitVec' INTCONST ')'
            |   'Bool'
            |   'Int'
            |   'Real'
            |   '(' 'Enum' ecList ')'
            |   '(' 'Array' sortExpr sortExpr ')'
            |   SYMBOL
            ;

boolConst   :   'true' | 'false'
            ;

enumConst   :   SYMBOL '::' SYMBOL
            ;

ecList      :   '(' symbolPlus ')'
            ;

symbolPlus  :   symbolPlus SYMBOL
            |   SYMBOL
            ;

setOptsCmd  :   '(' 'set-options' optList ')'
            ;

optList     :   '(' symbolPairPlus ')'
            ;

symbolPairPlus  :   symbolPairPlus symbolPair
                |   symbolPair
                ;

symbolPair  :   '(' SYMBOL QUOTEDLIT ')'
            ;

funDefCmd   :   '(' 'define-fun' SYMBOL argList sortExpr term ')'
            ;

funDeclCmd  :   '(' 'declare-fun' SYMBOL '(' sortStar ')' sortExpr ')'
            ;

sortStar    :   sortStar sortExpr
            |   /* epsilon */
            ;

argList     :   '(' symbolSortPairStar ')'
            ;

symbolSortPairStar  :   symbolSortPairStar symbolSortPair
                    |   /* epsilon */
                    ;

symbolSortPair      :   '(' SYMBOL sortExpr ')'
                    ;

term        :   '(' SYMBOL termStar ')'
            |   literal
            |   SYMBOL
            |   letTerm
            ;

letTerm     :   '(' 'let' '(' letBindingTermPlus ')' term ')'
            ;

letBindingTermPlus  :   letBindingTermPlus letBindingTerm
                    |   letBindingTerm
                    ;

letBindingTerm      :   '(' SYMBOL sortExpr term ')'
                    ;

termStar    :   termStar term
            |   /* epsilon */
            ;

literal     :   INTCONST
            |   boolConst
            |   BVCONST
            |   enumConst
            |   REALCONST
            ;

ntDefPlus   :   ntDefPlus ntDef
            |   ntDef
            ;

ntDef       :   '(' SYMBOL sortExpr '(' gTermPlus ')' ')'
            ;

gTermPlus   :   gTermPlus gTerm
            |   gTerm
            ;

checkSynthCmd   :   '(' 'check-synth' ')'
                ;

constraintCmd   :   '(' 'constraint' term ')'
                ;

synthFunCmd :   '(' 'synth-fun' SYMBOL argList sortExpr '(' ntDefPlus ')' ')'
            ;

gTerm       :   SYMBOL
            |   literal
            |   '(' SYMBOL gTermStar ')'
            |   '(' 'Constant' sortExpr ')'
            |   '(' 'Vairiable' sortExpr ')'
            |   '(' 'InputVariable' sortExpr ')'
            |   '(' 'LocalVariable' sortExpr ')'
            |   letGTerm
            ;

letGTerm    :   '(' 'let' '(' letBindingGTermPlus ')' gTerm ')'
            ;

letBindingGTermPlus :   letBindingGTermPlus letBindingGTerm
                    |   letBindingGTerm
                    ;

letBindingGTerm :   '(' SYMBOL sortExpr gTerm ')'
                ;

gTermStar   :   gTermStar gTerm
            |   /* epsilon */
            ;

WS          :   [\t\f]
            ;

LETTER      :   [a-zA-Z_]
            ;

DIGIT       :   [0-9]
            ;

HEXDIGIT    :   {DIGIT}
            |   [a-f]
            |   [A-F]
            ;

BIT         :   '0'
            |   '1'
            ;

INTEGER     :   '-'? DIGIT+
            ;

INTCONST    :   INTEGER
            ;

BVCONST     :   '#x'HEXDIGIT+
            |   '#b'BIT+
            ;

REALCONST   :   '-'? DIGIT+ '.' DIGIT+
            ;

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