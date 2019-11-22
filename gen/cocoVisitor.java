// Generated from /Users/SimonAndersen/Documents/Studie/3.Semester/CompilerConstruction/Opgaver/coco.v1/src/coco.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link cocoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface cocoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link cocoParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(cocoParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link cocoParser#dataTypeDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeDef(cocoParser.DataTypeDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link cocoParser#alternatives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternatives(cocoParser.AlternativesContext ctx);
	/**
	 * Visit a parse tree produced by {@link cocoParser#alternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternative(cocoParser.AlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cocoParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(cocoParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cocoParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(cocoParser.ArgumentContext ctx);
}