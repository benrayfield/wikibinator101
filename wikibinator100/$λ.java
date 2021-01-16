/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator100;

public final class $λ{
	
	public final long gas;

	/** gas==0 implies fn==null, but fn==null does not imply gas==0 since it might have
	given up early cuz it knew it didnt have enough gas to do the requested calculation
	(which fn is normally the ret of if the $λ is a return value, and which means
	something else if $λ is a param such as to spend at most that much trying to eval it.
	*/
	public final λ fn;
	
	/** gave up early. fn is null. or at least it means that if this is a return value. */
	public $λ(long gas){
		this(gas,null);
	}
	
	public $λ(long gas, λ fn){
		this.gas = gas;
		this.fn = fn;
	}
	
	/** param may be positive or negative */
	public $λ add(long gas){
		return new $λ(this.gas+gas, fn);
	}
	
	/** fn becomes null */
	public $λ giveUp(){
		return new $λ(gas);
	}

}