package DynamicProgramming;

public class FibonacciMemoization 
{
  public static void main(String[] args) 
  {
	 int n=20;
	  System.out.println(fib(20));
	  
	  
	  
}

private static int  fib(int n) 
{
  if(n<=1)
	  return n;
  else
	  return fib(n-1)+fib(n-2);
	

}
	
	
}
