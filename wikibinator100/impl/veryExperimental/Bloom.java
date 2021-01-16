package wikibinator100.impl.veryExperimental;

import axiomforest.TruthValue;

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
	
	/*TODO no nondeterminism for now, and just get debugStepInto and debugStepOver working in bloom, of wikibinator
	(aka where wikiState is (lazig (S I I) (S I I)))?
	Just the ability for many people and computers to share <return func param> (RFP) cache would be big progress.
	TODO need the ability to replace java etc's == operator with just viewing the TruthValues in self's childs recursively
	without knowing which of those childs equal eachother or not. Use the fact that if x.l==y.l and x.r==y.r then x==y,
	and some small constant depth to combinator that to generate the relevant statements (in terms of their parent's TruthValue)
	of are they equal or not or unknown... Build callquad-like (as in occamsfuncer) implementation of wikibinator in Bloom that way.
	Optimize later.
	Use model of computing where an axiom sees all 2^(n+1)-1 TruthValues of a node x and n depth below it (offby1error?)
	and outputs a map of the integers in range 0..(2^(n+1)-1) into that same range, allowing duplicate output values,
	and wherever its output integer, copy that binary forest node to those 0 or more places within the n depth,
	then OR the TruthValues with eachother, and it better NEVER derive any TruthValue.bull.
	??? Is that what I want?
	*/
	
	
	
	/*FIXME... it shouldnt need to know this at the VM level. I'll put in optimizations
	to put in solid blocks of 1s and 0s if needed, or whatever datastruct, nomatter how big it makes it,
	but the core has to be simple. You should be able to pair any node with any node and generate a
	SPECIFIC yes/1 or no/0 from it (even if it costs infinite compute time and memory to do so).
	Fortunately the universe is infinite, but before such possibilities are explored, compiled to CPUs and GPUs.
	*/
	
	/** Axioms are only called on EVEN bloom nodes (FIXME or should it be only ODD... would work either way but must choose one design),
	which can of course act on ODD bloom nodes by looking 1 deeper within
	the behaviors of the axiom. An example of an axiom is to look in 2 certain position relative to self node
	and if one of them equals a certain 256 bits then hash the other bits and write the sha3_256 of those bits into a third place,
	or an example of an axiom is to find some numbers and add them and write that into another place,
	or could emulate any opcodes of any system, binary blobs, neuralnets, GPU, music tools, etc, as long as the math is strict.
	<br><br>
	x.odd()!=x.l().odd(). x.l().odd()==x.r().odd().
	<br><br>
	With this, you dont need to know height in binary forest, as it might be infinitely deep
	andOr have cycles (like it could encode mandelbrot fractal to infinite depth,
	though probably not efficiently the deeper it gets). 
	<br><br>
	This might be needed to emulate 3-way trees and to prove it is or is not an internal node of a 3-way-tree
	vs a 3-way-tree node such as x.l.l and x.l.r and x.r.l might be the 3 childs, and x.r.r is all TruthValue.no
	or x.r.r equals x, or any way of you dont have to care about x.r.r's value if you're using it as a 3-way-tree.
	The purpose of 3-way-trees is if you want the ability to "do a function call of x on y" then you do <x y leaf>
	for any x and y but constraints only apply to leaf which is where "internal calculations of a lambda VM" happen,
	and maybe you would have a use for the fourth child if thats the return value, or something,
	but the point is, it needs at least a 3-way tree, not a 2-way, so without this isEven() func,
	it would be unable to prove that since all nodes start as TruthValue.unknown.
	Just alternate isEven at each next depth. Dont need to store it except maybe to have 2 subclasses of Bloom
	or a final boolean var in them.
	*
	public boolean odd();
	*/
	
	public TruthValue v();
	
	/** 31 TruthValues in a long, as binheapIndexing of 1 2 4 8 16 TruthValues at depths 0..4 */
	public default long v4(){
		//TODO optimize theres some overlap between v1 v3 v7 v15 and v31. wont break anything but is inefficient.
		return (v3()<<32)|(l().v3()<<16)|r().v3();
	}
	
	public default long v3(){
		//TODO optimize theres some overlap between v1 v3 v7 v15 and v31. wont break anything but is inefficient.
		return (v2()<<16)|(l().v2()<<8)|r().v2();
	}
	
	public default long v2(){
		//TODO optimize theres some overlap between v1 v3 v7 v15 and v31. wont break anything but is inefficient.
		return (v1()<<8)|(l().v1()<<4)|r().v1();
	}
	
	public default long v1(){
		//TODO optimize theres some overlap between v1 v3 v7 v15 and v31. wont break anything but is inefficient.
		return (v0()<<4)|(l().v0()<<2)|r().v0();
	}
	
	public default long v0(){
		//TODO optimize theres some overlap between v1 v3 v7 v15 and v31. wont break anything but is inefficient.
		switch(v()){
		case unknown: return 0L;
		case no: return 1L;
		case yes: return 2L;
		case bull: return 3L;
		default: throw new RuntimeException("This cant happen, but java doesnt know that.");
		}
	}
	
	/** get to depth n, where the last 4 depth are a v31(). Returns long[1<<(n-4)] FIXME is that offby1. */
	public default long[] vn(int n){
		if(n <= 4){
			switch(n){
			case 0: return new long[]{v0()};
			case 1: return new long[]{v1()};
			case 2: return new long[]{v2()};
			case 3: return new long[]{v3()};
			case 4: return new long[]{v4()};
			default: throw new RuntimeException("n="+n);
			}
		}
		long[] ret = new long[1<<(n-4)];
		vn_internal(this, ret, 1, n);
		return ret;
	}
	
	static void vn_internal(Bloom b, long[] ret, int i, int recurse){
		if(recurse > 0){
			vn_internal(b.l(), ret, i*2, recurse-1);
			vn_internal(b.r(), ret, i*2+1, recurse-1);
		}
		ret[i] = b.v4();
	}
	
	/*TODO do i want a data format where half of a long is a binheapIndex and the other half is a v15 (which can store a byte)?
	In that way, each long could put 15 TruthValues (its 8 deepest could be the bits of a byte) in a space of around a gigabyte.
	Or 2 longs could put an int16 somewhere in an exabyte space.
	*/
	
	
	
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

