/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;
import java.util.AbstractList;
import java.util.Iterator;

import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

public abstract class AbstractNode extends AbstractList<Node> implements Node{
	
	protected final Node[] childs;
	
	public AbstractNode(Node... childs){
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

}