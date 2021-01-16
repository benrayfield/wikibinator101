package wikibinator101.wikibinatornodes;

/** TODO will this be a node that you use to choose a specific Node type (such as Callquad, Cbt, or Rfpd)
to call on some node or curried list of nodes or something like that?
For example, if you want to check MultiReturnDetector on 2 Rfpds,
how do you say MultiReturnDetector in terms of the 3+1bit way axiomforest nodes?
You use a <leaf "wikibinatorV0" intOpcode> node somewhere in the v child
(maybe v.l is that and v.r is a linkedlist (made of axiomnode.l and axiomnode.r) of its params?).
Similarly someone might create <<leaf "theirwebsite.com" someKindOfId> somethingX somethingY>
which would be considered in the <leaf "theirwebsite.com" someKindOfId> namespace
(or <<leaf "yomama so fat" someKindOfId> somethingX somethingY>) nomatter what it is,
so if many people and computers cooperate to follow the axioms normally used per namespace and
across multiple namespaces, various sets of axioms that might evolve to fit together consistently,
then you should be able to put anything you want at a random or made up place,
in that simple pattern of axiomnode.v.l.l being namespace or axiomnode.v.l being a 2 level deep subnamespace,
or use axiomnode.v.l as a linkedlist-like namespace for multiple levels deep and axiomnode.v.r
is where the "vm state" goes, internal calculations within whatever that namespace does,
and always axiomnode.l and axiomnode.r can be anything when axiomnode.v is leaf,
but when axiomnode.v is not leaf then not all possible l and r are allowed.
For example, in the wiki it might evolve that a space for statements about yomamas in general
get automatically cross referenced with lambda based possible models of physics
that prove or disprove if the statements could be true,
and with various lambda based contexts such as a thing in a joking context
does not imply anything about the physical world so such axioms would not limit it
and exaggeration would be counted as true as long as its a joke, for example.
Lambdas inside axiomforest can be shaped into whatever you want.
Since neuralnets and other models of AI will be buildable inside the wiki,
the otherwise strict logic can start to have a sense of humor and other thought patterns.
<br><br>
maybe this is a byte short or int that goes somewhere in axiomforest node v child as a cbt32,
with 1 cbt32 value for each possible Node type in the wikibinator axiom,
within a Pair of "wikibinatorV0" and that int, somewhere in the v child,'
so that other systems (forks of wikibinator or non-wikibinator systems, anything you like)
can each choose some area of the 3-way forest of 1 TruthValue of bloomFilter,
that dont conflict with eachother but may overlap eachother in nonconflicting ways,
so that many systems can be in the same sparse forest based bloom filter
(where unknown blooms to yes or no,
and errors are detected if it blooms to bull, per 3 way forest node).
<br><br>
FIXME should this be its own subclass of Node instead of each of the subclasses
just being that pattern of trinary forest shape (implying by their Node.next() axiom
a node which has such an opcode/type in v child of what next returns?).
*/
public class Opcode extends AbstractNode{
	
	TODO every Node should define itself as Λ andOr λ asap,
	using the semantic (axiomforest doesnt care how you choose the TruthValues, just that they're consistent)
	that Λ.v.l.l (or is it Λ.v.l?) is an axiomnodeLinkedList (made of axiomnode.l and axiomnode.r)
	such as Λ.v.l.l is <leaf "wikibinatorV0" <leaf anIntOpcode leaf>>
	or such as Λ.v.l.l is <leaf "wikibinatorV0" <leaf "MultiReturnDetector" leaf>> (but that might be slow),
	and Λ.v.r is an axiomnodeLinkedList of the node params that for example go in java constructors
	such as the 3 nodes in: "MultiReturnDetector(Rfpd cacheKeyA, Rfpd cacheKeyB, No mutuallyAssuredDestructionTrigger)",
	and the 2 "join" params aka Λ.l and Λ.r can be reacted to differently depending on whats in Λ.v.
	
	public Op(boolean tv){
		super(tv); //FIXME more params
	}
	
	/*public static final Op T = new Op(true), F = new Op(false);
	
	/*public Op(boolean bit)
	
	/*public final boolean value;
	
	public Op(boolean bit){
		throw new RuntimeException("TODO it needs to be defined by forest shape, similar to how T and F are defined in wikibinator, except it will probably be deeper cuz this is a layer below that universalFunc");
	}*/

}
