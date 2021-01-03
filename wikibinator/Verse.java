package wikibinator;

import java.util.Random;

/** a sparse piece of multiverse implementing this datastruct mentioned in README.md (state of README.md as of 2021-1-3)...
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

}
