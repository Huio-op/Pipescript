// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.function.Function;
    import java.util.Optional;
    import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PipescriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PipescriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PipescriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(PipescriptParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(PipescriptParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PipescriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#statement_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_if(PipescriptParser.Statement_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#statement_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_else(PipescriptParser.Statement_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#statement_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_while(PipescriptParser.Statement_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#statement_while_true}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_while_true(PipescriptParser.Statement_while_trueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#break}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(PipescriptParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_printInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_printInteger(PipescriptParser.Function_printIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_printString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_printString(PipescriptParser.Function_printStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_printVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_printVar(PipescriptParser.Function_printVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_scanInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_scanInteger(PipescriptParser.Function_scanIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_scanString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_scanString(PipescriptParser.Function_scanStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_readFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_readFile(PipescriptParser.Function_readFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_writeFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_writeFile(PipescriptParser.Function_writeFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#function_customCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_customCall(PipescriptParser.Function_customCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#goto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto(PipescriptParser.GotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#def_goto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_goto(PipescriptParser.Def_gotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#call_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_function(PipescriptParser.Call_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PipescriptParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PipescriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PipescriptParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipescriptParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(PipescriptParser.FactorContext ctx);
}