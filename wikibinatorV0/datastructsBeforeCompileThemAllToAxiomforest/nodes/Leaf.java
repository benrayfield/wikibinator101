/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

public class Leaf extends AbstractNode{
	
	public static final Leaf instance = new Leaf();
	
	public boolean isLeaf(){
		return true;
	}

}