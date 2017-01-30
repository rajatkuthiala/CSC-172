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

public class MyBinaryTree<T extends Comparable<T>> implements BST<T> {

	private MyTreeNode<T> root;

	MyBinaryTree() {
		root = new MyTreeNode<T>();
	}

	// Implementation of methods built-in to MyTreeNode
	
	// Insert method, checks if root is null and sets data if so, prevents duplicates with lookup condition
	public void insert(T x) {
		if(lookup(x) == true) {
			return;
		}
		if (root.data == null) {
			root.data = x;
		} else {
			root.insert(root, x);
		}
	}

	// Delete method, if value is in the tree and the root isn't null, remove the node with the data
	public void delete(T x) {
		if((lookup(x) == false) || (root == null)) {
			return;
		} else {
			root.remove(x);
		}
	}

	// Lookup method, if the root isn't null lookup for data and return boolean value
	public boolean lookup(T x) {
		if(root.data != null) {
			if(root.lookup(x)) {
				return true;
			}
		} return false;
	}

	// Calls to traversal method
	public void printPreOrder() {
		if(root.data != null) {
			root.printPreOrder();
		}
	}

	public void printInOrder() {
		if(root.data != null) {
			root.printInOrder();
		}
	}

	public void printPostOrder() {
		if(root.data != null) {
			root.printPostOrder();
		}
	}

}
