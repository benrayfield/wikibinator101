/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;
import java.util.function.BinaryOperator;

import wikibinator.*;

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
	public static final byte opS = 0,
		opT = 1,
		opFI = 2,
		opReflect = 3,
		opPair = 4,
		opSecondLastInList = 5,
		opCurry = 6,
		opWiki = 7;
	
	
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
	public static void infloop(){
		throw new RuntimeException("TODO define the S and I funcs");
		//TODO return S.e(I).e(I).e(S.e(I).e(I));
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
	infinite loops for all possible params such as Lx.(S I I (S I I)) (todo write that without the Lx.
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
	since the first 3 params (of u) are each either u or anything_except_u to choose between the 8 ops
	which are each a lambda of 3 params (6 params of u), or some ops (Reflect) also uses params 4 and 5
	to choose between IsLeaf, L, and R, of the last param (6 of 6).
	*/
	public static final λ Typeval = null; //FIXME not null
	
	public static λ cp(λ func, λ param){
		return Cache.cp(func, param);
	}
	
	public static λ cpcp(λ func, λ param){
		return Cache.cpcp(func, param);
	}

}


