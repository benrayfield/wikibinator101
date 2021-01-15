package wikibinatorV0.datastructsBeforeCompileThemAllToAxiomforest;
import java.util.List;

import axiomforest.observe.Λ;

/** Immutable. I'm planning to get the various kinds of Nodes working together,
as a way to help me design their final form in axiomforest where theres only 1 type that does it all.
<br><br>
//sMustBeAbleToUse2RfpdsCreatedInParallelInsteadOfStackHavingToBeSequential
	//considerWhere(Compiled.java_inTheFormOf_UnaryOperator_axiom_etc)WillEfficientlyHookIn
	//axiomsCanCreateAxioms
	//	datastructWrappingAHaltedLambdaInThe(Axiomnode.v)Child)ThatsClaimedToBeAValidAxiomBasedOnTheVShapeAndStepFuncCreatesWhatever<bit,v,l,r>ItSaysToWithoutVerifyingIt
	//axiomnodeVChildWillHaveAPlaceToPutAnInteger(byte?Int?long?int256?)ForWhichDatastructAndRuletypeItIs

	These will all share a superclass (interface?) to make it easier to compile to axiomforest.
		wrapperOfAxiomnodeThatCanBeANonhaltedLambdaCallAndChildOfHaltedLambda
		datastructWrappingAHaltedLambdaInThe(Axiomnode.v)Child)ThatsClaimedToBeAValidAxiomBasedOnTheVShapeAndStepFuncCreatesWhatever<bit,v,l,r>ItSaysToWithoutVerifyingIt
		datastructThatHas3AxiomnodesWhere2OfThemAreSameShapeAndIfTheyHave2DifferentBitValuesThenTheThirdAxiomnodeIsForkeditedToBeOppositeOfItsValueAsWayToSpreadErrors
		rfpd
		cbt
		datastructThatSomehowDoesDebugstepoverUsingSomethingLike2CallquadsButTodoWhich2SpecificDatastructs
		datastructThatHasARFPDAndAnotherRAndItLeadsToTheClaimThatTheOtherReturn(R)InARFPDIsFalseIfRFPDIsTrueCuzTheresMaxOneReturnValuePerFuncParam
*/
public interface Node extends List<Node>, Λ{
	
	//FIXME should Node extend axiomforest.observe.Λ vs axiomforest.superposition.λ ?
	//Id like to make Λ extend λ but I dont want them to Object.equals (and hashCode), so TODO think about that.
	
	public boolean isLeaf();
	
	/** same as the lambda call (STEP thisNode) or maybe (STEP ViewNodeAsHaltedLambda_of_thisNode).
	axiomforest.observe.ΛObserver.implies contains UnaryOperator<Λ>s, 1 of which is STEP.
	I'm planning to redesign (or somewhow create subclasses that wrap or implement) Node to be Λ,
	and there will be a Λ that represents the STEP function (which is a lower level of wikibinator logic,
	like a debugger step instead of a whole lambda call), so its all Λ calling Λ and returning Λ.
	*/
	public Node step();
	
	/** join like Λ.p(Λ) but TODO Node might be at a higher level? Should Node act more like a lambda that always halts in bigO(1)? */
	public default Node P(Node r){
		throw new RuntimeException("join like Λ.p(Λ) but TODO Node might be at a higher level? Should Node act more like a lambda that always halts in bigO(1)?");
	}
	
}