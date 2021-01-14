package debugstepinator_old;

/** like turing tape cell color.
As of 2021-1-11 I'm very uncertain about what the right colors (turing-colors) are,
what kinds of things should be a color vs a pattern of shapes in the trinary forest
or 4-way direced graph if you include the nextState edges.
TODO emulate wikibinator in it to work out those details, and write testcases,
and try to fake the colors and see if such fakes can be disproven (similar to TruthValue.bull
but in this system any node being multiple colors at once is the only kind of error in the abstract math,
other than practical problems like finding a node thats across a network or merkle hash ids).
*/
public enum Color{
	
	/*Color is derived deterministicly and instantly (bigO(1)) in step, of course allowing for
	GPU and WIKI to have DFP nodes generated, including their color, and to debugStepOver using those,
	including SPEND-like ops, which we may evolve a variety of in opensource forks of the VM, in WIKI.
	
	There are no TruthValue.unknown in Debugstepinator since every node is a specific statement,
	such as you maybe dont know what a certain (func param) returns, so you dont have to say you dont know,
	you just dont have a node that represents (func param)->aRet or (func param)->anotherRet
	or even (aFunc param)->aFunc the same aFunc called on param.
	The unknowns seem to prevent a kind of self-reference that was preventing me from
	creating the text syntax of the language without the names of things and lazy calls they referred to
	being at transfinite level while the lambdas were below transfinite,
	so instead I want everything to be at the lambda level with no transfinite,
	or maybe you could still have a statement that a certain call does not halt
	such as (S I I (S I I)) does not halt we know that for sure,
	but some things it might just be claimed it does not halt and that could be disproven
	(same node has more than 1 color, means error) by finding that it returns a certain node.
	It would be the choice of the the many people and computers in p2p networks if they believe
	that certain nodes are certain colors or not, but all trinary forest shapes are valid nodes though
	may have Color.ignore as a way to say theyre valid nodes but have no other effect.
	
	Godel-number-like-statements are still 256 bit and just have a hash and a color.
	
	Spend, wallet, solve, etc calls are still done in the WIKI function, as in Color.wiki,
	and like GPU optimizations, the WIKI works by accumulating RFP cache entries that are colored consistent together.
	*/
	
	//TODO Optimizations like lwjgl opencl compiling matmul, will create RFP cache entries
	//which are specific Nodes with specific colors that will fit in as if they had been
	//computed the pure interpreted way but can debugStepOver using them regardless how they were created.
	//(debugstepinatorGPUEtcOptimizationsWillCreateRFPCacheEntriesAsDebugstepinatorNodesThatCanBeDebugStepOver)
	//
	//wikiCalls(evenIfRecursiveOfWiki)WillBeDoneSimilarTo_debugstepinatorGPUEtcOptimizationsWillCreateRFPCacheEntriesAsDebugstepinatorNodesThatCanBeDebugStepOver
	
	
	//FIXME should there be twice as many colors, an isDirty vs !isDirty (nondeterministic vs deterministic) form of each
	//like wikibinator HeaderBits.isDirty? Probably so, but todo work out those details after get the deterministic form working.
	
	/** Not all trinary forest nodes can be derived, as the node.v (vmState) param
	has to come from x.nextState.nextState... But if someone just puts together an arbitrary trinary forest shape,
	that still needs to be a valid node, and its color is IGNORE unless it can be derived from nextState of some derivable node,
	or at least that it can not be derived to have any other color.
	Godel incompleteness, halting problem, etc, may be related to this. TODO think more about this possible design.
	*/
	ignore,
	
	/** a universal function (must be universal lambda function (combinator) and pattern calculus function,
	such as wikibinator or occamsfuncer (other than occamsfuncer's nondet func takes more than 1 param so is Color.wiki-incompatible)).
	*/
	leaf,
	
	/** is the function where all nondeterminsm goes such as the wiki opcode in wikibinator,
	or if occamsfuncer's nondet op took only 1 param (which it has more) then that would be one of these (which its not).
	*/
	wiki,
	
	/** any node x where x.v==Node.LEAF and therefore x.c==Color.leaf */
	newCall,
	
	/** a cbt1 aka 1 bit, and that bit is T/1 */
	T,
	
	/** a cbt1 aka 1 bit, and that bit is F/0 */
	F,
	
	/** efficient bitstring of any size. a cbt is T or F or (pair aCbt anotherCbt) aka ((pair aCbt) anotherCbt) */
	cbt2,
	cbt4,
	cbt8,
	cbt16,
	//...
	//cbt<2^62>,
	
	/** any cbt size that doesnt fit in the specific sizes named by a color (maybe its up to 2^62 bits each?) */
	cbtBig,
	
	/** (pair aCbt) like described in the comment of Color.cbt */
	pair_cbt2,
	pair_cbt4,
	pair_cbt8,
	//...
	//pair_cbt<2^62>,
	pair_cbtBig,
	
	/*FIXME instead of outerjoining cbt with those sizes, should ALL colors be joined with wikibinator HeaderBits heightByte?
	So a color would be similar to a heightByte and an opByte but might also have some of the other parts of HeaderBits?
	Maybe, but try to keep the number of colors fewer, and it has to differ some from just wikibinator
	since wikibinator is less self-referencing than this, as this ONLY has halted states and every call returns in bigO(1)
	and you just step more often.
	*/
	
	/** a claim of [[returnVal func param]] where (func param)->returnVal. */
	RFP,
	
	/** see comment of twoRFPWithSameFPAndDifferentR. Also see errorExistsAnywhere which we might not need all these colors. */
	twoRFPWithSameFPAndSameR,
	
	/** twoRFPWithSameFPAndSameR and twoRFPWithSameFPAndDifferentR are the main 2 colors that will disagree with eachother,
	depending if (x y)->z and (x y)->z vs (x y)->b and (x y)->z cuz b!=z and z==z.
	Its trivially true that if F and P equal then R must equal,
	but to say that in terms of color, you need to say it the trivial way using twoRFPWithSameFPAndSameR
	and also derive the 2 different return values and say them together using twoRFPWithSameFPAndDifferentR.
	<br><br>
	Also see errorExistsAnywhere which we might not need all these colors.
	*/
	twoRFPWithSameFPAndDifferentR,
	
	/** The slower way, thats your only choice if you cant debugStepOver using an existing RFP cache,
	debugStepInto creates RFP cache when (or if ever) it pops back to the same position on stack,
	where stack is emulated in callquad.stack and callquad.cacheKey and callquad.isParentsFunc (which are emulated in Node).
	All possible paths of debugStepInto and debugStepOver from the same lambda call lead to the same returnVal.
	*/
	debugStepInto,
	
	/** in occamsfuncer this is when 2 callquads are used together, one being a RFP cache
	and the other wanting to know what FP (func param) returns (R) and uses that.
	All possible paths of debugStepInto and debugStepOver from the same lambda call lead to the same returnVal.
	*/
	debugStepOver,
	
	/** count emulatorLevel as unary numbers in the Node.v child, such as (T (T (T leaf))) is unary3 and leaf is unary0 */
	pushEmulatorLevel,
	
	/** count emulatorLevel as unary numbers in the Node.v child, such as (T (T (T leaf))) is unary3 and leaf is unary0 */
	popEmulatorLevel,
	
	/** Any node that can reach a node whose color can derive errorExistsAnywhere
	will only create or find nodes whose color is errorExistsAnywhere,
	so like a cellularAutomata in the sparse dimensional space, anything touching error becomes error,
	therefore any non-error color (colors other than errorExistsAnywhere) will become errorExistsAnywhere
	and contradict that things have only 1 color.
	TODO I'm unsure if need both this and twoRFPWithSameFPAndDifferentR?
	*/
	errorExistsAnywhere;
	
	//TODO

}
