package BitAlgorithm;

public class SmallestPowerOf2GreaterThanOrEqualToN 
{
public static void main(String[] args) 
{
	int n = 28; 
    System.out.println(nextPowerOf2(n)); 
	
	
}

private static int nextPowerOf2(int n)
{
 int count=0;
 
  while(n!=0)
  {
	  n=n>>1;
	  count++;
	  
  }
	
	return (int) Math.pow(2, count);
}
}
