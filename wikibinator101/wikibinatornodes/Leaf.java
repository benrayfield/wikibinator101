/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

public class Leaf extends AbstractNode{
	
	public static final Leaf instance = new Leaf(true);
	
	public Leaf(boolean tv){
		super(tv);
	}
	
	public boolean isLeaf(){
		return true;
	}

}