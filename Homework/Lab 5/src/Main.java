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

public class Main {
	
	public static void main(String[] args) {
		myDoublyLinkedList<String> myList = new myDoublyLinkedList<String>();
		
		// Section 4 of Lab
		myList.insert("R");
		myList.insert("A");
		myList.insert("J");
		myList.insert("T");
		
		System.out.println("My Doubly Linked List: ");
		myList.printList();
		
		System.out.println("\n\nMy Doubly Linked List in Reverse: ");
		myList.printListRev();
		
		// Section 5 of Lab
		System.out.println("\n\nDoes my Doubly Linked list contain 'x' ? " + myList.contains("x"));
		System.out.println();
		
		System.out.println("My Doubly Linked List After Duplicate Insertion: ");
		myList.insert("R");
		myList.insert("A");
		myList.insert("J");
		myList.printList();
		
		// Section 6 of Lab
		System.out.println("\n\nImplementing Lookup Method. Looking up 'A'");
		System.out.println("Returning: " + myList.lookup("A"));
		
		// Section 7 of Lab
		System.out.println("\nImplementing Delete Method: Removing 'K' and 'J'");
		myList.delete("K");
		myList.delete("J");
		myList.printList();
	}
}
