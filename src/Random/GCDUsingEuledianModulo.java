package Random;

public class GCDUsingEuledianModulo
{
public static void main(String[] args) 
{
	 int a = 2, b = 9381; 
     System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b)); 
	
	
}

private static int gcd(int a, int b) 
{
  if(b==0)
	  return a;
	
	
	return gcd(b,a%b);
}
}
