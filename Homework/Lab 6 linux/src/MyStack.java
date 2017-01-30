/*
 * Rajat Kuthiala
 * LAB-6
 * CSC-172
 * TA: Shuyang Liu
 * Partner: Jordy
 * 
 * I affirm that I have not given 
 * or received any unauthorized help 
 * on this assignment, and that this 
 * work is my own.
 */

public class MyStack<AnyType> implements Stack<AnyType>{

	// Head Node
	private MyNode<AnyType> head;
	private LinkedList<AnyType> list;
	
	public MyStack() {
		head = new MyNode<AnyType>();
		list = new LinkedList<AnyType>();
	}
	
	// Method returns boolean value based on what is after the first node
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// Method inserts a node to the front of the list and set it as the head
	public void push(AnyType x) {
		list.addFirst(x);
	}

	// Method takes the first node in the list, removes and returns it
	public AnyType pop() {
		return list.removeLast();
	}

	// Method returns the data of the first node on the stack
	public AnyType peek() {
		return list.peek();
	}
}
