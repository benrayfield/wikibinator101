/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;

import wikibinator.fn;

public class Cache{
	private Cache(){}
	
	public static fn dedup(fn x){
		throw new RuntimeException("TODO");
	}
	
	/** deduped call pair, without checking if this combo is valid or if it should be evaling or not. */
	public static fn cp(fn x, fn y){
		return dedup(cpcp(x,y));
	}
	
	/** potentially-non-deduped CALL PAIR (i wrote cp twice in the name to mean there could be multiple of them),
	without checking if this combo is valid or if it should be evaling or not.
	*/
	public static fn cpcp(fn x, fn y){
		return new SimpleFn(x,y);
	}

}
