/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;
import java.util.AbstractList;
import java.util.Iterator;

import axiomforest.observe.Λ;
import axiomforest.superposition.λ;
import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

/** <leaf x y> for any x and y, regardless if x is yes or no, and regardless if y is yes or no,
the <leaf x y> is yes, BUT any bull (simultaneous yes and no of the same node)
of course triggers MutuallyAssuredDestructionIf of the whole "multiverse branch",
among those who include MutuallyAssuredDestruction related axioms.
A Join should never be the cause of that. You can make linkedlists, treemaps,
and a variety of other lisp-like datastructs with it, containing any Node as x andOr y,
but the v child only necessarily allows that if v chCild is leaf,
and if you STEP from it, the v child of what that returns is usually
not leaf (UPDATE: I'm undecided if joins should always step to themself and have to start from
GeneratedAxiom or Believe of GeneratedAxiom, VERY IMPORTANT DESIGN CHOICE RELATED TO GODEL INCOMPLETENESS HERE)
as its more like vmState of the internal workings of a calculation.
*/
public abstract class Join extends AbstractNode{
	
	public Join(Node x, Node y){
		super(x,y);
	}
	
	public Node step(){
		throw new RuntimeException("TODO which of the node types (datastructs in v child) to create might depend on the 2 nodes x and y OR maybe it should only do that if you already have some non-leaf v such as Believe of the Wikibinator step as a GeneratedAxiom?");
	}

}