/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0;

/** a key in java memory, which may have weaker dedup than globalId
but is often useful as an optimization since it doesnt require generating an id
as it can be compared by SystemidentityHashCode.
*/ 
public interface ob{
	
	//TODO alloc long id from Time.timeId()? public default long localId();
	
	public boolean equals(Object obj);
	
	public int hashCode();
	
	/*public default int identHashCode(){
		return System.identityHashCode(this);
	}*/

}