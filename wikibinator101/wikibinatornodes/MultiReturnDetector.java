/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

/** Implies No is TruthValue.yes if same lambda call has 2 different returnValues is detected.
<br><br>
If cacheKeyA.func().equals(cacheKeyB.func()) && cacheKeyA.param().equals(cacheKeyB.param())
&& !cacheKeyA.ret().equals(cacheKeyB.ret()) && this node is true THEN implies the opposite TruthValue (yes or no)
about whatever messenger is, so that messenger is both yes and no at once, so messenger is bull,
and the same way those 2 conflicting Rfpds about messenger can imply that any node in the system
is both yes and no at once aka bull.
<br><br>
datastructThatHas3AxiomnodesWhere2OfThemAreSameShapeAndIfTheyHave2DifferentBitValuesThenTheThird
AxiomnodeIsForkeditedToBeOppositeOfItsValueAsWayToSpreadErrors
<br><br>
datastructThatHasARFPDAndAnotherRAndItLeadsToTheClaimThatTheOtherReturn(R)InARFPD
IsFalseIfRFPDIsTrueCuzTheresMaxOneReturnValuePerFuncParam
*/
public class MultiReturnDetector extends AbstractNode{
	
	public MultiReturnDetector(boolean tv, Rfpd cacheKeyA, Rfpd cacheKeyB, No mutuallyAssuredDestructionTrigger){
		super(tv, cacheKeyA, cacheKeyB, mutuallyAssuredDestructionTrigger);
	}
	
	public Rfpd cacheKeyA(){
		return (Rfpd)get(0);
	}
	
	public Rfpd cacheKeyB(){
		return (Rfpd)get(1);
	}
	
	/** the mutually assured destruction happens when anything proves No is Yes (in axiom value of No) */
	public No mutuallyAssuredDestructionTrigger(){
		return (No)get(2);
	}

}
