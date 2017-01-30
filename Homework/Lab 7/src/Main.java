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
public class Main {
	public static void main(String[] args) {
		
		MyDoublyLinkedList<String> myList = new MyDoublyLinkedList<String>();
		MyQueue<String> q = new MyQueue<String>();
		
		//	Testing Enqueue method
		System.out.println("### Testing Enqueue method ###");
		q.enqueue("R");
		System.out.println("Enqueue 'R' ");
		q.enqueue("A");
		System.out.println("Enqueue 'A' ");
		q.enqueue("J");
		System.out.println("Enqueue 'J' ");
	
	//	Testing isEmpty method
		System.out.println("\n### Testing isEmpty method ###");
		System.out.println("Is the queue empty? " + q.isEmpty());
		
	//	Testing Peek method	
		System.out.println("\n### Testing peek method ###");
		System.out.print("Peeking top of q: ");
		System.out.println(q.peek());
		
	//	Testing Dequeue method	
		System.out.println("\n### Testing dequeue method ###");
		System.out.print("dequeue: ");
		System.out.println(q.dequeue());
		System.out.print("dequeue: ");
		System.out.println(q.dequeue());
		System.out.print("dequeue: ");
		System.out.println(q.dequeue());
		
		
	}
}
