// Generated from D:/Documents/parsers/Valyria/src\Valyria.g4 by ANTLR 4.x

import java.util.*;
import java.util.stream.*;
import java.lang.StringBuilder;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValyriaParser}.
 */
public interface ValyriaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(@NotNull ValyriaParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(@NotNull ValyriaParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(@NotNull ValyriaParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(@NotNull ValyriaParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(@NotNull ValyriaParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(@NotNull ValyriaParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull ValyriaParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull ValyriaParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(@NotNull ValyriaParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(@NotNull ValyriaParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#functionList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionList(@NotNull ValyriaParser.FunctionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#functionList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionList(@NotNull ValyriaParser.FunctionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull ValyriaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull ValyriaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull ValyriaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull ValyriaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void enterTypeDesc(@NotNull ValyriaParser.TypeDescContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void exitTypeDesc(@NotNull ValyriaParser.TypeDescContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull ValyriaParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull ValyriaParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(@NotNull ValyriaParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(@NotNull ValyriaParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull ValyriaParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull ValyriaParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull ValyriaParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull ValyriaParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#rType}.
	 * @param ctx the parse tree
	 */
	void enterRType(@NotNull ValyriaParser.RTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#rType}.
	 * @param ctx the parse tree
	 */
	void exitRType(@NotNull ValyriaParser.RTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#callParam}.
	 * @param ctx the parse tree
	 */
	void enterCallParam(@NotNull ValyriaParser.CallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#callParam}.
	 * @param ctx the parse tree
	 */
	void exitCallParam(@NotNull ValyriaParser.CallParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ValyriaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ValyriaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#callParams}.
	 * @param ctx the parse tree
	 */
	void enterCallParams(@NotNull ValyriaParser.CallParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#callParams}.
	 * @param ctx the parse tree
	 */
	void exitCallParams(@NotNull ValyriaParser.CallParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#paramsList}.
	 * @param ctx the parse tree
	 */
	void enterParamsList(@NotNull ValyriaParser.ParamsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#paramsList}.
	 * @param ctx the parse tree
	 */
	void exitParamsList(@NotNull ValyriaParser.ParamsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(@NotNull ValyriaParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(@NotNull ValyriaParser.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#pType}.
	 * @param ctx the parse tree
	 */
	void enterPType(@NotNull ValyriaParser.PTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#pType}.
	 * @param ctx the parse tree
	 */
	void exitPType(@NotNull ValyriaParser.PTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValyriaParser#funCall}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(@NotNull ValyriaParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValyriaParser#funCall}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(@NotNull ValyriaParser.FunCallContext ctx);
}