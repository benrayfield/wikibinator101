/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/** rfpd aka <returnVal func param isDeterministic> */ 
public class Rfpd extends AbstractNode{
	
	/** isDeterministic is part of the Node */
	public Rfpd(Node ret, Node func, Node param){
		super(ret, func, param);
	}
	
	public Node ret(){
		return get(0);
	}
	
	public Node func(){
		return get(1);
	}
	
	public Node param(){
		return get(2);
	}
	
	public Node step(){
		return this;
	}

}
