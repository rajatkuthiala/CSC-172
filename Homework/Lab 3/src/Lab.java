
public class Lab {
	
	public static void part1(String beginningString, String endingString) {
	    if (endingString.length() <= 1)
	      System.out.println(beginningString + endingString);
	    else
	      for (int i = 0; i < endingString.length(); i++) {
	        
	          String newString = endingString.substring(0, i) + endingString.substring(i + 1);

	          part1(beginningString + endingString.charAt(i), newString);
	        
	      }
	}
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		part1("", "error");
	}

}
