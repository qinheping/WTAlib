// Generated from Timbuk.g4 by ANTLR 4.5.3
package parser.TimbukParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TimbukParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TimbukVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TimbukParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(TimbukParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#label_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel_list(TimbukParser.Label_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#label_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel_decl(TimbukParser.Label_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#automaton}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutomaton(TimbukParser.AutomatonContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#state_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_list(TimbukParser.State_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(TimbukParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#transition_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition_list(TimbukParser.Transition_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimbukParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(TimbukParser.TransitionContext ctx);
}