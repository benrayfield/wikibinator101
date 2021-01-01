/** Ben F Rayfield offers this software opensource MIT license */
package wikibinator.impl;
import java.util.function.Supplier;

import wikibinator_old.Compiled;
import wikibinator_old.fn;

public class RemoteFn implements fn{
	
	/** TODO this should be 1 of the bytes in id instead of a constructor param */
	public final byte op;
	
	/** idType.e(this)->id, but you can know what idType.e(this) would return
	without calling that since calling that would downloader.get().
	<br><br>
	TODO optimize this, by putting a <func,param,return> cache entry of <idType,this,id>
	instead of storing idType and id here, so when idType.e(this) is called,
	it will find that in the cache and not call downloader.get(),
	but if you call things on this which are not cached then it will downloader.get().
	*/
	public final fn idType;
	
	/** compare by this */
	public final fn id;
	
	protected final Supplier<fn> downloader;
	
	/** FIXME byte op should be 1 of the bytes in id as a compiled().cbt()->Blob instead of a constructor param */
	public RemoteFn(byte op, fn idType, fn id, Supplier<fn> downloader){
		this.op = op; //FIXME this should be 1 of the bytes in id instead of a constructor param
		this.idType = idType;
		this.id = id;
		this.downloader = downloader;
	}

	public fn e(fn param){
		return downloader.get().e(param);
	}

	public fn e(){
		return downloader.get().e();
	}

	public fn f(fn param){
		return downloader.get().f(param);
	}

	public fn L(){
		return downloader.get().L();
	}

	public fn R(){
		return downloader.get().R();
	}

	public byte op(){
		return op;
	}

	public Compiled compiled(){
		return downloader.get().compiled(); 
	}

	public void setCompiled(Compiled compiled){
		downloader.get().setCompiled(compiled);
	}

}
