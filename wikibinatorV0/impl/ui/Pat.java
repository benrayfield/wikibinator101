package wikibinatorV0.impl.ui;

import java.lang.ref.SoftReference;

/** PArse Tree. A tree view of a shared CharSequence, where each branch is a subrange of it */
public class Pat implements CharSequence{

	/** may be nulls *
	public final CharSequence parent, left, right;
	*/
	
	public final CharSequence code;
	
	public final int from, to;
	
	protected SoftReference<String> cacheString;
	
	protected Syty syty;
	
	public Pat(CharSequence code){
		this(code,0,code.length());
	}
	
	public Pat(CharSequence code, int from, int to){
		if(from < 0 || length() < to) throw new IndexOutOfBoundsException(
			"in constructor len="+code.length()+" asked for from="+from+" to="+to);
		this.code = code;
		this.from = from;
		this.to = to;
	}
	
	public int length(){
		return to-from;
	}
	
	public char charAt(int index){
		return code.charAt(from+index);
	}
	
	public String toString(){
		String ret;
		if(cacheString == null || (ret = cacheString.get()) == null){
			char[] c = new char[length()];
			for(int i=0; i<c.length; i++) c[i] = charAt(i);
			cacheString = new SoftReference(ret = new String(c));
		}
		return ret;
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
	
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof Pat)) return false;
		return toString().equals(o.toString());
	}
	
	/** prefix */
	public CharSequence pre(int to){
		return subSequence(0,to);
	}
	
	/** suffix */
	public CharSequence suf(int from){
		return subSequence(from,length());
	}
	
	/** concat. BigO(this.length()+suf.length()) */
	public CharSequence cat(CharSequence suf){
		return new Pat(toString()+suf.toString());
	}

	/** BigO(1) */
	public CharSequence subSequence(int from, int to){
		if(from == 0 && to == length()) return this;
		if(from < 0 || length() < to) throw new IndexOutOfBoundsException(
			"in subSequence len="+length()+" asked for from="+from+" to="+to);
		return new Pat(code, from, to);
	}
	
	public Syty syty(){
		if(syty == null){
			if(length() == 0){
				syty = Syty.ignore;
			}else{
				//FIXME what syntax type is: x = (y [z y z]).
				//Technically it means <? y [z y z] x>, but = is not its first char so thats confusing.
				//Maybe I should just put the return value first, so <x (y [z y z])> means <x y [z y z]> means <x y [z y z] ?>
				//aka <ret func param wikiState>, so when <...> has 2 things it means they equal,
				//and when <...> has 3 things it means the first equals the second called on the third,
				//and when <...> has 4 things it means the same as 3 things except fourth thing is wikiState.
				//
				//So to write x = (y [z y z]), you write: <x y [z y z]>, or you write: <x (y [z y z])>,
				//and THERE IS NO = SYNTAX OTHER THAN <...>.
				
				
				
				
				//FIXME ([)] would be Syty.parseError, and that can happen for any possible first char
				switch(charAt(0)){
				case '(': //(a b c) means ((a b) c). (a b) is a callPair, not {a b} kind of pair cuz that means ((pair a) b).
					//FIXME UPDATE: {...} is sCurryList, not (pair x y).
					//(a) means a.
					//() means identityFunc so (() a) = (a) = a.
					syty = Syty.curryList;
				break;
				case '[': //[a b c] means {a {b {c λ}}}
					syty = Syty.pairList;
				break;
				case '{': //sCurryList example: {I (T x) I}, and about that: <(y x y) {I (T x) I} y>
					//{...} contains 2 or more things.
					syty = Syty.sCurryList;
				break;
				/*case '{': //{x y} means (pair x y)
					//Theres always 2 things in {}.
					syty = Syty.pair;
				break;
				*/
				case '<':
					syty = Syty.ax;
					/** OLD...
					//Theres 0-4 things in <>, and each of them can be expanded to the 4 view, but usually 2-4.
					//<return func param wikiState>
					//or <return func param> which means <return func param ?>
					//or <return (func param)> such as <x y> if they eval to the same forest of call pairs,
					//	which means <x (L y) (R y) ?> cuz (L x (R x)) equals x forall x, and L and R are derivable from λ.
					//<return> means <return ? ? ?>, which means "what are all the possible things that return this?".
					//<> means <? ? ? ?> which means "what are all the possible tensor4D statements in the universe?"
					syty = Syty.rfpw;
					*/
				break;
				/*case '?': //? means TruthValue.unknown for all bits in the dimIndex/pointer/globalId to this object
					//? is the only kind of this.
					syty = Syty.allPossibilities;
				break;
				/*case '!':
					//FIXME maybe this should be generalized to ForAll and Exists and NotExists and Never etc,
					//like what Godel tried to do with integers and failed cuz every integer is finite
					//but wikibinator deals with real numbers (bitstrings of infinite size and some are finite size),
					//such as wikibinator does not contain any haltingOracles (which are possible)
					//but in some cases will prove that some statements halt or do not halt.
					//
					//Example: !["hello" "world"] means all possible forests of call pairs other than ["hello" "world"],
					//but its only practically efficient to use outside a <...> statement like...
					//<5 (+ 2) 2)> which means 2+2=5 then you can say <!5 (+ 2) 2)>
					//to mean that 2+2 equals something other than 5, or say !<5 (+ 2) 2)> to say NOT on the whole statement.
					syty = Syty.allPossibilitiesExcept;
				break;
				*/
				case '/': //comment or /someNameThatStartsWithSlash
					if(length() > 1 && charAt(2)=='/'){ //TODO choose some single char to start a comment? Or use string literal?
						syty = Syty.ignore;
					}
				//dont break
				default:
					//numberLiterals, stringLiterals, the λ constant, and globalIds are constants.
					//? is not a constant cuz "? means TruthValue.unknown for all bits in the dimIndex/pointer/globalId to this object".
					//A constant is a specific forest of call pairs where all paths lead to λ and which is halted.
					//A forest of call pairs if halted IFF foreach node reachable in its childs recursively theres at most 5 curries.
					syty = Syty.constant;
					//TODO??? throw new RuntimeException("TODO "+this);
				}
			}
		}
		return syty;
	}
	
	

}