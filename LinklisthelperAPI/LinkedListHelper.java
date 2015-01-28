package LinklisthelperAPIs;


import java.util.NoSuchElementException;

/**
 * @author suryanshu
 *
 * @param <T> T is a generic variable
 */
public class LinkedListHelper<T> {

	private Node head;
	private Node end;
	private Node Ref;
	private int size;

	// this is class to create structure of node
	public class Node {

		private T data;
		private Node link;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getNext() {
			return link;
		}

		public void setLink(Node link) {
			this.link = link;
		}

		public Node(T data) {

			this.data = data;
		}

		public Node() {

			this.link = null;
		}

	}

//defining Linkedlisthelper constructor
	public LinkedListHelper() {

		head = null;
		Ref = head;
		end = null;
		size = 0;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	private void setSize() {
		this.size++;
	}

	//method to add node at the beginning of the list
	
	/**
	 * @param data value given by the user
	 */
	public void addAtStart(T data) {
		Node temp = new Node(data);
		size++;
		if (head == null) {
			setHead(temp);

			end = temp;

		} else {
			temp.setLink(head);
			setHead(temp);
		}
	}

	 
	/** Getting node at position given by the user
	 * @param pos position supplied by user
	 * @return node at the required position
	 */
	public Node getNodeAt(int pos)throws NoSuchElementException {
		if(IsEmpty() || pos> getSize())
		{
			throw new NoSuchElementException();
		}
		
		else
		{
		Node ref = getHead();
		int count = 1;

		while (count != pos) {
			ref = ref.getNext();
			count++;
		}

		return ref;
		}

	}

	
	/** display all the elements in the list
	 * 
	 */
	public void display() {
		Node ref = null;
		ref = getHead();

		while (ref != null) {
			System.out.print(ref.getData() + "->");
			ref = ref.getNext();
		}
		System.out.println("NULL");
	}

	public Boolean IsEmpty() {
		if (this.head == null) {
			return true;
		}

		return false;
	}

	
	/** add element at the end of the list
	 * @param data element which has to be added
	 */
	public void addAtEnd(T data) {
		if (IsEmpty()) {
			addAtStart(data);
		}

		else {
			Node temp = new Node(data);
			setSize();

			end.setLink(temp);
			end = temp;
		}
	}


	
	/** add element at the provided position
	 * @param pos location where element has to be added
	 * @param data that has to be added
	 */
	public void addNodeAt(int pos, T data) {
		if (pos == 1) {
			addAtStart(data);
		}

		else if (pos == size) {
			addAtEnd(data);
		}

		else {
			Node temp = new Node(data);
			setSize();
			Node ref = getNodeAt(pos - 1);
			temp.setLink(ref.getNext());
			ref.setLink(temp);
		}
	}

	// deletes the first element of the list

	public Node getEnd() {
		return end;
	}
	
	
	public void setEnd(Node data) {
		end= data;
	}

	public void delFirst() {
		if (IsEmpty())
			System.out.println("list is empty");
		else

			setHead(head.getNext());
		size--;

	}

	
	/** deletes the last element of the list
	 * 
	 */
	public void delLast() 
	{
		if (IsEmpty())
		{
			System.out.println("list is empty");}
		
		else if(getSize()==1)
		{
			delFirst();
		}
		
		else{
			
			Node ref = getNodeAt(size - 1);
			ref.setLink(null);
			end = ref;
			size--;
				
		}
	}



	/** deletes element at given Position
	 * @param pos location where element has to be added
	 * 
	 */
	public void delAtPos(int pos) {

		if (IsEmpty())
			System.out.println("list is empty");
		else {
			Node ref = getNodeAt(pos - 1);
			ref.setLink(ref.getNext().getNext());
			size--;
		}
	}

	
	
	// deletes all the items in the list
	public void delAll() {
		if (IsEmpty())
			System.out.println("list is empty");
		else {

			head = null;
			end = null;
			size=0;
		}
	}

	
	
	
	

	/** iterator class implementing customized iterator interface
	 * @author suryanshu
	 *
	 * @param <T> T is a generic variable
	 */
	private class LinkListHelperIterator<T> implements IteratorCustomized<T> {

		private Node Ref;

		public LinkListHelperIterator() {
			Ref = getHead();
		}

		@Override
		public boolean hasNext() {
			if (Ref.getNext()!= null)
				return true;
			else
				return false;
		}

		
		/* (non-Javadoc) 
		 * @see IteratorCustomized#iterateOver(int) iterator iterates over p no of elements
		 */
		public void iterateOver(int p)
		{
			for(int i=0;i<p;i++)
			{
				Ref= Ref.getNext();
			}
		}
		
		
		/* (non-Javadoc)
		 * @see IteratorCustomized#getValue() return value of element pointed by the iterataor
		 */
		public T getValue()
		{
		
			T object = (T)Ref.getData();
			return object;
		}
		@Override
		public T next() {
			T object = (T) Ref.getData();
			Ref = Ref.getNext();

			return object;
		}
		
	

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

		

	}

	
	
	
	/**
	 * @return object of customized iterator 
	 */
	public IteratorCustomized<T> iterator() {
		return new LinkListHelperIterator<T>();
	}
	
	
	
	
	
	 /** create a loop in the list starting from end to any of the given position
	 * @param pos  location where loop will begin
	 */
	public void addAloop(int pos)
	 {
		 Node ref = getNodeAt(pos);
		 end.setLink(ref);
		 
	 }
	 
	
	
	
}