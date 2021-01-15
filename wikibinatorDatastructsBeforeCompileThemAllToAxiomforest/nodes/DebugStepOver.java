/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/** datastructThatSomehowDoesDebugstepoverUsingSomethingLike2CallquadsButTodoWhich2SpecificDatastructs */
public class DebugStepOver extends AbstractNode{
	
	/** If cacheKey's func and param matches the func and param the call wants to know returnVal for,
	then this IMPLIES far ahead in the calculation aka debugStepOver it instead of debugStepInto,
	but if its not a match then this IMPLIES (todo choose a design,
	either debugStepInto or implies some constant thats always true).
	*/
	public DebugStepOver(Callquad call, Rfpd cacheKey){
		super(call, cacheKey);
	}
	
	public Callquad call(){
		return (Callquad)get(0);
	}
	
	public Rfpd cacheKey(){
		return (Rfpd)get(1);
	}

}
