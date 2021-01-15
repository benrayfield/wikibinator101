package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;

/** maybe this is a byte short or int that goes somewhere in axiomforest node v child as a cbt32,
with 1 cbt32 value for each possible Node type in the wikibinator axiom,
within a Pair of "wikibinatorV0" and that int, somewhere in the v child,'
so that other systems (forks of wikibinator or non-wikibinator systems, anything you like)
can each choose some area of the 3-way forest of 1 TruthValue of bloomFilter,
that dont conflict with eachother but may overlap eachother in nonconflicting ways,
so that many systems can be in the same sparse forest based bloom filter
(where unknown blooms to yes or no,
and errors are detected if it blooms to bull, per 3 way forest node).
<br><br>
FIXME should this be its own subclass of Node instead of each of the subclasses
just being that pattern of trinary forest shape (implying by their Node.next() axiom
a node which has such an opcode/type in v child of what next returns?).
*/
public class Opcode extends AbstractNode{
	
	/*public static final Op T = new Op(true), F = new Op(false);
	
	/*public Op(boolean bit)
	
	/*public final boolean value;
	
	public Op(boolean bit){
		throw new RuntimeException("TODO it needs to be defined by forest shape, similar to how T and F are defined in wikibinator, except it will probably be deeper cuz this is a layer below that universalFunc");
	}*/

}
