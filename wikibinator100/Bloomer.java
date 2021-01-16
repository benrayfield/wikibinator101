/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator100;
import java.util.function.Consumer;

/** Sparsely observes the forest of λ reachable from param λ
and may OReq some TruthValues into any of them, without ever creating TruthValue.bull anywhere
as long as correct axioms were used to reach their current state.
State is only in λ.header()&HeadewrBits.valMask,
and state could be emulated as an immutable trinary forest with a third child being that long header,
which you could do at user level as [myLongHeader myLeft myRight] aka [myLongHeader [myLeft myRight]]
which is not a linkedlist
but if you want linkedlist use [myLongHeader myLeft myRight λ] aka [myLongHeader [myLeft [myRight λ]]].
All possible axioms can be explored at user level that way,
since you can derive a function that evals a [myLongHeader myLeft myRight] on another one
the same as a function, viewing it like the L and R childs.
Thats one of the advantages of being a "pattern calculus function".
If people start doing that, a Compiled.java could be manually designed in an opensource forkedited wikibinatorVM
which is fully compatible with the wikibinator spec (just more optimized for certain kinds of calculation)
or eventually it will have very general compiler(s) that can figure out patterns like that
and generate formally-verified compiled output (verified not to let things escape sandbox)
where compiled output might for example be opencl ndrange kernel code, java code strings
to put into javassist or beanshell or python code or javascript code etc,
that it would be able to compile binary forest of wikibinator call pairs
to a variety of existing inputs to existing compilers.
<br><br>
This Bloomer interface is for things that only write using λ.headerOreq(long)
and never cause HeaderBits.bulls(λ.header())!=0.
*/
public interface Bloomer extends Consumer<λ>{
	
	/** If this is a manually written Bloomer, you could put a Human readable description of what it does here *
	public String description();
	*/
	
}