package BitAlgorithm;

public class ComputeTheIntegerAbsoluteValue 
{
public static void main(String[] args) 
{
	printTheAbsoluteValue(-300);
	
	
}

private static void printTheAbsoluteValue(int n) 
{
  int mask=n>>63;
  
//  n=mask^n;
  
  
   n=(n^mask)-mask;
   
  System.out.println("The absolute value is "+n);
	
	
  
	
	
}
}
