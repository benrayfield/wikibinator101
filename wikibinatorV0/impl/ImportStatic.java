/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0.impl;
import java.util.function.BinaryOperator;

import wikibinatorV0.Compiled;
import wikibinatorV0.WikiState;
import wikibinatorV0.λ;

public class ImportStatic{
	
	public static byte funcOpAndParamOpToParentOp(byte leftOp, byte rightOp){
		//TODO optimize using byte[1<<16]? Or is this faster? Probably this (computing it every time
		//instead of caching, way) is faster even though that would fit in L2 cpu cache.
		
		/*TODO does leftOp have 6 params (is not halted), and same question for right op?
		TODO are the low 7 bits of either of them 0, meaning at least 1 of the 2 childs
		(2 childs of leftOp or 2 childs of rightOp) is not halted?
		TODO
		*
		
		return (byte)(
			((leftOp|rightOp)&(1<<7)) //sign bit is OR of sign bits
			| 
		);
		*/
		throw new RuntimeException("TODO");
	}
	
	/** isDirty vs isForceDeterminism. If isForceDeterminism (aka !isDirty)
	then the import/callccUniverse/observer opcode (1 of 8 opcodes) evals to (S I I (S I I)) aka an infinite loop.
	If isDirty then that function can compute whatever the "wiki" or converging agreement of many people and computers
	thinks that function should do, as this spec does not define any behaviors of that function
	other than forall x, (L x (R x)) equals x, which makes it a pattern calculus function
	(and is also a universal lambda function aka combinator) which is why its called wikibinator.
	*/
	public static boolean opIsDirty(byte op){
		return (op&0x80)!=0;
	}
	
	/*
	he 8 opcodes, chosen in the first 3 of 6 parameters...

	S x y z //(x z (y z))
	T y z //y
	FI y z //z, ... I z is F u z
	Reflect x y z //x and y define which of 3 things to do (L R IsLeaf) with z, and the cache byte per node does it in 1 step.
	Pair x y z //(z x y)
	SecondLastInList z //calls SecondLastInList recursively depending if (IsLeaf (R z)), returns (L z) or recurses into (R z),
		UPDATE: use second last in list as funcBody,
		and last in list is comment but has no effect other than L and R and IsLeaf can see it,
		which is why there will be 6 (instead of 7) params of the universalFunction
		(no comment param in those, it goes in the vararg lambdas).
	Curry x y z //(Curry counter linkedList nextParam) --ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
	Import z //this is where to hook in plugins, to modify the possible behaviors of (Import z).
		forceDeterminismMode makes Import always eval to infloop or not.
	..
	cacheByte with isForceDeterminism as high bit, and the low 7 bits are the cache.\
	But more likely isForceDeterminism is not part of node itself but is part of NondetNode???
	*/
	
	/*Theres already 32 opcodes in the 6 params of the universalFunc, as the first 5 params each being leaf vs nonleaf.
	UPDATE: actually 64 opcodes by counting the isDeterministic bit in header (TODO put that beside the 7 curryLeaf
	bits aka the byte op, so its actually 8 adjacent bits a byte, which is actually 16 bits in 2 places as 8 TruthValues).
	UPDATE: actually theres around 128 (126?) opcodes cuz of counting there being 0..6 curries like binheap indexing,
	and if we count the last param its back to 256... This was an optimization I was already planning,
	but it helps to explain it as fewer categories of opcodes branching from each of 0..6 params
	being leaf vs anyNonleaf vs isLastParam.
	...
	TODO 32 opcodes (some of which are duplicates, especially to put T and F 4 deep and typeval is 3 deep,
	so the byte opcode (which knows leaf vs nonleaf) can identify if something is the typeval symbol,
	if something is (typeval x), vs if something is (typeval x y).
	So the typeval semantic, unlike the text I wrote about it being at user level near here,
	is at the universal function level, but what the types mean (other than acting exactly like the pair func)
	is still decided at user level. Its just a pair of 2 pieces of data (functions are data)
	implying "the typeval semantic" mostly for display and helping to organize many existing semantics on the internet,
	a place such things could be hooked in and evolved together.
	Make the third param (if first 2 params are something) decide if its pair vs typeval
	so we can say the third param is the isSemantic bit (after 2 other params being leaf vs nonleaf each),
	and regardless of isSemantic vs !isSemantic, it computes the church pair lambda aka λx.λy.λz.zxy,
	and as a pair or typeval its only curried x and y so doesnt do that yet.
	/*
	
		FIXME, whichever of these typeval goes in has to be an odd number,
		and I might want to to go in pair,
		such as op5 is (λ (λ λ) λ (λ λ)) and if pair was changed to be op5
		then could use (λ (λ λ) λ (λ (λ λ))) as typeval aka (λ (λ λ) λ (λ (λ λ)) "image/jpeg" ...thebytes...)
		which would still technically be a pair lambda since (λ (λ λ)) is not leaf,
		and the opReflect are chosen by the first 3 params being either leaf or any nonleaf,
		but by L and R etc can check if third param is (λ (λ λ)), or maybe just make it be "typeval",
		so could derive an isTypeval func that can tell the difference between a normal pair and a typeval pair.
		Typeval is needed for a bunch of existing stuff on the internet to fit in
		without being displayed as raw bits, such as string would have a typeval, and double would have a typeval,
		and double[] would have a typeval... It doesnt change anything except that certain funcs
		might be designed to look for that datastruct. Its still exactly described by the universal func math.
		Its something you can build using that math.
		...
		Or maybe just put "double[]" in that third param, since any "type" other than λ and (λ λ) would work,
		as (λ λ) is normally whats used for the "anything except leaf".
		...
		Ive moved opPair to be op 1 (of 0..7) so its an odd number.
		TODO update the newest *.λ example code which derives op0..op7, but other places are using these constants.
		...
		Example typeval:     (λ λ λ "typeval" "image/jpeg" thebytes)
		Example normal pair: (λ λ λ (λ λ) "image/jpeg" thebytes)
		WAIT... If Im putting the symbol for typeval in third param then I dont need it to go in pair.
		Could just use T.l or F.l aka T or F with 1 less param, and put the param there
		(λ takes 6 params, 3 of which choose op and 3 are the params of that op, but not every op needs all 3 params).
		Its not something that has to be decided before building it, since its derived as user level code
		and anyone who doesnt like it can just not use those functions and derive their own functions to use instead
		and share those across the internet and get a bunch of other people to use it with them
		and obsolete the kind of typeval I define here.
		But you cant easily do that for the universal function of 6 params,
		at least not without breaking compatibility.
		...
		Or could use (λ "image/jpeg" thebytes) as such a typeval, since anything with less than 6 params is halted.
		We could view anything other than (λ (λ λ)) and (λ λ) that has 2 params as a typeval,
		and the type would be anything other than λ and (λ λ). You could have functions in the type,
		such as x is type y if (y x)->T or if (y x) halts would be another semantic (instead of halting on T or F).
		I put the 8 opReflect back as their old order. It doesnt really matter what order they are
		as long as its constant, and changing a single bit to swap between T and F is important.
		But... do I want a typeval symbol like (λ "typeval" "image/jpeg" thebytes),
		or just to be able to say things like (λ "image/jpeg" thebytes)?
		A typeval symbol is useful in that it implies you should display its first param as a string
		if its first param is a bitstring. For binary, could use deeper datastructs than just a string.
		
		TODO merge T and FI since they both only take 2 params,
		giving space for Typeval to be 1 of the 8 opcodes.
		Make typeval and pair do the same thing except differ by 1 opcode bit, similar to T and F differ by 1 bit.
		Theres actually 32 opcodes, some of which are duplicates, depending on if the first 5 (of 6) params are leaf vs anything other than leaf,
		so just put that in the switch statement.
		Typeval will be 1 of them, a duplicate of Pair but with a semantic that means it should be viewed as a type and value of some kind.
	*/	

	public static final byte
		opWiki_1 = 0, //1. TODO for possible future expansion? theres space to put 3 more unary ops here, or 1 more that takes 2 params and 1 more unary.
		opReflect_3 = 1, //3: L 1, R 1, IsLeaf 1, isDeterministic 1.
		opTFI_3 = 2, //3
		opS_3 = 3, //3
		opPair_3 = 4, //3
		opTypeval_3 = 5, //3, same as opPair except the semantic
		opSecondLastInList_1 = 6, //1. TODO for possible future expansion? theres space to put 3 more unary ops here, or 1 more that takes 2 params and 1 more unary.
		opCurry_3 = 7; //3
			
			
		//Have 1 more space coult put a 1 param func,
		//but 6 params is simpler than 5 cuz would squash them together too tightly.
		//Keep it as 6 params. Its maybe the best possible digital universal function, either that or is very close to it.
	
	public static final byte opWiki00=opWiki_1*4, opWiki01=opWiki_1*4+1, opWiki10=opWiki_1*4+2, opWiki11=opWiki_1*4+3;
	public static final byte opS00=opS_3*4, opS01=opS_3*4+1, opS10=opS_3*4+2, opS11=opS_3*4+3;
	public static final byte opTFI00=opTFI_3*4, opTFI01=opTFI_3*4+1, opTFI10=opTFI_3*4+2, opTFI11=opTFI_3*4+3;
	public static final byte opSecondLastInList00=opSecondLastInList_1*4, opSecondLastInList01=opSecondLastInList_1*4+1, opSecondLastInList10=opSecondLastInList_1*4+2, opSecondLastInList11=opSecondLastInList_1*4+3;
	public static final byte opTypeval00=opTypeval_3*4, opTypeval01=opTypeval_3*4+1, opTypeval10=opTypeval_3*4+2, opTypeval11=opTypeval_3*4+3;
	public static final byte opPair00=opPair_3*4, opPair01=opPair_3*4+1, opPair10=opPair_3*4+2, opPair11=opPair_3*4+3;
	public static final byte opCurry00=opCurry_3*4, opCurry01=opCurry_3*4+1, opCurry10=opCurry_3*4+2, opCurry11=opCurry_3*4+3;
	public static final byte opReflect00=opReflect_3*4, opReflect01=opReflect_3*4+1, opReflect10=opReflect_3*4+2, opReflect11=opReflect_3*4+3;
	
	/*
	public static final byte opWiki00=opWiki_1*4, opWiki01=opWiki_1*4+1, opWiki10=opWiki_1*4+2, opWiki11=opWiki_1*4+3;
	public static final byte opS00=opS_3*4, opS01=opS_3*4+1, opS10=opS_3*4+2, opS11=opS_3*4+3;
	public static final byte opTFI00=opTFI_3*4, opTFI01=opTFI_3*4+1, opTFI10=opTFI_3*4+2, opTFI11=opTFI_3*4+3;
	public static final byte opSecondLastInList00=opSecondLastInList_1*4, opSecondLastInList01=opSecondLastInList_1*4+1, opSecondLastInList10=opSecondLastInList_1*4+2, opSecondLastInList11=opSecondLastInList_1*4+3;
	public static final byte opTypeval00=opTypeval_3*4, opTypeval01=opTypeval_3*4+1, opTypeval10=opTypeval_3*4+2, opTypeval11=opTypeval_3*4+3;
	public static final byte opPair00=opPair_3*4, opPair01=opPair_3*4+1, opPair10=opPair_3*4+2, opPair11=opPair_3*4+3;
	public static final byte opCurry00=opCurry_3*4, opCurry01=opCurry_3*4+1, opCurry10=opCurry_3*4+2, opCurry11=opCurry_3*4+3;
	public static final byte opReflect00=opReflect_3*4, opReflect01=opReflect_3*4+1, opReflect10=opReflect_3*4+2, opReflect11=opReflect_3*4+3;
	*/
	
	/** TODO derive a fn which computes getComment instead of hardcoding it here */
	public static λ getComment(λ anyVarargLambda){
		throw new RuntimeException("cur(anyVarargLambda)==5 and the first 3 params are the 3 bits of opCurry and param 5 of 5 is a linkedlist of at least size 1, then the last thing in that linkedlist is the COMMENT (and second last thing in that linkedlist (if its size is at least 2) is funcBody, and after that in reverse order are curried params of that funcBody. Else the comment is u.");
	}
	
	/** TODO derive a fn which computes setComment instead of hardcoding it here. */
	public static λ setComment(λ any, λ comment){
		throw new RuntimeException("TODO, counterpart of getComment, and if its not a vararg lambda already, wraps it in one which computes the same thing as it (other than reflection by L R IsLeaf which would see that its wrapped.");
	}
	
	public static Compiled wrapInCompiled(BinaryOperator<λ> callXOnYReturnsZ){
		return new SimpleCompiled(callXOnYReturnsZ);
	}
	
	/** eval an infinite loop made of lambdas, so that if the lambdas are inside a spend call (in wiki)
	or something like that, then depending what kind of caller that is it can detect
	that more compute resources (compute cycles, memory, etc) are about to be used than allocated
	and choose to smite/backOut/giveUp and do something else (near the spend call which this is a recursion of),
	or in pure determinism mode (!isDirty(byte op)) this will actually infinite loop,
	keeping in mind that pure determinism can exist as a call inside nondeterminism
	thats deterministic higher on stack and nondeterministic lower on stack.
	*/
	public static λ infloop(){
		throw new RuntimeException("TODO define the S and I funcs");
		//TODO return S.e(I).e(I).e(S.e(I).e(I));
	}
	
	/** called by SimpleFn.interpretedMode etc to infloop and be a semantic in the VM code
	that such behavior might change in a future version, and infloop is the easiest to change.
	*/
	public static λ reservedForPossibleFutureExpansion(){
		return infloop();
	}
	
	/** the leaf which all paths in binary forest lead to,
	the universal function called "wikibinator" which always curries 6 params
	and which is a universal lambda function (combinator) and pattern calculus function
	and has simple opcodes designed for creating all possible vararg lambdas
	(any integer number of params, no overflow since its by unary counting).
	*/
	public static final λ U = null; //FIXME not null
	
	public static final λ S = null; //FIXME not null
	
	public static final λ T = null; //FIXME not null
	
	public static final λ F = null; //FIXME not null
	
	public static final λ I = null; //FIXME not null
	
	public static final λ Reflect = null; //FIXME not null
	
	public static final λ IsLeaf = null; //FIXME not null
	
	public static final λ L = null; //FIXME not null
	
	public static final λ R = null; //FIXME not null
	
	public static final λ Pair = null; //FIXME not null
	
	/** aka SecondLastInList. gets the second last thing in a linkedlist, where funcBody goes as used by Curry */
	public static final λ GetFuncBody = null; //FIXME not null
	
	public static final λ Curry = null; //FIXME not null
	
	/** a function that is entirely undefined other than what many people and computers agree
	are its possible behaviors in terms of accumulating <func,param,return> cache entries
	which are consistent with (L x (R x)) equals x forall x AND the logic constraints
	defined in SimpleVM.interpretedMode which apply to every possible set of around 20
	number of <func,param,return>s (or some set size around that? todo find it exactly),
	but its actually only a very specific subset of those not all permutations of them,
	which can be computed procedurally forward efficiently and in theory some simple combos of it
	will be GPU optimized. Wiki is a function that people and computers edit together
	and is the ONLY state in the system, and abstractly it can be viewed as
	the system is running in an emulator which takes a wiki function as a parameter
	and replaces all calls of the wiki opcode with that parameter,
	so can be viewed as purely deterministic, but in practice we wont actually store
	the wiki as a forest of call pairs like other functions are normally stored
	and will instead deal with it by a bunch of plugins and math proofs
	of how they fit together, or something like that.
	This wiki function is meant to scale to the size of the whole internet
	at gaming-low-lag such as for example you could mount every existing cloud inside it
	as long as its done in a stateless way such as various people or computers
	generate digital signatures (digsig) which they use to sign messages
	that claim some cloud or another (or whatever external system such as a game controller or anything)
	...claim that some external system responded with some message when sent another message,
	or such clouds may generate their own publickeys or ways of statelessly hooking in.
	I dont really care how any system hooks in as long as together they converge toward
	a single stateless function called wikibinator where a certain binary forest node in
	it (the wiki op of 5 params, leaving the 6th param as the param the (some possible function
	thats currently the) wiki function sees and whatever wiki returns is what that op returns),
	so you actually dont have to use publickeys and could just somehow informally agree
	on the possible behaviors of the wiki function, maybe using int64 ids
	or that certain data structures its called on are certain functions like spend, wallet, solve,
	andOr mount a tiny implementation of linux into it with time-and-memory-mapping
	like 64 bits of time (nanoseconds since year 1970 utc and 32 bits of memory space
	each mapping to 32 bits at that address, or 62 bits of address and 2 bits of value
	where 10 means that bit is certainly 1 and 01 means that bit is certainly 0
	and 00 means dont know what value that bit has (such as cuz its in the future
	and the bloomfilter (of 00 10 01 at 2^126 possible sparse addresses) hasnt accumulated
	any statements about them (each statement being 128 bits)... for example...
	The wiki function could be used for many possible things.
	The rest of the universal function (which wiki is 1 of its opcodes) is only for controlflow
	and keeping track if which things are isDirty vs !isDirty,
	where a binary forest node isDirty if it is the result of nondeterminism (which exists only in wiki function),
	and if a !isDirty function tries to call wiki then it sees wiki as a function that
	infinite loopReflect for all possible params such as Lx.(S I I (S I I)) (todo write that without the Lx.
	and instead in terms of U/theUniversalFunc itself... I have a lazig somewhere
	that takes 3 params and calls the first on the second ignoring the first, but waits for all 3,
	so a deterministic function would see the wiki function as (lazig (S I I) (S I I)),
	while a nondeterministic function might see a grid of memory mapped linuxes
	and game controllers and bigdata storage and minigames and pieces of interesting math functions
	inside the wiki.
	*/
	public static final λ Wiki = null; //FIXME not null
	
	public static final λ SetComment = null; //FIXME not null
	
	public static final λ GetComment = null; //FIXME not null
	
	/** call the current state of the wiki on a function to get a function */
	public static λ wiki(λ param){
		return WikiState.wiki.apply(param);
	}
	
	//TODO this kind of thing, and spend/wallet/solve/etc has to go in Wiki
	//public static final fn TightenToDeterministic = null; //FIXME not null
	
	
	/** Just a semantic, used for things like (typeval "image/jpeg" <bytesOfJpg>).
	Todo put something other than u and (u u) in param 3 of 6, in pair? so its still a pair op
	since the first 3 params (of u) are each either u or anything_except_u to choose between the 8 opReflect
	which are each a lambda of 3 params (6 params of u), or some opReflect (Reflect) also uses params 4 and 5
	to choose between IsLeaf, L, and R, of the last param (6 of 6).
	*/
	public static final λ Typeval = null; //FIXME not null
	
	public static λ cp(λ func, λ param){
		return Cache.cp(func, param);
	}
	
	public static λ cpcp(λ func, λ param){
		return Cache.cpcp(func, param);
	}
	
	/** create long from high and low 32 bits */
	public static long ii(int high, int low){
		return (((long)high)<<32)|(low&0xffffffffL);
	}
	
	/** high 32 bits of long */
	public static int hi(long j){
		return (int)(j>>32);
	}
	
	/** low 32 bits of long */
	public static int lo(long j){
		return (int)j;
	}

}


