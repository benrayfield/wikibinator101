/** Ben F Rayfield offers this software opensource MIT license */
package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest.nodes;
import wikibinatorDatastructsBeforeCompileThemAllToAxiomforest.Node;

/** This can be used in parallel such as (S x y z) evals to ((x z)(y z)) aka (x z (y z)).
Each of (x z) and (y z) may be an S call, which is very common, so could continue becoming more parallel,
or do it sequentially. Each such call can be precomputed such as by lwjgl opencl GPU optimization,
to create a Rfpd for (x z) and a Rfpd for (y z) so if both of those already exist
then they can be used with 2 DebugStepOver
(created by 2 GetRfpdfromCallquadIf, from the callquads it was computed in),
so it is still 2 sequential steps of CallQuad -> DebugStepOver -> CallQuad -> DebugStepOver -> CallQuad,
but thats bigO(1) and those DebugStepOver can each be any huge amount of work done in parallel,
and together they generate a Rfpd of the whole (S x y z) call which can be used the same way
anywhere someone wants to know what happens when you call (S x y) on z, what does that return,
the Rfpd tells the returnValue for that (func param),
and if someone makes up a fake return value, then those 2 Rfpds can go in a MultiReturnDetector
which will check (in STEP from it) if they both have the same func and param but different returns,
and if they do then it proves that the axiom TruthValue of No is Truthvalue.yes (and its also Truthvalue.no),
and many MutuallyAssuredDestructionIf already each have 2 childs: No and anyRandomlyChosenNode,
and No (if its yes) implies anyRandomlyChosenNode is the NOT of its current TruthValue
(or implies its both separately, todo choose a design, should it have to know a current yes or no
to choose the opposite or just do both in 2 separate STEPs), so thats what protects the system
from people andOr computers making up, or just accidentally computing it wrong,
the wrong returnValue for a (func param) lambda call,
which is most likely to happen or be used by DebugStepOver and Rfpd.
<br><br>
datastructThatSomehowDoesDebugstepoverUsingSomethingLike2CallquadsButTodoWhich2SpecificDatastructs.
*/
public class DebugStepOver extends AbstractNode{
	
	/** If cacheKey's func and param matches the func and param the call wants to know returnVal for,
	then this IMPLIES far ahead in the calculation aka debugStepOver it instead of debugStepInto,
	but if its not a match then this IMPLIES (todo choose a design,
	either debugStepInto or implies some constant thats always true).
	*/
	public DebugStepOver(Callquad call, Rfpd cacheKey){
		super(call, cacheKey);
	}
	
	public Callquad call(){
		return (Callquad)get(0);
	}
	
	public Rfpd cacheKey(){
		return (Rfpd)get(1);
	}
	
	public Node step(){
		//new GetRfpdFromCallquadIf(call()).step()
		if(
			call().func().equals(cacheKey().func()
			&& call().param().equals(cacheKey().param()
			&& (HaltedLambda) .. (call.func call.param).isHalted
		){ //do debugStepOver, returning a HaltedLambda
			"then return that (HaltedLambda) .. (call.func call.param).isHalted"
		}else{ //is not the cacheKey needed or was not ready to debugStepOver
			throw new RuntimeException("TODO return this? or do a debugStepInto? Or return Yes (no-op)?");
		}
	}

}
