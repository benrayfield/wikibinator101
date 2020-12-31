package wikibinator.impl;

import java.util.function.UnaryOperator;

import wikibinator.fn;

public class Wiki{
	private Wiki(){}
	
	/** every possible state of the wiki is a UnaryOperator<fn>.
	It starts as a function that always returns u/theUniversalFunction for all possible params.
	*/
	public static UnaryOperator<fn> wiki = T.e(u);

}
