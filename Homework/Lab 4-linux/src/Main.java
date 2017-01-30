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

public class Main {

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		
		// Section 4 of Lab
		System.out.println("Linked List: ");
		myList.insert("R");
		myList.insert("A");
		myList.insert("J");
		myList.insert("T");
		myList.printList();
		
		// Section 5 of Lab
		System.out.println("\n\nDoes the Linked List contain 'J'? " + myList.contains("J") + "\n");
		myList.insert("R");
		System.out.println("Linked List after duplicate insertion: ");
		myList.printList();
		
		// Section 6 of Lab
		System.out.print("\n\nLooking up 'T' in the Linked List: ");
		System.out.println(myList.lookup("T"));
		System.out.print("Looking up 'X' in the Linked List: ");
		System.out.println(myList.lookup("X"));
		
		// Section 7 of Lab
		System.out.println("\nDeleting 'R' and 'T' from the Linked List");
		myList.delete("R");
		myList.delete("T");
		myList.printList();
	}

}
