/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/** For any 2 fns x and y, an optimization of call x on y and return what that would return,
but potentially in a more optimized way, and in the worst case just do it in the slow interpreted way.
Every fn has a Compiled and that Compiled can be replaced by another Compiled
that remembers it in a linkedlist (Compiled.prev()), and when you use a Compiled,
you use Compiled.get() which gives you the nearest Compiled that is Compiled.on()
which you can choose to disable certain Compileds (which may be shared by multiple fns
such as a fn that does plus with a curried param of 3 vs a fn that does plus with a
curried param of 5, both might use a Compiled optimization of the plus function,
and if you want to compare the earlier Compileds or down to pure interpreted mode
to see if that optimization gives the exact same answer (a fn being a binary forest node)
then aFn.compiled().setOn(false) then aFn.e(20) -> 23, and anotherFn.e(20) -> 25,
and both aFn and anotherFn, if their .compiled() is that Compiled, have that optimization
turned on or off together at runtime.
<br><br>
This Compiled stuff is already working in some fork of occamsfuncer.
<br><br>
TODO this will be similar to Compiled.java in occamsfuncer,
which is a mutable linkedlist of Compiled instances which is called in fn.e(fn)
and is likely to use LazyBlob (of lazycl) and other optimizations,
else run in interpreted mode (the default Compiled) when no optimization is known.
<br><br>
As BinaryOperator<fn> its the same as UnaryOperator<fn> on cp(its 2 params),
without needing to create that object. Its call x on y -> z.
*/
public interface Compiled extends BinaryOperator<fn>{
	
	"TODO should this as BinaryOperator already call get() and return from that BinaryOperator?"
	
	/** If prev()==null then this must be on */
	public void setOn(boolean on);
	
	public boolean on();
	
	/** use this (linkedlists of Compiled each replacing the last) if this Compiled is not on(),
	which you can do to test it with and without various optimizations,
	which must all compute exactly the same thing.
	*/
	public Compiled prev();
	
	public default Compiled get(){
		return on() ? this : prev().get();
	}
	
	/** lazycl Blob, probably a LazyBlob. For number crunching such as 1 teraflops,
	display of 3d fractals in realtime, matmul, music tools, etc.
	When I say teraflop, I mean formal-verified IEEE754 float32 or float64 bits computed as lambdas
	for even the smallest things like NAND of 2 bits, in interpreted mode (or various levels between using Compiled.setOn(boolean),
	but in practice (TODO) will have a Compiled that calls lazycl in strict opencl mode to compute those exact float32 multiply bits etc,
	which will generate the exact same merkle ids as the interpreted mode.
	Or... If you do it thru Wiki.wiki which is a UnaryOperator<fn> and is 1 of the 8 opcodes to call wiki on 1 param,
	then it may be nondeterministic without that formal-verification but is recommended to verify it
	recursively and statistically using (L x (R x)) equals x forall x
	and by turing-complete-challenge-response using various ids which are known to eval to the same thing
	but those which have incomplete info might not know they have to return the same thing
	so they can be caught in spreading unverified rumors or deception as theres an infinite number of ways
	to write the same function if some parts are evaled and other parts are not evaled yet.
	<br><br>
	null if dont have this or if this Compiled is not a specific bitstring cuz its shared by many bitstrings,
	in which case you should probably create a Blob view of that bitstring (or any powOf2 aligned subrange of it) thats relevant,
	and create a Compiled whose prev() is this Compiled,
	or something like that... I'm planning for linkedlists (anything made of pairs where u is R().R().R()...R()
	to have a second kind of Compiled which is used by Curry op when Curry gets the second last thing in the linkedlist
	to use as funcBody then calls funcBody on that linkedlist. The linkedlist should know that funcBody's Compiled
	and with each nextParam prepended (appended as first thing in it), that pair should copy the ptr to that Compiled,
	then Curry gets the Compiled without recursing into the linkedlist, so doesnt even have to go get the funcBody
	since already have its Compiled if that Compiled somehow has a ptr to that funcBody but I'm not sure if thats a good idea
	so might separately cache the second last thing in each linkedlist in each node in the linkedlist
	(which never prevents garbcol since every fn that caches the second last thing in the linkedlist
	can already reach that second last thing).
	*/
	public Blob cbt();
	
	//TODO

}
