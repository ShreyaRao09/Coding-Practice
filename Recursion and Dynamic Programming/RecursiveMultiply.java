import java.util.Arrays;

/**
 * Multiply two integers in O(log n) time.
 * 
 * @author Shreya Vishwanath Rao
 * @Version 1.0:
 *
 */
public class RecursiveMultiply {
	
	/**
	 * Calculates the product of two integers
	 * 
	 * @param a : first integers
	 * @param b : second integers
	 * @return product of the numbers
	 */
	public static int product(int a,int b){
		int smaller=a<b?a:b;
		int bigger=a<b?b:a;
		
		int[] memo=new int[smaller+1];
		Arrays.fill(memo, -1);
		
		return product(smaller, bigger, memo);
				
	}
	
	/**
	 * Helper function. Calculates the product in a recursive manner.
	 * 
	 * @param smaller : smaller integer
	 * @param bigger : bigger integer
	 * @param memo :stores precalculated products to avoid redundant calculation
	 * @return product of smaller and bigger
	 */
	public static int product(int smaller, int bigger, int[] memo){
		if(smaller==0)
			return 0;
		if(smaller==1)
			return bigger;
		if(memo[smaller]!=-1)
			return memo[smaller];
		
		int half=product((smaller>>1),bigger, memo);
		
		if(smaller%2==0)
			memo[smaller]=half+half;
		else
			memo[smaller]=half+half+bigger;
		
		return memo[smaller];
	}

	/**
	 * Main function. Calls product() to calculate the product of two number
	 * @param args : Command line argument
	 */
	public static void main(String[] args){
		int a=40;
		int b=35;
		System.out.println(product(a,b));
	}
}
