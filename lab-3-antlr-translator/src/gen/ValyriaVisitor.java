// Generated from D:/Documents/parsers/Valyria/src\Valyria.g4 by ANTLR 4.x

import java.util.*;
import java.util.stream.*;
import java.lang.StringBuilder;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValyriaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValyriaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(@NotNull ValyriaParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(@NotNull ValyriaParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(@NotNull ValyriaParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(@NotNull ValyriaParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(@NotNull ValyriaParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#functionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionList(@NotNull ValyriaParser.FunctionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull ValyriaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull ValyriaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#typeDesc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDesc(@NotNull ValyriaParser.TypeDescContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull ValyriaParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(@NotNull ValyriaParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#compExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull ValyriaParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull ValyriaParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#rType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRType(@NotNull ValyriaParser.RTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#callParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParam(@NotNull ValyriaParser.CallParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull ValyriaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#callParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParams(@NotNull ValyriaParser.CallParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#paramsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsList(@NotNull ValyriaParser.ParamsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr(@NotNull ValyriaParser.ArithExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#pType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPType(@NotNull ValyriaParser.PTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValyriaParser#funCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(@NotNull ValyriaParser.FunCallContext ctx);
}