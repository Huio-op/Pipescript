// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;

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
		PLUS=1, MINUS=2, TIMES=3, OVER=4, OPEN_C=5, CLOSE_C=6, OPEN_B=7, CLOSE_B=8, 
		OPEN_P=9, CLOSE_P=10, PIPE=11, ATTRIB=12, EQUAL=13, DIFFER=14, LESSER=15, 
		LESSER_EQUAL=16, GREATER=17, GREATER_EQUAL=18, FUNC=19, PRINT=20, IF=21, 
		ELSE=22, WHILE=23, COMMA=24, SEMICOLON=25, VAR=26, NUM=27, STRING=28, 
		NL=29, WS=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS", "MINUS", "TIMES", "OVER", "OPEN_C", "CLOSE_C", "OPEN_B", "CLOSE_B", 
			"OPEN_P", "CLOSE_P", "PIPE", "ATTRIB", "EQUAL", "DIFFER", "LESSER", "LESSER_EQUAL", 
			"GREATER", "GREATER_EQUAL", "FUNC", "PRINT", "IF", "ELSE", "WHILE", "COMMA", 
			"SEMICOLON", "VAR", "NUM", "STRING", "NL", "WS"
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
		"\u0004\u0000\u001e\u00b0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0004\u0012r\b\u0012\u000b\u0012\f\u0012s\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012y\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0004\u0019\u0093\b\u0019\u000b\u0019\f"+
		"\u0019\u0094\u0001\u001a\u0004\u001a\u0098\b\u001a\u000b\u001a\f\u001a"+
		"\u0099\u0001\u001b\u0001\u001b\u0005\u001b\u009e\b\u001b\n\u001b\f\u001b"+
		"\u00a1\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0003\u001c\u00a6\b"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0004\u001d\u00ab\b\u001d\u000b"+
		"\u001d\f\u001d\u00ac\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u001c9\u001d;\u001e\u0001\u0000\u0003\u0002\u0000"+
		"AZaz\u0001\u0000\"\"\u0003\u0000\t\t\r\r  \u00b6\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0001=\u0001\u0000\u0000\u0000\u0003"+
		"?\u0001\u0000\u0000\u0000\u0005A\u0001\u0000\u0000\u0000\u0007C\u0001"+
		"\u0000\u0000\u0000\tE\u0001\u0000\u0000\u0000\u000bG\u0001\u0000\u0000"+
		"\u0000\rI\u0001\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000\u0011"+
		"M\u0001\u0000\u0000\u0000\u0013O\u0001\u0000\u0000\u0000\u0015Q\u0001"+
		"\u0000\u0000\u0000\u0017S\u0001\u0000\u0000\u0000\u0019V\u0001\u0000\u0000"+
		"\u0000\u001bY\u0001\u0000\u0000\u0000\u001d]\u0001\u0000\u0000\u0000\u001f"+
		"`\u0001\u0000\u0000\u0000!d\u0001\u0000\u0000\u0000#g\u0001\u0000\u0000"+
		"\u0000%k\u0001\u0000\u0000\u0000\'z\u0001\u0000\u0000\u0000)\u007f\u0001"+
		"\u0000\u0000\u0000+\u0082\u0001\u0000\u0000\u0000-\u0087\u0001\u0000\u0000"+
		"\u0000/\u008d\u0001\u0000\u0000\u00001\u008f\u0001\u0000\u0000\u00003"+
		"\u0092\u0001\u0000\u0000\u00005\u0097\u0001\u0000\u0000\u00007\u009b\u0001"+
		"\u0000\u0000\u00009\u00a5\u0001\u0000\u0000\u0000;\u00aa\u0001\u0000\u0000"+
		"\u0000=>\u0005+\u0000\u0000>\u0002\u0001\u0000\u0000\u0000?@\u0005-\u0000"+
		"\u0000@\u0004\u0001\u0000\u0000\u0000AB\u0005*\u0000\u0000B\u0006\u0001"+
		"\u0000\u0000\u0000CD\u0005/\u0000\u0000D\b\u0001\u0000\u0000\u0000EF\u0005"+
		"{\u0000\u0000F\n\u0001\u0000\u0000\u0000GH\u0005}\u0000\u0000H\f\u0001"+
		"\u0000\u0000\u0000IJ\u0005[\u0000\u0000J\u000e\u0001\u0000\u0000\u0000"+
		"KL\u0005]\u0000\u0000L\u0010\u0001\u0000\u0000\u0000MN\u0005(\u0000\u0000"+
		"N\u0012\u0001\u0000\u0000\u0000OP\u0005)\u0000\u0000P\u0014\u0001\u0000"+
		"\u0000\u0000QR\u0005|\u0000\u0000R\u0016\u0001\u0000\u0000\u0000ST\u0005"+
		"<\u0000\u0000TU\u0005<\u0000\u0000U\u0018\u0001\u0000\u0000\u0000VW\u0005"+
		"i\u0000\u0000WX\u0005s\u0000\u0000X\u001a\u0001\u0000\u0000\u0000YZ\u0005"+
		"n\u0000\u0000Z[\u0005o\u0000\u0000[\\\u0005t\u0000\u0000\\\u001c\u0001"+
		"\u0000\u0000\u0000]^\u0005l\u0000\u0000^_\u0005t\u0000\u0000_\u001e\u0001"+
		"\u0000\u0000\u0000`a\u0005l\u0000\u0000ab\u0005t\u0000\u0000bc\u0005e"+
		"\u0000\u0000c \u0001\u0000\u0000\u0000de\u0005g\u0000\u0000ef\u0005t\u0000"+
		"\u0000f\"\u0001\u0000\u0000\u0000gh\u0005g\u0000\u0000hi\u0005t\u0000"+
		"\u0000ij\u0005e\u0000\u0000j$\u0001\u0000\u0000\u0000kl\u0005f\u0000\u0000"+
		"lm\u0005u\u0000\u0000mn\u0005n\u0000\u0000no\u0005 \u0000\u0000oq\u0001"+
		"\u0000\u0000\u0000pr\u0007\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tx\u0001\u0000\u0000\u0000uy\u0005|\u0000\u0000vw\u0005 \u0000\u0000"+
		"wy\u0005|\u0000\u0000xu\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"y&\u0001\u0000\u0000\u0000z{\u0005t\u0000\u0000{|\u0005e\u0000\u0000|"+
		"}\u0005x\u0000\u0000}~\u0005t\u0000\u0000~(\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005i\u0000\u0000\u0080\u0081\u0005f\u0000\u0000\u0081*\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005e\u0000\u0000\u0083\u0084\u0005l\u0000"+
		"\u0000\u0084\u0085\u0005s\u0000\u0000\u0085\u0086\u0005e\u0000\u0000\u0086"+
		",\u0001\u0000\u0000\u0000\u0087\u0088\u0005w\u0000\u0000\u0088\u0089\u0005"+
		"h\u0000\u0000\u0089\u008a\u0005i\u0000\u0000\u008a\u008b\u0005l\u0000"+
		"\u0000\u008b\u008c\u0005e\u0000\u0000\u008c.\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0005,\u0000\u0000\u008e0\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		";\u0000\u0000\u00902\u0001\u0000\u0000\u0000\u0091\u0093\u0007\u0000\u0000"+
		"\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u00954\u0001\u0000\u0000\u0000\u0096\u0098\u000209\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"6\u0001\u0000\u0000\u0000\u009b\u009f\u0005\"\u0000\u0000\u009c\u009e"+
		"\b\u0001\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00a1\u0001"+
		"\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0005\"\u0000\u0000\u00a38\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a6\u0005\r\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0005\n\u0000\u0000\u00a8:\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ab\u0007\u0002\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0006\u001d\u0000\u0000\u00af<\u0001\u0000\u0000\u0000\b"+
		"\u0000sx\u0094\u0099\u009f\u00a5\u00ac\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}