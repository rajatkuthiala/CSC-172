import java.math.BigInteger;

public class Lab {
	
	public static int part1(int a, int b){
		return (int) Math.pow(a, b);
		
	}
	
	public static BigInteger part2(int a){
		if(a<=1){
			return BigInteger.ONE;
		}
			
		else{
			return a.multiply(BigInteger.valueOf(part2(BigInteger(a))));
		}
	}
		
	
	public static BigInteger part3(long a, long b){
		return part2(a)/part2(a-b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Part 1
		System.out.println("Number of ways in which we can paint three house in four color: "+part1(4,3));
		System.out.println("Number of password combinations for 10 character password:  "+part1(62,10));
		
		//Part 2
		System.out.println("Possible batting order for 9 players: "+part2(9));
		
		//Part 3
		System.out.println("Number of ways in which four officers can be selected: "+part3(200,4));

	}

}
