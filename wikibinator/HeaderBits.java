package wikibinator;
import static mutable.util.Lg.*;
import static wikibinator.impl.ImportStatic.*; //FIXME this shouldnt be in spec. keep impl separate from this.
import immutable.util.MathUtil;
import immutable.util.Text;
import immutable.util.TruthValue;
import wikibinator.impl.Bull;
import wikibinator.impl.NotAllYesOrNo;
import wikibinator.impl.Unknown;
import wikibinator.impl.Word;

/** (long)λ.header() is made of TruthValues of 2 bits each,
storing the YES bits in the high 32 bits of a long and the NO bits in the low 32 bits.
<br><br>
Every binary forest node is valid. At height 0 theres 1 possible node.
At height 1 and below theres 2 nodes. At height 3 and below theres 5 nodes.
At each next height, the total number of nodes (at and below that height)
is nodesAtOneHeightLower^2+1 which I've verified by bruteForce up to a few levels deep by hash.
A λ is such a binary forest node, as the math spec for what it does,
but in practice it will be equally fast as any other GPU software for some kinds of calculations,
equally fast as music tools software on CPU, and various kinds of JIT compilers used together.
<br><br>
If its halted then it returns itself.
If its not halted then it returns some other node,
or multiple nodes if theres multiple equal forest shapes in duplicate nodes (before dedup)
that 2 kinds of equality in a parent node about its childs describes:
returnValOfLeftChildEqualsReturnValOfRightChild and leftAndRightForestShapesEqual.
Hash ids and dedup are lazyEvaled, and both those kinds of equality can be used
without triggering that lazyEval. Hash ids describe the leftAndRightForestShapesEqual kind of equality.
All ids have the 64 bits of header (32 TruthValues) which can do everything in this HeaderBits enum
except some parts of it (like about the callquads) are for possible future expansion.
<br><br>
Similar to immutable.occamsfuncer.impl.optimize.id.IdField.
<br><br>
The default kind of id is 256 bits (id256), including 3 longs and this header long.
This defines 32 TruthValues which together fit in a long.
The other 192 bits are either a secureHash (merkle forest) or 1..128 bits of literal cbt
(such as you could put 2 doubles for a complexnum in it, or a string of 16 utf8 bytes,
or a string of 32 utf8 bytes
in a parent node with (pair leftChild) and rightChild each having 16 bytes).
<br><br>
For higher security you can use for example sha3_256 or sha3_384 with these same header TruthValues
and maybe include 64 bits of bize (bitstring size) andOr other things you might want to fit in 512 bits.
192 bits means you would have to create and remember about 2^96 nodes before finding 1 collision,
which is maybe within the abilities of the strongest supercomputers as of Y2021
BUT it would be very very expensive which there are far more valuable calculations to spend that on,
or remember a random set of 2^64 of them 2^64 times since either way that multiplies to 2^192...
AND even if they do find a few duplicates, its squared times that hard to find an id
thats the same as a specific id such as a specific function that many people and computers together use.
Even if some collisions happen, theres very strong security by math axioms of how the functions fit together
so it would probably recover or with some slight adjustments to the VM
or especially a bunch of compatible opensource forks of the VM working together in realtime in p2p networks.
*/
public enum HeaderBits{
	
	/** isNondeterministic concat curriesAreLeaf together are the λ.op byte used in switch statement
	in SimpleFn.interpretedMode, and TODO in optimizations of it such as lwjgl opencl GPU and javassist.
	Self and (this many - 1) curries viewed by self.isLeaf() .. self.L().L().L().L().L().L().isLeaf().
	Each next parent just bit shifts this part of the header long and ORs in itself (which is not leaf
	unless its 2 childs are identityFunc and leaf which are the 2 childs of leaf to "close the loop").
	Knowing that allows recursing less deep to know what opcode to do.
	<br><br>
	Usually you can only know x.isLeaf or !x.isLeaf if x.isHalted.
	*/
	curriesAreLeaf(7, true),
	
	curriesAreLeaf_ignore6(0, false),
	curriesAreLeaf_ignore5(0, false),
	curriesAreLeaf_ignore4(0, false),
	curriesAreLeaf_ignore3(0, false),
	curriesAreLeaf_ignore2(0, false),
	curriesAreLeaf_ignore1(0, false),
	
	/** isNondeterministic concat curriesAreLeaf together are the λ.op byte used in switch statement
	in SimpleFn.interpretedMode, and TODO in optimizations of it such as lwjgl opencl GPU and javassist.
	Changed this to isNondeterministic so the first 128 ops are deterministic, second 128 ops nondeterministic.
	If isDeterministic then wikiState == (lazig (S I I) (S I I))
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
	isNondeterministic(1, true),
	//TODO rename it back to isDeterministic and flip the TruthValue? Cuz its shorter to say,
	//but I also like determinism being sorted first.
	//Either way, the λ.op byte is (byte)(header>>>32)... wait.. do I want the YES section to be the low bits
	//so that will be just (byte)header? Still have to verify theres 8 1s in those 16 bits in the 8 TruthValues,
	//but that would normally be verified when the node is created as its part of merkle forest (key, not val),
	//even though it could be part of val since it can be derived from the forest shape, but make it part of key
	//as an optimization.
			
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
	and (pair (pair T F) (pair T T)) is the bitstring 101 and (pair (pair T F) (pair T F)) is the bitstring 10.
	Literal does not specify how to interpret the cbt (as bitstring or general cbt
	or just a bunch of pairs and Ts and Fs). That depends on the functions which take cbts as params.
	<br><br>
	Theres a syntax for pairs, like  (pair (pair T F) (pair T T)) is [[T F] T T] aka [[T F][T T]],
	and if you want a linkedlist of a b c d e its [a b d d e λ] aka [a [b [d [d [e λ]]]]].
	*/
	isLiteral_elseHash(1, true),
	
	/** An optimization of the call (L x).
	I dont know about the header bits for this, if it should be self's header bits vs self.R's header bits,
	(especially cuz this TruthValue is in self's header)
	but it is certain that if this is TruthValue.yes then the 192 bits of id are the 192 bits of self.R
	AND self.L == theLFunction
	AND that self.R.lcall_myHash192IsOfMyRAndMyLIsTheLFunc is TruthValue.no,
	AND that self.R.rcall_myHash192IsOfMyRAndMyLIsTheRFunc is TruthValue.no,
	aka this is the call (L x) and has x's 192 hash bits and x is not such an lcall or rcall (else hash normally).
	*/
	lcall_myHash192IsOfMyRAndMyLIsTheLFunc(1, true),
	
	/** An optimization of the call (R x).
	I dont know about the header bits for this, if it should be self's header bits vs self.R's header bits,
	(especially cuz this TruthValue is in self's header)
	but it is certain that if this is TruthValue.yes then the 192 bits of id are the 192 bits of self.R
	AND self.L == theRFunction
	AND that self.R.lcall_myHash192IsOfMyRAndMyLIsTheLFunc is TruthValue.no,
	AND that self.R.rcall_myHash192IsOfMyRAndMyLIsTheRFunc is TruthValue.no,
	aka this is the call (R x) and has x's 192 hash bits and x is not such an lcall or rcall (else hash normally).
	*/
	rcall_myHash192IsOfMyRAndMyLIsTheRFunc(1, true),
	
	/** Similar to lcall and rcall, but for pair instead of L or R.
	An optimization to avoid storing (pair x) in ((pair x) y) aka (pair x y)
	and to only store x, y, and (pair x y), but be able to generate the id of (pair x) where
	hashing that id with the id of y generates the id of (pair x y).
	*/
	pcall_myHash192IsOfMyRAndMyLIsThePairFunc(1, true),
	
	/** TODO is this also useful for defining var names, or is it just a symbol for wikiStates you dont
	want to define as specific functions but converge instead? And how would the Reflect op see it?
	TODO remove this? I'm undecided if will keep this, since isDeterministic might be enough.
	A node is salt if its globalId says it is salt OR if isFake aka its an invalid globalId
	such as 256 random bits that are claimed to not be salt.
	aSymbolRepresentingTheUniverse (see comment of isDeterministic) is a globalId made of salt,
	such as maybe its hash bits are arbitrarily defined to be all 1s.
	*/
	isSalt(1, true),
	
	/** For possible future expansion to use debugStepInto vs debugStepOver similar to occamsfuncer callquad
	which has func param stack cacheKey and isParentsFunc. But wikibinator.Bloom has a different way of doing it.
	*/
	hasStackfunc(1, true),
	
	/** For possible future expansion to use debugStepInto vs debugStepOver similar to occamsfuncer callquad
	which has func param stack cacheKey and isParentsFunc. But wikibinator.Bloom has a different way of doing it.
	*/
	hasStackparam(1, true),
	
	/** For possible future expansion to use debugStepInto vs debugStepOver similar to occamsfuncer callquad
	which has func param stack cacheKey and isParentsFunc. But wikibinator.Bloom has a different way of doing it.
	*/
	hasCachekey(1, true),
	
	/** If !isHigher then this is all bits of the unsigned height integer, else this is only the low n bits of it.
	TODO should this be ignored (set to its max value?) if isHigher since it
	might make it harder to compute without having to know how deep you are?
	This may bits of height allows it to describe that a cbt has 1 bit, 2 bits .. 2^61 bits (about 2 exabits),
	todo is that offby1 aka 2^60 bits 2^59 bits? verify the exact number, but somewhere around 1 exabit.
	It doesnt store the exact bit length of the cbtBitstring, just the powOf2 it fits in
	(and it might be smaller than that powOf2 such as if the right child is all 0s).
	If you want to know the long size in bits (bize) of it, use RFPD cache
	<(bize aBitstring) 1152921504606846976L> aka the claim that (bize aBitstring) returns the cbt64
	returned by (baseTenToSignedCbt64 "1152921504606846976") but thats just a way to display
	numbers in baseTen depending on some syntax or another which will also be derived by combos of λ,
	where bize and baseTenToSignedCbt64 would be functions derived from combos of λ
	then optimized using Compiled.java as in λ.getCompiled() and λ.setCompiled(Compiled).
	*/
	lowBitsOfHeight(7, true),
	
	lowBitsOfHeight_ignore6(0,false),
	lowBitsOfHeight_ignore5(0,false),
	lowBitsOfHeight_ignore4(0,false),
	lowBitsOfHeight_ignore3(0,false),
	lowBitsOfHeight_ignore2(0,false),
	lowBitsOfHeight_ignore1(0,false),
	
	/** If true, then there are more digits of the height integer than fits in lowBitsOfHeight */
	isHigher(1, true),
	
	/** These 2 TruthValue spaces were taken by the L and R optimizations 2021-1-8.
	This is how much space in header is unused and is reserved for future expansion.
	Leave these as TruthValue.unknown.
	<br><br>
	FIXME you cant hash before observing its bits. Are these TruthValues (2 bits each) in the
	hash or not? and if they're in the hash, are they 1 bit each as they cant be unknown or bull?)
	*
	reservedForFutureExpansion(0, false),
	*/
	
	/** True if this is a fake node such as random bits made up pretending to be a globalId
	or any secureHash id which can reach those. False if have verified all the way down to leaf
	or have found some other way to prove its a forest shape where all paths lead to leaf.
	TruthValue.unknown is especially useful here since this is a very expensive thing to prove or disprove.
	Once its proved for a node, it spreads to any node which can reach it by λ.headerOreq.
	*/
	isFake(1, false),
	
	/** isHalted(x) = (x.l.isHalted & x.r.isHalted &
	(x.isLeaf | x.l.isLeaf | x.l.l.isLeaf | x.l.l.l.isLeaf | x.l.l.l.l.isLeaf | x.l.l.l.l.l.isLeaf)).
	Of course the change from TruthValue.unknown to TruthValue.yes of isHalted might not happen right away,
	but whatever you want to prove, whatever is valuable to you, you can accelerate it.
	*/
	isHalted(1, false),
	
	/** TruthValue.unknown is especially useful here since in some cases it costs
	infinite compute cycles and memory to know if a certain lambda call halts or not,
	but other times it can be known quickly, and everywhere between.
	willHalt(x) becomes true when <x y> and y.isHalted or if it can be proven some other way
	such as if its noticed that its a loop that counts from 1 to 2^1000000000000000000000000000
	then you dont have to compute all that, just add that axiom to your VM (by opensource forking it)
	to look for that kind of thing and know it will halt.
	Similarly if <x (S I I (S I I))> then you can set x.willHalt to TruthValue.no.
	All things which do not halt equal (S I I (S I I)) by returnValOfLeftChildEqualsReturnValOfRightChild
	aka <m (S I I (S I I))>.returnValOfLeftChildEqualsReturnValOfRightChild is TruthValue.yes
	if !m.willHalt, or they could all be TruthValue.unknown.
	<br><br>
	x.isHalted implies x.willHalt. x.willHalt does not imply x.isHalted
	since it would halt by returning some node other than x.
	We know its not x cuz what it returns isHalted and !x.isHalted.
	*/
	willHalt(1, false),
	
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
	
	/** (L x (R x)) equals x, forall x.
	<br><br>
	About nonhalters...
	The normed form of anything that does not halt is (S I I (S I I)),
	and its 2 childs are (S I I) and (S I I) which are each halted.
	FIXME I had been using normedFormOfAnythingThatDoesNotHalt as a thing which is its own left and right childs,
	BUT thats just what it evals to. Confirm (L x (R x)) equals x for (S I I (S I I)).
	Its 2 childs are both (S I I).
	1: (L (S I I (S I I))) never halts.
	2: (R (S I I (S I I))) never halts.
	3: (L (S I I (S I I)) (R (S I I (S I I)))) never halts.
	I've been defining any 2 things which never halt as equal to eachother
	at least in the HeaderBits.returnValOfLeftChildEqualsReturnValOfRightChild way,
	and I've been using (S I I (S I I)) as the thing they all return,
	as a semantic for the normed form of anything which does not halt.
	Since all 3 of those things (1: 2: 3: above) do not halt,
	we can use the semantic that they all HeaderBits.returnValOfLeftChildEqualsReturnValOfRightChild eachother.
	*
	Id.java: public static final Word idKeyOfTheNormedFormOfAnythingThatDoesNotHalt = null;
	*/
	returnValOfLeftChildEqualsReturnValOfRightChild(1, false),
	
	/** true if left child is same forest shape as right child.
	This isnt much useful if you have the 192 bits of secureHash, since you just compare those,
	but hash ids are lazyEvaled and dedup is lazyEvaled so λ.java instances can use this
	to say that some things equal or not equal in forest shape.
	This is not the same as returnValOfLeftChildEqualsReturnValOfRightChild kind of equality
	which is equality of the forest shape of what each child returns (or returns itself if child isHalted).
	*/
	leftAndRightForestShapesEqual(1, false);
	
	/** number of 2-bit TruthValues */
	public final int tvs;
	
	public final boolean isPartOfMerkleForest;
	
	/** aligns to high, and aligns to low, half of long header */
	public final int myimask;
	
	public final long myyesmask;
	
	public final long mynomask;
	
	public final long mybullmask;
	
	/** This only works if you know specificly that each of the 8 bits in op are TruthValue.yes or TruthValue.no,
	as represented in int instead of long. If thats true of a long, then this int can be the yes side of it.
	<br><br>
	The returned byte is <0 vs >=0 depending if isNondeterministic vs deterministic (FIXME swapped order of those?).
	*/
	public static byte opByte(int h){
		//This requires curriesAreLeaf (7) and isNondeterministic (1) (or rename it back to isDeterministic) be adjacent.
		return (byte)(h>>curriesAreLeaf.ordinal());
	}
	
	public static final int imaskOfOpByte = curriesAreLeaf.myimask|isNondeterministic.myimask;
	
	public static byte opByte(long h) throws NotAllYesOrNo{
		//TODO optimize by computing it directly from the long with no deeper function calls
		int obs = observes(h);
		if((obs&imaskOfOpByte) != imaskOfOpByte) throw NotAllYesOrNo.instance;
		return opByte(yeses(h));
	}
	
	/** high bit is isHigher which is 1 if height does not fit in the low 7 bits.
	TODO should those low 7 bits still be the low 7 digits of it, or should it be some constant or TruthValue.unknown?
	<br><br>
	If the returned byte < 0 then its higher than fits in those 7 bits.
	*/
	public static byte heightByte(int h){
		//This requires lowBitsOfHeight (7) and isHigher (1) be adjacent.
		return (byte)(h>>lowBitsOfHeight.ordinal());
	}
	
	public static final int imaskOfHeightByte = lowBitsOfHeight.myimask|isHigher.myimask;
	
	public static byte heightByte(long h) throws NotAllYesOrNo{
		//TODO optimize by computing it directly from the long with no deeper function calls
		int obs = observes(h);
		if((obs&imaskOfHeightByte) != imaskOfHeightByte) throw NotAllYesOrNo.instance;
		return heightByte(yeses(h));
	}
	
	/** see comment about the sign bit being isDeterministic vs isNondeterministic */
	public static byte opByte(λ x) throws NotAllYesOrNo{
		return opByte(x.header());
	}
	
	/** see comment about the sign bit not being a digit of height */
	public static byte heightByte(λ x) throws NotAllYesOrNo{
		return heightByte(x.header());
	}
	
	/** Only works where HeaderBits.tvs==1. */
	public TruthValue tv(λ x){
		return tv(x.header());
	}
	
	/** Only works where HeaderBits.tvs==1.
	Example: TruthValue xIsHalted = HeaderBits.isHalted.tv(x.header());
	*/
	public TruthValue tv(long header){
		if(tvs != 1) throw new RuntimeException("Doesnt fit in 1 TruthValue");
		boolean y = (header&myyesmask) != 0;
		boolean n = (header&mynomask) != 0;
		return y
			? (n ? TruthValue.bull : TruthValue.yes)
			: (n ? TruthValue.no : TruthValue.unknown);
	}
	
	/** High 32 bits are the yes parts. Low 32 bits are the no parts.
	AND those to get bull. AND(NOT NOT) those to get unknown.
	AND it with valMask to replace all [yes, no, and bull] with unknown in the val without affecting key/merkle.
	<br><br>
	In an id256, the first n bits (UPDATE: its not a solid range in the header long)
	for some constant n) are key, and the other bits are val.
	The last 64 bits is a long that has some bits of key and some bits of val. The other 3 longs are key only.
	Bits where isPartOfMerkleForest==true ae part of key, else they are part of val.
	This valMask long selects val. aVal&(~valMask) removes the val (sets it all to TruthValue.unknown)
	and and thats the long that goes with the other 3 longs as 256 bits to hash.
	Keep in mind when designing hashing algorithms that sha3_256 costs 1 cycle to hash up to 135 bytes
	and sha2_256 costs 1 cycle to hash up to 55 bytes. sha3_256 (or maybe sha3_224) (or maybe derive a sha3_192?)
	will be the default hash algorithm.
	Functions can be derived that take a function as parameter and return a cbt256 or cbt512 as a hash
	BUT ONLY FOR HALTED FUNCTIONS, SINCE IF THEY ARENT HALTED, THEN OTHER FUNCTIONS CANT SEE THEM YET,
	BUT YOU COULD EMULATE THE NONHALTED BINARY FOREST INTERNAL WORKINGS OF THE VM (THE id256s
	SOME OF WHICH ARE HALTED AND SOME OF WHICH ARE NOT) AS PAIRS INSTEAD OF FUNCTION CALL PAIRS,
	AS THE PAIR FUNCTION IS λx.λy.λz.zxy AKA CHURCH PAIR FUNCTION, OR SIMILAR FOR LAZIG INSTEAD OF CHURCH PAIR,
	WHERE LAZIG IS λx.λy.λz.xy AND TODO DEFINE THE SPECIFIC LAZIG FUNCTION WHICH DOES THAT,
	like occamsfuncer has a lazig but as of 2021-1-8 wikibinator has not derived one yet.
	An example of lazyEval of (x y) is (S (T x) (T y)) cuz <(x y) (S (T x) (T y) λ)>,
	and <m n> means m and n return the same thing aka m=n and n=m.
	TODO make sure the Reflect op is complete enough for example it has to know the isDeterministic bit
	to be able to hash it, so put that (either that or getWikiState) as the 4th thing the Reflect op can do,
	as Reflect currently only does L, R, and IsLeaf, but has space for 1 more thing.
	Also the GetWikiState op has space for 3 more things, and T and F each have space for 1 more thing.
	*/
	public static final long valMask;
	static{
		if(HeaderBits.values().length != 32) throw new RuntimeException(
			"There must be exactly 32 enum values, aligning their Enum.ordinal() to their bit index"
			+" in an int, as theres 2 ints in the high and low of long header. Number of enums: "
			+HeaderBits.values().length);
		long m = 0;
		long maskPrinter = 0x100000001L;
		for(HeaderBits h : HeaderBits.values()){
			for(int i=0; i<h.tvs; i++){
				if(!h.isPartOfMerkleForest){ //is part of val
					m |= maskPrinter;
				}
				maskPrinter >>>= 1;
			}
		}
		valMask = m;
	}
	public static final long keyMask = ~valMask;
	
	//FIXME 2021-1-9 I swapped yesMask and noMask so (int)header would be the yes bits.
	
	public static final long yesMask = 0x00000000ffffffffL;
	
	public static final long noMask =  0xffffffff00000000L;
	
	/** header is 32 TruthValues. Returns true iff any of them are TruthValue.bull */
	public static boolean hasAnyBull(long header){
		return (((int)(header>>32))&(int)header)!=0;
	}
	
	public static int yeses(long header){
		return lo(header);
	}
	
	public static int nos(long header){
		return hi(header);
	}
	
	/** Which of the 32 TruthValues are exactly 1 of TruthValue.yes or TruthValue.no (not unknown or bull) */
	public static int observes(long header){
		return (int)(header>>32)^(int)header;
	}
	
	public static int unknowns(long header){
		return ~(int)(header>>32)&~(int)header;
	}
	
	public static int bulls(long header){
		return (int)(header>>32)&(int)header;
	}
	
	/** x.header()&keyMask == headerKeyOf2Headers(x.l().header(),x.r().header()),
	forall x where each of the TruthValues in the key part of their headers are TruthValue.yes or TruthValue.no,
	which will always be true in the TruthValues in the key part of header since they are used
	in merkle hashing so must be a specific bit each, but they're still useful for error detection
	such as if someone gives you the same 192 bits of hash but with different key bits in the header.
	This uses &keyMask on each of its 2 params.
	*/
	public static long headerKeyOf2Headers(long headerA, long headerB){
		long headerKeyA = headerA&keyMask;
		long headerKeyB = headerB&keyMask;
		
		TODO use opByteOf2ChildOpBytes and heightByteOf2ChildHeightBytes
		
		TODO finish this func, then finish (long)Id.headerKeyOf2Headers(long,long),
		then hook it into λ.idKey().
	}
	
	public static byte opByteOf2ChildOpBytes(byte opByteA, byte opByteB){
		"TODO is there another function i wrote some code for but didnt finish"
		"TODO maybe cache this in a byte[1<<16]"
	}
	
	public static byte heightByteOf2ChildHeightBytes(byte heightByteA, byte heightByteB){
		TODO
		"TODO maybe cache this in a byte[1<<16]? Probably not cuz this is simpler than opByteOf2ChildOpBytes"
	}
	
	HeaderBits(int tvs, boolean isPartOfMerkleForest){
		this.tvs = tvs;
		this.isPartOfMerkleForest = isPartOfMerkleForest;
		myimask = ((int)((1L<<tvs)-1))<<ordinal();
		mybullmask = ii(myimask,myimask);
		myyesmask = mybullmask&yesMask;
		mynomask = mybullmask&noMask;
	}
	
	public static void main(String[] args){
		lg(HeaderBits.class.getName()+":");
		int tvSum = 0;
		for(HeaderBits h : HeaderBits.values()){
			tvSum += h.tvs;
			lg(h+" "+h.tvs+" ("+tvSum+") ordinal="+h.ordinal()+" mask="+Text.intTo32Chars(h.imask)+" "+h.isPartOfMerkleForest);
		}
	}
	
}
