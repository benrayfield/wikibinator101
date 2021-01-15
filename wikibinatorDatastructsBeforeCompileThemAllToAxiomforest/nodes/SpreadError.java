/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

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
public class SpreadError extends AbstractNode{
	
	public SpreadError(Rfpd cacheKeyA, Rfpd cacheKeyB, Node messenger){
		super(cacheKeyA, cacheKeyB, messenger);
	}
	
	public Rfpd cacheKeyA(){
		return (Rfpd)get(0);
	}
	
	public Rfpd cacheKeyB(){
		return (Rfpd)get(1);
	}

}
