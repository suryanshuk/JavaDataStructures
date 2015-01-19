package Problems;
import LinklisthelperAPI.*;

/**
 * @author suryanshu
 * 
 * @param <T>
 *            generic variable
 */

public class parenthesis<T> extends StackByList<T> {

	IteratorCustomized<Character> iterator;

	/**
	 * method for checking if given set of parantesis is balanced
	 * 
	 * @param str
	 *            contains set of paranthesis
	 * @return true or false
	 */
	public boolean isBalanced(String str) {
		StackByList<Character> stk = new StackByList<>();

		char[] chararray = str.toCharArray();

		// loop to read each parenthesis character by character
		for (int i = 0; i < chararray.length; i++) {

			// if stack is empty just push the array element
			if (stk.getSize() == 0) {
				stk.push(chararray[i]);

			}

			// if stack isnt empty check the incoming element and the top value
			else {

				// if they are opposite of each other pop the top element

				if (chararray[i] == ')' && stk.getTop() == '(') {

					stk.pop();

				}

				else if (chararray[i] == ']' && stk.getTop() == '[') {

					stk.pop();

				}

				// if they donot match just push it in stack

				else {
					stk.push(chararray[i]);

				}

			}
		}

		// return true if stack is empty after reading whole string
		if (stk.getSize() == 0)
			return true;

		else
			return false;

	}

}
