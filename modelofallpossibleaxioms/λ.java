package modelofallpossibleaxioms;

/** immuable trinary forest node where all paths lead to leaf */
public interface λ{
	
	/** isLeaf */
	public boolean a();
	
	public λ v();
	
	public λ l();
	
	public λ r();
	
	/** by forest shape */
	public boolean equals(Object o);
	
	/** by trinary forest shape. not part of the axioms or datastruct but needed by java maps etc. */
	public int hashCode();

	/** same as SetOfAxioms.node(SetOfAxioms.leaf(), this, r);
	create or find λ node where node.v().a() aka isLeaf and node.l().equals(this) and node.r().equals(r) *
	public λ p(λ r);
	*/

}