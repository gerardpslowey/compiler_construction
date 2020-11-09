grammar cal;

prog:                decl_list function_list main ;

decl_list:           (decl SEMI decl_list)? ;              
decl:                var_decl | const_decl ;
var_decl:            VARIABLE ID COLON type ;
const_decl:          CONSTANT ID COLON type ASSIGN expression ;

function_list:       (function function_list)? ;
function:            type ID LBR parameter_list RBR IS
                     decl_list
                     BEGIN
                     statement_block
                     RETURN LBR (expression)? RBR SEMI
                     END
                     ;

type:                INTEGER | BOOLEAN | VOID ;
parameter_list:      nemp_parameter_list? ;
nemp_parameter_list: ID COLON type (COMMA nemp_parameter_list)? ;

main:                MAIN
                     BEGIN
                     decl_list
                     statement_block
                     END
                     ;

statement_block:     (statement statement_block)? ;
statement:           ID ASSIGN expression SEMI
                     | ID LBR arg_list RBR SEMI
                     | BEGIN statement_block END
                     | IF condition BEGIN statement_block END
                     ELSE BEGIN statement_block END
                     | WHILE condition BEGIN statement_block END
                     | SKIP_ SEMI
                     ;

expression:          frag (binary_arith_op frag)* ;
binary_arith_op:     PLUS | MINUS ;
frag:                MINUS? ID (LBR arg_list RBR)?
                     | NUMBER 
                     | TRUE 
                     | FALSE 
                     | LBR expression RBR;
condition:           NEGATE condition
                     | LBR condition RBR
                     | expression comp_op expression
                     | condition (OR | AND) condition
                     ;

comp_op:             EQUAL | NEQUAL | LTHAN | LTHANE | GTHAN | GTHANE ;
arg_list:            nemp_arg_list? ;
nemp_arg_list:       ID (COMMA nemp_arg_list)? ;


fragment A:		      'a' | 'A' ;
fragment B:		      'b' | 'B' ;
fragment C:		      'c' | 'C' ;
fragment D:		      'd' | 'D' ;
fragment E:		      'e' | 'E' ;
fragment F:		      'f' | 'F' ;
fragment G:		      'g' | 'G' ;
fragment H:		      'h' | 'H' ;
fragment I:		      'i' | 'I' ;
fragment K:		      'k' | 'K' ;
fragment L:		      'l' | 'L' ;
fragment M:		      'm' | 'M' ;
fragment N:		      'n' | 'N' ;
fragment O:		      'o' | 'O' ;
fragment P:		      'p' | 'P' ;
fragment R:		      'r' | 'R' ;
fragment S:		      's' | 'S' ;
fragment T:		      't' | 'T' ;
fragment U:		      'u' | 'U' ;
fragment V:          'v' | 'V' ;
fragment W:          'w' | 'W' ;
fragment Y:		      'y' | 'Y' ;


fragment Digit :     [1-9] ;
fragment Digits :    [0-9] ;
fragment Letter :    [a-zA-Z] ;
fragment UnderScore: '_' ;


VARIABLE :           V A R I A B L E ;
CONSTANT :           C O N S T A N T ;
RETURN :             R E T U R N ;
INTEGER :            I N T E G E R ;
BOOLEAN :            B O O L E A N ;
VOID :               V O I D ;
MAIN :               M A I N ;
IF :                 I F ;
ELSE :               E L S E ;
TRUE :               T R U E ;
FALSE :              F A L S E ;
WHILE :              W H I L E ;
BEGIN :              B E G I N ;
END :                E N D ;
IS :                 I S ;
SKIP_ :              S K I P ;


COMMA:               ','  ;
SEMI:                ';'  ;
COLON:               ':'  ;
ASSIGN:              ':=' ;
LBR:                 '('  ;
RBR:                 ')'  ;
PLUS:                '+'  ;
MINUS:               '-'  ;
NEGATE:              '~'  ;
OR:                  '|'  ;
AND:                 '&'  ;
EQUAL:               '='  ;
NEQUAL:              '!=' ;
LTHAN:               '<'  ;
LTHANE:              '<=' ;
GTHAN:               '>'  ;
GTHANE:              '>=' ;


NUMBER:             MINUS? Digit (Digits)* | '0' ;
ID:                 Letter (Letter | Digits | UnderScore)* ;

WS:                 [ \t\n\r]+ -> skip ;
MLINE_COMMENT:      '/*' .*? '*/' -> skip;
LINE_COMMENT:       '//' ~[\r\n]* -> skip;
