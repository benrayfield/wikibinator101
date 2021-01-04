package mutable.util;
import static mutable.util.Lg.*;

import java.util.Arrays;

/** Mutable but reversible/unitary. Addresses are in units of 32 bits, stored in an int[].
Writes cost 64 bits each, to remember how to undo them.
<br><br>
A stackptr (sp) into the long[sp++] and which long to do next may depend on current state of the int[],
and when pop from that long[] stack, subtract it from that part of the int[]. Its a way of representing a
cbt536870912 (aka 16 million ints) and can forkEdit it with each next long forward or backward in time (reversible)
BUT cant efficiently have a ptr to multiple states of it cuz would be copyOnWrite. Its a way to optimize a loop
etc which writes into such a cbt and does spend call inside the loop recursively. For example, it could copy any
range of the cbt to any other range of the cbt, by reading whats currently at the relevant indexs in the int[] and
adding the diff to it. Yes, a copy memory range optimization, and can do other things like photoshop-like ops.
It makes it expensive to use floats and doubles as it must be stored as ints but I can do smooth ops with ints
much faster than I can emulate float or double math with ints. Yes, do this...
*/
public final class UndoMem{
	
	private final int[] mem = new int[1<<24];
	
	private final int[] ops = new int[1<<28];
	
	private final int memMask = mem.length-1; //only works if its a powOf2
	
	private int sp; //points into ops
	
	public int readI(int i){
		return mem[i&memMask];
	}
	
	public float readF(int i){
		return Float.intBitsToFloat(readI(i));
	}
	
	public static long intsToLong(int high, int low){
		return (((long)high)<<32)|(low&0xffffffffL);
	}
	
	public long readJ(int i){
		return intsToLong(readI(i),readI(i+1));
	}
	
	public double readD(int i){
		return Double.longBitsToDouble(readJ(i));
	}
	
	/** write, but can only do this writesLeft() times until you need to commit()
	or copy int[] mem to a new UndoMem etc such as using copy().
	WARNING: If write the same val that was already there, does not count an op, so undo() will undo the op before it.
	This means if for example you're painting 1024x1024 screen pixels and it writes the whole screen every time,
	and you only changed 1% of the screen, it only costs 1% that much op space so the undo history can be 100 times longer.
	*/
	public void writeI(int addr, int val){
		addr &= memMask;
		ops[sp++] = addr;
		int change = val-mem[addr];
		ops[sp++] = change; //change at addr
		mem[addr] = val;
		/*int changeExists = change&(change>>>16);
		changeExists &= (changeExists>>>8);
		changeExists &= (changeExists>>>4);
		changeExists &= (changeExists>>>2);
		changeExists &= (changeExists>>>1);
		//changeExists is 0 or 1 depending if change!=0
		sp -= (changeExists<<1); //no branching, other than mem[addr], but tested this and using the IF is faster.
		*/
		if(change == 0) sp-=2; //dont waste an op
	}
	
	public void writeJ(int addr, long val){
		writeI(addr,(int)(val>>32));
		writeI(addr+1,(int)val);
	}
	
	public void writeF(int addr, float val){
		writeI(addr, Float.floatToIntBits(val));
	}
	
	/** floatToRawIntBits is faster than floatToIntBits but is nondeterministic in which of the nonnormed IEEE754 bits it may write.
	Even though it converts float to int in a nonstrict way, undo is still strict and will work.
	*/
	public void writeF_nonstrict(int addr, float val){
		writeI(addr, Float.floatToRawIntBits(val));
	}
	
	public void writeD(int addr, double val){
		writeJ(addr, Double.doubleToLongBits(val));
	}
	
	/** floatToRawIntBits is faster than floatToIntBits but is nondeterministic in which of the nonnormed IEEE754 bits it may write.
	Even though it converts double to long in a nonstrict way, undo is still strict.
	*/
	public void writeD_nonstrict(int addr, double val){
		writeJ(addr, Double.doubleToRawLongBits(val));
	}
	
	/** undo last write(int,int), nomatter how far back it is, and efficiently */
	public void undo(){
		int change = ops[--sp];
		int addr = ops[--sp];
		mem[addr] -= change;
	}
	
	/** undo n steps back, where 0 <= n <= writes() */
	public void undoN(int n){
		if(n < 0) throw new RuntimeException("neg: "+n);
		int max = writes();
		if(n > max) throw new RuntimeException("Only have "+max+" steps, cant go back "+n);
		sp -= (n<<1);
	}
	
	/** number of writes minus number of undos */
	public int writes(){
		return sp>>1;
	}
	
	/** number of times you can call write(int,int) minus number of undo() you call during that
	as long as you dont ever exceed this in the middle.
	*/
	public int writesLeft(){
		return (ops.length-sp)>>1;
	}
	
	/** FIXME handle if the ranges overlap and do it in a loop without calling read and write,
	instead inline the contents of read and write funcs, and also faster cuz doesnt need to mask the addr.
	*/
	public void copyRange(int from, int to, int len){
		for(int i=0; i<len; i++) writeI(to+i, readI(from+i));
	}
	
	/** erase mem state and undo history */
	public void clear(){
		if(writes() < mem.length/3){
			//optimization: few enough writes that its probably faster than wiping the whole int[] mem.
			undoN(writes());
		}else{
			Arrays.fill(mem, 0);
			sp = 0;
		}
	}
	
	/** erase undo info but keep current state, so you can only undo back to here, and have more writesLeft() */
	public void commit(){
		sp = 0;
	}
	
	public UndoMem copy(){
		throw new RuntimeException("TODO");
	}
	
	
	
	//TODO generalize to any powOf2 sizes of int[] and long[]... public UndoMem()
	//using constructor
	
	
	public static void main(String[] args){
		UndoMem m = new UndoMem();
		for(int r=0; r<2; r++){
			double timeStart = Time.now();
			int cycles = 10000000;
			m.writeI(0, 1);
			for(int i=1; i<cycles; i++){
				m.writeI(i, m.readI(i-1)+1);
			}
			double duration = Time.now()-timeStart;
			double hz = cycles/duration;
			double mhz = hz*1e-6;
			lg("ints mhz = "+mhz+" duration="+duration);
		}
		for(int r=0; r<2; r++){
			double timeStart = Time.now();
			int cycles = 10000000;
			m.writeF(0, 3.344353245f);
			for(int i=1; i<cycles; i++){
				m.writeF(i, m.readF(i-1)+1);
			}
			double duration = Time.now()-timeStart;
			double hz = cycles/duration;
			double mhz = hz*1e-6;
			lg("floats mhz = "+mhz+" duration="+duration);
		}
		for(int r=0; r<2; r++){
			double timeStart = Time.now();
			int cycles = 10000000;
			m.writeD(0, 3.344353245f);
			for(int i=2; i<cycles; i+=2){
				m.writeD(i, m.readD(i-2)+1);
			}
			double duration = Time.now()-timeStart;
			double hz = cycles/duration;
			double mhz = hz*1e-6;
			lg("doubles mhz = "+mhz+" duration="+duration);
		}
		/*
		> ints mhz = 430.87885107300986 duration=0.0232083797454834
		> ints mhz = 392.66626722588376 duration=0.0254669189453125
		> floats mhz = 333.6545009068635 duration=0.02997112274169922
		> floats mhz = 307.8501229402914 duration=0.03248333930969238
		> doubles mhz = 400.48352445789686 duration=0.024969816207885742
		> doubles mhz = 340.4826808023574 duration=0.02937006950378418
		
		but it gets much slower when doing smaller loop size.
		*/
		
		
		m.clear();
		int vars = 0;
		int x = vars++, y = vars++, z = vars++;
		m.writeI(x,100);
		m.writeI(y,101);
		m.writeI(z,102);
		lg("Forward...");
		for(int i=0; i<20; i++){
			lg("m.readI(x)%7 == 0 ---> "+(m.readI(x)%7 == 0));
			if(m.readI(x)%7 == 0){
				m.writeI(z, m.readI(z)+1);
			}
			m.writeI(x, m.readI(x)+1);
			lg("x="+m.readI(x)+" y="+m.readI(y)+" z="+m.readI(z));
		}
		lg("Testing undo...");
		while(m.writes() > 0){
			m.undo();
			lg("x="+m.readI(x)+" y="+m.readI(y)+" z="+m.readI(z));
		}
	}

}