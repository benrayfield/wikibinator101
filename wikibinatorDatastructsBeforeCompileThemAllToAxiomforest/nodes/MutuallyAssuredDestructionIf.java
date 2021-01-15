package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.nodes;

import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/**  No, Yes, T, and F, are 4 different things. Yes, T, and F are axiom value TruthValue.yes.
No is axiom value TruthValue.no, or is TruthValue.bull when used
as a peaceful-just-forking mutuallyAssuredDestructionTrigger.
<br><br>
You should have these MutuallyAssuredDestructionIf nodes pointing from No to every other Node
(at least in abstract math)
or randomly selected nodes, which force blockchain-fork or logic-in-1-computer-fork if any BULL is proven,
to fork to a possible state of the system which is less likely to have any BULL,
and many possible states (merkle forest nodes) explored in many combos at once,
so mutually assured destruction is about a "multiverse branch" and you probably wont even notice it
cuz theres so many of them happening at once, like "error correcting codes" except
in a more extreme way to motivate convergence toward 0 errors in the p2p network.
Errors slow things down and break compatibility and the whole system would destroy itself
if it wasnt instantly ready to back out of any even slightly wrong calculation in many combos.
This is like the "control rod" of the wikibinator system and it operates at a precision
between .01 seconds and .00001 seconds,
closer to .00001 except when OS gives another thread control for a short time
or during lwjgl opencl gpu optimizations that do a block of calculations such as in .005 seconds.
The worst that will happen is blockchain-fork OR whatever people might hook in to
read the system and react in ways that only they are responsible for and not the system itself.
<br><br>
If No (aka have proved true==false) then this proves the opposite TruthValue about any given statement (target).
<br><br>
This is a kind of (peaceful) "mutually assured destruction" (MAD)
on the level of blockchain-forking or logic forking in the bits of 1 computer,
that it must fork if an error can be derived anywhere in the system,
enforced by the axioms allow using a proof that true==false to prove anything about anything.
<br><br>
In MultiReturnDetector (todo rewrite this as its supposed to imply No (is yes) QUOTE
If cacheKeyA.func().equals(cacheKeyB.func()) && cacheKeyA.param().equals(cacheKeyB.param())
&& !cacheKeyA.ret().equals(cacheKeyB.ret()) && this node is true THEN implies the opposite TruthValue (yes or no)
about whatever messenger is, so that messenger is both yes and no at once, so messenger is bull,
and the same way those 2 conflicting Rfpds about messenger can imply that any node in the system
is both yes and no at once aka bull.
UNQUOTE.
*/
public class MutuallyAssuredDestructionIf extends AbstractNode{
	
	/** No (TruthValue.bull) else Node elseOneOfManyTargets (bull).
	Its a mutually assured destruction of any bull anywhere implies bull everywhere,
	cuz if you can prove that true==false then you can prove anything,
	and we need to motivate removing that before it spreads errors in less obvious ways.
	*/
	public MutuallyAssuredDestructionIf(No noBull, Node elseOneOfManyTargetsBecomesBull){
		super(noBull, elseOneOfManyTargetsBecomesBull);
	}
	
	/** No's axiom value is TruthValue.no.
	But if it also has axiom value TruthValue.yes, thats TruthValue.bull,
	and any bull triggers MutuallyAssuredDestruction everywhere that expands exponentially,
	and peers cant deny the bull if they've certified things that derived the bull as any set of nodes
	reachable thru childs of childs recursively, if any joins and implies of combos of those can generate bull,
	then it proves at least 1 thing in that set is the cause of bull and must fork. Many combos can be tried
	as its a merkle forest, and its not bull on a peer themself but on some things but not others they shared.
	*/
	public No noBull(){
		return (No)get(0);
	}
	
	/** becomes TruthValue.bull (simultaneous yes and no) so the MutuallyAssuredDestruction expands exponentially */
	public Node elseOneOfManyTargetsBecomesBull(){
		return get(1);
	}

}
