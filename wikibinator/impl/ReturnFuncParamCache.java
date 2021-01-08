package wikibinator.impl;
import mutable.util.Time;
import wikibinator.*;

/** RFP (such as RFPD or RFPW) cache entry, should become garbcolable (garbage collectible)
in order of least recently used. Long is timeId (number of nanoseconds since Y1970.0 utc)
as in Time.utcnano() or could just increment a long counter.
timeId is utcnano but increments by 1 if it would duplicate the last call, so its unique.
λ nonhalted returns λ halted.
TODO might be faster to just increment a counter.
*/
public final class ReturnFuncParamCache{
	
	public final λ nonhaltedCall, returnThisHalted;
	
	public long timeLastUsed;
	
	public ReturnFuncParamCache(λ nonhaltedCall, λ returnThisHalted){
		this.nonhaltedCall = nonhaltedCall;
		this.returnThisHalted = returnThisHalted;
		touch();
	}
	
	public void touch(){
		timeLastUsed = Time.timeId();
	}
	
	/** touches so this cache entry wont be garbcoled as soon,
	and returns what the nonhaltedCall returned.
	*/
	public λ get(){
		touch();
		return returnThisHalted;
	}

}
