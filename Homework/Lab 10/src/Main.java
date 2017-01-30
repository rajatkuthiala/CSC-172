/*
 * Rajat Kuthiala
 * LAB-10
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
		MyBinaryTree<Integer> bst = new MyBinaryTree<Integer>();
		
		// Testing the insert method
		bst.insert(15);
		bst.insert(20);
		bst.insert(25);
		bst.insert(10);
		bst.insert(5);
		bst.insert(30);
		bst.insert(0);
		bst.insert(12);
		bst.insert(18);
		
		// Testing traversal methods
		System.out.println("inOrder Traversal: ");
		bst.printInOrder();
		System.out.println("\n");
		
		System.out.println("preOrder Traversal: ");
		bst.printPreOrder();
		System.out.println("\n");
		
		System.out.println("postOrder Traversal: ");
		bst.printPostOrder();
		System.out.println("\n");
		
		// Testing the lookup method
		System.out.println("Looking up 12 in Binary Search Tree");
		System.out.println("Boolean Result: " + bst.lookup(12) + "\n");
		
		// Testing the remove method
		System.out.println("... Deleting 0, 15 and 12");
		
		bst.delete(0);
		bst.delete(15);
		bst.delete(12);
		
		System.out.println("[Post Deletion] inOrder Traversal: ");
		bst.printInOrder();
		System.out.println("\n");
		
	}

}
