/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

public class HaltedLambda{
	
	public HaltedLambda(Node func, Node param){
		super(func,param);
	}
	
	public Node func(){
		return get(0);
	}
	
	public Node param(){
		return get(1);
	}

}
