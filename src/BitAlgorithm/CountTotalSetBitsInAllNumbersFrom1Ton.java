package BitAlgorithm;

public class CountTotalSetBitsInAllNumbersFrom1Ton 
{
public static void main(String[] args) 
{
	 int n = 6; 
     System.out.print("Total set bit count is "); 
     System.out.print(countSetBits(n));
	
	
}

private static int countSetBits(int n) {
	
	int count=0;
	
	for(int i=1;i<=n;i++)
	{
		count+=getCount(i);
	}
	
	return count;
}

private static int getCount(int n) 
{
  if(n<=0)
	  return 0;
	
	if(n%2!=0)
		return 1+getCount(n/2);
	else 
		return getCount(n/2);
	
}
}
