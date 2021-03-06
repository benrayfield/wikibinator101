/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes.unknownIfNeedThese;

import wikibinator101.wikibinatornodes.AbstractNode;
import wikibinator101.wikibinatornodes.No;
import wikibinator101.wikibinatornodes.Node;
import wikibinator101.wikibinatornodes.Rfpd;

/** This is a kind of (peaceful) "mutually assured destruction" (MAD)
on the level of blockchain-forking or logic forking in the bits of 1 computer,
that it must fork if an error can be derived anywhere in the system,
enforced by the axioms allow using a proof that true==false to prove anything about anything.
<br><br>
If cacheKeyA.func().equals(cacheKeyB.func()) && cacheKeyA.param().equals(cacheKeyB.param())
&& !cacheKeyA.ret().equals(cacheKeyB.ret()) && this node is true THEN implies the opposite TruthValue (yes or no)
about whatever messenger is, so that messenger is both yes and no at once, so messenger is bull,
and the same way those 2 conflicting Rfpds about messenger can imply that any node in the system
is both yes and no at once aka bull.
<br><br>
datastructThatHas3AxiomnodesWhere2OfThemAreSameShapeAndIfTheyHave2DifferentBitValuesThenTheThird
AxiomnodeIsForkeditedToBeOppositeOfItsValueAsWayToSpreadErrors
*/
public class SpreadError_old extends AbstractNode{
	
	//FIXME merge MultiReturnDetector with SpreadError? Or have a MADNode type
	//(lets call it No.java which is not T or F but is something whose axiom value is always no,
	//and Yes.java's axiom value is always yes.
	
	public SpreadError_old(boolean tv, Rfpd cacheKeyA, Rfpd cacheKeyB, No messenger){
		super(tv, cacheKeyA, cacheKeyB, messenger);
	}
	
	public Rfpd cacheKeyA(){
		return (Rfpd)get(0);
	}
	
	public Rfpd cacheKeyB(){
		return (Rfpd)get(1);
	}
	
	/** the mutually assured destruction happens when anything proves No is Yes (in axiom value of No) */
	public No mad(){
		return (No)get(2);
	}

}
