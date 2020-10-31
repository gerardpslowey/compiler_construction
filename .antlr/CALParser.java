// Generated from c:\Users\g_slo\compiler_construction\CAL.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CALParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VARIABLE=1, CONSTANT=2, RETURN=3, INTEGER=4, BOOLEAN=5, VOID=6, MAIN=7, 
		IF=8, ELSE=9, TRUE=10, FALSE=11, WHILE=12, BEGIN=13, END=14, IS=15, SKIPP=16, 
		COMMA=17, SEMI=18, COLON=19, ASSIGN=20, LBR=21, RBR=22, PLUS=23, MINUS=24, 
		NEGATE=25, OR=26, AND=27, EQUAL=28, NEQUAL=29, LTHAN=30, LTHANE=31, GTHAN=32, 
		GTHANE=33, NUMBER=34, ID=35, WS=36, MLINE_COMMENT=37, LINE_COMMENT=38;
	public static final int
		RULE_program = 0, RULE_decl_list = 1, RULE_decl = 2, RULE_var_decl = 3, 
		RULE_const_decl = 4, RULE_function_list = 5, RULE_function = 6, RULE_type = 7, 
		RULE_parameter_list = 8, RULE_nemp_parameter_list = 9, RULE_main = 10, 
		RULE_statement_block = 11, RULE_statement = 12, RULE_expression = 13, 
		RULE_condition = 14, RULE_comp_op = 15, RULE_arg_list = 16, RULE_nemp_arg_list = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl_list", "decl", "var_decl", "const_decl", "function_list", 
			"function", "type", "parameter_list", "nemp_parameter_list", "main", 
			"statement_block", "statement", "expression", "condition", "comp_op", 
			"arg_list", "nemp_arg_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "','", "';'", "':'", "':='", "'('", "')'", 
			"'+'", "'-'", "'~'", "'|'", "'&'", "'='", "'!='", "'<'", "'<='", "'>'", 
			"'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VARIABLE", "CONSTANT", "RETURN", "INTEGER", "BOOLEAN", "VOID", 
			"MAIN", "IF", "ELSE", "TRUE", "FALSE", "WHILE", "BEGIN", "END", "IS", 
			"SKIPP", "COMMA", "SEMI", "COLON", "ASSIGN", "LBR", "RBR", "PLUS", "MINUS", 
			"NEGATE", "OR", "AND", "EQUAL", "NEQUAL", "LTHAN", "LTHANE", "GTHAN", 
			"GTHANE", "NUMBER", "ID", "WS", "MLINE_COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CAL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CALParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<Decl_listContext> decl_list() {
			return getRuleContexts(Decl_listContext.class);
		}
		public Decl_listContext decl_list(int i) {
			return getRuleContext(Decl_listContext.class,i);
		}
		public List<Function_listContext> function_list() {
			return getRuleContexts(Function_listContext.class);
		}
		public Function_listContext function_list(int i) {
			return getRuleContext(Function_listContext.class,i);
		}
		public List<MainContext> main() {
			return getRuleContexts(MainContext.class);
		}
		public MainContext main(int i) {
			return getRuleContext(MainContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIABLE) | (1L << CONSTANT) | (1L << INTEGER) | (1L << BOOLEAN) | (1L << VOID) | (1L << MAIN))) != 0)) {
				{
				{
				setState(36);
				decl_list();
				setState(37);
				function_list();
				setState(38);
				main();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_listContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CALParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CALParser.SEMI, i);
		}
		public List<Decl_listContext> decl_list() {
			return getRuleContexts(Decl_listContext.class);
		}
		public Decl_listContext decl_list(int i) {
			return getRuleContext(Decl_listContext.class,i);
		}
		public Decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_list; }
	}

	public final Decl_listContext decl_list() throws RecognitionException {
		Decl_listContext _localctx = new Decl_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					decl();
					setState(46);
					match(SEMI);
					setState(47);
					decl_list();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				var_decl();
				}
				break;
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				const_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(CALParser.VARIABLE, 0); }
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CALParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(VARIABLE);
			setState(59);
			match(ID);
			setState(60);
			match(COLON);
			setState(61);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_declContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(CALParser.CONSTANT, 0); }
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CALParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CALParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(CONSTANT);
			setState(64);
			match(ID);
			setState(65);
			match(COLON);
			setState(66);
			type();
			setState(67);
			match(ASSIGN);
			setState(68);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_listContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<Function_listContext> function_list() {
			return getRuleContexts(Function_listContext.class);
		}
		public Function_listContext function_list(int i) {
			return getRuleContext(Function_listContext.class,i);
		}
		public Function_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_list; }
	}

	public final Function_listContext function_list() throws RecognitionException {
		Function_listContext _localctx = new Function_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					function();
					setState(71);
					function_list();
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public List<TerminalNode> LBR() { return getTokens(CALParser.LBR); }
		public TerminalNode LBR(int i) {
			return getToken(CALParser.LBR, i);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<TerminalNode> RBR() { return getTokens(CALParser.RBR); }
		public TerminalNode RBR(int i) {
			return getToken(CALParser.RBR, i);
		}
		public TerminalNode IS() { return getToken(CALParser.IS, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CALParser.BEGIN, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CALParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(CALParser.SEMI, 0); }
		public TerminalNode END() { return getToken(CALParser.END, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			type();
			setState(79);
			match(ID);
			setState(80);
			match(LBR);
			setState(81);
			parameter_list();
			setState(82);
			match(RBR);
			setState(83);
			match(IS);
			setState(84);
			decl_list();
			setState(85);
			match(BEGIN);
			setState(86);
			statement_block();
			setState(87);
			match(RETURN);
			setState(88);
			match(LBR);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LBR) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(89);
				expression(0);
				}
			}

			setState(92);
			match(RBR);
			setState(93);
			match(SEMI);
			setState(94);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CALParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(CALParser.BOOLEAN, 0); }
		public TerminalNode VOID() { return getToken(CALParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_listContext extends ParserRuleContext {
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(98);
				nemp_parameter_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nemp_parameter_listContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CALParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CALParser.COMMA, 0); }
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public Nemp_parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_parameter_list; }
	}

	public final Nemp_parameter_listContext nemp_parameter_list() throws RecognitionException {
		Nemp_parameter_listContext _localctx = new Nemp_parameter_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nemp_parameter_list);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(ID);
				setState(102);
				match(COLON);
				setState(103);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(ID);
				setState(105);
				match(COLON);
				setState(106);
				type();
				setState(107);
				match(COMMA);
				setState(108);
				nemp_parameter_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(CALParser.MAIN, 0); }
		public TerminalNode BEGIN() { return getToken(CALParser.BEGIN, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode END() { return getToken(CALParser.END, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(MAIN);
			setState(113);
			match(BEGIN);
			setState(114);
			decl_list();
			setState(115);
			statement_block();
			setState(116);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statement_blockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Statement_blockContext> statement_block() {
			return getRuleContexts(Statement_blockContext.class);
		}
		public Statement_blockContext statement_block(int i) {
			return getRuleContext(Statement_blockContext.class,i);
		}
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					statement();
					setState(119);
					statement_block();
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CALParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CALParser.SEMI, 0); }
		public TerminalNode LBR() { return getToken(CALParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(CALParser.RBR, 0); }
		public List<TerminalNode> BEGIN() { return getTokens(CALParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(CALParser.BEGIN, i);
		}
		public List<Statement_blockContext> statement_block() {
			return getRuleContexts(Statement_blockContext.class);
		}
		public Statement_blockContext statement_block(int i) {
			return getRuleContext(Statement_blockContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(CALParser.END); }
		public TerminalNode END(int i) {
			return getToken(CALParser.END, i);
		}
		public TerminalNode IF() { return getToken(CALParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(CALParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(CALParser.WHILE, 0); }
		public TerminalNode SKIPP() { return getToken(CALParser.SKIPP, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ID);
				setState(127);
				match(ASSIGN);
				setState(128);
				expression(0);
				setState(129);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(ID);
				setState(132);
				match(LBR);
				setState(133);
				arg_list();
				setState(134);
				match(RBR);
				setState(135);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(BEGIN);
				setState(138);
				statement_block();
				setState(139);
				match(END);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(IF);
				setState(142);
				condition(0);
				setState(143);
				match(BEGIN);
				setState(144);
				statement_block();
				setState(145);
				match(END);
				setState(146);
				match(ELSE);
				setState(147);
				match(BEGIN);
				setState(148);
				statement_block();
				setState(149);
				match(END);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				match(WHILE);
				setState(152);
				condition(0);
				setState(153);
				match(BEGIN);
				setState(154);
				statement_block();
				setState(155);
				match(END);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				match(SKIPP);
				setState(158);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public TerminalNode LBR() { return getToken(CALParser.LBR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBR() { return getToken(CALParser.RBR, 0); }
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CALParser.MINUS, 0); }
		public TerminalNode NUMBER() { return getToken(CALParser.NUMBER, 0); }
		public TerminalNode TRUE() { return getToken(CALParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CALParser.FALSE, 0); }
		public TerminalNode PLUS() { return getToken(CALParser.PLUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(162);
				match(LBR);
				setState(163);
				expression(0);
				setState(164);
				match(RBR);
				}
				break;
			case 2:
				{
				setState(166);
				match(ID);
				setState(167);
				match(LBR);
				setState(168);
				arg_list();
				setState(169);
				match(RBR);
				}
				break;
			case 3:
				{
				setState(171);
				match(ID);
				}
				break;
			case 4:
				{
				setState(172);
				match(MINUS);
				setState(173);
				match(ID);
				}
				break;
			case 5:
				{
				setState(174);
				match(NUMBER);
				}
				break;
			case 6:
				{
				setState(175);
				match(TRUE);
				}
				break;
			case 7:
				{
				setState(176);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(179);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(180);
					((ExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(181);
					expression(9);
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode NEGATE() { return getToken(CALParser.NEGATE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode LBR() { return getToken(CALParser.LBR, 0); }
		public TerminalNode RBR() { return getToken(CALParser.RBR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public TerminalNode AND() { return getToken(CALParser.AND, 0); }
		public TerminalNode OR() { return getToken(CALParser.OR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(188);
				match(NEGATE);
				setState(189);
				condition(5);
				}
				break;
			case 2:
				{
				setState(190);
				match(LBR);
				setState(191);
				condition(0);
				setState(192);
				match(RBR);
				}
				break;
			case 3:
				{
				setState(194);
				expression(0);
				setState(195);
				comp_op();
				setState(196);
				expression(0);
				}
				break;
			case 4:
				{
				setState(198);
				match(AND);
				setState(199);
				match(RBR);
				setState(200);
				condition(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(203);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(204);
					match(LBR);
					setState(205);
					match(OR);
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(CALParser.EQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(CALParser.NEQUAL, 0); }
		public TerminalNode LTHAN() { return getToken(CALParser.LTHAN, 0); }
		public TerminalNode LTHANE() { return getToken(CALParser.LTHANE, 0); }
		public TerminalNode GTHAN() { return getToken(CALParser.GTHAN, 0); }
		public TerminalNode GTHANE() { return getToken(CALParser.GTHANE, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NEQUAL) | (1L << LTHAN) | (1L << LTHANE) | (1L << GTHAN) | (1L << GTHANE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arg_listContext extends ParserRuleContext {
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(213);
				nemp_arg_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nemp_arg_listContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CALParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(CALParser.COMMA, 0); }
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public Nemp_arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_arg_list; }
	}

	public final Nemp_arg_listContext nemp_arg_list() throws RecognitionException {
		Nemp_arg_listContext _localctx = new Nemp_arg_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_nemp_arg_list);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(ID);
				setState(218);
				match(COMMA);
				setState(219);
				nemp_arg_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 14:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00e1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\3\3\3\3\3\3\3\7\3"+
		"\64\n\3\f\3\16\3\67\13\3\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7L\n\7\f\7\16\7O\13\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\5\nf\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13q\n\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00a2\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b4\n\17\3\17\3\17\3\17"+
		"\7\17\u00b9\n\17\f\17\16\17\u00bc\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00cc\n\20\3\20\3\20\3\20"+
		"\7\20\u00d1\n\20\f\20\16\20\u00d4\13\20\3\21\3\21\3\22\5\22\u00d9\n\22"+
		"\3\23\3\23\3\23\3\23\5\23\u00df\n\23\3\23\2\4\34\36\24\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$\2\5\3\2\6\b\3\2\31\32\3\2\36#\2\u00e8\2,"+
		"\3\2\2\2\4\65\3\2\2\2\6:\3\2\2\2\b<\3\2\2\2\nA\3\2\2\2\fM\3\2\2\2\16P"+
		"\3\2\2\2\20b\3\2\2\2\22e\3\2\2\2\24p\3\2\2\2\26r\3\2\2\2\30}\3\2\2\2\32"+
		"\u00a1\3\2\2\2\34\u00b3\3\2\2\2\36\u00cb\3\2\2\2 \u00d5\3\2\2\2\"\u00d8"+
		"\3\2\2\2$\u00de\3\2\2\2&\'\5\4\3\2\'(\5\f\7\2()\5\26\f\2)+\3\2\2\2*&\3"+
		"\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\3\3\2\2\2.,\3\2\2\2/\60\5\6\4\2"+
		"\60\61\7\24\2\2\61\62\5\4\3\2\62\64\3\2\2\2\63/\3\2\2\2\64\67\3\2\2\2"+
		"\65\63\3\2\2\2\65\66\3\2\2\2\66\5\3\2\2\2\67\65\3\2\2\28;\5\b\5\29;\5"+
		"\n\6\2:8\3\2\2\2:9\3\2\2\2;\7\3\2\2\2<=\7\3\2\2=>\7%\2\2>?\7\25\2\2?@"+
		"\5\20\t\2@\t\3\2\2\2AB\7\4\2\2BC\7%\2\2CD\7\25\2\2DE\5\20\t\2EF\7\26\2"+
		"\2FG\5\34\17\2G\13\3\2\2\2HI\5\16\b\2IJ\5\f\7\2JL\3\2\2\2KH\3\2\2\2LO"+
		"\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\r\3\2\2\2OM\3\2\2\2PQ\5\20\t\2QR\7%\2\2"+
		"RS\7\27\2\2ST\5\22\n\2TU\7\30\2\2UV\7\21\2\2VW\5\4\3\2WX\7\17\2\2XY\5"+
		"\30\r\2YZ\7\5\2\2Z\\\7\27\2\2[]\5\34\17\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2"+
		"\2\2^_\7\30\2\2_`\7\24\2\2`a\7\20\2\2a\17\3\2\2\2bc\t\2\2\2c\21\3\2\2"+
		"\2df\5\24\13\2ed\3\2\2\2ef\3\2\2\2f\23\3\2\2\2gh\7%\2\2hi\7\25\2\2iq\5"+
		"\20\t\2jk\7%\2\2kl\7\25\2\2lm\5\20\t\2mn\7\23\2\2no\5\24\13\2oq\3\2\2"+
		"\2pg\3\2\2\2pj\3\2\2\2q\25\3\2\2\2rs\7\t\2\2st\7\17\2\2tu\5\4\3\2uv\5"+
		"\30\r\2vw\7\20\2\2w\27\3\2\2\2xy\5\32\16\2yz\5\30\r\2z|\3\2\2\2{x\3\2"+
		"\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\31\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
		"\7%\2\2\u0081\u0082\7\26\2\2\u0082\u0083\5\34\17\2\u0083\u0084\7\24\2"+
		"\2\u0084\u00a2\3\2\2\2\u0085\u0086\7%\2\2\u0086\u0087\7\27\2\2\u0087\u0088"+
		"\5\"\22\2\u0088\u0089\7\30\2\2\u0089\u008a\7\24\2\2\u008a\u00a2\3\2\2"+
		"\2\u008b\u008c\7\17\2\2\u008c\u008d\5\30\r\2\u008d\u008e\7\20\2\2\u008e"+
		"\u00a2\3\2\2\2\u008f\u0090\7\n\2\2\u0090\u0091\5\36\20\2\u0091\u0092\7"+
		"\17\2\2\u0092\u0093\5\30\r\2\u0093\u0094\7\20\2\2\u0094\u0095\7\13\2\2"+
		"\u0095\u0096\7\17\2\2\u0096\u0097\5\30\r\2\u0097\u0098\7\20\2\2\u0098"+
		"\u00a2\3\2\2\2\u0099\u009a\7\16\2\2\u009a\u009b\5\36\20\2\u009b\u009c"+
		"\7\17\2\2\u009c\u009d\5\30\r\2\u009d\u009e\7\20\2\2\u009e\u00a2\3\2\2"+
		"\2\u009f\u00a0\7\22\2\2\u00a0\u00a2\7\24\2\2\u00a1\u0080\3\2\2\2\u00a1"+
		"\u0085\3\2\2\2\u00a1\u008b\3\2\2\2\u00a1\u008f\3\2\2\2\u00a1\u0099\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a2\33\3\2\2\2\u00a3\u00a4\b\17\1\2\u00a4\u00a5"+
		"\7\27\2\2\u00a5\u00a6\5\34\17\2\u00a6\u00a7\7\30\2\2\u00a7\u00b4\3\2\2"+
		"\2\u00a8\u00a9\7%\2\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\5\"\22\2\u00ab"+
		"\u00ac\7\30\2\2\u00ac\u00b4\3\2\2\2\u00ad\u00b4\7%\2\2\u00ae\u00af\7\32"+
		"\2\2\u00af\u00b4\7%\2\2\u00b0\u00b4\7$\2\2\u00b1\u00b4\7\f\2\2\u00b2\u00b4"+
		"\7\r\2\2\u00b3\u00a3\3\2\2\2\u00b3\u00a8\3\2\2\2\u00b3\u00ad\3\2\2\2\u00b3"+
		"\u00ae\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2"+
		"\2\2\u00b4\u00ba\3\2\2\2\u00b5\u00b6\f\n\2\2\u00b6\u00b7\t\3\2\2\u00b7"+
		"\u00b9\5\34\17\13\u00b8\u00b5\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\35\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00be\b\20\1\2\u00be\u00bf\7\33\2\2\u00bf\u00cc\5\36\20\7\u00c0\u00c1"+
		"\7\27\2\2\u00c1\u00c2\5\36\20\2\u00c2\u00c3\7\30\2\2\u00c3\u00cc\3\2\2"+
		"\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\5 \21\2\u00c6\u00c7\5\34\17\2\u00c7"+
		"\u00cc\3\2\2\2\u00c8\u00c9\7\35\2\2\u00c9\u00ca\7\30\2\2\u00ca\u00cc\5"+
		"\36\20\3\u00cb\u00bd\3\2\2\2\u00cb\u00c0\3\2\2\2\u00cb\u00c4\3\2\2\2\u00cb"+
		"\u00c8\3\2\2\2\u00cc\u00d2\3\2\2\2\u00cd\u00ce\f\4\2\2\u00ce\u00cf\7\27"+
		"\2\2\u00cf\u00d1\7\34\2\2\u00d0\u00cd\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\37\3\2\2\2\u00d4\u00d2\3\2\2"+
		"\2\u00d5\u00d6\t\4\2\2\u00d6!\3\2\2\2\u00d7\u00d9\5$\23\2\u00d8\u00d7"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9#\3\2\2\2\u00da\u00df\7%\2\2\u00db\u00dc"+
		"\7%\2\2\u00dc\u00dd\7\23\2\2\u00dd\u00df\5$\23\2\u00de\u00da\3\2\2\2\u00de"+
		"\u00db\3\2\2\2\u00df%\3\2\2\2\21,\65:M\\ep}\u00a1\u00b3\u00ba\u00cb\u00d2"+
		"\u00d8\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}