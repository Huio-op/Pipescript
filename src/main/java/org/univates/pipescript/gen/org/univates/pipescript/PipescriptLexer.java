// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.function.Function;
    import java.util.Optional;
    import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PipescriptLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS", "MINUS", "TIMES", "DIV", "OPEN_C", "CLOSE_C", "OPEN_B", "CLOSE_B", 
			"OPEN_P", "CLOSE_P", "PIPE", "ATTRIB", "RETURN", "EQUAL", "DIFFER", "LESSER", 
			"LESSER_EQUAL", "GREATER", "GREATER_EQUAL", "FUNC", "MAIN", "PRINT", 
			"IF", "ELSE", "WHILE", "COMMA", "SEMICOLON", "VAR", "NUM", "STRING", 
			"NL", "WS", "INT_VAR", "DOUBLE_VAR", "STRING_VAR", "CHAR_VAR", "BOOL_VAR", 
			"VOID_VAR", "NULL_VAR"
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


	public PipescriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pipescript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\'\u00e4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0004\u001b\u00a2\b\u001b\u000b\u001b\f\u001b\u00a3\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0004\u001c\u00a9\b\u001c\u000b\u001c\f\u001c"+
		"\u00aa\u0001\u001d\u0001\u001d\u0005\u001d\u00af\b\u001d\n\u001d\f\u001d"+
		"\u00b2\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0003\u001e\u00b7\b"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0004\u001f\u00bc\b\u001f\u000b"+
		"\u001f\f\u001f\u00bd\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0000\u0000\'\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f? A!C\"E#G$I%K&M\'\u0001\u0000\u0004\u0002\u0000AZaz\f\u0000"+
		"  \'\',,CCFFNNUUeeppttyy||\u0001\u0000\"\"\u0003\u0000\t\t\r\r  \u00e8"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K"+
		"\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0001O\u0001\u0000"+
		"\u0000\u0000\u0003Q\u0001\u0000\u0000\u0000\u0005S\u0001\u0000\u0000\u0000"+
		"\u0007U\u0001\u0000\u0000\u0000\tW\u0001\u0000\u0000\u0000\u000bY\u0001"+
		"\u0000\u0000\u0000\r[\u0001\u0000\u0000\u0000\u000f]\u0001\u0000\u0000"+
		"\u0000\u0011_\u0001\u0000\u0000\u0000\u0013a\u0001\u0000\u0000\u0000\u0015"+
		"c\u0001\u0000\u0000\u0000\u0017e\u0001\u0000\u0000\u0000\u0019h\u0001"+
		"\u0000\u0000\u0000\u001bk\u0001\u0000\u0000\u0000\u001dn\u0001\u0000\u0000"+
		"\u0000\u001fr\u0001\u0000\u0000\u0000!u\u0001\u0000\u0000\u0000#y\u0001"+
		"\u0000\u0000\u0000%|\u0001\u0000\u0000\u0000\'\u0080\u0001\u0000\u0000"+
		"\u0000)\u0084\u0001\u0000\u0000\u0000+\u0089\u0001\u0000\u0000\u0000-"+
		"\u008e\u0001\u0000\u0000\u0000/\u0091\u0001\u0000\u0000\u00001\u0096\u0001"+
		"\u0000\u0000\u00003\u009c\u0001\u0000\u0000\u00005\u009e\u0001\u0000\u0000"+
		"\u00007\u00a1\u0001\u0000\u0000\u00009\u00a8\u0001\u0000\u0000\u0000;"+
		"\u00ac\u0001\u0000\u0000\u0000=\u00b6\u0001\u0000\u0000\u0000?\u00bb\u0001"+
		"\u0000\u0000\u0000A\u00c1\u0001\u0000\u0000\u0000C\u00c5\u0001\u0000\u0000"+
		"\u0000E\u00cc\u0001\u0000\u0000\u0000G\u00d0\u0001\u0000\u0000\u0000I"+
		"\u00d5\u0001\u0000\u0000\u0000K\u00da\u0001\u0000\u0000\u0000M\u00df\u0001"+
		"\u0000\u0000\u0000OP\u0005+\u0000\u0000P\u0002\u0001\u0000\u0000\u0000"+
		"QR\u0005-\u0000\u0000R\u0004\u0001\u0000\u0000\u0000ST\u0005*\u0000\u0000"+
		"T\u0006\u0001\u0000\u0000\u0000UV\u0005/\u0000\u0000V\b\u0001\u0000\u0000"+
		"\u0000WX\u0005{\u0000\u0000X\n\u0001\u0000\u0000\u0000YZ\u0005}\u0000"+
		"\u0000Z\f\u0001\u0000\u0000\u0000[\\\u0005[\u0000\u0000\\\u000e\u0001"+
		"\u0000\u0000\u0000]^\u0005]\u0000\u0000^\u0010\u0001\u0000\u0000\u0000"+
		"_`\u0005(\u0000\u0000`\u0012\u0001\u0000\u0000\u0000ab\u0005)\u0000\u0000"+
		"b\u0014\u0001\u0000\u0000\u0000cd\u0005|\u0000\u0000d\u0016\u0001\u0000"+
		"\u0000\u0000ef\u0005<\u0000\u0000fg\u0005<\u0000\u0000g\u0018\u0001\u0000"+
		"\u0000\u0000hi\u0005>\u0000\u0000ij\u0005>\u0000\u0000j\u001a\u0001\u0000"+
		"\u0000\u0000kl\u0005i\u0000\u0000lm\u0005s\u0000\u0000m\u001c\u0001\u0000"+
		"\u0000\u0000no\u0005n\u0000\u0000op\u0005o\u0000\u0000pq\u0005t\u0000"+
		"\u0000q\u001e\u0001\u0000\u0000\u0000rs\u0005l\u0000\u0000st\u0005t\u0000"+
		"\u0000t \u0001\u0000\u0000\u0000uv\u0005l\u0000\u0000vw\u0005t\u0000\u0000"+
		"wx\u0005e\u0000\u0000x\"\u0001\u0000\u0000\u0000yz\u0005g\u0000\u0000"+
		"z{\u0005t\u0000\u0000{$\u0001\u0000\u0000\u0000|}\u0005g\u0000\u0000}"+
		"~\u0005t\u0000\u0000~\u007f\u0005e\u0000\u0000\u007f&\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005f\u0000\u0000\u0081\u0082\u0005u\u0000\u0000\u0082"+
		"\u0083\u0005n\u0000\u0000\u0083(\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"m\u0000\u0000\u0085\u0086\u0005a\u0000\u0000\u0086\u0087\u0005i\u0000"+
		"\u0000\u0087\u0088\u0005n\u0000\u0000\u0088*\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0005t\u0000\u0000\u008a\u008b\u0005e\u0000\u0000\u008b\u008c\u0005"+
		"x\u0000\u0000\u008c\u008d\u0005t\u0000\u0000\u008d,\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005i\u0000\u0000\u008f\u0090\u0005f\u0000\u0000\u0090"+
		".\u0001\u0000\u0000\u0000\u0091\u0092\u0005e\u0000\u0000\u0092\u0093\u0005"+
		"l\u0000\u0000\u0093\u0094\u0005s\u0000\u0000\u0094\u0095\u0005e\u0000"+
		"\u0000\u00950\u0001\u0000\u0000\u0000\u0096\u0097\u0005w\u0000\u0000\u0097"+
		"\u0098\u0005h\u0000\u0000\u0098\u0099\u0005i\u0000\u0000\u0099\u009a\u0005"+
		"l\u0000\u0000\u009a\u009b\u0005e\u0000\u0000\u009b2\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0005,\u0000\u0000\u009d4\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0005;\u0000\u0000\u009f6\u0001\u0000\u0000\u0000\u00a0\u00a2\u0007"+
		"\u0000\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\b\u0001"+
		"\u0000\u0000\u00a68\u0001\u0000\u0000\u0000\u00a7\u00a9\u000209\u0000"+
		"\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab:\u0001\u0000\u0000\u0000\u00ac\u00b0\u0005\"\u0000\u0000\u00ad"+
		"\u00af\b\u0002\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\"\u0000\u0000\u00b4<\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b7\u0005\r\u0000\u0000\u00b6\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\n\u0000\u0000\u00b9>\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bc\u0007\u0003\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0006\u001f\u0000\u0000\u00c0@\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0005i\u0000\u0000\u00c2\u00c3\u0005n\u0000\u0000\u00c3\u00c4"+
		"\u0005t\u0000\u0000\u00c4B\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005d"+
		"\u0000\u0000\u00c6\u00c7\u0005o\u0000\u0000\u00c7\u00c8\u0005u\u0000\u0000"+
		"\u00c8\u00c9\u0005b\u0000\u0000\u00c9\u00ca\u0005l\u0000\u0000\u00ca\u00cb"+
		"\u0005e\u0000\u0000\u00cbD\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005s"+
		"\u0000\u0000\u00cd\u00ce\u0005t\u0000\u0000\u00ce\u00cf\u0005r\u0000\u0000"+
		"\u00cfF\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005c\u0000\u0000\u00d1\u00d2"+
		"\u0005h\u0000\u0000\u00d2\u00d3\u0005a\u0000\u0000\u00d3\u00d4\u0005r"+
		"\u0000\u0000\u00d4H\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005b\u0000\u0000"+
		"\u00d6\u00d7\u0005o\u0000\u0000\u00d7\u00d8\u0005o\u0000\u0000\u00d8\u00d9"+
		"\u0005l\u0000\u0000\u00d9J\u0001\u0000\u0000\u0000\u00da\u00db\u0005v"+
		"\u0000\u0000\u00db\u00dc\u0005o\u0000\u0000\u00dc\u00dd\u0005i\u0000\u0000"+
		"\u00dd\u00de\u0005d\u0000\u0000\u00deL\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0005n\u0000\u0000\u00e0\u00e1\u0005u\u0000\u0000\u00e1\u00e2\u0005l"+
		"\u0000\u0000\u00e2\u00e3\u0005l\u0000\u0000\u00e3N\u0001\u0000\u0000\u0000"+
		"\u0006\u0000\u00a3\u00aa\u00b0\u00b6\u00bd\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}