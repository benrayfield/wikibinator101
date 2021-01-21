/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;
import java.util.AbstractList;
import java.util.Iterator;
import axiomforest.*;

public abstract class AbstractNode extends AbstractList<Node> implements Node{
	
	/** the new way it can be any of the 4 truthvalues.
	OLD: TruthValue.yes or TruthValue.no about is the 3-way forest shape of this node a true statement or not.
	*/
	public final TruthValue tv;
	
	protected final Node[] childs;
	
	public AbstractNode(TruthValue tv, Node... childs){
		this.tv = tv;
		this.childs = childs;
	}
	
	public Node get(int index){
		return childs[index];
	}
	
	public int size(){
		return childs.length;
	}
	
	/** cant remove() */
	public Iterator<Node> iterator(){
		return new Iterator<Node>(){
			protected int index;
			public Node next(){ return childs[index++]; }
			public boolean hasNext(){ return index < childs.length; }
			public void remove(){ throw new UnsupportedOperationException(); }
		};
	}
	
	public boolean isLeaf(){
		return false;
	}
	
	//axiomforest.observe.Λ functions...
	
	public boolean a(){
		return isLeaf(); //FIXME is Node leaf different from the Λ leaf which might be a lower level than Nodes?
	}
	
	public TruthValue tv(){
		return tv;
		//throw new RuntimeException("FIXME should Node extend axiomforest.observe.Λ vs axiomforest.superposition.λ ?"
		//	+" Id like to make Λ extend λ but I dont want them to Object.equals (and hashCode), so TODO think about that.");
	}
	
	public Node v(){
		throw new RuntimeException("TODO I havent decided how to map between Node and Λ yet. Need wikibinator implemented as Nodes to pass testcases first.");
	}
	
	public Node l(){
		throw new RuntimeException("TODO I havent decided how to map between Node and Λ yet. Need wikibinator implemented as Nodes to pass testcases first.");
	}
	
	public Node r(){
		throw new RuntimeException("TODO I havent decided how to map between Node and Λ yet. Need wikibinator implemented as Nodes to pass testcases first.");
	}
	
	public Node superposition(){
		throw new RuntimeException("TODO");
	}
	
	public boolean equals(Object o){
		throw new RuntimeException("TODO compare List contents and class type. It will match axiomforest equality since each class type will not overlap any of the possible shapes of the others in axiomforest.");
	}
	
	public int hashCode(){
		throw new RuntimeException("TODO be very careful about this as it must match Λ.hashCode(). See the throw/comment of equals(Object).");
	}
	
	public Node leaf(){
		return Leaf.instance; //FIXME is Λ leaf the same forest shape as Node leaf in axiomforest? Probably, but todo think more about that.
	}
	
	public Node node(TruthValue tv, Node v, Node l, Node r){
		throw new RuntimeException("TODO");
	}
	
	public Node step(){
		throw new RuntimeException("TODO");
	}

}