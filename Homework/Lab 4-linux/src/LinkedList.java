/*
 * Rajat Kuthiala
 * LAB-4
 * CSC-172
 * TA: Shuyang Liu
 * Partner: Jordy
 * 
 * I affirm that I have not given 
 * or received any unauthorized help 
 * on this assignment, and that this 
 * work is my own.
 */

// Section 3 of Lab: Implementing my own Linked List
public class LinkedList<AnyType> implements SimpleLinkedList<AnyType> {

	private MyNode<AnyType> start;
	
	public LinkedList(){
		start = new MyNode<AnyType>(); // Create the starting node
	}
	
	/** Method inserts item at the end of the list:
	 *  Create a new Node, place data from parameter into code, loop until the end of list, then add the new Node
	 *  If the data is already within the list, do not insert a Node
	 *  The expected runtime is O(n): the lines are constant until the while loop which is still O(n)
	 */
	public void insert(AnyType x) { 
		MyNode<AnyType> c = start;
		MyNode<AnyType> insertNode = new MyNode<AnyType>();
		insertNode.data = x;
		if(contains(x) == true) {
			return;
		}
		while(c.next != null) {
			c = c.next;
		} 
		c.next = insertNode;
	}
	
	/** Method deletes objects passed through
	 *  If the object is found, remove the pointer and point it to the next Node
	 */
	public void delete(AnyType x) {
		MyNode<AnyType> c = start;
		while(c.next != null) {
			if(c.next.data == x  ) {
				c.next = c.next.next;
				return;
			}
			c = c.next;
		}
	}

	/** Method checks if the list contains the object passed
	 *  Returns true if data can be located and false otherwise
	 */
	public boolean contains(AnyType x) {
		MyNode<AnyType> c = start;
		while(c.next != null) {
			if(c.next.data == x) {
				return true;
			} 
			c = c.next;
		}
		return false;
	}

	/** Method checks if the list contains the object passed
	 *  Returns the object if it is in the list and null otherwise
	 */
	public AnyType lookup(AnyType x) {
		MyNode<AnyType> c = start;
		while(c.next != null) {
			if(c.next.data == x) {
				return x;
			} 
			c = c.next;
		}
		return null;
	}
	
	/** Method checks if the list is empty
	 *  If the next node is after the starting node is null, then list is empty
	 */
	public boolean isEmpty() {
		return (start.next == null);
	}
	
	/** Method prints out list until end of list
	 *  While there is another node, keep printing the data
	 *  The expected runtime is O(n)
	 */
	public void printList() {
		MyNode<AnyType> c = start;
		while(c.next != null) {
			System.out.print(c.next.data + ", ");
			c = c.next;
		}
	}
}
