package Random;

public class GCDUsingEuledian
{
	
	public static void main(String[] args) 
	{ 
		 int a = 98, b = 56; 
	     System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b)); 
	}

	private static int gcd(int a, int b) {
		
		if(b==0||a==0)
			return 0;
		
		if(a==b)
			return a;
		
		if(a>b)
			return gcd(a-b,a);
		
		return gcd(a,b-a);
	}
	
}
