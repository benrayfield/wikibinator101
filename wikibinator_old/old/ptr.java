package wikibinator.old;
import java.util.function.Supplier;

import wikibinator.fn;

/** you can still get hashCode, equals, etc, without downloading binary forest childs below recursively,
if you know its 256 bit id (will be something like 30 bytes of sha3_256 and 2 bytes of header, or maybe 28+4?).
*/
public interface ptr extends Supplier<fn>, Comparable<ptr>{
	
	"FIXME this should just implement fn, instead of implementing Supplier<fn>, and when you try to use it, it does Supplier.get() and calls its fns on that"

}
