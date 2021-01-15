package wikibinatorV0.impl;
import java.util.function.BinaryOperator;

import wikibinatorV0.Compiled;
import wikibinatorV0.λ;

public class SimpleCompiled implements Compiled{
	
	protected boolean on = true;
	
	public final Compiled prevOrNull;
	
	public final BinaryOperator<λ> wrapMe;
	
	public SimpleCompiled(BinaryOperator<λ> wrapMe){
		this(wrapMe, null);
	}
	
	public SimpleCompiled(BinaryOperator<λ> wrapMe, Compiled prevOrNull){
		this.wrapMe = wrapMe;
		this.prevOrNull = prevOrNull;
	}

	/** todo optimize by extending SimpleCompiled directly and overriding this apply func, consistent with setOn and prev etc? */
	public λ apply(λ func, λ param){
		return (on?wrapMe:prevOrNull).apply(func, param);
	}

	public void setOn(boolean on){
		if(!on && prevOrNull == null) throw new RuntimeException(
			"Cant turn off the deepest Compiled whose prev()==null cuz that would change its behaviors to have no implementation of lambda math at all. this="+this);
		this.on = on;
	}

	public boolean on(){
		return on;
	}

	public Compiled prev(){
		return prevOrNull;
	}

}
