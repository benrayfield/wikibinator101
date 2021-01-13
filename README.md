# wikibinator
A decentralized wiki style interactive math book (for ages 0 to expert, which TODO will appear like cartoony art with drag and drop or hardcore number crunching tools that hook into cloud computing tools etc depending on the user's skill), based on a combinator (that is both a universal lambda function and a pattern calculus function of 6 parameters which has vararg lambdas) in which it is extremely easier to say true things than to say false things, based on a logic similar to godel-number where one must commit to statements about lambda called on lambda returns lambda before one can verify which lambdas they are, and in theory scaleable enough for graphics, musical instruments, GPU number crunching, etc, but lets start simple, so everyone can understand and fit the pieces of the puzzle together.

https://github.com/benrayfield/axiomforest
A 3 way forest where all paths lead to leaf where turing complete axioms can be built which are bigO(1) to eval, and a layer of 3-way forest above that with true or false at each node, as an infinite dimensional sparse bloom filter where each node may be true, false, or unknown and never observed especially if unproveable. This will be a layer under wikibinator, which is a universal lambda function (combinator) and pattern calculus function, which forks of wikibinator or other systems could use to share the same 3-way forest and provide third party validation of the claim that wikibinator is just an axiom in the axiom space and is not above or below any other possible axioms.

UPDATE: "In this axiom space, the "decentralized wiki style interactive math book (for ages 0 to expert" will be written, and from what we learn, practical systems will be built also in the axiom space including AI tools, number crunching, games, musical instruments, and general cloud computing in p2p networks, such as GPU optimized by lazycl. An optimization of an axiom is an axiom. An axiom is a UnaryOperator<Observedλ>." ... There maybe (I'd avoid it if I could) must be 1 root axiom which all other axioms are optimizations of since it has to be able to generate an id (any runtime derived hash algorithm of merkle hash of a 3+1bit way forest) for every axiom thats not an optimization of an axiom that has an id, and that would be the wikibinator STEP axiom. ... The wiki opcode (see SimpleFn.java) is the only nondeterministic thing in the system (other than unprovable statements?) and can be represented as accumulation of axioms of 1 key/value each such as (wiki "hello")->"world" would contradict (wiki "hello")->(wiki (wiki "hello") (wiki wiki)) since those are 2 different values for the same param of the wiki function. These axioms would be considered optimizations of the wikibinator STEP axiom that otherwise will eval to (S I I (S I I)) (which is an infinite loop) for all possible params of the wiki function, and therefore it will never return therefore will not contradict any axiom which says it returns a specific value for a specific param unless theres 2 such axioms that claim (wiki someParam) has 2 different values that would be detected within 1 video frame of a game (like 1/60 second) in most cases. ... Wikibinator, being a (mostly well-defined, its control-flow opcodes are finished, todo last few adjustments to opcodes for determinism vs nondeterminism and axiom compatibility...)... Wikibinator will be just 2 of many possible axioms you might use, in an axiom space made of the data structure of 3-way forest nodes (λ) where all paths lead to leaf, and layered on top of that are Observedλ nodes which each have a λ and a bit for is that statement TruthValue.yes or TruthValue.no. Each statement is instantly observed to be YES or NO the first time its used for a cost of bigO(1) as an axiom is a UnaryOperator<Observedλ> which looks only to a shallow depth from its param and generates another Observedλ as some combo of the Observedλs it finds and <leaf ObservedλX ObservedλY> which it can make up. Forall Observedλ x forall Observedλ y [leaf x y] (FIXME on github you cant see the angle brackets lessthan greaterthan and whats inside them so todo replace those with some other syntax in this readme) is YES, regardless of if x is YES or NO and regardless of if y is YES or NO. A λ is TruthValue.unknown until first observed, and many statements are unproveable in finite time and unprovable in this axiom system due to it only acts in BigO(1) steps. An axiom does a BigO(1) tiny piece of work, described by the lambda call (STEP Observedλ), where STEP is a Observedλ. Depending on which axiom(s) you use, the axiom may contain a way to use STEP to do debugStepInto and debugStepOver and pushEmulatorLevel and popEmulatorLevel and ops to get each of the 3+1butr trinary forest childs and to read the bit (fourth child, being yes or no) of an Observedλ. EmulatorLevel is not a normal emulator but is just a way (and incompletely defined, TODO) to divide work into BigO(1) size pieces. The work the system will do is to call function on function to return/find function, as lambdas normally do, and the only kind of disproof-by-contradiction it supports is 2 Observedλ of the same λ (aka forest shape) where 1 is YES and the other is NO, and depending on what axiom(s) you use, specificly I do plan to use 2 axioms, one that computes procedurally forward 1 step in wikibinator, and 1 that recognizes when 2 statements are of the same lambda call but different return values (x y)->b and (x y)->c therefore at least 1 of those statements is NO, AND to make sure everyone everywhere converges to consistency, that axiom will also imply that EVERY statement is both YES and NO (or at least many of them that will be so many it cant be ignored as it spreads like a cellular automata across the whole network pointing out the existence of a single bit being both YES and NO anywhere in the network)... if such a contradiction is proven, AND the peers wont be able to say they dont believe in the things which led to that contradiction since a Observedλ has a YES or NO about itself (a specific trinary forest shape, without YESes or NOs) AND has 3 Observedλ childs which also have a YES or NO (no unknowns allowed in the merkle forest), so when a peer shares a Observedλ (a 256 or 512 bit id, depending if its all YES at and below it you can shrink it to 256, but 512 bits if you have a mix of YES and NO as statements can see and talk about statements being yes and no)... when a peer shares a Observedλ, that peer is claiming everything reachable in the childs of that Observedλ. Garbage collection will be that you dont have to store what derived a Observedλ (by STEP). You only have to store whats reachable thru its 3+1bit childs recursively, and you only have to store any cross-section of them and the bits, as the forest shape ids (but not the bits) can be derived deterministicly upward. The bits can only be derived sideways, allowing cycles (like an all-paths integral in physics or gear teeth spinning together in infinite dimensions and no gear ever chips or misaligns another gear but in turing complete ways). So the axiom system will not be specific to the wikibinator universal function, since wikibinator will be just an axiom that you can choose to go along with or not, In this axiom space, the "decentralized wiki style interactive math book (for ages 0 to expert" will be written, and from what we learn, practical systems will be built also in the axiom space including AI tools, number crunching, games, musical instruments, and general cloud computing in p2p networks, such as GPU optimized by lazycl. An optimization of an axiom is an axiom. An axiom is a UnaryOperator<Observedλ>.

UPDATE: https://github.com/benrayfield/wikibinator/blob/main/wikibinator/Bloom.java will be a sparse bloom-filter
scaleable up to the size of running the whole internet on it at gaming-low-lag. Its not a specific algorithm
but is a binary forest where each node has 2 mutable bits as TruthValue.yes, TruthValue.no, TruthValue.unknown, or TruthValue.bull,
and is a math abstraction that can wrap binary blobs. Its a sparse hill-climbable memory
that can sync writes between an exponential number of computers at once and every write that any
2 computers do will always be the same value so read write locking is unnecessary
except a little of it to check for TruthValue.bull which will occur far less often than yes no or unknown.
An axiom is any function of [map of binary forest node to TruthValue] to another [map of binary forest node to TruthValue]
and such maps can be ORed together, and as long as that doesnt cause them to have any TruthValue.bull, its ok,
even though bull may occur later unknown that its implied yet, but there is no time in the system
so if there will be bull later then it can be proven that theres bull now if you look in the right combos.

UPDATE: https://github.com/benrayfield/wikibinator/blob/main/mutable/util/UndoMem.java will allow undo per 32 bits of memory back around 100 million writes, even if the writes depend on current contents of megabytes of memory at the time such as branching to do one thing or another, to do some graphics or sound op, copy a range of memory, etc... If it "runs out of gas" during that recursively, it will be able to undo back to any chosen point and continue from there.

FIXME conflicts with "all possible axioms are: trinaryForestNode (aka tfn), (axiomX T tfnZ)->thisTfnIsTrue and (axiomX F tfnZ)->thisTfnIsFalse and forall tfnA forall tfnB: <tfnLeaf tfnA tfnB>".

Use "all possible axioms are: trinaryForestNode (aka tfn), (axiomX T tfnZ)->thisTfnIsTrue and (axiomX F tfnZ)->thisTfnIsFalse and forall tfnA forall tfnB: <tfnLeaf tfnA tfnB>" to write those 2 questions (predicate-like but taking no param, just provable as true or false if you have infinity cubed time and memory or something like that.

I dont expect to actually prove if p equals np or not, but I do want the axiom system to be flexible enough to ask the question to infinite precision and the question is a specific trinary forest node which takes about infinity cubed time and memory to answer.

Looking for a consistent model of the space of all possible axioms, but I'm uncertain if it can handle these exists and !exists recursions. It will be able to make the statement in the trinary forest nodes (which are a lower level than the lambda call pairs in the binary forest nodes of wikibinator, which will implement the wikibinator opcodes)... but the axioms would only work if there can be a trinary forest node for pEqualsNp and a node for pNotEqualsNp and at least 1 of them could be derived if you had infinity cubed amount of compute cycles and memory.
```
pEqualsNp IFF[
	//verifyNpSolverOnASubsetSum is a lambda that curries 3 params and emulates another lambda for a certain number of steps
	//and returns T or F depending if it found a subset of integers (excluding the first) that sum to the first of those integers.
	//(verifyNpSolverOnASubsetSum maxSteps aPossibleNpSolver subsetSumQuestion) -> T or F, always halts in maxSteps.
	existsNonnegInteger<p>[ //NP questions of n nodes can be answered in bigO(n^p) if pEqualsNp
		existsLambda<aPossibleNpSolver>[
			//I can map 1-to-1 between integers and all unique lambdas
			//(max 5 curries, uniqueforestnodesatheight aka ufnah(n)=ufnah(n-1)^2+1
			//but skipping those with more than 5 curries.
			//Or can dovetail using fntape in order of kolmogorovComplexity andOr computeCycles and mem.
			notExistsPositiveInteger<subsetSumQuestion>[
				inputBitstringSize = (bitstringLen subsetSumQuestion);
				maxSteps = (exponent inputBitstringSize p);
				return !(verifyNpSolverOnASubsetSum maxSteps aPossibleNpSolver subsetSumQuestion);
			]
			//Could also write the following as !exists of !(verifyNpSolverOnA ... estion).
			//My axiom system seems only able to have exists and !exists statements, so yes do that.
			//forallPositiveInteger<subsetSumQuestion>[
			//	//view the integer as a square array
			//	//of b=floor(log2(subsetSumQuestion)) integers of b bits each,
			//	//and the first of those integers is the sum in question,
			//	//and the question is does any subset of the other b-1 integers sum to that.
			//	//The following always returns T or F :
			//	inputBitstringSize = (bitstringLen subsetSumQuestion);
			//	maxSteps = (exponent inputBitstringSize p);
			//	return (verifyNpSolverOnASubsetSum maxSteps aPossibleNpSolver subsetSumQuestion)
			//]
		]
	]
]
```
About the above exists !exists flexibility of axioms... Very probably, the best I can do is a statement that a certain lambda, when called on leaf (such as (S (T x) (T y) leaf)->(x y) as a way to derive lazyeval as (S (T x) (T y)))... The claim that a certain lambda when called on leaf HALTS or DOES_NOT_HALT. If you claim it DOES_NOT_HALT then an observation of it halting disproves that. If you claim it HALTS but it actually doesnt, you would not always be able to disprove that. So not every true statement can be proven (and not every false statement can be disproven), but I'll be happy within the space of only what can be proven and disproven since a theory which makes no testable predictions is not a useful scientific theory and therefore will not break the system for unprovable statements to be lied about, since as soon as they contradict any other provable statement, its proven that at least 1 of the things which led there is wrong. The HALTS claim can be computed by the normal universal function math (since its both a universal lambda function (combinator) and pattern calculus function), (thisHaltsIfItsParamCalledOnLeafHalts x) would simply eval to (x leaf). But theres no such statement for DOES_NOT_HALT, since that is just the NOT of the TruthValue for (x leaf) halts. I want there to be a trinary forest node representing the statement that x halts and another node representing the statement that x does not halt, but I do not claim all of these statements can be derived in finite time, just that the "x halts" statement can be derived in finite time if its true, and "x halts" implies NOT "x does not halt" and "x does not halt" implies NOT "x halts". That should be enough to represent some parts of EXISTS and FORALL statements as a lambda can loop over all the positive integers and call one of its params on that integer and halt if (thatParam anInteger) halts, and you can use (S (T not) thatParam) as in (S (T not) thatParam anInteger) to eval to (not (thatParam integer)) and use https://en.wikipedia.org/wiki/De_Morgan%27s_laws (which are normally for logic on 3 bits at a time) to transform between EXISTS and FORALL on infinite sets, but I do not claim its always solvable in finite time. I do claim that the axiom system of each trinaryForestNode tfn... (anAxiom T tfnX) -> tfnY (implies tfnY is true), and (anAxiom F tfnX) -> tfnZ (implies tfnZ is false), if tfnX is true it implies those things, and forall tfn b forall tfn c, if b and c are true then <trinaryForestLeaf b c> is true, and trinaryForestLeaf is true... I do claim that axiom system is flexible enough to compute exact math on real numbers such as a mandelbrot fractal and flexible enough to compute everything that any digital computer has ever computed and in some cases will be GPU optimizable (by lazycl). I need such a flexible axiom system so that a nonhalted lambda call (internal workings of the VM) can have a custom id generated (for all possible idMaker lambdas, which is any lambda that returns a bitstring (cbt) of the same size when given any trinary forest node such as a halted or nonhalted lambda call)... If something is wrong with a specific kind of id, I want user level code at runtime to be able to generate alternative kinds of ids and to use multiple kinds of ids (all lazy merkle forest based, but with varying sizes and kinds of cache in them) together in realtime. I need that level of self reference, so I need a good axiom system at the core. Godel incompleteness and halting problem etc limit what an axiom system can possibly do, but I'll be happy if it works on a global scale just well enough to sync everything at gaming-low-lag and converge the statements of which function called on which function returns which function... converge that toward truth often enough we can actually use it.

Here's the 32 TruthValues that will be 64 bits in every id256. An id is a godel-number-like statement...

https://github.com/benrayfield/wikibinator/blob/main/wikibinator/HeaderBits.java 2021-1-10:

package wikibinator;
import static mutable.util.Lg.*;
import static wikibinator.impl.ImportStatic.*; //FIXME this shouldnt be in spec. keep impl separate from this.
import immutable.util.MathUtil;
import immutable.util.Text;
import immutable.util.TruthValue;
import wikibinator.impl.Bull;
import wikibinator.impl.NotAllYesOrNo;
import wikibinator.impl.Unknown;

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
	
	/** Renamed to isDirty, which means isNondeterministic.
	isNondeterministic concat curriesAreLeaf together are the λ.op byte used in switch statement
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
	isDirty(1, true),
	
	//UPDATE: renaming it to isDirty which means isNondeterministic.
	//TODO?? rename it (from isNondeterministic) back to isDeterministic and flip the TruthValue? Cuz its shorter to say,
	//but I also like determinism being sorted first.
	//Either way, the λ.op byte is (byte)(header>>>32)... wait.. do I want the YES section to be the low bits
	//so that will be just (byte)header? Still have to verify theres 8 1s in those 16 bits in the 8 TruthValues,
	//but that would normally be verified when the node is created as its part of merkle forest (key, not val),
	//even though it could be part of val since it can be derived from the forest shape, but make it part of key
	//as an optimization.
	
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
	
	/** If false in x then x.isDirty==x.l.isDirty==x.r.isDirty and so on recursively all the isDirty are yes or all are no.
	The purpose of tracking this is the merkle hash id (192 bits) is the same between x and y where
	x and y have the same forest shape and differ only in x.isDirty!=y.isDirty,
	but if containsDirtyAndNondirtyDeeply then the merkle hash differs.
	Of course if its a literal of 1..128 bits of cbt then its not a hash id there so is the same 192 bits either way,
	BUT... a literal id can only be optimized that way if containsDirtyAndNondirtyDeeply everywhere inside it.
	*/
	containsDirtyAndNondirtyDeeply(1,true),
			
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
	*
	myWikiStateIsTheMainWikiState(1, true),
	*/
	
	/** Can only store 1..128 bits of literal cbt in an id256 if HeaderBits.containsDirtyAndNondirtyDeeply in it,
	else would have to hash it as usual for call pairs.
	<br><br>
	OLD... This is one of the first few bits so that literals cant be designed to start with the same first 128 bits
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
	
	/** An optimization of the call (pair x).
	Similar to lcall and rcall, but for pair instead of L or R.
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
	
	/** is (S I I (S I I))? Or maybe the normed form should be one of the salt nodes, just define a symbol for it?
	*/
	isTheNormedFormOfEveryCallThatDoesNotHalt(1, true),
	
	/** Removing this cache cuz every cbt other than those which have all 0s are bitstrings,
	and if you need to know that you can derive a containsT function
	then use {(T and2) isCbt containsT} as an isBitstring function.
	I'm taking this space in header for isMerkleHeader.
	<br><br>
	isCbt and contains T. A bitstring is a cbt padded with a 1 then 0s until the next powOf2,
	viewing whats before that last 1 as the contents of the bitstring.
	The id256 does not contain the length but for bitstrings up to about 1 exabit (TODO get exact number)
	it does contain the height so you know its max size to a precision of a certain powOf2,
	and you can use the RFPD system <func param return isDeterministic> cache entries
	to store its exact bit length in a cbt64 aka a long, something like <derivedLengthFunction aBitstring itsLen T>
	or <derivedLengthFunction aBitstring itsLen F> or if RFPW <derivedLengthFunction aBitstring itsLen wikiState>.
	aka <derivedLengthFunction aBitstring itsLen (lazig (S I I) (S I I))>
	or <derivedLengthFunction aBitstring itsLen theMainWikiState>.
	*
	isBitstring(1, false),
	*/
	
	/** see (λ)λ.setHeader(long) and (λ)λ.setIsMerkleHeader(boolean).
	If isMerkleHeader then HeaderBits.keyMask is 0xffffffffffffffffL aka -1L, and HeaderBits.valMask is 0L,
	aka all 256 bits in an id256 are key and there is no val other than that,
	but the header works the same way, means the same things. Its just that you have to forkEdit it
	upwork as a merkle forest every time you OReq a TruthValue into the bloomFilter.
	Its potentially very useful, and a good research path, for improving consistency in a p2p network
	but at the cost of its far more expensive.
	*
	isMerkleHeader(1, true),
	FIXME remove isMerkleHeader (and leave the space reserved(1,?)? since its a very slow algorithm?
	or bring back isBitstring? Or what should use that 1 TruthValue of space?
	and if remove isMerkleHeader, then theres λ functions about it to also remove.
	*
	reservedForPossibleFutureExpansion(1,false),
	
	/** These 2 TruthValue spaces were taken by the L and R optimizations 2021-1-8.
	This is how much space in header is unused and is reserved for future expansion.
	Leave these as TruthValue.unknown.
	<br><br>
	FIXME you cant hash before observing its bits. Are these TruthValues (2 bits each) in the
	hash or not? and if they're in the hash, are they 1 bit each as they cant be unknown or bull?)
	*
	reservedForFutureExpansion(0, false),
	*/

	
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
	eq_returnValOfLeftChildEqualsReturnValOfRightChild(1, false),
	
	/** true if left child is same forest shape as right child AND their isNondeterministic bit equals
	(like each node has 3 merkle childs: L R isNondeterministic).
	This isnt much useful if you have the 192 bits of secureHash, since you just compare those,
	but hash ids are lazyEvaled and dedup is lazyEvaled so λ.java instances can use this
	to say that some things equal or not equal in forest shape.
	This is not the same as returnValOfLeftChildEqualsReturnValOfRightChild kind of equality
	which is equality of the forest shape of what each child returns (or returns itself if child isHalted).
	*/
	eq_leftAndRightForestShapesAndNondetBitEqual(1, false);
	
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
	
	/** like long is 32 truthvalues with its high 32 and low 32 bits, get a uint16 of high 8 and low 8 bits.
	Char is java's only uint16 type.
	*/
	public static char opTwobyte(long header){
		return twobyteAt(header, curriesAreLeaf.ordinal());
	}
	
	public static final int imaskOfOpByte = curriesAreLeaf.myimask|isDirty.myimask;
	
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
	
	/** like long is 32 truthvalues with its high 32 and low 32 bits, get a uint16 of high 8 and low 8 bits.
	Char is java's only uint16 type.
	*/
	public static char heightTwobyte(long header){
		return twobyteAt(header, lowBitsOfHeight.ordinal());
	}
	
	/** like long is 32 truthvalues with its high 32 and low 32 bits, get a uint16 of high 8 and low 8 bits.
	Char is java's only uint16 type.
	*/
	public static char twobyteAt(long header, int shift){
		return (char)( ((header>>(shift+24))&0xff00) | ((header>>shift)&0xffL) );
	}
	
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
	
	/** Only works where HeaderBits.tvs==1 and [the value is TruthValue.yes or TruthValue.no else throws Unknown or Bull] */
	public boolean z(λ x) throws Unknown, Bull{
		//TODO optimizer
		return tv(x.header()).z();
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
	
	/** all 1s. See HeaderBits.isMerkleHeader. *
	public static final long valMask_if_merkleHeader = -1L;
	
	/** all 0s. See HeaderBits.isMerkleHeader. *
	public static final long keyMask_if_merkleHeader = ~valMask_if_merkleHeader;
	*/
	
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
		
		/*TODO use opByteOf2ChildOpBytes and heightByteOf2ChildHeightBytes
		
		TODO finish this func, then finish (long)Id.headerKeyOf2Headers(long,long),
		then hook it into λ.idKey().
		*/
		throw new RuntimeException("TODO");
	}
	
	public static byte opByteOf2ChildOpBytes(byte opByteA, byte opByteB){
		throw new RuntimeException("TODO");
		//"TODO is there another function i wrote some code for but didnt finish"
		//"TODO maybe cache this in a byte[1<<16]"
	}
	
	public static byte heightByteOf2ChildHeightBytes(byte heightByteA, byte heightByteB){
		throw new RuntimeException("TODO");
		//"TODO maybe cache this in a byte[1<<16]? Probably not cuz this is simpler than opByteOf2ChildOpBytes"
	}
	
	/** Range 0-6. Number of params more to curry before this would eval.
	If 0, is now evaling. If 6, its u (aka the universal function).
	*/
	public static int opCur(byte op){
		//TODO optimize using byte[256]? Or is this faster?
		int i = (op&0x7f); //0..127
		if(i == 0) return 0;
		if(i == 1) return 6; //is u
		return opCur((byte)(i>>1))-1; //TODO verify this is not offby1
	}
	
	public static boolean opIsHalted(byte op){
		//TODO optimize by not computing which nonzero value cur is, just is it 0 or not.
		return opCur(op)!=0;
	}
	
	/** This is what happens when you call an evaling on an evaling,
	or a halted on an evaling, or an evaling on a halted.
	If it just started to eval, then its op would be in range 64-127 (or that minus 128 as the isDirty bit).
	*/
	public static boolean areLow7BitsOfOpAll0(byte op){
		return (op&0x7f)==0;
	}
	
	public static boolean opIsLeaf(byte op){
		return (op&0x7f)==1;
	}
	
	public static boolean isLeaf(λ x){
		//its 1 of the 7 bits of curriesAreLeaf which are the 7 low bits of opByte
		//TODO optimize it can be done with tv(x) instead of getting the whole opByte, or more directly a mask here.
		return (opByte(x)&1)==1;
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
			lg(h+" "+h.tvs+" ("+tvSum+") ordinal="+h.ordinal()+" mask="+Text.intTo32Chars(h.myimask)+" "+h.isPartOfMerkleForest);
		}
	}
	
}



```
//My theory-of-everything:
//Universe is a specific irrational fraction = the 4d cantor diagonal of <wikiState,func,param,return> -> true or false,
//and to avoid ambiguity of those words I mean 4d cantor diagonal as a nondecreasing order of manhattan-distance from
//<λ,λ,λ,λ> which is the first digit, and any way of breaking ties will work such as bigEndian of 4 integers or littleEndian of 4,
//such as <λ,λ,λ,(λ λ)> is the second digit,
//where numberOfUniqueBinaryForestsAtHeight aka uniqbin(0)=1 and uniqbin(x)=uniqbin(x-1)^2+1
//(todo found that by brute forcing a few levels deep, copy that code here)
//with no unknowns, but we only use trinary (true, false, or unknown) values of 3d tensor (instead of 4d) as optimization,
//and in practice will appear and be used any way people like even if you're bad at math.  
//
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
//
//As the name suggests, wikibinator will start as a math wiki similar to wikipedia, to explain how itself works,
//and to derive all known kinds of math in the form of lambda functions, such as pi could be represented
//as a function that takes an integer of which digit number you want and in finite time returns that digit,
//and pi squared could be represented as another such function which calls pi, but thats not a very efficient way.
//
//Similar to the spend and wallet and solve calls in (some forks of occamsfuncer, TODO), those calls will be somewhere in the wiki
//that can be called on otherwise deterministic lambdas to limit their amounts of compute resources (time, memory, etc) recursively,
//so in practice all lambda calls will halt within .02 seconds in time to display the next video frame of a game or sound etc.
//
//I'm exploring possible syntaxes, for the well defined wikibinator universal function.
//λ means that universal function aka wikibinator. All possible deterministic functions are made of combos of λ.
//A certain combo of λ (TODO choose order of params so can write it here) means the wiki, which is a function,
//but we only learn which function it is by how people and computers use it,
//which there is math ((L x (R x)) equals x forall x and the logic in SimpleVM.interpretedMode) to verify
//the wiki function is consistent based on many <func,param,return> cache entries.
//Every function is an infinite set of <func,param,return> cache entries,
//exactly 1 return value for each possible func called on possible param,
//and as a semantic if it does not halt then we say it halts on (S I I (S I I)) which is an infinite loop,
//but of course halting oracles are impossible (since they answer in finite time), but still it is a fact of math
//that any specific lambda call either halts or does not halt.
//It just takes an infinite number of compute cycles and memory to know,
//so that semantic is mostly there as a math abstraction, but also may be used in disproof-by-contradiction sometimes,
//in proofs using the ((L x (R x)) equals x forall x and the logic in SimpleVM.interpretedMode) constraint.
//
//Syntax:
//λ is wikibinator.
//(x y) means call x on y, and its value is whatever that call returns.If a call has less than 6 params
//it is halted so returns itself, like (λ λ) is  waiting on 5 more params, and ((λ (λ λ)) λ) aka (λ (λ λ) λ) is waiting on 4 more params.
//(w x y z) means (((w x) y) z), which is called a curryList, similar to a linkedList but in reverse order and doesnt have nil.
//[a b c] is a linkedlist that means (pair a (pair b (pair c λ))). λ is used as nil in linkedLists.
//{a b} means (pair a b).
//<func param ret> means (func param) returns ret. It always has 3 things.
//TODO: "hello" means the utf8 bitstring of 5*8 bits, stored in a complete binary tree (cbt) of pairs of pairs... of T or F,
//padded with T then F F F... until the next powOf2 size. Or TODO I might use typeval to mark it as being a string, some few constants
//representing a few common types but there is no type system other than <type x λ> vs <type x anythingExceptλ>,
//so for example if <type x (S I I (S I I))> then x is not that type cuz the call (type x) will not halt
//(even though we may be unable to know that in finite time, so be careful to design types so they always halt).
//There are no variables cuz everything is a constant, but in this file I might define some variables outside of wikibinator
//whose value can be changed to a different constant, but those constants cant refer to those variables, only to constants.
//Even the wiki function is a constant and just accumultes <func param return> facts in an infinite sparse dimensional space
//of all possibilities.
//
//I'm thinking about representing the names (like infloop in <(S I I),(S I I),infloop>) as the return value of (wiki ["infloop" "myNamespaceXYZ"]),
//so that would be the statement <(S I I) (S I I) (wiki ["infloop" "myNamespaceXYZ"])>,
//but there might be a problem writing it that way since (wiki ["infloop" "myNamespaceXYZ"]) returns (S I I (S I I)),
//and maybe what I meant to say is <wiki ["infloop" "myNamespaceXYZ"] (S I I (S I I))>?
//Or maybe I'll just write it as: infloop = (S I I (S I I));
//FIXME.
//
//If a var name is written more than once, then its just a semantic for appending a number to the var name
//so its a different var name each time, and lines of code above that use the lower numbers
//and lines after that use the higher numbers, so each "var name" has at most 1 constant value
//in any certain multiline string of lines of code, and those lines represent a sparse 3d tensor
//of 3 possible values at each cell: true, false, or unknown: that <func param return> is true false or unknown.
//Since wikibinator is meant for ever expanding virtual worlds, tools, games, number crunching, etc...
//those sparse tensors fitting together with other sparse tensors could be said
//to be similar to a variant of "the matrix" as a virtual world can fit in a 3d tensor and a matrix is a 2d tensor.
//All possible states of the wikibinator system are sparse 3d tensors of 3 possible values per cell - true false unknown.
//Also it might someday be able to run on a black-hole-computer or gray-goo, but CPUs and GPUs are the sooner goal.


//Its important to understand that, if each var name is written only once (which can just append a number to the var name
//after each time you write it automatically) that...
//If there are n lines of code then all n! permutations of those lines of code, reordering them before and after eachother,
//are still true statements, and in practice as long as you dont call wiki that will be equally efficient to compute it that way,
//and if you do call wiki in that then its still the same code but may be impractically slow to compute it
//or have sync problems involving the limiting of compute resources recursively which will be mounted
//into the wiki function like a bloom-filter growing (which may also be uncached / garbcoled)...
//But the point is, these lines of code are a sparse 4d tensor, with each "var name" being a dimension,
//and tensors are not affected by permutation, and those tensors represent all possible pasts, present, and futures of the system,
//therefore the whole system, in parts which do not call wiki, can in theory be computed in an infinite number of threads
//which can branch predict eachother.

wikibinator = λ;
u = λ; //easier to write u than λ
uu = (u u);
op0 = (u u u u);
op1 = (u u u uu);
op2 = (u u uu u);
op3 = (u u uu uu);
op4 = (u uu u u);
op5 = (u uu u uu);
op6 = (u uu uu u);
op7 = (u uu uu uu);

//public static final byte
//	opWiki = 0,
//	opS = 1,
//	opT = 2,
//	opFI = 3,
//	opPair = 4,
//	opSecondLastInList = 5,
//	opCurry = 6,
//	opReflect = 7;

w = (op0 u u); //The wiki. The only nondeterministic function, defined by agreement among many on an ever expanding set of <func param return>.
//wiki = (u u u u u u) cuz op0 = (u u u u).
//(wiki x) is (u u u u u u x), forall x.
//For example, (λ λ λ λ λ λ (λ λ λ λ λ λ)) aka (w w) is calling the wiki on itself. TODO what should that return?
s = op1;
t = (op2 u);
f = (op3 u);
p = op4;
b = (op5 u u);
c = op6;
reflect_todoChooseALetterForThis = op7;

wiki = w;
i = (f u); //identityFunc
pair = p;
getFuncBodyAkaSecondLastInLinkedList = b;
curry = C;
a = (reflect_todoChooseALetterForThis u u);
l = (reflect_todoChooseALetterForThis uu u);
r = (reflect_todoChooseALetterForThis uu uu);
isLeaf = a;
getFunc = l;
getParam = r;

<u u uu>;
<(s i i) wiki (wiki wiki)>;
<(s i i) u (u u)>;
<(l wiki) (r wiki) wiki>; //(l x (r x)) equals x forall x.
<(l u) (r u) u>; //(l x (r x)) equals x forall x.
<l u i>; //(l x (r x)) equals x forall x.
<r u u>; //(l x (r x)) equals x forall x.
<(l l) (r l) l>; //(l x (r x)) equals x forall x.
<(l r) (r r) r>; //(l x (r x)) equals x forall x.
<(l p) (r p) p>; //(l x (r x)) equals x forall x.

//TODO define equals function. will be similar to the lambda returned by OcfnUtil.equals() in occamsfuncer.
```

Unlike other advanced systems, its very important for wikibinator to be able to explain its every detail of its own operation.

The main thing wikibinator does is to help many people and computers agree among eachother what the "Import" combinator/function does, which is entirely undefined other than the <function,parameter,return> style messages they say to eachother, which can be verified or disproven statistically based on the quinelike behavior of any function x that (L x (R x)) equals x, for all possible x, which means that recursively anything can be turing-complete-challenge-responsed. To extremely reduce the spread of unverified rumors, <func,param,return> cache entries, which are 3 of 256 bit merkle ids (in binary forest of merkle ids, of any chosen hash function such as SHA3_256 with some pre and post processing)... The <func,param> is, in terms of database theory, a primary-key, and the "return" is its only value that it can ever have. Its constant, not changing over time or context. The same function and parameter always gives the same return value, but depending on [what the "Import" combinator/function does, which is entirely undefined other than the <function,parameter,return> style messages they say to eachother], <function,parameter> --> return, will vary but hopefully converge to some consistent view of it all in the whole wiki, which is basically a way to verify and experiment with claimed behaviors of this single function which is defined only by peoples and computers shared beliefs about it, however those may fit together. For example, this function may be learned and converged similar to a neuralnet energy function, to when it receives certain patterns of input (other functions) that it does GPU matrix multiply, a certain musical instrument, SQL queries with extremely faster hyperdimensional mutex convergence at low lag, or anything people and computers together may find useful to define it as, as long as (L x (R x)) recursively in all possible combos of calling the wikibinator (a combinator) on itself in many combos (why its called a combinator, like SKI calculus and pattern calculus)... as long as this (L x (R x)) constraint is true in all possible sparsely observed combos, which is in theory harder to fake longterm than searching for a needle in a haystack of infinite size, because, and here's the very very slightly homomorphic piece of it which protects its security... <func,param> is secureHashed and its return value is not, so those who tend to spread rumors that <func,param> --> someReturn, will not necessarily know what func or param are, just will know the secureHash of concat(func,param) and can repeat to others that secureHash -> someReturn, and as in pattern calculus functions, func and return can be found, if others cooperate recursively, by asking others (L someReturn) which returns func, and asking others (R someReturn) which returns param, in the cases when number of curries (cur) remaining in func (before it would be evaled) is more than 1 (which decreases by 1 with each next curry), since (L x (R x)) equals x, forall x, so <(L x),(R x),x> is a func param return cache entry for every possible x, and the secureHash ids will know their number of curries so you can know if its part of the merkle forest vs some other func param return cache entry. This is the security primitives that the "decentralized wiki style interactive math book" aka wikibinator will be made of which makes it far easier to say true things than to say false things.

```
The 8 opcodes, chosen in the first 3 of 6 parameters...

S x y z //(x z (y z))
T y z //y
FI y z //z, ... I z is F u z
Reflect x y z //x and y define which of 3 things to do (L R IsLeaf) with z, and the cache byte per node does it in 1 step.
Pair x y z //(z x y)
LastInList z //calls LastInList recursively depending if (IsLeaf (R z)), returns (L z) or recurses into (R z).
Curry x y z //(Curry counter linkedList nextParam) --ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
Import z //this is where to hook in plugins, to modify the possible behaviors of (Import z).
	forceDeterminismMode makes Import always eval to infloop or not.
..
cacheByte with isForceDeterminism as high bit, and the low 7 bits are the cache.\
But more likely isForceDeterminism is not part of node itself but is part of NondetNode???

I'm undecided if it will be 6 vs 7 parameters since a comment parameter (in the middle of the 7 parameters
of the universal combinator) might make it much easier for people to understand, vs it might be easy enough
deriveable in the VARARG LAMBDAS of the Curry opcode.
```

--- below is disorganized text which lead to this... ---

The below text is easier to understand if you view it in github "raw" or a plain text viewer, instead of as html which turns newlines into spaces...


TODO examples of java code of how to use N as treemap to get functions,
or javalike code... I want a slightly modified syntax so
I dont have to keep typing the function names in the N interface
and can instead call things more like lambdas but keeping in mind
that it uses map key val key val key val like in lazycl instead of lambda currying directly?
No, I do want it to work by currying, and a treemap will take key as param and return value,
and mput func will curry 3 params (mput aMap key val)->aForkEditedMap.
But I still want the ability for lazycl(key val key val) syntax and java loop syntax,
or something like that.
(lazycl aMap)->aLazyBlob?
Include a ns param (like the context param in occamsfuncer) in the currying?
It would have to be given recursively in every deeper call, like (ns mput ns aMap key val),
but I dont want to write that every time.
I could just use occamsfuncer directly, which has opcodes for lambdas of 1-7 params
and can derive lambdas with deeper curries than that.
But I dont want the FPR cache to be outside the forest of N's, like it is in occamsfuncerVM.
I want something simpler that doesnt have a VM and is not sandboxed,
to get started with and build a sandbox inside parts of it later.

namespace, not built in, is just any param you want to use as a namespace (if any) in forest.
treemap
lazycl
	opencl1.2:...
	java8WithJava4Syntax:...
lazyDedup and FPR without VM, do it in the java8WithJava4Syntax code strings.


{
	
}


lazycl(
	"Code",
	"java8WithJava4Syntax: ...TODO..."
)

TODO write an example code of how I want to use the namespace.
This is java or javalike code, that gets an N used as a namespace,
and can forkEdit that namespace to send it into deeper calls if it wants to,
or can return a forkEdit of the namespace, or can return any N it wants.
This javalike code will be part of an N or is that N itself or something like that,
and I just need a syntax that feels good to use...

N ns = TODO get namespace;
N car = TODO how to get the lispCar func?
N otherThing = TODO;
N x = car(otherThing);
N y = (car otherThing);
N z = car(ns,otherThing);
or what syntax do I want?



N ns = TODO;
//N car = ns("car");
N car = ns.car; //x.y does same as x("y")
No, I dont want to use "." to mean that cuz it means something else in java etc.
N car = car@ns
N abc = c@b@a
No I dont like that syntax.
N car = ns_car
N car = ns?car
N car = ns`car
N car = ns..car


//x.y means x("y") means ((N)x).e("y").
//x..y means what x.y means in java.
N car = ns.car
int hash = ns..hashCode()
N idOfNs = ns..id()

Or how about the syntax only works for keys that start with a capital letter,
so xY means x.Y,
or nsAbcCar means ns.abc.car???


ns.anArray[5](ns.someList)

a = ns.anArray;
five = 5;
sl = ns.someList;
N bcd = a(five)(sl);
N bcd = (a five sl);
N bcd = (a 5 sl);
N bcd = (ns.anArray 5 sl);
N bcd = (ns.anArray 5 ns.someList);
//FIXME do I want to take the symbol "+" out of the syntax and it be a valid var name?
//Would leave a few basic things like = ( ) N in the syntax maybe?
N bcd = (ns.anArray (ns.+ 2 3) ns.someList);
+ = ns.+;
+ = ns("+");
ns = (ns.put ns "someVarName" bcd);
return (ns.pair ns 42);


Do I want pythonlike range(...) objects for loops?
for x in range(2, 30, 3):
	print(x)
for x in range(2, 6):
	print(x)

Dont have any types except N and primitives and primitive arrays... ???
bcd = a(five)(sl);
bcd = (a five sl);
bcd = (a 5 sl);
bcd = (ns.anArray 5 sl);
bcd = (ns.anArray 5 ns.someList);

Should var name have a prefix that tells its type?
Like, if it starts with i then its an int, and if its I then its a 1d int array?
ix = 5;
Ix = new int[345];
Ix[33] = -3;
IIsdf = new int[121][];
aaix = new int[121][]; //Each a means array of it.
anx = new N[2315]; //a of n, named x. No, theres no clear border between the types and the var name x.
jx = 5L;
dx = 5.67;
fx = 5.67f;
nx = (a 5 sl); //type N
x = (a 5 sl); //type N
X = (a 5 sl); //type N
???


Or just let the var names be anything?

Some later java version has "var" which figures out the type at compile time (so is same speed at runtime)
but javassist only has syntax up to java4 (even though it can compile for later java versions).

Or... I could probably with a few hours or days of programming figure out those types so wouldnt
have to write the types. but for now at least, just write the types?

N someFunc = {
	N[] arrayToPermutate = TODO;
	for(int i=0; i<arrayToPermutate..length; i++){
		for(int j=1; j<=i; j++){
			int randIndex = TODO choose rand index 0..j;
			N temp = arrayToPermutate[randIndex];
			arrayToPermutate[randIndex] = arrayToPermutate[j];
			arrayToPermutate[j] = temp;
		}
	}
	//FIXME copy needs to be part of the syntax, similar to = ( ).
	N frozenArray = (copy arrayToPermutate); //arrayToPermutate is still mutable
	N ertjwse = (frozenArray 3 4); //same as ((frozenArray 3) 4).
};

//TODO i want a syntax to inline opencl ndrange kernels, but lazycl compatible which takes map as param,
//so where do the params go such as bSize cSize dSize bc cd bize?
N gpuMatmul = {
	TODO
};
N aMultipliedResult = (gpuMatmul ...WHAT PARAMS GO HERE AND WHAT SYNTAX FOR LAZYCL-MAP-LIKE...);

Must be able to pass in literal N objects (that may be LazyBlobs or other N's) into gpuMatmul,
and still be able to run it as LazyBlobs if its a forest containing multiple of those that can be optimized together.

Must be able to generate the {...} func as a string and eval it to an N,
so...
N aFuncEvaledFromCodeString = eval("{...stuff...}");
Must be able to inline N's into the eval, so...
N aFuncEvaledFromCodeString = eval("{...stuff...}", ns);
Remember, N ns is just another N, and every N is immutable, even though its not sandboxed
so is possible to contain code that acts on the world statefully even though I plan to not do that
and to build a sandbox inside it, using it as a forest of N's, while I'm using the system itself,
to build a sandbox within that.
Basically I want a dangerous forest layer and inside that to build a safe forest layer.



N blah = {
	N ns = TODO;
	ns.anArray[5](ns.someList)
	a = ns.anArray;
	five = 5;
	sl = ns.someList;
	N bcd = a(five)(sl);
	N bcd = (a five sl);
	N bcd = (a 5 sl);
	
	N[] arrayToPermutate = TODO;
	for(int i=0; i<arrayToPermutate..length; i++){
		for(int j=1; j<=i; j++){
			int randIndex = TODO choose rand index 0..j;
			N temp = arrayToPermutate[randIndex];
			arrayToPermutate[randIndex] = arrayToPermutate[j];
			arrayToPermutate[j] = temp;
		}
	}
	
	//FIXME copy needs to be part of the syntax, similar to = ( ).
	N frozenArray = (copy arrayToPermutate); //arrayToPermutate is still mutable
	N ertjwse = (frozenArray 3 4); //same as ((frozenArray 3) 4).
	
	N bcd = (ns.anArray 5 sl);
	N bcd = (ns.anArray 5 ns.someList);
	N aFuncEvaledFromCodeString = eval("{...stuff...}", ns);
	N gpuMatmul = {
		TODO
	};
	N aMultipliedResult = (gpuMatmul ...WHAT PARAMS GO HERE AND WHAT SYNTAX FOR LAZYCL-MAP-LIKE...);
	N pair = ns.pair;
	N pair = ns("pair");
	N put = ns.put;
	return (pair aMultipliedResult (put (put ns "aFuncEvaledFromCodeString" aFuncEvaledFromCodeString) "hello" "world"));  
};


Getting close to what I want the syntax to look like, and remember these are all forest nodes
that can be stored on harddrive as merkle forest as soon as they return (a N, which can be a call pair or lazyblob etc).

Maybe there should be a Fire object, similar to java's Unsafe object,
that can do things like call lazycl (nonsandboxed), call the network, etc,
but things that only risk infiniteloop etc arent "playing with fire" since they're still sandboxed
and just risk having to restart the program.

N ffiirree = Fire; TODO
N whatLazyclReturned = (ffiirree.lazycl aMap);
N downloaded = (ffiirree.download "https://upload.wikimedia.org/wikipedia/commons/a/a3/Ice_water_vapor.jpg");
N downloaded = (ffiirree "download" "https://upload.wikimedia.org/wikipedia/commons/a/a3/Ice_water_vapor.jpg");
N downloader = ffiirree.download;
N downloaded = (downloader "https://upload.wikimedia.org/wikipedia/commons/a/a3/Ice_water_vapor.jpg");

Every N has a cur (number of curries left before eval). Example: (ns.cur aMap) returns 1 cuz (aMap someKey) -> value.

TODO how is the cur of an N defined?
N..cur() is where its stored, but what syntax defines the cur of a {...}?
(cur {..... stuff }) -> 5, cuz the syntax has "....." which is 5 curries.

(cur ({..... stuff } "hello" "world" aMap)) -> 2 cuz it has 3 of its curries.

TODO how will dedup happen without a VM? For example,
is ({..... stuff } "hello" "world" aMap) and ({..... stuff } "hello" "world" aMap) the same N object?

TODO how to FPR cache from a treemap derived and used inside the N's if currying is going to be occamsfuncer-like?



N concatThreeThings = {....
	N self = TODO;
	N ns = TODO get from self's currys;
	N x = TODO get from self's currys;
	N y = TODO get from self's currys;
	N z = TODO get from self's currys;
	N concat2 = ns.concat;
	return (cat2 (cat2 x y) z);
};

N ns = TODO;
N theDogJumps = (concatThreeThings ns "the " "dog " "jumps");


Should I just use occamsfuncer with the {...} function maker differing in its first param
(like occamsfuncer opcodes start with (u u), where u is the universal function,
so this might be (u "nonsandboxedtreeexperiment" ...stuff...).

Occamsfuncer can handle defining curries from 1-7 and where the ns param goes (and a comment param, default comment is u).




This would use occamsfuncer in a nonsandboxed way,
such as it could call (u "nonsandboxedtreeexperiment" ...stuff...) to do dangerous things
and could have infinite loops and generate java code that has infinite loops,
so be careful, but I do need this to get started with doing everythning in a forest
instead of continuing to define things within java namespace. There are no namespaces other than
what exists between a {...} and that cant access names outside it or inside its inner {...}s etc.
Everything is passed as param, including N ns param, by currying,
and theres no sandboxing, no dedup, no FPR caching... except whats derived in the forest itself,
but might have to adjust that strategy of dedup and FPR etc...




Or maybe I just want pairs and lazyblobs and for javalike code (with curry syntax and procedural syntax mixable),
and if you want to use some combo of pairs as a treemap you build a javalike code (store it in an N)
to use it that way.
But how to get that derived func to use a forest of pairsAndLazyblobs as a treemap,
without having such a func already to get itself out of a namespace? Dont want to have to derive it again
at the start of every java code just to get the params etc curried into that java code.

A universal function is a good way to boot that.

Occamsfuncer is such a universal function, but I do have a few variants of it that take less params...
a universal function (thats both a universal lambda function (combinator) and pattern calculus function) is...
..
always curries 7 params, where first param is namespace,
and last 6 params are: opDigitA opDigitB opDigitC paramD paramE paramF,
where the first 3 choose which of 8 opcodes,
and those opcodes are: S T FI L R IsLeaf Pair Curry,
where Curry = Lx.Ly.x(pair x y),
or could do it in 6 params if combined L and R into getPairOfLROf, and put the namespace param as 1 of the opcodes,
but then it would only get 3 params.

Params: rootNamespace opDigitA opDigitB opDigitC paramD paramE paramF.
Ops: S T FI L R IsLeaf Pair Curry.


TODO derive Lx.Ly.x(pair x y), from the other 7 ops... It can certainly be done like how currying is derived in unlambda,
but its confusing and inefficient compared to if its an op.

iota = (pair S T). Can represent all possible combos of currying iotas called on combos of iota, with those 7 opcodes,
not needing the Curry opcode. Derive everything using iota?
For example, derive the Curry "op" but not as an op, using iota?

I'm thinking maybe I want 7 instead of 8 opcodes, so I have space for 1 more, that being
where I'd hook in near anything else such as nonsandboxedtreeexperiment and lazyblob optimizations
(the dirty way, instead of formal verifying them before I start using them, can do that later
after I play with and get used to the system)...

Ops: S T FI L R IsLeaf Pair Import.
Example:
(Import "nonsandboxedtreeexperiment" <somePossibleState> nextParam)
-> (Import "nonsandboxedtreeexperiment" <anotherPossibleState>), which waits on 1 more param.


Ops: S T FI pairOfLROf IsLeaf Pair Curry Import ???

Think of Curry as its state containing 2 linkedlists, one that just counts down,
and the other to append the next param to until the countdown ends then eval.

TODO where does typeval and comment go?

Or do I want to derive the Curry opcode using S and T and Pair etc?
Or do I want to derive a 4 or 5 param form where the funcBody to call on it,
and the 2 linkedlists, each get their own param index?



Ops: S T FI L R IsLeaf Pair Curry??? but i want import op.

or curry of 3 params?...
(Curry x y z) -> x (pair (Curry x y) z)
???
No, curry should be just 2 params: Lx.Ly.x(pair x y).


iota = (pair S T).
Ops: S T FI L R IsLeaf Pair Import ???
No... cuz without the Curry op, the L and R are confusing of how to get stuff out of curries.


Ops: S T FI getPairOfLAndR IsLeaf Pair Curry Import.
Example: (getPairOfLAndR u T xyz) -> left child of xyz.
Example: (getPairOfLAndR u F xyz) -> right child of xyz.
Example: (getPairOfLAndR u) -> (pair <abstractlyThinkOfThisAsL> <abstractlyThinkOfThisAsR>)...
But basically (getPairOfLAndR u T) is L, and (getPairOfLAndR u F) is R.
???


Ops: S T FI pairOfLROf IsLeaf Pair Curry Import.



(Curry counter linkedList nextParam)
-> (Curry (R counter) (pair nextParam linkedList)) IF counter is not u, ELSE
-> funcThatReturns... (deepestThingInTheLinkedlist (pair nextParam linkedList)) where deepestThingInTheLinkedlist is funcBody,
and funcThatReturns has to be called instead of instantly jumping to deepestThingInTheLinkedlist
cuz ops have to be constant cost of computeCycles and memory,
and funcThatReturns calculation is to simply check if its R is u (nil) and if it is then return L of it
else return recursion of that into R of that. Can often be optimized to just cache the deepest thing in the linkedlist.


Ops: S T FI getPairOfLAndR IsLeaf Pair Curry Import,
where Curry does that (Curry counter linkedList nextParam) thing and funcBody is deepest thing in the linkedList,
and an example of counter is (T (T (T (T (T u))))) which is unary counting (similar to lin numbers which have T and F).

So (Curry counter linkedList) is a vararg function.

 


Ops: S T FI getPairOfLAndR IsLeaf Pair Curry Import.

Replace getPairOfLAndR with branching it on param 4 of 6 being u vs anything except u?
(getPairOfLAndR u u x) -> left child of x,
(getPairOfLAndR (u u) u x) -> right child of x
???
Could use <u u> and <(u u) u> and <u (u u)> as isLeaf L and R, so have 1 opcode left to do something else with,
and I have been wanting a typeval opcode as a semantic for things like "image/jpeg" and <bytesOfJpg>,
and other than that it acts like pair.


Ops: S T FI Reflect Pair Typeval Curry Import,
where (Reflect u u x) -> T or F depending if x is the leaf,
and (Reflect (u u) u x) -> left child of x,
and (Reflect u (u u) x) -> right child of x,
or something like that. Make param 4 choose isleaf vs LR,
	and if not(param 4 is leaf) isleaf then param 5 chooses L vs R of param 6.
???


Or instead of typeval (which could use some variant (in param 3 of 6) of pair...
Maybe should have getDeepestThingInLinkedlist (aka LastInList) as an op, which Curry would call,
and which calls itself recursively if R of a param is not u.


Ops: S T FI Reflect Pair LastInList Curry Import.
???


Do I want a comment param and for u to always curry 7 params (a b c comment x y z)???
Would need to redesign Curry...
(Curry comment counter linkedList nextParam) -> (LastInList linkedList (pair (Curry comment counter linkedList) nextParam)),
or if its not enough curries to eval yet: (Curry comment (R counter) (pair linkedList nextParam)),
or something like that (dont forget to put nextParam into the linkedlist)...
???
seems complex.
(LastInList linkedList linkedList) is the simpler eval part (after curries enough params),
aka (LastInList linkedList) -> funcBody, and it evals to (funcBody linkedList_whereFuncBodyIsDeepestThingInIt).

I'm undecided if want comment to exist at this level. Can it go in just 6 params, or does it require expanding to 7
and does it make Curry more complex?

Also its important for linkedList to have funcBody as its deepest part cuz
it allows occamsfuncer-like Compiled.java-like optimization to be curried with the linkedlist as
it continues being appended to, as Compiled is recursively connected to currying.


Universalfunc always takes 6 curried params (not referring to Curry opcode, a lower level of currying)...
Ops: S T FI Reflect Pair LastInList Curry Import.
???

As an optimization, put a byte (used as uint7) in each node, which is a cache of cur and the bit of is each param
curried so far (max 6 of them, and if its 6 then its evaling now)... is that param leaf or anything other than leaf,
with a 1 bit just above that as a positive integer of b bits has a 1 as its highest bit and is a bitstring of b-1 bits.
1 //u
10 11 (u u) vs (u anythingExceptU)
101 110 101 110
1011 1100 1011 1100 1011 1100 1011 1100 (cache after 3 curries, with 3 more curries til eval).
...
1000000..1111111 eval here.
Thats 127 possible byte values in range 1..127. A useful cache.
Use in a switch statement. That means L R and IsLeaf (which depend on 5 params) each have their own byte val
so dont need to look deeper, very fast.

Maybe that other bit in the cache byte tells if its forceDeterministic vs allowNondeterminism??? which related ops
would be in Import???



Ops: S T FI Reflect Pair LastInList Curry Import.
Has Compiled-recursively-optimizable vararg lambdas.
Has no place to put comment param, but maybe put that somewhere in varargs such as
always the first (second deepest, just after the deepest param which is funcBody???) param???


Should Import take just 1 param (ignores params 4 and 5, only uses param 6),
and simply have Curry call Import as needed? I want to, but can it be efficient?
Example: (Import (pair "lazycl" aMap)) -> bitstring that lazycl returns, or param of Import could be a linkedlist etc.
Stateless import. Import is a function of 1 param that together contains all possible plugins or whichever are loaded.

S x y z //(x z (y z))
T y z //y
FI y z //z, ... I z is F u z
Reflect x y z //x and y define which of 3 things to do (L R IsLeaf) with z, and the cache byte per node does it in 1 step.
Pair x y z //(z x y)
LastInList z //calls LastInList recursively depending if (IsLeaf (R z)), returns (L z) or recurses into (R z).
Curry x y z //(Curry counter linkedList nextParam) --ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
Import z //this is where to hook in plugins, to modify the possible behaviors of (Import z).
	forceDeterminismMode makes Import always eval to infloop or not.
..
cacheByte with isForceDeterminism as high bit, and the low 7 bits are the cache.\
But more likely isForceDeterminism is not part of node itself but is part of NondetNode???



TODO where to put comment?



TODO? Put a Blob field in every node, as a cache of cbt, to hook into lazycl etc, especially that LazyBlob is-a Blob.


TODO rename "Import" to "CallccUniverse" or "Observer" or something like that?












































































