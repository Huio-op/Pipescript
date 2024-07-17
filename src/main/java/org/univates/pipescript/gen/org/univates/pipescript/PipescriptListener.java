// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/univates/pipescript/Pipescript.g4 by ANTLR 4.13.1
package org.univates.pipescript;

    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.function.Function;
    import java.util.Optional;
    import java.util.ArrayList;
    import java.util.Random;

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
	 * Enter a parse tree produced by {@link PipescriptParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(PipescriptParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(PipescriptParser.FunctionContext ctx);
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
	 * Enter a parse tree produced by {@link PipescriptParser#statement_while_true}.
	 * @param ctx the parse tree
	 */
	void enterStatement_while_true(PipescriptParser.Statement_while_trueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#statement_while_true}.
	 * @param ctx the parse tree
	 */
	void exitStatement_while_true(PipescriptParser.Statement_while_trueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#break}.
	 * @param ctx the parse tree
	 */
	void enterBreak(PipescriptParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#break}.
	 * @param ctx the parse tree
	 */
	void exitBreak(PipescriptParser.BreakContext ctx);
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
	 * Enter a parse tree produced by {@link PipescriptParser#function_printVar}.
	 * @param ctx the parse tree
	 */
	void enterFunction_printVar(PipescriptParser.Function_printVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_printVar}.
	 * @param ctx the parse tree
	 */
	void exitFunction_printVar(PipescriptParser.Function_printVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_scanInteger}.
	 * @param ctx the parse tree
	 */
	void enterFunction_scanInteger(PipescriptParser.Function_scanIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_scanInteger}.
	 * @param ctx the parse tree
	 */
	void exitFunction_scanInteger(PipescriptParser.Function_scanIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_scanString}.
	 * @param ctx the parse tree
	 */
	void enterFunction_scanString(PipescriptParser.Function_scanStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_scanString}.
	 * @param ctx the parse tree
	 */
	void exitFunction_scanString(PipescriptParser.Function_scanStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_readFile}.
	 * @param ctx the parse tree
	 */
	void enterFunction_readFile(PipescriptParser.Function_readFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_readFile}.
	 * @param ctx the parse tree
	 */
	void exitFunction_readFile(PipescriptParser.Function_readFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_writeFile}.
	 * @param ctx the parse tree
	 */
	void enterFunction_writeFile(PipescriptParser.Function_writeFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_writeFile}.
	 * @param ctx the parse tree
	 */
	void exitFunction_writeFile(PipescriptParser.Function_writeFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_randomNum}.
	 * @param ctx the parse tree
	 */
	void enterFunction_randomNum(PipescriptParser.Function_randomNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_randomNum}.
	 * @param ctx the parse tree
	 */
	void exitFunction_randomNum(PipescriptParser.Function_randomNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#function_customCall}.
	 * @param ctx the parse tree
	 */
	void enterFunction_customCall(PipescriptParser.Function_customCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#function_customCall}.
	 * @param ctx the parse tree
	 */
	void exitFunction_customCall(PipescriptParser.Function_customCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#goto}.
	 * @param ctx the parse tree
	 */
	void enterGoto(PipescriptParser.GotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#goto}.
	 * @param ctx the parse tree
	 */
	void exitGoto(PipescriptParser.GotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipescriptParser#def_goto}.
	 * @param ctx the parse tree
	 */
	void enterDef_goto(PipescriptParser.Def_gotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipescriptParser#def_goto}.
	 * @param ctx the parse tree
	 */
	void exitDef_goto(PipescriptParser.Def_gotoContext ctx);
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