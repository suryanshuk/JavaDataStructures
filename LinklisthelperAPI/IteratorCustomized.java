package LinklisthelperAPI;
import java.util.Iterator;



	public interface IteratorCustomized<E> extends Iterator<E> {
	    
	    void iterateOver(int p); 
	    E getValue();
	}