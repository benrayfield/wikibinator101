/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

public class HaltedLambda extends AbstractNode{
	
	public HaltedLambda(boolean tv, Node func, Node param){
		super(tv,func,param);
	}
	
	public Node func(){
		return get(0);
	}
	
	public Node param(){
		return get(1);
	}

}
