/*
 * Rajat Kuthiala
 * LAB-7
 * CSC-172
 * TA: Shuyang Liu
 * Partner: Jordy
 * 
 * I affirm that I have not given 
 * or received any unauthorized help 
 * on this assignment, and that this 
 * work is my own.
 */
public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {

	private MyDoubleNode<AnyType> head;
	private MyDoubleNode<AnyType> tail;

	public MyDoublyLinkedList() {
		head = new MyDoubleNode<AnyType>(); // initialize head node
		tail = new MyDoubleNode<AnyType>(); // initialize tail node
		head.prev = null; 
		head.next = tail; // set head and tail to point to each other
		tail.prev = head;
		tail.next = null;
	}

	/** Method inserts item at the before the tail node of the list:
	 *  Create a new Node, place data from parameter into code and set it so it is the node previous to the tail
	 *  If the data is already within the list, do not insert a Node
	 *  The expected runtime is O(n): the lines are constant except for the contains method which is O(n)
	 */
	public void insert(AnyType x) {
		MyDoubleNode<AnyType> current = head;
		MyDoubleNode<AnyType> insertNode = new MyDoubleNode<AnyType>();
		insertNode.data = x;
		if(contains(x) == true) {
			return;
		}
		insertNode.prev = current;
		insertNode.next = current.next;
		insertNode.prev.next = insertNode;
		insertNode.next.prev = insertNode;
	}

	/** Method deletes objects passed through parameter
	 *  If the list contains what is passed through, change pointers so that it no longer points to that node
	 */
	public void delete(AnyType x) {
		if(contains(x)) {
			MyDoubleNode<AnyType> current = tail;
			while(current.prev.prev != null) {
				if(current.prev.data == x) {
					current.prev = current.prev.prev;
					return;
				}
				current = current.prev;
			}
		}
	}

	/** Method checks if the list contains the object passed
	 *  Returns true if data can be located and false otherwise
	 */
	public boolean contains(AnyType x) {
		MyDoubleNode<AnyType> current = head;
		while(current.next != null) {
			if(current.next.data == x) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/** Method checks if the list contains the object passed
	 *  Returns the object if it is in the list and null otherwise
	 */
	public AnyType lookup(AnyType x) {
		MyDoubleNode<AnyType> current = head;
		while(current.next != null) {
			if(current.next.data == x) {
				return x;
			}
			current = current.next;
		}
		return null;
	}

	/** Method checks if the list is empty
	 *  If the next node is after the starting node is null, then list is empty
	 */
	public boolean isEmpty() {
		return (head.next.next == null);
	}

	/** Method prints out list until end of list
	 *  While there is another node, keep printing the data
	 *  The expected runtime is O(n)
	 */
	public void printList() {
		MyDoubleNode<AnyType> current = tail;
		while(current.prev.prev != null) {
			System.out.print(current.prev.data + ", ");
			current = current.prev;
		}
	}

	/** Method prints out list in reverse until end of list
	 *  Start from the tail node and print backwards
	 *  The expected runtime is O(n)
	 */
	public void printListRev() {
		MyDoubleNode<AnyType> current = head;
		while(current.next.next != null) {
			System.out.print(current.next.data + ", ");
			current = current.next;
		}
	}
	
	/**
	 * Method returns and removes first item entered into doubly linked list
	 */
	public AnyType removeFirst() {
		MyDoubleNode<AnyType> current = tail;
		AnyType x = current.prev.data;
		current.prev = current.prev.prev;
		return x;
	}
	
	/**
	 * Method returns first item without removing
	 */
	public AnyType checkFirst() {
		MyDoubleNode<AnyType> current = tail;
		AnyType x = current.prev.data;
		return x;
	}
}
