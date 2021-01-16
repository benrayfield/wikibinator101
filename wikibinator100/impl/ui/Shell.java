package wikibinator100.impl.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.UnaryOperator;

import immutable.util.ListUtil;
import wikibinator100.λ;

/** https://en.wikipedia.org/wiki/Shell_(computing) of wikibinator.
Give it 1 command at a time, such as "xyz = (ab cd (ab yy));" or "wikibinator = λ;" or "uu = (λ λ)";
You start only with 1 constant, called "λ" aka wikibinator, which you can derive the whole universe from.
In java, λ is the type of any function. Every function contains the wikibinator root function.
*/
public class Shell implements UnaryOperator<String>{
	
	/** namespace.
	using time_exists_optimization instead of timeless_sparse_tensor_4d_optimization.
	In timeless_sparse_tensor_4d_optimization, each name refers to a dimension and can be renamed
	without changing the sparse tensor4Ds or how they fit together to make bigger sparse tensor4Ds.
	*/
	protected final Map<String,λ> ns;
	
	/** the root function, which you can call on itself in various combos to derive the whole universe */
	public final λ wikibinator;
	
	/** it takes wikibinator as a param cuz there can be various implementations of it, each optimized differently */
	public Shell(λ wikibinator){
		this.wikibinator = wikibinator;
		ns = new HashMap();
		ns.put("λ", wikibinator);
	}
	
	public String toShortString(λ x){
		throw new RuntimeException("TODO");
	}
	
	/** Example: "(a b (c d e) f)" -> "Example: "(((a b)((c d) e))f)" */
	public String convertToDeepParens(String expr){
		/*List<String> tokens = (List) iterToList(new StringTokenizer(expr,delims,true).asIterator());
		List<String> 
		for(String token : ListUtil.reverse(tokens)){
			
		}*/
		throw new RuntimeException("TODO");
	}
	
	/** TODO "//" is a delim? yes and comment (or output as comment) ends at \n (\r or \r\n becomes \n),
	and what about things inside stringLiterals, TODO get some parsing code from humanAiNetNeural Text.java.
	*/
	public static final String delims = "()[]{}<>;= \\t\r\n\"";
	
	/** Example: "x" -> "x".
	Example: "(x y)" -> "` x y".
	Example: "(x y z)" -> "` ` x y z".
	Example: "(x (y z))" -> "` x ` y z".
	Example: "(a b (c d e) f)" ->  "` ` ` a b ` ` c d e f".
	UPDATE: returns ParseTree instead of String. If you want that String, call ParseTree.toUnlambdaLikeCallPairs
	*
	public ParseTree convertToUnlambdalikeCallPairs(String expr){
		List<String> tokens = (List) iterToList(new StringTokenizer(expr,delims,true).asIterator());
		int height = 0;
		Stack<ParseTree> stack = new Stack();
		stack.push(null);
		for(String token : ListUtil.reverse(tokens)){
			if(token.equals(")")){
				stack.push(new ParseTree(null,stack.peek()));
			}else if(token.equals("(")){
				//stack.push(new ParseTree(null,stack.peek()));
			}else if(token.equals("]")){
				throw new RuntimeException("TODO");
			}else if(token.equals("[")){
				throw new RuntimeException("TODO");
			}else if(token.equals("}")){
				throw new RuntimeException("TODO");
			}else if(token.equals("{")){
				throw new RuntimeException("TODO");
			}else if(token.equals(">")){
				throw new RuntimeException("TODO");
			}else if(token.equals("<")){
				throw new RuntimeException("TODO");
			}else if(token.equals("=")){
				throw new RuntimeException("TODO");
			}else{ //name
				stack.peek().name = token;
			}
		}
	}*/
	
	static <T> List<T> iterToList(Iterator<T> iter){
		List<T> list = new ArrayList();
		while(iter.hasNext()) list.add(iter.next());
		return Collections.unmodifiableList(list);
	}

	public String apply(String in){
		if(in.contains("\"")) throw new RuntimeException("TODO string literals are cbt of utf8 or maybe a typeval containing that");
		int eqIndex = in.indexOf("=");
		if(eqIndex != -1){
			String lval = in.substring(0,eqIndex).trim();
			String rval = in.substring(eqIndex+1).trim();
			return "LVAL: "+lval+". RVAL: "+rval;
		}else{
			throw new RuntimeException("TODO");
		}
	}

}