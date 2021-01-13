package fixingselfreference;

/** a variety of disorganized ideas about selfReference that I'm trying to organize.
I dont expect to use this in code directly except maybe to help me design a more organized form of it,
but now that I'm writing it out here it does look more technical than I expected so maybe useful directly?
*/
public enum Selfref{
	
	/** leaf of cp forest (aka the lowercase lambda symbol). This is a cp. */
	λ,
	
	/** leaf of ds forest (aka the capital lambda symbol). This is a ds. */
	Λ,
	
	/** color, such as mapping a ds to an int color or to a TruthValue as color.
	This is a cp, such as a cbt32 and */
	cl,
	
	/** debugstepinator node. At the lowest level, everything is one of these.
	It has 3 childs and a cl (color). That color might be as simple as TruthValue.yes or TruthValue.no
	but I'm undecided about that.
	*/
	ds,
	
	/** this is a specific cp which is the only place nondeterminism is allowed. Its the wiki as a function
	that encapsulates the details of exactly which function the wiki is since its by nondeterministic convergence of RFPDs.
	*/ 
	wk,
	
	/** the vmState child of a ds */
	dsv,
	
	/** the x child of a ds, similar to cpl but for ds */
	dsx,
	
	/** the y child of a ds, similar to cpr but for ds */
	dsy,
	
	//TODO where does the combo of ds with cl go?
	
	/** callpair node */
	cp,
	
	/** lazy wrapper of a ds so it can be pointed at as a cp.
	This is a ds wrapping a ds, and the wrapper can appear in cp forest.
	*/
	lz,
	
	/** callpair left child. similar to dsx but in cp. */
	cpl,
	
	/** callpair right child. similar to dsy but in cp. */
	cpr,
	
	/** ishalted child of cq or cp. ds is always halted.
	Is a bit. Is a cache as it can be derived from cq forest shape, but without it the bigO increases.
	*/
	ishalted,
	
	/** callquad. A callpair is a callquad whose cqstack==null and cqcachekey==null and cqisparentsfunc==false.
	I dont plan to use callquads directly but instead to design something similar in ds.
	*/
	cq,
	
	/** left/func child of cq. Is a cq. */
	cql,
	
	/** right/param child of cq. Is a cq. */
	cqr,
	
	/** stack child of cq. Is a cq. */
	cqstack,
	
	/** cachekey child of cq. Is a cq. */
	cqcachekey,
	
	/** isparentsfunc child of cq. Is a bit. Tells if stack is parentCq.cql vs [parentCq.cqr or has no stack] */
	cqisparentsfunc,
	
	/** A claim of: return, func, param, isDeterministicOrNot. This is a ds, similar to a callquad,
	where depending on other fields... (callquad.cacheKey.l callquad.cacheKey.r) -> (callquad.l callquad.r).
	*/
	rfpd;
	
	/** if callpair has 3 childs (which would make it a calltri (ct?) then this is its meta/dsm child,
	but probably that will be viewed in some kind of lazy wrapper in cpl or cpr.
	*
	cpm
	*/

}
