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

public class Main {

	public static void main(String[] args) {
		
		MyStack<String> stack = new MyStack<String>();
		
	//	Testing push method
		System.out.println("### Testing push method ###");
		stack.push("R");
		System.out.println("Pushed 'R' ");
		stack.push("A");
		System.out.println("Pushed 'A' ");
		stack.push("J");
		System.out.println("Pushed 'J' ");

	
	//	Testing isEmpty method
		System.out.println("\n### Testing isEmpty method ###");
		System.out.println("Is the stack empty? " + stack.isEmpty());
		
	//	Testing peek method	
		System.out.println("\n### Testing peek method ###");
		System.out.print("Peeking top of stack: ");
		System.out.println(stack.peek());
		
	//	Testing pop method	
		System.out.println("\n### Testing pop method ###");
		System.out.print("Popped: ");
		System.out.println(stack.pop());
		System.out.print("Popped: ");
		System.out.println(stack.pop());
		System.out.print("Popped: ");
		System.out.println(stack.pop());
	}

}
