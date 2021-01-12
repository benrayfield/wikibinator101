package modelofallpossibleaxioms;

import java.util.function.Consumer;

/** color 0 means unknown color and does not count against having multiple colors at once,
such as a node can simultaneously be color 0 (unknown what color it is) and color 3
but it cant simultaneously be 2 and 3. 0 does count in SetOfAxioms.colors().
<br><br>
As Consumer<VM> will tell the VM that λ is that color, but only if the Consumer.accept(VM) function is called,
at risk of throwing MultiColoredλ but only if axioms are inconsistent (or if some computer lies
through the network about what colors their λs are or if they are using bad axioms)...
only then could that ever happen.
*/
public interface Coloredλ extends Consumer<VM>{
	
	public int color();
	
	public λ fn();
	
	public default void accept(VM vm) throws MultiColoredλ{
		vm.setColor(fn(), color());
	}

}
