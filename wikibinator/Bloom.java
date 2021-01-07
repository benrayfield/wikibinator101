package wikibinator;

import immutable.util.TruthValue;

/** A binary forest where all paths lead to the same leaf OR a web allowing cycles
such as in wikibinator and occamsfuncer (L x (R x)) equals x forall x
and (L leaf) equals identityFunc and (R leaf) equals leaf
and identityFunc is a certain forest shape (of call pairs) of leaf called on itself in a few specific combos,
so in that case you might want to leaf.setL(identityFunc) and leaf.setR(leaf)
or if each function is represented as a datastruct of a few Blooms deep then setL and setR of other things
to include those extra parts of the datastruct, or just leave it as a forest without cycles
and merge their TruthValues as needed in various combos.
<br><br>
...and each node has 2 bits of mutable value as a TruthValue
which can be unknown, yes, no, or bull.
All nodes start as unknown, and can become yes or no or bull
but if they ever become bull then something has to be backtracked
to avoid being able to prove any bull.
<br><br>
The TruthValues are a math description of what Bloom does
but it will actually be stored in sparse combos of primitive arrays.
*/
public interface Bloom{
	
	public TruthValue v();
	
	/** 31 TruthValues in a long, as binheapIndexing of 1 2 4 8 16 TruthValues at depths 0..4 */
	public long v31();
	
	/** get to depth n, where the last 4 depth are a v31(). Returns long[1<<(n-4)] FIXME is that offby1. */
	public long[] vn(int n);
	TODO do i want a data format where half of a long is a binheapIndex and the other half is a v15 (which can store a byte)?
	In that way, each long could put 15 TruthValues (its 8 deepest could be the bits of a byte) in a space of around a gigabyte.
	Or 2 longs could put an int16 somewhere in an exabyte space.
	
	
	
	/** pair of blooms, which is not the same as the pair function in lambdas. This is lower level.
	Creates or finds a Bloom whose l() is this and whose r() is b,
	and if such a Bloom is found then it may have an existing TruthValue other than unknown,
	else it starts as unknown but its 2 childs are recursively the TruthValues in this and the param b.
	*/
	public Bloom p(Bloom b);
	
	//public boolean isLeaf();
	
	public default Bloom l(){ return g(2L); }

	public default Bloom r() { return g(3L); }
	
	/* This allows creating cycles. See comment of Bloom.java about "(L leaf) equals identityFunc and (R leaf) equals leaf" *
	public void setG(Bloom l);
	/* This allows creating cycles. See comment of Bloom.java about "(L leaf) equals identityFunc and (R leaf) equals leaf" *
	public void setR(Bloom r);
	*/
	public void put(long binheapIndex, Bloom b);/*{
		TODO default implementation gets g(someTransformOf(binheapIndex)) then calls putL or putR on it?
	}*/
	
	/** Self is at 1L. L child of index x is 2*x. R child of index x is at 2*x+1. */
	public Bloom g(long binheapIndex);
	
	/** If incoming then writes my TruthValues. If outgoing then writes b's TruthValues.
	If incoming&outgoing then from depth 0 to maxDepth, all TruthValues here and in b will equal.
	If maxDepth is 0 then only joins v() with b.v().
	If maxDepth is 1 then also joins l().v() with b.l().v() and r().v() with b.r().v().
	Each depth has up to twice as much data at it to merge
	but may be stored sparsely so large ranges that are all TruthValue.unknown may be skipped as optimization.
	*/
	public void join(Bloom b, int maxDepth, boolean incoming, boolean outgoing);

	/** replace v() with v().join(x). This is the base case of join(Bloom, int, true incoming, TruthValue.unknown outgoing),
	at least in abstract math, but in practice TruthValues will be stored in sparse combos of primitive arrays.
	*/
	public void in(TruthValue x);
	
	public default void in(Bloom b, int maxDepth){
		join(b, maxDepth, true, false);
	}
	
	public default void out(Bloom b, int maxDepth){
		join(b, maxDepth, false, true);
	}
	
	public default void sync(Bloom b, int maxDepth){
		join(b, maxDepth, true, true);
	}
	
	/** normally returns unknown, since thats an expensive calculation if its not somehow cached,
	and caching that increases bigO in some cases, in theory.
	*
	public default TruthValue allValuesBelowMeEqual(){ return TruthValue.unknown; }
	*/


}
