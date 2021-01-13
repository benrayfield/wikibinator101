package modelofallpossibleaxioms;

/** Immutable. */
public class MultiColoredλ extends RuntimeException{
	
	public final λ node;
	
	public final int colorA, colorB;
	
	public MultiColoredλ(λ node, int colorA, int colorB){
		this.node = node;
		this.colorA = colorA;
		this.colorB = colorB;
	}

}