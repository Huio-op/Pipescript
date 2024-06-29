// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PipescriptParser}.
 */
public interface PipescriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PipescriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PipescriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(PipescriptParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(PipescriptParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PipescriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PipescriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#statement_if}.
	 * @param ctx the parse tree
	 */
	void enterStatement_if(PipescriptParser.Statement_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#statement_if}.
	 * @param ctx the parse tree
	 */
	void exitStatement_if(PipescriptParser.Statement_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#statement_else}.
	 * @param ctx the parse tree
	 */
	void enterStatement_else(PipescriptParser.Statement_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#statement_else}.
	 * @param ctx the parse tree
	 */
	void exitStatement_else(PipescriptParser.Statement_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#statement_while}.
	 * @param ctx the parse tree
	 */
	void enterStatement_while(PipescriptParser.Statement_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#statement_while}.
	 * @param ctx the parse tree
	 */
	void exitStatement_while(PipescriptParser.Statement_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_printInteger}.
	 * @param ctx the parse tree
	 */
	void enterFunction_printInteger(PipescriptParser.Function_printIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_printInteger}.
	 * @param ctx the parse tree
	 */
	void exitFunction_printInteger(PipescriptParser.Function_printIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_printString}.
	 * @param ctx the parse tree
	 */
	void enterFunction_printString(PipescriptParser.Function_printStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_printString}.
	 * @param ctx the parse tree
	 */
	void exitFunction_printString(PipescriptParser.Function_printStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#call_function}.
	 * @param ctx the parse tree
	 */
	void enterCall_function(PipescriptParser.Call_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#call_function}.
	 * @param ctx the parse tree
	 */
	void exitCall_function(PipescriptParser.Call_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PipescriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PipescriptParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PipescriptParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PipescriptParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PipescriptParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PipescriptParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PipescriptParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PipescriptParser.FactorContext ctx);
}