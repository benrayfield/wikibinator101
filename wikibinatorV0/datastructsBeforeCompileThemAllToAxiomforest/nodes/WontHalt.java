/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

/** a claim that a certain Callquad (a nonhalted lambda call) will not halt.
You may Believe.java this or claim it without a Believe (as you may claim anything with or without a Believe,
but if you claim it and a Rfpd is found where it does halt, then (TODO create a MultiReturnDetector for
nonhalting vs halting on a specific value, or should Rfpd be able to represent nonhalting such as
using (S I I (S I I)) which is a callquad as the normed form all nonhalters?).
TODO add an axiom that (S I I (S I I)) WontHalt, and an axiom that anything which has
a nonhalting child callquad is itself nonhalting (even if it ignores that callquad
such as (T x anythingThatHalts)->x but (T x anyNonhalter) does not halt.
<br><br>
There are a few general categories of halting vs nonhalting...
<br><br>
-- halter (a kind of infiniteLoop of length 1 since x.step->x).
<br><br>
-- infiniteLoop (length > 1) which are anything where x.step.step.step... leads back to x.
<br><br>
-- leadsToInfiniteLoop which is anything which does not come back to itself but leads to an infiniteLoop.
<br><br>
-- foreverExpander which is any nonhalter that is not a infiniteLoop or leadsToInfiniteLoop.
<br><br>
If x is a halter or infiniteLoop or leadsToInfiniteLoop, that can be proven in finite time and memory
(though may be so large a "finite" number that we would never figure that out).
<br><br>
The last 3 of those 4 things WontHalt. TODO be more specific about it?
*/
public class WontHalt extends AbstractNode{
	
	public WontHalt(Callquad call){
		super(call);
	}
	
	public Callquad call(){
		return (Callquad)get(0);
	}

}
