# wikibinator
A decentralized wiki style interactive math book (for ages 0 to expert, which TODO will appear like cartoony art with drag and drop or hardcore number crunching tools that hook into cloud computing tools etc depending on the user's skill), based on a combinator (that is both a universal lambda function and a pattern calculus function of 6 parameters which has vararg lambdas) in which it is extremely easier to say true things than to say false things, based on a logic similar to godel-number where one must commit to statements about lambda called on lambda returns lambda before one can verify which lambdas they are, and in theory scaleable enough for graphics, musical instruments, GPU number crunching, etc, but lets start simple, so everyone can understand and fit the pieces of the puzzle together.

```
//My theory-of-everything:
//Universe is a specific irrational fraction = the 4d cantor diagonal of <wikiState,func,param,return> -> true or false,
//and to avoid ambiguity of those words I mean 4d cantor diagonal as a nondecreasing order of manhattan-distance from
//<λ,λ,λ,λ> which is the first digit, and any way of breaking ties will work such as bigEndian of 4 integers or littleEndian of 4,
//where numberOfUniqueBinaryForestsAtHeight aka uniqbin(0)=1 and uniqbin(x)=uniqbin(x-1)^2+1
//(todo found that by brute forcing a few levels deep, copy that code here)
//with no unknowns, but we only use trinary (true, false, or unknown) values of 3d tensor (instead of 4d) as optimization,
//and in practice will appear and be used any way people like even if you're bad at math.  
//
//As the name suggests, wikibinator will start as a math wiki similar to wikipedia, to explain how itself works,
//and to derive all known kinds of math in the form of lambda functions, such as pi could be represented
//as a function that takes an integer of which digit number you want and in finite time returns that digit,
//and pi squared could be represented as another such function which calls pi, but thats not a very efficient way.
//
//Similar to the spend and wallet and solve calls in (some forks of occamsfuncer, TODO), those calls will be somewhere in the wiki
//that can be called on otherwise deterministic lambdas to limit their amounts of compute resources (time, memory, etc) recursively,
//so in practice all lambda calls will halt within .02 seconds in time to display the next video frame of a game or sound etc.
//
//I'm exploring possible syntaxes, for the well defined wikibinator universal function.
//λ means that universal function aka wikibinator. All possible deterministic functions are made of combos of λ.
//A certain combo of λ (TODO choose order of params so can write it here) means the wiki, which is a function,
//but we only learn which function it is by how people and computers use it,
//which there is math ((L x (R x)) equals x forall x and the logic in SimpleVM.interpretedMode) to verify
//the wiki function is consistent based on many <func,param,return> cache entries.
//Every function is an infinite set of <func,param,return> cache entries,
//exactly 1 return value for each possible func called on possible param,
//and as a semantic if it does not halt then we say it halts on (S I I (S I I)) which is an infinite loop,
//but of course halting oracles are impossible (since they answer in finite time), but still it is a fact of math
//that any specific lambda call either halts or does not halt.
//It just takes an infinite number of compute cycles and memory to know,
//so that semantic is mostly there as a math abstraction, but also may be used in disproof-by-contradiction sometimes,
//in proofs using the ((L x (R x)) equals x forall x and the logic in SimpleVM.interpretedMode) constraint.
//
//Syntax:
//λ is wikibinator.
//(x y) means call x on y, and its value is whatever that call returns.If a call has less than 6 params
//it is halted so returns itself, like (λ λ) is  waiting on 5 more params, and ((λ (λ λ)) λ) aka (λ (λ λ) λ) is waiting on 4 more params.
//(w x y z) means (((w x) y) z), which is called a curryList, similar to a linkedList but in reverse order and doesnt have nil.
//[a b c] is a linkedlist that means (pair a (pair b (pair c λ))). λ is used as nil in linkedLists.
//{a b} means (pair a b).
//<func param ret> means (func param) returns ret. It always has 3 things.
//TODO: "hello" means the utf8 bitstring of 5*8 bits, stored in a complete binary tree (cbt) of pairs of pairs... of T or F,
//padded with T then F F F... until the next powOf2 size. Or TODO I might use typeval to mark it as being a string, some few constants
//representing a few common types but there is no type system other than <type x λ> vs <type x anythingExceptλ>,
//so for example if <type x (S I I (S I I))> then x is not that type cuz the call (type x) will not halt
//(even though we may be unable to know that in finite time, so be careful to design types so they always halt).
//There are no variables cuz everything is a constant, but in this file I might define some variables outside of wikibinator
//whose value can be changed to a different constant, but those constants cant refer to those variables, only to constants.
//Even the wiki function is a constant and just accumultes <func param return> facts in an infinite sparse dimensional space
//of all possibilities.
//
//I'm thinking about representing the names (like infloop in <(S I I),(S I I),infloop>) as the return value of (wiki ["infloop" "myNamespaceXYZ"]),
//so that would be the statement <(S I I) (S I I) (wiki ["infloop" "myNamespaceXYZ"])>,
//but there might be a problem writing it that way since (wiki ["infloop" "myNamespaceXYZ"]) returns (S I I (S I I)),
//and maybe what I meant to say is <wiki ["infloop" "myNamespaceXYZ"] (S I I (S I I))>?
//Or maybe I'll just write it as: infloop = (S I I (S I I));
//FIXME.
//
//If a var name is written more than once, then its just a semantic for appending a number to the var name
//so its a different var name each time, and lines of code above that use the lower numbers
//and lines after that use the higher numbers, so each "var name" has at most 1 constant value
//in any certain multiline string of lines of code, and those lines represent a sparse 3d tensor
//of 3 possible values at each cell: true, false, or unknown: that <func param return> is true false or unknown.
//Since wikibinator is meant for ever expanding virtual worlds, tools, games, number crunching, etc...
//those sparse tensors fitting together with other sparse tensors could be said
//to be similar to a variant of "the matrix" as a virtual world can fit in a 3d tensor and a matrix is a 2d tensor.
//All possible states of the wikibinator system are sparse 3d tensors of 3 possible values per cell - true false unknown.
//Also it might someday be able to run on a black-hole-computer or gray-goo, but CPUs and GPUs are the sooner goal.



wikibinator = λ;
u = λ; //easier to write u than λ
uu = (u u);
op0 = (u u u u);
op1 = (u u u uu);
op2 = (u u uu u);
op3 = (u u uu uu);
op4 = (u uu u u);
op5 = (u uu u uu);
op6 = (u uu uu u);
op7 = (u uu uu uu);

//public static final byte
//	opWiki = 0,
//	opS = 1,
//	opT = 2,
//	opFI = 3,
//	opPair = 4,
//	opSecondLastInList = 5,
//	opCurry = 6,
//	opReflect = 7;

w = (op0 u u); //The wiki. The only nondeterministic function, defined by agreement among many on an ever expanding set of <func param return>.
//wiki = (u u u u u u) cuz op0 = (u u u u).
//(wiki x) is (u u u u u u x), forall x.
//For example, (λ λ λ λ λ λ (λ λ λ λ λ λ)) aka (w w) is calling the wiki on itself. TODO what should that return?
s = op1;
t = (op2 u);
f = (op3 u);
p = op4;
b = (op5 u u);
c = op6;
reflect_todoChooseALetterForThis = op7;

wiki = w;
i = (f u); //identityFunc
pair = p;
getFuncBodyAkaSecondLastInLinkedList = b;
curry = C;
a = (reflect_todoChooseALetterForThis u u);
l = (reflect_todoChooseALetterForThis uu u);
r = (reflect_todoChooseALetterForThis uu uu);
isLeaf = a;
getFunc = l;
getParam = r;

<u u uu>;
<(s i i) wiki wiki>;
<(s i i) u u>;
<(l wiki) (r wiki) wiki>; //(l x (r x)) equals x forall x.
<(l u) (r u) u>; //(l x (r x)) equals x forall x.
<l u i>; //(l x (r x)) equals x forall x.
<r u u>; //(l x (r x)) equals x forall x.
<(l l) (r l) l>; //(l x (r x)) equals x forall x.
<(l r) (r r) r>; //(l x (r x)) equals x forall x.
<(l p) (r p) p>; //(l x (r x)) equals x forall x.

//TODO define equals function. will be similar to the lambda returned by OcfnUtil.equals() in occamsfuncer.
```

Unlike other advanced systems, its very important for wikibinator to be able to explain its every detail of its own operation.

The main thing wikibinator does is to help many people and computers agree among eachother what the "Import" combinator/function does, which is entirely undefined other than the <function,parameter,return> style messages they say to eachother, which can be verified or disproven statistically based on the quinelike behavior of any function x that (L x (R x)) equals x, for all possible x, which means that recursively anything can be turing-complete-challenge-responsed. To extremely reduce the spread of unverified rumors, <func,param,return> cache entries, which are 3 of 256 bit merkle ids (in binary forest of merkle ids, of any chosen hash function such as SHA3_256 with some pre and post processing)... The <func,param> is, in terms of database theory, a primary-key, and the "return" is its only value that it can ever have. Its constant, not changing over time or context. The same function and parameter always gives the same return value, but depending on [what the "Import" combinator/function does, which is entirely undefined other than the <function,parameter,return> style messages they say to eachother], <function,parameter> --> return, will vary but hopefully converge to some consistent view of it all in the whole wiki, which is basically a way to verify and experiment with claimed behaviors of this single function which is defined only by peoples and computers shared beliefs about it, however those may fit together. For example, this function may be learned and converged similar to a neuralnet energy function, to when it receives certain patterns of input (other functions) that it does GPU matrix multiply, a certain musical instrument, SQL queries with extremely faster hyperdimensional mutex convergence at low lag, or anything people and computers together may find useful to define it as, as long as (L x (R x)) recursively in all possible combos of calling the wikibinator (a combinator) on itself in many combos (why its called a combinator, like SKI calculus and pattern calculus)... as long as this (L x (R x)) constraint is true in all possible sparsely observed combos, which is in theory harder to fake longterm than searching for a needle in a haystack of infinite size, because, and here's the very very slightly homomorphic piece of it which protects its security... <func,param> is secureHashed and its return value is not, so those who tend to spread rumors that <func,param> --> someReturn, will not necessarily know what func or param are, just will know the secureHash of concat(func,param) and can repeat to others that secureHash -> someReturn, and as in pattern calculus functions, func and return can be found, if others cooperate recursively, by asking others (L someReturn) which returns func, and asking others (R someReturn) which returns param, in the cases when number of curries (cur) remaining in func (before it would be evaled) is more than 1 (which decreases by 1 with each next curry), since (L x (R x)) equals x, forall x, so <(L x),(R x),x> is a func param return cache entry for every possible x, and the secureHash ids will know their number of curries so you can know if its part of the merkle forest vs some other func param return cache entry. This is the security primitives that the "decentralized wiki style interactive math book" aka wikibinator will be made of which makes it far easier to say true things than to say false things.

```
The 8 opcodes, chosen in the first 3 of 6 parameters...

S x y z //(x z (y z))
T y z //y
FI y z //z, ... I z is F u z
Reflect x y z //x and y define which of 3 things to do (L R IsLeaf) with z, and the cache byte per node does it in 1 step.
Pair x y z //(z x y)
LastInList z //calls LastInList recursively depending if (IsLeaf (R z)), returns (L z) or recurses into (R z).
Curry x y z //(Curry counter linkedList nextParam) --ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
Import z //this is where to hook in plugins, to modify the possible behaviors of (Import z).
	forceDeterminismMode makes Import always eval to infloop or not.
..
cacheByte with isForceDeterminism as high bit, and the low 7 bits are the cache.\
But more likely isForceDeterminism is not part of node itself but is part of NondetNode???

I'm undecided if it will be 6 vs 7 parameters since a comment parameter (in the middle of the 7 parameters
of the universal combinator) might make it much easier for people to understand, vs it might be easy enough
deriveable in the VARARG LAMBDAS of the Curry opcode.
```

--- below is disorganized text which lead to this... ---

The below text is easier to understand if you view it in github "raw" or a plain text viewer, instead of as html which turns newlines into spaces...


TODO examples of java code of how to use N as treemap to get functions,
or javalike code... I want a slightly modified syntax so
I dont have to keep typing the function names in the N interface
and can instead call things more like lambdas but keeping in mind
that it uses map key val key val key val like in lazycl instead of lambda currying directly?
No, I do want it to work by currying, and a treemap will take key as param and return value,
and mput func will curry 3 params (mput aMap key val)->aForkEditedMap.
But I still want the ability for lazycl(key val key val) syntax and java loop syntax,
or something like that.
(lazycl aMap)->aLazyBlob?
Include a ns param (like the context param in occamsfuncer) in the currying?
It would have to be given recursively in every deeper call, like (ns mput ns aMap key val),
but I dont want to write that every time.
I could just use occamsfuncer directly, which has opcodes for lambdas of 1-7 params
and can derive lambdas with deeper curries than that.
But I dont want the FPR cache to be outside the forest of N's, like it is in occamsfuncerVM.
I want something simpler that doesnt have a VM and is not sandboxed,
to get started with and build a sandbox inside parts of it later.

namespace, not built in, is just any param you want to use as a namespace (if any) in forest.
treemap
lazycl
	opencl1.2:...
	java8WithJava4Syntax:...
lazyDedup and FPR without VM, do it in the java8WithJava4Syntax code strings.


{
	
}


lazycl(
	"Code",
	"java8WithJava4Syntax: ...TODO..."
)

TODO write an example code of how I want to use the namespace.
This is java or javalike code, that gets an N used as a namespace,
and can forkEdit that namespace to send it into deeper calls if it wants to,
or can return a forkEdit of the namespace, or can return any N it wants.
This javalike code will be part of an N or is that N itself or something like that,
and I just need a syntax that feels good to use...

N ns = TODO get namespace;
N car = TODO how to get the lispCar func?
N otherThing = TODO;
N x = car(otherThing);
N y = (car otherThing);
N z = car(ns,otherThing);
or what syntax do I want?



N ns = TODO;
//N car = ns("car");
N car = ns.car; //x.y does same as x("y")
No, I dont want to use "." to mean that cuz it means something else in java etc.
N car = car@ns
N abc = c@b@a
No I dont like that syntax.
N car = ns_car
N car = ns?car
N car = ns`car
N car = ns..car


//x.y means x("y") means ((N)x).e("y").
//x..y means what x.y means in java.
N car = ns.car
int hash = ns..hashCode()
N idOfNs = ns..id()

Or how about the syntax only works for keys that start with a capital letter,
so xY means x.Y,
or nsAbcCar means ns.abc.car???


ns.anArray[5](ns.someList)

a = ns.anArray;
five = 5;
sl = ns.someList;
N bcd = a(five)(sl);
N bcd = (a five sl);
N bcd = (a 5 sl);
N bcd = (ns.anArray 5 sl);
N bcd = (ns.anArray 5 ns.someList);
//FIXME do I want to take the symbol "+" out of the syntax and it be a valid var name?
//Would leave a few basic things like = ( ) N in the syntax maybe?
N bcd = (ns.anArray (ns.+ 2 3) ns.someList);
+ = ns.+;
+ = ns("+");
ns = (ns.put ns "someVarName" bcd);
return (ns.pair ns 42);


Do I want pythonlike range(...) objects for loops?
for x in range(2, 30, 3):
	print(x)
for x in range(2, 6):
	print(x)

Dont have any types except N and primitives and primitive arrays... ???
bcd = a(five)(sl);
bcd = (a five sl);
bcd = (a 5 sl);
bcd = (ns.anArray 5 sl);
bcd = (ns.anArray 5 ns.someList);

Should var name have a prefix that tells its type?
Like, if it starts with i then its an int, and if its I then its a 1d int array?
ix = 5;
Ix = new int[345];
Ix[33] = -3;
IIsdf = new int[121][];
aaix = new int[121][]; //Each a means array of it.
anx = new N[2315]; //a of n, named x. No, theres no clear border between the types and the var name x.
jx = 5L;
dx = 5.67;
fx = 5.67f;
nx = (a 5 sl); //type N
x = (a 5 sl); //type N
X = (a 5 sl); //type N
???


Or just let the var names be anything?

Some later java version has "var" which figures out the type at compile time (so is same speed at runtime)
but javassist only has syntax up to java4 (even though it can compile for later java versions).

Or... I could probably with a few hours or days of programming figure out those types so wouldnt
have to write the types. but for now at least, just write the types?

N someFunc = {
	N[] arrayToPermutate = TODO;
	for(int i=0; i<arrayToPermutate..length; i++){
		for(int j=1; j<=i; j++){
			int randIndex = TODO choose rand index 0..j;
			N temp = arrayToPermutate[randIndex];
			arrayToPermutate[randIndex] = arrayToPermutate[j];
			arrayToPermutate[j] = temp;
		}
	}
	//FIXME copy needs to be part of the syntax, similar to = ( ).
	N frozenArray = (copy arrayToPermutate); //arrayToPermutate is still mutable
	N ertjwse = (frozenArray 3 4); //same as ((frozenArray 3) 4).
};

//TODO i want a syntax to inline opencl ndrange kernels, but lazycl compatible which takes map as param,
//so where do the params go such as bSize cSize dSize bc cd bize?
N gpuMatmul = {
	TODO
};
N aMultipliedResult = (gpuMatmul ...WHAT PARAMS GO HERE AND WHAT SYNTAX FOR LAZYCL-MAP-LIKE...);

Must be able to pass in literal N objects (that may be LazyBlobs or other N's) into gpuMatmul,
and still be able to run it as LazyBlobs if its a forest containing multiple of those that can be optimized together.

Must be able to generate the {...} func as a string and eval it to an N,
so...
N aFuncEvaledFromCodeString = eval("{...stuff...}");
Must be able to inline N's into the eval, so...
N aFuncEvaledFromCodeString = eval("{...stuff...}", ns);
Remember, N ns is just another N, and every N is immutable, even though its not sandboxed
so is possible to contain code that acts on the world statefully even though I plan to not do that
and to build a sandbox inside it, using it as a forest of N's, while I'm using the system itself,
to build a sandbox within that.
Basically I want a dangerous forest layer and inside that to build a safe forest layer.



N blah = {
	N ns = TODO;
	ns.anArray[5](ns.someList)
	a = ns.anArray;
	five = 5;
	sl = ns.someList;
	N bcd = a(five)(sl);
	N bcd = (a five sl);
	N bcd = (a 5 sl);
	
	N[] arrayToPermutate = TODO;
	for(int i=0; i<arrayToPermutate..length; i++){
		for(int j=1; j<=i; j++){
			int randIndex = TODO choose rand index 0..j;
			N temp = arrayToPermutate[randIndex];
			arrayToPermutate[randIndex] = arrayToPermutate[j];
			arrayToPermutate[j] = temp;
		}
	}
	
	//FIXME copy needs to be part of the syntax, similar to = ( ).
	N frozenArray = (copy arrayToPermutate); //arrayToPermutate is still mutable
	N ertjwse = (frozenArray 3 4); //same as ((frozenArray 3) 4).
	
	N bcd = (ns.anArray 5 sl);
	N bcd = (ns.anArray 5 ns.someList);
	N aFuncEvaledFromCodeString = eval("{...stuff...}", ns);
	N gpuMatmul = {
		TODO
	};
	N aMultipliedResult = (gpuMatmul ...WHAT PARAMS GO HERE AND WHAT SYNTAX FOR LAZYCL-MAP-LIKE...);
	N pair = ns.pair;
	N pair = ns("pair");
	N put = ns.put;
	return (pair aMultipliedResult (put (put ns "aFuncEvaledFromCodeString" aFuncEvaledFromCodeString) "hello" "world"));  
};


Getting close to what I want the syntax to look like, and remember these are all forest nodes
that can be stored on harddrive as merkle forest as soon as they return (a N, which can be a call pair or lazyblob etc).

Maybe there should be a Fire object, similar to java's Unsafe object,
that can do things like call lazycl (nonsandboxed), call the network, etc,
but things that only risk infiniteloop etc arent "playing with fire" since they're still sandboxed
and just risk having to restart the program.

N ffiirree = Fire; TODO
N whatLazyclReturned = (ffiirree.lazycl aMap);
N downloaded = (ffiirree.download "https://upload.wikimedia.org/wikipedia/commons/a/a3/Ice_water_vapor.jpg");
N downloaded = (ffiirree "download" "https://upload.wikimedia.org/wikipedia/commons/a/a3/Ice_water_vapor.jpg");
N downloader = ffiirree.download;
N downloaded = (downloader "https://upload.wikimedia.org/wikipedia/commons/a/a3/Ice_water_vapor.jpg");

Every N has a cur (number of curries left before eval). Example: (ns.cur aMap) returns 1 cuz (aMap someKey) -> value.

TODO how is the cur of an N defined?
N..cur() is where its stored, but what syntax defines the cur of a {...}?
(cur {..... stuff }) -> 5, cuz the syntax has "....." which is 5 curries.

(cur ({..... stuff } "hello" "world" aMap)) -> 2 cuz it has 3 of its curries.

TODO how will dedup happen without a VM? For example,
is ({..... stuff } "hello" "world" aMap) and ({..... stuff } "hello" "world" aMap) the same N object?

TODO how to FPR cache from a treemap derived and used inside the N's if currying is going to be occamsfuncer-like?



N concatThreeThings = {....
	N self = TODO;
	N ns = TODO get from self's currys;
	N x = TODO get from self's currys;
	N y = TODO get from self's currys;
	N z = TODO get from self's currys;
	N concat2 = ns.concat;
	return (cat2 (cat2 x y) z);
};

N ns = TODO;
N theDogJumps = (concatThreeThings ns "the " "dog " "jumps");


Should I just use occamsfuncer with the {...} function maker differing in its first param
(like occamsfuncer opcodes start with (u u), where u is the universal function,
so this might be (u "nonsandboxedtreeexperiment" ...stuff...).

Occamsfuncer can handle defining curries from 1-7 and where the ns param goes (and a comment param, default comment is u).




This would use occamsfuncer in a nonsandboxed way,
such as it could call (u "nonsandboxedtreeexperiment" ...stuff...) to do dangerous things
and could have infinite loops and generate java code that has infinite loops,
so be careful, but I do need this to get started with doing everythning in a forest
instead of continuing to define things within java namespace. There are no namespaces other than
what exists between a {...} and that cant access names outside it or inside its inner {...}s etc.
Everything is passed as param, including N ns param, by currying,
and theres no sandboxing, no dedup, no FPR caching... except whats derived in the forest itself,
but might have to adjust that strategy of dedup and FPR etc...




Or maybe I just want pairs and lazyblobs and for javalike code (with curry syntax and procedural syntax mixable),
and if you want to use some combo of pairs as a treemap you build a javalike code (store it in an N)
to use it that way.
But how to get that derived func to use a forest of pairsAndLazyblobs as a treemap,
without having such a func already to get itself out of a namespace? Dont want to have to derive it again
at the start of every java code just to get the params etc curried into that java code.

A universal function is a good way to boot that.

Occamsfuncer is such a universal function, but I do have a few variants of it that take less params...
a universal function (thats both a universal lambda function (combinator) and pattern calculus function) is...
..
always curries 7 params, where first param is namespace,
and last 6 params are: opDigitA opDigitB opDigitC paramD paramE paramF,
where the first 3 choose which of 8 opcodes,
and those opcodes are: S T FI L R IsLeaf Pair Curry,
where Curry = Lx.Ly.x(pair x y),
or could do it in 6 params if combined L and R into getPairOfLROf, and put the namespace param as 1 of the opcodes,
but then it would only get 3 params.

Params: rootNamespace opDigitA opDigitB opDigitC paramD paramE paramF.
Ops: S T FI L R IsLeaf Pair Curry.


TODO derive Lx.Ly.x(pair x y), from the other 7 ops... It can certainly be done like how currying is derived in unlambda,
but its confusing and inefficient compared to if its an op.

iota = (pair S T). Can represent all possible combos of currying iotas called on combos of iota, with those 7 opcodes,
not needing the Curry opcode. Derive everything using iota?
For example, derive the Curry "op" but not as an op, using iota?

I'm thinking maybe I want 7 instead of 8 opcodes, so I have space for 1 more, that being
where I'd hook in near anything else such as nonsandboxedtreeexperiment and lazyblob optimizations
(the dirty way, instead of formal verifying them before I start using them, can do that later
after I play with and get used to the system)...

Ops: S T FI L R IsLeaf Pair Import.
Example:
(Import "nonsandboxedtreeexperiment" <somePossibleState> nextParam)
-> (Import "nonsandboxedtreeexperiment" <anotherPossibleState>), which waits on 1 more param.


Ops: S T FI pairOfLROf IsLeaf Pair Curry Import ???

Think of Curry as its state containing 2 linkedlists, one that just counts down,
and the other to append the next param to until the countdown ends then eval.

TODO where does typeval and comment go?

Or do I want to derive the Curry opcode using S and T and Pair etc?
Or do I want to derive a 4 or 5 param form where the funcBody to call on it,
and the 2 linkedlists, each get their own param index?



Ops: S T FI L R IsLeaf Pair Curry??? but i want import op.

or curry of 3 params?...
(Curry x y z) -> x (pair (Curry x y) z)
???
No, curry should be just 2 params: Lx.Ly.x(pair x y).


iota = (pair S T).
Ops: S T FI L R IsLeaf Pair Import ???
No... cuz without the Curry op, the L and R are confusing of how to get stuff out of curries.


Ops: S T FI getPairOfLAndR IsLeaf Pair Curry Import.
Example: (getPairOfLAndR u T xyz) -> left child of xyz.
Example: (getPairOfLAndR u F xyz) -> right child of xyz.
Example: (getPairOfLAndR u) -> (pair <abstractlyThinkOfThisAsL> <abstractlyThinkOfThisAsR>)...
But basically (getPairOfLAndR u T) is L, and (getPairOfLAndR u F) is R.
???


Ops: S T FI pairOfLROf IsLeaf Pair Curry Import.



(Curry counter linkedList nextParam)
-> (Curry (R counter) (pair nextParam linkedList)) IF counter is not u, ELSE
-> funcThatReturns... (deepestThingInTheLinkedlist (pair nextParam linkedList)) where deepestThingInTheLinkedlist is funcBody,
and funcThatReturns has to be called instead of instantly jumping to deepestThingInTheLinkedlist
cuz ops have to be constant cost of computeCycles and memory,
and funcThatReturns calculation is to simply check if its R is u (nil) and if it is then return L of it
else return recursion of that into R of that. Can often be optimized to just cache the deepest thing in the linkedlist.


Ops: S T FI getPairOfLAndR IsLeaf Pair Curry Import,
where Curry does that (Curry counter linkedList nextParam) thing and funcBody is deepest thing in the linkedList,
and an example of counter is (T (T (T (T (T u))))) which is unary counting (similar to lin numbers which have T and F).

So (Curry counter linkedList) is a vararg function.

 


Ops: S T FI getPairOfLAndR IsLeaf Pair Curry Import.

Replace getPairOfLAndR with branching it on param 4 of 6 being u vs anything except u?
(getPairOfLAndR u u x) -> left child of x,
(getPairOfLAndR (u u) u x) -> right child of x
???
Could use <u u> and <(u u) u> and <u (u u)> as isLeaf L and R, so have 1 opcode left to do something else with,
and I have been wanting a typeval opcode as a semantic for things like "image/jpeg" and <bytesOfJpg>,
and other than that it acts like pair.


Ops: S T FI Reflect Pair Typeval Curry Import,
where (Reflect u u x) -> T or F depending if x is the leaf,
and (Reflect (u u) u x) -> left child of x,
and (Reflect u (u u) x) -> right child of x,
or something like that. Make param 4 choose isleaf vs LR,
	and if not(param 4 is leaf) isleaf then param 5 chooses L vs R of param 6.
???


Or instead of typeval (which could use some variant (in param 3 of 6) of pair...
Maybe should have getDeepestThingInLinkedlist (aka LastInList) as an op, which Curry would call,
and which calls itself recursively if R of a param is not u.


Ops: S T FI Reflect Pair LastInList Curry Import.
???


Do I want a comment param and for u to always curry 7 params (a b c comment x y z)???
Would need to redesign Curry...
(Curry comment counter linkedList nextParam) -> (LastInList linkedList (pair (Curry comment counter linkedList) nextParam)),
or if its not enough curries to eval yet: (Curry comment (R counter) (pair linkedList nextParam)),
or something like that (dont forget to put nextParam into the linkedlist)...
???
seems complex.
(LastInList linkedList linkedList) is the simpler eval part (after curries enough params),
aka (LastInList linkedList) -> funcBody, and it evals to (funcBody linkedList_whereFuncBodyIsDeepestThingInIt).

I'm undecided if want comment to exist at this level. Can it go in just 6 params, or does it require expanding to 7
and does it make Curry more complex?

Also its important for linkedList to have funcBody as its deepest part cuz
it allows occamsfuncer-like Compiled.java-like optimization to be curried with the linkedlist as
it continues being appended to, as Compiled is recursively connected to currying.


Universalfunc always takes 6 curried params (not referring to Curry opcode, a lower level of currying)...
Ops: S T FI Reflect Pair LastInList Curry Import.
???

As an optimization, put a byte (used as uint7) in each node, which is a cache of cur and the bit of is each param
curried so far (max 6 of them, and if its 6 then its evaling now)... is that param leaf or anything other than leaf,
with a 1 bit just above that as a positive integer of b bits has a 1 as its highest bit and is a bitstring of b-1 bits.
1 //u
10 11 (u u) vs (u anythingExceptU)
101 110 101 110
1011 1100 1011 1100 1011 1100 1011 1100 (cache after 3 curries, with 3 more curries til eval).
...
1000000..1111111 eval here.
Thats 127 possible byte values in range 1..127. A useful cache.
Use in a switch statement. That means L R and IsLeaf (which depend on 5 params) each have their own byte val
so dont need to look deeper, very fast.

Maybe that other bit in the cache byte tells if its forceDeterministic vs allowNondeterminism??? which related ops
would be in Import???



Ops: S T FI Reflect Pair LastInList Curry Import.
Has Compiled-recursively-optimizable vararg lambdas.
Has no place to put comment param, but maybe put that somewhere in varargs such as
always the first (second deepest, just after the deepest param which is funcBody???) param???


Should Import take just 1 param (ignores params 4 and 5, only uses param 6),
and simply have Curry call Import as needed? I want to, but can it be efficient?
Example: (Import (pair "lazycl" aMap)) -> bitstring that lazycl returns, or param of Import could be a linkedlist etc.
Stateless import. Import is a function of 1 param that together contains all possible plugins or whichever are loaded.

S x y z //(x z (y z))
T y z //y
FI y z //z, ... I z is F u z
Reflect x y z //x and y define which of 3 things to do (L R IsLeaf) with z, and the cache byte per node does it in 1 step.
Pair x y z //(z x y)
LastInList z //calls LastInList recursively depending if (IsLeaf (R z)), returns (L z) or recurses into (R z).
Curry x y z //(Curry counter linkedList nextParam) --ifItsEnoughCurriesToEval--> (LastInList next_linkedList next_linkedList).
Import z //this is where to hook in plugins, to modify the possible behaviors of (Import z).
	forceDeterminismMode makes Import always eval to infloop or not.
..
cacheByte with isForceDeterminism as high bit, and the low 7 bits are the cache.\
But more likely isForceDeterminism is not part of node itself but is part of NondetNode???



TODO where to put comment?



TODO? Put a Blob field in every node, as a cache of cbt, to hook into lazycl etc, especially that LazyBlob is-a Blob.


TODO rename "Import" to "CallccUniverse" or "Observer" or something like that?












































































