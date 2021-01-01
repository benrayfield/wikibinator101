package wikibinator;
import static wikibinator.impl.ImportStatic.*;
import java.util.function.UnaryOperator;
import wikibinator.Compiled;
//TODO import immutable.lazycl.Blob;

public strictfp interface λ extends UnaryOperator<λ>, /*Blob,*/ ob{
	
	/*TODO use binheap indexing to do what Blob does for a linear range, instead of implementing Blob?
	Im thinking of storing the first n bits in each cbt in all higher binary forest nodes,
	which would mean those n bits, an optimization specialized in cbts (pair of pair of pair... of T vs F).
	or something like that.
	
	TODO put into Wiki.wiki the spend/wallet/solve/etc ops (how to make all possible calls halt within chosen time limit etc),
	or specificly put into wiki <func,param,return> cache entries (<func,param> is primaryKey, and return is value,
	and each <func,param> never changes its value after its first observed except by accidental lack of sync etc
	and such conflicts should statistically converge to a consistent model of the world and space of possibilities
	as measured by (L x (R x)) equals x forall x (such as (L u)->I and (R u)->u and (I u)->u).
	*/
	
	
	/**
	//L and R functions removed. Derive them by combons of the universal function,
	//save them in 2 vars named fn L and fn R, and use L.e(this) and R.e(this).
	//cuz, what if you dont really need those but you want a 4096 way tree instead, in some cases?
	//Put things in the <func,param,return> cache so that when L and R are called on this,
	//they will know this's L and R are those things.
	???
	No, put the L() and R() funcs here....
	Or more generally binheap indexing (like in urbit) where 1 is this, 2 is L(), 3 is R(),
	4 is L().L(), 7 is R().R(), and in general the left child of index x is 2*x
	and the right child of index x is 2*x+1.
	Remember, a cbt/Blob is made of (pair x y) aka ((pair x) y) so is twice as deep as you might expect
	so is more like an int binheapIndex but costs a long.
	I'm creating a function just for that, which skips the (pair x) and branches directly to L().R() or R() with each bit,
	and this function is G(long cbtBinheapIndex).
	*
	public fn L();
	public fn R();
	*/
	public λ g(long binheapIndex);
			
	/** same as g(binheapIndexFirst).g(binheapIndexSecond) but does not necessarily create
	the fn returned by g(binheapIndexFirst) as the middle step.
	An up to 127 bit binheapIndex. Can reach approx as deep as G(long) if this is a cbt,
	and you want to get from a pair to a pair, but this is more flexible, and slower.
	If you want complete control of the path through L() and R() in something of exabit size, use this.
	*/
	public default λ gg(long binheapIndexFirst, long binheapIndexSecond){
		return g(binheapIndexFirst).g(binheapIndexSecond);
	}
	
	/** similar to g(long) except this branches to L().R() vs R(), compared to g(long) branches to L() vs R(),
	so this can index individual bits in an exabit size bitstring, though that doesnt mean it can be efficiently stored.
	Remember, a cbt/Blob is made of (pair x y) aka ((pair x) y) so is twice as deep as you might expect unless you use this.
	*/
	public λ G(long cbtBinheapIndex);
	
	public default λ L(){
		return g(2L);
	}
	
	public default λ R(){
		return g(3L);
	}
	
	/** same as L().R(). This is an optimization for getting x out of ((pair x) y) aka (pair x y)
	without (pair x) having to exist.
	*/
	public default λ LR(){
		return G(2L);
		//return g(0b110L); is that right? reverse the high/low bit order (excluding the highest 1 bit) or not?
	}
	
	
	
	public default λ e(λ param){
		//TODO make sure Compiled does the get() automatically if !compiled().on(): return compiled().get().apply(this,param);
		return compiled().apply(this,param);
	}
	
	public default λ apply(λ param){
		return e(param);
	}
	
	/** You can check if this is u or not (the node which all binary forest paths lead to)
	as it is 2 specific byte values (depending if isDirty vs !isDirty in the highest bit in that byte).
	Everything else in this byte (the low 7 bits) are cache, including to check if it is halted or not,
	which is a fact of any specific binary forest shape. There is no time in this system,
	only <func,param,return> cache entries,
	and everything else in the system (such as the semantic that the last thing in a linkedlist is a comment
	and may contain icon pixels, unicode text, andOr anything else you like,
	and the second last thing in a linkedlist is funcBody (called on that linkedlist which contains funcBody
	so it has a simple way to do recursion), but only if its used in a Curry opcode)
	... "everything else in the system"... is to more conveniently and efficiently and intuitively
	use combos of <func,param,return> cache entries. These accumulate like a sparse bloom filter
	and may just as easily be uncached/forgotten and later derived again,
	except some parts of Wiki.wiki (a UnaryOperator<fn> mounted at a certain forest node of 5 curries)
	can not be derived other than if many people and computers happen to believe them
	and they fit together with the rest of the <func,param,return> cache entries
	across the world (even across physical multiverse branches of this physical reality
	if that is ever discovered how to do that, this system will not miss a step,
	will have no errors due to being used in that way, such as if you "go back in time and kill your grandfather
	before he impregnates your grandmother leading to you" and during that <func,param,return>
	cache entries are created, and many points along that pbrane (which might be mobius-like
	<func,param,return> cache entries are created, the logic is the same nomatter
	what happens before, after, or in whatever combos. A func called on a param gives the same return
	nomatter what, if it is converged correctly)... but more practically,
	its a way of converging toward any consistent set of <func,param,return> cache entries
	which are valid iff (if and only if) forall x (L x (R x)) equals x AND
	the logic in the (BinaryOperator<fn>)SimpleFn.interpretedMode (which can be viewed as a predicate of 3 fn params,
	the question of does fn called on fn return fn (if it ever returns)
	and including (S I I (S I I)) as a symbol of "anything which does not halt" (infinite cost to compute in some cases)
	if one wants to be a perfectionist for every possible <func,param> mapping to exactly 1 value
	even if we dont know what those values are.
	<br><br>
	Normally used in a switch statement.
	The combinator/universalFunction u takes 6 params. It has 0-6 params, or 0-5 (waiting on 6th before it evals)
	if you dont create an object to represent the evaling (like happens in occamsfuncer callquad).
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
	
	public default boolean isLeaf(){
		return opIsLeaf(op());
	}
	
	public default boolean isDirty(){
		return opIsDirty(op());
	}
	
	public default boolean isHalted(){
		return opIsHalted(op());
	}
	
	/** bits of cbt, or null if this is not a cbt or is not optimized as such a wrapper. See comment of this class. */
	public Compiled compiled();
	
	/** if newCompiled.prev()!=compiled() then throw */
	public void setCompiled(Compiled newCompiled);

}

