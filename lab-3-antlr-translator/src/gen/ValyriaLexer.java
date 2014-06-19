// Generated from D:/Documents/parsers/Valyria/src\Valyria.g4 by ANTLR 4.x

import java.util.*;
import java.util.stream.*;
import java.lang.StringBuilder;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValyriaLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MODULE=1, INT=2, COMMA=3, B=4, EQ=5, AND=6, OR=7, NOT=8, PLUSMINUS=9, 
		MULDIV=10, COMP=11, NEQ=12, DOT=13, IF=14, ELSE=15, SL=16, SR=17, PL=18, 
		PR=19, NUMBER=20, RARR=21, IDENTIFIER=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"MODULE", "INT", "COMMA", "B", "EQ", "AND", "OR", "NOT", "PLUSMINUS", 
		"MULDIV", "COMP", "NEQ", "DOT", "IF", "ELSE", "SL", "SR", "PL", "PR", 
		"NUMBER", "RARR", "IDENTIFIER"
	};


	int offset;
	String packageName;
	String className;

	Map<String, String> functions;
	Map<String, List<Type>> paramTypes;
	Map<String, List<String>> paramNames;
	Map<String, Type> returnTypes;

	String fName;
	StringBuilder fBody;
	List<Type> fParams;
	List<String> fParamNames;
	Type fReturnType;

	Type lastTypeDesc;

	String getClassName() {
	    return className;
	}

	String getPackage() {
	    return packageName;
	}

	String getCode() {
	    StringBuilder sb = new StringBuilder();
	    header(sb);

	    for (Map.Entry<String, String> fun : functions.entrySet()) {
	        String name = fun.getKey();
	        List<String> params = paramNames.get(name);
	        List<Type> types = paramTypes.get(name);
	        if (name.equals("main")) {
	            if (paramNames.get("main").size() != 0) {
	                throw new RuntimeException("main function should take no arguments");
	            }
	            sb.append("    public static void main(String[] __args) throws Throwable {\n");
	        } else {
	            sb.append("    public static BigInteger ").append(name).append("(");

	            for (int i = 0; i < params.size(); i++) {
	                if (i > 0) {
	                    sb.append(", ");
	                }
	                Type t = types.get(i);
	                sb.append(t.typeId == Type.INT ? "BigInteger " : "MethodHandle ").append(params.get(i));
	            }

	            sb.append(") throws Throwable {\n");
	        }
	        sb.append(fun.getValue());
	        sb.append("    }\n");
	    }

	    offset--;
	    sb.append("}");
	    return sb.toString();
	}

	String off() {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < offset; i++) {
	        sb.append("    ");
	    }
	    return sb.toString();
	}

	void header(StringBuilder sb) {
	    offset = 0;
	    if (packageName != null && !"".equals(packageName)) {
	        sb.append("package ").append(packageName.substring(0, packageName.length() - 1)).append(";\n");
	    }

	    sb.append("import java.lang.invoke.*;\n");
	    sb.append("import java.math.BigInteger;\n");
	    sb.append("import static stdlib.Util.*;\n");
	    sb.append("import stdlib.*;\n");
	    sb.append("import java.util.*;\n\n");
	    sb.append("public class ").append(className).append("{\n");
	    offset++;
	    sb.append(off()).append("private static Map<String, MethodHandle> __functions;\n");
	    sb.append(off()).append("static {\n");
	    offset++;
	    sb.append(off()).append("__functions = new HashMap<>();\n");
	    sb.append(off())
	        .append("MethodHandles.Lookup __lookup = MethodHandles.lookup();\n")
	        .append(off())
	        .append("try {\n");

	    offset++;

	    sb.append(off()).append("__functions.put(\"print\", ")
	        .append("__lookup.findStatic(Util.class, \"print\", MethodType.methodType(BigInteger.class, Object.class)));\n")
	        .append(off()).append("__functions.put(\"read\", ")
	        .append("__lookup.findStatic(Util.class, \"read\", MethodType.methodType(BigInteger.class)));\n");

	    for (String name : functions.keySet()) {
	        if (name.equals("main")) {
	            continue;
	        }
	        List<Type> params = paramTypes.get(name);
	        String lookupType = params.stream()
	            .map(t -> t.typeId == Type.INT ? "BigInteger.class" : "MethodHandle.class")
	            .collect(Collectors.joining(", "));

	        sb.append(off()).append("__functions.put(\"").append(name).append("\", ");

	        sb.append("__lookup.findStatic(")
	            .append(className)
	            .append(".class, \"")
	            .append(name)
	            .append("\", MethodType.methodType(")
	            .append("BigInteger.class, ")
	            .append(lookupType)
	            .append(")));\n");
	    }
	    offset--;
	    sb.append(off()).append("} catch (Exception e) { throw new AssertionError(); }\n");
	    offset--;
	    sb.append(off()).append("}\n");
	}

	void init() {
	    functions = new HashMap<>();
	    paramTypes = new HashMap<>();
	    List<Type> specialParams = new ArrayList<>();
	    specialParams.add(Type.integer());
	    paramTypes.put("print", specialParams);
	    paramTypes.put("read", new ArrayList<>());
	    
	    paramNames = new HashMap<>();
	    List<String> specialParamNames = new ArrayList<>();
	    specialParamNames.add("o");
	    paramNames.put("print", specialParamNames);
	    paramNames.put("read", new ArrayList<>());
	    
	    returnTypes = new HashMap<>();
	    returnTypes.put("print", Type.integer());
	    returnTypes.put("read", Type.integer());
	    
	    offset = 1;
	}

	String muldiv(String text) {
	    switch(text) {
	        case "*":
	            return "multiply";
	        case "/":
	            return "divide";
	        case "%":
	            return "mod";
	    }
	    throw new AssertionError();
	}


	public ValyriaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Valyria.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 11: NEQ_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void NEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  setText("!=");  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fV"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6\25p\n\25\r\25\16"+
		"\25q\3\26\3\26\3\26\3\27\3\27\7\27y\n\27\f\27\16\27|\13\27\2\2\30\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30\3\2\t\5\2\13\f\17\17\"\"\4\2--//\5\2\'\'"+
		",,\61\61\4\2>>@@\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\u0081\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\66\3\2\2\2"+
		"\7:\3\2\2\2\t<\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17E\3\2\2\2\21H\3\2\2\2"+
		"\23J\3\2\2\2\25L\3\2\2\2\27U\3\2\2\2\31W\3\2\2\2\33\\\3\2\2\2\35^\3\2"+
		"\2\2\37a\3\2\2\2!f\3\2\2\2#h\3\2\2\2%j\3\2\2\2\'l\3\2\2\2)o\3\2\2\2+s"+
		"\3\2\2\2-v\3\2\2\2/\60\7o\2\2\60\61\7q\2\2\61\62\7f\2\2\62\63\7w\2\2\63"+
		"\64\7n\2\2\64\65\7g\2\2\65\4\3\2\2\2\66\67\7K\2\2\678\7p\2\289\7v\2\2"+
		"9\6\3\2\2\2:;\7.\2\2;\b\3\2\2\2<=\t\2\2\2=>\3\2\2\2>?\b\5\2\2?\n\3\2\2"+
		"\2@A\7?\2\2A\f\3\2\2\2BC\7(\2\2CD\7(\2\2D\16\3\2\2\2EF\7~\2\2FG\7~\2\2"+
		"G\20\3\2\2\2HI\7#\2\2I\22\3\2\2\2JK\t\3\2\2K\24\3\2\2\2LM\t\4\2\2M\26"+
		"\3\2\2\2NO\7@\2\2OV\7?\2\2PQ\7>\2\2QV\7?\2\2RV\t\5\2\2ST\7?\2\2TV\7?\2"+
		"\2UN\3\2\2\2UP\3\2\2\2UR\3\2\2\2US\3\2\2\2V\30\3\2\2\2WX\7\61\2\2XY\7"+
		"?\2\2YZ\3\2\2\2Z[\b\r\3\2[\32\3\2\2\2\\]\7\60\2\2]\34\3\2\2\2^_\7k\2\2"+
		"_`\7h\2\2`\36\3\2\2\2ab\7g\2\2bc\7n\2\2cd\7u\2\2de\7g\2\2e \3\2\2\2fg"+
		"\7]\2\2g\"\3\2\2\2hi\7_\2\2i$\3\2\2\2jk\7*\2\2k&\3\2\2\2lm\7+\2\2m(\3"+
		"\2\2\2np\t\6\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r*\3\2\2\2st\7"+
		"/\2\2tu\7@\2\2u,\3\2\2\2vz\t\7\2\2wy\t\b\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{.\3\2\2\2|z\3\2\2\2\6\2Uqz\4\b\2\2\3\r\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}