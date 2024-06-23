// Generated from C:/Users/fe151/IdeaProjects/Antlr/src/main/java/org/example/Tara.g4 by ANTLR 4.13.1
package org.example.gen;

    import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TaraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TaraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TaraParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TaraParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(TaraParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TaraParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#statement_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_if(TaraParser.Statement_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#statement_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_else(TaraParser.Statement_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#statement_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_while(TaraParser.Statement_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#function_printInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_printInteger(TaraParser.Function_printIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#function_printString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_printString(TaraParser.Function_printStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#call_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_function(TaraParser.Call_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TaraParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TaraParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(TaraParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaraParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(TaraParser.FactorContext ctx);
}