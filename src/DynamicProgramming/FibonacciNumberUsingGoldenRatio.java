package DynamicProgramming;

public class FibonacciNumberUsingGoldenRatio 
{
public static void main(String[] args) 
{ 
	int n=10;
	System.out.println(n+"th term will be = "+fib(20));
	
	
	
}

private static double fib(int n) {

	float a=(float) ((Math.sqrt(5)+1)/2);
	
	double ans= Math.floor((Math.pow(a,n)/Math.sqrt(5))+.5);
	
	
	
	return ans;
}

}
