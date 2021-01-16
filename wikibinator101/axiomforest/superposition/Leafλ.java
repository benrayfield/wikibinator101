/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.axiomforest.superposition;
import axiomforest_old.superposition.λ;

public class Leafλ implements λ{
	
	public static final Leafλ instance = new Leafλ();

	public boolean a(){
		return true;
	}

	public λ v(){
		return this;
	}

	public λ l(){
		return this;
	}

	public λ r(){
		return this;
	}

	public λ vlr(long sequence){
		return this;
	}

	public λ lr(long sequence){
		return this;
	}

	public λ leaf(){
		return this;
	}

	public λ node(λ v, λ l, λ r){
		throw new RuntimeException("TODO");
	}

}
