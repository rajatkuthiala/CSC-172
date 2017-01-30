/*
 * Rajat Kuthiala
 * LAB-5
 * CSC-172
 * TA: Shuyang Liu
 * Partner: Jordy
 * 
 * I affirm that I have not given 
 * or received any unauthorized help 
 * on this assignment, and that this 
 * work is my own.
 */


// Section 3 of Lab: Implementing my own Doubly Linked List
public class myDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
	
	private MyDoubleNode<AnyType> first; 
	private MyDoubleNode<AnyType> last; 
	
	public myDoublyLinkedList() {
		first = new MyDoubleNode<AnyType>(); // initialize first node
		last = new MyDoubleNode<AnyType>(); // initialize last node
		first.next = last; // set first and last to point to each other
		last.prev = first;
	}

	/** Method inserts item at the before the last node of the list:
	 *  Create a new Node, place data from parameter into code and set it so it is the node previous to the last
	 *  If the data is already within the list, do not insert a Node
	 *  The expected runtime is O(n): the lines are constant except for the contains method which is O(n)
	 */
	public void insert(AnyType x) {
		MyDoubleNode<AnyType> l = last;
		MyDoubleNode<AnyType> insertNode = new MyDoubleNode<AnyType>();
		insertNode.data = x;
		if(contains(x) == true) {
			return;
		}
		insertNode.prev = l.prev;
		insertNode.next = l;
		l.prev.next = insertNode;
		l.prev = insertNode;
	}

	/** Method deletes objects passed through parameter
	 *  If the list contains what is passed through, change pointers so that it no longer points to that node
	 */
	public void delete(AnyType x) {
		if(contains(x)) {
			MyDoubleNode<AnyType> l = first;
			while(l.next != null) {
				if(l.next.data == x  ) {
					l.next = l.next.next;
					return;
				}
				l = l.next;
			}
		}
	}

	/** Method checks if the list contains the object passed
	 *  Returns true if data can be located and false otherwise
	 */
	public boolean contains(AnyType x) {
		MyDoubleNode<AnyType> f = first;
		while(f.next != null) {
			if(f.next.data == x) {
				return true;
			} 
			f = f.next;
		}
		return false;	
	}

	/** Method checks if the list contains the object passed
	 *  Returns the object if it is in the list and null otherwise
	 */
	public AnyType lookup(AnyType x) {
		MyDoubleNode<AnyType> f = first;
		while(f.next != null) {
			if(f.next.data == x) {
				return x;
			} 
			f = f.next;
		}
		return null;	
	}

	/** Method checks if the list is empty
	 *  If the next node is after the starting node is null, then list is empty
	 */
	public boolean isEmpty() {
		return (first.next.next == null);
	}

	/** Method prints out list until end of list
	 *  While there is another node, keep printing the data
	 *  The expected runtime is O(n)
	 */
	public void printList() {
		MyDoubleNode<AnyType> f = first;
		while(f.next.next != null) {
			System.out.print(f.next.data + ", ");
			f = f.next;
		}
	}

	/** Method prints out list in reverse until end of list
	 *  Start from the last node and print backwards
	 *  The expected runtime is O(n)
	 */
	public void printListRev() {
		MyDoubleNode<AnyType> l = last;
		while(l.prev.prev != null) {
			System.out.print(l.prev.data + ", ");
			l = l.prev;
		}
	}
}
