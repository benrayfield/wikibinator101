/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/** This is for efficient bitstrings of any size.
Cbt aka complete binary tree of bits (pair of pair... of T or F).
*/
public class Leaf extends AbstractNode{
	
	public static final Leaf instance = new Leaf();
	
	public boolean isLeaf(){
		return true;
	}

}