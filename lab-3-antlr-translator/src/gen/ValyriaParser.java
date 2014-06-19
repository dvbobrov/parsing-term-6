// Generated from D:/Documents/parsers/Valyria/src\Valyria.g4 by ANTLR 4.x

import java.util.*;
import java.util.stream.*;
import java.lang.StringBuilder;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValyriaParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MODULE=1, INT=2, COMMA=3, B=4, EQ=5, AND=6, OR=7, NOT=8, PLUSMINUS=9, 
		MULDIV=10, COMP=11, NEQ=12, DOT=13, IF=14, ELSE=15, SL=16, SR=17, PL=18, 
		PR=19, NUMBER=20, RARR=21, IDENTIFIER=22;
	public static final String[] tokenNames = {
		"<INVALID>", "'module'", "'Int'", "','", "B", "'='", "'&&'", "'||'", "'!'", 
		"PLUSMINUS", "MULDIV", "COMP", "'/='", "'.'", "'if'", "'else'", "'['", 
		"']'", "'('", "')'", "NUMBER", "'->'", "IDENTIFIER"
	};
	public static final int
		RULE_program = 0, RULE_functionList = 1, RULE_function = 2, RULE_typeDesc = 3, 
		RULE_pType = 4, RULE_rType = 5, RULE_paramsList = 6, RULE_expr = 7, RULE_funCall = 8, 
		RULE_boolExpr = 9, RULE_conjunction = 10, RULE_neg = 11, RULE_compExpr = 12, 
		RULE_arithExpr = 13, RULE_mul = 14, RULE_factor = 15, RULE_callParams = 16, 
		RULE_callParam = 17, RULE_qualifiedName = 18, RULE_packageName = 19, RULE_comp = 20;
	public static final String[] ruleNames = {
		"program", "functionList", "function", "typeDesc", "pType", "rType", "paramsList", 
		"expr", "funCall", "boolExpr", "conjunction", "neg", "compExpr", "arithExpr", 
		"mul", "factor", "callParams", "callParam", "qualifiedName", "packageName", 
		"comp"
	};

	@Override
	public String getGrammarFileName() { return "Valyria.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public ValyriaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(ValyriaParser.MODULE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public FunctionListContext functionList() {
			return getRuleContext(FunctionListContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{

			    init();

			setState(43); match(MODULE);
			setState(44); qualifiedName();
			setState(45); functionList();
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

	public static class FunctionListContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public FunctionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterFunctionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitFunctionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitFunctionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionListContext functionList() throws RecognitionException {
		FunctionListContext _localctx = new FunctionListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PL) {
				{
				{
				setState(47); function();
				}
				}
				setState(52);
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

	public static class FunctionContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamsListContext paramsList() {
			return getRuleContext(ParamsListContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ValyriaParser.IDENTIFIER, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ValyriaParser.EQ, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); typeDesc();

			    fParams = lastTypeDesc.getParams();
			    fReturnType = lastTypeDesc.getReturnType();

			setState(55); ((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);

			    fName = (((FunctionContext)_localctx).IDENTIFIER!=null?((FunctionContext)_localctx).IDENTIFIER.getText():null);
			    fBody = new StringBuilder();
			    fParamNames = new ArrayList<String>();

			setState(57); paramsList();

			    if (fParams.size() != fParamNames.size()) {
			        throw new RuntimeException("Parameters and signature for function " + fName + " do not match");
			    }

			    paramTypes.put(fName, fParams);
			    paramNames.put(fName, fParamNames);
			    offset++;
			    fBody.append(off()).append("BigInteger __res;\n");

			setState(59); match(EQ);
			setState(60); expr(false);

			    if (!(((FunctionContext)_localctx).IDENTIFIER!=null?((FunctionContext)_localctx).IDENTIFIER.getText():null).equals("main")) {
			        fBody.append(off()).append("return __res;\n");
			    }
			    functions.put(fName, fBody.toString());
			    offset--;

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

	public static class TypeDescContext extends ParserRuleContext {
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public List<PTypeContext> pType() {
			return getRuleContexts(PTypeContext.class);
		}
		public TerminalNode RARR() { return getToken(ValyriaParser.RARR, 0); }
		public PTypeContext pType(int i) {
			return getRuleContext(PTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValyriaParser.COMMA); }
		public TerminalNode PL() { return getToken(ValyriaParser.PL, 0); }
		public TerminalNode PR() { return getToken(ValyriaParser.PR, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(ValyriaParser.COMMA, i);
		}
		public TypeDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDesc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterTypeDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitTypeDesc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitTypeDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescContext typeDesc() throws RecognitionException {
		TypeDescContext _localctx = new TypeDescContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDesc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			    List<Type> paramList = new ArrayList<>();
			    Type[] returnType = new Type[1];

			setState(64); match(PL);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==PL) {
				{
				{
				setState(65); pType(paramList);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(66); match(COMMA);
					setState(67); pType(paramList);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78); match(PR);
			setState(79); match(RARR);
			setState(80); rType(returnType);

			    if (returnType[0] == null) {
			        throw new AssertionError();
			    }
			    lastTypeDesc = Type.function(returnType[0], paramList);

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

	public static class PTypeContext extends ParserRuleContext {
		public List<Type> paramList;
		public TerminalNode INT() { return getToken(ValyriaParser.INT, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public TerminalNode PL() { return getToken(ValyriaParser.PL, 0); }
		public TerminalNode PR() { return getToken(ValyriaParser.PR, 0); }
		public PTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PTypeContext(ParserRuleContext parent, int invokingState, List<Type> paramList) {
			super(parent, invokingState);
			this.paramList = paramList;
		}
		@Override public int getRuleIndex() { return RULE_pType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterPType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitPType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitPType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PTypeContext pType(List<Type> paramList) throws RecognitionException {
		PTypeContext _localctx = new PTypeContext(_ctx, getState(), paramList);
		enterRule(_localctx, 8, RULE_pType);
		try {
			setState(90);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(83); match(INT);
				 paramList.add(Type.integer()); 
				}
				break;
			case PL:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); match(PL);
				setState(86); typeDesc();
				 paramList.add(lastTypeDesc); 
				setState(88); match(PR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RTypeContext extends ParserRuleContext {
		public Type[] returnType;
		public TerminalNode INT() { return getToken(ValyriaParser.INT, 0); }
		public RTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RTypeContext(ParserRuleContext parent, int invokingState, Type[] returnType) {
			super(parent, invokingState);
			this.returnType = returnType;
		}
		@Override public int getRuleIndex() { return RULE_rType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterRType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitRType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitRType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RTypeContext rType(Type[] returnType) throws RecognitionException {
		RTypeContext _localctx = new RTypeContext(_ctx, getState(), returnType);
		enterRule(_localctx, 10, RULE_rType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(INT);
			 returnType[0] = Type.integer(); 
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

	public static class ParamsListContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ValyriaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ValyriaParser.IDENTIFIER); }
		public ParamsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterParamsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitParamsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitParamsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsListContext paramsList() throws RecognitionException {
		ParamsListContext _localctx = new ParamsListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paramsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(95); ((ParamsListContext)_localctx).IDENTIFIER = match(IDENTIFIER);

				    fParamNames.add((((ParamsListContext)_localctx).IDENTIFIER!=null?((ParamsListContext)_localctx).IDENTIFIER.getText():null));

				}
				}
				setState(101);
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

	public static class ExprContext extends ParserRuleContext {
		public boolean in;
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode IF() { return getToken(ValyriaParser.IF, 0); }
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ValyriaParser.ELSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode SR() { return getToken(ValyriaParser.SR, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PL() { return getToken(ValyriaParser.PL, 0); }
		public TerminalNode PR() { return getToken(ValyriaParser.PR, 0); }
		public TerminalNode SL() { return getToken(ValyriaParser.SL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, boolean in) {
			super(parent, invokingState);
			this.in = in;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(boolean in) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), in);
		enterRule(_localctx, 14, RULE_expr);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102); match(SL);

				    if (!in) {
				        fBody.append(off()).append("__res = ");
				    }

				setState(104); funCall();

				    if (!in) {
				        fBody.append(";\n");
				    }

				setState(106); match(SR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108); match(IF);

				    fBody.append(off()).append("if (!");

				setState(110); match(PL);
				setState(111); expr(true);

				    fBody.append(".equals(BigInteger.ZERO)) {\n");
				    offset++;

				setState(113); match(PR);
				setState(114); expr(in);

				    offset--;
				    fBody.append(off()).append("} else {\n");
				    offset++;

				setState(116); match(ELSE);
				setState(117); expr(in);

				    offset--;
				    fBody.append(off()).append("}\n");

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{

				    if (!in) {
				        fBody.append(off()).append("__res = ");
				    }

				setState(121); boolExpr();

				    if (!in) {
				        fBody.append(";\n");
				    }

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

	public static class FunCallContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public CallParamsContext callParams() {
			return getRuleContext(CallParamsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ValyriaParser.IDENTIFIER, 0); }
		public FunCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterFunCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitFunCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunCallContext funCall() throws RecognitionException {
		FunCallContext _localctx = new FunCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); ((FunCallContext)_localctx).IDENTIFIER = match(IDENTIFIER);

			    if ((((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null).equals("main")) {
			        throw new RuntimeException("can't call main");
			    }
			    
			    int paramNumber = fParamNames.indexOf((((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null));
			    
			    if (paramNumber != -1) {
			        fBody.append("((BigInteger)").append((((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null)).append(".invokeExact(");
			    } else if (paramTypes.containsKey((((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null))) {
			        fBody.append((((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null)).append("(");
			    } else {
			        throw new RuntimeException("Can't find function " + (((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null));
			    }
			    
			    List<Type> cParamTypes = new ArrayList<>();

			setState(129);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SL) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(128); callParams(cParamTypes);
				}
			}


			    if (paramNumber != -1) {
			        fBody.append("))");
			        if (!fParams.get(paramNumber).equals(Type.function(Type.integer(), cParamTypes))) {
			            throw new RuntimeException("Parameter types for function parameter " 
			            + (((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null) + " inside function " + fName + " definition mismatch");                                                                  
			        }
			    } else {
			        fBody.append(")");
			        if (!Type.function(Type.integer(), paramTypes.get((((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null))).equals(Type.function(Type.integer(), cParamTypes))) {
			            throw new RuntimeException("Parameter types for function parameter " 
			            + (((FunCallContext)_localctx).IDENTIFIER!=null?((FunCallContext)_localctx).IDENTIFIER.getText():null) + " inside function " + fName + " definition mismatch");                                                                  
			        }
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

	public static class BoolExprContext extends ParserRuleContext {
		public List<TerminalNode> OR() { return getTokens(ValyriaParser.OR); }
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public TerminalNode OR(int i) {
			return getToken(ValyriaParser.OR, i);
		}
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boolExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); conjunction();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(134); match(OR);

				    fBody.append(".or(");

				setState(136); conjunction();

				    fBody.append(")");

				}
				}
				setState(143);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<TerminalNode> AND() { return getTokens(ValyriaParser.AND); }
		public NegContext neg(int i) {
			return getRuleContext(NegContext.class,i);
		}
		public List<NegContext> neg() {
			return getRuleContexts(NegContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(ValyriaParser.AND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); neg();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(145); match(AND);

				    fBody.append(".and(");

				setState(147); neg();

				    fBody.append(")");

				}
				}
				setState(154);
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

	public static class NegContext extends ParserRuleContext {
		public CompExprContext compExpr() {
			return getRuleContext(CompExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ValyriaParser.NOT, 0); }
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_neg);
		try {
			setState(161);
			switch (_input.LA(1)) {
			case SL:
			case PL:
			case NUMBER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); compExpr();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); match(NOT);

				    fBody.append("__not(");

				setState(158); compExpr();

				    fBody.append(")");

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CompExprContext extends ParserRuleContext {
		public CompContext comp;
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public CompExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompExprContext compExpr() throws RecognitionException {
		CompExprContext _localctx = new CompExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_compExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			    fBody.append("(");
			    String compType = null;

			setState(164); arithExpr();
			setState(170);
			_la = _input.LA(1);
			if (_la==COMP || _la==NEQ) {
				{
				setState(165); ((CompExprContext)_localctx).comp = comp();

				    fBody.append(".compareTo(");

				setState(167); arithExpr();

				    fBody.append(") ");
				    fBody.append((((CompExprContext)_localctx).comp!=null?_input.getText(((CompExprContext)_localctx).comp.start,((CompExprContext)_localctx).comp.stop):null)).append(" 0 ? BigInteger.ONE : BigInteger.ZERO");

				}
			}


			    fBody.append(")");

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

	public static class ArithExprContext extends ParserRuleContext {
		public Token PLUSMINUS;
		public List<TerminalNode> PLUSMINUS() { return getTokens(ValyriaParser.PLUSMINUS); }
		public List<MulContext> mul() {
			return getRuleContexts(MulContext.class);
		}
		public TerminalNode PLUSMINUS(int i) {
			return getToken(ValyriaParser.PLUSMINUS, i);
		}
		public MulContext mul(int i) {
			return getRuleContext(MulContext.class,i);
		}
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		ArithExprContext _localctx = new ArithExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); mul();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUSMINUS) {
				{
				{
				setState(175); ((ArithExprContext)_localctx).PLUSMINUS = match(PLUSMINUS);

				    switch ((((ArithExprContext)_localctx).PLUSMINUS!=null?((ArithExprContext)_localctx).PLUSMINUS.getText():null)) {
				        case "+":
				            fBody.append(".add(");
				            break;
				        case "-":
				            fBody.append(".subtract(");
				            break;
				    }

				setState(177); mul();

				    fBody.append(")");

				}
				}
				setState(184);
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

	public static class MulContext extends ParserRuleContext {
		public Token MULDIV;
		public TerminalNode MULDIV(int i) {
			return getToken(ValyriaParser.MULDIV, i);
		}
		public List<TerminalNode> MULDIV() { return getTokens(ValyriaParser.MULDIV); }
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		MulContext _localctx = new MulContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); factor();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULDIV) {
				{
				{
				setState(186); ((MulContext)_localctx).MULDIV = match(MULDIV);

				    fBody.append(".").append(muldiv((((MulContext)_localctx).MULDIV!=null?((MulContext)_localctx).MULDIV.getText():null))).append("(");

				setState(188); factor();

				    fBody.append(")");

				}
				}
				setState(195);
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

	public static class FactorContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public Token NUMBER;
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SR() { return getToken(ValyriaParser.SR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ValyriaParser.IDENTIFIER, 0); }
		public TerminalNode PL() { return getToken(ValyriaParser.PL, 0); }
		public TerminalNode PR() { return getToken(ValyriaParser.PR, 0); }
		public TerminalNode SL() { return getToken(ValyriaParser.SL, 0); }
		public TerminalNode NUMBER() { return getToken(ValyriaParser.NUMBER, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_factor);
		try {
			setState(208);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(196); ((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);

				    fBody.append((((FactorContext)_localctx).IDENTIFIER!=null?((FactorContext)_localctx).IDENTIFIER.getText():null));

				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(198); ((FactorContext)_localctx).NUMBER = match(NUMBER);

				    fBody.append("new BigInteger(\"").append((((FactorContext)_localctx).NUMBER!=null?((FactorContext)_localctx).NUMBER.getText():null)).append("\")");

				}
				break;
			case SL:
				enterOuterAlt(_localctx, 3);
				{
				setState(200); match(SL);
				setState(201); funCall();
				setState(202); match(SR);
				}
				break;
			case PL:
				enterOuterAlt(_localctx, 4);
				{
				setState(204); match(PL);
				setState(205); expr(true);
				setState(206); match(PR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CallParamsContext extends ParserRuleContext {
		public List<Type> cParamTypes;
		public CallParamContext callParam(int i) {
			return getRuleContext(CallParamContext.class,i);
		}
		public List<CallParamContext> callParam() {
			return getRuleContexts(CallParamContext.class);
		}
		public CallParamsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CallParamsContext(ParserRuleContext parent, int invokingState, List<Type> cParamTypes) {
			super(parent, invokingState);
			this.cParamTypes = cParamTypes;
		}
		@Override public int getRuleIndex() { return RULE_callParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterCallParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitCallParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitCallParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallParamsContext callParams(List<Type> cParamTypes) throws RecognitionException {
		CallParamsContext _localctx = new CallParamsContext(_ctx, getState(), cParamTypes);
		enterRule(_localctx, 32, RULE_callParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); callParam(cParamTypes);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SL) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				{

				    fBody.append(", ");

				setState(212); callParam(cParamTypes);
				}
				}
				setState(217);
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

	public static class CallParamContext extends ParserRuleContext {
		public List<Type> cParamTypes;
		public Token NUMBER;
		public Token IDENTIFIER;
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public TerminalNode SR() { return getToken(ValyriaParser.SR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ValyriaParser.IDENTIFIER, 0); }
		public TerminalNode SL() { return getToken(ValyriaParser.SL, 0); }
		public TerminalNode NUMBER() { return getToken(ValyriaParser.NUMBER, 0); }
		public CallParamContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CallParamContext(ParserRuleContext parent, int invokingState, List<Type> cParamTypes) {
			super(parent, invokingState);
			this.cParamTypes = cParamTypes;
		}
		@Override public int getRuleIndex() { return RULE_callParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterCallParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitCallParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitCallParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallParamContext callParam(List<Type> cParamTypes) throws RecognitionException {
		CallParamContext _localctx = new CallParamContext(_ctx, getState(), cParamTypes);
		enterRule(_localctx, 34, RULE_callParam);
		try {
			setState(227);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(218); ((CallParamContext)_localctx).NUMBER = match(NUMBER);

				    fBody.append("new BigInteger(\"").append((((CallParamContext)_localctx).NUMBER!=null?((CallParamContext)_localctx).NUMBER.getText():null)).append("\")");
				    cParamTypes.add(Type.integer());

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); ((CallParamContext)_localctx).IDENTIFIER = match(IDENTIFIER);

				    int argNum = fParamNames.indexOf((((CallParamContext)_localctx).IDENTIFIER!=null?((CallParamContext)_localctx).IDENTIFIER.getText():null));
				    if (argNum != -1) {
				        fBody.append((((CallParamContext)_localctx).IDENTIFIER!=null?((CallParamContext)_localctx).IDENTIFIER.getText():null));
				        Type type = fParams.get(argNum);
				        cParamTypes.add(type);
				    } else if (paramTypes.containsKey((((CallParamContext)_localctx).IDENTIFIER!=null?((CallParamContext)_localctx).IDENTIFIER.getText():null))) {
				        fBody.append("__functions.get(\"").append((((CallParamContext)_localctx).IDENTIFIER!=null?((CallParamContext)_localctx).IDENTIFIER.getText():null)).append("\")");
				        cParamTypes.add(Type.function(Type.integer(), paramTypes.get((((CallParamContext)_localctx).IDENTIFIER!=null?((CallParamContext)_localctx).IDENTIFIER.getText():null))));
				    } else {
				        throw new RuntimeException("Can't find function " + (((CallParamContext)_localctx).IDENTIFIER!=null?((CallParamContext)_localctx).IDENTIFIER.getText():null));    
				    }

				}
				break;
			case SL:
				enterOuterAlt(_localctx, 3);
				{
				setState(222); match(SL);
				setState(223); funCall();

				    cParamTypes.add(Type.integer());

				setState(225); match(SR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public PackageNameContext packageName;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(ValyriaParser.IDENTIFIER, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_qualifiedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); ((QualifiedNameContext)_localctx).packageName = packageName();

			    packageName = (((QualifiedNameContext)_localctx).packageName!=null?_input.getText(((QualifiedNameContext)_localctx).packageName.start,((QualifiedNameContext)_localctx).packageName.stop):null);

			setState(231); ((QualifiedNameContext)_localctx).IDENTIFIER = match(IDENTIFIER);

			    className = (((QualifiedNameContext)_localctx).IDENTIFIER!=null?((QualifiedNameContext)_localctx).IDENTIFIER.getText():null);

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

	public static class PackageNameContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(ValyriaParser.DOT); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ValyriaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ValyriaParser.IDENTIFIER); }
		public TerminalNode DOT(int i) {
			return getToken(ValyriaParser.DOT, i);
		}
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitPackageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitPackageName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		PackageNameContext _localctx = new PackageNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_packageName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(234); match(IDENTIFIER);
					setState(235); match(DOT);
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class CompContext extends ParserRuleContext {
		public TerminalNode NEQ() { return getToken(ValyriaParser.NEQ, 0); }
		public TerminalNode COMP() { return getToken(ValyriaParser.COMP, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValyriaListener ) ((ValyriaListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValyriaVisitor ) return ((ValyriaVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==COMP || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00f6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\3\7\3\63"+
		"\n\3\f\3\16\3\66\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\7\5G\n\5\f\5\16\5J\13\5\7\5L\n\5\f\5\16\5O\13\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\3\b\3\b\7"+
		"\bd\n\b\f\b\16\bg\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t\3\n\3\n\3\n\5\n\u0084"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008e\n\13\f\13\16\13"+
		"\u0091\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0099\n\f\f\f\16\f\u009c\13\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a4\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00ad\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00b7"+
		"\n\17\f\17\16\17\u00ba\13\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00c2"+
		"\n\20\f\20\16\20\u00c5\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u00d3\n\21\3\22\3\22\3\22\7\22\u00d8\n\22\f\22"+
		"\16\22\u00db\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e6"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u00ef\n\25\f\25\16\25\u00f2"+
		"\13\25\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*\2\3\3\2\r\16\u00f5\2,\3\2\2\2\4\64\3\2\2\2\6\67\3\2\2\2\bA\3\2\2"+
		"\2\n\\\3\2\2\2\f^\3\2\2\2\16e\3\2\2\2\20~\3\2\2\2\22\u0080\3\2\2\2\24"+
		"\u0087\3\2\2\2\26\u0092\3\2\2\2\30\u00a3\3\2\2\2\32\u00a5\3\2\2\2\34\u00b0"+
		"\3\2\2\2\36\u00bb\3\2\2\2 \u00d2\3\2\2\2\"\u00d4\3\2\2\2$\u00e5\3\2\2"+
		"\2&\u00e7\3\2\2\2(\u00f0\3\2\2\2*\u00f3\3\2\2\2,-\b\2\1\2-.\7\3\2\2./"+
		"\5&\24\2/\60\5\4\3\2\60\3\3\2\2\2\61\63\5\6\4\2\62\61\3\2\2\2\63\66\3"+
		"\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\5\3\2\2\2\66\64\3\2\2\2\678\5\b"+
		"\5\289\b\4\1\29:\7\30\2\2:;\b\4\1\2;<\5\16\b\2<=\b\4\1\2=>\7\7\2\2>?\5"+
		"\20\t\2?@\b\4\1\2@\7\3\2\2\2AB\b\5\1\2BM\7\24\2\2CH\5\n\6\2DE\7\5\2\2"+
		"EG\5\n\6\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JH\3\2\2\2"+
		"KC\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\25\2"+
		"\2QR\7\27\2\2RS\5\f\7\2ST\b\5\1\2T\t\3\2\2\2UV\7\4\2\2V]\b\6\1\2WX\7\24"+
		"\2\2XY\5\b\5\2YZ\b\6\1\2Z[\7\25\2\2[]\3\2\2\2\\U\3\2\2\2\\W\3\2\2\2]\13"+
		"\3\2\2\2^_\7\4\2\2_`\b\7\1\2`\r\3\2\2\2ab\7\30\2\2bd\b\b\1\2ca\3\2\2\2"+
		"dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\17\3\2\2\2ge\3\2\2\2hi\7\22\2\2ij\b\t"+
		"\1\2jk\5\22\n\2kl\b\t\1\2lm\7\23\2\2m\177\3\2\2\2no\7\20\2\2op\b\t\1\2"+
		"pq\7\24\2\2qr\5\20\t\2rs\b\t\1\2st\7\25\2\2tu\5\20\t\2uv\b\t\1\2vw\7\21"+
		"\2\2wx\5\20\t\2xy\b\t\1\2y\177\3\2\2\2z{\b\t\1\2{|\5\24\13\2|}\b\t\1\2"+
		"}\177\3\2\2\2~h\3\2\2\2~n\3\2\2\2~z\3\2\2\2\177\21\3\2\2\2\u0080\u0081"+
		"\7\30\2\2\u0081\u0083\b\n\1\2\u0082\u0084\5\"\22\2\u0083\u0082\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\n\1\2\u0086\23"+
		"\3\2\2\2\u0087\u008f\5\26\f\2\u0088\u0089\7\t\2\2\u0089\u008a\b\13\1\2"+
		"\u008a\u008b\5\26\f\2\u008b\u008c\b\13\1\2\u008c\u008e\3\2\2\2\u008d\u0088"+
		"\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\25\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u009a\5\30\r\2\u0093\u0094\7\b\2"+
		"\2\u0094\u0095\b\f\1\2\u0095\u0096\5\30\r\2\u0096\u0097\b\f\1\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0093\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\27\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a4"+
		"\5\32\16\2\u009e\u009f\7\n\2\2\u009f\u00a0\b\r\1\2\u00a0\u00a1\5\32\16"+
		"\2\u00a1\u00a2\b\r\1\2\u00a2\u00a4\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u009e"+
		"\3\2\2\2\u00a4\31\3\2\2\2\u00a5\u00a6\b\16\1\2\u00a6\u00ac\5\34\17\2\u00a7"+
		"\u00a8\5*\26\2\u00a8\u00a9\b\16\1\2\u00a9\u00aa\5\34\17\2\u00aa\u00ab"+
		"\b\16\1\2\u00ab\u00ad\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ac\u00ad\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\16\1\2\u00af\33\3\2\2\2\u00b0\u00b8"+
		"\5\36\20\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\b\17\1\2\u00b3\u00b4\5\36"+
		"\20\2\u00b4\u00b5\b\17\1\2\u00b5\u00b7\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\35\3\2\2"+
		"\2\u00ba\u00b8\3\2\2\2\u00bb\u00c3\5 \21\2\u00bc\u00bd\7\f\2\2\u00bd\u00be"+
		"\b\20\1\2\u00be\u00bf\5 \21\2\u00bf\u00c0\b\20\1\2\u00c0\u00c2\3\2\2\2"+
		"\u00c1\u00bc\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\37\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\30\2\2\u00c7"+
		"\u00d3\b\21\1\2\u00c8\u00c9\7\26\2\2\u00c9\u00d3\b\21\1\2\u00ca\u00cb"+
		"\7\22\2\2\u00cb\u00cc\5\22\n\2\u00cc\u00cd\7\23\2\2\u00cd\u00d3\3\2\2"+
		"\2\u00ce\u00cf\7\24\2\2\u00cf\u00d0\5\20\t\2\u00d0\u00d1\7\25\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00c8\3\2\2\2\u00d2\u00ca\3\2"+
		"\2\2\u00d2\u00ce\3\2\2\2\u00d3!\3\2\2\2\u00d4\u00d9\5$\23\2\u00d5\u00d6"+
		"\b\22\1\2\u00d6\u00d8\5$\23\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2"+
		"\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da#\3\2\2\2\u00db\u00d9\3"+
		"\2\2\2\u00dc\u00dd\7\26\2\2\u00dd\u00e6\b\23\1\2\u00de\u00df\7\30\2\2"+
		"\u00df\u00e6\b\23\1\2\u00e0\u00e1\7\22\2\2\u00e1\u00e2\5\22\n\2\u00e2"+
		"\u00e3\b\23\1\2\u00e3\u00e4\7\23\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00dc\3"+
		"\2\2\2\u00e5\u00de\3\2\2\2\u00e5\u00e0\3\2\2\2\u00e6%\3\2\2\2\u00e7\u00e8"+
		"\5(\25\2\u00e8\u00e9\b\24\1\2\u00e9\u00ea\7\30\2\2\u00ea\u00eb\b\24\1"+
		"\2\u00eb\'\3\2\2\2\u00ec\u00ed\7\30\2\2\u00ed\u00ef\7\17\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		")\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\t\2\2\2\u00f4+\3\2\2\2\23\64"+
		"HM\\e~\u0083\u008f\u009a\u00a3\u00ac\u00b8\u00c3\u00d2\u00d9\u00e5\u00f0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}