// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PipescriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, TIMES=3, OVER=4, OPEN_C=5, CLOSE_C=6, OPEN_B=7, CLOSE_B=8, 
		OPEN_P=9, CLOSE_P=10, PIPE=11, ATTRIB=12, EQUAL=13, DIFFER=14, LESSER=15, 
		LESSER_EQUAL=16, GREATER=17, GREATER_EQUAL=18, FUNC=19, PRINT=20, IF=21, 
		ELSE=22, WHILE=23, COMMA=24, SEMICOLON=25, VAR=26, NUM=27, STRING=28, 
		NL=29, WS=30;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_statement = 2, RULE_statement_if = 3, 
		RULE_statement_else = 4, RULE_statement_while = 5, RULE_function_printInteger = 6, 
		RULE_function_printString = 7, RULE_call_function = 8, RULE_assignment = 9, 
		RULE_expression = 10, RULE_term = 11, RULE_factor = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "statement", "statement_if", "statement_else", "statement_while", 
			"function_printInteger", "function_printString", "call_function", "assignment", 
			"expression", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'", "'|'", "'<<'", "'is'", "'not'", "'lt'", "'lte'", "'gt'", "'gte'", 
			null, "'text'", "'if'", "'else'", "'while'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "TIMES", "OVER", "OPEN_C", "CLOSE_C", "OPEN_B", 
			"CLOSE_B", "OPEN_P", "CLOSE_P", "PIPE", "ATTRIB", "EQUAL", "DIFFER", 
			"LESSER", "LESSER_EQUAL", "GREATER", "GREATER_EQUAL", "FUNC", "PRINT", 
			"IF", "ELSE", "WHILE", "COMMA", "SEMICOLON", "VAR", "NUM", "STRING", 
			"NL", "WS"
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
	public String getGrammarFileName() { return "Pipescript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    Map<String, Integer> memory = new LinkedHashMap<String, Integer>();
	    Integer counter = 1;
	    Integer ifCounter = 1;

	    public static void emit(String s) {
		    System.out.println(s);
	    }

	    public static void main(String[] args) throws Exception
	    {
	        ANTLRInputStream input = new ANTLRInputStream(System.in);
	        PipescriptLexer lexer = new PipescriptLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        PipescriptParser parser = new PipescriptParser(tokens);
	        parser.program();
	    }

	public PipescriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(PipescriptParser.FUNC, 0); }
		public TerminalNode OPEN_C() { return getToken(PipescriptParser.OPEN_C, 0); }
		public TerminalNode CLOSE_C() { return getToken(PipescriptParser.CLOSE_C, 0); }
		public TerminalNode NL() { return getToken(PipescriptParser.NL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(FUNC);
			setState(29);
			match(OPEN_C);

			                System.out.println(".source Output.j");
			                System.out.println(".class  public Output");
			                System.out.println(".super  java/lang/Object\n");
			                System.out.println(".method public <init>()V");
			                System.out.println("aload_0");
			                System.out.println("invokenonvirtual java/lang/Object/<init>()V");
			                System.out.println("return");
			                System.out.println(".end method\n");
			                System.out.println(".method public static main([Ljava/lang/String;)V\n");
			            
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 615514112L) != 0)) {
				{
				{
				setState(31);
				statement();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(CLOSE_C);
			setState(38);
			match(NL);

			                System.out.println("return");
			                System.out.println(".limit stack 50");
			                System.out.println(".limit locals 50");
			                System.out.println(".end method");
			            
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
		public TerminalNode NL() { return getToken(PipescriptParser.NL, 0); }
		public Call_functionContext call_function() {
			return getRuleContext(Call_functionContext.class,0);
		}
		public Statement_ifContext statement_if() {
			return getRuleContext(Statement_ifContext.class,0);
		}
		public Statement_elseContext statement_else() {
			return getRuleContext(Statement_elseContext.class,0);
		}
		public Statement_whileContext statement_while() {
			return getRuleContext(Statement_whileContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				call_function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				statement_if();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				statement_else();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				statement_while();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				assignment();
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
	public static class Statement_ifContext extends ParserRuleContext {
		public Token op;
		public TerminalNode IF() { return getToken(PipescriptParser.IF, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPEN_C() { return getToken(PipescriptParser.OPEN_C, 0); }
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
		}
		public TerminalNode CLOSE_C() { return getToken(PipescriptParser.CLOSE_C, 0); }
		public TerminalNode EQUAL() { return getToken(PipescriptParser.EQUAL, 0); }
		public TerminalNode DIFFER() { return getToken(PipescriptParser.DIFFER, 0); }
		public TerminalNode LESSER() { return getToken(PipescriptParser.LESSER, 0); }
		public TerminalNode LESSER_EQUAL() { return getToken(PipescriptParser.LESSER_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(PipescriptParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(PipescriptParser.GREATER_EQUAL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterStatement_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitStatement_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitStatement_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_ifContext statement_if() throws RecognitionException {
		Statement_ifContext _localctx = new Statement_ifContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempIf = ifCounter++; 
			setState(50);
			match(IF);
			setState(51);
			match(PIPE);
			setState(52);
			expression();
			setState(53);
			((Statement_ifContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
				((Statement_ifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(54);
			expression();


			             emit(((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            
			setState(56);
			match(OPEN_C);
			setState(57);
			match(NL);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 615514112L) != 0)) {
				{
				{
				setState(58);
				statement();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(CLOSE_C);
			setState(65);
			match(NL);
			 emit("NOT_IF_" + tempIf + ": "); 
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
	public static class Statement_elseContext extends ParserRuleContext {
		public Token op;
		public TerminalNode IF() { return getToken(PipescriptParser.IF, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> OPEN_C() { return getTokens(PipescriptParser.OPEN_C); }
		public TerminalNode OPEN_C(int i) {
			return getToken(PipescriptParser.OPEN_C, i);
		}
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
		}
		public List<TerminalNode> CLOSE_C() { return getTokens(PipescriptParser.CLOSE_C); }
		public TerminalNode CLOSE_C(int i) {
			return getToken(PipescriptParser.CLOSE_C, i);
		}
		public TerminalNode ELSE() { return getToken(PipescriptParser.ELSE, 0); }
		public TerminalNode EQUAL() { return getToken(PipescriptParser.EQUAL, 0); }
		public TerminalNode DIFFER() { return getToken(PipescriptParser.DIFFER, 0); }
		public TerminalNode LESSER() { return getToken(PipescriptParser.LESSER, 0); }
		public TerminalNode LESSER_EQUAL() { return getToken(PipescriptParser.LESSER_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(PipescriptParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(PipescriptParser.GREATER_EQUAL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterStatement_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitStatement_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitStatement_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_elseContext statement_else() throws RecognitionException {
		Statement_elseContext _localctx = new Statement_elseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempIfElse = ifCounter++; 
			setState(69);
			match(IF);
			setState(70);
			match(PIPE);
			setState(71);
			expression();
			setState(72);
			((Statement_elseContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
				((Statement_elseContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(73);
			expression();
			 emit(((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); 
			setState(75);
			match(OPEN_C);
			setState(76);
			match(NL);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 615514112L) != 0)) {
				{
				{
				setState(77);
				statement();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto END_IF_ELSE_" + tempIfElse + " ; "); 
			setState(84);
			match(CLOSE_C);
			setState(85);
			match(ELSE);
			setState(86);
			match(OPEN_C);
			setState(87);
			match(NL);
			 emit("NOT_IF_" + tempIfElse + ": "); 
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 615514112L) != 0)) {
				{
				{
				setState(89);
				statement();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			match(CLOSE_C);
			setState(96);
			match(NL);
			 emit("END_IF_ELSE_" + tempIfElse + ": "); 
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
	public static class Statement_whileContext extends ParserRuleContext {
		public Token op;
		public TerminalNode WHILE() { return getToken(PipescriptParser.WHILE, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPEN_C() { return getToken(PipescriptParser.OPEN_C, 0); }
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
		}
		public TerminalNode CLOSE_C() { return getToken(PipescriptParser.CLOSE_C, 0); }
		public TerminalNode EQUAL() { return getToken(PipescriptParser.EQUAL, 0); }
		public TerminalNode DIFFER() { return getToken(PipescriptParser.DIFFER, 0); }
		public TerminalNode LESSER() { return getToken(PipescriptParser.LESSER, 0); }
		public TerminalNode LESSER_EQUAL() { return getToken(PipescriptParser.LESSER_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(PipescriptParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(PipescriptParser.GREATER_EQUAL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterStatement_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitStatement_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitStatement_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_whileContext statement_while() throws RecognitionException {
		Statement_whileContext _localctx = new Statement_whileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempWhile = ifCounter++;
			          emit("START_WHILE_" + tempWhile + ": ");
			        
			setState(100);
			match(WHILE);
			setState(101);
			match(PIPE);
			setState(102);
			expression();
			setState(103);
			((Statement_whileContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
				((Statement_whileContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
			expression();
			 emit(((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); 
			setState(106);
			match(OPEN_C);
			setState(107);
			match(NL);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 615514112L) != 0)) {
				{
				{
				setState(108);
				statement();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto START_WHILE_" + tempWhile + " ; "); 
			setState(115);
			match(CLOSE_C);
			setState(116);
			match(NL);
			 emit("END_WHILE_" + tempWhile + ": "); 
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
	public static class Function_printIntegerContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(PipescriptParser.PRINT, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Function_printIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_printInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_printInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_printInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_printInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_printIntegerContext function_printInteger() throws RecognitionException {
		Function_printIntegerContext _localctx = new Function_printIntegerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_printInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(PRINT);
			setState(120);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(122);
			expression();
			 System.out.println("invokevirtual java/io/PrintStream/println(I)V\n"); 
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
	public static class Function_printStringContext extends ParserRuleContext {
		public Token STRING;
		public TerminalNode PRINT() { return getToken(PipescriptParser.PRINT, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public TerminalNode STRING() { return getToken(PipescriptParser.STRING, 0); }
		public Function_printStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_printString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_printString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_printString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_printString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_printStringContext function_printString() throws RecognitionException {
		Function_printStringContext _localctx = new Function_printStringContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_printString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(PRINT);
			setState(126);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(128);
			((Function_printStringContext)_localctx).STRING = match(STRING);
			 System.out.println("ldc " + (((Function_printStringContext)_localctx).STRING!=null?((Function_printStringContext)_localctx).STRING.getText():null)); 
			 System.out.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"); 
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
	public static class Call_functionContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public Function_printIntegerContext function_printInteger() {
			return getRuleContext(Function_printIntegerContext.class,0);
		}
		public Function_printStringContext function_printString() {
			return getRuleContext(Function_printStringContext.class,0);
		}
		public Call_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterCall_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitCall_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitCall_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_functionContext call_function() throws RecognitionException {
		Call_functionContext _localctx = new Call_functionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(132);
				function_printInteger();
				}
				break;
			case 2:
				{
				setState(133);
				function_printString();
				}
				break;
			}
			setState(136);
			match(SEMICOLON);
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
	public static class AssignmentContext extends ParserRuleContext {
		public Token VAR;
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode ATTRIB() { return getToken(PipescriptParser.ATTRIB, 0); }
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Call_functionContext call_function() {
			return getRuleContext(Call_functionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((AssignmentContext)_localctx).VAR = match(VAR);
			setState(139);
			match(ATTRIB);
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_P:
			case VAR:
			case NUM:
				{
				setState(140);
				expression();
				}
				break;
			case PRINT:
				{
				setState(141);
				call_function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			    	    if (!memory.containsKey((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null))) memory.put((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null), counter++);
			            System.out.println("istore " + memory.get((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null)));
			        
			setState(145);
			match(SEMICOLON);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(PipescriptParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(PipescriptParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(PipescriptParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(PipescriptParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			term();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(148);
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
				setState(149);
				term();
				 System.out.println(((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getType():0) == PLUS) ? "iadd" : "isub"); 
				}
				}
				setState(156);
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
	public static class TermContext extends ParserRuleContext {
		public Token op;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(PipescriptParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(PipescriptParser.TIMES, i);
		}
		public List<TerminalNode> OVER() { return getTokens(PipescriptParser.OVER); }
		public TerminalNode OVER(int i) {
			return getToken(PipescriptParser.OVER, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			factor();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==OVER) {
				{
				{
				setState(158);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==OVER) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				factor();
				 System.out.println(((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getType():0) == TIMES) ? "imul" : "idiv"); 
				}
				}
				setState(166);
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
	public static class FactorContext extends ParserRuleContext {
		public Token NUM;
		public Token VAR;
		public TerminalNode NUM() { return getToken(PipescriptParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode OPEN_B() { return getToken(PipescriptParser.OPEN_B, 0); }
		public TerminalNode CLOSE_B() { return getToken(PipescriptParser.CLOSE_B, 0); }
		public TerminalNode OPEN_P() { return getToken(PipescriptParser.OPEN_P, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_P() { return getToken(PipescriptParser.CLOSE_P, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((FactorContext)_localctx).NUM = match(NUM);
				 System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				((FactorContext)_localctx).VAR = match(VAR);

				    	    Integer v = memory.get((((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				            if (v != null)  System.out.println("iload " + v.intValue());
				            else System.err.println("undefined variable " + (((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				    	
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				((FactorContext)_localctx).VAR = match(VAR);
				setState(172);
				match(OPEN_B);
				setState(173);
				((FactorContext)_localctx).NUM = match(NUM);
				setState(174);
				match(CLOSE_B);

				            Integer v = memory.get((((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				            if (v != null)  System.out.println("aload " + v.intValue());
				            else System.err.println("undefined variable " + (((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				            System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null));
				            System.out.println("iaload");
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(OPEN_P);
				setState(177);
				expression();
				setState(178);
				match(CLOSE_P);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001$\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003<\b\u0003\n\u0003"+
		"\f\u0003?\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004O\b\u0004\n\u0004"+
		"\f\u0004R\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004[\b\u0004\n\u0004\f\u0004^\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005n\b\u0005\n\u0005\f\u0005q\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0003\b\u0087\b\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u008f\b\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u0099\b\n\n\n\f\n\u009c\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a3\b\u000b"+
		"\n\u000b\f\u000b\u00a6\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00b5\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u0000\u0003\u0001\u0000\r\u0012\u0001\u0000"+
		"\u0001\u0002\u0001\u0000\u0003\u0004\u00ba\u0000\u001a\u0001\u0000\u0000"+
		"\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000"+
		"\u00061\u0001\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000\nc\u0001\u0000"+
		"\u0000\u0000\fw\u0001\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000"+
		"\u0010\u0086\u0001\u0000\u0000\u0000\u0012\u008a\u0001\u0000\u0000\u0000"+
		"\u0014\u0093\u0001\u0000\u0000\u0000\u0016\u009d\u0001\u0000\u0000\u0000"+
		"\u0018\u00b4\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000"+
		"\u001b\u0001\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0013\u0000\u0000"+
		"\u001d\u001e\u0005\u0005\u0000\u0000\u001e\"\u0006\u0001\uffff\uffff\u0000"+
		"\u001f!\u0003\u0004\u0002\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001"+
		"\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0006\u0000"+
		"\u0000&\'\u0005\u001d\u0000\u0000\'(\u0006\u0001\uffff\uffff\u0000(\u0003"+
		"\u0001\u0000\u0000\u0000)0\u0005\u001d\u0000\u0000*0\u0003\u0010\b\u0000"+
		"+0\u0003\u0006\u0003\u0000,0\u0003\b\u0004\u0000-0\u0003\n\u0005\u0000"+
		".0\u0003\u0012\t\u0000/)\u0001\u0000\u0000\u0000/*\u0001\u0000\u0000\u0000"+
		"/+\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u0000/.\u0001\u0000\u0000\u00000\u0005\u0001\u0000\u0000\u000012\u0006"+
		"\u0003\uffff\uffff\u000023\u0005\u0015\u0000\u000034\u0005\u000b\u0000"+
		"\u000045\u0003\u0014\n\u000056\u0007\u0000\u0000\u000067\u0003\u0014\n"+
		"\u000078\u0006\u0003\uffff\uffff\u000089\u0005\u0005\u0000\u00009=\u0005"+
		"\u001d\u0000\u0000:<\u0003\u0004\u0002\u0000;:\u0001\u0000\u0000\u0000"+
		"<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u0006"+
		"\u0000\u0000AB\u0005\u001d\u0000\u0000BC\u0006\u0003\uffff\uffff\u0000"+
		"C\u0007\u0001\u0000\u0000\u0000DE\u0006\u0004\uffff\uffff\u0000EF\u0005"+
		"\u0015\u0000\u0000FG\u0005\u000b\u0000\u0000GH\u0003\u0014\n\u0000HI\u0007"+
		"\u0000\u0000\u0000IJ\u0003\u0014\n\u0000JK\u0006\u0004\uffff\uffff\u0000"+
		"KL\u0005\u0005\u0000\u0000LP\u0005\u001d\u0000\u0000MO\u0003\u0004\u0002"+
		"\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000ST\u0006\u0004\uffff\uffff\u0000TU\u0005\u0006\u0000"+
		"\u0000UV\u0005\u0016\u0000\u0000VW\u0005\u0005\u0000\u0000WX\u0005\u001d"+
		"\u0000\u0000X\\\u0006\u0004\uffff\uffff\u0000Y[\u0003\u0004\u0002\u0000"+
		"ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000_`\u0005\u0006\u0000\u0000`a\u0005\u001d\u0000\u0000ab\u0006"+
		"\u0004\uffff\uffff\u0000b\t\u0001\u0000\u0000\u0000cd\u0006\u0005\uffff"+
		"\uffff\u0000de\u0005\u0017\u0000\u0000ef\u0005\u000b\u0000\u0000fg\u0003"+
		"\u0014\n\u0000gh\u0007\u0000\u0000\u0000hi\u0003\u0014\n\u0000ij\u0006"+
		"\u0005\uffff\uffff\u0000jk\u0005\u0005\u0000\u0000ko\u0005\u001d\u0000"+
		"\u0000ln\u0003\u0004\u0002\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0006\u0005\uffff\uffff"+
		"\u0000st\u0005\u0006\u0000\u0000tu\u0005\u001d\u0000\u0000uv\u0006\u0005"+
		"\uffff\uffff\u0000v\u000b\u0001\u0000\u0000\u0000wx\u0005\u0014\u0000"+
		"\u0000xy\u0005\u000b\u0000\u0000yz\u0006\u0006\uffff\uffff\u0000z{\u0003"+
		"\u0014\n\u0000{|\u0006\u0006\uffff\uffff\u0000|\r\u0001\u0000\u0000\u0000"+
		"}~\u0005\u0014\u0000\u0000~\u007f\u0005\u000b\u0000\u0000\u007f\u0080"+
		"\u0006\u0007\uffff\uffff\u0000\u0080\u0081\u0005\u001c\u0000\u0000\u0081"+
		"\u0082\u0006\u0007\uffff\uffff\u0000\u0082\u0083\u0006\u0007\uffff\uffff"+
		"\u0000\u0083\u000f\u0001\u0000\u0000\u0000\u0084\u0087\u0003\f\u0006\u0000"+
		"\u0085\u0087\u0003\u000e\u0007\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u0019\u0000\u0000\u0089\u0011\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u001a\u0000\u0000\u008b\u008e\u0005\f\u0000\u0000\u008c"+
		"\u008f\u0003\u0014\n\u0000\u008d\u008f\u0003\u0010\b\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0006\t\uffff\uffff\u0000\u0091\u0092"+
		"\u0005\u0019\u0000\u0000\u0092\u0013\u0001\u0000\u0000\u0000\u0093\u009a"+
		"\u0003\u0016\u000b\u0000\u0094\u0095\u0007\u0001\u0000\u0000\u0095\u0096"+
		"\u0003\u0016\u000b\u0000\u0096\u0097\u0006\n\uffff\uffff\u0000\u0097\u0099"+
		"\u0001\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0099\u009c"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u0015\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009d\u00a4\u0003\u0018\f\u0000\u009e\u009f\u0007"+
		"\u0002\u0000\u0000\u009f\u00a0\u0003\u0018\f\u0000\u00a0\u00a1\u0006\u000b"+
		"\uffff\uffff\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u009e\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u0017\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"\u001b\u0000\u0000\u00a8\u00b5\u0006\f\uffff\uffff\u0000\u00a9\u00aa\u0005"+
		"\u001a\u0000\u0000\u00aa\u00b5\u0006\f\uffff\uffff\u0000\u00ab\u00ac\u0005"+
		"\u001a\u0000\u0000\u00ac\u00ad\u0005\u0007\u0000\u0000\u00ad\u00ae\u0005"+
		"\u001b\u0000\u0000\u00ae\u00af\u0005\b\u0000\u0000\u00af\u00b5\u0006\f"+
		"\uffff\uffff\u0000\u00b0\u00b1\u0005\t\u0000\u0000\u00b1\u00b2\u0003\u0014"+
		"\n\u0000\u00b2\u00b3\u0005\n\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b4\u00a7\u0001\u0000\u0000\u0000\u00b4\u00a9\u0001\u0000\u0000"+
		"\u0000\u00b4\u00ab\u0001\u0000\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b5\u0019\u0001\u0000\u0000\u0000\u000b\"/=P\\o\u0086\u008e\u009a"+
		"\u00a4\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}