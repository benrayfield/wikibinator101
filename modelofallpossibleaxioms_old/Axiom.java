package modelofallpossibleaxioms_old;

import java.util.function.ToIntFunction;

import axiomforest.superposition.λ;

/** Immutable. An axiom can be a set of axioms by using more colors or deeper patterns of trinary forest nodes.
Axioms are consistent as long as no possible combo of calling (λ)node(λ,λ,λ) and next(λ)
leads to more than 1 color for the same λ.
<br><br>
An axiom must return instantly aka bigO(1), which does a tiny amount of work
that can be divided from any huge amount of work similar to pushemu, popemu, debugStepInto, and debugStepOver,
while still being turingComplete and potentially transfinite.
*/
public interface Axiom{
	
	/* Does not modify anything except to create cache in it.
	Does not modify the VM except to add trinary forest nodes (which all of are valid nodes, so those are only cache).
	Does not set the color of anything. Only returns a Coloredλ which caller may put into the VM or not.
	<br><br>
	FIXME the param is supposed to have colors, or at least some of them have colors,
	but if you get a node from VM.node(λ,λ,λ) then that doesnt imply any color on them yet.
	Im not sure if it needs to read the colors from the param vs if it can generate color just from the shape
	in bigO(1). Its required that this function always return in bigO(1),
	similar to debugstepinator using pushemu popemu debugStepInto and debugStepOver
	to break it into bigO(1) size pieces of work.
	If need colors, the put VM as param here and have a func VM.color(λ)
	which starts as color 0 (unknown what color it is) for every λ
	then can change at most once to some nonzero color per λ since a λ can have at most 1 color.
	*/
	public Coloredλ next(ToIntFunction<λ> colors, λ x);
	//public Coloredλ next(VM vm, λ x);
	
	/** statefully modifies VM instead of just returning a Coloredλ for how it would be modified,
	and may be more efficient than that.
	*
	public default λ Next(VM vm, λ x) throws MultiColoredλ{
		Coloredλ c = next(vm,x);
		λ fn = c.fn();
		int color = c.color();
		vm.setColor(fn, color);
		return fn;
	}*/
	
	public int colors();
	
	//TODO BiFunction isnt right for that. its 1 thing to 2 things.
	
	//TODO what do I mean by color? Can i use a λ as color? or do I want an integer?
	//Should SetOfAxioms have a Number that tells how many colors it has? How about int numOfColors?
			
	//TODO cbt and other optimizations, but put that somewhere other than the math prototype of the system.

}
