package LinklisthelperAPIs;
import java.util.NoSuchElementException;


/**
 * @author suryanshu
 *
 * @param <T> T is a generic variable 
 */
public class Queue_by_list<T> extends LinkedListHelper<T> {

	LinkedListHelper<T> list;
	IteratorCustomized<T> iterator;
	private int limit;
	
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**constructor to create a new list
	 * 
	 */
	public Queue_by_list()
	{
		list = new LinkedListHelper<T>();
		
	}

	/** add an element in the queue
	 * @param data element that has to be added
	 */
	public void enqueue(T data)
	{
		list.addAtEnd(data); 
	}
	
	
	
	/** deletes the element in the queue
	 * @return deleted element 
	 * @throws NoSuchElementException in case if there is no more element to delete
	 */
	public T dequeue() throws NoSuchElementException
	{
		if(list.IsEmpty())
			throw new NoSuchElementException("there are no such element");
		
		else
		{
		iterator = list.iterator();
		T ob= iterator.getValue();
		list.delFirst();
		
		return ob;
	}}
	
	/** give the size of the queue
	 * @return return the size of the queue
	 */
	public int getsize()
	{
		return list.getSize();
	}
	
	
	
	/* (non-Javadoc) display the queue
	 * @see LinkedListHelper#display() display the list
	 */
	public void display()
	{
		list.display();
	}
	
	
}