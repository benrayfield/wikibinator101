package wikibinator101.wikibinatornodes.unknownIfNeedThese;

import wikibinator101.wikibinatornodes.AbstractNode;
import wikibinator101.wikibinatornodes.Node;

/** Believe vs RefuseAllBelieve vs TODO various subsets could be defined (in turing complete ways) for each.
For skeptics. An axiom that prevents any Believe instances from existing.
*/
public class RefuseAllBelieveExceptTheBelieveInRefusingAllBelieve extends AbstractNode{
	
	public RefuseAllBelieveExceptTheBelieveInRefusingAllBelieve(boolean tv, Believe requestNotToLookForEvidenceOfCertainStatement){
		super(tv, requestNotToLookForEvidenceOfCertainStatement);
	}
	
	public Believe requestNotToLookForEvidenceOfCertainStatement(){
		return (Believe)get(0);
	}
	
	public Node step(){
		throw new RuntimeException("Return the TruthValue.yes form of No aka trigger MutuallyAssuredDestructionIf, if any Believe is observed to be TruthValue.yes (or TruthValue.bull).");
	}

}
