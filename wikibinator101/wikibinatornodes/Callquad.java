/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;
import axiomforest_old.observe.Λ;

/** a nonhalted lambda. In occamsfuncer a callquad can be halted or nonhalted,
but here if its halted, use HaltedLambda instead, since it only needs 2 instead of 4 pointers to Node.
Also it has an isParentsFunc bit to say which of func/L vs param/R this node is in parent
(even if both of those are this child other than the isParentsFunc bit, so the bit is needed).
*/
public class Callquad extends AbstractNode{
	
	public Callquad(boolean tv, Node func, Node param, Callquad stack, Rfpd cacheKey, Opcode t_or_f_isParentsFunc){
		super(tv, func, param, stack, cacheKey, t_or_f_isParentsFunc);
	}
	
	public Node func(){
		return get(0);
	}
	
	public Node param(){
		return get(1);
	}
	
	public Callquad stack(){
		return (Callquad)get(2);
	}
	
	public Rfpd cacheKey(){
		return (Rfpd)get(3);
	}
	
	public Opcode t_or_f_isParentsFunc(){
		return (Opcode)get(4);
	}
	
	public Node step(){
		throw new RuntimeException("TODO debugStepInto. If you want to debugStepOver you need a Callquad and a Rfpd, in a DebugStepOver node");
	}

}
