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

public class MyTreeNode<T extends Comparable<T>> {
	
	public T data;
	public MyTreeNode<T> leftChild;
	public MyTreeNode<T> rightChild;
	public MyTreeNode<T> parent;
	
	
	// Recursive Insert Method
	// ### Problem #3:
	/*
	 * Base Case: if node is null, create a new node and set the data to x.
	 * Else if the data is greater than the current node, move to the rightChild.
	 * Else if the data is less than the current node, move to the leftChild.
	 * 
	 * Each time it is returned, set the node's parent as parent (used in the remove method)
	 */
	public MyTreeNode<T> insert(MyTreeNode<T> node, T x) {
		if(node == null) {
			node = new MyTreeNode<T>();
			node.data = x;
		} else if (x.compareTo(node.data) > 0) {
			node.rightChild = insert(node.rightChild, x);
			node.rightChild.parent = node;
		} else {
			node.leftChild = insert(node.leftChild, x);
			node.leftChild.parent = node;
		}
		return node;
	}
	
	
	// Recursive PreOrder Traversal Method 
	// ### Problem #4:
	/*
	 * First, visit the node, print its data.
	 * Second, traverse the left subtree.
	 * Third, traverse the right subtree.
	 * 
	 * Note: Modified/Copied some of code from Pawlicki's slide and used the following link.
	 * 		Link: http://www.java2blog.com/2014/07/binary-tree-preorder-traversal-in-java.html
	 */
	public void printPreOrder() {
		System.out.print(data + ", ");
		if(leftChild != null) {
			leftChild.printPreOrder();
		}
		if(rightChild != null) {
			rightChild.printPreOrder();
		}
	}
	
	// Recursive InOrder Traversal Method
	/*
	 * First, traverse the left subtree. 
	 * Second, visit the node, print its data.
	 * Third, traverse the right subtree.
	 * 
	 * Note: Modified/Copied some of code from Pawlicki's slide and used the following link.
	 * 		Link: http://www.java2blog.com/2014/07/binary-tree-inorder-traversal-in-java.html
	 */
	public void printInOrder() {
		if(leftChild != null) {
			leftChild.printInOrder();
		}
		System.out.print(data + ", ");
		if(rightChild != null) {
			rightChild.printInOrder();
		}
	}
	
	// Recursive InOrder Traversal Method
	/*
	 * First, traverse the left subtree. 
	 * Second, traverse the right subtree.
	 * Third, visit the node, print its data.
	 * 
	 * Note: Modified/Copied some of code from Pawlicki's slide and used the following link.
	 * 		Link: http://www.java2blog.com/2014/07/binary-tree-postorder-traversal-in-java.html
	 */
	public void printPostOrder() {
		if(leftChild != null) {
			leftChild.printPostOrder();
		}
		if(rightChild != null) {
			rightChild.printPostOrder();
		}
		System.out.print(data + ", ");
	}
	
	// Recursive Lookup Method
	/*
	 * If node is equal to the data being looked up, return true.
	 * else if x is greater than data, move right in tree.
	 * else if x is less than data , move left in tree.
	 */
	public boolean lookup(T x) {
		if(x.equals(data)) {
			return true;
		} else if((x.compareTo(data) > 0 ) && rightChild!= null) {
			return rightChild.lookup(x);
		} else if ((x.compareTo(data) < 0 && leftChild != null)) {
			return leftChild.lookup(x);
		}
		return false;
	}
	
	// Method finds the leftmost value of the right subtree
	// Used in deletion Case 3: Tree Node has two children
	/*
	 * Set node e to the right subtree
	 * return the leftmost node of that right subtree
	 */
	public MyTreeNode<T> minValue() {
	  MyTreeNode<T> e = rightChild;
	  while (e.leftChild != null) {
		  e = e.leftChild;
	  }
	  return e;
	}
	
	// Remove/Deletion Method
	public void remove(T x) {
		if(x.equals(data)) {
			
			// Case 1: TreeNode is a leaf
			// if leftChild and rightChild are null, make the parent's child to null
			if(leftChild == null && rightChild == null) {
				if(parent.leftChild == this) {
					parent.leftChild = null;
				} else {
					parent.rightChild = null;
				}
			}
			
			// Case 2: TreeNode has one child
			else if(leftChild == null) { 			// if the leftChild is null
				if(parent.leftChild == this) {			// and if the node is the parent's leftChild
					parent.leftChild = rightChild;		// set the parents leftChild to the current node's rightChild (because leftChild is null)
					if(rightChild != null) {			
						rightChild.parent = parent;		// set that rightChild's parent to the current node's parent
					}
				} else {								// if the node is the parent's rightChild
					parent.rightChild = rightChild;		// set the parents leftChild to the current node's rightChild (because leftChild is null)
					if(rightChild != null) {			
						rightChild.parent = parent;		// set the rightChild's parent to the current node's parent
					}
				}
			} else if(rightChild == null) {			// Same conditions as before except rightChild is null
				if(parent.rightChild == this) {
					parent.rightChild = leftChild;
					if(leftChild != null) {
						leftChild.parent = parent;
					}
				} else {
					parent.leftChild = leftChild;
					if(leftChild != null) {
						leftChild.parent = parent;
					}
				}
			}
			
			// Case 3: TreeNode has two children
			else if(leftChild != null && rightChild != null){
				MyTreeNode<T> y = minValue();			// retrieve the leftmost child of the right subtree
				T temp = y.data;						// store that node's data
				remove(y.data);							// remove the duplicate
				data = temp;							// set current node to that stored data
			}
		} 
		
		// Traverse while data does not equal to x
		else if(x.compareTo(data) > 0 && rightChild != null) {
			rightChild.remove(x);
		} 
		else if(x.compareTo(data) < 0 && leftChild != null) {
			leftChild.remove(x);
		}
	}
}