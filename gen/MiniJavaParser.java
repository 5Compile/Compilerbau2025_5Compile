// Generated from C:/Users/schuh/IdeaProjects/Compilerbau2025_5Compile/src/main/antlr/MiniJava.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, BOOL=20, CHAR=21, INT=22, VOID=23, PUBLIC=24, NEW=25, 
		NULL=26, THIS=27, IF=28, ELSE=29, SUB=30, ADD=31, MUL=32, DIV=33, MOD=34, 
		GT=35, LT=36, GE=37, LE=38, EQ=39, NE=40, AND=41, OR=42, ASSIGN=43, ADD_ASSIGN=44, 
		SUB_ASSIGN=45, MUL_ASSIGN=46, MOD_ASSIGN=47, DIV_ASSIGN=48, NOT=49, BOOLEANLITERAL=50, 
		CHARLITEARAL=51, IDENTIFIER=52, NUMBER=53, WS=54, COMMENT=55, LINE_COMMENT=56;
	public static final int
		RULE_class = 0, RULE_methodDecl = 1, RULE_mainmethodDecl = 2, RULE_constructor = 3, 
		RULE_parameters = 4, RULE_parameter = 5, RULE_localVariable = 6, RULE_localVariableWithInitialization = 7, 
		RULE_block = 8, RULE_return = 9, RULE_assign = 10, RULE_statementexpr = 11, 
		RULE_newCall = 12, RULE_methodCall = 13, RULE_ifCall = 14, RULE_elseIF = 15, 
		RULE_fieldDecl = 16, RULE_type = 17, RULE_returntype = 18, RULE_statement = 19, 
		RULE_statemtexpr = 20, RULE_expr = 21, RULE_binaryOp = 22, RULE_unaryOp = 23, 
		RULE_literal = 24, RULE_name = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"class", "methodDecl", "mainmethodDecl", "constructor", "parameters", 
			"parameter", "localVariable", "localVariableWithInitialization", "block", 
			"return", "assign", "statementexpr", "newCall", "methodCall", "ifCall", 
			"elseIF", "fieldDecl", "type", "returntype", "statement", "statemtexpr", 
			"expr", "binaryOp", "unaryOp", "literal", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "'('", "')'", "'static'", "'void'", "'main'", 
			"'String[] args'", "','", "'return'", "';'", "'todo'", "'for'", "'while'", 
			"'do'", "'break'", "'continue'", "'printStmt'", "'boolean'", "'char'", 
			"'int'", "'Void'", "'public'", "'new'", "'null'", "'this'", "'if'", "'else'", 
			"'-'", "'+'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'&&'", "'||'", "'='", "'+='", "'-='", "'*='", "'%='", "'/='", 
			"'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "BOOL", "CHAR", "INT", 
			"VOID", "PUBLIC", "NEW", "NULL", "THIS", "IF", "ELSE", "SUB", "ADD", 
			"MUL", "DIV", "MOD", "GT", "LT", "GE", "LE", "EQ", "NE", "AND", "OR", 
			"ASSIGN", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "MOD_ASSIGN", "DIV_ASSIGN", 
			"NOT", "BOOLEANLITERAL", "CHARLITEARAL", "IDENTIFIER", "NUMBER", "WS", 
			"COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(PUBLIC);
			setState(53);
			match(T__0);
			setState(54);
			name();
			setState(55);
			match(T__1);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599651487744L) != 0)) {
				{
				{
				setState(56);
				fieldDecl();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public ReturntypeContext returntype() {
			return getRuleContext(ReturntypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(PUBLIC);
			setState(65);
			returntype();
			setState(66);
			name();
			setState(67);
			match(T__3);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599634710528L) != 0)) {
				{
				setState(68);
				parameters();
				}
			}

			setState(71);
			match(T__4);
			setState(72);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MainmethodDeclContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainmethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainmethodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMainmethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMainmethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMainmethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainmethodDeclContext mainmethodDecl() throws RecognitionException {
		MainmethodDeclContext _localctx = new MainmethodDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainmethodDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(PUBLIC);
			setState(75);
			match(T__5);
			setState(76);
			match(T__6);
			setState(77);
			match(T__7);
			setState(78);
			match(T__3);
			setState(79);
			match(T__8);
			setState(80);
			match(T__4);
			setState(81);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(PUBLIC);
			setState(84);
			name();
			setState(85);
			match(T__3);
			setState(86);
			parameters();
			setState(87);
			match(T__4);
			setState(88);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			parameter();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(91);
				match(T__9);
				setState(92);
				parameter();
				}
				}
				setState(97);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			type();
			setState(99);
			name();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public LocalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLocalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLocalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLocalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableContext localVariable() throws RecognitionException {
		LocalVariableContext _localctx = new LocalVariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			type();
			setState(102);
			name();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableWithInitializationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocalVariableWithInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableWithInitialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLocalVariableWithInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLocalVariableWithInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLocalVariableWithInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableWithInitializationContext localVariableWithInitialization() throws RecognitionException {
		LocalVariableWithInitializationContext _localctx = new LocalVariableWithInitializationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localVariableWithInitialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			type();
			setState(105);
			name();
			setState(106);
			match(ASSIGN);
			setState(107);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__1);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599904186368L) != 0)) {
				{
				{
				setState(110);
				statement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(116);
				return_();
				}
			}

			setState(119);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return);
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(T__10);
				setState(122);
				expr(0);
				setState(123);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(T__10);
				setState(126);
				match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementexprContext extends ParserRuleContext {
		public StatementexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatementexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatementexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatementexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementexprContext statementexpr() throws RecognitionException {
		StatementexprContext _localctx = new StatementexprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NewCallContext extends ParserRuleContext {
		public NewCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNewCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNewCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNewCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewCallContext newCall() throws RecognitionException {
		NewCallContext _localctx = new NewCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_newCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfCallContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<ElseIFContext> elseIF() {
			return getRuleContexts(ElseIFContext.class);
		}
		public ElseIFContext elseIF(int i) {
			return getRuleContext(ElseIFContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniJavaParser.ELSE, 0); }
		public IfCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIfCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIfCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIfCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfCallContext ifCall() throws RecognitionException {
		IfCallContext _localctx = new IfCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(IF);
			setState(138);
			match(T__3);
			setState(139);
			expr(0);
			setState(140);
			match(T__4);
			setState(141);
			block();
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					elseIF();
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(148);
				match(ELSE);
				setState(149);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIFContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MiniJavaParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterElseIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitElseIF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitElseIF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIFContext elseIF() throws RecognitionException {
		ElseIFContext _localctx = new ElseIFContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseIF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(ELSE);
			setState(153);
			match(IF);
			setState(154);
			match(T__3);
			setState(155);
			expr(0);
			setState(156);
			match(T__4);
			setState(157);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC) {
				{
				setState(159);
				match(PUBLIC);
				}
			}

			setState(162);
			type();
			setState(163);
			name();
			setState(164);
			match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(MiniJavaParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(MiniJavaParser.CHAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(INT);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(BOOL);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(CHAR);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				name();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturntypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MiniJavaParser.VOID, 0); }
		public ReturntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returntype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReturntype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReturntype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturntype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturntypeContext returntype() throws RecognitionException {
		ReturntypeContext _localctx = new ReturntypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returntype);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case INT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(VOID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public IfCallContext ifCall() {
			return getRuleContext(IfCallContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LocalVariableWithInitializationContext localVariableWithInitialization() {
			return getRuleContext(LocalVariableWithInitializationContext.class,0);
		}
		public LocalVariableContext localVariable() {
			return getRuleContext(LocalVariableContext.class,0);
		}
		public StatementexprContext statementexpr() {
			return getRuleContext(StatementexprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				ifCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__13);
				setState(178);
				match(T__3);
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(179);
					assign();
					}
					break;
				case BOOL:
				case CHAR:
				case INT:
				case IDENTIFIER:
					{
					setState(180);
					localVariableWithInitialization();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(183);
				match(T__11);
				setState(184);
				expr(0);
				setState(185);
				match(T__11);
				setState(186);
				assign();
				setState(187);
				match(T__4);
				setState(188);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(T__14);
				setState(191);
				match(T__3);
				setState(192);
				expr(0);
				setState(193);
				match(T__4);
				setState(194);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				match(T__15);
				setState(197);
				block();
				setState(198);
				match(T__14);
				setState(199);
				match(T__3);
				setState(200);
				expr(0);
				setState(201);
				match(T__4);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(202);
					match(T__11);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				match(T__16);
				setState(206);
				match(T__11);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(207);
				match(T__17);
				setState(208);
				match(T__11);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(209);
				localVariable();
				setState(210);
				match(T__11);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(212);
				localVariableWithInitialization();
				setState(213);
				match(T__11);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(215);
				assign();
				setState(216);
				match(T__11);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(218);
				match(T__18);
				setState(219);
				match(T__3);
				setState(220);
				expr(0);
				setState(221);
				match(T__4);
				setState(222);
				match(T__11);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(224);
				statementexpr();
				setState(225);
				match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatemtexprContext extends ParserRuleContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public NewCallContext newCall() {
			return getRuleContext(NewCallContext.class,0);
		}
		public StatemtexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statemtexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatemtexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatemtexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatemtexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatemtexprContext statemtexpr() throws RecognitionException {
		StatemtexprContext _localctx = new StatemtexprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statemtexpr);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				methodCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				newCall();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public StatemtexprContext statemtexpr() {
			return getRuleContext(StatemtexprContext.class,0);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case NOT:
				{
				setState(234);
				unaryOp();
				setState(235);
				expr(4);
				}
				break;
			case BOOLEANLITERAL:
			case CHARLITEARAL:
			case NUMBER:
				{
				setState(237);
				literal();
				}
				break;
			case T__3:
				{
				setState(238);
				match(T__3);
				setState(239);
				expr(0);
				setState(240);
				match(T__4);
				}
				break;
			case T__12:
				{
				setState(242);
				statemtexpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(245);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(246);
					binaryOp();
					setState(247);
					expr(6);
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(MiniJavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(MiniJavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiniJavaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiniJavaParser.MOD, 0); }
		public TerminalNode GT() { return getToken(MiniJavaParser.GT, 0); }
		public TerminalNode LT() { return getToken(MiniJavaParser.LT, 0); }
		public TerminalNode GE() { return getToken(MiniJavaParser.GE, 0); }
		public TerminalNode LE() { return getToken(MiniJavaParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MiniJavaParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniJavaParser.NE, 0); }
		public TerminalNode AND() { return getToken(MiniJavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniJavaParser.OR, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8795019280384L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(MiniJavaParser.NOT, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !(_la==SUB || _la==NOT) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(MiniJavaParser.NUMBER, 0); }
		public TerminalNode BOOLEANLITERAL() { return getToken(MiniJavaParser.BOOLEANLITERAL, 0); }
		public TerminalNode CHARLITEARAL() { return getToken(MiniJavaParser.CHARLITEARAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 12384898975268864L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class NameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniJavaParser.IDENTIFIER, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(IDENTIFIER);
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
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0107\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001F\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004^\b\u0004\n\u0004\f\u0004a\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bp\b\b\n\b"+
		"\f\bs\t\b\u0001\b\u0003\bv\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u0080\b\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0090\b\u000e\n"+
		"\u000e\f\u000e\u0093\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0097"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0003\u0010\u00a1\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u00ab\b\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u00af"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00b6\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00cc\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00e4\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u00e8\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00f4\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u00fa\b\u0015\n\u0015\f\u0015\u00fd\t\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0001*\u001a\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02\u0000\u0003\u0001\u0000\u001e*\u0002\u0000\u001e\u001e11\u0002"+
		"\u00002355\u010a\u00004\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000"+
		"\u0000\u0004J\u0001\u0000\u0000\u0000\u0006S\u0001\u0000\u0000\u0000\b"+
		"Z\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000\fe\u0001\u0000\u0000"+
		"\u0000\u000eh\u0001\u0000\u0000\u0000\u0010m\u0001\u0000\u0000\u0000\u0012"+
		"\u007f\u0001\u0000\u0000\u0000\u0014\u0081\u0001\u0000\u0000\u0000\u0016"+
		"\u0083\u0001\u0000\u0000\u0000\u0018\u0085\u0001\u0000\u0000\u0000\u001a"+
		"\u0087\u0001\u0000\u0000\u0000\u001c\u0089\u0001\u0000\u0000\u0000\u001e"+
		"\u0098\u0001\u0000\u0000\u0000 \u00a0\u0001\u0000\u0000\u0000\"\u00aa"+
		"\u0001\u0000\u0000\u0000$\u00ae\u0001\u0000\u0000\u0000&\u00e3\u0001\u0000"+
		"\u0000\u0000(\u00e7\u0001\u0000\u0000\u0000*\u00f3\u0001\u0000\u0000\u0000"+
		",\u00fe\u0001\u0000\u0000\u0000.\u0100\u0001\u0000\u0000\u00000\u0102"+
		"\u0001\u0000\u0000\u00002\u0104\u0001\u0000\u0000\u000045\u0005\u0018"+
		"\u0000\u000056\u0005\u0001\u0000\u000067\u00032\u0019\u00007;\u0005\u0002"+
		"\u0000\u00008:\u0003 \u0010\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\u0003\u0000\u0000"+
		"?\u0001\u0001\u0000\u0000\u0000@A\u0005\u0018\u0000\u0000AB\u0003$\u0012"+
		"\u0000BC\u00032\u0019\u0000CE\u0005\u0004\u0000\u0000DF\u0003\b\u0004"+
		"\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GH\u0005\u0005\u0000\u0000HI\u0003\u0010\b\u0000I\u0003\u0001"+
		"\u0000\u0000\u0000JK\u0005\u0018\u0000\u0000KL\u0005\u0006\u0000\u0000"+
		"LM\u0005\u0007\u0000\u0000MN\u0005\b\u0000\u0000NO\u0005\u0004\u0000\u0000"+
		"OP\u0005\t\u0000\u0000PQ\u0005\u0005\u0000\u0000QR\u0003\u0010\b\u0000"+
		"R\u0005\u0001\u0000\u0000\u0000ST\u0005\u0018\u0000\u0000TU\u00032\u0019"+
		"\u0000UV\u0005\u0004\u0000\u0000VW\u0003\b\u0004\u0000WX\u0005\u0005\u0000"+
		"\u0000XY\u0003\u0010\b\u0000Y\u0007\u0001\u0000\u0000\u0000Z_\u0003\n"+
		"\u0005\u0000[\\\u0005\n\u0000\u0000\\^\u0003\n\u0005\u0000][\u0001\u0000"+
		"\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`\t\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"bc\u0003\"\u0011\u0000cd\u00032\u0019\u0000d\u000b\u0001\u0000\u0000\u0000"+
		"ef\u0003\"\u0011\u0000fg\u00032\u0019\u0000g\r\u0001\u0000\u0000\u0000"+
		"hi\u0003\"\u0011\u0000ij\u00032\u0019\u0000jk\u0005+\u0000\u0000kl\u0003"+
		"*\u0015\u0000l\u000f\u0001\u0000\u0000\u0000mq\u0005\u0002\u0000\u0000"+
		"np\u0003&\u0013\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000tv\u0003\u0012\t\u0000ut\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0005\u0005"+
		"\u0000\u0000x\u0011\u0001\u0000\u0000\u0000yz\u0005\u000b\u0000\u0000"+
		"z{\u0003*\u0015\u0000{|\u0005\f\u0000\u0000|\u0080\u0001\u0000\u0000\u0000"+
		"}~\u0005\u000b\u0000\u0000~\u0080\u0005\f\u0000\u0000\u007fy\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0013\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005\r\u0000\u0000\u0082\u0015\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0005\r\u0000\u0000\u0084\u0017\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005\r\u0000\u0000\u0086\u0019\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\r\u0000\u0000\u0088\u001b\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u001c\u0000\u0000\u008a\u008b\u0005\u0004\u0000\u0000\u008b\u008c\u0003"+
		"*\u0015\u0000\u008c\u008d\u0005\u0005\u0000\u0000\u008d\u0091\u0003\u0010"+
		"\b\u0000\u008e\u0090\u0003\u001e\u000f\u0000\u008f\u008e\u0001\u0000\u0000"+
		"\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0096\u0001\u0000\u0000"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u001d\u0000"+
		"\u0000\u0095\u0097\u0003\u0010\b\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u001d\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u001d\u0000\u0000\u0099\u009a\u0005\u001c\u0000\u0000"+
		"\u009a\u009b\u0005\u0004\u0000\u0000\u009b\u009c\u0003*\u0015\u0000\u009c"+
		"\u009d\u0005\u0005\u0000\u0000\u009d\u009e\u0003\u0010\b\u0000\u009e\u001f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0005\u0018\u0000\u0000\u00a0\u009f"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0003\"\u0011\u0000\u00a3\u00a4\u0003"+
		"2\u0019\u0000\u00a4\u00a5\u0005\f\u0000\u0000\u00a5!\u0001\u0000\u0000"+
		"\u0000\u00a6\u00ab\u0005\u0016\u0000\u0000\u00a7\u00ab\u0005\u0014\u0000"+
		"\u0000\u00a8\u00ab\u0005\u0015\u0000\u0000\u00a9\u00ab\u00032\u0019\u0000"+
		"\u00aa\u00a6\u0001\u0000\u0000\u0000\u00aa\u00a7\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ab#\u0001\u0000\u0000\u0000\u00ac\u00af\u0003\"\u0011\u0000\u00ad"+
		"\u00af\u0005\u0017\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af%\u0001\u0000\u0000\u0000\u00b0\u00e4"+
		"\u0003\u001c\u000e\u0000\u00b1\u00b2\u0005\u000e\u0000\u0000\u00b2\u00b5"+
		"\u0005\u0004\u0000\u0000\u00b3\u00b6\u0003\u0014\n\u0000\u00b4\u00b6\u0003"+
		"\u000e\u0007\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005"+
		"\f\u0000\u0000\u00b8\u00b9\u0003*\u0015\u0000\u00b9\u00ba\u0005\f\u0000"+
		"\u0000\u00ba\u00bb\u0003\u0014\n\u0000\u00bb\u00bc\u0005\u0005\u0000\u0000"+
		"\u00bc\u00bd\u0003\u0010\b\u0000\u00bd\u00e4\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0005\u000f\u0000\u0000\u00bf\u00c0\u0005\u0004\u0000\u0000\u00c0"+
		"\u00c1\u0003*\u0015\u0000\u00c1\u00c2\u0005\u0005\u0000\u0000\u00c2\u00c3"+
		"\u0003\u0010\b\u0000\u00c3\u00e4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005"+
		"\u0010\u0000\u0000\u00c5\u00c6\u0003\u0010\b\u0000\u00c6\u00c7\u0005\u000f"+
		"\u0000\u0000\u00c7\u00c8\u0005\u0004\u0000\u0000\u00c8\u00c9\u0003*\u0015"+
		"\u0000\u00c9\u00cb\u0005\u0005\u0000\u0000\u00ca\u00cc\u0005\f\u0000\u0000"+
		"\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cc\u00e4\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0011\u0000\u0000"+
		"\u00ce\u00e4\u0005\f\u0000\u0000\u00cf\u00d0\u0005\u0012\u0000\u0000\u00d0"+
		"\u00e4\u0005\f\u0000\u0000\u00d1\u00d2\u0003\f\u0006\u0000\u00d2\u00d3"+
		"\u0005\f\u0000\u0000\u00d3\u00e4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0003"+
		"\u000e\u0007\u0000\u00d5\u00d6\u0005\f\u0000\u0000\u00d6\u00e4\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0003\u0014\n\u0000\u00d8\u00d9\u0005\f\u0000"+
		"\u0000\u00d9\u00e4\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0013\u0000"+
		"\u0000\u00db\u00dc\u0005\u0004\u0000\u0000\u00dc\u00dd\u0003*\u0015\u0000"+
		"\u00dd\u00de\u0005\u0005\u0000\u0000\u00de\u00df\u0005\f\u0000\u0000\u00df"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003\u0016\u000b\u0000\u00e1"+
		"\u00e2\u0005\f\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00b0"+
		"\u0001\u0000\u0000\u0000\u00e3\u00b1\u0001\u0000\u0000\u0000\u00e3\u00be"+
		"\u0001\u0000\u0000\u0000\u00e3\u00c4\u0001\u0000\u0000\u0000\u00e3\u00cd"+
		"\u0001\u0000\u0000\u0000\u00e3\u00cf\u0001\u0000\u0000\u0000\u00e3\u00d1"+
		"\u0001\u0000\u0000\u0000\u00e3\u00d4\u0001\u0000\u0000\u0000\u00e3\u00d7"+
		"\u0001\u0000\u0000\u0000\u00e3\u00da\u0001\u0000\u0000\u0000\u00e3\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e4\'\u0001\u0000\u0000\u0000\u00e5\u00e8\u0003"+
		"\u001a\r\u0000\u00e6\u00e8\u0003\u0018\f\u0000\u00e7\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8)\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0006\u0015\uffff\uffff\u0000\u00ea\u00eb\u0003.\u0017"+
		"\u0000\u00eb\u00ec\u0003*\u0015\u0004\u00ec\u00f4\u0001\u0000\u0000\u0000"+
		"\u00ed\u00f4\u00030\u0018\u0000\u00ee\u00ef\u0005\u0004\u0000\u0000\u00ef"+
		"\u00f0\u0003*\u0015\u0000\u00f0\u00f1\u0005\u0005\u0000\u0000\u00f1\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f4\u0003(\u0014\u0000\u00f3\u00e9\u0001"+
		"\u0000\u0000\u0000\u00f3\u00ed\u0001\u0000\u0000\u0000\u00f3\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00fb\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\n\u0005\u0000\u0000\u00f6\u00f7\u0003,"+
		"\u0016\u0000\u00f7\u00f8\u0003*\u0015\u0006\u00f8\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f9\u00f5\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fc+\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0007\u0000\u0000\u0000\u00ff-\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0007\u0001\u0000\u0000\u0101/\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0007\u0002\u0000\u0000\u01031\u0001\u0000\u0000\u0000\u0104\u0105\u0005"+
		"4\u0000\u0000\u01053\u0001\u0000\u0000\u0000\u0011;E_qu\u007f\u0091\u0096"+
		"\u00a0\u00aa\u00ae\u00b5\u00cb\u00e3\u00e7\u00f3\u00fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}