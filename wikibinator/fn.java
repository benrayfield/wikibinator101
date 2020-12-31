package wikibinator;

import java.util.function.UnaryOperator;

/** function, the core object type. The generic T in fn<T> is normally LazyBlob
and is where you put optimizations, or it might also be int[] or byte[] or double[]
or any representation of a cbt (complete binary tree of pairs of pairs... of T and F as bits),
but LazyBlob is all those things.
*/
public interface fn<T> extends UnaryOperator<fn>{
	
	/** UnaryOperator<fn>. just calls e(fn). Its important for names you use alot to be short. */
	public default fn apply(fn param){
		return e(param);
	}
	
	
	/** lambda call. The e means eval. */
	public fn e(fn param);
	
	/** finish evaling this, if its not already halted. Calling this.e(fn) doesnt ned another .e()
	cuz that finishes evaling. If you want a lazyEval like in occamsfuncer (other than deriving that at user level)
	then name it f(fn) similar to e(fn) and use a step (debuggerStepInto andOr debuggerStepOver)
	like in occamsfuncer's OcfnUtil.
	*/
	public fn e();
	
	/** I'm undecided if will have this function. Its a lazy call (ot her than deriving that at user level)
	similar to step func doing debuggerStepInto andOr debuggerStepOver in occamsfuncer's OcfnUtil.
	*/
	public fn f(fn param);
	
	/** (L x (R x)) equals x, forall x. */
	public fn L();
	
	/** (L x (R x)) equals x, forall x. */
	public fn R();
	
	/** Normally used in a switch statement.
	The combinator/universalFunction u takes 6 params. It has 0-6 params, or 0-5 if you dont
	create an object to represent the evaling (like happens in occamsfuncer callquad).
	It evals when it gets to 6. This byte is a bitstring of 0-6 bits, with a high 1 bit, so numbers 1-127,
	and the sign bit (highest bit) goes above that and means isDirty (if negative) vs isForceDeterminism (if nonnegative),
	except if the low 7 bits are 0 (is 0 or -128, or if unsigned thats 0 or 128) then it means its evaling
	such as if you somehow were able to (TODO depending on how the VM is coded, but leads to the same return value)
	call something that was evaling on something that was evaling (or if either of the 2 things was evaling and the other halted)
	then such 0 (in the low 7 bits of the byte) means that, so when it finishes evaling, compute the byte of that
	result from the 2 bytes of its 2 childs, whatever it halts on,
	or if it does not halt, then the normed form of nonhalter is (S I I (S I I)) which is a simple infinite loop,
	if you wanted to send to other people on the internet a <func,param,return> cache entry
	claiming that <func,param> does not halt, then you would send <func,param,(S I I (S I I))> which has 6 params,
	and there are 2 forms of it, as theres 2 forms of everything, with its high bit of the byte being 0 or 1.
	*/
	public byte op();
	
	/** bits of cbt, or null if this is not a cbt or is not optimized as such a wrapper. See comment of this class. */
	public T cbt();
	
	public static byte op(byte leftOp, byte rightOp){
		//TODO optimize using byte[1<<16]? Or is this faster? Probably this (computing it every time
		//instead of caching, way) is faster even though that would fit in L2 cpu cache.
		
		TODO does leftOp have 6 params (is not halted), and same question for right op?
		TODO are the low 7 bits of either of them 0, meaning at least 1 of the 2 childs
		(2 childs of leftOp or 2 childs of rightOp) is not halted?
		TODO
		
		return (byte)(
			((leftOp|rightOp)&(1<<7)) //sign bit is OR of sign bits
			| 
		);
	}
	
	/** isDirty vs isForceDeterminism. If isForceDeterminism (aka !isDirty)
	then the import/callccUniverse/observer opcode (1 of 8 opcodes) evals to (S I I (S I I)) aka an infinite loop.
	If isDirty then that function can compute whatever the "wiki" or converging agreement of many people and computers
	thinks that function should do, as this spec does not define any behaviors of that function
	other than forall x, (L x (R x)) equals x, which makes it a pattern calculus function
	(and is also a universal lambda function aka combinator) which is why its called wikibinator.
	*/
	public static boolean isDirty(byte op){
		return (op&0x80)!=0;
	}
	
	/** Range 0-6. Number of params more to curry before this would eval.
	If 0, is now evaling. If 6, its u (aka the universal function).
	*/
	public static int cur(byte op){
		//TODO optimize using byte[256]? Or is this faster?
		int i = (op&0x7f); //0..127
		if(i == 0) return 0;
		if(i == 1) return 6; //is u
		return cur((byte)(i>>1))-1; //TODO verify this is not offby1
	}
	
	public static boolean isHalted(byte op){
		//TODO optimize by not computing which nonzero value cur is, just is it 0 or not.
		return cur(op)!=0;
	}
	
	/** This is what happens when you call an evaling on an evaling,
	or a halted on an evaling, or an evaling on a halted.
	If it just started to eval, then its op would be in range 64-127 (or that minus 128 as the isDirty bit).
	*/
	public static boolean areLow7BitsOfOpAll0(byte op){
		return (op&0x7f)==0;
	}
	
	public static boolean isLeaf(byte op){
		return (op&0x7f)==1;
	}
	
	public default boolean isLeaf(){
		return fn.isLeaf(op());
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
	public static byte opS = 0,
		opT = 1,
		opFI = 2,
		opReflect = 3,
		opPair = 4,
		opSecondLastInList = 5,
		opCurry = 6,
		opImport = 7;

}
