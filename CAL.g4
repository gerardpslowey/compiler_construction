grammar CAL;

prog:               (decl_list func_list main)* ;

decl_list:          (decl SEMI decl_list | WS) ;
decl:               var_decl | const_decl ;
var_decl:           VARIABLE ID COL type ;
const_decl:         CONSTANT ID COL type ASSIGN expr ;

func_list:          function func_list | WS ;
function:           type ID LBR param_list RBR IS
                    decl_list
                    BEGIN
                    stm_block
                    RETURN LBR expr | WS RBR SEMI
                    END
                    ;

type:               INTEGER | BOOLEAN | VOID ;
param_list:         nemp_param_list | WS ;
nemp_param_list:    ID COL type | ID COL type COMMA nemp_param_list ;

main:               MAIN
                    BEGIN
                    decl_list
                    stm_block
                    END
                    ;

stm_block:          statement stm_block | WS ;
statement:          ID ASSIGN expr SEMI
                  | ID LBR arg_list RBR SEMI
                  | BEGIN stm_block END
                  | IF condition BEGIN stm_block END
                    ELSE BEGIN stm_block END
                  | WHILE condition BEGIN stm_block END
                  | SKIPP SEMI
                  ;
expr:               expr op=(PLUS |MINUS) expr
                  | LBR expr RBR
                  | ID LBR arg_list RBR
                  | ID
                  | MINUS ID
                  | NUMBER
                  | TRUE
                  | FALSE
                  ;

condition:          NEGATE condition
                  | LBR condition RBR
                  | expr comp_op expr
                  | condition LBR OR | AND RBR condition
                  ;
comp_op:            EQUAL | NOTEQUAL | LT | LTE | GT | GTE ;
arg_list:           nemp_arg_list | WS ;
nemp_arg_list:      ID | ID COMMA nemp_arg_list ;

// non case sensitive reserved words
VARIABLE :          V A R I A B L E;
CONSTANT :          C O N S T A N T;
RETURN :            R E T U R N;
INTEGER :           I N T E G E R;
BOOLEAN :           B O O L E A N;
VOID :              V O I D;
MAIN :              M A I N;
IF :                I F;
ELSE :              E L S E;
TRUE :              T R U E;
FALSE :             F A L S E;
WHILE :             W H I L E;
BEGIN :             B E G I N;
END :               E N D;
IS :                I S;
SKIPP :             S K I P;

// Language Tokens
ASSIGN:            ':=';
PLUS:               '+';
MINUS:              '-';
NEGATE:             '~';
OR:                 '|';
AND:                '&';
EQUAL:              '=';
NOTEQUAL:           '!=';
LT:                 '<';
LTE:                '<=';
GT:                 '>';
GTE:                '>=';
COMMA:              ',';
SEMI:               ';';
COL:                ':';
LBR:                '(';
RBR:                ')';
OPENC:              '/*';
CLOSEC:             '*/';
SLC:                '//';

// Non case sensitive tokens
fragment A:		      'a' | 'A';
fragment B:		      'b' | 'B';
fragment C:		      'c' | 'C';
fragment D:		      'd' | 'D';
fragment E:		      'e' | 'E';
fragment F:		      'f' | 'F';
fragment G:		      'g' | 'G';
fragment H:		      'h' | 'H';
fragment I:		      'i' | 'I';
fragment K:		      'k' | 'K';
fragment L:		      'l' | 'L';
fragment M:		      'm' | 'M';
fragment N:		      'n' | 'N';
fragment O:		      'o' | 'O';
fragment P:		      'p' | 'P';
fragment R:		      'r' | 'R';
fragment S:		      's' | 'S';
fragment T:		      't' | 'T';
fragment U:		      'u' | 'U';
fragment V:         'v' | 'V';
fragment W:         'w' | 'W';
fragment Y:		      'y' | 'Y';

fragment Digit:      [1-9] ;
fragment Digits:     [0-9] ;
fragment Letter:     [a-zA-Z] ;
fragment UnderScore:  '_';

NUMBER:             MINUS? Digit Digits* | '0';
ID:                 Letter (Letter | Digits | UnderScore)*;
WS:                 [ \t\n\r]+ -> channel(HIDDEN);
MULTI_COMMENT:      OPENC (MULTI_COMMENT | .)*? CLOSEC -> channel(HIDDEN);
SINGLE_COMMENT:     SLC ~[\r\n]* -> channel(HIDDEN);
