package inter;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,4,6,8,7,2,3,2,4,8,5,2};
		for(int i=0; i<numbers.length;i++){
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[i]+numbers[j]==6){
					System.out.println("("+numbers[i]+","+numbers[j]+")");
				}
			}
		}
		//pairs(numbers,6);
	}
	
//	public static void pairs(int[] array, int x) {
//		HashSet<Integer> set = new HashSet<Integer>();
//		for(int i=0; i<array.length;i++) {
//			set.add(array[i]);
//		}
//		for(int i=0; i<array.length;i++) {
//			int diff = x - array[i];
//			if(set.contains(diff)) {
//				System.out.print("("+array[i]+","+diff+")");
//				set.remove(diff);
//			}
//		}
//		
//		
//	
//	}

}
