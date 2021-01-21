/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;

import axiomforest.TruthValue;

/** use with IsNextStep and Rfpd and WontHalt.
The yes and no form of this are useful.
For example, leadsToInfiniteLoop and foreverExpander canReachBySteps from earlier to later state,
and every node in an infiniteLoop can reach every other node in that same infiniteLoop and no others.
<br><br>
from WontHalt QUOTE
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
The last 3 of those 4 things WontHalt. 
UNQUOTE.
*/
public class CanReachBySteps extends AbstractNode{
	
	public CanReachBySteps(TruthValue tv, Node from, Node to){
		super(tv, from, to);
	}
	
	public Node from(){
		return get(0);
	}
	
	public Node to(){
		return get(1);
	}

}