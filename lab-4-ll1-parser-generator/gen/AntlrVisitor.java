// Generated from D:/Documents/parsers/ll1generator\Antlr.g4 by ANTLR 4.x

    import grammar.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AntlrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AntlrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AntlrParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegex(@NotNull AntlrParser.RegexContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#ruleBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleBody(@NotNull AntlrParser.RuleBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(@NotNull AntlrParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#nonTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerm(@NotNull AntlrParser.NonTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(@NotNull AntlrParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#grammarTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammarTitle(@NotNull AntlrParser.GrammarTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#jTypeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJTypeArguments(@NotNull AntlrParser.JTypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#jClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJClassOrInterfaceType(@NotNull AntlrParser.JClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#attributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(@NotNull AntlrParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull AntlrParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#jTypeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJTypeArgument(@NotNull AntlrParser.JTypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#ruleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleName(@NotNull AntlrParser.RuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#jType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJType(@NotNull AntlrParser.JTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#jIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJIdentifier(@NotNull AntlrParser.JIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrParser#antlrGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAntlrGrammar(@NotNull AntlrParser.AntlrGrammarContext ctx);
}