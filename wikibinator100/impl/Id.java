package wikibinator100.impl;

import java.util.function.UnaryOperator;

import immutable.util.HashUtil;
import immutable.util.MathUtil;
import wikibinator100.HeaderBits;
import wikibinator100.Word;

public class Id{
	private Id(){}
	
	/** FIXME put a specific Word here. Use 192 0s as its hash. */
	public static final Word idKeyOfTheλSymbol = null;

	/** The purpose of having this constant here is that,
	the left child of idKeyOfTheλSymbol is idKeyOfIdentityFunc,
	and the right child of idKeyOfTheλSymbol is idKeyOfTheλSymbol.
	<br><br>
	FIXME TODO derive this from 5 calls of idKey starting with idKey(idKeyOfTheλSymbol,idKeyOfTheλSymbol)
	or idKey(idKeyOfTheλSymbol,idKey(idKeyOfTheλSymbol,idKeyOfTheλSymbol))
	which TODO finalize the order of the opcodes and find which of them is identityFunc,
	which is consistent with (L x (R x)) equals x forall x.
	*/
	public static final Word idKeyOfIdentityFunc = null;
	
	/** The normed form of anything that does not halt is (S I I (S I I)),
	and its 2 childs are (S I I) and (S I I) which are each halted.
	FIXME I had been using normedFormOfAnythingThatDoesNotHalt as a thing which is its own left and right childs,
	BUT thats just what it evals to. Confirm (L x (R x)) equals x for (S I I (S I I)).
	Its 2 childs are both (S I I).
	1: (L (S I I (S I I))) never halts.
	2: (R (S I I (S I I))) never halts.
	3: (L (S I I (S I I)) (R (S I I (S I I)))) never halts.
	I've been defining any 2 things which never halt as equal to eachother
	at least in the HeaderBits.returnValOfLeftChildEqualsReturnValOfRightChild way,
	and I've been using (S I I (S I I)) as the thing they all return,
	as a semantic for the normed form of anything which does not halt.
	Since all 3 of those things (1: 2: 3: above) do not halt,
	we can use the semantic that they all HeaderBits.returnValOfLeftChildEqualsReturnValOfRightChild eachother.
	*/
	public static final Word idKeyOfTheNormedFormOfAnythingThatDoesNotHalt = null;
	
	/** FIXME put a specific Word here. Use 192 1s as its hash. */
	public static final Word idKeyOfTheMainWikiStateSymbol = null;
	
	public static final int headerIsWhichOfFourLongs = 0;
	
	public static Word idKey(Word w){
		if(headerIsWhichOfFourLongs != 0) throw new RuntimeException("TODO");
		long newHeader = w.a&HeaderBits.keyMask;
		if(newHeader == w.a) return w;
		return new Word(newHeader, w.b, w.c, w.d);
	}
	
	public static Word idKey(Word left, Word right){
		return idKey(left, right, HashUtil::sha3_256);
	}
	
	public static Word idKey(Word left, Word right, UnaryOperator<byte[]> hasher){
		if(headerIsWhichOfFourLongs != 0) throw new RuntimeException("TODO");
		left = idKey(left); //same object if it already is an idKey
		right = idKey(left);
		byte[] contentToHash = MathUtil.longsToBytes(
			left.a, left.b, left.c, left.d, right.a, right.b, right.c, right.d);
		byte[] hash = hasher.apply(contentToHash);
		return new Word(
			HeaderBits.headerKeyOf2Headers(left.a, right.a),
			MathUtil.readLongFromByteArray(hash, 8),
			MathUtil.readLongFromByteArray(hash, 16),
			MathUtil.readLongFromByteArray(hash, 24)
		);
	}

}