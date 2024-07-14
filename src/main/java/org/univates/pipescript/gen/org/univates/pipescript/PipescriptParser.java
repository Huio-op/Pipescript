// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.function.Function;
    import java.util.Optional;
    import java.util.ArrayList;

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
		OPEN_P=9, CLOSE_P=10, PIPE=11, ATTRIB=12, RETURN=13, EQUAL=14, DIFFER=15, 
		LESSER=16, LESSER_EQUAL=17, GREATER=18, GREATER_EQUAL=19, FUNC=20, MAIN=21, 
		PRINT=22, IF=23, ELSE=24, WHILE=25, COMMA=26, SEMICOLON=27, VAR=28, NUM=29, 
		STRING=30, NL=31, WS=32, INT_VAR=33, DOUBLE_VAR=34, STRING_VAR=35, CHAR_VAR=36, 
		BOOL_VAR=37, VOID_VAR=38, NULL_VAR=39;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_function = 2, RULE_statement = 3, 
		RULE_statement_if = 4, RULE_statement_else = 5, RULE_statement_while = 6, 
		RULE_function_printInteger = 7, RULE_function_printString = 8, RULE_function_customCall = 9, 
		RULE_call_function = 10, RULE_assignment = 11, RULE_expression = 12, RULE_term = 13, 
		RULE_factor = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "function", "statement", "statement_if", "statement_else", 
			"statement_while", "function_printInteger", "function_printString", "function_customCall", 
			"call_function", "assignment", "expression", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'", "'|'", "'<<'", "'>>'", "'is'", "'not'", "'lt'", "'lte'", "'gt'", 
			"'gte'", "'fun'", "'main'", "'text'", "'if'", "'else'", "'while'", "','", 
			"';'", null, null, null, null, null, "'int'", "'double'", "'str'", "'char'", 
			"'bool'", "'void'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "TIMES", "DIV", "OPEN_C", "CLOSE_C", "OPEN_B", 
			"CLOSE_B", "OPEN_P", "CLOSE_P", "PIPE", "ATTRIB", "RETURN", "EQUAL", 
			"DIFFER", "LESSER", "LESSER_EQUAL", "GREATER", "GREATER_EQUAL", "FUNC", 
			"MAIN", "PRINT", "IF", "ELSE", "WHILE", "COMMA", "SEMICOLON", "VAR", 
			"NUM", "STRING", "NL", "WS", "INT_VAR", "DOUBLE_VAR", "STRING_VAR", "CHAR_VAR", 
			"BOOL_VAR", "VOID_VAR", "NULL_VAR"
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
	    Map<String, Map<String, Integer>> stackCounter = new LinkedHashMap<String, Map<String, Integer>>();
	    List<CustomFunction> functions = new ArrayList();
	    Integer counter = 1;
	    Integer ifCounter = 1;

	    public static class CustomFunction {
	        public String name;
	        public List<String> receivedTypes;
	        public String returnType;

	        public CustomFunction (String name, List<String> receivedTypes, String returnType) {
	            this.name = name;
	            this.receivedTypes = receivedTypes;
	            this.returnType = returnType;
	        }
	    }

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
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

			            System.out.println(".source Output.j");
			            System.out.println(".class  public Output");
			            System.out.println(".super  java/lang/Object\n");
			            System.out.println(".method public <init>()V");
			            System.out.println("aload_0");
			            System.out.println("invokenonvirtual java/lang/Object/<init>()V");
			            System.out.println("return");
			            System.out.println(".end method\n");
			        
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					function();
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(37);
				match(NL);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
			setState(45);
			match(FUNC);
			setState(46);
			match(MAIN);
			setState(47);
			match(PIPE);
			setState(48);
			match(OPEN_C);

			                if (!stackCounter.containsKey("main")) stackCounter.put("main", new LinkedHashMap<String, Integer>());

			                System.out.println(".method public static main([Ljava/lang/String;)V\n");
			            
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(50);
				statement("main");
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(CLOSE_C);
			setState(57);
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
		public Token name;
		public Token INT_VAR;
		public List<Token> types = new ArrayList<Token>();
		public Token BOOL_VAR;
		public Token CHAR_VAR;
		public Token DOUBLE_VAR;
		public Token STRING_VAR;
		public Token _tset428;
		public Token VAR;
		public List<Token> vars = new ArrayList<Token>();
		public Token _tset458;
		public Token ret;
		public TerminalNode FUNC() { return getToken(PipescriptParser.FUNC, 0); }
		public List<TerminalNode> PIPE() { return getTokens(PipescriptParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(PipescriptParser.PIPE, i);
		}
		public TerminalNode OPEN_C() { return getToken(PipescriptParser.OPEN_C, 0); }
		public TerminalNode RETURN() { return getToken(PipescriptParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
		}
		public TerminalNode CLOSE_C() { return getToken(PipescriptParser.CLOSE_C, 0); }
		public List<TerminalNode> BOOL_VAR() { return getTokens(PipescriptParser.BOOL_VAR); }
		public TerminalNode BOOL_VAR(int i) {
			return getToken(PipescriptParser.BOOL_VAR, i);
		}
		public List<TerminalNode> CHAR_VAR() { return getTokens(PipescriptParser.CHAR_VAR); }
		public TerminalNode CHAR_VAR(int i) {
			return getToken(PipescriptParser.CHAR_VAR, i);
		}
		public List<TerminalNode> DOUBLE_VAR() { return getTokens(PipescriptParser.DOUBLE_VAR); }
		public TerminalNode DOUBLE_VAR(int i) {
			return getToken(PipescriptParser.DOUBLE_VAR, i);
		}
		public List<TerminalNode> STRING_VAR() { return getTokens(PipescriptParser.STRING_VAR); }
		public TerminalNode STRING_VAR(int i) {
			return getToken(PipescriptParser.STRING_VAR, i);
		}
		public TerminalNode VOID_VAR() { return getToken(PipescriptParser.VOID_VAR, 0); }
		public List<TerminalNode> VAR() { return getTokens(PipescriptParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(PipescriptParser.VAR, i);
		}
		public List<TerminalNode> INT_VAR() { return getTokens(PipescriptParser.INT_VAR); }
		public TerminalNode INT_VAR(int i) {
			return getToken(PipescriptParser.INT_VAR, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PipescriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PipescriptParser.COMMA, i);
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

			        List<String> types = new ArrayList();
			        List<String> names = new ArrayList();
			    
			setState(61);
			match(FUNC);
			{
			setState(62);
			((FunctionContext)_localctx).name = match(VAR);
			}
			setState(63);
			match(PIPE);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266287972352L) != 0)) {
				{
				setState(64);
				((FunctionContext)_localctx)._tset428 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 266287972352L) != 0)) ) {
					((FunctionContext)_localctx)._tset428 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((FunctionContext)_localctx).types.add(((FunctionContext)_localctx)._tset428);
				setState(65);
				((FunctionContext)_localctx).VAR = match(VAR);
				((FunctionContext)_localctx).vars.add(((FunctionContext)_localctx).VAR);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(66);
					match(COMMA);
					setState(67);
					((FunctionContext)_localctx)._tset458 = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 266287972352L) != 0)) ) {
						((FunctionContext)_localctx)._tset458 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((FunctionContext)_localctx).types.add(((FunctionContext)_localctx)._tset458);
					setState(68);
					((FunctionContext)_localctx).VAR = match(VAR);
					((FunctionContext)_localctx).vars.add(((FunctionContext)_localctx).VAR);
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(76);
			match(PIPE);
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAR:
				{
				setState(77);
				((FunctionContext)_localctx).ret = match(INT_VAR);
				}
				break;
			case BOOL_VAR:
				{
				setState(78);
				match(BOOL_VAR);
				}
				break;
			case CHAR_VAR:
				{
				setState(79);
				match(CHAR_VAR);
				}
				break;
			case DOUBLE_VAR:
				{
				setState(80);
				match(DOUBLE_VAR);
				}
				break;
			case STRING_VAR:
				{
				setState(81);
				match(STRING_VAR);
				}
				break;
			case VOID_VAR:
				{
				setState(82);
				match(VOID_VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(85);
			match(OPEN_C);

			                if (!stackCounter.containsKey((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null))) stackCounter.put((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null), new LinkedHashMap());

			                final List<Var> receivedVars = new ArrayList();
			                for (int i = 0; i < ((FunctionContext)_localctx).types.size(); i++) {
			                    final String type = ((FunctionContext)_localctx).types.get(i).getText();
			                    final String name = ((FunctionContext)_localctx).vars.get(i).getText();

			                    Map<String, Integer> stackTypes = stackCounter.get((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
			                    Integer count = stackTypes.get(type);
			                    if (count == null) {
			                        count = 0;
			                    }
			                    final Var var = new Var(name, type, count);
			                    receivedVars.add(var);

			                    stackTypes.put(type, count++);
			                    stackCounter.put((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null), stackTypes);
			                }
			                if (memory.containsKey((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null))) {
			                    System.err.println("function being overwritten " + (((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
			                }

			                memory.put((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null), receivedVars);
			                functions.add(new CustomFunction((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null), ((FunctionContext)_localctx).types.stream().map(t -> t.getText()).toList(), (((FunctionContext)_localctx).ret!=null?((FunctionContext)_localctx).ret.getText():null)));

			                String returnType = switch((((FunctionContext)_localctx).ret!=null?((FunctionContext)_localctx).ret.getType():0)) {
			                    case INT_VAR:
			                        yield "I";
			                    case BOOL_VAR:
			                        yield "i";
			                    case CHAR_VAR:
			                        yield "i";
			                    case DOUBLE_VAR:
			                        yield "F";
			                    case STRING_VAR:
			                        yield "Ljava/lang/String;";
			                    default:
			                        yield "V";
			                };

			                final Function<String, String> getTypeString = (String type) -> {
			                    return switch(type) {
			                        case "int":
			                            yield "I";
			                        case "bool":
			                            yield "B";
			                        case "char":
			                            yield "C";
			                        case "double":
			                            yield "F";
			                        case "str":
			                            yield "Ljava/lang/String;";
			                        default:
			                            yield "V";
			                    };
			                };
			                String receivedTypes = receivedVars.stream()
			                    .map(v -> getTypeString.apply(v.type))
			                    .reduce("", String::concat);

			                System.out.println(".method public static "+ (((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null) +"("+ receivedTypes +")"+ returnType +"\n");
			            
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(87);
				statement((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(RETURN);
			setState(94);
			expression((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
			setState(95);
			match(SEMICOLON);
			setState(96);
			match(NL);
			setState(97);
			match(CLOSE_C);
			setState(98);
			match(NL);

			                switch((((FunctionContext)_localctx).ret!=null?((FunctionContext)_localctx).ret.getType():0)) {
			                    case INT_VAR:
			                    case BOOL_VAR:
			                    case CHAR_VAR:
			                        System.out.println("ireturn");
			                        break;
			                    case DOUBLE_VAR:
			                        System.out.println("dreturn");
			                        break;
			                    case STRING_VAR:
			                        System.out.println("areturn");
			                        break;
			                    default:
			                        System.out.println("return");
			                        break;
			                };
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
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				call_function(funcName);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				statement_if(funcName);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				statement_else(funcName);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				statement_while(funcName);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
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
			setState(110);
			match(IF);
			setState(111);
			match(PIPE);
			setState(112);
			expression(funcName);
			setState(113);
			((Statement_ifContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0)) ) {
				((Statement_ifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(114);
			expression(funcName);


			             emit(((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            
			setState(116);
			match(OPEN_C);
			setState(117);
			match(NL);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(118);
				statement(funcName);
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(CLOSE_C);
			setState(125);
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
			setState(129);
			match(IF);
			setState(130);
			match(PIPE);
			setState(131);
			expression(funcName);
			setState(132);
			((Statement_elseContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0)) ) {
				((Statement_elseContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(133);
			expression(funcName);
			 emit(((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); 
			setState(135);
			match(OPEN_C);
			setState(136);
			match(NL);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(137);
				statement(funcName);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto END_IF_ELSE_" + tempIfElse + " ; "); 
			setState(144);
			match(CLOSE_C);
			setState(145);
			match(ELSE);
			setState(146);
			match(OPEN_C);
			setState(147);
			match(NL);
			 emit("NOT_IF_" + tempIfElse + ": "); 
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(149);
				statement(funcName);
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(CLOSE_C);
			setState(156);
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
			        
			setState(160);
			match(WHILE);
			setState(161);
			match(PIPE);
			setState(162);
			expression(funcName);
			setState(163);
			((Statement_whileContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0)) ) {
				((Statement_whileContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(164);
			expression(funcName);
			 emit(((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); 
			setState(166);
			match(OPEN_C);
			setState(167);
			match(NL);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(168);
				statement(funcName);
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto START_WHILE_" + tempWhile + " ; "); 
			setState(175);
			match(CLOSE_C);
			setState(176);
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
			setState(179);
			match(PRINT);
			setState(180);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(182);
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
			setState(185);
			match(PRINT);
			setState(186);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(188);
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
	public static class Function_customCallContext extends ParserRuleContext {
		public String funcName;
		public Token funcCall;
		public Token VAR;
		public List<Token> vars = new ArrayList<Token>();
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public List<TerminalNode> VAR() { return getTokens(PipescriptParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(PipescriptParser.VAR, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PipescriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PipescriptParser.COMMA, i);
		}
		public Function_customCallContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_customCallContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_function_customCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_customCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_customCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_customCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_customCallContext function_customCall(String funcName) throws RecognitionException {
		Function_customCallContext _localctx = new Function_customCallContext(_ctx, getState(), funcName);
		enterRule(_localctx, 18, RULE_function_customCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(192);
			((Function_customCallContext)_localctx).funcCall = match(VAR);
			}
			setState(193);
			match(PIPE);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805306880L) != 0)) {
				{
				setState(196);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(194);
					((Function_customCallContext)_localctx).VAR = match(VAR);
					((Function_customCallContext)_localctx).vars.add(((Function_customCallContext)_localctx).VAR);
					}
					break;
				case 2:
					{
					setState(195);
					expression(funcName);
					}
					break;
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(201);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(199);
						((Function_customCallContext)_localctx).VAR = match(VAR);
						((Function_customCallContext)_localctx).vars.add(((Function_customCallContext)_localctx).VAR);
						}
						break;
					case 2:
						{
						setState(200);
						expression(funcName);
						}
						break;
					}
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}



			            final Optional<CustomFunction> optFun = functions.stream().filter(f -> f.name.equals((((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null))).findFirst();
			            if (!optFun.isPresent()) {
			               System.err.println("Undefined function " + (((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null));
			               throw new RuntimeException("Undefined function " + (((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null));
			            }

			            final CustomFunction fun = optFun.get();

			            final Function<String, String> getTypeString = (String type) -> {
			                return switch(type) {
			                    case "int":
			                        yield "I";
			                    case "bool":
			                        yield "B";
			                    case "char":
			                        yield "C";
			                    case "double":
			                        yield "F";
			                    case "str":
			                        yield "Ljava/lang/String;";
			                    default:
			                        yield "V";
			                };
			            };
			            final String receivedTypes = fun.receivedTypes.stream()
			                .map(v -> getTypeString.apply(v))
			                .reduce("", String::concat);
			            final String returnType = getTypeString.apply(fun.returnType);

			            List<Var> memoryVars = memory.get(funcName);
			            for (int i = 0; i < ((Function_customCallContext)_localctx).vars.size(); i++) {
			                String varName = ((Function_customCallContext)_localctx).vars.get(i).getText();
			                Var currentVar = memoryVars.stream().filter(mv -> mv.name.equals(varName)).findFirst()
			                    .orElse(null);
			                if (currentVar == null) {
			                   System.err.println("Unknown variable " + varName + " in function call " + (((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null));
			                   throw new RuntimeException("Unknown variable " + varName + " in function call " + (((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null));
			                }
			                switch (currentVar.type) {
			                    case "int":
			                    case "bool":
			                    case "char":
			                        System.out.println("iload " + currentVar.stackPos);
			                        break;
			                    case "double":
			                        System.out.println("dload " + currentVar.stackPos);
			                        break;
			                    case "str":
			                        System.out.println("aload " + currentVar.stackPos);
			                        break;
			                    default:
			                        System.out.println("iload " + currentVar.stackPos);
			                        break;
			                }
			            }

			            System.out.println("invokestatic Output/"+ fun.name +"("+ receivedTypes +")"+ returnType +"\n");
			        
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
		public Function_customCallContext function_customCall() {
			return getRuleContext(Function_customCallContext.class,0);
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
		enterRule(_localctx, 20, RULE_call_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(212);
				function_printInteger(funcName);
				}
				break;
			case 2:
				{
				setState(213);
				function_printString();
				}
				break;
			case 3:
				{
				setState(214);
				function_customCall(funcName);
				}
				break;
			}
			setState(217);
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
		enterRule(_localctx, 22, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAR:
				{
				setState(219);
				((AssignmentContext)_localctx).op = match(INT_VAR);
				}
				break;
			case BOOL_VAR:
				{
				setState(220);
				match(BOOL_VAR);
				}
				break;
			case CHAR_VAR:
				{
				setState(221);
				match(CHAR_VAR);
				}
				break;
			case DOUBLE_VAR:
				{
				setState(222);
				match(DOUBLE_VAR);
				}
				break;
			case STRING_VAR:
				{
				setState(223);
				match(STRING_VAR);
				}
				break;
			case VOID_VAR:
				{
				setState(224);
				match(VOID_VAR);
				}
				break;
			case NULL_VAR:
				{
				setState(225);
				match(NULL_VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(228);
			((AssignmentContext)_localctx).VAR = match(VAR);
			setState(229);
			match(ATTRIB);
			{
			setState(230);
			((AssignmentContext)_localctx).exp = expression(funcName);
			}

			    	    List<Var> vars = memory.get(funcName);
			            if (vars == null) {
			                vars = new ArrayList<>();
			            }
			    	    boolean containsVar = vars.stream().anyMatch(var -> var.name.equals((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null)));
			    	    if (!containsVar) {
			                Map<String, Integer> stackTypes = stackCounter.get(funcName);
			                Integer stackCount = stackTypes.get((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null));
			                if (stackCount == null) {
			                    stackCount = 0;
			                }
			    	        Var newVar = new Var((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null), (((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null), stackCount);
			    	        stackTypes.put((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null), stackCount++);
			    	        stackCounter.put(funcName, stackTypes);
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
			        
			setState(232);
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
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			term(funcName);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(235);
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
				setState(236);
				term(funcName);
				 System.out.println(((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getType():0) == PLUS) ? "iadd" : "isub"); 
				}
				}
				setState(243);
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
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			factor(funcName);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIV) {
				{
				{
				setState(245);
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
				setState(246);
				factor(funcName);
				 System.out.println(((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getType():0) == TIMES) ? "imul" : "idiv"); 
				}
				}
				setState(253);
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
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				((FactorContext)_localctx).NUM = match(NUM);
				 System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
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
				setState(258);
				((FactorContext)_localctx).VAR = match(VAR);
				setState(259);
				match(OPEN_B);
				setState(260);
				((FactorContext)_localctx).NUM = match(NUM);
				setState(261);
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
				setState(263);
				match(OPEN_P);
				setState(264);
				expression(funcName);
				setState(265);
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
		"\u0004\u0001\'\u010e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0005\u0000"+
		"\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"4\b\u0001\n\u0001\f\u00017\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002F\b\u0002"+
		"\n\u0002\f\u0002I\t\u0002\u0003\u0002K\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"T\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002Y\b\u0002\n\u0002"+
		"\f\u0002\\\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003l\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004x\b\u0004\n\u0004"+
		"\f\u0004{\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u008b\b\u0005\n"+
		"\u0005\f\u0005\u008e\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0097\b\u0005\n"+
		"\u0005\f\u0005\u009a\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00aa"+
		"\b\u0006\n\u0006\f\u0006\u00ad\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c5\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00ca\b\t\u0005\t\u00cc\b\t\n\t\f\t\u00cf\t\t\u0003"+
		"\t\u00d1\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u00d8\b\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e3\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u00f0\b\f\n\f\f\f\u00f3\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u00fa\b\r\n\r\f\r\u00fd\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u010c\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0004"+
		"\u0001\u0000!%\u0001\u0000\u000e\u0013\u0001\u0000\u0001\u0002\u0001\u0000"+
		"\u0003\u0004\u0123\u0000\u001e\u0001\u0000\u0000\u0000\u0002-\u0001\u0000"+
		"\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006k\u0001\u0000\u0000\u0000"+
		"\bm\u0001\u0000\u0000\u0000\n\u0080\u0001\u0000\u0000\u0000\f\u009f\u0001"+
		"\u0000\u0000\u0000\u000e\u00b3\u0001\u0000\u0000\u0000\u0010\u00b9\u0001"+
		"\u0000\u0000\u0000\u0012\u00c0\u0001\u0000\u0000\u0000\u0014\u00d7\u0001"+
		"\u0000\u0000\u0000\u0016\u00e2\u0001\u0000\u0000\u0000\u0018\u00ea\u0001"+
		"\u0000\u0000\u0000\u001a\u00f4\u0001\u0000\u0000\u0000\u001c\u010b\u0001"+
		"\u0000\u0000\u0000\u001e\"\u0006\u0000\uffff\uffff\u0000\u001f!\u0003"+
		"\u0004\u0002\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001\u0000\u0000"+
		"\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#(\u0001\u0000"+
		"\u0000\u0000$\"\u0001\u0000\u0000\u0000%\'\u0005\u001f\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000+,\u0003\u0002\u0001\u0000,\u0001\u0001\u0000\u0000\u0000-.\u0005"+
		"\u0014\u0000\u0000./\u0005\u0015\u0000\u0000/0\u0005\u000b\u0000\u0000"+
		"01\u0005\u0005\u0000\u000015\u0006\u0001\uffff\uffff\u000024\u0003\u0006"+
		"\u0003\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u000089\u0005\u0006\u0000\u00009:\u0005\u001f\u0000"+
		"\u0000:;\u0006\u0001\uffff\uffff\u0000;\u0003\u0001\u0000\u0000\u0000"+
		"<=\u0006\u0002\uffff\uffff\u0000=>\u0005\u0014\u0000\u0000>?\u0005\u001c"+
		"\u0000\u0000?J\u0005\u000b\u0000\u0000@A\u0007\u0000\u0000\u0000AG\u0005"+
		"\u001c\u0000\u0000BC\u0005\u001a\u0000\u0000CD\u0007\u0000\u0000\u0000"+
		"DF\u0005\u001c\u0000\u0000EB\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HK\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000J@\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LS\u0005\u000b\u0000\u0000"+
		"MT\u0005!\u0000\u0000NT\u0005%\u0000\u0000OT\u0005$\u0000\u0000PT\u0005"+
		"\"\u0000\u0000QT\u0005#\u0000\u0000RT\u0005&\u0000\u0000SM\u0001\u0000"+
		"\u0000\u0000SN\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000SP\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UV\u0005\u0005\u0000\u0000VZ\u0006\u0002\uffff"+
		"\uffff\u0000WY\u0003\u0006\u0003\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001"+
		"\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\r\u0000"+
		"\u0000^_\u0003\u0018\f\u0000_`\u0005\u001b\u0000\u0000`a\u0005\u001f\u0000"+
		"\u0000ab\u0005\u0006\u0000\u0000bc\u0005\u001f\u0000\u0000cd\u0006\u0002"+
		"\uffff\uffff\u0000d\u0005\u0001\u0000\u0000\u0000el\u0005\u001f\u0000"+
		"\u0000fl\u0003\u0014\n\u0000gl\u0003\b\u0004\u0000hl\u0003\n\u0005\u0000"+
		"il\u0003\f\u0006\u0000jl\u0003\u0016\u000b\u0000ke\u0001\u0000\u0000\u0000"+
		"kf\u0001\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000l\u0007\u0001"+
		"\u0000\u0000\u0000mn\u0006\u0004\uffff\uffff\u0000no\u0005\u0017\u0000"+
		"\u0000op\u0005\u000b\u0000\u0000pq\u0003\u0018\f\u0000qr\u0007\u0001\u0000"+
		"\u0000rs\u0003\u0018\f\u0000st\u0006\u0004\uffff\uffff\u0000tu\u0005\u0005"+
		"\u0000\u0000uy\u0005\u001f\u0000\u0000vx\u0003\u0006\u0003\u0000wv\u0001"+
		"\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000|}\u0005\u0006\u0000\u0000}~\u0005\u001f\u0000\u0000~\u007f\u0006"+
		"\u0004\uffff\uffff\u0000\u007f\t\u0001\u0000\u0000\u0000\u0080\u0081\u0006"+
		"\u0005\uffff\uffff\u0000\u0081\u0082\u0005\u0017\u0000\u0000\u0082\u0083"+
		"\u0005\u000b\u0000\u0000\u0083\u0084\u0003\u0018\f\u0000\u0084\u0085\u0007"+
		"\u0001\u0000\u0000\u0085\u0086\u0003\u0018\f\u0000\u0086\u0087\u0006\u0005"+
		"\uffff\uffff\u0000\u0087\u0088\u0005\u0005\u0000\u0000\u0088\u008c\u0005"+
		"\u001f\u0000\u0000\u0089\u008b\u0003\u0006\u0003\u0000\u008a\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0001"+
		"\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0006"+
		"\u0005\uffff\uffff\u0000\u0090\u0091\u0005\u0006\u0000\u0000\u0091\u0092"+
		"\u0005\u0018\u0000\u0000\u0092\u0093\u0005\u0005\u0000\u0000\u0093\u0094"+
		"\u0005\u001f\u0000\u0000\u0094\u0098\u0006\u0005\uffff\uffff\u0000\u0095"+
		"\u0097\u0003\u0006\u0003\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0006\u0000\u0000\u009c"+
		"\u009d\u0005\u001f\u0000\u0000\u009d\u009e\u0006\u0005\uffff\uffff\u0000"+
		"\u009e\u000b\u0001\u0000\u0000\u0000\u009f\u00a0\u0006\u0006\uffff\uffff"+
		"\u0000\u00a0\u00a1\u0005\u0019\u0000\u0000\u00a1\u00a2\u0005\u000b\u0000"+
		"\u0000\u00a2\u00a3\u0003\u0018\f\u0000\u00a3\u00a4\u0007\u0001\u0000\u0000"+
		"\u00a4\u00a5\u0003\u0018\f\u0000\u00a5\u00a6\u0006\u0006\uffff\uffff\u0000"+
		"\u00a6\u00a7\u0005\u0005\u0000\u0000\u00a7\u00ab\u0005\u001f\u0000\u0000"+
		"\u00a8\u00aa\u0003\u0006\u0003\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u0006\u0006\uffff\uffff"+
		"\u0000\u00af\u00b0\u0005\u0006\u0000\u0000\u00b0\u00b1\u0005\u001f\u0000"+
		"\u0000\u00b1\u00b2\u0006\u0006\uffff\uffff\u0000\u00b2\r\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0005\u0016\u0000\u0000\u00b4\u00b5\u0005\u000b\u0000"+
		"\u0000\u00b5\u00b6\u0006\u0007\uffff\uffff\u0000\u00b6\u00b7\u0003\u0018"+
		"\f\u0000\u00b7\u00b8\u0006\u0007\uffff\uffff\u0000\u00b8\u000f\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0005\u0016\u0000\u0000\u00ba\u00bb\u0005\u000b"+
		"\u0000\u0000\u00bb\u00bc\u0006\b\uffff\uffff\u0000\u00bc\u00bd\u0005\u001e"+
		"\u0000\u0000\u00bd\u00be\u0006\b\uffff\uffff\u0000\u00be\u00bf\u0006\b"+
		"\uffff\uffff\u0000\u00bf\u0011\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"\u001c\u0000\u0000\u00c1\u00d0\u0005\u000b\u0000\u0000\u00c2\u00c5\u0005"+
		"\u001c\u0000\u0000\u00c3\u00c5\u0003\u0018\f\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00cd\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c9\u0005\u001a\u0000\u0000\u00c7\u00ca\u0005\u001c"+
		"\u0000\u0000\u00c8\u00ca\u0003\u0018\f\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cb\u00c6\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d0\u00c4\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0006\t\uffff\uffff"+
		"\u0000\u00d3\u0013\u0001\u0000\u0000\u0000\u00d4\u00d8\u0003\u000e\u0007"+
		"\u0000\u00d5\u00d8\u0003\u0010\b\u0000\u00d6\u00d8\u0003\u0012\t\u0000"+
		"\u00d7\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00da\u0005\u001b\u0000\u0000\u00da\u0015\u0001\u0000\u0000\u0000"+
		"\u00db\u00e3\u0005!\u0000\u0000\u00dc\u00e3\u0005%\u0000\u0000\u00dd\u00e3"+
		"\u0005$\u0000\u0000\u00de\u00e3\u0005\"\u0000\u0000\u00df\u00e3\u0005"+
		"#\u0000\u0000\u00e0\u00e3\u0005&\u0000\u0000\u00e1\u00e3\u0005\'\u0000"+
		"\u0000\u00e2\u00db\u0001\u0000\u0000\u0000\u00e2\u00dc\u0001\u0000\u0000"+
		"\u0000\u00e2\u00dd\u0001\u0000\u0000\u0000\u00e2\u00de\u0001\u0000\u0000"+
		"\u0000\u00e2\u00df\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0005\u001c\u0000\u0000\u00e5\u00e6\u0005\f\u0000\u0000"+
		"\u00e6\u00e7\u0003\u0018\f\u0000\u00e7\u00e8\u0006\u000b\uffff\uffff\u0000"+
		"\u00e8\u00e9\u0005\u001b\u0000\u0000\u00e9\u0017\u0001\u0000\u0000\u0000"+
		"\u00ea\u00f1\u0003\u001a\r\u0000\u00eb\u00ec\u0007\u0002\u0000\u0000\u00ec"+
		"\u00ed\u0003\u001a\r\u0000\u00ed\u00ee\u0006\f\uffff\uffff\u0000\u00ee"+
		"\u00f0\u0001\u0000\u0000\u0000\u00ef\u00eb\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f2\u0019\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f4\u00fb\u0003\u001c\u000e\u0000\u00f5"+
		"\u00f6\u0007\u0003\u0000\u0000\u00f6\u00f7\u0003\u001c\u000e\u0000\u00f7"+
		"\u00f8\u0006\r\uffff\uffff\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9"+
		"\u00f5\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc"+
		"\u001b\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0005\u001d\u0000\u0000\u00ff\u010c\u0006\u000e\uffff\uffff\u0000"+
		"\u0100\u0101\u0005\u001c\u0000\u0000\u0101\u010c\u0006\u000e\uffff\uffff"+
		"\u0000\u0102\u0103\u0005\u001c\u0000\u0000\u0103\u0104\u0005\u0007\u0000"+
		"\u0000\u0104\u0105\u0005\u001d\u0000\u0000\u0105\u0106\u0005\b\u0000\u0000"+
		"\u0106\u010c\u0006\u000e\uffff\uffff\u0000\u0107\u0108\u0005\t\u0000\u0000"+
		"\u0108\u0109\u0003\u0018\f\u0000\u0109\u010a\u0005\n\u0000\u0000\u010a"+
		"\u010c\u0001\u0000\u0000\u0000\u010b\u00fe\u0001\u0000\u0000\u0000\u010b"+
		"\u0100\u0001\u0000\u0000\u0000\u010b\u0102\u0001\u0000\u0000\u0000\u010b"+
		"\u0107\u0001\u0000\u0000\u0000\u010c\u001d\u0001\u0000\u0000\u0000\u0015"+
		"\"(5GJSZky\u008c\u0098\u00ab\u00c4\u00c9\u00cd\u00d0\u00d7\u00e2\u00f1"+
		"\u00fb\u010b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}