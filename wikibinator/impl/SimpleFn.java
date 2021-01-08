/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;
import static wikibinator.impl.ImportStatic.*;

import java.lang.ref.SoftReference;
//import static wikibinator.fn.*;
//import static wikibinator.impl.Cache.*;
import java.util.function.Supplier;

import wikibinator.Compiled;
import wikibinator.WikiState;
import wikibinator.λ;

public class SimpleFn implements λ{
	
	/** The purpose of SoftReference is for JVM to decide when to garbcol things
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
	When any λ parent has !parent.l.isHalted and parent.r.isHalted
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
	*/
	protected SoftReference<λ> cacheAnyRet;
	
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
	
	public SimpleFn(byte op, λ func, λ param){
		this.op = op;
		this.func = func;
		this.param = param;
	}

	//public fn L(){ return lazyDownloadFunc.get(); }

	//public fn R(){ return lazyDownloadParam.get(); }

	public byte op(){ return op; }

	public Compiled compiled(){ return compiled; }
	
	//FIXME need dedup map. its in Cache.java (TODO)
	
	public λ e(λ param){
		return compiled.get().apply(this, param);
	}
	
	
	//public fn e(fn param){
	public static final Compiled interpretedMode = wrapInCompiled((λ func, λ param)->{
		//FIXME add <func,param,return> to Cache just before return, if not returning from Cache already
		
		byte opOfCall = funcOpAndParamOpToParentOp(func.op(), param.op()); //same as new SimpleFn(this,param).op()
		if(opIsHalted(opOfCall)) return cp(func,param);
		
		//already handled the isHalted kinds, so everything here has at least 6 params
		//or is an evaling called on a halted or a halted called on an evaling or an evaling called on an evaling
		//in which case its low 7 bits of that byte are 0.
		if(areLow7BitsOfOpAll0(opOfCall)){
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
		switch(opOfCall&7){ //8 opcodes, though some of them use the next 2 bits like opcodes
		case opS:
			return x.e(z).e(y.e(z));
		//break;
		case opT:
			return y;
		//break;
		case opFI:
			return z;
		//break;
		case opReflect:
			if(x.isLeaf()){
				return z.isLeaf() ? T : F;
			}else{ //!x.isLeaf
				return y.isLeaf() ? z.L() : z.R();
			}
		//break;
		case opPair:
			return z.e(x).e(y);
		//break;
		case opSecondLastInList:
			if(z.R().R().isLeaf()) return z.L();
			//return this.e(z.R()); //this fn (in the call <this,z>) is a function that gets second last in a linkedlist
			//return secondLastInList.e(z.R());
			return GetFuncBody.e(z.R());
		//break;
		case opCurry:
			//Curry x y z //(Curry counter linkedList nextParam)
			//--ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
			λ nextLinkedList = Pair.e(z).e(y); //y is linkedList. z is nextParam.
			if(x.isLeaf()){ //x is counter and has counted down to 0 (such as (T (T (T u))) is 3 and u is 0. Eval.
				if(1<2) throw new RuntimeException("FIXME should that be x.R().isLeaf(), and what if x is already leaf? this is an offby1error");
				λ funcBody = GetFuncBody.e(nextLinkedList);
				//FIXME??? offby1error in size of nextLinkedList including nextParam or not? offby1error somewhere else?
				return funcBody.e(nextLinkedList);
			}else{ //has not counted down to 0 yet, so count down 1 more and add nextParam to linkedlist
				λ counterAsOneLess = x.R();
				//FIXME??? offby1error in size of nextLinkedList including nextParam or not? offby1error somewhere else?
				return Curry.e(counterAsOneLess).e(nextLinkedList); //wait for next param to curry again or eval
			}
		//break;
		case opWiki:
			/*before calling wiki function, check isDirty(byte) and if !isDirty then eval to (S I I (S I I)). call fnThatInfiniteLoopsForAllPossibleParams=(S (T (S I I)) (T (S I I))) or something like that maybe using lazig on 2 of (S I I)... or simply call (S I I) on itself aka callParamOnItself.e(callParamOnItself)... or just inline it as S.e(I).e(I).e(S.e(I).e(I)); */
			if(!func.isDirty()) infloop(); //return S.e(I).e(I).e(S.e(I).e(I)); //infloop so anything that halts is deterministic
			return WikiState.wiki.apply(param); //allow nondeterminism (forkEdit wiki) as long as (L x (R x)) equals x, forall x.
		//break;
		default:
			throw new RuntimeException("this can never happen but is here in case java doesnt know that");
		}
	});

	public λ g(long binheapIndex){
		throw new RuntimeException("TODO");
	}

	public λ G(long cbtBinheapIndex){
		throw new RuntimeException("TODO");
	}

	public void setCompiled(Compiled newCompiled){
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
