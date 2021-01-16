/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.axiomforest.observe;
import axiomforest_old.observe.Λ;
import axiomforest_old.superposition.λ;

/** Λ is a trinary forest node with a bit */
public class LeafΛ implements Λ{
	
	public static final LeafΛ instance = new LeafΛ();

	public boolean a(){
		return true;
	}

	public boolean tv(){
		return true;
	}

	public Λ v(){
		return this;
	}

	public Λ l(){
		return this;
	}

	public Λ r(){
		return this;
	}

	public λ superposition(){
		throw new RuntimeException("TODO");
	}

	public Λ leaf(){
		throw new RuntimeException("TODO");
	}

	public Λ node(boolean tv, Λ v, Λ l, Λ r){
		throw new RuntimeException("TODO");
	}

}
