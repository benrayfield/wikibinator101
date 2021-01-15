package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/** No, Yes, T, and F, are 4 different things. Yes, T, and F are axiom value TruthValue.yes.
No is axiom value TruthValue.no, or is TruthValue.bull when used
as a peaceful-just-forking mutuallyAssuredDestructionTrigger.
<br><br>
No's axiom value is always no.
If this is implied to be yes as axiom value,
then a "mutually assured destruction" (at blockchain level, or logic in 1 computer) forking happens.
<br><br>
When a STEP returns No, its like a no-op if the No's axiom value is TruthValue.no (Λ has a yes/no bit,
always observed, while λ's axiom value is TruthValue.unknown).
If STEP returns a No whose TruthValue is TruthValue.yes (then a No of TruthValue.bull comes soon after that)
then MutuallyAssuredDestructionIf of No and any target Node can spread the error exponentially
as the web of many MutuallyAssuredDestructionIf allow eachother to activate,
motivating near everyone in the network to work together
to not allow any set of axioms that can prove yes==no aka bull.
*/
public class No extends AbstractNode{
	
	public Node step(){
		return this;
	}
}