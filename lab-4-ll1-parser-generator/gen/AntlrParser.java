// Generated from D:/Documents/parsers/ll1generator\Antlr.g4 by ANTLR 4.x

    import grammar.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHATEVER=1, GRAMMAR=2, B=3, COLON=4, RARR=5, SKIP=6, SEMICOLON=7, DOT=8, 
		VLINE=9, LBRACE=10, RBRACE=11, SL=12, SR=13, LT=14, GT=15, QM=16, JTypeBound=17, 
		COMMA=18, JPrimitiveType=19, TERMNAME=20, NONTERMNAME=21;
	public static final String[] tokenNames = {
		"<INVALID>", "WHATEVER", "'grammar'", "B", "':'", "'->'", "'skip'", "';'", 
		"'.'", "'|'", "'{'", "'}'", "'['", "']'", "'<'", "'>'", "'?'", "JTypeBound", 
		"','", "JPrimitiveType", "TERMNAME", "NONTERMNAME"
	};
	public static final int
		RULE_antlrGrammar = 0, RULE_grammarTitle = 1, RULE_term = 2, RULE_nonTerm = 3, 
		RULE_attributeList = 4, RULE_attribute = 5, RULE_regex = 6, RULE_ruleBody = 7, 
		RULE_ruleName = 8, RULE_code = 9, RULE_jType = 10, RULE_jClassOrInterfaceType = 11, 
		RULE_jTypeArguments = 12, RULE_jTypeArgument = 13, RULE_jIdentifier = 14;
	public static final String[] ruleNames = {
		"antlrGrammar", "grammarTitle", "term", "nonTerm", "attributeList", "attribute", 
		"regex", "ruleBody", "ruleName", "code", "jType", "jClassOrInterfaceType", 
		"jTypeArguments", "jTypeArgument", "jIdentifier"
	};

	@Override
	public String getGrammarFileName() { return "Antlr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public AntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AntlrGrammarContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public NonTermContext nonTerm(int i) {
			return getRuleContext(NonTermContext.class,i);
		}
		public List<NonTermContext> nonTerm() {
			return getRuleContexts(NonTermContext.class);
		}
		public GrammarTitleContext grammarTitle() {
			return getRuleContext(GrammarTitleContext.class,0);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AntlrGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_antlrGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterAntlrGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitAntlrGrammar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitAntlrGrammar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AntlrGrammarContext antlrGrammar() throws RecognitionException {
		AntlrGrammarContext _localctx = new AntlrGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_antlrGrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 init(); 
			setState(31); grammarTitle();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TERMNAME || _la==NONTERMNAME) {
				{
				setState(34);
				switch (_input.LA(1)) {
				case NONTERMNAME:
					{
					setState(32); nonTerm();
					}
					break;
				case TERMNAME:
					{
					setState(33); term();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 grammar.finishConstruction(); 
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

	public static class GrammarTitleContext extends ParserRuleContext {
		public JIdentifierContext jIdentifier;
		public TerminalNode SEMICOLON() { return getToken(AntlrParser.SEMICOLON, 0); }
		public JIdentifierContext jIdentifier() {
			return getRuleContext(JIdentifierContext.class,0);
		}
		public TerminalNode GRAMMAR() { return getToken(AntlrParser.GRAMMAR, 0); }
		public GrammarTitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarTitle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterGrammarTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitGrammarTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitGrammarTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GrammarTitleContext grammarTitle() throws RecognitionException {
		GrammarTitleContext _localctx = new GrammarTitleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarTitle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); match(GRAMMAR);
			setState(42); ((GrammarTitleContext)_localctx).jIdentifier = jIdentifier();
			 gName = (((GrammarTitleContext)_localctx).jIdentifier!=null?_input.getText(((GrammarTitleContext)_localctx).jIdentifier.start,((GrammarTitleContext)_localctx).jIdentifier.stop):null); 
			setState(44); match(SEMICOLON);
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

	public static class TermContext extends ParserRuleContext {
		public Token TERMNAME;
		public RegexContext regex;
		public TerminalNode RARR() { return getToken(AntlrParser.RARR, 0); }
		public TerminalNode SEMICOLON() { return getToken(AntlrParser.SEMICOLON, 0); }
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public TerminalNode SKIP() { return getToken(AntlrParser.SKIP, 0); }
		public TerminalNode TERMNAME() { return getToken(AntlrParser.TERMNAME, 0); }
		public TerminalNode COLON() { return getToken(AntlrParser.COLON, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); ((TermContext)_localctx).TERMNAME = match(TERMNAME);
			setState(47); match(COLON);
			setState(48); ((TermContext)_localctx).regex = regex();
			 boolean skip = false; 
			setState(53);
			_la = _input.LA(1);
			if (_la==RARR) {
				{
				setState(50); match(RARR);
				setState(51); match(SKIP);
				 skip = true; 
				}
			}


			        grammar.add(new Terminal((((TermContext)_localctx).TERMNAME!=null?((TermContext)_localctx).TERMNAME.getText():null), (((TermContext)_localctx).regex!=null?_input.getText(((TermContext)_localctx).regex.start,((TermContext)_localctx).regex.stop):null), skip));
			    
			setState(56); match(SEMICOLON);
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

	public static class NonTermContext extends ParserRuleContext {
		public Token NONTERMNAME;
		public List<TerminalNode> VLINE() { return getTokens(AntlrParser.VLINE); }
		public TerminalNode SEMICOLON() { return getToken(AntlrParser.SEMICOLON, 0); }
		public TerminalNode SR() { return getToken(AntlrParser.SR, 0); }
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public TerminalNode NONTERMNAME() { return getToken(AntlrParser.NONTERMNAME, 0); }
		public RuleBodyContext ruleBody(int i) {
			return getRuleContext(RuleBodyContext.class,i);
		}
		public TerminalNode SL() { return getToken(AntlrParser.SL, 0); }
		public List<RuleBodyContext> ruleBody() {
			return getRuleContexts(RuleBodyContext.class);
		}
		public TerminalNode VLINE(int i) {
			return getToken(AntlrParser.VLINE, i);
		}
		public TerminalNode COLON() { return getToken(AntlrParser.COLON, 0); }
		public NonTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterNonTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitNonTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitNonTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTermContext nonTerm() throws RecognitionException {
		NonTermContext _localctx = new NonTermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nonTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); ((NonTermContext)_localctx).NONTERMNAME = match(NONTERMNAME);

			        List<Attribute> attributes = new ArrayList<>();
			    
			setState(64);
			_la = _input.LA(1);
			if (_la==SL) {
				{
				setState(60); match(SL);
				setState(61); attributeList(attributes);
				setState(62); match(SR);
				}
			}


			        NonTerminal nt = new NonTerminal((((NonTermContext)_localctx).NONTERMNAME!=null?((NonTermContext)_localctx).NONTERMNAME.getText():null), attributes);
			        grammar.add(nt);
			    
			setState(67); match(COLON);
			setState(68); ruleBody(nt);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VLINE) {
				{
				{
				setState(69); match(VLINE);
				setState(70); ruleBody(nt);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76); match(SEMICOLON);
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

	public static class AttributeListContext extends ParserRuleContext {
		public List<Attribute> attributes;
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(AntlrParser.COMMA); }
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(AntlrParser.COMMA, i);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeListContext(ParserRuleContext parent, int invokingState, List<Attribute> attributes) {
			super(parent, invokingState);
			this.attributes = attributes;
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeListContext attributeList(List<Attribute> attributes) throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState(), attributes);
		enterRule(_localctx, 8, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); attribute(attributes);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(79); match(COMMA);
				setState(80); attribute(attributes);
				}
				}
				setState(85);
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

	public static class AttributeContext extends ParserRuleContext {
		public List<Attribute> attributes;
		public JTypeContext jType;
		public JIdentifierContext jIdentifier;
		public JTypeContext jType() {
			return getRuleContext(JTypeContext.class,0);
		}
		public JIdentifierContext jIdentifier() {
			return getRuleContext(JIdentifierContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeContext(ParserRuleContext parent, int invokingState, List<Attribute> attributes) {
			super(parent, invokingState);
			this.attributes = attributes;
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute(List<Attribute> attributes) throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState(), attributes);
		enterRule(_localctx, 10, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); ((AttributeContext)_localctx).jType = jType();
			setState(87); ((AttributeContext)_localctx).jIdentifier = jIdentifier();
			 attributes.add(new Attribute((((AttributeContext)_localctx).jType!=null?_input.getText(((AttributeContext)_localctx).jType.start,((AttributeContext)_localctx).jType.stop):null), (((AttributeContext)_localctx).jIdentifier!=null?_input.getText(((AttributeContext)_localctx).jIdentifier.start,((AttributeContext)_localctx).jIdentifier.stop):null))); 
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

	public static class RegexContext extends ParserRuleContext {
		public TerminalNode WHATEVER() { return getToken(AntlrParser.WHATEVER, 0); }
		public RegexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterRegex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitRegex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitRegex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegexContext regex() throws RecognitionException {
		RegexContext _localctx = new RegexContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_regex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(WHATEVER);
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

	public static class RuleBodyContext extends ParserRuleContext {
		public NonTerminal nt;
		public CodeContext code;
		public List<RuleNameContext> ruleName() {
			return getRuleContexts(RuleNameContext.class);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public RuleNameContext ruleName(int i) {
			return getRuleContext(RuleNameContext.class,i);
		}
		public RuleBodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RuleBodyContext(ParserRuleContext parent, int invokingState, NonTerminal nt) {
			super(parent, invokingState);
			this.nt = nt;
		}
		@Override public int getRuleIndex() { return RULE_ruleBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterRuleBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitRuleBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitRuleBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleBodyContext ruleBody(NonTerminal nt) throws RecognitionException {
		RuleBodyContext _localctx = new RuleBodyContext(_ctx, getState(), nt);
		enterRule(_localctx, 14, RULE_ruleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			        Rule curRule = new Rule();
			        nt.addRule(curRule);
			    
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TERMNAME || _la==NONTERMNAME) {
				{
				{
				setState(93); ruleName(curRule);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        if (curRule.size() == 0) {
			             nt.enableEpsRule();
			        }
			    
			setState(103);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(100); ((RuleBodyContext)_localctx).code = code();
				 curRule.setCode(((RuleBodyContext)_localctx).code.c); 
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

	public static class RuleNameContext extends ParserRuleContext {
		public Rule curRule;
		public Token TERMNAME;
		public Token NONTERMNAME;
		public TerminalNode TERMNAME() { return getToken(AntlrParser.TERMNAME, 0); }
		public TerminalNode NONTERMNAME() { return getToken(AntlrParser.NONTERMNAME, 0); }
		public RuleNameContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RuleNameContext(ParserRuleContext parent, int invokingState, Rule curRule) {
			super(parent, invokingState);
			this.curRule = curRule;
		}
		@Override public int getRuleIndex() { return RULE_ruleName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterRuleName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitRuleName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitRuleName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleNameContext ruleName(Rule curRule) throws RecognitionException {
		RuleNameContext _localctx = new RuleNameContext(_ctx, getState(), curRule);
		enterRule(_localctx, 16, RULE_ruleName);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case TERMNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(105); ((RuleNameContext)_localctx).TERMNAME = match(TERMNAME);
				 curRule.addChild((((RuleNameContext)_localctx).TERMNAME!=null?((RuleNameContext)_localctx).TERMNAME.getText():null)); 
				}
				break;
			case NONTERMNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); ((RuleNameContext)_localctx).NONTERMNAME = match(NONTERMNAME);
				 curRule.addChild((((RuleNameContext)_localctx).NONTERMNAME!=null?((RuleNameContext)_localctx).NONTERMNAME.getText():null)); 
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

	public static class CodeContext extends ParserRuleContext {
		public String c;
		public Token WHATEVER;
		public TerminalNode LBRACE() { return getToken(AntlrParser.LBRACE, 0); }
		public TerminalNode WHATEVER() { return getToken(AntlrParser.WHATEVER, 0); }
		public TerminalNode RBRACE() { return getToken(AntlrParser.RBRACE, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(LBRACE);
			setState(112); ((CodeContext)_localctx).WHATEVER = match(WHATEVER);
			((CodeContext)_localctx).c =  (((CodeContext)_localctx).WHATEVER!=null?((CodeContext)_localctx).WHATEVER.getText():null); 
			setState(114); match(RBRACE);
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

	public static class JTypeContext extends ParserRuleContext {
		public List<TerminalNode> SR() { return getTokens(AntlrParser.SR); }
		public TerminalNode JPrimitiveType() { return getToken(AntlrParser.JPrimitiveType, 0); }
		public TerminalNode SR(int i) {
			return getToken(AntlrParser.SR, i);
		}
		public List<TerminalNode> SL() { return getTokens(AntlrParser.SL); }
		public JClassOrInterfaceTypeContext jClassOrInterfaceType() {
			return getRuleContext(JClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode SL(int i) {
			return getToken(AntlrParser.SL, i);
		}
		public JTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterJType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitJType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitJType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JTypeContext jType() throws RecognitionException {
		JTypeContext _localctx = new JTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jType);
		int _la;
		try {
			setState(132);
			switch (_input.LA(1)) {
			case TERMNAME:
			case NONTERMNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); jClassOrInterfaceType();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SL) {
					{
					{
					setState(117); match(SL);
					setState(118); match(SR);
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case JPrimitiveType:
				enterOuterAlt(_localctx, 2);
				{
				setState(124); match(JPrimitiveType);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SL) {
					{
					{
					setState(125); match(SL);
					setState(126); match(SR);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class JClassOrInterfaceTypeContext extends ParserRuleContext {
		public JIdentifierContext jIdentifier(int i) {
			return getRuleContext(JIdentifierContext.class,i);
		}
		public List<JTypeArgumentsContext> jTypeArguments() {
			return getRuleContexts(JTypeArgumentsContext.class);
		}
		public JTypeArgumentsContext jTypeArguments(int i) {
			return getRuleContext(JTypeArgumentsContext.class,i);
		}
		public List<JIdentifierContext> jIdentifier() {
			return getRuleContexts(JIdentifierContext.class);
		}
		public JClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterJClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitJClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitJClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JClassOrInterfaceTypeContext jClassOrInterfaceType() throws RecognitionException {
		JClassOrInterfaceTypeContext _localctx = new JClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); jIdentifier();
			setState(136);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(135); jTypeArguments();
				}
			}

			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(138); match(DOT);
				setState(139); jIdentifier();
				setState(141);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(140); jTypeArguments();
					}
				}

				}
				}
				setState(147);
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

	public static class JTypeArgumentsContext extends ParserRuleContext {
		public JTypeArgumentContext jTypeArgument(int i) {
			return getRuleContext(JTypeArgumentContext.class,i);
		}
		public List<JTypeArgumentContext> jTypeArgument() {
			return getRuleContexts(JTypeArgumentContext.class);
		}
		public TerminalNode LT() { return getToken(AntlrParser.LT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AntlrParser.COMMA); }
		public TerminalNode GT() { return getToken(AntlrParser.GT, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(AntlrParser.COMMA, i);
		}
		public JTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterJTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitJTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitJTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JTypeArgumentsContext jTypeArguments() throws RecognitionException {
		JTypeArgumentsContext _localctx = new JTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_jTypeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(LT);
			setState(149); jTypeArgument();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(150); match(COMMA);
				setState(151); jTypeArgument();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157); match(GT);
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

	public static class JTypeArgumentContext extends ParserRuleContext {
		public TerminalNode QM() { return getToken(AntlrParser.QM, 0); }
		public TerminalNode JTypeBound() { return getToken(AntlrParser.JTypeBound, 0); }
		public JTypeContext jType() {
			return getRuleContext(JTypeContext.class,0);
		}
		public JTypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jTypeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterJTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitJTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitJTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JTypeArgumentContext jTypeArgument() throws RecognitionException {
		JTypeArgumentContext _localctx = new JTypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jTypeArgument);
		int _la;
		try {
			setState(165);
			switch (_input.LA(1)) {
			case JPrimitiveType:
			case TERMNAME:
			case NONTERMNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(159); jType();
				}
				break;
			case QM:
				enterOuterAlt(_localctx, 2);
				{
				setState(160); match(QM);
				setState(163);
				_la = _input.LA(1);
				if (_la==JTypeBound) {
					{
					setState(161); match(JTypeBound);
					setState(162); jType();
					}
				}

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

	public static class JIdentifierContext extends ParserRuleContext {
		public TerminalNode TERMNAME() { return getToken(AntlrParser.TERMNAME, 0); }
		public TerminalNode NONTERMNAME() { return getToken(AntlrParser.NONTERMNAME, 0); }
		public JIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).enterJIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrListener ) ((AntlrListener)listener).exitJIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrVisitor ) return ((AntlrVisitor<? extends T>)visitor).visitJIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JIdentifierContext jIdentifier() throws RecognitionException {
		JIdentifierContext _localctx = new JIdentifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !(_la==TERMNAME || _la==NONTERMNAME) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\27\u00ac\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\7"+
		"\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\48\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\3\5\3\6\3\6\3\6\7\6T\n\6\f\6"+
		"\16\6W\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\7\ta\n\t\f\t\16\td\13\t\3"+
		"\t\3\t\3\t\3\t\5\tj\n\t\3\n\3\n\3\n\3\n\5\np\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\7\fz\n\f\f\f\16\f}\13\f\3\f\3\f\3\f\7\f\u0082\n\f\f\f"+
		"\16\f\u0085\13\f\5\f\u0087\n\f\3\r\3\r\5\r\u008b\n\r\3\r\3\r\3\r\5\r\u0090"+
		"\n\r\7\r\u0092\n\r\f\r\16\r\u0095\13\r\3\16\3\16\3\16\3\16\7\16\u009b"+
		"\n\16\f\16\16\16\u009e\13\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00a6"+
		"\n\17\5\17\u00a8\n\17\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36\2\3\3\2\26\27\u00ae\2 \3\2\2\2\4+\3\2\2\2\6\60\3\2\2\2\b"+
		"<\3\2\2\2\nP\3\2\2\2\fX\3\2\2\2\16\\\3\2\2\2\20^\3\2\2\2\22o\3\2\2\2\24"+
		"q\3\2\2\2\26\u0086\3\2\2\2\30\u0088\3\2\2\2\32\u0096\3\2\2\2\34\u00a7"+
		"\3\2\2\2\36\u00a9\3\2\2\2 !\b\2\1\2!&\5\4\3\2\"%\5\b\5\2#%\5\6\4\2$\""+
		"\3\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2"+
		")*\b\2\1\2*\3\3\2\2\2+,\7\4\2\2,-\5\36\20\2-.\b\3\1\2./\7\t\2\2/\5\3\2"+
		"\2\2\60\61\7\26\2\2\61\62\7\6\2\2\62\63\5\16\b\2\63\67\b\4\1\2\64\65\7"+
		"\7\2\2\65\66\7\b\2\2\668\b\4\1\2\67\64\3\2\2\2\678\3\2\2\289\3\2\2\29"+
		":\b\4\1\2:;\7\t\2\2;\7\3\2\2\2<=\7\27\2\2=B\b\5\1\2>?\7\16\2\2?@\5\n\6"+
		"\2@A\7\17\2\2AC\3\2\2\2B>\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\b\5\1\2EF\7\6"+
		"\2\2FK\5\20\t\2GH\7\13\2\2HJ\5\20\t\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL"+
		"\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7\t\2\2O\t\3\2\2\2PU\5\f\7\2QR\7\24\2\2"+
		"RT\5\f\7\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\13\3\2\2\2WU\3\2\2"+
		"\2XY\5\26\f\2YZ\5\36\20\2Z[\b\7\1\2[\r\3\2\2\2\\]\7\3\2\2]\17\3\2\2\2"+
		"^b\b\t\1\2_a\5\22\n\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2"+
		"\2db\3\2\2\2ei\b\t\1\2fg\5\24\13\2gh\b\t\1\2hj\3\2\2\2if\3\2\2\2ij\3\2"+
		"\2\2j\21\3\2\2\2kl\7\26\2\2lp\b\n\1\2mn\7\27\2\2np\b\n\1\2ok\3\2\2\2o"+
		"m\3\2\2\2p\23\3\2\2\2qr\7\f\2\2rs\7\3\2\2st\b\13\1\2tu\7\r\2\2u\25\3\2"+
		"\2\2v{\5\30\r\2wx\7\16\2\2xz\7\17\2\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|"+
		"\3\2\2\2|\u0087\3\2\2\2}{\3\2\2\2~\u0083\7\25\2\2\177\u0080\7\16\2\2\u0080"+
		"\u0082\7\17\2\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"v\3\2\2\2\u0086~\3\2\2\2\u0087\27\3\2\2\2\u0088\u008a\5\36\20\2\u0089"+
		"\u008b\5\32\16\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0093\3"+
		"\2\2\2\u008c\u008d\7\n\2\2\u008d\u008f\5\36\20\2\u008e\u0090\5\32\16\2"+
		"\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008c"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\31\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\20\2\2\u0097\u009c\5\34"+
		"\17\2\u0098\u0099\7\24\2\2\u0099\u009b\5\34\17\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\21\2\2\u00a0\33\3\2\2\2\u00a1\u00a8"+
		"\5\26\f\2\u00a2\u00a5\7\22\2\2\u00a3\u00a4\7\23\2\2\u00a4\u00a6\5\26\f"+
		"\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a1"+
		"\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a8\35\3\2\2\2\u00a9\u00aa\t\2\2\2\u00aa"+
		"\37\3\2\2\2\24$&\67BKUbio{\u0083\u0086\u008a\u008f\u0093\u009c\u00a5\u00a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}