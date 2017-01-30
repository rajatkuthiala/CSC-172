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

import java.util.*;

public class Part6 {

	public static void main(String[] args) {
		String [] arr = {"ZEBRA", "Alligator", "Crocodile"};
		System.out.println(findMax(arr, new CaseInsensitiveCompare()));
		
		
		Character [] arr2 = {'G','A', 'Z', 'E', 'B', 'O'};
		System.out.println(findMax(arr2, new CaseInsensitiveCompare2()));
		
	}
	
	public static <AnyType> AnyType findMax(AnyType [] arr, Comparator<? super AnyType> cmp) {
		int maxIndex = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if(cmp.compare( arr[i], arr[maxIndex] ) > 0 ) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
}

class CaseInsensitiveCompare implements Comparator<String> {
	public int compare(String lhs, String rhs) {
		return lhs.compareToIgnoreCase(rhs);
	}
}


class CaseInsensitiveCompare2 implements Comparator<Character> {
	public int compare(Character lhs, Character rhs) {
		return lhs.compareTo(rhs);
	}

}

