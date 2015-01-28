package LinklisthelperAPIs;
import java.util.Iterator;



	/**interface extending iterator interface
	 * @author suryanshu
	 *
	 * @param <E> is a generic varible
	 */
	public interface IteratorCustomized<E> extends Iterator<E> {
	    
	    void iterateOver(int p); 
	    E getValue();
	}