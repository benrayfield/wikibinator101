package wikibinator;
import static mutable.util.Lg.*;
import immutable.util.TruthValue;

/** (long)λ.header() is made of TruthValues of 2 bits each,
maybe storing the YES bits in the high 32 bits of a long and the NO bits in the low 32 bits.
TODO try to fit it in 32 or 48 bits so theres more bits left in id256 for secureHash
(and if its not a secureHash then its up to 128 bits of literal cbt).
<br><br>
Similar to immutable.occamsfuncer.impl.optimize.id.IdField.
<br><br>
This defines 32 TruthValues which together fit in a long.
The other 192 bits are either a secureHash (merkle forest) or 1..128 bits of literal cbt.
For higher security you can use for example sha3_256 or sha3_384 with these same header TruthValues
and maybe include 64 bits of bize (bitstring size) andOr other things you might want to fit in 512 bits.
192 bits means you would have to create and remember about 2^96 nodes before finding 1 duplicate,
which is maybe within the abilities of the strongest supercomputers as of Y2021
BUT it would be very very expensive which there are far more valuable calculations to spend that on,
or remember a random set of 2^64 of them 2^64 times since either way that multiplies to 2^192...
AND even if they do find a few duplicates, its squared times that hard to find an id
thats the same as a specific id such as a specific function that many people and computers together use.
*/
public enum HeaderBits{
	
	/** If isDeterministic then wikiState == (lazig (S I I) (S I I))
	which is a lambda that infloops for every possible param.
	If not isDeterministic then lambdaState is some possible function that
	is probably not completely defined as it will be defined by the accumulation of
	RFPDs aka <returnValue func param isDeterministic>
	or RFPWs aka <returnValue func param wikiState> where wikiState may be a specific lambda
	or may be a salt (isSalt) whose child pointers are made of TruthValue.unknown
	and it will probably never be known exactly what function the wikiState is
	or if theres many or just 1 of them, depending if they all fit together consistently or not.
	The main nondeterministic WikiState is defined by many peoples and computers
	shared beliefs about it in the form of basically <returnValue func param aSymbolRepresentingTheUniverse>,
	though in the far more expensive math of Verse.java which is many <ret func param wikiState>-->TruthValue,
	sparse selections from all possible wikiStates are considered in many sparse combos
	in how they may align to eachother. In practice we will probably have just 2 wikiStates
	which are (lazig (S I I) (S I I)) and aSymbolRepresentingTheUniverse.
	Its (lazig (S I I) (S I I)) if isDeterministic else its aSymbolRepresentingTheUniverse,
	but I'm leaving that open for possible future expansion of considering multiple incompatible forks
	of wikiState. aSymbolRepresentingTheUniverse aka theMainWikiState.
	*/
	isDeterministic(1, true),
	
	//FIXME should isDeterministic and isTheMainWikiState be part of the merkle forest?
			
	/** If !isDeterministic then either it is the main wiki state (aSymbolRepresentingTheUniverse)
	or it is something related to "leaving that open for possible future expansion of considering
	multiple incompatible forks of wikiState" (see comment of isDeterministic)
	in which case this isTheMainWikiState TruthValue would be obsolete.
	UPDATE: renamed isTheMainWikiState to myWikiStateIsTheMainWikiState cuz
	wikiState is like a child (parallel to l() and r() but since its often incompletely defined
	its often impractical to include it in the merkle childs, UNLESS its an isSalt
	in which case you cant get its l() and r(), though you can still get the l() and r() of the wiki opcode
	which is a way to encapsulate wikiState while having the same globalId of the wiki opcode
	for all possible wikiStates so that when the gradually expanding and adjustingForConsistency
	wikiState(s) change (toward some combo of RFPWs) that you dont have to rehash everything which calls it.
	If isDeterministic then wikiState is (lazig (S I I) (S I I)) so its 1 hash to 1 deterministic behavior.
	If myWikiStateIsTheMainWikiState then !isDeterministic. These TruthValues are about individual λ's.
	*/
	myWikiStateIsTheMainWikiState(1, true),
	
	/** This is one of the first few bits so that literals cant be designed to start with the same first 128 bits
	as a hash id cuz that would make treemaps (trie-like, skipping branches where theres only 1 child) slower.
	<br><br>
	If true, then globalId contains 1, 2, 4, 8, 16, 32, 64, or 128 bits of literal cbt.
	If false, then it contains 192 bits (TODO can it be a little more? cut down on header size?) of hash
	such as the first or last 192 bits of sha3_224 or of sha3_256 (TODO choose a default).
	Which of those it is depends on lowBitsOfHeight. Each cbt twice as big as the last is at height+2,
	and T and F are the 2 possible cbts of 1 bit each. There is no cbt of 0 bits, but T is the empty bitstring,
	similar to (pair F T) is the bitstring 0 and (pair T T) is the bitstring 1
	and (pair (pair T F) (T T)) is the bitstring 101 and (pair (pair T F) (T F)) is the bitstring 10.
	Literal does not specify how to interpret the cbt (as bitstring or general cbt
	or just a bunch of pairs and Ts and Fs). That depends on the functions which take cbts as params.
	*/
	isLiteral(1, true),
	
	/** TODO remove this? I'm undecided if will keep this, since isDeterministic might be enough.
	A node is salt if its globalId says it is salt OR if isFake aka its an invalid globalId
	such as 256 random bits that are claimed to not be salt.
	aSymbolRepresentingTheUniverse (see comment of isDeterministic) is a globalId made of salt,
	such as maybe its hash bits are arbitrarily defined to be all 1s.
	*/
	isSalt(1, true),
	
	/** an optimization to avoid storing (pair x) in ((pair x) y) aka (pair x y)
	and to only store x, y, and (pair x y), but be able to generate the id of (pair x) where
	hashing that id with the id of y generates the id of (pair x y).
	*/
	leftIsThePairFunc(1, true),
	
	/** For possible future expansion to use debutStepInto vs debugStepOver similar to occamsfuncer callquad
	which has func param stack cacheKey and isParentsFunc. But wikibinator.Bloom has a different way of doing it.
	*/
	hasStackfunc(1, true),
	
	/** For possible future expansion to use debutStepInto vs debugStepOver similar to occamsfuncer callquad
	which has func param stack cacheKey and isParentsFunc. But wikibinator.Bloom has a different way of doing it.
	*/
	hasStackparam(1, true),
	
	/** For possible future expansion to use debutStepInto vs debugStepOver similar to occamsfuncer callquad
	which has func param stack cacheKey and isParentsFunc. But wikibinator.Bloom has a different way of doing it.
	*/
	hasCachekey(1, true),
	
	/** Self and this many curries viewed by λ.L().isLeaf() .. λ.L().L().L().L().L().L().isLeaf().
	Knowing that allows recursing less deep to know what opcode to do.
	<br><br>
	Usually you can only know x.isLeaf or !x.isLeaf if x.isHalted.
	*/
	curriesAreLeaf(7, true),
	
	/** If true, then there are more digits of the height integer than fits in lowBitsOfHeight */
	isHigher(1, true),
	
	/** If !isHigher then this is the low n bits of the height integer */
	lowBitsOfHeight(7, true),
	
	/** This is how much space in header is unused and is reserved for future expansion.
	Leave these as TruthValue.unknown.
	<br><br>
	FIXME you cant hash before observing its bits. Are these TruthValues (2 bits each) in the
	hash or not? and if they're in the hash, are they 1 bit each as they cant be unknown or bull?)
	*/
	reservedForFutureExpansion(2, false),
	
	/** True if this is a fake node such as random bits made up pretending to be a globalId
	or any secureHash id which can reach those. False if have verified all the way down to leaf
	or have found some other way to prove its a forest shape where all paths lead to leaf.
	TruthValue.unknown is especially useful here since this is a very expensive thing to prove or disprove.
	Once its proved for a node, it spreads to any node which can reach it by λ.headerOreq.
	*/
	isFake(1, false),
	
	/** canBeHalted(x) = (x.l.isHalted & x.r.isHalted &
	(x.isLeaf | x.l.isLeaf | x.l.l.isLeaf | x.l.l.l.isLeaf | x.l.l.l.l.isLeaf | x.l.l.l.l.l.isLeaf)).
	If !canBeHalted(x) then !x.isHalted, but if canBeHalted(x) then x.isHalted or !x.isHalted,
	cuz those childs might have changed to make canBeHalted(parent) true but parent has not been updated yet. 
	*/
	isHalted(1, false),
	
	/** a binary blob of powOf2 number of bits, and can often (in theory, TODO) be stored in primitive array.
	Is a complete binary tree of bits such as (pair (pair T F) (pair T T)).
	*/
	isCbt(1, false),
	
	/** isCbt and contains T. A bitstring is a cbt padded with a 1 then 0s until the next powOf2,
	viewing whats before that last 1 as the contents of the bitstring.
	The id256 does not contain the length but for bitstrings up to about 1 exabit (TODO get exact number)
	it does contain the height so you know its max size to a precision of a certain powOf2,
	and you can use the RFPD system <func param return isDeterministic> cache entries
	to store its exact bit length in a cbt64 aka a long, something like <derivedLengthFunction aBitstring itsLen T>
	or <derivedLengthFunction aBitstring itsLen F> or if RFPW <derivedLengthFunction aBitstring itsLen wikiState>.
	aka <derivedLengthFunction aBitstring itsLen (lazig (S I I) (S I I))>
	or <derivedLengthFunction aBitstring itsLen theMainWikiState>.
	*/
	isBitstring(1, false),
	
	returnValOfLeftChildEqualsReturnValOfRightChild(1, false),
	
	/** true if left child is same forest shape as right child */
	leftAndRightForestShapesEqual(1, false),
	
	/** TruthValue.unknown is especially useful here since in some cases it costs
	infinite compute cycles and memory to know if a certain lambda call halts or not,
	but other times it can be known quickly, and everywhere between.
	*/
	willHalt(1, false);
	
	/** number of 2-bit TruthValues */
	public final int tvs;
	
	public final boolean isPartOfMerkleForest;
	
	HeaderBits(int tvs, boolean isPartOfMerkleForest){
		this.tvs = tvs;
		this.isPartOfMerkleForest = isPartOfMerkleForest;
	}
	
	public static void main(String[] args){
		lg(HeaderBits.class.getName()+":");
		int tvSum = 0;
		for(HeaderBits h : HeaderBits.values()){
			tvSum += h.tvs;
			lg(h+" "+h.tvs+" ("+tvSum+") "+h.isPartOfMerkleForest);
		}
	}
	
}
