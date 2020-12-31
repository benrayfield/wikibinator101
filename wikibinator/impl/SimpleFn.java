/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;
import static wikibinator.fn.*;
import static wikibinator.impl.Cache.*;

import wikibinator.Wiki;
import wikibinator.fn;

public class SimpleFn<T> implements fn<T>{
	
	public final byte op;
	
	public final fn<T> func, param;
	
	protected T cbt;
	
	/** u/theUniversalFunction with isForceDeterminism */
	public SimpleFn(){
		this(false);
	}
	
	/** u aka the universal function, either isDirty or isForceDeterminism */
	public SimpleFn(boolean isDirty){
		this((byte)(isDirty?-128:0), null, null, null);
	}
	
	public SimpleFn(fn<T> func, fn<T> param){
		this(fn.op(func.op(),param.op()), func, param, null);
	}
	
	public SimpleFn(byte op, fn<T> func, fn<T> param){
		this(op,func,param,null);
	}
	
	public SimpleFn(byte op, fn<T> func, fn<T> param, T cbt){
		this.op = op;
		this.func = func;
		this.param = param;
		this.cbt = cbt;
	}

	public fn L(){ return func; }

	public fn R(){ return param; }

	public byte op(){ return op; }

	public T cbt(){ return cbt; }
	
	//FIXME need dedup map. its in Cache.java (TODO)
	
	
	
	public fn e(fn param){
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
	
		fn x = L().L().R(), y = L().R(), z = param; //the 3 params of each of 8 ops
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
			if(x.isLeaf())){
				return z.isLeaf() ? T : F;
			}else{ //!isLeaf(x.op())
				if(y.isLeaf()) z.L();
				else z.R();
			}
		break;
		case opPair:
			return z.e(x).e(y);
		break;	
		case opSecondLastInList:
			if(z.R().R().isLeaf()) return z.L();
			return this.e(z.R()); //this fn (in the call <this,z>) is a function that gets second last in a linkedlist
		break;
		case opCurry:
			//Curry x y z //(Curry counter linkedList nextParam)
			//--ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
			fn nextLinkedList = pair.e(z).e(y); //y is linkedList. z is nextParam.
			if(x.isLeaf()){ //x is counter and has counted down to 0 (such as (T (T (T u))) is 3 and u is 0. Eval.
				fn funcBody = secondLastInList.e(nextLinkedList);
				return funcBody.e(nextLinkedList);
			}else{ //has not counted down to 0 yet, so count down 1 more and add nextParam to linkedlist
				fn counterAsOneLess = x.R();
				return curry.e(counterAsOneLess).e(nextLinkedList); //wait for next param to curry again or eval
			}
		break;	
		case opImport:
			return Wiki.wiki.apply(param);
		break;
		default:
			throw new RuntimeException("this can never happen but is here in case java doesnt know that");
		}
	}
	

}
