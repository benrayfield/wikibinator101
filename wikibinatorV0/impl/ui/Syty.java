package wikibinatorV0.impl.ui;

/** SYntax TYpe */
public enum Syty{
	
	
	/** Example: [(]) */
	parseError,
	
	/** Example: //this is a comment */
	ignore,
	
	/** Theres only 1 example of this: ?
	such as <? x y> means "? = (x y)", which is compatible with "z = (x y)" depending on the possible values of z,
	or such as in <z x y ?> which means "z = (x y) when wikiState=?".
	If you say <? x y> to someone, they might say <(x (x x)) x y> to you if its true that (x (x x)) = (x y),
	and they might also say <abjsdf (x (x x))> and <abjsdf x y>.
	*
	allPossibilities,
	*/
	
	/** Example: !x means all possible forests of call pairs which are not the forest of call pairs called x.
	Example: !? means no possibilities (and therefore causes TruthValue.bull in everything which depends on it)
	cuz ? means all possibilities.
	<br><br>
	//FIXME maybe this should be generalized to ForAll and Exists and NotExists and Never etc,
	//like what Godel tried to do with integers and failed cuz every integer is finite
	//but wikibinator deals with real numbers (bitstrings of infinite size and some are finite size),
	//such as wikibinator does not contain any haltingOracles (which are possible)
	//but in some cases will prove that some statements halt or do not halt.
	<br><br>		
	Any statement can be preceded by this to claim it is TruthValue.bull,
	such as if someone says <5 (+ 2) 2)> which means 2+2=5 then you can say <!5 (+ 2) 2)>
	to mean that 2+2 equals something other than 5, or say !<5 (+ 2) 2)> to say NOT on the whole statement,
	or say <x (!y !z)> to mean x equals something other than y called on something other than z,
	keeping in mind that equality is by forest shape (of call pairs, where all paths lead to λ)
	and that "variable names" do not change globalIds or forest shapes and are only for convenience
	and any disagreement within the system can in theory be solved by converting all relevant parts
	to tensor4DOfRFPW+triangleArray2DOfEquality form (Verse.java, for example) and filling in
	the relevant TruthValues without any TruthValue.bull occurring,
	only TruthValue.yes, TruthValue.no, and in parts you dont need to know can leave as TruthValue.unknown.
	The Syty.allPossibilities and Syty.allPossibilitiesExcept syntaxs have an indirect representation in
	the conditionalProbability of multiple TruthValues in tensor4DOfRFPW but that is an expensive calculation.
	There is a very cheap direct representation of every possible <r f p w> and !<r f p w>
	in tensor4DOfRFPW (Verse.java) which is simply the TruthValue that a <r f p w> maps to.
	You can expand a <x (!y !z)> into more dims (dimensions) in a tensor4DOfRFPW but
	thats not something I want to get into any time soon cuz its so complex and expensive.
	*
	allPossibilitiesExcept,
	*/
	
	
	/** Example: λ
	means the universal function aka wikibinator.
	<br><br>
	Example: xyz
	means the name xyz.
	<br><br>
	Example: 5.67
	means the cbt64 of the bits of the IEEE754 double 5.67, or TODO should that be in a typeval?
	<br><br>
	Example: "this is a \"string literal\" in a string literal"
	means a cbt of those utf8 bytes or TODO should it be that in a typeval?
	<br><br>
	Example: λ
	Example: λasasdfq324w5rsadfq34w5...3245rdrfgew45345 TODO that one is made up but its a globalId
		that would refer to a specific binary forest of call pairs of λ and can be shared across untrusted borders
		while proving dataIntegrity to eachother as its a merkle forest which can contain binary blobs for efficiency.
	*/
	constant,
	
	/** VARARGLIST doesnt need its own syntax since can just create a var name for (curry unary3) and one for (curry unary4) etc,
	such as (... [d c b a funcBody comment]) where "..." would be the name of (curry unary3)
	and ".." would be the name of (curry unary2),
	or whatever names you like...
	
	/** A vararg view of the Curry op (1 of 8 ops).
	Example (todo choose some syntax other than <vararg>...</vararg>):
	((curry unary3 [d c b a funcBody comment]) e) could be viewed as:
	(<vararg>comment funcBody a b c d</vararg> e) -> <vararg>comment funcBody a b c d e</vararg>,
	but FIXME that needs to know how many curries are left (unary2 aka (T (T λ)) unary1 aka (T λ) or λ for example),
	and since its a vararg that takes 7 params then (<vararg>comment funcBody a b c d e</vararg> b b)
	evals to (funcBody [b b e d c b a funcBody comment]). Thats what the Curry op does,
	it counts down in unary while adding each next param as the first thing in a linkedlist,
	then when the counter reaches unary0 aka λ, it gets funcBody as second last thing in the linkedlist
	and calls funcBody on that linkedlist. A func may also choose to wait for more params
	by calling itself on a higher unary number, when its evaled, so it can actually take
	an infinite number of params in some cases and finite numbers of params other times
	such as to take a variable number of params until one param equals ";" or "quit" then eval.
	*
	varargList,
	*/
	
	/** Example: (a b c)
	means ((a b) c).
	*/
	curryList,
	
	/** Example: [a b c λ] means [a [b [c λ]]] aka (pair a (pair b (pair c λ))).
	Example: [a b c] means [a [b c]] aka (pair a (pair b c)).
	Bitstring and cbt examples...
	[[[T F][T T]][[F F][T F]]] aka the bitstring 101100 (excluding 100000... padding up to next powOf2),
	and supporting bitstrings of unlimited size such as exabit in theory.
	[[T F][T T]] is [[T F] T T].
	[[[T F][T T]][[F F][T F]]] is [[[T F] T T] [F F] T F]. 
	*/
	pairList,
	
	/** Example: {a b}
	means (pair a b).
	UPDATE: I'm taking {...} to mean sCurryList cuz its used far more often.
	*
	pair,
	*/
	
	/** A way of passing 1 param down a binary forest of call pairs,
	similar to how lambdas of named params are done in Unlambda. A sCurryList defines a function,
	and (T x) quotes x, and I/identityFunc gets x, such as {I I} is a function that calls its param on itself,
	and ({I (T x) I} y) -> (y x y), aka <(y x y) {I (T x) I} y>.
	<br><br>
	Example: {a b} means (S a b).
	Example: {a b c} means (S (S a b) c).
	Example: {a {b c} d} means (S (S a (S b c)) c).
	See OcfnUtil.equals() for an example of using this on a practical function.
	TODO also the syntaxes for ST, IF, thenT, and thenConst, which are also used in OcfnUtil.
	*/
	sCurryList,
	
	/** Renaming this to ax for axiomforest node, which is a 3-way forest andOr a 3+1bit way forest above that.
	see SelfRef.ds aka debugstepinator node which is a trinary forest (still redesigning it),
	which is similar to callquads in occamsfuncer but can have lazyeval view of them in the callpair forest.
	This allows different cardinalities, such as transfinite vs integers, to work together.
	*/
	ax;
	//ds,
	
	/** These things dont need their own syntax since can just display like {IF condition ifTrue ifFalse} or something like that?
	where IF is a var name.
	
	/** often used with sCurryList. See OcfnUtil.java in occamsfuncer for examples *
	IF,
	
	/** often used with sCurryList. See OcfnUtil.java in occamsfuncer for examples *
	then,
	
	/** often used with sCurryList. See OcfnUtil.java in occamsfuncer for examples *
	thenT,
	
	/** often used with sCurryList. See OcfnUtil.java in occamsfuncer for examples *
	thenConst,
	*/
		
	//TODO? progn, a sequence of functions like (<progn>a b c d</progn> e) -> (d (c (b (a e)))).
	
	/** Example: <aReturn aFunc aParam aWikiState>.
	Example: <aReturn aFunc aParam> uses "the same wikistate as other near things are using",
	or maybe it should always have 4 things like <aReturn aFunc aParam ?>.
	<br><br>
	TODO rewrite this disorganized comment copied from Pat.java 2021-1-5:
	//FIXME what syntax type is: x = (y [z y z]).
	//Technically it means <? y [z y z] x>, but = is not its first char so thats confusing.
	//Maybe I should just put the return value first, so <x (y [z y z])> means <x y [z y z]> means <x y [z y z] ?>
	//aka <ret func param wikiState>, so when <...> has 2 things it means they equal,
	//and when <...> has 3 things it means the first equals the second called on the third,
	//and when <...> has 4 things it means the same as 3 things except fourth thing is wikiState.
	//
	//So to write x = (y [z y z]), you write: <x y [z y z]>, or you write: <x (y [z y z])>,
	//and THERE IS NO = SYNTAX OTHER THAN <...>.
	*
	rfpw;
	*/
	
	//This seems an interesting syntax similar to function currying https://en.wikipedia.org/wiki/Fexpr
	//https://en.wikipedia.org/wiki/S-expression

}
