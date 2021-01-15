package wikibinatorV0.impl.veryExperimental;

import java.util.Random;

import axiomforest.TruthValue;
import immutable.util.Blob;

/** This is a sparse piece of multiverse implementing this datastruct mentioned in README.md (state of README.md as of 2021-1-3)...
QUOTE
//The main data structure for this system might (each instance) contain... sparse 4d tensor of 2 bits per cell,
//meaning that <wikiState,func,param,return> is true (10), false (01), unknown (00), or disproofByContradiction (11),
//AND a sparse 2d triangle (undirected graph) of 2 bits per cell, that it is true/false/unknown/disproof that these 2 dimensions equal,
//AND some kind of edges which claim that a certain node/dimension is or is not equal to (see cbt) a certain powOf2 size binary blob.
//2 Dimensions equal if all possible <wikiState,func,param,return> on them equal aka can be split or merged without contradiction.
//This data structure might also optionally be named by a hash and have a proofOfWork attached to it only to attract attention
//to it among many other possible randomly generated useless combos of bits, but a high proofOfWork does not allow proving a falsity,
//only may attract attention to reach 100% agreement among all people and computers involved faster,
//agreement only on the facts of math which can be proven, not on one opinion above another.
//These data structures could be merged like joins in a database, so for example you take 2 of them,
//which has as many dimensions as the sum of each of their dimensions, then in a proof based or statistics based way
//start accumulating edges in that bloom-filter in the 2d tensor part, edges which claim that some pair of nodes equals or does not equal,
//and 4d tensor edges <wikiState,func,param,return>, so that whether they are in 2 equal wikiStates or nonequal wikiStates (which may be vague
//if which wikiStates each is in does not have alot of <func,param,return> statements to know precisely what it is and is not...
//2 such data structures, which are basically a 2d with a 4d bloom filter, kind of evolve together (by n-sat-like logic andOr statistics andOr other optimizations)
//to create more bloom-filters which are all or at least most of them true, for the purpose of sharing <wikiState,func,param,return> caches
//at gaming-low-lag for number crunching, math wikis, musical instruments, serious tools, fun things, etc... across the internet.
UNQUOTE.
*/
public interface Verse{
	
	/** Is this immutable or mutable? Once it becomes immutable, it cant become mutable again
	but could be copied to a new mutable one.
	As mutable, it would only be allowed to accumulate valid TruthValue
	from TruthValue.unknown becoming TruthValue.yes or TruthValue.no but not TruthValue.bull
	which would only happen when 2 Verses are merged and they had some dimensions (Number) in common.
	Given any permutation of a Verse (of all possible orders of the Number within it as sparse dims),
	some of those logically imply (by the logic in SimpleVM.interpretedMode or optimizations of it) some yes or no,
	but you will normally reach a point when you cant imply any more within the given dimensions
	so would need to add more dimensions or allow the SimpleVM.interpretedMode logic to
	tell you which dimensions need to be added. As long as you have the root dimension (λ),
	you can derive all possible dimensions from just calling that on itself in various combos
	(why its called wikibinator, its a combinator).
	*/
	public boolean isMutable();
	
	//TODO use primitives optimized for smaller sizes Verse,
	//such as a long can store 15 bits of wikState, func, param, and ret, and a 2 bit truthValue,
	//or such as 4 ints or 4 longs,
	//and 2 instead of 4 (either way still need 2 bits of truthValue, maybe stored in some of those primitives,
	//such as the low 2 bits in every one of the primitives must equal those 2 bits same 2 bits of all of them,
	//or something like that, or just put those in a byte.
	//Also I want lazycl (already reached 1 teraflop on 1 computer), acyclicFlow, javassist, jsoundcard, statvoxel,?
	//browserGamepadAPI, WebAudioAPI, webasm, GPU.js, etc.
	
	public TruthValue wfpr(Number wikiState, Number func, Number param, Number ret);
	
	public TruthValue eq(Number x, Number y);
	
	public TruthValue isBlob(Number x, Blob b);
	
	/** inner-joins/concats their dimensions. They must have no dimensions in common,
	and if they do, just permutate the dimensions and it will all still be true
	OTHER THAN you are not allowed to permutate 2 specific dimensions that are the universalFunc itself
	and (S I I (S I I)) which is a semantic that means "anything that does not halt" and of course itself does not halt.
	*/
	public Verse cat(Verse v);
	
	/** to avoid overlapping dimensions with any other verse before call of cat
	(can merge cleanly after they're proven not to overlap)...
	or its probably more efficient to for example just have a few hundred or few thousand dimensions
	in each and just allocate dimensions densely for the sum of those 2 small number of dimensions.
	This wikibinator system is meant to have around 2^80 number of dimensions when it scales up to p2p network
	and is in theory scale-free up to infinity dimensions.
	<br><br>
	TODO? This permutation may also include duplicating some dimensions and merging others which
	have a clique of TruthValue.yes on eq(dimensionA,dimensionB) which is still unitary.
	*/
	public Verse randomPermutateDims(Random rand);
	
	/** This is needed by SimpleVM to compute procedurally forward efficiently,
	in the way that (wikiState,func,param) is like a database.table primaryKey and ret is its value,
	and for every primaryKey there is exactly 1 value (though we may not know what it is) in the abstract math.
	<br><br>
	Select from wfpr(wikiState,func,param,*) which -> TruthValue.yes (no unknown, no, or bull),
	and FIXME if there are none of those, then.. should this infloop or return null or what?
	*/
	public Number wfpObserve(Number wikiState, Number func, Number param, Random rand);
	
	
	
	public default TruthValue wfpr(int wikiState, int func, int param, int ret){
		return wfpr((Integer)wikiState, (Integer)func, (Integer)param, (Integer)ret);
	}
	
	
	/** Returns the same long except with the uint2 truthValue replaced.
	wfprtv is concat of 4 dim14tv2: wikiState, func, param, ret. (TODO choose order of those)
	Each 16 bits has 14 bits of dimIndex and 2 bits of TruthValue.
	You normally dont use the TruthValue for wikiState, func, param, but do use it for ret.
	Its just more convenient to have it split into 4 of 16 bits,
	and maybe it would be useful to for example have which wikiState it is be\
	[TruthValue.unknown (00) about the question of is it that specific dim or not].
	Or more generally each bit in dimIndex could be viewed as a TruthValue,
	like a long could contain 32 TruthValues and each dimIndex is a TruthValue[8]?
	That way, you dont have to just return a TruthValue for if you guessed the ret right
	but it could fill in 8 yes andOr nos for the 8 bits (or n bits if it fits in more than a long)
	to tell you specificly which ret it knows go with those (certainty of) wikiState, func, and param
	(since wikiState_func_param is primaryKey and ret is value, and theres exactly 1 correct value for each primaryKey).
	I could use each byte as 4 TruthValues, for each of wikiState func param and ret,
	or I could split it into 1 byte of wikiState's dimIndex's TruthValue.certaintyOfYes
	thuen 1 byte of wikiState's dimIndex's TruthValue.certaintyOfNo,
	then 6 more bytes similarly for func param ret.
	Or I could have 8 longs as a wfpr thats the same thing except a long instead of a byte.
	These optimizations are causing me a problem in designing it to be efficient for
	very small Verses (like a small icon on screen or maybe even a single voxel or single number)
	and very big Verses (like whole internet size) and everywhere between.
	I dont expect to need TruthValue in the dimIndexs of func and param and unknown if will need it in wikiState,
	but it would be useful in the dimIndex of ret, so maybe divide it into these 5 things...
	wikiState func param ret.yesBits ret.noBits, like 12 bits each so each long could be a sparse statement
	about up to 4096 dims, that are another level deeper sparse inside as many dims as there are bits on the internet,
	or it could also fit in a double if its 1024 dims and 10 bits each.
	Or, if its just 1 wikiState in a certain Verse then it could have 2^16 dims.
	*
	public default long wfpr(long wfprtv){
		int wikiState = 
	}
	
	/** range 0 to 2^15-1 *
	public static int func(long wfprtv){
		return 0x7fff&(int)(wfprtv>>>45);
	}
	
	public static int param(long wfprtv){
		return 0x7fff&(int)(wfprtv>>>30);
	}
	
	public static int ret(long wfprtv){
		return 0x7fff&(int)(wfprtv>>>15);
	}*/

}
