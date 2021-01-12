package debugstepinator_old;

import java.util.function.UnaryOperator;

/** Think of this as an infinite size unweighted directed graph where each node
points at exactly 4 nodes with 4 kinds of edges (v, l, r, nextState) and has a Color (like turing tape cell color),
and in that is the space of all possibilities frozen timelessly,
and that Color is used for error detection such as if a lambda call has more than 1 return value
when computed in different ways (which should never happen).
All actions are bigO(1) and that will be true even in practice, similar to debugStepInto and debugStepOver.
<br><br>
Immutable 3-way (trinary) merkle forest where all paths lead to leaf (such as wikibinator as universal func,
except with some extra stuff between the wikibinator nodes to make every possible action return in bigO(1)
as its (TODO in theory) an infinite sparse directedGraph containing all possible lambda calls
and debugStepInto and debugStepOver them. A certain Node is STEP, where (leaf STEP x)
is the same as x.n(). Similarly it can reflect to call (leaf STEP (leaf STEP x)), to any depth.
<br><br>
Node as UnaryOperator<Node> is always bigO(1) as long as you have the whole forest below in memory
instead of for example it being across the internet in p2p networks or stored somewhere unreliable
where parts may need to be rederived, in which case you shouldnt be able to call n() yet
since you dont fully have the things its being called on.
<br><br>
LEAF is either wikibinator or some 3-way-forest wrapper of it to implement this debugstepinator logic.
<br><br>
All possible trinary forest nodes are valid as keys, and each key maps to a specific Color
(like turing tape cell color, see Color.java enum), but TODO I havent defined those details of the logic yet.
You cant refer to a Node without its Color.
Color is similar to wikibinator TruthValue, in that you may view the statement that node x is color y
as a TruthValue, but also similar in the way that its there to make it in theory impractically hard to
create fake <return func param isDeterministic> cache entries, such as it should be impracticaly hard
to give others in a p2p network the statement <5 (+ 2 2)> since 2+2 does not equal 5,
so the color of 5 and the color of + and the color of 2 and the color of (+ 2) and the color of ((+ 2) 2)
and the color of <5 (+ 2 2)> and the color of other trinary forest nodes, would all be specific colors
that if any one of them were claimed to be a color that is later found to be the wrong color
then that would echo errors outward in exponentially or even infinitely many combos
that would make it impractical for most people and computers
to fit <5 (+ 2 2)> into a consistent view of the space of
all possible <return func param isDeterministic>s aka RFPDs.
<br><br>
As trinary forest, the childs are called v, l, and r. l is func. r is param. like in lambdas.
You are allowed to take any 2 nodes x y (which may equal or not) and create the node (LEAF x y),
and by repeating (LEAF STEP (LEAF STEP (LEAF x y)))... the nextState (n()),
which of course is bigO(1) to get nextState from each node you have the whole forest below it...
The nextState will reach something containing (or that literally is?) the return value of the (x y) lambda call.
<br><br>
As a trinary forest, you may not just put anything in the v child. That has to be derived from nextState.
You can only create (LEAF x y) for any x and y nodes that correctly exist, and go nextState (aka node.n())
from anywhere, and all ops are bigO(1).
<br><br>
Bull happens (error, must backtrack in some other combo of nodes which led here) when
the same trinary forest shape has more than 1 Color,
such as could be derived if starting with the flawed claims that (a b)->c and (a b)->d. 
*/
public class Node implements UnaryOperator<Node>{
	
	/** trinary forest node is key. Color is val. */
	public final Node v, l, r;
	
	/** trinary forest node is key. Color is val. */
	public final Color c;
	
	public static final Node LEAF = null; //FIXME TODO not null
	
	public static final Node STEP = null; //FIXME TODO not null
	
	public static final Node GETL = null; //FIXME TODO not null
	
	public static final Node GETR = null; //FIXME TODO not null
	
	public static final Node GETV = null; //FIXME TODO not null
	
	public static final Node ISLEAF = null; //FIXME TODO not null
	
	//TODO dedup
	
	public Node(Node func, Node param){
		this(Color.newCall, LEAF, func, param);
	}
	
	public Node(Color turingColor, Node vmState, Node func, Node param){
		c = turingColor;
		v = vmState;
		l = func;
		r = param;
	}
	
	/** nextState */
	public Node step(){
		throw new RuntimeException("TODO");
	}

	public Node apply(Node param){
		if(this == STEP) return param.step();
		return new Node(this, param); //TODO dedup
	}

}
