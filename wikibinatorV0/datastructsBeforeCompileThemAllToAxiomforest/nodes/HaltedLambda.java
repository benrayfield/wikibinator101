/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

public class HaltedLambda extends AbstractNode{
	
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
