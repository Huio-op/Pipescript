// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/example/Tara.g4 by ANTLR 4.13.1
package org.example.gen;

    import java.util.Map;
    import java.util.LinkedHashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
		import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TaraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, TIMES=3, OVER=4, OPEN_C=5, CLOSE_C=6, OPEN_B=7, CLOSE_B=8, 
		OPEN_P=9, CLOSE_P=10, ATTRIB=11, EQUAL=12, DIFFER=13, LESSER=14, LESSER_EQUAL=15, 
		GREATER=16, GREATER_EQUAL=17, FUNC=18, MAIN=19, PRINT=20, IF=21, ELSE=22, 
		WHILE=23, COMMA=24, VAR=25, NUM=26, STRING=27, NL=28, SPACE=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS", "MINUS", "TIMES", "OVER", "OPEN_C", "CLOSE_C", "OPEN_B", "CLOSE_B", 
			"OPEN_P", "CLOSE_P", "ATTRIB", "EQUAL", "DIFFER", "LESSER", "LESSER_EQUAL", 
			"GREATER", "GREATER_EQUAL", "FUNC", "MAIN", "PRINT", "IF", "ELSE", "WHILE", 
			"COMMA", "VAR", "NUM", "STRING", "NL", "SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'public'", 
			"'function'", "'print_r'", "'if'", "'else'", "'while'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "TIMES", "OVER", "OPEN_C", "CLOSE_C", "OPEN_B", 
			"CLOSE_B", "OPEN_P", "CLOSE_P", "ATTRIB", "EQUAL", "DIFFER", "LESSER", 
			"LESSER_EQUAL", "GREATER", "GREATER_EQUAL", "FUNC", "MAIN", "PRINT", 
			"IF", "ELSE", "WHILE", "COMMA", "VAR", "NUM", "STRING", "NL", "SPACE"
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
	        TaraLexer lexer = new TaraLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TaraParser parser = new TaraParser(tokens);
	        parser.program();
	    }


	public TaraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tara.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 28:
			SPACE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void SPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u00ad\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0004\u0018\u008b\b\u0018\u000b\u0018\f\u0018\u008c"+
		"\u0001\u0018\u0004\u0018\u0090\b\u0018\u000b\u0018\f\u0018\u0091\u0001"+
		"\u0019\u0004\u0019\u0095\b\u0019\u000b\u0019\f\u0019\u0096\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u009b\b\u001a\n\u001a\f\u001a\u009e\t\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0003\u001b\u00a3\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0004\u001c\u00a8\b\u001c\u000b\u001c\f\u001c\u00a9"+
		"\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d\u0001\u0000\u0002\u0001\u0000\"\"\u0002\u0000\t\t  \u00b2"+
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
		"\u00009\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000\u0003="+
		"\u0001\u0000\u0000\u0000\u0005?\u0001\u0000\u0000\u0000\u0007A\u0001\u0000"+
		"\u0000\u0000\tC\u0001\u0000\u0000\u0000\u000bE\u0001\u0000\u0000\u0000"+
		"\rG\u0001\u0000\u0000\u0000\u000fI\u0001\u0000\u0000\u0000\u0011K\u0001"+
		"\u0000\u0000\u0000\u0013M\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000"+
		"\u0000\u0017Q\u0001\u0000\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001b"+
		"W\u0001\u0000\u0000\u0000\u001dY\u0001\u0000\u0000\u0000\u001f\\\u0001"+
		"\u0000\u0000\u0000!^\u0001\u0000\u0000\u0000#a\u0001\u0000\u0000\u0000"+
		"%h\u0001\u0000\u0000\u0000\'q\u0001\u0000\u0000\u0000)y\u0001\u0000\u0000"+
		"\u0000+|\u0001\u0000\u0000\u0000-\u0081\u0001\u0000\u0000\u0000/\u0087"+
		"\u0001\u0000\u0000\u00001\u008a\u0001\u0000\u0000\u00003\u0094\u0001\u0000"+
		"\u0000\u00005\u0098\u0001\u0000\u0000\u00007\u00a2\u0001\u0000\u0000\u0000"+
		"9\u00a7\u0001\u0000\u0000\u0000;<\u0005+\u0000\u0000<\u0002\u0001\u0000"+
		"\u0000\u0000=>\u0005-\u0000\u0000>\u0004\u0001\u0000\u0000\u0000?@\u0005"+
		"*\u0000\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005/\u0000\u0000B\b\u0001"+
		"\u0000\u0000\u0000CD\u0005{\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005"+
		"}\u0000\u0000F\f\u0001\u0000\u0000\u0000GH\u0005[\u0000\u0000H\u000e\u0001"+
		"\u0000\u0000\u0000IJ\u0005]\u0000\u0000J\u0010\u0001\u0000\u0000\u0000"+
		"KL\u0005(\u0000\u0000L\u0012\u0001\u0000\u0000\u0000MN\u0005)\u0000\u0000"+
		"N\u0014\u0001\u0000\u0000\u0000OP\u0005=\u0000\u0000P\u0016\u0001\u0000"+
		"\u0000\u0000QR\u0005=\u0000\u0000RS\u0005=\u0000\u0000S\u0018\u0001\u0000"+
		"\u0000\u0000TU\u0005!\u0000\u0000UV\u0005=\u0000\u0000V\u001a\u0001\u0000"+
		"\u0000\u0000WX\u0005<\u0000\u0000X\u001c\u0001\u0000\u0000\u0000YZ\u0005"+
		"<\u0000\u0000Z[\u0005=\u0000\u0000[\u001e\u0001\u0000\u0000\u0000\\]\u0005"+
		">\u0000\u0000] \u0001\u0000\u0000\u0000^_\u0005>\u0000\u0000_`\u0005="+
		"\u0000\u0000`\"\u0001\u0000\u0000\u0000ab\u0005p\u0000\u0000bc\u0005u"+
		"\u0000\u0000cd\u0005b\u0000\u0000de\u0005l\u0000\u0000ef\u0005i\u0000"+
		"\u0000fg\u0005c\u0000\u0000g$\u0001\u0000\u0000\u0000hi\u0005f\u0000\u0000"+
		"ij\u0005u\u0000\u0000jk\u0005n\u0000\u0000kl\u0005c\u0000\u0000lm\u0005"+
		"t\u0000\u0000mn\u0005i\u0000\u0000no\u0005o\u0000\u0000op\u0005n\u0000"+
		"\u0000p&\u0001\u0000\u0000\u0000qr\u0005p\u0000\u0000rs\u0005r\u0000\u0000"+
		"st\u0005i\u0000\u0000tu\u0005n\u0000\u0000uv\u0005t\u0000\u0000vw\u0005"+
		"_\u0000\u0000wx\u0005r\u0000\u0000x(\u0001\u0000\u0000\u0000yz\u0005i"+
		"\u0000\u0000z{\u0005f\u0000\u0000{*\u0001\u0000\u0000\u0000|}\u0005e\u0000"+
		"\u0000}~\u0005l\u0000\u0000~\u007f\u0005s\u0000\u0000\u007f\u0080\u0005"+
		"e\u0000\u0000\u0080,\u0001\u0000\u0000\u0000\u0081\u0082\u0005w\u0000"+
		"\u0000\u0082\u0083\u0005h\u0000\u0000\u0083\u0084\u0005i\u0000\u0000\u0084"+
		"\u0085\u0005l\u0000\u0000\u0085\u0086\u0005e\u0000\u0000\u0086.\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005,\u0000\u0000\u00880\u0001\u0000\u0000"+
		"\u0000\u0089\u008b\u0005$\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0002az\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u00922\u0001\u0000\u0000\u0000\u0093\u0095\u0002"+
		"09\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u00974\u0001\u0000\u0000\u0000\u0098\u009c\u0005\"\u0000\u0000"+
		"\u0099\u009b\b\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\"\u0000\u0000\u00a06"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a3\u0005\r\u0000\u0000\u00a2\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0005\n\u0000\u0000\u00a58\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a8\u0007\u0001\u0000\u0000\u00a7\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0006\u001c\u0000\u0000\u00ac:\u0001\u0000\u0000"+
		"\u0000\u0007\u0000\u008c\u0091\u0096\u009c\u00a2\u00a9\u0001\u0001\u001c"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}