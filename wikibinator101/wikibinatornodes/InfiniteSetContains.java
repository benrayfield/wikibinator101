/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator101.wikibinatornodes;
import axiomforest.TruthValue;
import wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.Node;

/** This can be used to ask a turing-complete question
of "find a param of a certain function which when that function is called on it the call halts".
For example, if you just want to call x on y using this,
then the function would call x on y then compare its param (using derived equals function) to
what that returns (if it ever returns), which an optimization could be designed for
to understand that you are just asking the question "what does (x y) return?",
but in a unified way that might be more optimized, that all questions to the system
would be of the form: find an InfiniteSetContains where InfiniteSetContains.infiniteSet()==theGivenFunc,
like the "occamsfuncer nondet solve" function.
<br><br>
f contains p if (f p) halts, therefore Rfpd implies an InfiniteSetContains. f contains p.
All such infinite sets (that can be represented in this system) have finite kolmogorovComplexity.
An infinite set can contain itself or not. There are no paradoxes,
such as it is not possible in this system to ask https://en.wikipedia.org/wiki/Russell%27s_paradox
cuz it is "word salad". Not every sequence of words means something.
<br><br>
TODO??? if this were to have 2 possible return values, T and F (which theres an axiomforest form
of T and F and a wikibinator form of T and F at a higher level, which are different things),
instead of just halts or not
(aka halts on T or halts on F or [does not halt or halts on something other than those]),
then this could be viewed as the set of all possible hash functions of 1 bit each
(allowing unknown if it doesnt return T or F on a given possible param)
such as the 237th bit of sha3_256 of a certain merkle forest node (with some pre and post processing) etc,
then various functions could name eachother by their T or F (if they return at all on eachother)
so every tiny part of every possible hash algorithm could hash every tiny part of eachother,
the same way as you could ask for a solution to any (finite kolmogorovComplexity) puzzle.
The T vs F could be viewed as the param is certainly in the set, or certainly not in the set,
vs if its not been observed to return yet (or will never halt) then its unknown if is in the set or not.
*/
public class InfiniteSetContains extends AbstractNode{
	
	"TODO T F kind vs simplerDoesItHaltOrNot kind"
	
	public InfiniteSetContains(TruthValue tv, HaltedLambda infiniteSet, Node memberOfSet){
		super(tv, infiniteSet, memberOfSet);
	}
	
	public HaltedLambda infiniteSet(){
		return (HaltedLambda)get(0);
	}
	
	public Node memberOfSet(){
		return get(1);
	}
	
	public Node step(){
		return this;
	}

}
