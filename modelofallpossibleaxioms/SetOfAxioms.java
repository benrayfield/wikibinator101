/** Ben F Rayfield offers this software opensource MIT license */
package modelofallpossibleaxioms;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public interface SetOfAxioms{
	
	public λ trinaryForestLeaf();
	
	public Set<UnaryOperator<λ>> impliesYes();
	
	public Set<UnaryOperator<λ>> impliesNo();
	
	/** of trinaryForestNodes: forall x forall y: if x and y are true then <trinaryForestLeaf x y> is true.
	This returns <trinaryForestLeaf x y> for its 2 params x y.
	*/
	public BinaryOperator<λ> joiner();
	
}
