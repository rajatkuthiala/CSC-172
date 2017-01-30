/*
 * Rajat Kuthiala
 * LAB-1
 * Part:6
 * CSC-172
 * TA: Shuyang Liu
 * Partner: Jordy
 * 
 * I affirm that I have not given 
 * or received any unauthorized help 
 * on this assignment, and that this 
 * work is my own.
 */


import java.util.Arrays;

public class Lab{

	public static void main(String[] args) {
		
		Integer [] intArray = {1, 2, 3, 4, 5 };
		Double [] doubArray = {1.1, 2.2, 3.3, 4.4};
		Character [] charArray = {'H','E','L', 'L', 'O' };
		String [] strArray = {"once", "upon", "a", "time" };
		
		// @Sections 1-3
//		printarray(intArray);
//		printarray(doubArray);
//		printarray(charArray);
//		printarray(strArray);
		
	
		
		// @Sections 4-5
		
		System.out.println("Max Integer is: " + getMax(intArray));
		System.out.println("Max Double is: " + getMax(doubArray));
		System.out.println("Max Character is: " + getMax(charArray));
		System.out.println("Max String is: " + getMax(strArray));
	}

	// @Section 1:
	// Implements a static printarray method using objects as parameter

//	public static void printarray (Object [] parameter) {
//		System.out.println(Arrays.toString(parameter));
//	}

	
	// @Section 2:
	// Implements printarray method using method overloading
	
//	private static void printarray(String[] strArray) {
//		System.out.println(Arrays.toString(strArray));
//	}
//
//	private static void printarray(Character[] charArray) {
//		System.out.println(Arrays.toString(charArray));
//	}
//
//	private static void printarray(Double[] doubArray) {
//		System.out.println(Arrays.toString(doubArray));
//	}
//
//	private static void printarray(Integer[] intArray) {
//		System.out.println(Arrays.toString(intArray));
//	}
	
	
	// @Section 3
	// Using Generics. Using T as a substitute for the types.
	
//	private static <T> void printarray(T[] t) {
//		System.out.println(Arrays.toString(t));
//	}
	
	
	// @Section 4
	// Returns the max without using Generics, just Comparable interface
	
//	public static Comparable getMax(Comparable [] a) {
//		
//		Comparable greatest = a[0];
//		for(int i = 0; i < a.length; i++) {
//			for(int n = 0; n < a.length; n++) {
//				if(a[i].compareTo(a[n]) < 0) {
//					greatest = a[n];
//				}
//			}
//		}
//		return greatest;
//	}
	
	
	// @Section 5
	// Returns the max with Generics
	
	public static <T extends Comparable<? super T>> T getMax(T [] a){

		T greatest = a[0];
		for(int i = 0; i < a.length; i++) {
			for(int n = 0; n < a.length; n++) {
				if(a[i].compareTo(a[n]) < 0) {
					greatest = a[n];
				}
			}
		}
		return greatest;
	}
}
