package wikibinator101.wikibinatornodes;

/** No, Yes, T, and F, are 4 different things. Yes, T, and F are axiom value TruthValue.yes.
No is axiom value TruthValue.no, or is TruthValue.bull when used
as a peaceful-just-forking mutuallyAssuredDestructionTrigger.
*/
public class T extends AbstractNode{
	
	public T(boolean tv){
		super(tv); //FIXME more params?
	}
	
	public Node step(){
		return this;
	}

}