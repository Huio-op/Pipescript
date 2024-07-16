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
		PRINT=22, INT_SCANNER=23, STR_SCANNER=24, IF=25, ELSE=26, WHILE=27, COMMA=28, 
		SEMICOLON=29, INT_VAR=30, DOUBLE_VAR=31, STRING_VAR=32, CHAR_VAR=33, BOOL_VAR=34, 
		VOID_VAR=35, NULL_VAR=36, READ=37, GOTO=38, DEF_GOTO=39, WRITE=40, NUM=41, 
		COMMENT=42, BREAK=43, TRUE=44, VAR=45, STRING=46, NL=47, WS=48;
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
			"INT_SCANNER", "STR_SCANNER", "IF", "ELSE", "WHILE", "COMMA", "SEMICOLON", 
			"INT_VAR", "DOUBLE_VAR", "STRING_VAR", "CHAR_VAR", "BOOL_VAR", "VOID_VAR", 
			"NULL_VAR", "READ", "GOTO", "DEF_GOTO", "WRITE", "NUM", "COMMENT", "BREAK", 
			"TRUE", "VAR", "STRING", "NL", "WS"
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
		"\u0004\u00000\u0134\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001(\u0004(\u00fd\b(\u000b(\f(\u00fe\u0001"+
		")\u0001)\u0005)\u0103\b)\n)\f)\u0106\t)\u0001)\u0001)\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001,\u0001,\u0005,\u0119\b,\n,\f,\u011c\t,\u0001-\u0001-\u0001-\u0001"+
		"-\u0005-\u0122\b-\n-\f-\u0125\t-\u0001-\u0001-\u0001.\u0003.\u012a\b."+
		"\u0001.\u0001.\u0001/\u0004/\u012f\b/\u000b/\f/\u0130\u0001/\u0001/\u0001"+
		"\u0104\u00000\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0\u0001\u0000\u0005\u0001\u000009\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000\"\"\\\\\u0003\u0000\t\t\r"+
		"\r  \u013a\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000"+
		"\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000"+
		"]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0001a\u0001"+
		"\u0000\u0000\u0000\u0003c\u0001\u0000\u0000\u0000\u0005e\u0001\u0000\u0000"+
		"\u0000\u0007g\u0001\u0000\u0000\u0000\ti\u0001\u0000\u0000\u0000\u000b"+
		"k\u0001\u0000\u0000\u0000\rm\u0001\u0000\u0000\u0000\u000fo\u0001\u0000"+
		"\u0000\u0000\u0011q\u0001\u0000\u0000\u0000\u0013s\u0001\u0000\u0000\u0000"+
		"\u0015u\u0001\u0000\u0000\u0000\u0017w\u0001\u0000\u0000\u0000\u0019z"+
		"\u0001\u0000\u0000\u0000\u001b}\u0001\u0000\u0000\u0000\u001d\u0080\u0001"+
		"\u0000\u0000\u0000\u001f\u0084\u0001\u0000\u0000\u0000!\u0087\u0001\u0000"+
		"\u0000\u0000#\u008b\u0001\u0000\u0000\u0000%\u008e\u0001\u0000\u0000\u0000"+
		"\'\u0092\u0001\u0000\u0000\u0000)\u0096\u0001\u0000\u0000\u0000+\u009b"+
		"\u0001\u0000\u0000\u0000-\u00a0\u0001\u0000\u0000\u0000/\u00aa\u0001\u0000"+
		"\u0000\u00001\u00b4\u0001\u0000\u0000\u00003\u00b7\u0001\u0000\u0000\u0000"+
		"5\u00bc\u0001\u0000\u0000\u00007\u00c2\u0001\u0000\u0000\u00009\u00c4"+
		"\u0001\u0000\u0000\u0000;\u00c6\u0001\u0000\u0000\u0000=\u00ca\u0001\u0000"+
		"\u0000\u0000?\u00d1\u0001\u0000\u0000\u0000A\u00d5\u0001\u0000\u0000\u0000"+
		"C\u00da\u0001\u0000\u0000\u0000E\u00df\u0001\u0000\u0000\u0000G\u00e4"+
		"\u0001\u0000\u0000\u0000I\u00e9\u0001\u0000\u0000\u0000K\u00ee\u0001\u0000"+
		"\u0000\u0000M\u00f0\u0001\u0000\u0000\u0000O\u00f5\u0001\u0000\u0000\u0000"+
		"Q\u00fc\u0001\u0000\u0000\u0000S\u0100\u0001\u0000\u0000\u0000U\u010b"+
		"\u0001\u0000\u0000\u0000W\u0111\u0001\u0000\u0000\u0000Y\u0116\u0001\u0000"+
		"\u0000\u0000[\u011d\u0001\u0000\u0000\u0000]\u0129\u0001\u0000\u0000\u0000"+
		"_\u012e\u0001\u0000\u0000\u0000ab\u0005+\u0000\u0000b\u0002\u0001\u0000"+
		"\u0000\u0000cd\u0005-\u0000\u0000d\u0004\u0001\u0000\u0000\u0000ef\u0005"+
		"*\u0000\u0000f\u0006\u0001\u0000\u0000\u0000gh\u0005/\u0000\u0000h\b\u0001"+
		"\u0000\u0000\u0000ij\u0005{\u0000\u0000j\n\u0001\u0000\u0000\u0000kl\u0005"+
		"}\u0000\u0000l\f\u0001\u0000\u0000\u0000mn\u0005[\u0000\u0000n\u000e\u0001"+
		"\u0000\u0000\u0000op\u0005]\u0000\u0000p\u0010\u0001\u0000\u0000\u0000"+
		"qr\u0005(\u0000\u0000r\u0012\u0001\u0000\u0000\u0000st\u0005)\u0000\u0000"+
		"t\u0014\u0001\u0000\u0000\u0000uv\u0005|\u0000\u0000v\u0016\u0001\u0000"+
		"\u0000\u0000wx\u0005<\u0000\u0000xy\u0005<\u0000\u0000y\u0018\u0001\u0000"+
		"\u0000\u0000z{\u0005>\u0000\u0000{|\u0005>\u0000\u0000|\u001a\u0001\u0000"+
		"\u0000\u0000}~\u0005i\u0000\u0000~\u007f\u0005s\u0000\u0000\u007f\u001c"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005n\u0000\u0000\u0081\u0082\u0005"+
		"o\u0000\u0000\u0082\u0083\u0005t\u0000\u0000\u0083\u001e\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005l\u0000\u0000\u0085\u0086\u0005t\u0000\u0000\u0086"+
		" \u0001\u0000\u0000\u0000\u0087\u0088\u0005l\u0000\u0000\u0088\u0089\u0005"+
		"t\u0000\u0000\u0089\u008a\u0005e\u0000\u0000\u008a\"\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0005g\u0000\u0000\u008c\u008d\u0005t\u0000\u0000\u008d"+
		"$\u0001\u0000\u0000\u0000\u008e\u008f\u0005g\u0000\u0000\u008f\u0090\u0005"+
		"t\u0000\u0000\u0090\u0091\u0005e\u0000\u0000\u0091&\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0005f\u0000\u0000\u0093\u0094\u0005u\u0000\u0000\u0094"+
		"\u0095\u0005n\u0000\u0000\u0095(\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"m\u0000\u0000\u0097\u0098\u0005a\u0000\u0000\u0098\u0099\u0005i\u0000"+
		"\u0000\u0099\u009a\u0005n\u0000\u0000\u009a*\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005t\u0000\u0000\u009c\u009d\u0005e\u0000\u0000\u009d\u009e\u0005"+
		"x\u0000\u0000\u009e\u009f\u0005t\u0000\u0000\u009f,\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0005t\u0000\u0000\u00a1\u00a2\u0005e\u0000\u0000\u00a2"+
		"\u00a3\u0005x\u0000\u0000\u00a3\u00a4\u0005t\u0000\u0000\u00a4\u00a5\u0005"+
		"I\u0000\u0000\u00a5\u00a6\u0005n\u0000\u0000\u00a6\u00a7\u0005I\u0000"+
		"\u0000\u00a7\u00a8\u0005n\u0000\u0000\u00a8\u00a9\u0005t\u0000\u0000\u00a9"+
		".\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005t\u0000\u0000\u00ab\u00ac\u0005"+
		"e\u0000\u0000\u00ac\u00ad\u0005x\u0000\u0000\u00ad\u00ae\u0005t\u0000"+
		"\u0000\u00ae\u00af\u0005I\u0000\u0000\u00af\u00b0\u0005n\u0000\u0000\u00b0"+
		"\u00b1\u0005S\u0000\u0000\u00b1\u00b2\u0005t\u0000\u0000\u00b2\u00b3\u0005"+
		"r\u0000\u0000\u00b30\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005i\u0000"+
		"\u0000\u00b5\u00b6\u0005f\u0000\u0000\u00b62\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0005e\u0000\u0000\u00b8\u00b9\u0005l\u0000\u0000\u00b9\u00ba\u0005"+
		"s\u0000\u0000\u00ba\u00bb\u0005e\u0000\u0000\u00bb4\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005w\u0000\u0000\u00bd\u00be\u0005h\u0000\u0000\u00be"+
		"\u00bf\u0005i\u0000\u0000\u00bf\u00c0\u0005l\u0000\u0000\u00c0\u00c1\u0005"+
		"e\u0000\u0000\u00c16\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005,\u0000"+
		"\u0000\u00c38\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005;\u0000\u0000\u00c5"+
		":\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005i\u0000\u0000\u00c7\u00c8\u0005"+
		"n\u0000\u0000\u00c8\u00c9\u0005t\u0000\u0000\u00c9<\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0005d\u0000\u0000\u00cb\u00cc\u0005o\u0000\u0000\u00cc"+
		"\u00cd\u0005u\u0000\u0000\u00cd\u00ce\u0005b\u0000\u0000\u00ce\u00cf\u0005"+
		"l\u0000\u0000\u00cf\u00d0\u0005e\u0000\u0000\u00d0>\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0005s\u0000\u0000\u00d2\u00d3\u0005t\u0000\u0000\u00d3"+
		"\u00d4\u0005r\u0000\u0000\u00d4@\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005"+
		"c\u0000\u0000\u00d6\u00d7\u0005h\u0000\u0000\u00d7\u00d8\u0005a\u0000"+
		"\u0000\u00d8\u00d9\u0005r\u0000\u0000\u00d9B\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0005b\u0000\u0000\u00db\u00dc\u0005o\u0000\u0000\u00dc\u00dd\u0005"+
		"o\u0000\u0000\u00dd\u00de\u0005l\u0000\u0000\u00deD\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005v\u0000\u0000\u00e0\u00e1\u0005o\u0000\u0000\u00e1"+
		"\u00e2\u0005i\u0000\u0000\u00e2\u00e3\u0005d\u0000\u0000\u00e3F\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0005n\u0000\u0000\u00e5\u00e6\u0005u\u0000"+
		"\u0000\u00e6\u00e7\u0005l\u0000\u0000\u00e7\u00e8\u0005l\u0000\u0000\u00e8"+
		"H\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005r\u0000\u0000\u00ea\u00eb\u0005"+
		"e\u0000\u0000\u00eb\u00ec\u0005a\u0000\u0000\u00ec\u00ed\u0005d\u0000"+
		"\u0000\u00edJ\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005@\u0000\u0000\u00ef"+
		"L\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005d\u0000\u0000\u00f1\u00f2\u0005"+
		"e\u0000\u0000\u00f2\u00f3\u0005f\u0000\u0000\u00f3\u00f4\u0005@\u0000"+
		"\u0000\u00f4N\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005w\u0000\u0000\u00f6"+
		"\u00f7\u0005r\u0000\u0000\u00f7\u00f8\u0005i\u0000\u0000\u00f8\u00f9\u0005"+
		"t\u0000\u0000\u00f9\u00fa\u0005e\u0000\u0000\u00faP\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fd\u0007\u0000\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ffR\u0001\u0000\u0000\u0000"+
		"\u0100\u0104\u0005#\u0000\u0000\u0101\u0103\t\u0000\u0000\u0000\u0102"+
		"\u0101\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105"+
		"\u0107\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0005\n\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0006)\u0000\u0000\u010aT\u0001\u0000\u0000\u0000\u010b\u010c\u0005b"+
		"\u0000\u0000\u010c\u010d\u0005r\u0000\u0000\u010d\u010e\u0005e\u0000\u0000"+
		"\u010e\u010f\u0005a\u0000\u0000\u010f\u0110\u0005k\u0000\u0000\u0110V"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0005t\u0000\u0000\u0112\u0113\u0005"+
		"r\u0000\u0000\u0113\u0114\u0005u\u0000\u0000\u0114\u0115\u0005e\u0000"+
		"\u0000\u0115X\u0001\u0000\u0000\u0000\u0116\u011a\u0007\u0001\u0000\u0000"+
		"\u0117\u0119\u0007\u0002\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000"+
		"\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011bZ\u0001\u0000\u0000\u0000\u011c"+
		"\u011a\u0001\u0000\u0000\u0000\u011d\u0123\u0005\"\u0000\u0000\u011e\u0122"+
		"\b\u0003\u0000\u0000\u011f\u0120\u0005\\\u0000\u0000\u0120\u0122\t\u0000"+
		"\u0000\u0000\u0121\u011e\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000"+
		"\u0000\u0000\u0122\u0125\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0126\u0001\u0000"+
		"\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0126\u0127\u0005\"\u0000"+
		"\u0000\u0127\\\u0001\u0000\u0000\u0000\u0128\u012a\u0005\r\u0000\u0000"+
		"\u0129\u0128\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000"+
		"\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0005\n\u0000\u0000\u012c"+
		"^\u0001\u0000\u0000\u0000\u012d\u012f\u0007\u0004\u0000\u0000\u012e\u012d"+
		"\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u012e"+
		"\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132"+
		"\u0001\u0000\u0000\u0000\u0132\u0133\u0006/\u0001\u0000\u0133`\u0001\u0000"+
		"\u0000\u0000\b\u0000\u00fe\u0104\u011a\u0121\u0123\u0129\u0130\u0002\u0000"+
		"\u0001\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}