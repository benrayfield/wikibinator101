/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

/** rfpd aka <returnVal func param isDeterministic> */ 
public class Rfpd extends AbstractNode{
	
	/** isDeterministic is part of the Node */
	public Rfpd(boolean tv, Node ret, Node func, Node param){
		super(tv, ret, func, param);
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
