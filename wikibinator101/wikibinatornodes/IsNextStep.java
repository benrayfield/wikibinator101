/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

import axiomforest.TruthValue;

/** use with CanReachBySteps and the outermost UnaryOperator in some view of axiomforest.
*/
public class IsNextStep extends AbstractNode{
	
	public IsNextStep(TruthValue tv, Node from, Node to){
		super(tv, from, to);
	}
	
	public Node from(){
		return get(0);
	}
	
	public Node to(){
		return get(1);
	}

}