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
		PRINT=22, INT_SCANNER=23, STR_SCANNER=24, IF=25, ELSE=26, WHILE=27, COMMA=28, 
		SEMICOLON=29, INT_VAR=30, DOUBLE_VAR=31, STRING_VAR=32, CHAR_VAR=33, BOOL_VAR=34, 
		VOID_VAR=35, NULL_VAR=36, READ=37, GOTO=38, DEF_GOTO=39, WRITE=40, NUM=41, 
		COMMENT=42, BREAK=43, TRUE=44, VAR=45, STRING=46, NL=47, WS=48;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_function = 2, RULE_statement = 3, 
		RULE_statement_if = 4, RULE_statement_else = 5, RULE_statement_while = 6, 
		RULE_statement_while_true = 7, RULE_break = 8, RULE_function_printInteger = 9, 
		RULE_function_printString = 10, RULE_function_printVar = 11, RULE_function_scanInteger = 12, 
		RULE_function_scanString = 13, RULE_function_readFile = 14, RULE_function_writeFile = 15, 
		RULE_function_customCall = 16, RULE_goto = 17, RULE_def_goto = 18, RULE_call_function = 19, 
		RULE_assignment = 20, RULE_expression = 21, RULE_term = 22, RULE_factor = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "function", "statement", "statement_if", "statement_else", 
			"statement_while", "statement_while_true", "break", "function_printInteger", 
			"function_printString", "function_printVar", "function_scanInteger", 
			"function_scanString", "function_readFile", "function_writeFile", "function_customCall", 
			"goto", "def_goto", "call_function", "assignment", "expression", "term", 
			"factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'", "'|'", "'<<'", "'>>'", "'is'", "'not'", "'lt'", "'lte'", "'gt'", 
			"'gte'", "'fun'", "'main'", "'text'", "'textInInt'", "'textInStr'", "'if'", 
			"'else'", "'while'", "','", "';'", "'int'", "'double'", "'str'", "'char'", 
			"'bool'", "'void'", "'null'", "'read'", "'@'", "'def@'", "'write'", null, 
			null, "'break'", "'true'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "TIMES", "DIV", "OPEN_C", "CLOSE_C", "OPEN_B", 
			"CLOSE_B", "OPEN_P", "CLOSE_P", "PIPE", "ATTRIB", "RETURN", "EQUAL", 
			"DIFFER", "LESSER", "LESSER_EQUAL", "GREATER", "GREATER_EQUAL", "FUNC", 
			"MAIN", "PRINT", "INT_SCANNER", "STR_SCANNER", "IF", "ELSE", "WHILE", 
			"COMMA", "SEMICOLON", "INT_VAR", "DOUBLE_VAR", "STRING_VAR", "CHAR_VAR", 
			"BOOL_VAR", "VOID_VAR", "NULL_VAR", "READ", "GOTO", "DEF_GOTO", "WRITE", 
			"NUM", "COMMENT", "BREAK", "TRUE", "VAR", "STRING", "NL", "WS"
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
	    Map<String, String> gotos = new LinkedHashMap<String, String>();
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

	    final Function<Var, String> storeVar = (Var var) -> {
	        switch (var.type) {
	            case "int":
	            case "bool":
	            case "char":
	                return "istore " + var.stackPos;
	            case "double":
	                return "dstore " + var.stackPos;
	            case "str":
	                return "astore " + var.stackPos;
	            default:
	                return "istore " + var.stackPos;
	        }
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
			        
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(49);
				match(NL);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					function();
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(56);
						match(NL);
						}
						}
						setState(61);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(67);
			main();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(68);
				match(NL);
				}
				}
				setState(73);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(FUNC);
			setState(75);
			match(MAIN);
			setState(76);
			match(PIPE);
			setState(77);
			match(OPEN_C);

			                if (!stackCounter.containsKey("main")) stackCounter.put("main", new LinkedHashMap<String, Integer>());

			                System.out.println(".method public static main([Ljava/lang/String;)V\n");
			            
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(79);
				statement("main", null);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(CLOSE_C);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					match(NL);
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}

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
		public Token _tset520;
		public Token VAR;
		public List<Token> vars = new ArrayList<Token>();
		public Token _tset550;
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
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

			        List<String> types = new ArrayList();
			        List<String> names = new ArrayList();
			    
			setState(95);
			match(FUNC);
			{
			setState(96);
			((FunctionContext)_localctx).name = match(VAR);
			}
			setState(97);
			match(PIPE);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33285996544L) != 0)) {
				{
				setState(98);
				((FunctionContext)_localctx)._tset520 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33285996544L) != 0)) ) {
					((FunctionContext)_localctx)._tset520 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((FunctionContext)_localctx).types.add(((FunctionContext)_localctx)._tset520);
				setState(99);
				((FunctionContext)_localctx).VAR = match(VAR);
				((FunctionContext)_localctx).vars.add(((FunctionContext)_localctx).VAR);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(100);
					match(COMMA);
					setState(101);
					((FunctionContext)_localctx)._tset550 = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33285996544L) != 0)) ) {
						((FunctionContext)_localctx)._tset550 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((FunctionContext)_localctx).types.add(((FunctionContext)_localctx)._tset550);
					setState(102);
					((FunctionContext)_localctx).VAR = match(VAR);
					((FunctionContext)_localctx).vars.add(((FunctionContext)_localctx).VAR);
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(110);
			match(PIPE);
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAR:
				{
				setState(111);
				((FunctionContext)_localctx).ret = match(INT_VAR);
				}
				break;
			case BOOL_VAR:
				{
				setState(112);
				match(BOOL_VAR);
				}
				break;
			case CHAR_VAR:
				{
				setState(113);
				match(CHAR_VAR);
				}
				break;
			case DOUBLE_VAR:
				{
				setState(114);
				match(DOUBLE_VAR);
				}
				break;
			case STRING_VAR:
				{
				setState(115);
				match(STRING_VAR);
				}
				break;
			case VOID_VAR:
				{
				setState(116);
				match(VOID_VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(119);
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

			                    stackTypes.put(type, ++count);
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

			                String receivedTypes = receivedVars.stream()
			                    .map(v -> getTypeString.apply(v.type))
			                    .reduce("", String::concat);

			                System.out.println(".method public static "+ (((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null) +"("+ receivedTypes +")"+ returnType +"\n");
			            
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(121);
				statement((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null), null);
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(RETURN);
			setState(128);
			expression((((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null));
			setState(129);
			match(SEMICOLON);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(130);
				match(NL);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			match(CLOSE_C);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					match(NL);
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}

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
		public Integer tempWhile;
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
		public Statement_while_trueContext statement_while_true() {
			return getRuleContext(Statement_while_trueContext.class,0);
		}
		public BreakContext break_() {
			return getRuleContext(BreakContext.class,0);
		}
		public Def_gotoContext def_goto() {
			return getRuleContext(Def_gotoContext.class,0);
		}
		public GotoContext goto_() {
			return getRuleContext(GotoContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, String funcName, Integer tempWhile) {
			super(parent, invokingState);
			this.funcName = funcName;
			this.tempWhile = tempWhile;
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

	public final StatementContext statement(String funcName,Integer tempWhile) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), funcName, tempWhile);
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				call_function(funcName, tempWhile);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				statement_if(funcName, tempWhile);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				statement_else(funcName, tempWhile);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				statement_while(funcName);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				statement_while_true(funcName);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				break_(tempWhile);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(152);
				def_goto(funcName);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(153);
				goto_(funcName);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(154);
				assignment(funcName, tempWhile);
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
		public Integer tempWhile;
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
		public Statement_ifContext(ParserRuleContext parent, int invokingState, String funcName, Integer tempWhile) {
			super(parent, invokingState);
			this.funcName = funcName;
			this.tempWhile = tempWhile;
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

	public final Statement_ifContext statement_if(String funcName,Integer tempWhile) throws RecognitionException {
		Statement_ifContext _localctx = new Statement_ifContext(_ctx, getState(), funcName, tempWhile);
		enterRule(_localctx, 8, RULE_statement_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempIf = ifCounter++; 
			setState(158);
			match(IF);
			setState(159);
			match(PIPE);
			setState(160);
			expression(funcName);
			setState(161);
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
			setState(162);
			expression(funcName);


			             emit(((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
			                     ((((Statement_ifContext)_localctx).op!=null?((Statement_ifContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            
			setState(164);
			match(OPEN_C);
			setState(165);
			match(NL);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(166);
				statement(funcName, tempWhile);
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(CLOSE_C);
			setState(173);
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
		public Integer tempWhile;
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
		public Statement_elseContext(ParserRuleContext parent, int invokingState, String funcName, Integer tempWhile) {
			super(parent, invokingState);
			this.funcName = funcName;
			this.tempWhile = tempWhile;
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

	public final Statement_elseContext statement_else(String funcName,Integer tempWhile) throws RecognitionException {
		Statement_elseContext _localctx = new Statement_elseContext(_ctx, getState(), funcName, tempWhile);
		enterRule(_localctx, 10, RULE_statement_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempIfElse = ifCounter++; 
			setState(177);
			match(IF);
			setState(178);
			match(PIPE);
			setState(179);
			expression(funcName);
			setState(180);
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
			setState(181);
			expression(funcName);
			 emit(((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
			                     ((((Statement_elseContext)_localctx).op!=null?((Statement_elseContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); 
			setState(183);
			match(OPEN_C);
			setState(184);
			match(NL);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(185);
				statement(funcName, tempWhile);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto END_IF_ELSE_" + tempIfElse + " ; "); 
			setState(192);
			match(CLOSE_C);
			setState(193);
			match(ELSE);
			setState(194);
			match(OPEN_C);
			setState(195);
			match(NL);
			 emit("NOT_IF_" + tempIfElse + ": "); 
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(197);
				statement(funcName, tempWhile);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
			match(CLOSE_C);
			setState(204);
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
			        
			setState(208);
			match(WHILE);
			setState(209);
			match(PIPE);
			setState(210);
			expression(funcName);
			setState(211);
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
			setState(212);
			expression(funcName);
			 emit(((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
			                     ((((Statement_whileContext)_localctx).op!=null?((Statement_whileContext)_localctx).op.getType():0) == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); 
			setState(214);
			match(OPEN_C);
			setState(215);
			match(NL);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(216);
				statement(funcName, tempWhile);
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto START_WHILE_" + tempWhile + " ; "); 
			setState(223);
			match(CLOSE_C);
			setState(224);
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
	public static class Statement_while_trueContext extends ParserRuleContext {
		public String funcName;
		public TerminalNode WHILE() { return getToken(PipescriptParser.WHILE, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public TerminalNode TRUE() { return getToken(PipescriptParser.TRUE, 0); }
		public TerminalNode OPEN_C() { return getToken(PipescriptParser.OPEN_C, 0); }
		public List<TerminalNode> NL() { return getTokens(PipescriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(PipescriptParser.NL, i);
		}
		public TerminalNode CLOSE_C() { return getToken(PipescriptParser.CLOSE_C, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BreakContext break_() {
			return getRuleContext(BreakContext.class,0);
		}
		public Statement_while_trueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Statement_while_trueContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_statement_while_true; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterStatement_while_true(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitStatement_while_true(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitStatement_while_true(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_while_trueContext statement_while_true(String funcName) throws RecognitionException {
		Statement_while_trueContext _localctx = new Statement_while_trueContext(_ctx, getState(), funcName);
		enterRule(_localctx, 14, RULE_statement_while_true);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 Integer tempWhile = ifCounter++;
			          emit("START_WHILE_" + tempWhile + ": ");
			        
			setState(228);
			match(WHILE);
			setState(229);
			match(PIPE);
			setState(230);
			match(TRUE);
			setState(231);
			match(OPEN_C);
			setState(232);
			match(NL);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					statement(funcName, tempWhile);
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(239);
				break_(tempWhile);
				}
				break;
			}
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 186916100112384L) != 0)) {
				{
				{
				setState(242);
				statement(funcName, tempWhile);
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 emit("goto START_WHILE_" + tempWhile + " ; "); 
			setState(249);
			match(CLOSE_C);
			setState(250);
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
	public static class BreakContext extends ParserRuleContext {
		public Integer tempWhile;
		public TerminalNode BREAK() { return getToken(PipescriptParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public BreakContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BreakContext(ParserRuleContext parent, int invokingState, Integer tempWhile) {
			super(parent, invokingState);
			this.tempWhile = tempWhile;
		}
		@Override public int getRuleIndex() { return RULE_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakContext break_(Integer tempWhile) throws RecognitionException {
		BreakContext _localctx = new BreakContext(_ctx, getState(), tempWhile);
		enterRule(_localctx, 16, RULE_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(BREAK);
			setState(254);
			match(SEMICOLON);
			 emit("goto END_WHILE_" + tempWhile + " ; "); 
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
		public ExpressionContext var;
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
		enterRule(_localctx, 18, RULE_function_printInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(PRINT);
			setState(258);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			{
			setState(260);
			((Function_printIntegerContext)_localctx).var = expression(funcName);
			}

			                final String expressionResult = (((Function_printIntegerContext)_localctx).var!=null?_input.getText(((Function_printIntegerContext)_localctx).var.start,((Function_printIntegerContext)_localctx).var.stop):null);

			                if (expressionResult.matches("^[a-zA-Z]+$")) {
			                    final List<Var> memoryVars = memory.get(funcName);

			                    final Var var = memoryVars.stream().filter(v -> v.name.equals(expressionResult)).findFirst()
			                        .orElse(null);
			                    if (var == null) {
			                        System.err.println("Unknown variable " + expressionResult + " in function call text");
			                        throw new RuntimeException("Unknown variable " + expressionResult + " in function call text");
			                    }

			                    final String returnType = getTypeString.apply(var.type);

			                    System.out.println("invokevirtual java/io/PrintStream/println("+ returnType +")V\n");
			                } else {
			                    System.out.println("invokevirtual java/io/PrintStream/println(I)V\n");
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
		enterRule(_localctx, 20, RULE_function_printString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(PRINT);
			setState(264);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(266);
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
		enterRule(_localctx, 22, RULE_function_printVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(PRINT);
			setState(271);
			match(PIPE);
			 System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
			setState(273);
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
	public static class Function_scanIntegerContext extends ParserRuleContext {
		public String funcName;
		public TerminalNode INT_SCANNER() { return getToken(PipescriptParser.INT_SCANNER, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public Function_scanIntegerContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_scanIntegerContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_function_scanInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_scanInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_scanInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_scanInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_scanIntegerContext function_scanInteger(String funcName) throws RecognitionException {
		Function_scanIntegerContext _localctx = new Function_scanIntegerContext(_ctx, getState(), funcName);
		enterRule(_localctx, 24, RULE_function_scanInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(INT_SCANNER);
			setState(277);
			match(PIPE);

			            System.out.println("new java/util/Scanner");
			            System.out.println("dup");
			            System.out.println("getstatic java/lang/System/in Ljava/io/InputStream;");
			            System.out.println("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
			            System.out.println("invokevirtual java/util/Scanner/nextInt()I");
			        
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
	public static class Function_scanStringContext extends ParserRuleContext {
		public String funcName;
		public TerminalNode STR_SCANNER() { return getToken(PipescriptParser.STR_SCANNER, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public Function_scanStringContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_scanStringContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_function_scanString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_scanString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_scanString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_scanString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_scanStringContext function_scanString(String funcName) throws RecognitionException {
		Function_scanStringContext _localctx = new Function_scanStringContext(_ctx, getState(), funcName);
		enterRule(_localctx, 26, RULE_function_scanString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(STR_SCANNER);
			setState(281);
			match(PIPE);

			            System.out.println("new java/util/Scanner");
			            System.out.println("dup");
			            System.out.println("getstatic java/lang/System/in Ljava/io/InputStream;");
			            System.out.println("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
			            System.out.println("invokevirtual java/util/Scanner/next()Ljava/lang/String;");
			        
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
	public static class Function_readFileContext extends ParserRuleContext {
		public String funcName;
		public Token STRING;
		public TerminalNode READ() { return getToken(PipescriptParser.READ, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public TerminalNode STRING() { return getToken(PipescriptParser.STRING, 0); }
		public Function_readFileContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_readFileContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_function_readFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_readFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_readFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_readFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_readFileContext function_readFile(String funcName) throws RecognitionException {
		Function_readFileContext _localctx = new Function_readFileContext(_ctx, getState(), funcName);
		enterRule(_localctx, 28, RULE_function_readFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(READ);
			setState(285);
			match(PIPE);
			setState(286);
			((Function_readFileContext)_localctx).STRING = match(STRING);

			            String fileName = (((Function_readFileContext)_localctx).STRING!=null?((Function_readFileContext)_localctx).STRING.getText():null).replaceAll("^\"|\"$", "");
			            emit("new java/io/BufferedReader");
			            emit("dup");
			            emit("new java/io/FileReader");
			            emit("dup");
			            emit("ldc \"" + fileName + "\"");
			            emit("invokespecial java/io/FileReader/<init>(Ljava/lang/String;)V");
			            emit("invokespecial java/io/BufferedReader/<init>(Ljava/io/Reader;)V");
			            emit("invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;");
			        
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
	public static class Function_writeFileContext extends ParserRuleContext {
		public String funcName;
		public Token STRING;
		public FactorContext fac;
		public Token str;
		public TerminalNode WRITE() { return getToken(PipescriptParser.WRITE, 0); }
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public List<TerminalNode> STRING() { return getTokens(PipescriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PipescriptParser.STRING, i);
		}
		public TerminalNode COMMA() { return getToken(PipescriptParser.COMMA, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Function_writeFileContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_writeFileContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_function_writeFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterFunction_writeFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitFunction_writeFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitFunction_writeFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_writeFileContext function_writeFile(String funcName) throws RecognitionException {
		Function_writeFileContext _localctx = new Function_writeFileContext(_ctx, getState(), funcName);
		enterRule(_localctx, 30, RULE_function_writeFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(WRITE);
			setState(290);
			match(PIPE);
			setState(291);
			((Function_writeFileContext)_localctx).STRING = match(STRING);

			            String fileName = (((Function_writeFileContext)_localctx).STRING!=null?((Function_writeFileContext)_localctx).STRING.getText():null).replaceAll("^\"|\"$", "");
			            emit("new java/io/BufferedWriter");
			            emit("dup");
			            emit("new java/io/FileWriter");
			            emit("dup");
			            emit("ldc \"" + fileName + "\"");
			            emit("invokespecial java/io/FileWriter/<init>(Ljava/lang/String;)V");
			            emit("invokespecial java/io/BufferedWriter/<init>(Ljava/io/Writer;)V");
			            emit("dup");
			        
			setState(293);
			match(COMMA);
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_P:
			case NUM:
			case VAR:
				{
				setState(294);
				((Function_writeFileContext)_localctx).fac = factor(funcName);
				}
				break;
			case STRING:
				{
				setState(295);
				((Function_writeFileContext)_localctx).str = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			            if ((((Function_writeFileContext)_localctx).str!=null?((Function_writeFileContext)_localctx).str.getText():null) != null) {
			                String content = (((Function_writeFileContext)_localctx).str!=null?((Function_writeFileContext)_localctx).str.getText():null).replaceAll("^\"|\"$", "");
			                emit("ldc \"" + content + "\"");
			            }

			            if ((((Function_writeFileContext)_localctx).fac!=null?_input.getText(((Function_writeFileContext)_localctx).fac.start,((Function_writeFileContext)_localctx).fac.stop):null) == null) {
			                emit("invokevirtual java/io/BufferedWriter/write(Ljava/lang/String;)V");
			            } else {
			                 Var var = memory.get(funcName)
			                                 .stream()
			                                 .filter(v -> v.name.equals((((Function_writeFileContext)_localctx).fac!=null?_input.getText(((Function_writeFileContext)_localctx).fac.start,((Function_writeFileContext)_localctx).fac.stop):null)))
			                                 .findFirst()
			                                 .get();

			                 if (var.type.equals("int")) {
			                     emit("invokevirtual java/io/BufferedWriter/write(I)V");
			                 } else {
			                     emit("invokevirtual java/io/BufferedWriter/write(Ljava/lang/String;)V");
			                 }
			            }

			            emit("invokevirtual java/io/BufferedWriter/close()V");
			        
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
		public TerminalNode PIPE() { return getToken(PipescriptParser.PIPE, 0); }
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
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
		public List<Function_customCallContext> function_customCall() {
			return getRuleContexts(Function_customCallContext.class);
		}
		public Function_customCallContext function_customCall(int i) {
			return getRuleContext(Function_customCallContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PipescriptParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PipescriptParser.SEMICOLON, i);
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
		enterRule(_localctx, 32, RULE_function_customCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(300);
			((Function_customCallContext)_localctx).funcCall = match(VAR);
			}
			setState(301);
			match(PIPE);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 37383395344896L) != 0)) {
				{
				setState(307);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(302);
					factor(funcName);
					}
					break;
				case 2:
					{
					setState(303);
					expression(funcName);
					}
					break;
				case 3:
					{
					{
					setState(304);
					function_customCall(funcName);
					setState(305);
					match(SEMICOLON);
					}
					}
					break;
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==VAR) {
					{
					setState(317);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(309);
						match(COMMA);
						setState(312);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
						case 1:
							{
							setState(310);
							factor(funcName);
							}
							break;
						case 2:
							{
							setState(311);
							expression(funcName);
							}
							break;
						}
						}
						break;
					case VAR:
						{
						{
						setState(314);
						function_customCall(funcName);
						setState(315);
						match(SEMICOLON);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(321);
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

			            final String receivedTypes = fun.receivedTypes.stream()
			                .map(v -> getTypeString.apply(v))
			                .reduce("", String::concat);
			            final String returnType = getTypeString.apply(fun.returnType);

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
	public static class GotoContext extends ParserRuleContext {
		public String funcName;
		public Token VAR;
		public TerminalNode GOTO() { return getToken(PipescriptParser.GOTO, 0); }
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public GotoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public GotoContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_goto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitGoto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitGoto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoContext goto_(String funcName) throws RecognitionException {
		GotoContext _localctx = new GotoContext(_ctx, getState(), funcName);
		enterRule(_localctx, 34, RULE_goto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(GOTO);
			setState(327);
			((GotoContext)_localctx).VAR = match(VAR);
			setState(328);
			match(SEMICOLON);

			            final String gotoName = (((GotoContext)_localctx).VAR!=null?((GotoContext)_localctx).VAR.getText():null);
			            final String nameDef = gotos.get(gotoName);
			            if (nameDef == null || nameDef.isEmpty()) {
			                System.err.println("Undefined Goto pointer " + gotoName);
			                throw new RuntimeException("Undefined Goto pointer " + gotoName);
			            }

			            emit("goto " + nameDef + " ;");

			        
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
	public static class Def_gotoContext extends ParserRuleContext {
		public String funcName;
		public Token VAR;
		public TerminalNode DEF_GOTO() { return getToken(PipescriptParser.DEF_GOTO, 0); }
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public Def_gotoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Def_gotoContext(ParserRuleContext parent, int invokingState, String funcName) {
			super(parent, invokingState);
			this.funcName = funcName;
		}
		@Override public int getRuleIndex() { return RULE_def_goto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).enterDef_goto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipescriptListener ) ((PipescriptListener)listener).exitDef_goto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipescriptVisitor ) return ((PipescriptVisitor<? extends T>)visitor).visitDef_goto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Def_gotoContext def_goto(String funcName) throws RecognitionException {
		Def_gotoContext _localctx = new Def_gotoContext(_ctx, getState(), funcName);
		enterRule(_localctx, 36, RULE_def_goto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(DEF_GOTO);
			setState(332);
			((Def_gotoContext)_localctx).VAR = match(VAR);
			setState(333);
			match(SEMICOLON);

			            final String gotoName = (((Def_gotoContext)_localctx).VAR!=null?((Def_gotoContext)_localctx).VAR.getText():null);
			            if (stackCounter.containsKey(gotoName)) {
			                System.err.println("Goto name already used in function " + gotoName);
			                throw new RuntimeException("Goto name already used in function " + gotoName);
			            }
			            if (memory.get(funcName).stream().anyMatch(v -> v.name.equals(gotoName))) {
			                System.err.println("Goto name already used in variable " + gotoName);
			                throw new RuntimeException("Goto name already used in variable " + gotoName);
			            }

			            if (gotos.get(gotoName) != null) {
			                System.err.println("Goto name already used in another goto " + gotoName);
			                throw new RuntimeException("Goto name already used in another goto " + gotoName);
			            }

			            final String nameDef = gotoName.toUpperCase() + "_DEF";
			            gotos.put(gotoName, nameDef);
			            emit(nameDef + ":");
			        
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
		public Integer tempWhile;
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
		public Function_scanIntegerContext function_scanInteger() {
			return getRuleContext(Function_scanIntegerContext.class,0);
		}
		public Function_scanStringContext function_scanString() {
			return getRuleContext(Function_scanStringContext.class,0);
		}
		public Function_readFileContext function_readFile() {
			return getRuleContext(Function_readFileContext.class,0);
		}
		public Function_writeFileContext function_writeFile() {
			return getRuleContext(Function_writeFileContext.class,0);
		}
		public Function_customCallContext function_customCall() {
			return getRuleContext(Function_customCallContext.class,0);
		}
		public Call_functionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Call_functionContext(ParserRuleContext parent, int invokingState, String funcName, Integer tempWhile) {
			super(parent, invokingState);
			this.funcName = funcName;
			this.tempWhile = tempWhile;
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

	public final Call_functionContext call_function(String funcName,Integer tempWhile) throws RecognitionException {
		Call_functionContext _localctx = new Call_functionContext(_ctx, getState(), funcName, tempWhile);
		enterRule(_localctx, 38, RULE_call_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(336);
				function_printInteger(funcName);
				}
				break;
			case 2:
				{
				setState(337);
				function_printString();
				}
				break;
			case 3:
				{
				setState(338);
				function_printVar(funcName);
				}
				break;
			case 4:
				{
				setState(339);
				function_scanInteger(funcName);
				}
				break;
			case 5:
				{
				setState(340);
				function_scanString(funcName);
				}
				break;
			case 6:
				{
				setState(341);
				function_readFile(funcName);
				}
				break;
			case 7:
				{
				setState(342);
				function_writeFile(funcName);
				}
				break;
			case 8:
				{
				setState(343);
				function_customCall(funcName);
				}
				break;
			}
			setState(346);
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
		public Integer tempWhile;
		public Token op;
		public Token VAR;
		public ExpressionContext exp;
		public Token STRING;
		public TerminalNode VAR() { return getToken(PipescriptParser.VAR, 0); }
		public TerminalNode ATTRIB() { return getToken(PipescriptParser.ATTRIB, 0); }
		public TerminalNode SEMICOLON() { return getToken(PipescriptParser.SEMICOLON, 0); }
		public Function_customCallContext function_customCall() {
			return getRuleContext(Function_customCallContext.class,0);
		}
		public Function_scanIntegerContext function_scanInteger() {
			return getRuleContext(Function_scanIntegerContext.class,0);
		}
		public Function_scanStringContext function_scanString() {
			return getRuleContext(Function_scanStringContext.class,0);
		}
		public Function_readFileContext function_readFile() {
			return getRuleContext(Function_readFileContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PipescriptParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INT_VAR() { return getToken(PipescriptParser.INT_VAR, 0); }
		public TerminalNode BOOL_VAR() { return getToken(PipescriptParser.BOOL_VAR, 0); }
		public TerminalNode CHAR_VAR() { return getToken(PipescriptParser.CHAR_VAR, 0); }
		public TerminalNode DOUBLE_VAR() { return getToken(PipescriptParser.DOUBLE_VAR, 0); }
		public TerminalNode STRING_VAR() { return getToken(PipescriptParser.STRING_VAR, 0); }
		public TerminalNode VOID_VAR() { return getToken(PipescriptParser.VOID_VAR, 0); }
		public TerminalNode NULL_VAR() { return getToken(PipescriptParser.NULL_VAR, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AssignmentContext(ParserRuleContext parent, int invokingState, String funcName, Integer tempWhile) {
			super(parent, invokingState);
			this.funcName = funcName;
			this.tempWhile = tempWhile;
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

	public final AssignmentContext assignment(String funcName,Integer tempWhile) throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState(), funcName, tempWhile);
		enterRule(_localctx, 40, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 136365211648L) != 0)) {
				{
				setState(348);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 136365211648L) != 0)) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(351);
			((AssignmentContext)_localctx).VAR = match(VAR);
			setState(352);
			match(ATTRIB);
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(353);
				((AssignmentContext)_localctx).exp = expression(funcName);
				}
				break;
			case 2:
				{
				setState(354);
				function_customCall(funcName);
				}
				break;
			case 3:
				{
				setState(355);
				function_scanInteger(funcName);
				}
				break;
			case 4:
				{
				setState(356);
				function_scanString(funcName);
				}
				break;
			case 5:
				{
				setState(357);
				function_readFile(funcName);
				}
				break;
			case 6:
				{
				setState(358);
				((AssignmentContext)_localctx).STRING = match(STRING);
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
			    	        stackTypes.put((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null), ++stackCount);
			    	        stackCounter.put(funcName, stackTypes);
			                vars.add(newVar);
			                memory.put(funcName, vars);
			    	    }

			    	    final Var currentVar = memory.get(funcName)
			    	        .stream().filter(var -> var.name.equals((((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null))).findFirst().get();

			            if ((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getType():0) == 0) {
			                System.out.println(storeVar.apply(currentVar));
			            } else if (((AssignmentContext)_localctx).STRING != null) {
			                System.out.println("ldc " + (((AssignmentContext)_localctx).STRING!=null?((AssignmentContext)_localctx).STRING.getText():null));
			                System.out.println("astore " + currentVar.stackPos);
			            } else {
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
			                    case STRING_VAR:
			                        System.out.println("astore " + currentVar.stackPos);
			                        break;
			                    default:
			                        System.err.println("undefined variable " + (((AssignmentContext)_localctx).VAR!=null?((AssignmentContext)_localctx).VAR.getText():null));
			                }
			            }
			        
			setState(362);
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
		enterRule(_localctx, 42, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			term(funcName);
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(365);
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
				setState(366);
				term(funcName);
				 System.out.println(((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getType():0) == PLUS) ? "iadd" : "isub"); 
				}
				}
				setState(373);
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
		enterRule(_localctx, 44, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			factor(funcName);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIV) {
				{
				{
				setState(375);
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
				setState(376);
				factor(funcName);
				 System.out.println(((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getType():0) == TIMES) ? "imul" : "idiv"); 
				}
				}
				setState(383);
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
		enterRule(_localctx, 46, RULE_factor);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(384);
				((FactorContext)_localctx).NUM = match(NUM);
				 System.out.println("ldc " + (((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				((FactorContext)_localctx).VAR = match(VAR);

				    	    Var var = memory.get(funcName)
				    	        .stream().filter(v -> v.name.equals((((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null))).findFirst().get();
				            if (var == null) {
				                System.err.println("undefined variable " + (((FactorContext)_localctx).VAR!=null?((FactorContext)_localctx).VAR.getText():null));
				            } else {
				                System.out.println(loadVar.apply(var));
				            }
				    	
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(388);
				((FactorContext)_localctx).VAR = match(VAR);
				setState(389);
				match(OPEN_B);
				setState(390);
				((FactorContext)_localctx).NUM = match(NUM);
				setState(391);
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
				setState(393);
				match(OPEN_P);
				setState(394);
				expression(funcName);
				setState(395);
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
		"\u0004\u00010\u0190\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0005\u0000?\b\u0000\n"+
		"\u0000\f\u0000B\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000F\b\u0000\n"+
		"\u0000\f\u0000I\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001Q\b\u0001\n\u0001\f\u0001T\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001X\b\u0001\n\u0001\f\u0001[\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"h\b\u0002\n\u0002\f\u0002k\t\u0002\u0003\u0002m\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002v\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002{\b\u0002"+
		"\n\u0002\f\u0002~\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0084\b\u0002\n\u0002\f\u0002\u0087\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u008b\b\u0002\n\u0002\f\u0002\u008e\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u009c\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00a8\b\u0004\n\u0004\f\u0004\u00ab\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u00bb\b\u0005\n\u0005\f\u0005\u00be\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00c7\b\u0005\n\u0005\f\u0005\u00ca\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00da\b\u0006\n\u0006\f\u0006\u00dd\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00eb\b\u0007"+
		"\n\u0007\f\u0007\u00ee\t\u0007\u0001\u0007\u0003\u0007\u00f1\b\u0007\u0001"+
		"\u0007\u0005\u0007\u00f4\b\u0007\n\u0007\f\u0007\u00f7\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0129\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u0134\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u0139\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u013e\b\u0010\n\u0010\f\u0010\u0141\t\u0010\u0003\u0010\u0143"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0159\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0003\u0014\u015e\b\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0168\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0172\b\u0015\n"+
		"\u0015\f\u0015\u0175\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u017c\b\u0016\n\u0016\f\u0016\u017f\t\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u018e\b\u0017\u0001\u0017\u0000\u0000\u0018\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.\u0000\u0005\u0001\u0000\u001e\"\u0001\u0000\u000e\u0013"+
		"\u0001\u0000\u001e$\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004\u01b0"+
		"\u00000\u0001\u0000\u0000\u0000\u0002J\u0001\u0000\u0000\u0000\u0004^"+
		"\u0001\u0000\u0000\u0000\u0006\u009b\u0001\u0000\u0000\u0000\b\u009d\u0001"+
		"\u0000\u0000\u0000\n\u00b0\u0001\u0000\u0000\u0000\f\u00cf\u0001\u0000"+
		"\u0000\u0000\u000e\u00e3\u0001\u0000\u0000\u0000\u0010\u00fd\u0001\u0000"+
		"\u0000\u0000\u0012\u0101\u0001\u0000\u0000\u0000\u0014\u0107\u0001\u0000"+
		"\u0000\u0000\u0016\u010e\u0001\u0000\u0000\u0000\u0018\u0114\u0001\u0000"+
		"\u0000\u0000\u001a\u0118\u0001\u0000\u0000\u0000\u001c\u011c\u0001\u0000"+
		"\u0000\u0000\u001e\u0121\u0001\u0000\u0000\u0000 \u012c\u0001\u0000\u0000"+
		"\u0000\"\u0146\u0001\u0000\u0000\u0000$\u014b\u0001\u0000\u0000\u0000"+
		"&\u0158\u0001\u0000\u0000\u0000(\u015d\u0001\u0000\u0000\u0000*\u016c"+
		"\u0001\u0000\u0000\u0000,\u0176\u0001\u0000\u0000\u0000.\u018d\u0001\u0000"+
		"\u0000\u000004\u0006\u0000\uffff\uffff\u000013\u0005/\u0000\u000021\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u00005@\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u00007;\u0003\u0004\u0002\u00008:\u0005/\u0000\u000098\u0001\u0000\u0000"+
		"\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>7\u0001"+
		"\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000CG\u0003\u0002\u0001\u0000DF\u0005/\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000H\u0001\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"JK\u0005\u0014\u0000\u0000KL\u0005\u0015\u0000\u0000LM\u0005\u000b\u0000"+
		"\u0000MN\u0005\u0005\u0000\u0000NR\u0006\u0001\uffff\uffff\u0000OQ\u0003"+
		"\u0006\u0003\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000UY\u0005\u0006\u0000\u0000VX\u0005/\u0000"+
		"\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000\\]\u0006\u0001\uffff\uffff\u0000]\u0003\u0001\u0000"+
		"\u0000\u0000^_\u0006\u0002\uffff\uffff\u0000_`\u0005\u0014\u0000\u0000"+
		"`a\u0005-\u0000\u0000al\u0005\u000b\u0000\u0000bc\u0007\u0000\u0000\u0000"+
		"ci\u0005-\u0000\u0000de\u0005\u001c\u0000\u0000ef\u0007\u0000\u0000\u0000"+
		"fh\u0005-\u0000\u0000gd\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000lb\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000nu\u0005\u000b\u0000\u0000ov\u0005"+
		"\u001e\u0000\u0000pv\u0005\"\u0000\u0000qv\u0005!\u0000\u0000rv\u0005"+
		"\u001f\u0000\u0000sv\u0005 \u0000\u0000tv\u0005#\u0000\u0000uo\u0001\u0000"+
		"\u0000\u0000up\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000\u0000ur\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000"+
		"vw\u0001\u0000\u0000\u0000wx\u0005\u0005\u0000\u0000x|\u0006\u0002\uffff"+
		"\uffff\u0000y{\u0003\u0006\u0003\u0000zy\u0001\u0000\u0000\u0000{~\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\u007f\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005\r\u0000\u0000\u0080\u0081\u0003*\u0015\u0000\u0081\u0085\u0005"+
		"\u001d\u0000\u0000\u0082\u0084\u0005/\u0000\u0000\u0083\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008c\u0005\u0006"+
		"\u0000\u0000\u0089\u008b\u0005/\u0000\u0000\u008a\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0006\u0002\uffff"+
		"\uffff\u0000\u0090\u0005\u0001\u0000\u0000\u0000\u0091\u009c\u0005/\u0000"+
		"\u0000\u0092\u009c\u0003&\u0013\u0000\u0093\u009c\u0003\b\u0004\u0000"+
		"\u0094\u009c\u0003\n\u0005\u0000\u0095\u009c\u0003\f\u0006\u0000\u0096"+
		"\u009c\u0003\u000e\u0007\u0000\u0097\u009c\u0003\u0010\b\u0000\u0098\u009c"+
		"\u0003$\u0012\u0000\u0099\u009c\u0003\"\u0011\u0000\u009a\u009c\u0003"+
		"(\u0014\u0000\u009b\u0091\u0001\u0000\u0000\u0000\u009b\u0092\u0001\u0000"+
		"\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009b\u0094\u0001\u0000"+
		"\u0000\u0000\u009b\u0095\u0001\u0000\u0000\u0000\u009b\u0096\u0001\u0000"+
		"\u0000\u0000\u009b\u0097\u0001\u0000\u0000\u0000\u009b\u0098\u0001\u0000"+
		"\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u0007\u0001\u0000\u0000\u0000\u009d\u009e\u0006\u0004"+
		"\uffff\uffff\u0000\u009e\u009f\u0005\u0019\u0000\u0000\u009f\u00a0\u0005"+
		"\u000b\u0000\u0000\u00a0\u00a1\u0003*\u0015\u0000\u00a1\u00a2\u0007\u0001"+
		"\u0000\u0000\u00a2\u00a3\u0003*\u0015\u0000\u00a3\u00a4\u0006\u0004\uffff"+
		"\uffff\u0000\u00a4\u00a5\u0005\u0005\u0000\u0000\u00a5\u00a9\u0005/\u0000"+
		"\u0000\u00a6\u00a8\u0003\u0006\u0003\u0000\u00a7\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u0006\u0000"+
		"\u0000\u00ad\u00ae\u0005/\u0000\u0000\u00ae\u00af\u0006\u0004\uffff\uffff"+
		"\u0000\u00af\t\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006\u0005\uffff\uffff"+
		"\u0000\u00b1\u00b2\u0005\u0019\u0000\u0000\u00b2\u00b3\u0005\u000b\u0000"+
		"\u0000\u00b3\u00b4\u0003*\u0015\u0000\u00b4\u00b5\u0007\u0001\u0000\u0000"+
		"\u00b5\u00b6\u0003*\u0015\u0000\u00b6\u00b7\u0006\u0005\uffff\uffff\u0000"+
		"\u00b7\u00b8\u0005\u0005\u0000\u0000\u00b8\u00bc\u0005/\u0000\u0000\u00b9"+
		"\u00bb\u0003\u0006\u0003\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0006\u0005\uffff\uffff\u0000"+
		"\u00c0\u00c1\u0005\u0006\u0000\u0000\u00c1\u00c2\u0005\u001a\u0000\u0000"+
		"\u00c2\u00c3\u0005\u0005\u0000\u0000\u00c3\u00c4\u0005/\u0000\u0000\u00c4"+
		"\u00c8\u0006\u0005\uffff\uffff\u0000\u00c5\u00c7\u0003\u0006\u0003\u0000"+
		"\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005\u0006\u0000\u0000\u00cc\u00cd\u0005/\u0000\u0000\u00cd"+
		"\u00ce\u0006\u0005\uffff\uffff\u0000\u00ce\u000b\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0006\u0006\uffff\uffff\u0000\u00d0\u00d1\u0005\u001b\u0000"+
		"\u0000\u00d1\u00d2\u0005\u000b\u0000\u0000\u00d2\u00d3\u0003*\u0015\u0000"+
		"\u00d3\u00d4\u0007\u0001\u0000\u0000\u00d4\u00d5\u0003*\u0015\u0000\u00d5"+
		"\u00d6\u0006\u0006\uffff\uffff\u0000\u00d6\u00d7\u0005\u0005\u0000\u0000"+
		"\u00d7\u00db\u0005/\u0000\u0000\u00d8\u00da\u0003\u0006\u0003\u0000\u00d9"+
		"\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0006\u0006\uffff\uffff\u0000\u00df\u00e0\u0005\u0006\u0000\u0000"+
		"\u00e0\u00e1\u0005/\u0000\u0000\u00e1\u00e2\u0006\u0006\uffff\uffff\u0000"+
		"\u00e2\r\u0001\u0000\u0000\u0000\u00e3\u00e4\u0006\u0007\uffff\uffff\u0000"+
		"\u00e4\u00e5\u0005\u001b\u0000\u0000\u00e5\u00e6\u0005\u000b\u0000\u0000"+
		"\u00e6\u00e7\u0005,\u0000\u0000\u00e7\u00e8\u0005\u0005\u0000\u0000\u00e8"+
		"\u00ec\u0005/\u0000\u0000\u00e9\u00eb\u0003\u0006\u0003\u0000\u00ea\u00e9"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00f0"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f1"+
		"\u0003\u0010\b\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f5\u0001\u0000\u0000\u0000\u00f2\u00f4\u0003"+
		"\u0006\u0003\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0006\u0007\uffff\uffff\u0000\u00f9\u00fa"+
		"\u0005\u0006\u0000\u0000\u00fa\u00fb\u0005/\u0000\u0000\u00fb\u00fc\u0006"+
		"\u0007\uffff\uffff\u0000\u00fc\u000f\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0005+\u0000\u0000\u00fe\u00ff\u0005\u001d\u0000\u0000\u00ff\u0100\u0006"+
		"\b\uffff\uffff\u0000\u0100\u0011\u0001\u0000\u0000\u0000\u0101\u0102\u0005"+
		"\u0016\u0000\u0000\u0102\u0103\u0005\u000b\u0000\u0000\u0103\u0104\u0006"+
		"\t\uffff\uffff\u0000\u0104\u0105\u0003*\u0015\u0000\u0105\u0106\u0006"+
		"\t\uffff\uffff\u0000\u0106\u0013\u0001\u0000\u0000\u0000\u0107\u0108\u0005"+
		"\u0016\u0000\u0000\u0108\u0109\u0005\u000b\u0000\u0000\u0109\u010a\u0006"+
		"\n\uffff\uffff\u0000\u010a\u010b\u0005.\u0000\u0000\u010b\u010c\u0006"+
		"\n\uffff\uffff\u0000\u010c\u010d\u0006\n\uffff\uffff\u0000\u010d\u0015"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u0016\u0000\u0000\u010f\u0110"+
		"\u0005\u000b\u0000\u0000\u0110\u0111\u0006\u000b\uffff\uffff\u0000\u0111"+
		"\u0112\u0005-\u0000\u0000\u0112\u0113\u0006\u000b\uffff\uffff\u0000\u0113"+
		"\u0017\u0001\u0000\u0000\u0000\u0114\u0115\u0005\u0017\u0000\u0000\u0115"+
		"\u0116\u0005\u000b\u0000\u0000\u0116\u0117\u0006\f\uffff\uffff\u0000\u0117"+
		"\u0019\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u0018\u0000\u0000\u0119"+
		"\u011a\u0005\u000b\u0000\u0000\u011a\u011b\u0006\r\uffff\uffff\u0000\u011b"+
		"\u001b\u0001\u0000\u0000\u0000\u011c\u011d\u0005%\u0000\u0000\u011d\u011e"+
		"\u0005\u000b\u0000\u0000\u011e\u011f\u0005.\u0000\u0000\u011f\u0120\u0006"+
		"\u000e\uffff\uffff\u0000\u0120\u001d\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0005(\u0000\u0000\u0122\u0123\u0005\u000b\u0000\u0000\u0123\u0124\u0005"+
		".\u0000\u0000\u0124\u0125\u0006\u000f\uffff\uffff\u0000\u0125\u0128\u0005"+
		"\u001c\u0000\u0000\u0126\u0129\u0003.\u0017\u0000\u0127\u0129\u0005.\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0127\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b\u0006\u000f\uffff"+
		"\uffff\u0000\u012b\u001f\u0001\u0000\u0000\u0000\u012c\u012d\u0005-\u0000"+
		"\u0000\u012d\u0142\u0005\u000b\u0000\u0000\u012e\u0134\u0003.\u0017\u0000"+
		"\u012f\u0134\u0003*\u0015\u0000\u0130\u0131\u0003 \u0010\u0000\u0131\u0132"+
		"\u0005\u001d\u0000\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u012e"+
		"\u0001\u0000\u0000\u0000\u0133\u012f\u0001\u0000\u0000\u0000\u0133\u0130"+
		"\u0001\u0000\u0000\u0000\u0134\u013f\u0001\u0000\u0000\u0000\u0135\u0138"+
		"\u0005\u001c\u0000\u0000\u0136\u0139\u0003.\u0017\u0000\u0137\u0139\u0003"+
		"*\u0015\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0137\u0001\u0000"+
		"\u0000\u0000\u0139\u013e\u0001\u0000\u0000\u0000\u013a\u013b\u0003 \u0010"+
		"\u0000\u013b\u013c\u0005\u001d\u0000\u0000\u013c\u013e\u0001\u0000\u0000"+
		"\u0000\u013d\u0135\u0001\u0000\u0000\u0000\u013d\u013a\u0001\u0000\u0000"+
		"\u0000\u013e\u0141\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000"+
		"\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000"+
		"\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0142\u0133\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0006\u0010\uffff\uffff\u0000\u0145!\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0005&\u0000\u0000\u0147\u0148\u0005-\u0000\u0000\u0148"+
		"\u0149\u0005\u001d\u0000\u0000\u0149\u014a\u0006\u0011\uffff\uffff\u0000"+
		"\u014a#\u0001\u0000\u0000\u0000\u014b\u014c\u0005\'\u0000\u0000\u014c"+
		"\u014d\u0005-\u0000\u0000\u014d\u014e\u0005\u001d\u0000\u0000\u014e\u014f"+
		"\u0006\u0012\uffff\uffff\u0000\u014f%\u0001\u0000\u0000\u0000\u0150\u0159"+
		"\u0003\u0012\t\u0000\u0151\u0159\u0003\u0014\n\u0000\u0152\u0159\u0003"+
		"\u0016\u000b\u0000\u0153\u0159\u0003\u0018\f\u0000\u0154\u0159\u0003\u001a"+
		"\r\u0000\u0155\u0159\u0003\u001c\u000e\u0000\u0156\u0159\u0003\u001e\u000f"+
		"\u0000\u0157\u0159\u0003 \u0010\u0000\u0158\u0150\u0001\u0000\u0000\u0000"+
		"\u0158\u0151\u0001\u0000\u0000\u0000\u0158\u0152\u0001\u0000\u0000\u0000"+
		"\u0158\u0153\u0001\u0000\u0000\u0000\u0158\u0154\u0001\u0000\u0000\u0000"+
		"\u0158\u0155\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000"+
		"\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000"+
		"\u015a\u015b\u0005\u001d\u0000\u0000\u015b\'\u0001\u0000\u0000\u0000\u015c"+
		"\u015e\u0007\u0002\u0000\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015d"+
		"\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f"+
		"\u0160\u0005-\u0000\u0000\u0160\u0167\u0005\f\u0000\u0000\u0161\u0168"+
		"\u0003*\u0015\u0000\u0162\u0168\u0003 \u0010\u0000\u0163\u0168\u0003\u0018"+
		"\f\u0000\u0164\u0168\u0003\u001a\r\u0000\u0165\u0168\u0003\u001c\u000e"+
		"\u0000\u0166\u0168\u0005.\u0000\u0000\u0167\u0161\u0001\u0000\u0000\u0000"+
		"\u0167\u0162\u0001\u0000\u0000\u0000\u0167\u0163\u0001\u0000\u0000\u0000"+
		"\u0167\u0164\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000"+
		"\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000"+
		"\u0169\u016a\u0006\u0014\uffff\uffff\u0000\u016a\u016b\u0005\u001d\u0000"+
		"\u0000\u016b)\u0001\u0000\u0000\u0000\u016c\u0173\u0003,\u0016\u0000\u016d"+
		"\u016e\u0007\u0003\u0000\u0000\u016e\u016f\u0003,\u0016\u0000\u016f\u0170"+
		"\u0006\u0015\uffff\uffff\u0000\u0170\u0172\u0001\u0000\u0000\u0000\u0171"+
		"\u016d\u0001\u0000\u0000\u0000\u0172\u0175\u0001\u0000\u0000\u0000\u0173"+
		"\u0171\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174"+
		"+\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0176\u017d"+
		"\u0003.\u0017\u0000\u0177\u0178\u0007\u0004\u0000\u0000\u0178\u0179\u0003"+
		".\u0017\u0000\u0179\u017a\u0006\u0016\uffff\uffff\u0000\u017a\u017c\u0001"+
		"\u0000\u0000\u0000\u017b\u0177\u0001\u0000\u0000\u0000\u017c\u017f\u0001"+
		"\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001"+
		"\u0000\u0000\u0000\u017e-\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000"+
		"\u0000\u0000\u0180\u0181\u0005)\u0000\u0000\u0181\u018e\u0006\u0017\uffff"+
		"\uffff\u0000\u0182\u0183\u0005-\u0000\u0000\u0183\u018e\u0006\u0017\uffff"+
		"\uffff\u0000\u0184\u0185\u0005-\u0000\u0000\u0185\u0186\u0005\u0007\u0000"+
		"\u0000\u0186\u0187\u0005)\u0000\u0000\u0187\u0188\u0005\b\u0000\u0000"+
		"\u0188\u018e\u0006\u0017\uffff\uffff\u0000\u0189\u018a\u0005\t\u0000\u0000"+
		"\u018a\u018b\u0003*\u0015\u0000\u018b\u018c\u0005\n\u0000\u0000\u018c"+
		"\u018e\u0001\u0000\u0000\u0000\u018d\u0180\u0001\u0000\u0000\u0000\u018d"+
		"\u0182\u0001\u0000\u0000\u0000\u018d\u0184\u0001\u0000\u0000\u0000\u018d"+
		"\u0189\u0001\u0000\u0000\u0000\u018e/\u0001\u0000\u0000\u0000 4;@GRYi"+
		"lu|\u0085\u008c\u009b\u00a9\u00bc\u00c8\u00db\u00ec\u00f0\u00f5\u0128"+
		"\u0133\u0138\u013d\u013f\u0142\u0158\u015d\u0167\u0173\u017d\u018d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}