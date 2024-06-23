// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/example/Tara.g4 by ANTLR 4.13.1
package org.example.gen;

    import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaraParser}.
 */
public interface TaraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaraParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TaraParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TaraParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TaraParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TaraParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TaraParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TaraParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#statement_if}.
	 * @param ctx the parse tree
	 */
	void enterStatement_if(TaraParser.Statement_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#statement_if}.
	 * @param ctx the parse tree
	 */
	void exitStatement_if(TaraParser.Statement_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#statement_else}.
	 * @param ctx the parse tree
	 */
	void enterStatement_else(TaraParser.Statement_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#statement_else}.
	 * @param ctx the parse tree
	 */
	void exitStatement_else(TaraParser.Statement_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#statement_while}.
	 * @param ctx the parse tree
	 */
	void enterStatement_while(TaraParser.Statement_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#statement_while}.
	 * @param ctx the parse tree
	 */
	void exitStatement_while(TaraParser.Statement_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#function_printInteger}.
	 * @param ctx the parse tree
	 */
	void enterFunction_printInteger(TaraParser.Function_printIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#function_printInteger}.
	 * @param ctx the parse tree
	 */
	void exitFunction_printInteger(TaraParser.Function_printIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#function_printString}.
	 * @param ctx the parse tree
	 */
	void enterFunction_printString(TaraParser.Function_printStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#function_printString}.
	 * @param ctx the parse tree
	 */
	void exitFunction_printString(TaraParser.Function_printStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#call_function}.
	 * @param ctx the parse tree
	 */
	void enterCall_function(TaraParser.Call_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#call_function}.
	 * @param ctx the parse tree
	 */
	void exitCall_function(TaraParser.Call_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TaraParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TaraParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TaraParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TaraParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(TaraParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(TaraParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaraParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TaraParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaraParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TaraParser.FactorContext ctx);
}