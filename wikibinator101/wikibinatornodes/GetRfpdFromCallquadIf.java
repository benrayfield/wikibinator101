package wikibinator101.wikibinatornodes;

/** In some cases (depending what is halted),
(callquad.cacheKey.func callquad.cacheKey.param)->(callquad.func callquad.param).
(callquad.func callquad.param) is a HaltedLambda.
(callquad.cacheKey.func callquad.cacheKey.param) is normally a HaltedLambda but
technically might be nonhalted aka a callquad with no stack (is it null or leaf or what constant?) and no cacheKey.
<br><br>
TODO should callquad be used directly as Rfpd instead of this class?
*/
public class GetRfpdFromCallquadIf extends AbstractNode{
	
	public GetRfpdFromCallquadIf(boolean tv, Callquad call){
		super(tv, call);
	}
	
	public Callquad call(){
		return (Callquad)get(0);
	}
	
	public Rfpd impliesRfpd(){
		throw new RuntimeException("TODO read comment of this class, and return null if it doest imply that, else generate the Rfpd it implies");
	}

}