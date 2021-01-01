/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;
import static wikibinator.impl.ImportStatic.*;
import wikibinator.λ;

public class Cache{
	private Cache(){}
	
	public static λ dedup(λ x){
		throw new RuntimeException("TODO");
	}
	
	/** deduped call pair, without checking if this combo is valid or if it should be evaling or not. */
	public static λ cp(λ x, λ y){
		return dedup(cpcp(x,y));
	}
	
	//TODO optimize, shouldnt have to ()->aFn if you already have (fn)aFn, and you have to get it to dedup anyways.
	//"FIXME is Supplier<fn> impractical due to not being able to dedup it until you have it? You can actually dedup if you have its id, but maybe that shouldnt be part of SimpleFn and should instead be in LazyChildsFn"
	
	/** potentially-non-deduped CALL PAIR (i wrote cp twice in the name to mean there could be multiple of them),
	without checking if this combo is valid or if it should be evaling or not.
	*/
	public static λ cpcp(λ x, λ y){
		return new SimpleFn(funcOpAndParamOpToParentOp(x.op(),y.op()), x, y);
	}

}
