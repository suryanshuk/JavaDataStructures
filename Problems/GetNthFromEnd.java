package Problems;
import LinklisthelperAPI.*;
import java.util.NoSuchElementException;

// returns nth node from end
public class GetNthFromEnd<T>

{

	// method returns nth node from end in the list
	/**
	 * @param iterator1
	 *            this will traverse to the last element from nth position in
	 *            the start
	 * @param iterator2
	 *            iterator2 will traverse one by one from the beginning
	 * @param position
	 *            is the nth position entered by user
	 * @param list
	 *            list is linkedlist of which nth node has to be found
	 * @return value of nth node by method
	 * @throws NoSuchElementException
	 *             if entered position doesn't exist
	 */
	public T GetDnode(IteratorCustomized<T> iterator1,
			IteratorCustomized<T> iterator2, int position,
			LinkedListHelper<T> list) throws NoSuchElementException {

		if (position > list.getSize())

		{
			throw new NoSuchElementException("there is no such element");
		}

		// referring the nth node from the beginning
		iterator1.iterateOver(position - 1);

		// traversing untill iterator goes to last element
		while (iterator1.hasNext()) {
			iterator1.next();
			iterator2.next();

		}

		// returns the value of nth node
		return iterator2.getValue();

	}

}
