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


// Implementation of Queue Interface
public interface Queue<AnyType> {
	public boolean isEmpty();
	public void enqueue(AnyType x);
	public AnyType dequeue();
	public AnyType peek();
}
