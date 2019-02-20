package Random;

public class GCD 
{
public static void main(String[] args) 
{
	int a = 20, b = 28; 
    System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b)); 
	
	
	
}

private static int gcd(int a, int b) 
{
    int min=a>b?b:a;
    
    for(int i=min;i>=1;i--)
    {
    	if(a%i==0 && b%i==0)
    		return i;
    	
    }
	
	
	
	
	return 1;
}
}
