grammar Antlr;

@header {
    import grammar.*;
}

@members {
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
}

antlrGrammar 
    : { init(); } grammarTitle (nonTerm | term)* { grammar.finishConstruction(); }
    ;

grammarTitle
    : GRAMMAR jIdentifier { gName = $jIdentifier.text; } SEMICOLON
    ;

term 
    : TERMNAME COLON regex { boolean skip = false; } (RARR SKIP { skip = true; })? {
        grammar.add(new Terminal($TERMNAME.text, $regex.text, skip));
    } SEMICOLON
    ;
nonTerm	
    : NONTERMNAME {
        List<Attribute> attributes = new ArrayList<>();
    } (SL attributeList[attributes] SR)? {
        NonTerminal nt = new NonTerminal($NONTERMNAME.text, attributes);
        grammar.add(nt);
    } COLON ruleBody[nt] (VLINE ruleBody[nt])* SEMICOLON
    ;
attributeList[List<Attribute> attributes]
    : attribute[attributes] (COMMA attribute[attributes])*
    ;
attribute[List<Attribute> attributes]
    : jType jIdentifier { attributes.add(new Attribute($jType.text, $jIdentifier.text)); }
    ;
regex
    : WHATEVER
    ;
ruleBody[NonTerminal nt]
    : { 
        Rule curRule = new Rule();
        nt.addRule(curRule);
    } ruleName[curRule]* {
        if (curRule.size() == 0) {
             nt.enableEpsRule();
        }
    } (code { curRule.setCode($code.c); })?
    ;
ruleName[Rule curRule]
    : TERMNAME { curRule.addChild($TERMNAME.text); }
    | NONTERMNAME { curRule.addChild($NONTERMNAME.text); }
    ;
code returns [String c]
    : LBRACE WHATEVER {$c = $WHATEVER.text; } RBRACE
    ;

/* Type definitions from Java grammar */
jType
    :   jClassOrInterfaceType (SL SR)*
    |   JPrimitiveType (SL SR)*
    ;

jClassOrInterfaceType
    :   jIdentifier jTypeArguments? ('.' jIdentifier jTypeArguments? )*
    ;

jTypeArguments
    :   LT jTypeArgument (COMMA jTypeArgument)* GT
    ;

jTypeArgument
    :   jType
    |   QM (JTypeBound jType)?
    ;
/* End type definitions from Java grammar */

jIdentifier
    : TERMNAME | NONTERMNAME
    ;


WHATEVER
    : '#' (~[#])+ '#'
    ;
GRAMMAR
    : 'grammar'
    ;
B
    : ('\t' | ' ' |'\r' | '\n') -> skip
    ;
COLON
    : ':'
    ;
RARR
    : '->'
    ;
SKIP
    : 'skip'
    ;
SEMICOLON
    : ';'
    ;
DOT
    : '.'
    ;
VLINE
    : '|'
    ;
LBRACE
    : '{'
    ;
RBRACE
    : '}'
    ;
SL
    : '['
    ;
SR
    : ']'
    ;
LT
    : '<'
    ;
GT
    : '>'
    ;
QM
    : '?'
    ;
JTypeBound
    : 'extends'
    | 'super'
    ;
COMMA
    : ','
    ;
JPrimitiveType
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;
TERMNAME
    : [A-Z][A-Za-z0-9_]*
    ;
NONTERMNAME
    : [a-z][A-Za-z0-9_]*
    ;
