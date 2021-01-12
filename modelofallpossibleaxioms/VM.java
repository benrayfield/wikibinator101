package modelofallpossibleaxioms;

public interface VM{
	
	/** the constant node which all trinary forest nodes lead to in all possible paths of node.v node.l node.r.
	This is not specific to any SetOfAxioms.
	*/
	public λ leaf();
	
	/** just a plain trinary forest node without implying its any specific color. This is not specific to any SetOfAxioms.
	*/
	public λ node(λ v, λ l, λ r);
	
	public default λ node(λ l, λ r){
		return node(leaf(), l, r);
	}
	
	public int color(λ x);
	
	public default boolean knowsColor(λ x){
		return color(x) != 0;
	}
	
	/** If axiom(s) are correct then every call of setColor on the same λ will be the same color
	regardless of order of running the axioms.
	*/
	public void setColor(λ x, int color) throws MultiColoredλ;
	
	/** color goes back to 0 which means unknown which color it is */
	public void forgetColor(λ x);
	
	/** forget which childs it has. Dont call this if theres still incoming ptrs to it.
	It can be derived again since equality is by forest shape.
	*/
	public void forgetChilds(λ x);

}