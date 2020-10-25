grammar cal;

// parser rules
prog:	stm*;
stm: 	decl_list
		|




// non case sensitive tokens
fragment A:				'a' | 'A';
fragment B:				'b' | 'B';
fragment C:				'c' | 'C';
fragment D:				'd' | 'D';
fragment E:				'e' | 'E';
fragment F:				'f' | 'F';
fragment G:				'g' | 'G';
fragment H:				'h' | 'H';
fragment I:				'i' | 'I';
fragment K:				'k' | 'K';
fragment L:				'l' | 'L';
fragment M:				'm' | 'M';
fragment N:				'n' | 'N';
fragment O:				'o' | 'O';
fragment P:				'p' | 'P';
fragment R:				'r' | 'R';
fragment S:				's' | 'S';
fragment T:				't' | 'T';
fragment U:				'u' | 'U';
fragment V:				'v' | 'V';
fragment W:				'w' | 'W';




// Fragments
fragment Letter: 		[a-zA-Z];
fragment Digit:			[0-9];
fragment UnderScore:	'_';





// non case sensitive reserved words
Variable:				V A R I A B L E;
Constant:				C O N S T A N T;
Return:					R E T U R N;
Integer:				I N T E G E R;
Boolean:				B O O L E A N;
Void:					V O I D;
Main:					M A I N;
If:						I F;
Else:					E L S E;
True:					T R U E;
False:					F A L S E;
While:					W H I L E;
Begin:					B E G I N;
End:					E N D;
Is:						I S;
Skip:					S K I P;




// language tokens
COMMA:					',';
SEMI: 					';';
COLON: 					':';
ASSIGN:					':='; 
LBR: 					'(';
RBR: 					')';
PUS: 					'+';
MINUS: 					'-';
TILDA: 					'∼';
OR: 					'|';
AND: 					'&';
EQUAL: 					'=';
NOT: 					'!='; 
LESS: 					'<';
LEQUAL: 				'<=';
GREATER: 				'>';
GEQUAL: 				'>=';




// numbers
INTEGER: MINUS? Digit Digit* | 0;




// identifiers
Bool:					True | False;



// white space
WS:						[ \t\n\r]+ -> skip;