/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

/** This is for efficient bitstrings of any size.
Cbt aka complete binary tree of bits (pair of pair... of T or F).
*/
public class Cbt extends AbstractNode{
	
	public Cbt(TruthValue tv){
		super(tv); //TODO more params
	}
	
	public Node step(){
		return this;
	}

}