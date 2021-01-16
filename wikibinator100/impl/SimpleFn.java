/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator100.impl;
import static wikibinator100.impl.ImportStatic.*;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
//import static wikibinator.fn.*;
//import static wikibinator.impl.Cache.*;
import java.util.function.Supplier;

import wikibinator100.$λ;
import wikibinator100.Compiled;
import wikibinator100.HeaderBits;
import wikibinator100.WikiState;
import wikibinator100.λ;

public class SimpleFn implements λ{
	
	/** UPDATE: Use WeakReference of what each λ (call) evals to (when thats observed)
	and keep many parent λ (whose L() is that call and whose R() is what it evals to)
	in some sorted collection (such as minheap or treemap) sorted by λ.garbcolOrder,
	so what those WeakReference point to wont be garbcoled until the minheap
	allows garbcol of the statement that the eval equals the return,
	and keep count of estimated total memory (as each λ adds some, especially if it wraps a blob)
	and garbcol in order of that minheap until get down to maybe 90% of max memory allowed,
	continuously, and when change λ.garbcolOrder (every time its accessed, like by touch time)
	then move it in the minheap. The minheap must not include anything that cant be garbcoled
	due to having incoming pointers such as from other λ,
	so TODO create a class just for this which has just those 2 ptrs to λ,
	or maybe just the 1 ptr to the R() λ (the return value).
	Look at how CacheFuncParamReturn.java did it in occamsfuncer,
	but there was still more basic work to do to that.
	Since the minheap stores RFPs (RFPD? or RFPW? Or just RFP?),
	and RFPs of nondeterministic wikiState,such as a claim that (wiki "hello")->"world" aka <"world" (wiki "hello")>,
	can not always be rederived from other known things as the wiki can have some of the physical world's state in it,
	but in other ways many things can be downloaded again from various peers or rederived from
	combos of things they know as the wiki has to be 1 function (forkEdited by millions of people and computers at once),
	that anyone can call (including recursively a wiki call can call wiki...)
	therefore... the minheap needs some kind of redesign to not lose the primary storage source of any data
	unless its near certain that question will never be asked again such as
	making up a random number to prefix things with that are meant to be temp calculations
	and not telling anyone that random number and forgetting it yourself,
	for example a "salt" param (not HeaderBits.isSalt which is a lower level, but a salt thats a cbt)
	which gets forkEdited by 1 of 2 unitary functions to vary itself deterministicly down
	paths of function calls so that nondeterministic calls (such as spend, to limit compute resources recursively, in wiki)...
	so such calls can be repeatable by whoever has such a RFP cache but can garbcol that without
	having to store it in longterm public space, but it still being part of the wiki,
	just a part that its exponentially unlikely that anyone will ever ask about again (not even you who created it and forgot it)
	so basically you can make up random addesses for temp vars to do temp calculations
	and in abstract math define them as part of the wiki function, such as <retValOfXYZ (wiki ["varNameXYZ" aRandomNumber "temp"])>,
	and its still true, in abstract math, that forever after that
	anyone in the world who calls (wiki ["varNameXYZ" aRandomNumber "temp"]) gets the return value retValOfXYZ,
	and you may actually share that RFP with them so it works there, and the both of you 2 may forget it,
	or store it longer, but others are exponentially unlikely to ever make that call,
	and the logic of it is, "x implies y" is true if x is always false, so you never have to do y,
	but you actually can do y its just an expensive to store things longterm.
	Its very very cheap in wikibinator to sync in turing-complete ways.
	It could in theory sync the whole internet at gaming-low-lag. But storage is expensive.
	It will have 99.9999999% binary efficiency for storage,
	even though storage purely in id256s has 25% binary efficiency,
	but the same id256 can be derived from a bitstring of any size such as if you sent someone a megabyte bitstring
	with an id256 of that megabyte, you dont have to send the internal nodes of the binary forest
	since they can be derived from that megabyte. But storage in general is just expensive longterm
	compared to how much data computers create and delete in their memory per second such as 1 teraflop GPU.
	Also, id256s are lazyEvaled so you only need the long (64 bit) header in memory and can dedup most things,
	just cant efficiently dedup blobs without the ids, but can dedup things above the blobs using == on blob wrappers.
	The id256s are perfect dedup by binary forest shape but multiple things can have the same return value.
	<br><br>
	<br><br>
	<br><br>
	<br><br>
	OLD: The purpose of SoftReference is for JVM to decide when to garbcol things
	based on how much memory is available as its defined as a cache. Nondeterministic things in
	wikiState will need something more than this since they cant be derived again without at
	least some parts of that. On the other hand, deterministic things can all be derived only from λ
	so are all cache. The deterministic functions, which you can build a whole universe with, is 100% cache.
	Theres nothing other than cache in such a virtual world.
	<br><br>
	Its called cacheAnyRet instead of cacheRet cuz dedup is lazy and in case the math axioms
	are not used correctly or some peer in network is trusted that shouldnt have, which leads to bull
	or may lead to bull later, but before that, multiple return values, that are not the same forest shape,
	could happen, but will never happen in the correct use of the system,
	so until that converges, this "cuts you some slack" in returning "any" of those return values
	even though in the perfect math axioms theres only 1 return value, which it converges toward.
	<br><br>
	FIXME I wrote the below paragraph wrong. The parent knows its 2 childs eval to the same thing,
	but the SoftReference<λ> goes in parent.l and points at parent.r,
	so the parent tells parent.l about parent.r. TODO fix the below text.
	and parent.returnValOfLeftChildEqualsReturnValOfRightChild
	THEN can set parent.cacheAnyRet = new SoftReference(parent.r),
	which is a RFPD cache aka return func param isDeterministic,
	so when someone wants to compute (x y), then create a new (x y) and dedup or partialDedup it,
	which finds that parent aka is that (x y) and looks in (x y).cacheAnyRet.get()
	(and dont forget to check if the SoftReference is null as you replace it for each value it is a soft reference to) 
	and if that (x y).cacheAnyRet.get() returns a λ then thats the halted return value of (x y).
	This is similar to occamsfuncer's CacheFuncParamReturn.java
	which is a map of callquad to callquad aka fn.java to fn.java.
	If (x y).cacheAnyRet==null or (x y).cacheAnyRet.get()==null THEN recurse to compute the return value
	aka debugStepInto. If the SoftReference has it, thats a debugStepOver.
	<br><br>
	TODO theres probably faster ways to compute this than interacting directly with the java garbage collector
	thru SoftReference, such as using UndoMem and Bloom and lwjgl opencl and javassist etc,
	but this is an ok way to prototype wikibinator and maybe will be efficient enough longterm for interpreted mode.
	<br><br>
	WARNING might have to use leastRecentlyUsed caching instead of using SoftReference cuz...
	https://blog.shiftleft.io/understanding-jvm-soft-references-for-great-good-and-building-a-cache-244a4f7bb85d
	QUOTE
		1. don’t trust the javadoc:
		All soft references to softly-reachable objects are guaranteed to have been freed before the virtual machine throws an OutOfMemoryError		
		That’s a lie. It was true when soft references were first introduced in java 1.2, but from java 1.3.1 the jvm property -XX:SoftRefLRUPolicyMSPerMB was introduced. It defaults to 1000 (milliseconds), meaning that if there’s only 10MB available heap, the garbage collector will free references that have been used more than 10s ago. I.e. everything else will not be freed, leading to an OutOfMemoryError, breaking the guarantee from the javadoc (I’ll try to get that changed).
		No problem, let’s just set it to -XX:SoftRefLRUPolicyMSPerMB=0 and the javadoc is suddenly true again.
	UNQUOTE.
	Also, least recently used will probably be more efficient.
	*
	protected SoftReference<λ> cacheAnyRet;
	TODO test SoftReference caching does it work reliably (not run out of memory ever)
	AND benchmark it against leastRecentlyUsed [map of λ nonhalted -> λ halted] cache.
	Created ReturnFuncParamCache class for that. Will need some class like CacheFuncParamReturn.java in occamsfuncer,
	a map of λ nonhaltedCall to ReturnFuncParamCache, or something like that.
	...
	FIXME consider replacing ReturnFuncParamCache with the "parent" in comments of cacheAnyRet,
	so CacheFuncParamReturn.java would have a map of λ x to λ parent where parent.l==x and parent.r is what x evals to,
	so SimpleFn. would have a mutable long thats the same as ReturnFuncParamCache.timeLastUsed.
	
	see the comments around cacheAnyRet, where this is the "parent" and this is like CacheFuncParamReturn.
	This will be garbcolable (garbage collectible) if its the leastRecentlyUsed one thats
	not reachable by any Other λ thru its λ.l and λ.r child pointers deeply.
	If x can reach y and x is not going to be garbcoled now, then neither will y be garbcoled,
	but many λ will be kept only as cache of for example what (x z) or (y z) or (y x) etc returns,
	and those will become garbcolable in order of leastRecentlyUsed.
	So put the touch() func in λ.java interface and the e() func andOr e(long maxSpend)
	funcs will automatically call touch.
	*
	protected long timeLastUsed;
	*/
	protected long garbcolOrder;
	
	/** used with garbcolOrder and a minheap of λs that stays sorted by λ.garbcolOrder,
	able to find the λ with smallest λ.garbcolOrder. See comment of λ.garbcolOrder.
	Its "any return" instead of "the return" cuz it might be multiple before dedup
	or if in a p2p network and it hasnt yet converged to at most 1 return value per call.
	In the abstract math there is exactly 1 return value for each call.
	*/
	protected WeakReference<λ> cacheAnyRet;
	
	//public final byte op;
	
	/** the 32 TruthValues (2 bits each) described in HeaderBits.
	The YES parts are in high 32 bits, NO parts in low 32 bits.
	Axioms read long header in many binary forest nodes (λ's) and derive new TruthValues
	and OR those into various λ.header without ever causing TruthValue.bull (simultaneous YES and NO)
	except if that does happen then it proves the math was computed wrong so
	backtrack andOr try it in various other combos to find what went wrong and proceed
	without any BULL. Bull occurs when (((int)(header>>32))&(int)header)!=0 aka HeaderBits.hasAnyBull(long).
	*/
	protected long header;
	
	public final λ func, param;
	
	//This kind of thing moved to RemoteFn.
	//protected final Supplier<fn> lazyDownloadFunc, lazyDownloadParam;
	
	protected Compiled compiled = interpretedMode;
	
	/** u/theUniversalFunction with isForceDeterminism *
	public SimpleFn(){
		this(false);
	}
	
	/** u aka the universal function, either isDirty or isForceDeterminism */
	public SimpleFn(boolean isDirty){
		this((byte)(isDirty?-128:0), null, null);
	}
	
	public SimpleFn(λ func, λ param){
		this(funcOpAndParamOpToParentOp(func.op(),param.op()), func, param);
	}
	
	/*public SimpleFn(byte op, fn<T> func, fn<T> param){
		//this.op = op;
		//this.func = func;
		//this.param = param;
		
		//TODO optimize. "this.func = func!=null ? I : this" is infloop cuz I is derived
		//by calling these constructors (what if it was its own class? then could do this optimization,
		//to just return func from L() and return param from R() and them still be final.
		//this.func = func!=null ? I : this;
		//this.param = param!=null ? param : this;
		
		//this.compiled = compiled;
	}*/
	
	/** long header is described by HeaderBits aka is 32 TruthValues. */
	public SimpleFn(long header, λ func, λ param){
		this.header = header;
		this.func = func;
		this.param = param;
	}

	//public fn L(){ return lazyDownloadFunc.get(); }

	//public fn R(){ return lazyDownloadParam.get(); }

	public byte op(){
		return HeaderBits.opByte(header);
	}

	public Compiled compiled(){ return compiled; }
	
	//FIXME need dedup map. its in Cache.java (TODO)
	
	public λ e(λ param){
		return compiled.get().apply(this, param);
	}
	
	
	//public fn e(fn param){
	public static final Compiled interpretedMode = wrapInCompiled((λ func, λ param)->{
		//FIXME add <func,param,return> to Cache just before return, if not returning from Cache already
		
		byte opOfCall = funcOpAndParamOpToParentOp(func.op(), param.op()); //same as new SimpleFn(this,param).op()
		if(HeaderBits.opIsHalted(opOfCall)) return cp(func,param);
		
		//already handled the isHalted kinds, so everything here has at least 6 params
		//or is an evaling called on a halted or a halted called on an evaling or an evaling called on an evaling
		//in which case its low 7 bits of that byte are 0.
		if(HeaderBits.areLow7BitsOfOpAll0(opOfCall)){
			throw new RuntimeException("TODO");
			//return e().e(param.e()); //eval this and param first
		}
		
		//TODO all the logic should be done in the switch(opOfCall), all 256 cases of it,
		//but thats an optimization for later. For now, get the testcases working, as the shorter code is easier to read.
		
		//boolean isDirty = fn.isDirty(opOfCall);
		
		//There are exactly 6 params (instead of handling all 256 cases here, TODO)
		/*switch(opOfCall&0x7f){ //the & gets rid of the isDirty bit, which will be checked for in only relevant cases
		case 0b000000:
		}*/
	
		λ x = func.L().R(), y = func.R(), z = param; //the 3 params of each of 8 ops
		switch(opOfCall&31){ //8 opcode categories, though some of them use the next 2 bits like opcodes
		case opS00: case opS01: case opS10: case opS11:
			return x.e(z).e(y.e(z));
		//break;
		case opTFI00: case opTFI01:
			//TODO swap the order of T and FI?
			return y; //FI
		case opTFI10: case opTFI11:
			//TODO swap the order of T and FI?
			return x; //T
		//break;
		//case opFI:
		//	return z;
		//break;
		case opReflect00:
			return z.isLeaf()?T:F;
		case opReflect01:
			//FIXME should this be isDirty or isDirtyDeep or some clean and some deep (see that HeaderBits thing).
			return z.isDirty()?T:F;
		case opReflect10:
			return z.L();
		case opReflect11:
			return z.R();
		//	if(x.isLeaf()){
		//		return z.isLeaf() ? T : F;
		//	}else{ //!x.isLeaf
		//		return y.isLeaf() ? z.L() : z.R();
		//	}
		//break;
		case opTypeval00: case opTypeval01: case opTypeval10: case opTypeval11:
		case opPair00: case opPair01: case opPair10: case opPair11:
			//Typeval is same as pair func but is useful as a semantic. same as pair func but its useful as a semantic. 
			return z.e(x).e(y);
		//break;
		case opSecondLastInList00:
			//maybe last in list? but only really need an op for second last to get funcBody. Can derive the others efficiently.
			//Maybe isLinkedList?
			return reservedForPossibleFutureExpansion();
		case opSecondLastInList01:
			//GetFuncBody aka getSecondLastInList
			if(z.R().R().isLeaf()) return z.L();
			//return this.e(z.R()); //this fn (in the call <this,z>) is a function that gets second last in a linkedlist
			//return secondLastInList.e(z.R());
			return GetFuncBody.e(z.R()); //recurse
		case opSecondLastInList10:
			//maybe third last in list? but only really need an op for second last to get funcBody. Can derive the others efficiently.
			//Maybe isLinkedList?
			return reservedForPossibleFutureExpansion();
		case opSecondLastInList11:
			//maybe fourth last in list? but only really need an op for second last to get funcBody. Can derive the others efficiently.
			//Maybe isLinkedList?
			return reservedForPossibleFutureExpansion();
		case opCurry00: case opCurry01:
			//x (the first 0 in opCurry00 and opCurry01)
			//is counter and has counted down to 0 (such as (T (T (T u))) is 3 and u is 0. Eval.
			λ nextLinkedList = Pair.e(z).e(y); //y is linkedList. z is nextParam.
			λ funcBody = GetFuncBody.e(nextLinkedList);
			return funcBody.e(nextLinkedList);
		case opCurry10: case opCurry11:
			//x (the first 0 in opCurry00 and opCurry01) is not leaf,
			//which means it has not counted down to 0 yet, so just remember another param into the linkedlist,
			//which will opCurry01 later (the 1 being the linkedlist which is of course not leaf).
			nextLinkedList = Pair.e(z).e(y); //y is linkedList (second last thing in it is funcBody). z is nextParam.
			λ counterAsOneLess = x.R();
			return Curry.e(counterAsOneLess).e(nextLinkedList);
		//break;
		case opWiki00: //(λ λ λ λ λ λ) is wiki, so (λ λ λ λ λ λ x) is (wiki x).
			//call the wiki on a param. if !isDirty aka isDeterministic, then wiki is (S I I (S I I)),
			//else wiki is whatever many people and computers converge toward some consistent set of RFPD cache entries about
			//as computed by (UnaryOperator<λ>)WikiState.wiki
			
			/*before calling wiki function, check isDirty(byte) and if !isDirty then eval to (S I I (S I I)). call fnThatInfiniteLoopsForAllPossibleParams=(S (T (S I I)) (T (S I I))) or something like that maybe using lazig on 2 of (S I I)... or simply call (S I I) on itself aka callParamOnItself.e(callParamOnItself)... or just inline it as S.e(I).e(I).e(S.e(I).e(I)); */
			if(!func.isDirty()) infloop(); //return S.e(I).e(I).e(S.e(I).e(I)); //infloop so anything that halts is deterministic
			return WikiState.wiki.apply(param); //allow nondeterminism (forkEdit wiki) as long as (L x (R x)) equals x, forall x.
			
		case opWiki01:
			//cleanCall (todo rename that op byte to cleanCall)
			
			/*FIXME this needs 2 params of op space since it has 2 params.
			(if it had 3 params it would need 4 params of op space, and if it takes 1 param it needs only 1 param of op space)
			Theres space in opSecondLastInList* but todo rename that since its no longer just opSecondLastInList.
			TODO rename detcall to cleancall since dirty means nondeterministic and clean means deterministic.
			*/
			
			//cleanCall. (cleanCall y z) -> (setCleanDeep (setCleanDeep y (setCleanDeep z))), but without creating the nondet forms in the middle steps,
			//due to that call being put together by nondeterministic stuff such as by nondeterministic_S_lambda,
			//as an optimization for nondeterministic λs which contain deterministic λs to call those on eachother
			//without the middle step of becoming nondeterministic.
			
			//what this returns is already clean deep, cuz clean deep called on clean deep is always clean deep.
			return y.setDirtyDeep(false).e(z.setDirtyDeep(false));
			
			/* TODO maybe put the op described in this comment in one of the other reserved opcode spaces?
			//maybe this op should be flipDeepIfAlreadyAllTheSameDetVsNondetDeeply, like in (λ)λ.dirtyDeep(boolean)?
			//The purpose of that is the merkle hash is constant, and only changes header bits,
			//when everything reachable thru l() and r() recursively is all dirty or all !dirty.
			//dirty means nondeterministic. !dirty means deterministic.
			//See HeaderBits.containsDirtyAndNondirtyDeeply
			return reservedForPossibleFutureExpansion();
			*/
			
		case opWiki10:
			//setdet
			//forkEdit param to be deterministic. A deterministic or nondeterministic func can do this,
			//since the result is deterministic. TODO does that mean that deterministic can only have a param
			//thats already deterministic and just return that param as it is?
			
			//FIXME swap opWiki00 with opWiki01 so the last param (the last 0 or 1 aka param 5 of 6 is leaf or is any nonleaf)
			//it aligns with HeaderBits.isNondeterministic or is it .isDeterministic?
			
			return z.setDirty(false);
			
		case opWiki11:
			//setnondet
			//forkEdit param to be nondeterministic. This must infloop if func is deterministic.
			
			//FIXME swap opWiki00 with opWiki01 so the last param (the last 0 or 1 aka param 5 of 6 is leaf or is any nonleaf)
			//it aligns with HeaderBits.isNondeterministic or is it .isDeterministic?
			
			if(!func.isDirty()) infloop();
			return z.setDirty(true);
			
		//break;
		default:
			throw new RuntimeException("this can never happen but is here in case java doesnt know that");
		}
	});
	
	public λ setNondeterministic(boolean nondeterministic){
		throw new RuntimeException("UPDATE: merkle hash might need to include isDeterministic vs nondeterministic bit, at least in some cases (or all?) cuz parent.isDeterministic can differ from its 2 child isDeterministics as nondet can call det but if det calls nondet then (todo choose a design) it either recursively converts the nondet to det before the det sees it, or it must infloop??? OLD... TODO forkedit this λ to have that TruthValue in its header, and remember 2 λs together so each can efficiently return the other without having to keep creating more of them, and in ids isNondeterministic should be part of key and merkle but should not be input to the hash algorithm and should be able to just flip that bit in the header, in forkedited λ, and set other parts to TruthValue.unknown since the behaviors of determinism and nondeterminism can differ deeply (cuz wiki infloops or not), so only differs in header not in the 192 bits of hash_or_literal. It has to be part of key since they are 2 different forest nodes. A forest node 'is the same forest shape' (todo update that part of Headerbits, theres a truthvalue for it) if it has the same L and R childs recursively AND the same isNondeterministic bit/truthvalue.");
	}

	public λ g(long binheapIndex){
		throw new RuntimeException("TODO");
	}

	public λ G(long cbtBinheapIndex){
		throw new RuntimeException("TODO");
	}

	public void setCompiled(Compiled newCompiled){
		throw new RuntimeException("TODO");
	}

	public λ e(){
		throw new RuntimeException("TODO");
	}

	public $λ e(long maxSpend){
		throw new RuntimeException("TODO");
	}

	public λ f(λ param){
		throw new RuntimeException("TODO");
	}

	public long header(){
		throw new RuntimeException("TODO");
	}

	public void headerOreq(long oreq){
		throw new RuntimeException("TODO");
	}

	public λ flip(){
		throw new RuntimeException("TODO");
	}

	public λ setDirty(boolean dirty){
		throw new RuntimeException("TODO");
	}

	public λ setDirtyDeep(boolean dirtyDeep){
		throw new RuntimeException("TODO");
	}

	/*public fn e(){
		if(fn.isHalted(op)) return this;
		//(L x (R x)) equals x, forall x. If this parent node is not halted,
		//then eval one child on the other to derive parent.
		return L().e(R());
	}

	public fn f(fn param){
		//just create the call pair without evaling it.
		//This is BigO(heightOfForest) to eval, like in iotavm (see benrayfields github project iotavm),
		//instead of the BigO(1) smaller pieces of work like in occamsfuncer callquad,
		//but if using java stack to do it, its still bigO(1) but I mean the algorithm as self contained
		//without the java stack optimization. So this is actually fast to call.
		return cp(this,param);
	}*/
	

}
