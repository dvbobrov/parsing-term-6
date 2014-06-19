// Generated from D:/Documents/parsers/ll1generator\Antlr.g4 by ANTLR 4.x

    import grammar.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHATEVER=1, GRAMMAR=2, B=3, COLON=4, RARR=5, SKIP=6, SEMICOLON=7, DOT=8, 
		VLINE=9, LBRACE=10, RBRACE=11, SL=12, SR=13, LT=14, GT=15, QM=16, JTypeBound=17, 
		COMMA=18, JPrimitiveType=19, TERMNAME=20, NONTERMNAME=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'"
	};
	public static final String[] ruleNames = {
		"WHATEVER", "GRAMMAR", "B", "COLON", "RARR", "SKIP", "SEMICOLON", "DOT", 
		"VLINE", "LBRACE", "RBRACE", "SL", "SR", "LT", "GT", "QM", "JTypeBound", 
		"COMMA", "JPrimitiveType", "TERMNAME", "NONTERMNAME"
	};


	    private Grammar grammar;
	    private String gName;

	    private void init() {
	        grammar = new Grammar();
	    }

	    public Grammar getGrammar() {
	        return grammar;
	    }

	    public String getGName() {
	        return gName;
	    }


	public AntlrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Antlr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\6\2\60\n\2\r\2\16"+
		"\2\61\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22l\n\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0096\n\24\3\25\3\25"+
		"\7\25\u009a\n\25\f\25\16\25\u009d\13\25\3\26\3\26\7\26\u00a1\n\26\f\26"+
		"\16\26\u00a4\13\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\7\3\2%%\5"+
		"\2\13\f\17\17\"\"\3\2C\\\6\2\62;C\\aac|\3\2c|\u00af\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\65\3\2\2\2\7=\3\2\2\2\tA\3"+
		"\2\2\2\13C\3\2\2\2\rF\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25Q"+
		"\3\2\2\2\27S\3\2\2\2\31U\3\2\2\2\33W\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!"+
		"]\3\2\2\2#k\3\2\2\2%m\3\2\2\2\'\u0095\3\2\2\2)\u0097\3\2\2\2+\u009e\3"+
		"\2\2\2-/\7%\2\2.\60\n\2\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62"+
		"\3\2\2\2\62\63\3\2\2\2\63\64\7%\2\2\64\4\3\2\2\2\65\66\7i\2\2\66\67\7"+
		"t\2\2\678\7c\2\289\7o\2\29:\7o\2\2:;\7c\2\2;<\7t\2\2<\6\3\2\2\2=>\t\3"+
		"\2\2>?\3\2\2\2?@\b\4\2\2@\b\3\2\2\2AB\7<\2\2B\n\3\2\2\2CD\7/\2\2DE\7@"+
		"\2\2E\f\3\2\2\2FG\7u\2\2GH\7m\2\2HI\7k\2\2IJ\7r\2\2J\16\3\2\2\2KL\7=\2"+
		"\2L\20\3\2\2\2MN\7\60\2\2N\22\3\2\2\2OP\7~\2\2P\24\3\2\2\2QR\7}\2\2R\26"+
		"\3\2\2\2ST\7\177\2\2T\30\3\2\2\2UV\7]\2\2V\32\3\2\2\2WX\7_\2\2X\34\3\2"+
		"\2\2YZ\7>\2\2Z\36\3\2\2\2[\\\7@\2\2\\ \3\2\2\2]^\7A\2\2^\"\3\2\2\2_`\7"+
		"g\2\2`a\7z\2\2ab\7v\2\2bc\7g\2\2cd\7p\2\2de\7f\2\2el\7u\2\2fg\7u\2\2g"+
		"h\7w\2\2hi\7r\2\2ij\7g\2\2jl\7t\2\2k_\3\2\2\2kf\3\2\2\2l$\3\2\2\2mn\7"+
		".\2\2n&\3\2\2\2op\7d\2\2pq\7q\2\2qr\7q\2\2rs\7n\2\2st\7g\2\2tu\7c\2\2"+
		"u\u0096\7p\2\2vw\7e\2\2wx\7j\2\2xy\7c\2\2y\u0096\7t\2\2z{\7d\2\2{|\7{"+
		"\2\2|}\7v\2\2}\u0096\7g\2\2~\177\7u\2\2\177\u0080\7j\2\2\u0080\u0081\7"+
		"q\2\2\u0081\u0082\7t\2\2\u0082\u0096\7v\2\2\u0083\u0084\7k\2\2\u0084\u0085"+
		"\7p\2\2\u0085\u0096\7v\2\2\u0086\u0087\7n\2\2\u0087\u0088\7q\2\2\u0088"+
		"\u0089\7p\2\2\u0089\u0096\7i\2\2\u008a\u008b\7h\2\2\u008b\u008c\7n\2\2"+
		"\u008c\u008d\7q\2\2\u008d\u008e\7c\2\2\u008e\u0096\7v\2\2\u008f\u0090"+
		"\7f\2\2\u0090\u0091\7q\2\2\u0091\u0092\7w\2\2\u0092\u0093\7d\2\2\u0093"+
		"\u0094\7n\2\2\u0094\u0096\7g\2\2\u0095o\3\2\2\2\u0095v\3\2\2\2\u0095z"+
		"\3\2\2\2\u0095~\3\2\2\2\u0095\u0083\3\2\2\2\u0095\u0086\3\2\2\2\u0095"+
		"\u008a\3\2\2\2\u0095\u008f\3\2\2\2\u0096(\3\2\2\2\u0097\u009b\t\4\2\2"+
		"\u0098\u009a\t\5\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c*\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a2\t\6\2\2\u009f\u00a1\t\5\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3,\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\b\2\61k\u0095\u009b\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}