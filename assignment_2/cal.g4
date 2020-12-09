grammar cal;

// Non-terminals
prog:                decl_list function_list main ;
decl_list:           (decl SEMI decl_list)? ; 

decl:                 var_decl
                    | const_decl
                    ;                      

var_decl:            Variable ID COLON type ;
const_decl:          Constant ID COLON type ASSIGN expression ;
function_list:       (function function_list)? ;

function:            type ID LBR parameter_list RBR Is
                     decl_list
                     Begin
                     statement_block
                     Return LBR returnStatement RBR SEMI
                     End
                     ;

returnStatement:     (expression)? ;

type:                (Integer | Boolean | Void) ;
parameter_list:      nemp_parameter_list? ;
nemp_parameter_list: ID COLON type (COMMA nemp_parameter_list)? ;

main:                Main
                     Begin
                     decl_list
                     statement_block
                     End
                     ;

statement_block:     (statement statement_block)? ;

statement:           ID ASSIGN expression SEMI                                #AssignStm
                     | ID LBR arg_list RBR SEMI                               #ParensStm
                     | Begin statement_block End                              #BlockStm
                     | If condition Begin statement_block End elseStatement   #IfElseStm
                     | While condition Begin statement_block End              #WhileStm
                     | Skipp SEMI                                             #SkipStm
                     ;

// expression:          frag (binary_arith_op frag)* ; 

elseStatement:       Else Begin statement_block End ;

expression:          frag binary_arith_op frag                    #BinaryOp
                     | LBR expression RBR                         #ParensOp
                     | ID LBR arg_list RBR                        #ArglistOp
                     | frag                                       #FragOp
                     ;


binary_arith_op:     PLUS | MINUS ;
frag:                MINUS? ID (LBR arg_list RBR)?                #NegOp
                     | NUMBER                                     #NumOP
                     | True                                       #BooleanOp
                     | False                                      #BooleanOp
                     | LBR expression RBR                         #ExprOp
                     ;

condition:           NEGATE condition                             #NegateOp
                     | LBR condition RBR                          #ParensCondOp
                     | expression op = (EQUAL | NEQUAL | LTHAN | LTHANE | GTHAN | GTHANE) expression              #ExprCompOp
                     | condition op=(OR | AND) condition          #CondOp
                     ;

arg_list:            nemp_arg_list? ;
nemp_arg_list:       ID (COMMA nemp_arg_list)? ;

// Case insensitive fragments
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
fragment V:         'v' | 'V' ;
fragment W:         'w' | 'W' ;
fragment Y:		      'y' | 'Y' ;

fragment Letter :    [a-zA-Z] ;
fragment Digit :     [1-9] ;
fragment Digits :    [0-9] ;
fragment Underscore: '_' ;

// Matching terminals with fragments
Variable :           V A R I A B L E ;
Constant :           C O N S T A N T ;
Return :             R E T U R N ;
Integer :            I N T E G E R ;
Boolean :            B O O L E A N ;
Void :               V O I D ;
Main :               M A I N ;
If :                 I F ;
Else :               E L S E ;
True :               T R U E ;
False :              F A L S E ;
While :              W H I L E ;
Begin :              B E G I N ;
End :                E N D ;
Is :                 I S ;
Skipp :              S K I P ;

// Matching terminals with tokens
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
STARTCOMMENT:        '/*' ;
ENDCOMMENT:          '*/' ;
OPENCOMMENT:         '//' ;

// Handling numbers and identifiers
NUMBER:             MINUS? Digit (Digits)* | [0] ;
ID:                 Letter(Letter | Digits | Underscore)* ;

// Just skip any whitespace
WS:                 [ \t\n\r]+ -> skip ;
ML_COMMENT :        STARTCOMMENT (ML_COMMENT|.)*? ENDCOMMENT -> skip ;
LINE_COMMENT  :     OPENCOMMENT .*? '\n' -> skip ;
