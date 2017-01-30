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

public class MyQueue<AnyType> implements Queue<AnyType> {

	private MyDoublyLinkedList<AnyType> list;
	
	public MyQueue() {
		list = new MyDoublyLinkedList<AnyType>();
	}
	
	/**
	 * Used methods from Lab 5 DoublyLinkedList class:
	 * Added removeFirst and checkFirst methods
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(AnyType x) {
		list.insert(x);
	}

	public AnyType dequeue() {
		return list.removeFirst();
	}

	public AnyType peek() {
		return list.checkFirst();
	}

}
