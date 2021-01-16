/** Ben F Rayfield offers this software opensource MIT license */
package axiomforest_old.observe;
import java.util.Map;

import axiomforest.TruthValue;
import axiomforest_old.superposition.λ;

/** Immutable. Λ has a bit for every child recursively reachable in λ. λ is just the 3 way forest.
This λtv is a λ with a TruthValue but all childs recursively below it are TruthValue.unknown.
*/
public interface λtv /*extends Map.Entry<λ,TruthValue>*/{
	
	public λ key();
	
	public TruthValue val();
	
	/** compare the 2 keys and the 2 vals */
	public boolean equals(Object o);
	
	/** compare the 2 keys and the 2 vals */
	public int hashCode();
	
}