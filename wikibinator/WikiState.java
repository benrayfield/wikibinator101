/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator;

import java.util.function.UnaryOperator;

public class WikiState{
	private WikiState(){}
	
	/** every possible state of the wiki is a UnaryOperator<fn>.
	It starts as a function that always returns u/theUniversalFunction for all possible params.
	*/
	public static UnaryOperator<λ> wiki = (λ param)->param; //FIXME start it as T.e(u); instead of that identityFunc

}