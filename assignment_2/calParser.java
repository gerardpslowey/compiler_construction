// Generated from cal.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Variable=1, Constant=2, Return=3, Integer=4, Boolean=5, Void=6, Main=7, 
		If=8, Else=9, True=10, False=11, While=12, Begin=13, End=14, Is=15, Skipp=16, 
		COMMA=17, SEMI=18, COLON=19, ASSIGN=20, LBR=21, RBR=22, PLUS=23, MINUS=24, 
		NEGATE=25, OR=26, AND=27, EQUAL=28, NEQUAL=29, LTHAN=30, LTHANE=31, GTHAN=32, 
		GTHANE=33, STARTCOMMENT=34, ENDCOMMENT=35, OPENCOMMENT=36, NUMBER=37, 
		ID=38, WS=39, ML_COMMENT=40, LINE_COMMENT=41;
	public static final int
		RULE_prog = 0, RULE_decl_list = 1, RULE_decl = 2, RULE_var_decl = 3, RULE_const_decl = 4, 
		RULE_function_list = 5, RULE_function = 6, RULE_returnStatement = 7, RULE_type = 8, 
		RULE_parameter_list = 9, RULE_nemp_parameter_list = 10, RULE_main = 11, 
		RULE_statement_block = 12, RULE_statement = 13, RULE_elseStatement = 14, 
		RULE_expression = 15, RULE_binary_arith_op = 16, RULE_frag = 17, RULE_condition = 18, 
		RULE_arg_list = 19, RULE_nemp_arg_list = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl_list", "decl", "var_decl", "const_decl", "function_list", 
			"function", "returnStatement", "type", "parameter_list", "nemp_parameter_list", 
			"main", "statement_block", "statement", "elseStatement", "expression", 
			"binary_arith_op", "frag", "condition", "arg_list", "nemp_arg_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "','", "';'", "':'", "':='", "'('", "')'", 
			"'+'", "'-'", "'~'", "'|'", "'&'", "'='", "'!='", "'<'", "'<='", "'>'", 
			"'>='", "'/*'", "'*/'", "'//'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Variable", "Constant", "Return", "Integer", "Boolean", "Void", 
			"Main", "If", "Else", "True", "False", "While", "Begin", "End", "Is", 
			"Skipp", "COMMA", "SEMI", "COLON", "ASSIGN", "LBR", "RBR", "PLUS", "MINUS", 
			"NEGATE", "OR", "AND", "EQUAL", "NEQUAL", "LTHAN", "LTHANE", "GTHAN", 
			"GTHANE", "STARTCOMMENT", "ENDCOMMENT", "OPENCOMMENT", "NUMBER", "ID", 
			"WS", "ML_COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "cal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			decl_list();
			setState(43);
			function_list();
			setState(44);
			main();
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
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDecl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_listContext decl_list() throws RecognitionException {
		Decl_listContext _localctx = new Decl_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Variable || _la==Constant) {
				{
				setState(46);
				decl();
				setState(47);
				match(SEMI);
				setState(48);
				decl_list();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				var_decl();
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
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
		public TerminalNode Variable() { return getToken(calParser.Variable, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(Variable);
			setState(57);
			match(ID);
			setState(58);
			match(COLON);
			setState(59);
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
		public TerminalNode Constant() { return getToken(calParser.Constant, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(calParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitConst_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(Constant);
			setState(62);
			match(ID);
			setState(63);
			match(COLON);
			setState(64);
			type();
			setState(65);
			match(ASSIGN);
			setState(66);
			expression();
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
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public Function_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunction_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_listContext function_list() throws RecognitionException {
		Function_listContext _localctx = new Function_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << Boolean) | (1L << Void))) != 0)) {
				{
				setState(68);
				function();
				setState(69);
				function_list();
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

	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public List<TerminalNode> LBR() { return getTokens(calParser.LBR); }
		public TerminalNode LBR(int i) {
			return getToken(calParser.LBR, i);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<TerminalNode> RBR() { return getTokens(calParser.RBR); }
		public TerminalNode RBR(int i) {
			return getToken(calParser.RBR, i);
		}
		public TerminalNode Is() { return getToken(calParser.Is, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode Return() { return getToken(calParser.Return, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			type();
			setState(74);
			match(ID);
			setState(75);
			match(LBR);
			setState(76);
			parameter_list();
			setState(77);
			match(RBR);
			setState(78);
			match(Is);
			setState(79);
			decl_list();
			setState(80);
			match(Begin);
			setState(81);
			statement_block();
			setState(82);
			match(Return);
			setState(83);
			match(LBR);
			setState(84);
			returnStatement();
			setState(85);
			match(RBR);
			setState(86);
			match(SEMI);
			setState(87);
			match(End);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << LBR) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(89);
				expression();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(calParser.Integer, 0); }
		public TerminalNode Boolean() { return getToken(calParser.Boolean, 0); }
		public TerminalNode Void() { return getToken(calParser.Void, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << Boolean) | (1L << Void))) != 0)) ) {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(94);
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
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(calParser.COMMA, 0); }
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public Nemp_parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_parameter_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNemp_parameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nemp_parameter_listContext nemp_parameter_list() throws RecognitionException {
		Nemp_parameter_listContext _localctx = new Nemp_parameter_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nemp_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ID);
			setState(98);
			match(COLON);
			setState(99);
			type();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(100);
				match(COMMA);
				setState(101);
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

	public static class MainContext extends ParserRuleContext {
		public TerminalNode Main() { return getToken(calParser.Main, 0); }
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(Main);
			setState(105);
			match(Begin);
			setState(106);
			decl_list();
			setState(107);
			statement_block();
			setState(108);
			match(End);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Begin) | (1L << Skipp) | (1L << ID))) != 0)) {
				{
				setState(110);
				statement();
				setState(111);
				statement_block();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignStmContext extends StatementContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(calParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public AssignStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitAssignStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmContext extends StatementContext {
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public BlockStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBlockStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmContext extends StatementContext {
		public TerminalNode While() { return getToken(calParser.While, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public WhileStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitWhileStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipStmContext extends StatementContext {
		public TerminalNode Skipp() { return getToken(calParser.Skipp, 0); }
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public SkipStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitSkipStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensStmContext extends StatementContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public ParensStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParensStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseStmContext extends StatementContext {
		public TerminalNode If() { return getToken(calParser.If, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfElseStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitIfElseStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AssignStmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(ID);
				setState(116);
				match(ASSIGN);
				setState(117);
				expression();
				setState(118);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ParensStmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(ID);
				setState(121);
				match(LBR);
				setState(122);
				arg_list();
				setState(123);
				match(RBR);
				setState(124);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new BlockStmContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(Begin);
				setState(127);
				statement_block();
				setState(128);
				match(End);
				}
				break;
			case 4:
				_localctx = new IfElseStmContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(If);
				setState(131);
				condition(0);
				setState(132);
				match(Begin);
				setState(133);
				statement_block();
				setState(134);
				match(End);
				setState(135);
				elseStatement();
				}
				break;
			case 5:
				_localctx = new WhileStmContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
				match(While);
				setState(138);
				condition(0);
				setState(139);
				match(Begin);
				setState(140);
				statement_block();
				setState(141);
				match(End);
				}
				break;
			case 6:
				_localctx = new SkipStmContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(143);
				match(Skipp);
				setState(144);
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(calParser.Else, 0); }
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(Else);
			setState(148);
			match(Begin);
			setState(149);
			statement_block();
			setState(150);
			match(End);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArglistOpContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public ArglistOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitArglistOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FragOpContext extends ExpressionContext {
		public FragContext frag() {
			return getRuleContext(FragContext.class,0);
		}
		public FragOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFragOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryOpContext extends ExpressionContext {
		public List<FragContext> frag() {
			return getRuleContexts(FragContext.class);
		}
		public FragContext frag(int i) {
			return getRuleContext(FragContext.class,i);
		}
		public Binary_arith_opContext binary_arith_op() {
			return getRuleContext(Binary_arith_opContext.class,0);
		}
		public BinaryOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensOpContext extends ExpressionContext {
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public ParensOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParensOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new BinaryOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				frag();
				setState(153);
				binary_arith_op();
				setState(154);
				frag();
				}
				break;
			case 2:
				_localctx = new ParensOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(LBR);
				setState(157);
				expression();
				setState(158);
				match(RBR);
				}
				break;
			case 3:
				_localctx = new ArglistOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(ID);
				setState(161);
				match(LBR);
				setState(162);
				arg_list();
				setState(163);
				match(RBR);
				}
				break;
			case 4:
				_localctx = new FragOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				frag();
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

	public static class Binary_arith_opContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(calParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(calParser.MINUS, 0); }
		public Binary_arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_arith_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBinary_arith_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_arith_opContext binary_arith_op() throws RecognitionException {
		Binary_arith_opContext _localctx = new Binary_arith_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binary_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class FragContext extends ParserRuleContext {
		public FragContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frag; }
	 
		public FragContext() { }
		public void copyFrom(FragContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumOPContext extends FragContext {
		public TerminalNode NUMBER() { return getToken(calParser.NUMBER, 0); }
		public NumOPContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNumOP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOpContext extends FragContext {
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public ExprOpContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExprOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanOpContext extends FragContext {
		public TerminalNode True() { return getToken(calParser.True, 0); }
		public TerminalNode False() { return getToken(calParser.False, 0); }
		public BooleanOpContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBooleanOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegOpContext extends FragContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode MINUS() { return getToken(calParser.MINUS, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public NegOpContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNegOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragContext frag() throws RecognitionException {
		FragContext _localctx = new FragContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_frag);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case ID:
				_localctx = new NegOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(170);
					match(MINUS);
					}
				}

				setState(173);
				match(ID);
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(174);
					match(LBR);
					setState(175);
					arg_list();
					setState(176);
					match(RBR);
					}
					break;
				}
				}
				break;
			case NUMBER:
				_localctx = new NumOPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(NUMBER);
				}
				break;
			case True:
				_localctx = new BooleanOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(True);
				}
				break;
			case False:
				_localctx = new BooleanOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(False);
				}
				break;
			case LBR:
				_localctx = new ExprOpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				match(LBR);
				setState(184);
				expression();
				setState(185);
				match(RBR);
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

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegateOpContext extends ConditionContext {
		public TerminalNode NEGATE() { return getToken(calParser.NEGATE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public NegateOpContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNegateOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondOpContext extends ConditionContext {
		public Token op;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OR() { return getToken(calParser.OR, 0); }
		public TerminalNode AND() { return getToken(calParser.AND, 0); }
		public CondOpContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitCondOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCompOpContext extends ConditionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(calParser.EQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(calParser.NEQUAL, 0); }
		public TerminalNode LTHAN() { return getToken(calParser.LTHAN, 0); }
		public TerminalNode LTHANE() { return getToken(calParser.LTHANE, 0); }
		public TerminalNode GTHAN() { return getToken(calParser.GTHAN, 0); }
		public TerminalNode GTHANE() { return getToken(calParser.GTHANE, 0); }
		public ExprCompOpContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExprCompOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensCondOpContext extends ConditionContext {
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public ParensCondOpContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParensCondOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new NegateOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(190);
				match(NEGATE);
				setState(191);
				condition(4);
				}
				break;
			case 2:
				{
				_localctx = new ParensCondOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(LBR);
				setState(193);
				condition(0);
				setState(194);
				match(RBR);
				}
				break;
			case 3:
				{
				_localctx = new ExprCompOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				expression();
				setState(197);
				((ExprCompOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NEQUAL) | (1L << LTHAN) | (1L << LTHANE) | (1L << GTHAN) | (1L << GTHANE))) != 0)) ) {
					((ExprCompOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(198);
				expression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondOpContext(new ConditionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(202);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(203);
					((CondOpContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
						((CondOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(204);
					condition(2);
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class Arg_listContext extends ParserRuleContext {
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(210);
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
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(calParser.COMMA, 0); }
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public Nemp_arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNemp_arg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nemp_arg_listContext nemp_arg_list() throws RecognitionException {
		Nemp_arg_listContext _localctx = new Nemp_arg_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_nemp_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(ID);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(214);
				match(COMMA);
				setState(215);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00dd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3\65\n\3\3\4\3\4\5\49\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\5\7J\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\5\t]\n\t\3\n\3\n\3\13\5\13b\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\5\fi\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16t\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0094\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a9\n\21\3\22"+
		"\3\22\3\23\5\23\u00ae\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b5\n\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00be\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00cb\n\24\3\24\3\24\3\24\7\24"+
		"\u00d0\n\24\f\24\16\24\u00d3\13\24\3\25\5\25\u00d6\n\25\3\26\3\26\3\26"+
		"\5\26\u00db\n\26\3\26\2\3&\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(*\2\6\3\2\6\b\3\2\31\32\3\2\36#\3\2\34\35\2\u00e1\2,\3\2\2\2\4\64"+
		"\3\2\2\2\68\3\2\2\2\b:\3\2\2\2\n?\3\2\2\2\fI\3\2\2\2\16K\3\2\2\2\20\\"+
		"\3\2\2\2\22^\3\2\2\2\24a\3\2\2\2\26c\3\2\2\2\30j\3\2\2\2\32s\3\2\2\2\34"+
		"\u0093\3\2\2\2\36\u0095\3\2\2\2 \u00a8\3\2\2\2\"\u00aa\3\2\2\2$\u00bd"+
		"\3\2\2\2&\u00ca\3\2\2\2(\u00d5\3\2\2\2*\u00d7\3\2\2\2,-\5\4\3\2-.\5\f"+
		"\7\2./\5\30\r\2/\3\3\2\2\2\60\61\5\6\4\2\61\62\7\24\2\2\62\63\5\4\3\2"+
		"\63\65\3\2\2\2\64\60\3\2\2\2\64\65\3\2\2\2\65\5\3\2\2\2\669\5\b\5\2\67"+
		"9\5\n\6\28\66\3\2\2\28\67\3\2\2\29\7\3\2\2\2:;\7\3\2\2;<\7(\2\2<=\7\25"+
		"\2\2=>\5\22\n\2>\t\3\2\2\2?@\7\4\2\2@A\7(\2\2AB\7\25\2\2BC\5\22\n\2CD"+
		"\7\26\2\2DE\5 \21\2E\13\3\2\2\2FG\5\16\b\2GH\5\f\7\2HJ\3\2\2\2IF\3\2\2"+
		"\2IJ\3\2\2\2J\r\3\2\2\2KL\5\22\n\2LM\7(\2\2MN\7\27\2\2NO\5\24\13\2OP\7"+
		"\30\2\2PQ\7\21\2\2QR\5\4\3\2RS\7\17\2\2ST\5\32\16\2TU\7\5\2\2UV\7\27\2"+
		"\2VW\5\20\t\2WX\7\30\2\2XY\7\24\2\2YZ\7\20\2\2Z\17\3\2\2\2[]\5 \21\2\\"+
		"[\3\2\2\2\\]\3\2\2\2]\21\3\2\2\2^_\t\2\2\2_\23\3\2\2\2`b\5\26\f\2a`\3"+
		"\2\2\2ab\3\2\2\2b\25\3\2\2\2cd\7(\2\2de\7\25\2\2eh\5\22\n\2fg\7\23\2\2"+
		"gi\5\26\f\2hf\3\2\2\2hi\3\2\2\2i\27\3\2\2\2jk\7\t\2\2kl\7\17\2\2lm\5\4"+
		"\3\2mn\5\32\16\2no\7\20\2\2o\31\3\2\2\2pq\5\34\17\2qr\5\32\16\2rt\3\2"+
		"\2\2sp\3\2\2\2st\3\2\2\2t\33\3\2\2\2uv\7(\2\2vw\7\26\2\2wx\5 \21\2xy\7"+
		"\24\2\2y\u0094\3\2\2\2z{\7(\2\2{|\7\27\2\2|}\5(\25\2}~\7\30\2\2~\177\7"+
		"\24\2\2\177\u0094\3\2\2\2\u0080\u0081\7\17\2\2\u0081\u0082\5\32\16\2\u0082"+
		"\u0083\7\20\2\2\u0083\u0094\3\2\2\2\u0084\u0085\7\n\2\2\u0085\u0086\5"+
		"&\24\2\u0086\u0087\7\17\2\2\u0087\u0088\5\32\16\2\u0088\u0089\7\20\2\2"+
		"\u0089\u008a\5\36\20\2\u008a\u0094\3\2\2\2\u008b\u008c\7\16\2\2\u008c"+
		"\u008d\5&\24\2\u008d\u008e\7\17\2\2\u008e\u008f\5\32\16\2\u008f\u0090"+
		"\7\20\2\2\u0090\u0094\3\2\2\2\u0091\u0092\7\22\2\2\u0092\u0094\7\24\2"+
		"\2\u0093u\3\2\2\2\u0093z\3\2\2\2\u0093\u0080\3\2\2\2\u0093\u0084\3\2\2"+
		"\2\u0093\u008b\3\2\2\2\u0093\u0091\3\2\2\2\u0094\35\3\2\2\2\u0095\u0096"+
		"\7\13\2\2\u0096\u0097\7\17\2\2\u0097\u0098\5\32\16\2\u0098\u0099\7\20"+
		"\2\2\u0099\37\3\2\2\2\u009a\u009b\5$\23\2\u009b\u009c\5\"\22\2\u009c\u009d"+
		"\5$\23\2\u009d\u00a9\3\2\2\2\u009e\u009f\7\27\2\2\u009f\u00a0\5 \21\2"+
		"\u00a0\u00a1\7\30\2\2\u00a1\u00a9\3\2\2\2\u00a2\u00a3\7(\2\2\u00a3\u00a4"+
		"\7\27\2\2\u00a4\u00a5\5(\25\2\u00a5\u00a6\7\30\2\2\u00a6\u00a9\3\2\2\2"+
		"\u00a7\u00a9\5$\23\2\u00a8\u009a\3\2\2\2\u00a8\u009e\3\2\2\2\u00a8\u00a2"+
		"\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9!\3\2\2\2\u00aa\u00ab\t\3\2\2\u00ab"+
		"#\3\2\2\2\u00ac\u00ae\7\32\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2"+
		"\u00ae\u00af\3\2\2\2\u00af\u00b4\7(\2\2\u00b0\u00b1\7\27\2\2\u00b1\u00b2"+
		"\5(\25\2\u00b2\u00b3\7\30\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b0\3\2\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00be\3\2\2\2\u00b6\u00be\7\'\2\2\u00b7\u00be"+
		"\7\f\2\2\u00b8\u00be\7\r\2\2\u00b9\u00ba\7\27\2\2\u00ba\u00bb\5 \21\2"+
		"\u00bb\u00bc\7\30\2\2\u00bc\u00be\3\2\2\2\u00bd\u00ad\3\2\2\2\u00bd\u00b6"+
		"\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd\u00b8\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be"+
		"%\3\2\2\2\u00bf\u00c0\b\24\1\2\u00c0\u00c1\7\33\2\2\u00c1\u00cb\5&\24"+
		"\6\u00c2\u00c3\7\27\2\2\u00c3\u00c4\5&\24\2\u00c4\u00c5\7\30\2\2\u00c5"+
		"\u00cb\3\2\2\2\u00c6\u00c7\5 \21\2\u00c7\u00c8\t\4\2\2\u00c8\u00c9\5 "+
		"\21\2\u00c9\u00cb\3\2\2\2\u00ca\u00bf\3\2\2\2\u00ca\u00c2\3\2\2\2\u00ca"+
		"\u00c6\3\2\2\2\u00cb\u00d1\3\2\2\2\u00cc\u00cd\f\3\2\2\u00cd\u00ce\t\5"+
		"\2\2\u00ce\u00d0\5&\24\4\u00cf\u00cc\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\'\3\2\2\2\u00d3\u00d1\3\2\2\2"+
		"\u00d4\u00d6\5*\26\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6)\3"+
		"\2\2\2\u00d7\u00da\7(\2\2\u00d8\u00d9\7\23\2\2\u00d9\u00db\5*\26\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db+\3\2\2\2\22\648I\\ahs\u0093\u00a8"+
		"\u00ad\u00b4\u00bd\u00ca\u00d1\u00d5\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}