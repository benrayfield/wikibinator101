package wikibinatorV0.impl.veryExperimental;

import axiomforest.TruthValue;

/** This is an attempt to reduce the number of tensorND from tensor4D to tensor2D,
using statements like: "(S I I y) = y" where (S I I y) not isHalted and yes willHalt,
and <y (S I I y)> yes twoChildReturnValuesEqual.
Every possible statement is a forest of nodes which each have 2 child nodes
and each node has a TruthValue (or simpler, just a bit, it is certainly true or false,
but we might not know it yet or ever as it might cost infinite memory and time to know)...
each node has these 3 TruthValues: isHalted, willHalt, and twoChildReturnValuesEqual.
Each node actually, in abstract math, has 3 childs, including a pointer to a wikiState (any function),
but that doesnt fit well with merkle ids so would have to be figured out after hashing
similar to the 3 TruthValues have to be figured out after hashing if ever figured out.
THEREFORE...
func_param (including hash of it) is primaryKey, and isHalted_willHalt_twoChildReturnValuesEqual_wikiState is its value
(a TruthValue for each bit in the dimIndex/globalId/etc of those 4 things, in abstract math).
...no... wikiState is part of primaryKey: func_param_wikiState, BUT it cant be efficiently merkle hashed that way
since the normal way to compute it is to converge gradually toward agreeement of the possible behaviors of wikiState,
basically exploring the space of all possible functions without naming them by hash/globalId.
If there is only 2 wikiStates, that being (S I I (S I I)) for determinism mode and theOnlyOtherWikiState
being whatever the world converges to together, then...
<br><br>
func_param_bitIsDeterministicVsAllowCallingWiki is primaryKey,
and value is 3 TruthValues as isHalted_willHalt_twoChildReturnValuesEqual.
That can work. Try that...
Or could think of wikiState like a kind of salt, just a random number
that identifies a cluster of compatible blockchain/actuallyAWebNotAChain parts,
or you might even name it by a string which is a number if translated by utf8.
So... primaryKey is func_param_specificFunctionORSaltAsWikiState, and each globalId tells if its meant as salt or not,
and value is 3 TruthValues as isHalted_willHalt_twoChildReturnValuesEqual. And maybe also an isLeaf TruthValue.
<br><br>
Wikibinator already has 1 byte (the "op") of cache per node. Concat to that 1 more byte
that has 4 TruthValues: isHalted, willHalt, twoChildReturnValuesEqual, and isLeaf.
Also, split the op byte into 8 TruthValues, so thats 3 bytes total.
Its all cache except isLeaf or not isLeaf and the 3 childs (func param specificFunctionORSaltAsWikiState).
Its a 3-way forest where all paths lead to leaf, but the space of possibilities needs alot of caching to navigate effectively.
*/
public interface fn2_exploringPossibleInterface{
	
	/*
	"TODO read comment of this class"
	
	TODO put all the TruthValues and opIfNonzero etc into an int per fn2_exploringPossibleInterface
	so the state of the system is a map of 3-way-forest-node to <int and nullable Blob and Compiled.java instance>
	
	
	
	** or should there be a TruthValue for each of 8 bits of its op? This is the op in SimpleVM. *
	public TruthValue opIs(byte possibleOp);
	*
	
	FIXME I'm using op value of 0 to mean more than 6 params. But now that wikiState is a third child (even if only a salt)
	that means that a whole extra bit in the op byte is available as its no longer used by wikiState being
	pureDeterminism vs allNondeterministicWikiStates, so TODO put isKnownVsUnknown in that bit, or something like that.
	*/
	
	/** If op is 0 then it means TruthValue.unknown for every
	possible question about the op (such as TruthValue opIs(byte possibleOp)).
	If op is nonzero, then it means that is the op, which can be used without further statistical thought in SimpleVM
	in a switch(byte op) optimization of the universalFunc.
	*/
	public byte opIfNonzero();
	
	public TruthValue isTheLeaf();
	
	public TruthValue isHalted();
	
	public TruthValue willHalt();
	
	/** Forall x forall y, if not x.willHalt and not y.willHalt,
	then x equals y (not measurable by OcfnUtil.equals() etc, but at transfinite cardinality they equal),
	and if 1 willHalt and the other not willHalt, they not equal (again, transfinite cardinality),
	and if both halt then they equal (measurable by OcfnUtil.equals() etc)
	IFF their forest of binary call pairs equals (is same forest shape).
	*/
	public TruthValue twoChildReturnValuesEqual();
	
	/** A node is salt if its globalId says it is salt OR if its an invalid globalId such as 256 random bits
	that are claimed to not be salt.
	*/
	public TruthValue isSalt();
		
	public fn2_exploringPossibleInterface L();
	
	public fn2_exploringPossibleInterface R();
	
	//resists merkle-compatibility but is tensor4D compatible: public fn2_exploringPossibleInterface wikiState();
	public fn2_exploringPossibleInterface specificFunctionORSaltAsWikiState();

}
