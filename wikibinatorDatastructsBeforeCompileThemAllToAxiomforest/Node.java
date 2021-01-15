package wikibinatorDatastructsBeforeCompileThemAllToAxiomforest;
import java.util.List;

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
public interface Node extends List<Node>{
	
	public boolean isLeaf();
	
}