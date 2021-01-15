package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

/** Believe vs RefuseAllBelieve vs TODO various subsets could be defined (in turing complete ways) for each.
For loose beliefs or faith or assumptions, but the same axiomforest cant be both ways,
though parts of it could be with more specialized axioms to limit which possible 3-way forest
nodes it applies to allowing vs not allowing Believe objects there.
<br><br>
A semantic that means a certain statement is not necessarily provable from combos of Leaf
but that those who accept it in [any axiom forest node whose childs can recursively reach it]
are either believing it or experimenting with it to see if it combined with other things
leads to TruthValue.bull (which triggers MutuallyAssuredDestructionIf of that fork,
of potentially as many forks as there are bits on the Internet).
<br><br>
Technically you the Node statement is a belief in itself,
if its a Λ (answer question with yes or no) instead of a λ (question),
but maybe there will be some logic in the system to check if there is a Believe of it
(and you can believe that its yes, or believe that its no, as Λ has the yes or no in it, while λ doesnt)
and that logic might be designed to stop looking for a proof of it other than the Believe,
if the Believe is found, and instead start a debate on if it should be believed without
further evidence or if there is evidence of some form that doesnt fit well into the axiomforest system
(which I doubt, but people or computers may find it hard to use and just want to Believe something).
Others might also put in a logic (RefuseAllBelieve.java)
(as everyone may use some axioms in common and some different
and align only where their axiomforest bloomfilter fits together or become isolated in
parts of it that less directly interact or only interact in certain limited ways...
Some people andOr computers might have among their axioms that all Believe nodes are TruthValue.no
which would mean anything that cant be proven from the leaf node and only some universal function logic
(which might also be Believed, but only 1 Believe and might be able to formally-verify it or not,
see godel incompleteness and halting problem etc)...
The point is, these things can be said as technical statements.
*/
public class Believe extends AbstractNode{
	
	public Believe(Node statement){
		super(statement);
	}
	
	public Node statement(){
		return get(0);
	}

}
