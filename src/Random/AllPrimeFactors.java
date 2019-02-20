package Random;

public class AllPrimeFactors 
{
public static void main(String[] args) 
{
	 int n = 316; 
     primeFactors(n); 
	
}

private static void primeFactors(int n) 
{
	int i=2;
  while(Math.sqrt(n)>1)
  {
    if(n%i==0)
    {
    	n=n/i;
    	System.out.print(i+" ");
    	i=2;
    }
    else
    {
    	i++;
    }
	  
	  
	  
  }
	 
	
}
}
