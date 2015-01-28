package LinklisthelperAPIs;
import java.util.NoSuchElementException;
import LinklisthelperAPIs.*;


/**
 * @author Suryanshu kumar
 *
 * @param <T> T is a generic variable
 */
public class StackByList<T> extends LinkedListHelper<T> {
	
	
	LinkedListHelper<T> list;
	IteratorCustomized<T> iterator;
	
	//constructor method initializing a new list
	public StackByList()
	{
		list = new LinkedListHelper<T>();
		
	}
	
	
	/**push the element into the stack
	 * @param data is the value that has to added
	 */
	public void push(T data)
	{
		list.addAtEnd(data);
	}
	
	
	
	/**deletes the topmost element of the stack
	 * @return deleted element of the stack
	 * @throws NoSuchElementException in case if there is no element to remove
	 */
	public T pop()throws NoSuchElementException
	{
		if(list.IsEmpty())
		{
			throw new NoSuchElementException();
		}
		
		else
		{
		iterator  = list.iterator();
		while(iterator.hasNext())
			iterator.next();
		T ob = (T)iterator.getValue();
		
		list.delLast();
		return ob;
		}
		
	}
	
	
	/**retrieve top element of the stack
	 * @return top element of the stack
	 * @throws NoSuchElementException in case if there is no element to remove
	 */
	public T getTop()throws NoSuchElementException
	{
		if(list.IsEmpty())
		{
			throw new NoSuchElementException();
		}
		
		
		else{
		iterator  = list.iterator();
		while(iterator.hasNext())
			iterator.next();
		T ob = (T)iterator.getValue();
		return ob;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see LinkedListHelper#getSize() returns size of the list
	 */
	public int getSize()
	{
		return list.getSize();
	}
	
	
	/* (non-Javadoc)
	 * @see LinkedListHelper#display() display all the elements in the list
	 */
	public void display()
	{
		list.display();
	}

}
