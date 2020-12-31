/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator;

import java.util.function.UnaryOperator;

public class Wiki{
	private Wiki(){}
	
	/** every possible state of the wiki is a UnaryOperator<fn>.
	It starts as a function that always returns u/theUniversalFunction for all possible params.
	*/
	public static UnaryOperator<fn> wiki = T.e(u);

}