/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

/** wrapperOfAxiomnodeThatCanBeANonhaltedLambdaCallAndChildOfHaltedLambda
View a axiomforest.observe.Λ (the core object type) as halted lambda,
even if its a wrapper of a nonhalted lambda. For now will use Node instead of Λ,
but planning to convert all Nodes to a single Λ type after get this working (now is 2021-1-15).
*/
public class ViewNodeAsHaltedLambda extends AbstractNode{
	
	public ViewNodeAsHaltedLambda(boolean tv, Node wrapMe){
		super(tv, wrapMe);
	}
	
	public Node wrapMe(){
		return get(0);
	}

}