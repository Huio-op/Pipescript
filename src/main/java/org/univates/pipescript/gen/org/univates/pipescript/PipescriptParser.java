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
		RULE_function_printInteger = 7, RULE_function_printString = 8, RULE_function_printVar = 9, 
		RULE_function_customCall = 10, RULE_call_function = 11, RULE_assignment = 12, 
		RULE_expression = 13, RULE_term = 14, RULE_factor = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "function", "statement", "statement_if", "statement_else", 
			"statement_while", "function_printInteger", "function_printString", "function_printVar", 
			"function_customCall", "call_function", "assignment", "expression", "term", 
			"factor"
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

	    final Function<Var, String> loadVar = (Var var) -> {
	        switch (var.type) {
	            case "int":
	            case "bool":
	            case "char":
	                return "iload " + var.stackPos;
	            case "double":
	                return "dload " + var.stackPos;
	            case "str":
	                return "aload " + var.stackPos;
	            default:
	                return "iload " + var.stackPos;
	        }
	    };

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
			        
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					function();
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(39);
				match(NL);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
			setState(47);
			match(FUNC);
			setState(48);
			match(MAIN);
			setState(49);
			match(PIPE);
			setState(50);
			match(OPEN_C);

			                if (!stackCounter.containsKey("main")) stackCounter.put("main", new LinkedHashMap<String, Integer>());

			                System.out.println(".method public static main([Ljava/lang/String;)V\n");
			            
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(52);
				statement("main");
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(CLOSE_C);
			setState(59);
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
			    
			setState(63);
			match(FUNC);
			{
			setState(64);
			((FunctionContext)_localctx).name = match(VAR);
			}
			setState(65);
			match(PIPE);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266287972352L) != 0)) {
				{
				setState(66);
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
				setState(67);
				((FunctionContext)_localctx).VAR = match(VAR);
				((FunctionContext)_localctx).vars.add(((FunctionContext)_localctx).VAR);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(68);
					match(COMMA);
					setState(69);
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
					setState(70);
					((FunctionContext)_localctx).VAR = match(VAR);
					((FunctionContext)_localctx).vars.add(((FunctionContext)_localctx).VAR);
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(78);
			match(PIPE);
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAR:
				{
				setState(79);
				((FunctionContext)_localctx).ret = match(INT_VAR);
				}
				break;
			case BOOL_VAR:
				{
				setState(80);
				match(BOOL_VAR);
				}
				break;
			case CHAR_VAR:
				{
				setState(81);
				match(CHAR_VAR);
				}
				break;
			case DOUBLE_VAR:
				{
				setState(82);
				match(DOUBLE_VAR);
				}
				break;
			case STRING_VAR:
				{
				setState(83);
				match(STRING_VAR);
				}
				break;
			case VOID_VAR:
				{
				setState(84);
				match(VOID_VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87);
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
			            
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(89);
				statement((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			match(RETURN);
			setState(96);
			expression((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
			setState(97);
			match(SEMICOLON);
			setState(98);
			match(NL);
			setState(99);
			match(CLOSE_C);
			setState(100);
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				call_function(funcName);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				statement_if(funcName);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				statement_else(funcName);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				statement_while(funcName);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
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
			setState(112);
			match(IF);
			setState(113);
			match(PIPE);
			setState(114);
			expression(funcName);
			setState(115);
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
			setState(116);
			expression(funcName);


			             emit(((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            
			setState(118);
			match(OPEN_C);
			setState(119);
			match(NL);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(120);
				statement(funcName);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(CLOSE_C);
			setState(127);
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
			setState(131);
			match(IF);
			setState(132);
			match(PIPE);
			setState(133);
			expression(funcName);
			setState(134);
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
			setState(135);
			expression(funcName);
			 emit(((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); 
			setState(137);
			match(OPEN_C);
			setState(138);
			match(NL);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(139);
				statement(funcName);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto END_IF_ELSE_" + tempIfElse + " ; "); 
			setState(146);
			match(CLOSE_C);
			setState(147);
			match(ELSE);
			setState(148);
			match(OPEN_C);
			setState(149);
			match(NL);
			 emit("NOT_IF_" + tempIfElse + ": "); 
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(151);
				statement(funcName);
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			match(CLOSE_C);
			setState(158);
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
			        
			setState(162);
			match(WHILE);
			setState(163);
			match(PIPE);
			setState(164);
			expression(funcName);
			setState(165);
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
			setState(166);
			expression(funcName);
			 emit(((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); 
			setState(168);
			match(OPEN_C);
			setState(169);
			match(NL);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1093383749632L) != 0)) {
				{
				{
				setState(170);
				statement(funcName);
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto START_WHILE_" + tempWhile + " ; "); 
			setState(177);
			match(CLOSE_C);
			setState(178);
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
			setState(181);
			match(PRINT);
			setState(182);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(184);
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
			setState(187);
			match(PRINT);
			setState(188);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(190);
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
	public static class Function_printVarContext extends ParserRuleContext {
		public String funcName;
		public Token VAR;
		public TerminalNode PRINT() { return getToken(PipescriptParser.PRINT, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public Function_printVarContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_printVarContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_function_printVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_printVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_printVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_printVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_printVarContext function_printVar(String funcName) throws RecognitionException {
		Function_printVarContext _localctx = new Function_printVarContext(_ctx, getState(), funcName);
		enterRule(_localctx, 18, RULE_function_printVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(PRINT);
			setState(195);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(197);
			((Function_printVarContext)_localctx).VAR = match(VAR);

			                final String varName = (((Function_printVarContext)_localctx).VAR!=null?((Function_printVarContext)_localctx).VAR.getText():null);
			                final List<Var> memoryVars = memory.get(funcName);

			                final Var var = memoryVars.stream().filter(v -> v.name.equals(varName)).findFirst()
			                    .orElse(null);
			                if (var == null) {
			                    System.err.println("Unknown variable " + varName + " in function call text");
			                    throw new RuntimeException("Unknown variable " + varName + " in function call text");
			                }

			                System.out.println(loadVar.apply(var));
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
		enterRule(_localctx, 20, RULE_function_customCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(200);
			((Function_customCallContext)_localctx).funcCall = match(VAR);
			}
			setState(201);
			match(PIPE);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805306880L) != 0)) {
				{
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(202);
					((Function_customCallContext)_localctx).VAR = match(VAR);
					((Function_customCallContext)_localctx).vars.add(((Function_customCallContext)_localctx).VAR);
					}
					break;
				case 2:
					{
					setState(203);
					expression(funcName);
					}
					break;
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(206);
					match(COMMA);
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(207);
						((Function_customCallContext)_localctx).VAR = match(VAR);
						((Function_customCallContext)_localctx).vars.add(((Function_customCallContext)_localctx).VAR);
						}
						break;
					case 2:
						{
						setState(208);
						expression(funcName);
						}
						break;
					}
					}
					}
					setState(215);
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

			            final List<Var> memoryVars = memory.get(funcName);
			            for (int i = 0; i < ((Function_customCallContext)_localctx).vars.size(); i++) {
			                final String varName = ((Function_customCallContext)_localctx).vars.get(i).getText();
			                final Var currentVar = memoryVars.stream().filter(mv -> mv.name.equals(varName)).findFirst()
			                    .orElse(null);
			                if (currentVar == null) {
			                   System.err.println("Unknown variable " + varName + " in function call " + (((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null));
			                   throw new RuntimeException("Unknown variable " + varName + " in function call " + (((Function_customCallContext)_localctx).funcCall!=null?((Function_customCallContext)_localctx).funcCall.getText():null));
			                }

			                System.out.println(loadVar.apply(currentVar));
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
		public Function_printVarContext function_printVar() {
			return getRuleContext(Function_printVarContext.class,0);
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
		enterRule(_localctx, 22, RULE_call_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(220);
				function_printInteger(funcName);
				}
				break;
			case 2:
				{
				setState(221);
				function_printString();
				}
				break;
			case 3:
				{
				setState(222);
				function_printVar(funcName);
				}
				break;
			case 4:
				{
				setState(223);
				function_customCall(funcName);
				}
				break;
			}
			setState(226);
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
		public Function_customCallContext function_customCall() {
			return getRuleContext(Function_customCallContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAR:
				{
				setState(228);
				((AssignmentContext)_localctx).op = match(INT_VAR);
				}
				break;
			case BOOL_VAR:
				{
				setState(229);
				match(BOOL_VAR);
				}
				break;
			case CHAR_VAR:
				{
				setState(230);
				match(CHAR_VAR);
				}
				break;
			case DOUBLE_VAR:
				{
				setState(231);
				match(DOUBLE_VAR);
				}
				break;
			case STRING_VAR:
				{
				setState(232);
				match(STRING_VAR);
				}
				break;
			case VOID_VAR:
				{
				setState(233);
				match(VOID_VAR);
				}
				break;
			case NULL_VAR:
				{
				setState(234);
				match(NULL_VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(237);
			((AssignmentContext)_localctx).VAR = match(VAR);
			setState(238);
			match(ATTRIB);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(239);
				((AssignmentContext)_localctx).exp = expression(funcName);
				}
				break;
			case 2:
				{
				setState(240);
				function_customCall(funcName);
				}
				break;
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
			        
			setState(244);
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
		enterRule(_localctx, 26, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			term(funcName);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(247);
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
				setState(248);
				term(funcName);
				 System.out.println(((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getType():0) == PLUS) ? "iadd" : "isub"); 
				}
				}
				setState(255);
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
		enterRule(_localctx, 28, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			factor(funcName);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIV) {
				{
				{
				setState(257);
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
				setState(258);
				factor(funcName);
				 System.out.println(((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getType():0) == TIMES) ? "imul" : "idiv"); 
				}
				}
				setState(265);
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
		enterRule(_localctx, 30, RULE_factor);
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				((FactorContext)_localctx).NUM = match(NUM);
				 System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
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
				setState(270);
				((FactorContext)_localctx).VAR = match(VAR);
				setState(271);
				match(OPEN_B);
				setState(272);
				((FactorContext)_localctx).NUM = match(NUM);
				setState(273);
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
				setState(275);
				match(OPEN_P);
				setState(276);
				expression(funcName);
				setState(277);
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
		"\u0004\u0001\'\u011a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0005\u0000)\b\u0000\n\u0000\f\u0000,\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u00019\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002H\b\u0002\n\u0002\f\u0002K\t\u0002\u0003\u0002M\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002V\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002[\b\u0002\n\u0002\f\u0002^\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003n\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004z\b\u0004\n\u0004\f\u0004}\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u008d\b\u0005\n\u0005\f\u0005\u0090\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0099\b\u0005\n\u0005\f\u0005\u009c\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00ac\b\u0006\n\u0006\f\u0006\u00af\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00cd\b\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00d2\b\n\u0005\n\u00d4\b\n\n\n\f\n\u00d7\t\n\u0003\n\u00d9\b\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00e1\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00ec\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00f2\b\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u00fc\b\r\n\r\f\r\u00ff\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0106\b\u000e\n\u000e"+
		"\f\u000e\u0109\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0118\b\u000f\u0001\u000f"+
		"\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000!%\u0001\u0000\u000e"+
		"\u0013\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004\u0130\u0000 \u0001"+
		"\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000"+
		"\u0000\u0006m\u0001\u0000\u0000\u0000\bo\u0001\u0000\u0000\u0000\n\u0082"+
		"\u0001\u0000\u0000\u0000\f\u00a1\u0001\u0000\u0000\u0000\u000e\u00b5\u0001"+
		"\u0000\u0000\u0000\u0010\u00bb\u0001\u0000\u0000\u0000\u0012\u00c2\u0001"+
		"\u0000\u0000\u0000\u0014\u00c8\u0001\u0000\u0000\u0000\u0016\u00e0\u0001"+
		"\u0000\u0000\u0000\u0018\u00eb\u0001\u0000\u0000\u0000\u001a\u00f6\u0001"+
		"\u0000\u0000\u0000\u001c\u0100\u0001\u0000\u0000\u0000\u001e\u0117\u0001"+
		"\u0000\u0000\u0000 $\u0006\u0000\uffff\uffff\u0000!#\u0003\u0004\u0002"+
		"\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000"+
		"\u0000\u0000$%\u0001\u0000\u0000\u0000%*\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000\')\u0005\u001f\u0000\u0000(\'\u0001\u0000\u0000\u0000"+
		"),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0003\u0002"+
		"\u0001\u0000.\u0001\u0001\u0000\u0000\u0000/0\u0005\u0014\u0000\u0000"+
		"01\u0005\u0015\u0000\u000012\u0005\u000b\u0000\u000023\u0005\u0005\u0000"+
		"\u000037\u0006\u0001\uffff\uffff\u000046\u0003\u0006\u0003\u000054\u0001"+
		"\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u0000:;\u0005\u0006\u0000\u0000;<\u0005\u001f\u0000\u0000<=\u0006\u0001"+
		"\uffff\uffff\u0000=\u0003\u0001\u0000\u0000\u0000>?\u0006\u0002\uffff"+
		"\uffff\u0000?@\u0005\u0014\u0000\u0000@A\u0005\u001c\u0000\u0000AL\u0005"+
		"\u000b\u0000\u0000BC\u0007\u0000\u0000\u0000CI\u0005\u001c\u0000\u0000"+
		"DE\u0005\u001a\u0000\u0000EF\u0007\u0000\u0000\u0000FH\u0005\u001c\u0000"+
		"\u0000GD\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000LB\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NU\u0005\u000b\u0000\u0000OV\u0005!\u0000\u0000"+
		"PV\u0005%\u0000\u0000QV\u0005$\u0000\u0000RV\u0005\"\u0000\u0000SV\u0005"+
		"#\u0000\u0000TV\u0005&\u0000\u0000UO\u0001\u0000\u0000\u0000UP\u0001\u0000"+
		"\u0000\u0000UQ\u0001\u0000\u0000\u0000UR\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0005\u0005\u0000\u0000X\\\u0006\u0002\uffff\uffff\u0000Y[\u0003\u0006"+
		"\u0003\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001"+
		"\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000"+
		"^\\\u0001\u0000\u0000\u0000_`\u0005\r\u0000\u0000`a\u0003\u001a\r\u0000"+
		"ab\u0005\u001b\u0000\u0000bc\u0005\u001f\u0000\u0000cd\u0005\u0006\u0000"+
		"\u0000de\u0005\u001f\u0000\u0000ef\u0006\u0002\uffff\uffff\u0000f\u0005"+
		"\u0001\u0000\u0000\u0000gn\u0005\u001f\u0000\u0000hn\u0003\u0016\u000b"+
		"\u0000in\u0003\b\u0004\u0000jn\u0003\n\u0005\u0000kn\u0003\f\u0006\u0000"+
		"ln\u0003\u0018\f\u0000mg\u0001\u0000\u0000\u0000mh\u0001\u0000\u0000\u0000"+
		"mi\u0001\u0000\u0000\u0000mj\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000n\u0007\u0001\u0000\u0000\u0000op\u0006"+
		"\u0004\uffff\uffff\u0000pq\u0005\u0017\u0000\u0000qr\u0005\u000b\u0000"+
		"\u0000rs\u0003\u001a\r\u0000st\u0007\u0001\u0000\u0000tu\u0003\u001a\r"+
		"\u0000uv\u0006\u0004\uffff\uffff\u0000vw\u0005\u0005\u0000\u0000w{\u0005"+
		"\u001f\u0000\u0000xz\u0003\u0006\u0003\u0000yx\u0001\u0000\u0000\u0000"+
		"z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0006\u0000\u0000\u007f\u0080\u0005\u001f\u0000\u0000\u0080\u0081\u0006"+
		"\u0004\uffff\uffff\u0000\u0081\t\u0001\u0000\u0000\u0000\u0082\u0083\u0006"+
		"\u0005\uffff\uffff\u0000\u0083\u0084\u0005\u0017\u0000\u0000\u0084\u0085"+
		"\u0005\u000b\u0000\u0000\u0085\u0086\u0003\u001a\r\u0000\u0086\u0087\u0007"+
		"\u0001\u0000\u0000\u0087\u0088\u0003\u001a\r\u0000\u0088\u0089\u0006\u0005"+
		"\uffff\uffff\u0000\u0089\u008a\u0005\u0005\u0000\u0000\u008a\u008e\u0005"+
		"\u001f\u0000\u0000\u008b\u008d\u0003\u0006\u0003\u0000\u008c\u008b\u0001"+
		"\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001"+
		"\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0006"+
		"\u0005\uffff\uffff\u0000\u0092\u0093\u0005\u0006\u0000\u0000\u0093\u0094"+
		"\u0005\u0018\u0000\u0000\u0094\u0095\u0005\u0005\u0000\u0000\u0095\u0096"+
		"\u0005\u001f\u0000\u0000\u0096\u009a\u0006\u0005\uffff\uffff\u0000\u0097"+
		"\u0099\u0003\u0006\u0003\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0006\u0000\u0000\u009e"+
		"\u009f\u0005\u001f\u0000\u0000\u009f\u00a0\u0006\u0005\uffff\uffff\u0000"+
		"\u00a0\u000b\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\u0006\uffff\uffff"+
		"\u0000\u00a2\u00a3\u0005\u0019\u0000\u0000\u00a3\u00a4\u0005\u000b\u0000"+
		"\u0000\u00a4\u00a5\u0003\u001a\r\u0000\u00a5\u00a6\u0007\u0001\u0000\u0000"+
		"\u00a6\u00a7\u0003\u001a\r\u0000\u00a7\u00a8\u0006\u0006\uffff\uffff\u0000"+
		"\u00a8\u00a9\u0005\u0005\u0000\u0000\u00a9\u00ad\u0005\u001f\u0000\u0000"+
		"\u00aa\u00ac\u0003\u0006\u0003\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000"+
		"\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006\u0006\uffff\uffff"+
		"\u0000\u00b1\u00b2\u0005\u0006\u0000\u0000\u00b2\u00b3\u0005\u001f\u0000"+
		"\u0000\u00b3\u00b4\u0006\u0006\uffff\uffff\u0000\u00b4\r\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0005\u0016\u0000\u0000\u00b6\u00b7\u0005\u000b\u0000"+
		"\u0000\u00b7\u00b8\u0006\u0007\uffff\uffff\u0000\u00b8\u00b9\u0003\u001a"+
		"\r\u0000\u00b9\u00ba\u0006\u0007\uffff\uffff\u0000\u00ba\u000f\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0005\u0016\u0000\u0000\u00bc\u00bd\u0005\u000b"+
		"\u0000\u0000\u00bd\u00be\u0006\b\uffff\uffff\u0000\u00be\u00bf\u0005\u001e"+
		"\u0000\u0000\u00bf\u00c0\u0006\b\uffff\uffff\u0000\u00c0\u00c1\u0006\b"+
		"\uffff\uffff\u0000\u00c1\u0011\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"\u0016\u0000\u0000\u00c3\u00c4\u0005\u000b\u0000\u0000\u00c4\u00c5\u0006"+
		"\t\uffff\uffff\u0000\u00c5\u00c6\u0005\u001c\u0000\u0000\u00c6\u00c7\u0006"+
		"\t\uffff\uffff\u0000\u00c7\u0013\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005"+
		"\u001c\u0000\u0000\u00c9\u00d8\u0005\u000b\u0000\u0000\u00ca\u00cd\u0005"+
		"\u001c\u0000\u0000\u00cb\u00cd\u0003\u001a\r\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d5\u0001\u0000"+
		"\u0000\u0000\u00ce\u00d1\u0005\u001a\u0000\u0000\u00cf\u00d2\u0005\u001c"+
		"\u0000\u0000\u00d0\u00d2\u0003\u001a\r\u0000\u00d1\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d3\u00ce\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d8\u00cc\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0006\n\uffff\uffff"+
		"\u0000\u00db\u0015\u0001\u0000\u0000\u0000\u00dc\u00e1\u0003\u000e\u0007"+
		"\u0000\u00dd\u00e1\u0003\u0010\b\u0000\u00de\u00e1\u0003\u0012\t\u0000"+
		"\u00df\u00e1\u0003\u0014\n\u0000\u00e0\u00dc\u0001\u0000\u0000\u0000\u00e0"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0"+
		"\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005\u001b\u0000\u0000\u00e3\u0017\u0001\u0000\u0000\u0000\u00e4"+
		"\u00ec\u0005!\u0000\u0000\u00e5\u00ec\u0005%\u0000\u0000\u00e6\u00ec\u0005"+
		"$\u0000\u0000\u00e7\u00ec\u0005\"\u0000\u0000\u00e8\u00ec\u0005#\u0000"+
		"\u0000\u00e9\u00ec\u0005&\u0000\u0000\u00ea\u00ec\u0005\'\u0000\u0000"+
		"\u00eb\u00e4\u0001\u0000\u0000\u0000\u00eb\u00e5\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e6\u0001\u0000\u0000\u0000\u00eb\u00e7\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e8\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ee\u0005\u001c\u0000\u0000\u00ee\u00f1\u0005\f\u0000\u0000\u00ef"+
		"\u00f2\u0003\u001a\r\u0000\u00f0\u00f2\u0003\u0014\n\u0000\u00f1\u00ef"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0006\f\uffff\uffff\u0000\u00f4\u00f5"+
		"\u0005\u001b\u0000\u0000\u00f5\u0019\u0001\u0000\u0000\u0000\u00f6\u00fd"+
		"\u0003\u001c\u000e\u0000\u00f7\u00f8\u0007\u0002\u0000\u0000\u00f8\u00f9"+
		"\u0003\u001c\u000e\u0000\u00f9\u00fa\u0006\r\uffff\uffff\u0000\u00fa\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fb\u00f7\u0001\u0000\u0000\u0000\u00fc\u00ff"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fe\u001b\u0001\u0000\u0000\u0000\u00ff\u00fd"+
		"\u0001\u0000\u0000\u0000\u0100\u0107\u0003\u001e\u000f\u0000\u0101\u0102"+
		"\u0007\u0003\u0000\u0000\u0102\u0103\u0003\u001e\u000f\u0000\u0103\u0104"+
		"\u0006\u000e\uffff\uffff\u0000\u0104\u0106\u0001\u0000\u0000\u0000\u0105"+
		"\u0101\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000\u0000\u0107"+
		"\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108"+
		"\u001d\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0005\u001d\u0000\u0000\u010b\u0118\u0006\u000f\uffff\uffff\u0000"+
		"\u010c\u010d\u0005\u001c\u0000\u0000\u010d\u0118\u0006\u000f\uffff\uffff"+
		"\u0000\u010e\u010f\u0005\u001c\u0000\u0000\u010f\u0110\u0005\u0007\u0000"+
		"\u0000\u0110\u0111\u0005\u001d\u0000\u0000\u0111\u0112\u0005\b\u0000\u0000"+
		"\u0112\u0118\u0006\u000f\uffff\uffff\u0000\u0113\u0114\u0005\t\u0000\u0000"+
		"\u0114\u0115\u0003\u001a\r\u0000\u0115\u0116\u0005\n\u0000\u0000\u0116"+
		"\u0118\u0001\u0000\u0000\u0000\u0117\u010a\u0001\u0000\u0000\u0000\u0117"+
		"\u010c\u0001\u0000\u0000\u0000\u0117\u010e\u0001\u0000\u0000\u0000\u0117"+
		"\u0113\u0001\u0000\u0000\u0000\u0118\u001f\u0001\u0000\u0000\u0000\u0016"+
		"$*7ILU\\m{\u008e\u009a\u00ad\u00cc\u00d1\u00d5\u00d8\u00e0\u00eb\u00f1"+
		"\u00fd\u0107\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}