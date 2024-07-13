// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;

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
		PLUS=1, MINUS=2, TIMES=3, DIV=4, OPEN_C=5, CLOSE_C=6, OPEN_B=7, CLOSE_B=8, 
		OPEN_P=9, CLOSE_P=10, PIPE=11, ATTRIB=12, EQUAL=13, DIFFER=14, LESSER=15, 
		LESSER_EQUAL=16, GREATER=17, GREATER_EQUAL=18, FUNC=19, MAIN=20, PRINT=21, 
		IF=22, ELSE=23, WHILE=24, COMMA=25, SEMICOLON=26, VAR=27, NUM=28, STRING=29, 
		NL=30, WS=31, INT_VAR=32, DOUBLE_VAR=33, STRING_VAR=34, CHAR_VAR=35, BOOL_VAR=36, 
		VOID_VAR=37, NULL_VAR=38;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_function = 2, RULE_statement = 3, 
		RULE_statement_if = 4, RULE_statement_else = 5, RULE_statement_while = 6, 
		RULE_function_printInteger = 7, RULE_function_printString = 8, RULE_call_function = 9, 
		RULE_assignment = 10, RULE_expression = 11, RULE_term = 12, RULE_factor = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "function", "statement", "statement_if", "statement_else", 
			"statement_while", "function_printInteger", "function_printString", "call_function", 
			"assignment", "expression", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'", "'|'", "'<<'", "'is'", "'not'", "'lt'", "'lte'", "'gt'", "'gte'", 
			"'fun'", "'main'", "'text'", "'if'", "'else'", "'while'", "','", "';'", 
			null, null, null, null, null, "'int'", "'double'", "'str'", "'char'", 
			"'bool'", "'void'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "TIMES", "DIV", "OPEN_C", "CLOSE_C", "OPEN_B", 
			"CLOSE_B", "OPEN_P", "CLOSE_P", "PIPE", "ATTRIB", "EQUAL", "DIFFER", 
			"LESSER", "LESSER_EQUAL", "GREATER", "GREATER_EQUAL", "FUNC", "MAIN", 
			"PRINT", "IF", "ELSE", "WHILE", "COMMA", "SEMICOLON", "VAR", "NUM", "STRING", 
			"NL", "WS", "INT_VAR", "DOUBLE_VAR", "STRING_VAR", "CHAR_VAR", "BOOL_VAR", 
			"VOID_VAR", "NULL_VAR"
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


	    Map<String, List<Var>> memory = new LinkedHashMap<String, List<Var>>();
	    Map<String, Integer> stackCounter = new LinkedHashMap<String, Integer>();
	    Integer counter = 1;
	    Integer ifCounter = 1;

	    public static class Var {
	        public String name;
	        public String type;
	        public Integer stackPos;

	        public Var (String name, String type, Integer stack) {
	            this.name = name;
	            this.type = type;
	            this.stackPos = stack;
	        }

	        public boolean isOnStack() {
	            if (stackPos != null) {
	                return false;
	            }
	            return true;
	        }

	        public Integer getStackPos() {
	            return stackPos;
	        }

	        public String toString() {
	            return "{" + this.name + ", " + this.type + ", " + this.stackPos + "}";
	        }
	    }

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
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			main();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(29);
				match(NL);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(35);
				function();
				}
				}
				setState(40);
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
	public static class MainContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(PipescriptParser.FUNC, 0); }
		public TerminalNode MAIN() { return getToken(PipescriptParser.MAIN, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
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
			setState(41);
			match(FUNC);
			setState(42);
			match(MAIN);
			setState(43);
			match(PIPE);
			setState(44);
			match(OPEN_C);

			                if (!stackCounter.containsKey("main")) stackCounter.put("main", 0);

			                System.out.println(".source Output.j");
			                System.out.println(".class  public Output");
			                System.out.println(".super  java/lang/Object\n");
			                System.out.println(".method public <init>()V");
			                System.out.println("aload_0");
			                System.out.println("invokenonvirtual java/lang/Object/<init>()V");
			                System.out.println("return");
			                System.out.println(".end method\n");
			                System.out.println(".method public static main([Ljava/lang/String;)V\n");
			            
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 546557657088L) != 0)) {
				{
				{
				setState(46);
				statement("main");
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(CLOSE_C);
			setState(53);
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
	public static class FunctionContext extends ParserRuleContext {
		public Token VAR;
		public TerminalNode FUNC() { return getToken(PipescriptParser.FUNC, 0); }
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public TerminalNode OPEN_C() { return getToken(PipescriptParser.OPEN_C, 0); }
		public TerminalNode CLOSE_C() { return getToken(PipescriptParser.CLOSE_C, 0); }
		public TerminalNode NL() { return getToken(PipescriptParser.NL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(FUNC);
			setState(57);
			((FunctionContext)_localctx).VAR = match(VAR);
			setState(58);
			match(PIPE);
			setState(59);
			match(OPEN_C);

			                if (!stackCounter.containsKey((((FunctionContext)_localctx).VAR!=null?((FunctionContext)_localctx).VAR.getText():null))) stackCounter.put((((FunctionContext)_localctx).VAR!=null?((FunctionContext)_localctx).VAR.getText():null), 0);
			                System.out.println(".method public static "+ (((FunctionContext)_localctx).VAR!=null?((FunctionContext)_localctx).VAR.getText():null) +"([Ljava/lang/String;)V\n");
			            
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 546557657088L) != 0)) {
				{
				{
				setState(61);
				statement((((FunctionContext)_localctx).VAR!=null?((FunctionContext)_localctx).VAR.getText():null));
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(CLOSE_C);
			setState(68);
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
		public String funcName;
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
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final StatementContext statement(String funcName) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), funcName);
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				call_function(funcName);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				statement_if(funcName);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				statement_else(funcName);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				statement_while(funcName);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				assignment(funcName);
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
		public String funcName;
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
		public Statement_ifContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Statement_ifContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final Statement_ifContext statement_if(String funcName) throws RecognitionException {
		Statement_ifContext _localctx = new Statement_ifContext(_ctx, getState(), funcName);
		enterRule(_localctx, 8, RULE_statement_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempIf = ifCounter++; 
			setState(80);
			match(IF);
			setState(81);
			match(PIPE);
			setState(82);
			expression(funcName);
			setState(83);
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
			setState(84);
			expression(funcName);


			             emit(((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            
			setState(86);
			match(OPEN_C);
			setState(87);
			match(NL);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 546557657088L) != 0)) {
				{
				{
				setState(88);
				statement(funcName);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(CLOSE_C);
			setState(95);
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
		public String funcName;
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
		public Statement_elseContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Statement_elseContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final Statement_elseContext statement_else(String funcName) throws RecognitionException {
		Statement_elseContext _localctx = new Statement_elseContext(_ctx, getState(), funcName);
		enterRule(_localctx, 10, RULE_statement_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempIfElse = ifCounter++; 
			setState(99);
			match(IF);
			setState(100);
			match(PIPE);
			setState(101);
			expression(funcName);
			setState(102);
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
			setState(103);
			expression(funcName);
			 emit(((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); 
			setState(105);
			match(OPEN_C);
			setState(106);
			match(NL);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 546557657088L) != 0)) {
				{
				{
				setState(107);
				statement(funcName);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto END_IF_ELSE_" + tempIfElse + " ; "); 
			setState(114);
			match(CLOSE_C);
			setState(115);
			match(ELSE);
			setState(116);
			match(OPEN_C);
			setState(117);
			match(NL);
			 emit("NOT_IF_" + tempIfElse + ": "); 
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 546557657088L) != 0)) {
				{
				{
				setState(119);
				statement(funcName);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			match(CLOSE_C);
			setState(126);
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
		public String funcName;
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
		public Statement_whileContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Statement_whileContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final Statement_whileContext statement_while(String funcName) throws RecognitionException {
		Statement_whileContext _localctx = new Statement_whileContext(_ctx, getState(), funcName);
		enterRule(_localctx, 12, RULE_statement_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempWhile = ifCounter++;
			          emit("START_WHILE_" + tempWhile + ": ");
			        
			setState(130);
			match(WHILE);
			setState(131);
			match(PIPE);
			setState(132);
			expression(funcName);
			setState(133);
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
			setState(134);
			expression(funcName);
			 emit(((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); 
			setState(136);
			match(OPEN_C);
			setState(137);
			match(NL);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 546557657088L) != 0)) {
				{
				{
				setState(138);
				statement(funcName);
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto START_WHILE_" + tempWhile + " ; "); 
			setState(145);
			match(CLOSE_C);
			setState(146);
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
		public String funcName;
		public TerminalNode PRINT() { return getToken(PipescriptParser.PRINT, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Function_printIntegerContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_printIntegerContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final Function_printIntegerContext function_printInteger(String funcName) throws RecognitionException {
		Function_printIntegerContext _localctx = new Function_printIntegerContext(_ctx, getState(), funcName);
		enterRule(_localctx, 14, RULE_function_printInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(PRINT);
			setState(150);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(152);
			expression(funcName);
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
		enterRule(_localctx, 16, RULE_function_printString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(PRINT);
			setState(156);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(158);
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
		public String funcName;
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public Function_printIntegerContext function_printInteger() {
			return getRuleContext(Function_printIntegerContext.class,0);
		}
		public Function_printStringContext function_printString() {
			return getRuleContext(Function_printStringContext.class,0);
		}
		public Call_functionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Call_functionContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final Call_functionContext call_function(String funcName) throws RecognitionException {
		Call_functionContext _localctx = new Call_functionContext(_ctx, getState(), funcName);
		enterRule(_localctx, 18, RULE_call_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(162);
				function_printInteger(funcName);
				}
				break;
			case 2:
				{
				setState(163);
				function_printString();
				}
				break;
			}
			setState(166);
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
		public String funcName;
		public Token op;
		public Token VAR;
		public ExpressionContext exp;
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode ATTRIB() { return getToken(PipescriptParser.ATTRIB, 0); }
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public TerminalNode BOOL_VAR() { return getToken(PipescriptParser.BOOL_VAR, 0); }
		public TerminalNode CHAR_VAR() { return getToken(PipescriptParser.CHAR_VAR, 0); }
		public TerminalNode DOUBLE_VAR() { return getToken(PipescriptParser.DOUBLE_VAR, 0); }
		public TerminalNode STRING_VAR() { return getToken(PipescriptParser.STRING_VAR, 0); }
		public TerminalNode VOID_VAR() { return getToken(PipescriptParser.VOID_VAR, 0); }
		public TerminalNode NULL_VAR() { return getToken(PipescriptParser.NULL_VAR, 0); }
		public TerminalNode INT_VAR() { return getToken(PipescriptParser.INT_VAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AssignmentContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final AssignmentContext assignment(String funcName) throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState(), funcName);
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAR:
				{
				setState(168);
				((AssignmentContext)_localctx).op = match(INT_VAR);
				}
				break;
			case BOOL_VAR:
				{
				setState(169);
				match(BOOL_VAR);
				}
				break;
			case CHAR_VAR:
				{
				setState(170);
				match(CHAR_VAR);
				}
				break;
			case DOUBLE_VAR:
				{
				setState(171);
				match(DOUBLE_VAR);
				}
				break;
			case STRING_VAR:
				{
				setState(172);
				match(STRING_VAR);
				}
				break;
			case VOID_VAR:
				{
				setState(173);
				match(VOID_VAR);
				}
				break;
			case NULL_VAR:
				{
				setState(174);
				match(NULL_VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(177);
			((AssignmentContext)_localctx).VAR = match(VAR);
			setState(178);
			match(ATTRIB);
			{
			setState(179);
			((AssignmentContext)_localctx).exp = expression(funcName);
			}

			    	    List<Var> vars = memory.get(funcName);
			            if (vars == null) {
			                vars = new ArrayList<>();
			            }
			    	    boolean containsVar = vars.stream().anyMatch(var -> var.name.equals((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null)));
			    	    if (!containsVar) {
			                Integer stackCount = stackCounter.get(funcName);
			    	        Var newVar = new Var((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null), (((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null), stackCount);
			    	        stackCounter.put(funcName, stackCount++);
			                vars.add(newVar);
			                memory.put(funcName, vars);
			    	    }

			    	    final Var currentVar = memory.get(funcName)
			    	        .stream().filter(var -> var.name.equals((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null))).findFirst().get();

			    	    switch((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getType():0)) {
			    	        case INT_VAR:
			    	        case CHAR_VAR:
			    	            System.out.println("istore " + currentVar.stackPos);
			                    break;
			                case BOOL_VAR:
			    	            System.out.println("bstore " + currentVar.stackPos);
			                    break;
			                case DOUBLE_VAR:
			    	            System.out.println("dstore " + currentVar.stackPos);
			                    break;
			                default:
			                    System.err.println("undefined variable " + (((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null));
			            }
			        
			setState(181);
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
		public String funcName;
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final ExpressionContext expression(String funcName) throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState(), funcName);
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			term(funcName);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(184);
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
				setState(185);
				term(funcName);
				 System.out.println(((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getType():0) == PLUS) ? "iadd" : "isub"); 
				}
				}
				setState(192);
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
		public String funcName;
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
		public List<TerminalNode> DIV() { return getTokens(PipescriptParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PipescriptParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final TermContext term(String funcName) throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState(), funcName);
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			factor(funcName);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIV) {
				{
				{
				setState(194);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(195);
				factor(funcName);
				 System.out.println(((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getType():0) == TIMES) ? "imul" : "idiv"); 
				}
				}
				setState(202);
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
		public String funcName;
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
		public FactorContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FactorContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
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

	public final FactorContext factor(String funcName) throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState(), funcName);
		enterRule(_localctx, 26, RULE_factor);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((FactorContext)_localctx).NUM = match(NUM);
				 System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				((FactorContext)_localctx).VAR = match(VAR);

				    	    Var var = memory.get(funcName)
				    	        .stream().filter(v -> v.name.equals((((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null))).findFirst().get();
				            if (var != null)  System.out.println("iload " + var.stackPos);
				            else System.err.println("undefined variable " + (((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				    	
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				((FactorContext)_localctx).VAR = match(VAR);
				setState(208);
				match(OPEN_B);
				setState(209);
				((FactorContext)_localctx).NUM = match(NUM);
				setState(210);
				match(CLOSE_B);

				            Var var = memory.get(funcName)
				                	        .stream().filter(v -> v.name.equals((((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null))).findFirst().get();
				            if (var != null)  System.out.println("aload " + var.stackPos);
				            else System.err.println("undefined variable " + (((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				            System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null));
				            System.out.println("iaload");
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				match(OPEN_P);
				setState(213);
				expression(funcName);
				setState(214);
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
		"\u0004\u0001&\u00db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0005\u0000\u001f\b"+
		"\u0000\n\u0000\f\u0000\"\t\u0000\u0001\u0000\u0005\u0000%\b\u0000\n\u0000"+
		"\f\u0000(\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u00010\b\u0001\n\u0001\f\u00013\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002?\b\u0002\n\u0002"+
		"\f\u0002B\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003N\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004Z\b\u0004\n\u0004\f\u0004]\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005m\b\u0005\n\u0005\f\u0005p\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005y\b"+
		"\u0005\n\u0005\f\u0005|\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u008c"+
		"\b\u0006\n\u0006\f\u0006\u008f\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0003\t\u00a5\b\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b0\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00bd\b\u000b\n\u000b\f\u000b\u00c0"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00c7\b\f\n\f"+
		"\f\f\u00ca\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d9\b\r\u0001"+
		"\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u0000\u0003\u0001\u0000\r\u0012\u0001\u0000\u0001\u0002"+
		"\u0001\u0000\u0003\u0004\u00e5\u0000\u001c\u0001\u0000\u0000\u0000\u0002"+
		")\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000\u0000\u0006M\u0001"+
		"\u0000\u0000\u0000\bO\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000"+
		"\f\u0081\u0001\u0000\u0000\u0000\u000e\u0095\u0001\u0000\u0000\u0000\u0010"+
		"\u009b\u0001\u0000\u0000\u0000\u0012\u00a4\u0001\u0000\u0000\u0000\u0014"+
		"\u00af\u0001\u0000\u0000\u0000\u0016\u00b7\u0001\u0000\u0000\u0000\u0018"+
		"\u00c1\u0001\u0000\u0000\u0000\u001a\u00d8\u0001\u0000\u0000\u0000\u001c"+
		" \u0003\u0002\u0001\u0000\u001d\u001f\u0005\u001e\u0000\u0000\u001e\u001d"+
		"\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!&\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'\u0001\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		")*\u0005\u0013\u0000\u0000*+\u0005\u0014\u0000\u0000+,\u0005\u000b\u0000"+
		"\u0000,-\u0005\u0005\u0000\u0000-1\u0006\u0001\uffff\uffff\u0000.0\u0003"+
		"\u0006\u0003\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000045\u0005\u0006\u0000\u000056\u0005\u001e"+
		"\u0000\u000067\u0006\u0001\uffff\uffff\u00007\u0003\u0001\u0000\u0000"+
		"\u000089\u0005\u0013\u0000\u00009:\u0005\u001b\u0000\u0000:;\u0005\u000b"+
		"\u0000\u0000;<\u0005\u0005\u0000\u0000<@\u0006\u0002\uffff\uffff\u0000"+
		"=?\u0003\u0006\u0003\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000"+
		"\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0005\u0006\u0000\u0000DE\u0005"+
		"\u001e\u0000\u0000EF\u0006\u0002\uffff\uffff\u0000F\u0005\u0001\u0000"+
		"\u0000\u0000GN\u0005\u001e\u0000\u0000HN\u0003\u0012\t\u0000IN\u0003\b"+
		"\u0004\u0000JN\u0003\n\u0005\u0000KN\u0003\f\u0006\u0000LN\u0003\u0014"+
		"\n\u0000MG\u0001\u0000\u0000\u0000MH\u0001\u0000\u0000\u0000MI\u0001\u0000"+
		"\u0000\u0000MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000ML\u0001"+
		"\u0000\u0000\u0000N\u0007\u0001\u0000\u0000\u0000OP\u0006\u0004\uffff"+
		"\uffff\u0000PQ\u0005\u0016\u0000\u0000QR\u0005\u000b\u0000\u0000RS\u0003"+
		"\u0016\u000b\u0000ST\u0007\u0000\u0000\u0000TU\u0003\u0016\u000b\u0000"+
		"UV\u0006\u0004\uffff\uffff\u0000VW\u0005\u0005\u0000\u0000W[\u0005\u001e"+
		"\u0000\u0000XZ\u0003\u0006\u0003\u0000YX\u0001\u0000\u0000\u0000Z]\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\u0006\u0000"+
		"\u0000_`\u0005\u001e\u0000\u0000`a\u0006\u0004\uffff\uffff\u0000a\t\u0001"+
		"\u0000\u0000\u0000bc\u0006\u0005\uffff\uffff\u0000cd\u0005\u0016\u0000"+
		"\u0000de\u0005\u000b\u0000\u0000ef\u0003\u0016\u000b\u0000fg\u0007\u0000"+
		"\u0000\u0000gh\u0003\u0016\u000b\u0000hi\u0006\u0005\uffff\uffff\u0000"+
		"ij\u0005\u0005\u0000\u0000jn\u0005\u001e\u0000\u0000km\u0003\u0006\u0003"+
		"\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000qr\u0006\u0005\uffff\uffff\u0000rs\u0005\u0006\u0000"+
		"\u0000st\u0005\u0017\u0000\u0000tu\u0005\u0005\u0000\u0000uv\u0005\u001e"+
		"\u0000\u0000vz\u0006\u0005\uffff\uffff\u0000wy\u0003\u0006\u0003\u0000"+
		"xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000}~\u0005\u0006\u0000\u0000~\u007f\u0005\u001e\u0000\u0000"+
		"\u007f\u0080\u0006\u0005\uffff\uffff\u0000\u0080\u000b\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0006\u0006\uffff\uffff\u0000\u0082\u0083\u0005\u0018"+
		"\u0000\u0000\u0083\u0084\u0005\u000b\u0000\u0000\u0084\u0085\u0003\u0016"+
		"\u000b\u0000\u0085\u0086\u0007\u0000\u0000\u0000\u0086\u0087\u0003\u0016"+
		"\u000b\u0000\u0087\u0088\u0006\u0006\uffff\uffff\u0000\u0088\u0089\u0005"+
		"\u0005\u0000\u0000\u0089\u008d\u0005\u001e\u0000\u0000\u008a\u008c\u0003"+
		"\u0006\u0003\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0006\u0006\uffff\uffff\u0000\u0091\u0092"+
		"\u0005\u0006\u0000\u0000\u0092\u0093\u0005\u001e\u0000\u0000\u0093\u0094"+
		"\u0006\u0006\uffff\uffff\u0000\u0094\r\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005\u0015\u0000\u0000\u0096\u0097\u0005\u000b\u0000\u0000\u0097\u0098"+
		"\u0006\u0007\uffff\uffff\u0000\u0098\u0099\u0003\u0016\u000b\u0000\u0099"+
		"\u009a\u0006\u0007\uffff\uffff\u0000\u009a\u000f\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0005\u0015\u0000\u0000\u009c\u009d\u0005\u000b\u0000\u0000"+
		"\u009d\u009e\u0006\b\uffff\uffff\u0000\u009e\u009f\u0005\u001d\u0000\u0000"+
		"\u009f\u00a0\u0006\b\uffff\uffff\u0000\u00a0\u00a1\u0006\b\uffff\uffff"+
		"\u0000\u00a1\u0011\u0001\u0000\u0000\u0000\u00a2\u00a5\u0003\u000e\u0007"+
		"\u0000\u00a3\u00a5\u0003\u0010\b\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005\u001a\u0000\u0000\u00a7\u0013\u0001\u0000\u0000\u0000"+
		"\u00a8\u00b0\u0005 \u0000\u0000\u00a9\u00b0\u0005$\u0000\u0000\u00aa\u00b0"+
		"\u0005#\u0000\u0000\u00ab\u00b0\u0005!\u0000\u0000\u00ac\u00b0\u0005\""+
		"\u0000\u0000\u00ad\u00b0\u0005%\u0000\u0000\u00ae\u00b0\u0005&\u0000\u0000"+
		"\u00af\u00a8\u0001\u0000\u0000\u0000\u00af\u00a9\u0001\u0000\u0000\u0000"+
		"\u00af\u00aa\u0001\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000\u0000"+
		"\u00af\u00ac\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0005\u001b\u0000\u0000\u00b2\u00b3\u0005\f\u0000\u0000\u00b3"+
		"\u00b4\u0003\u0016\u000b\u0000\u00b4\u00b5\u0006\n\uffff\uffff\u0000\u00b5"+
		"\u00b6\u0005\u001a\u0000\u0000\u00b6\u0015\u0001\u0000\u0000\u0000\u00b7"+
		"\u00be\u0003\u0018\f\u0000\u00b8\u00b9\u0007\u0001\u0000\u0000\u00b9\u00ba"+
		"\u0003\u0018\f\u0000\u00ba\u00bb\u0006\u000b\uffff\uffff\u0000\u00bb\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b8\u0001\u0000\u0000\u0000\u00bd\u00c0"+
		"\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u0017\u0001\u0000\u0000\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c8\u0003\u001a\r\u0000\u00c2\u00c3\u0007"+
		"\u0002\u0000\u0000\u00c3\u00c4\u0003\u001a\r\u0000\u00c4\u00c5\u0006\f"+
		"\uffff\uffff\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u0019\u0001"+
		"\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005"+
		"\u001c\u0000\u0000\u00cc\u00d9\u0006\r\uffff\uffff\u0000\u00cd\u00ce\u0005"+
		"\u001b\u0000\u0000\u00ce\u00d9\u0006\r\uffff\uffff\u0000\u00cf\u00d0\u0005"+
		"\u001b\u0000\u0000\u00d0\u00d1\u0005\u0007\u0000\u0000\u00d1\u00d2\u0005"+
		"\u001c\u0000\u0000\u00d2\u00d3\u0005\b\u0000\u0000\u00d3\u00d9\u0006\r"+
		"\uffff\uffff\u0000\u00d4\u00d5\u0005\t\u0000\u0000\u00d5\u00d6\u0003\u0016"+
		"\u000b\u0000\u00d6\u00d7\u0005\n\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d8\u00cb\u0001\u0000\u0000\u0000\u00d8\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d8\u00cf\u0001\u0000\u0000\u0000\u00d8\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d9\u001b\u0001\u0000\u0000\u0000\u000e &1@M[nz\u008d\u00a4\u00af"+
		"\u00be\u00c8\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}