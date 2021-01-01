/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;
import static wikibinator.fn.*;
import static wikibinator.impl.Cache.*;

import java.util.function.Supplier;

import wikibinator.Compiled;
import wikibinator.Wiki;
import wikibinator.fn;

public class SimpleFn implements fn{
	
	public final byte op;
	
	//public final fn func, param;
	protected final Supplier<fn> lazyDownloadFunc, lazyDownloadParam;
	
	protected Compiled compiled = interpretedMode;
	
	/** u/theUniversalFunction with isForceDeterminism *
	public SimpleFn(){
		this(false);
	}
	
	/** u aka the universal function, either isDirty or isForceDeterminism *
	public SimpleFn(boolean isDirty){
		this((byte)(isDirty?-128:0), null, null);
	}
	
	public SimpleFn(fn func, fn param){
		this(fn.op(func.op(),param.op()), ()->func, ()->param);
	}
	
	public SimpleFn(Supplier<fn> lazyDownloadFunc, Supplier<fn> lazyDownloadParam){
		this(fn.op(func.op(),param.op()), lazyDownloadFunc, lazyDownloadParam);
	}
	
	public SimpleFn(byte op, fn<T> func, fn<T> param){
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
	
	public SimpleFn(byte op, Supplier<fn> lazyDownloadFunc, Supplier<fn> lazyDownloadParam){
		this.op = op;
		this.lazyDownloadFunc = lazyDownloadFunc;
		this.lazyDownloadParam = lazyDownloadParam;
	}

	public fn L(){ return lazyDownloadFunc.get(); }

	public fn R(){ return lazyDownloadParam.get(); }

	public byte op(){ return op; }

	public Compiled compiled(){ return compiled; }
	
	//FIXME need dedup map. its in Cache.java (TODO)
	
	public fn e(fn param){
		return compiled.get().apply(this, param);
	}
	
	
	//public fn e(fn param){
	public static final Compiled interpretedMode = (fn func, fn param)->{
		//FIXME add <func,param,return> to Cache just before return, if not returning from Cache already
		
		byte opOfCall = fn.op(op, param.op()); //same as new SimpleFn(this,param).op()
		if(isHalted(opOfCall)) return cp(this,param);
		
		//already handled the isHalted kinds, so everything here has at least 6 params
		//or is an evaling called on a halted or a halted called on an evaling or an evaling called on an evaling
		//in which case its low 7 bits of that byte are 0.
		if(areLow7BitsOfOpAll0(opOfCall)){
			return e().e(param.e()); //eval this and param first
		}
		
		//TODO all the logic should be done in the switch(opOfCall), all 256 cases of it,
		//but thats an optimization for later. For now, get the testcases working, as the shorter code is easier to read.
		
		//boolean isDirty = fn.isDirty(opOfCall);
		
		//There are exactly 6 params (instead of handling all 256 cases here, TODO)
		/*switch(opOfCall&0x7f){ //the & gets rid of the isDirty bit, which will be checked for in only relevant cases
		case 0b000000:
		}*/
	
		fn x = L().R(), y = R(), z = param; //the 3 params of each of 8 ops
		switch(opOfCall&7){ //8 opcodes, though some of them use the next 2 bits like opcodes
		case opS:
			return x.e(z).e(y.e(z));
		break;
		case opT:
			return y;
		break;
		case opFI:
			return z;
		break;
		case opReflect:
			if(x.isLeaf()){
				return z.isLeaf() ? T : F;
			}else{ //!x.isLeaf
				return y.isLeaf() ? z.L() : z.R();
			}
		break;
		case opPair:
			return z.e(x).e(y);
		break;	
		case opSecondLastInList:
			if(z.R().R().isLeaf()) return z.L();
			//return this.e(z.R()); //this fn (in the call <this,z>) is a function that gets second last in a linkedlist
			return secondLastInList.e(z.R());
		break;
		case opCurry:
			//Curry x y z //(Curry counter linkedList nextParam)
			//--ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
			fn nextLinkedList = pair.e(z).e(y); //y is linkedList. z is nextParam.
			if(x.isLeaf()){ //x is counter and has counted down to 0 (such as (T (T (T u))) is 3 and u is 0. Eval.
				"FIXME should that be x.R().isLeaf(), and what if x is already leaf? this is an offby1error"
				fn funcBody = secondLastInList.e(nextLinkedList);
				return funcBody.e(nextLinkedList);
			}else{ //has not counted down to 0 yet, so count down 1 more and add nextParam to linkedlist
				fn counterAsOneLess = x.R();
				return curry.e(counterAsOneLess).e(nextLinkedList); //wait for next param to curry again or eval
			}
		break;
		case opWiki:
			/*before calling wiki function, check isDirty(byte) and if !isDirty then eval to (S I I (S I I)). call fnThatInfiniteLoopsForAllPossibleParams=(S (T (S I I)) (T (S I I))) or something like that maybe using lazig on 2 of (S I I)... or simply call (S I I) on itself aka callParamOnItself.e(callParamOnItself)... or just inline it as S.e(I).e(I).e(S.e(I).e(I)); */
			if(!isDirty(this.op)) return S.e(I).e(I).e(S.e(I).e(I)); //infloop so anything that halts is deterministic
			return Wiki.wiki.apply(param); //allow nondeterminism (forkEdit wiki) as long as (L x (R x)) equals x, forall x.
		break;
		default:
			throw new RuntimeException("this can never happen but is here in case java doesnt know that");
		}
	};

	public fn e(){
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
	}
	

}
