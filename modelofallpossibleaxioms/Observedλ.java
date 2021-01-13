/** Ben F Rayfield offers this software opensource MIT license */
package modelofallpossibleaxioms;

/** same as modelofallpossibleaxioms.λ but a layer above that with an observed TruthValue.yes or TruthValue.no
with each of them and those TruthValues are part of the forest shape (aka affect merkle ids).
Since any trinaryForestNodes x and y, if both are true, imply <trinaryForestLeaf x y> is true,
Or TODO expand that so that <trinaryForestLeaf x y> is true for all x and y regardless of the truth or falseness of x and y???
... This might create a problem for the selfreference fix I'm trying to do where
all possible statements in the merkle forest must be viewable by a halted lambda as idMaker
so (idMaker someLazyEvaledFormOf_aWrongStatement) -> cbt its id, and as long as the wrong statement
is marked as TruthValue.no its a true statement that its TruthValue is no so can be wrapped that way, in theory.
All nodes should have a specific yes or no attached to them the first time they're observed
since SetOfAxioms.joiner.apply(λ,λ)->λ generates the YES statement <trinaryForestLeaf x y>,
and getAnyInSet(SetOfAxioms.impliesYes,Random).apply(<trinaryForestLeaf x y>)->λ generates a YES statement,
and getAnyInSet(SetOfAxioms.impliesNo,Random).apply(<trinaryForestLeaf x y>)->λ generates a NO statement,
and any recursions in the computing of lambdas such as callquad.stack and callquad.cacheKey etc (in trinary form)
will be done in terms of those axioms (or optimizations of them that dont actually call those slow axioms,
would themselves be UnaryOperator<λ> which are axioms, so an optimization of an axiom
(such as by lazycl to lwjgl opencl/gpu optimize matrix multiply, neuralnets, and other number crunching) is an axiom
and can go in the same SetOfAxioms. An optimization of an axiom is an axiom.
*/
public interface Observedλ{
	
	/** isLeaf */
	public boolean a();
	
	/** TruthValue.yes or TruthValue.no */
	public boolean tv();
	
	public Observedλ v();
	
	public Observedλ l();
	
	public Observedλ r();
	
	/** same forest shape but without the boolean tv.
	Old?... WARNING: may duplicate the whole forest on the first call but cache it probably.
		TODO fix this by Observedλ automatically having the λ and the bit as fields.
	Hash ids can exist separately for λ vs Observedλ but normally (if Observedλ works out, TODO?)
	will only have hash ids for Observedλ.
	*/
	public λ shapeOnly();
	
	/** See speed warning (and the TODO how to fix it) in comment of unobserved() */
	public default boolean conflictsWithLocalBitOf(Observedλ x){
		return this.shapeOnly().equals(x.shapeOnly()) && this.tv()!=x.tv();
	}
	
	/** by 3+1bit forest shape including boolean tv (TruthValue.yes or TruthValue.no as part of forest shape). */
	public boolean equals(Object o);
	
	/** by 3+1bit forest shape including boolean tv (TruthValue.yes or TruthValue.no as part of forest shape). */
	public int hashCode();
	
	/** Returns the one leaf which all paths lead to.
	This does not depend on which instance λ its called from except they may optimize it different ways.
	*/
	public Observedλ leaf();
	
	/** This could have been a static func, but it seems better to put it here than in (ToIntFunction<λ>)VM.
	This does not depend on which instance λ its called from except they may optimize it different ways.
	All trinary forest nodes are valid, but most of them will be ignored aka you wont find,
	or would be very very hard to find, some Coloredλ returned from next whose λ is that one,
	which is cuz λ.v is "vm state" that only proceeds in certain ways,
	while the other 2 childs (λ.l and λ.r) can be anything when λ.v is leaf,
	which is the way to start a lambda call of l on r.
	*/
	public Observedλ node(boolean tv, Observedλ v, Observedλ l, Observedλ r);
	
	/** lazy call l on r (params of this func) */
	public default Observedλ node(Observedλ l, Observedλ r){
		return node(true, leaf(), l, r);
	}
	
	/** lazy call this on param */
	public default Observedλ p(Observedλ param){
		return node(this,param);
	}

	/** same as SetOfAxioms.node(SetOfAxioms.leaf(), this, r);
	create or find λ node where node.v().a() aka isLeaf and node.l().equals(this) and node.r().equals(r) *
	public λ p(λ r);
	*/

}