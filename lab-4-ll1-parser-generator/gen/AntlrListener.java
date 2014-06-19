// Generated from D:/Documents/parsers/ll1generator\Antlr.g4 by ANTLR 4.x

    import grammar.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AntlrParser}.
 */
public interface AntlrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AntlrParser#regex}.
	 * @param ctx the parse tree
	 */
	void enterRegex(@NotNull AntlrParser.RegexContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#regex}.
	 * @param ctx the parse tree
	 */
	void exitRegex(@NotNull AntlrParser.RegexContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#ruleBody}.
	 * @param ctx the parse tree
	 */
	void enterRuleBody(@NotNull AntlrParser.RuleBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#ruleBody}.
	 * @param ctx the parse tree
	 */
	void exitRuleBody(@NotNull AntlrParser.RuleBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull AntlrParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull AntlrParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#nonTerm}.
	 * @param ctx the parse tree
	 */
	void enterNonTerm(@NotNull AntlrParser.NonTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#nonTerm}.
	 * @param ctx the parse tree
	 */
	void exitNonTerm(@NotNull AntlrParser.NonTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(@NotNull AntlrParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(@NotNull AntlrParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#grammarTitle}.
	 * @param ctx the parse tree
	 */
	void enterGrammarTitle(@NotNull AntlrParser.GrammarTitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#grammarTitle}.
	 * @param ctx the parse tree
	 */
	void exitGrammarTitle(@NotNull AntlrParser.GrammarTitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#jTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterJTypeArguments(@NotNull AntlrParser.JTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#jTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitJTypeArguments(@NotNull AntlrParser.JTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#jClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterJClassOrInterfaceType(@NotNull AntlrParser.JClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#jClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitJClassOrInterfaceType(@NotNull AntlrParser.JClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(@NotNull AntlrParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(@NotNull AntlrParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull AntlrParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull AntlrParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#jTypeArgument}.
	 * @param ctx the parse tree
	 */
	void enterJTypeArgument(@NotNull AntlrParser.JTypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#jTypeArgument}.
	 * @param ctx the parse tree
	 */
	void exitJTypeArgument(@NotNull AntlrParser.JTypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#ruleName}.
	 * @param ctx the parse tree
	 */
	void enterRuleName(@NotNull AntlrParser.RuleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#ruleName}.
	 * @param ctx the parse tree
	 */
	void exitRuleName(@NotNull AntlrParser.RuleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#jType}.
	 * @param ctx the parse tree
	 */
	void enterJType(@NotNull AntlrParser.JTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#jType}.
	 * @param ctx the parse tree
	 */
	void exitJType(@NotNull AntlrParser.JTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#jIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterJIdentifier(@NotNull AntlrParser.JIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#jIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitJIdentifier(@NotNull AntlrParser.JIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrParser#antlrGrammar}.
	 * @param ctx the parse tree
	 */
	void enterAntlrGrammar(@NotNull AntlrParser.AntlrGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrParser#antlrGrammar}.
	 * @param ctx the parse tree
	 */
	void exitAntlrGrammar(@NotNull AntlrParser.AntlrGrammarContext ctx);
}