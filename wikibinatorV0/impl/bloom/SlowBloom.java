package wikibinatorV0.impl.bloom;

import java.util.concurrent.ForkJoinPool;

import axiomforest.TruthValue;
import wikibinatorV0.impl.veryExperimental.Bloom;

/** The simplest unoptimized implementation of Bloom. It literally stores 1 TruthValue per Bloom
instead of in sparse combos of primitive arrays which would be needed for practical efficiency.
*/
public class SlowBloom implements Bloom{
	
	protected TruthValue v;

	public TruthValue v(){ return v; }

	public Bloom g(long binheapIndex){
		throw new RuntimeException("TODO");
	}

	public void join(Bloom b, int maxDepth, boolean incoming, boolean outgoing){
		if(!incoming && !outgoing) return;
		if(maxDepth <= 0){
			if(maxDepth == 0){
				if(outgoing) b.in(v);
				if(incoming) v = v.join(b.v());
			}
		}else{
			//TODO make some function Fork.fork((int i)->{...do stuff...}, int maxIExcl)?
			l().join(b.l(), maxDepth-1, incoming, outgoing);
			r().join(b.r(), maxDepth-1, incoming, outgoing);
		}
	}

	public void in(TruthValue x){
		v = v.join(x);
	}

	public void put(long binheapIndex, Bloom b){
		throw new RuntimeException("TODO");
	}

	public long[] vn(int n){
		throw new RuntimeException("TODO");
	}

	public Bloom p(Bloom b){
		throw new RuntimeException("TODO");
	}

}
