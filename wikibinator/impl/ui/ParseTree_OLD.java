package wikibinator.impl.ui;

/** either name is null or [func is null and param is null] */
public class ParseTree_OLD{
	
	/** fill its fields in later */
	public ParseTree_OLD(){}
	
	public ParseTree_OLD(String name){
		this.name = name;
	}
	
	public ParseTree_OLD(ParseTree_OLD func, ParseTree_OLD param){
		this.func = func;
		this.param = param;
	}
	
	public String name;
	
	public ParseTree_OLD func, param;
	
	public String toUnlambdaLikeCallPairs(){
		return name!=null ? name : ("` "+func.toUnlambdaLikeCallPairs()+" "+param.toUnlambdaLikeCallPairs());
	}

}