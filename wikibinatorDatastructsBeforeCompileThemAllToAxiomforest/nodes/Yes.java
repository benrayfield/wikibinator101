package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/** No, Yes, T, and F, are 4 different things. Yes, T, and F are axiom value TruthValue.yes.
No is axiom value TruthValue.no, or is TruthValue.bull when used
as a peaceful-just-forking mutuallyAssuredDestructionTrigger.
<br><br>
Yes's axiom value is always yes.
<br><br>
When a STEP returns Yes its like a no-op or to say it has nothing to do but doesnt want to return itself for some reason?
*/
public class Yes extends AbstractNode{
	
	public Node step(){
		return this;
	}
	
}