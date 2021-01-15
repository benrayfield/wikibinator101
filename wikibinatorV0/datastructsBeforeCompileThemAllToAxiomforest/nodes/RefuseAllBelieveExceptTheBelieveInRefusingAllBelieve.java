package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

/** Believe vs RefuseAllBelieve vs TODO various subsets could be defined (in turing complete ways) for each.
For skeptics. An axiom that prevents any Believe instances from existing.
*/
public class RefuseAllBelieveExceptTheBelieveInRefusingAllBelieve extends AbstractNode{
	
	public RefuseAllBelieveExceptTheBelieveInRefusingAllBelieve(Believe requestNotToLookForEvidenceOfCertainStatement){
		super(requestNotToLookForEvidenceOfCertainStatement);
	}
	
	public Believe requestNotToLookForEvidenceOfCertainStatement(){
		return (Believe)get(0);
	}
	
	public Node step(){
		throw new RuntimeException("Return the TruthValue.yes form of No aka trigger MutuallyAssuredDestructionIf, if any Believe is observed to be TruthValue.yes (or TruthValue.bull).");
	}

}
