package wikibinator.impl.ui;

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
	*/
	allPossibilities,
	
	/** Example: !x means all possible forests of call pairs which are not the forest of call pairs called x.
	Example: !? means no possibilities (and therefore causes TruthValue.bull in everything which depends on it)
	cuz ? means all possibilities.
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
	*/
	allPossibilitiesExcept,
	
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
	
	/** Example: (a b c)
	means ((a b) c).
	*/
	curryList,
	
	/** Example: [a b c]
	means (pair a (pair b (pair c λ)))
	means {a {b {c λ}}}
	*/
	linkedList,
	
	/** Example: {a b}
	means (pair a b).
	*/
	pair,
	
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
	*/
	rfpw;

}
