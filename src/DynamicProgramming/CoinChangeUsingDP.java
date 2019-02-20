package DynamicProgramming;

public class CoinChangeUsingDP 
{
	public static void main(String[] args) {
		int i, j;
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println(count(arr, m, 4));

	}

	private static int  count(int[] arr, int m, int n) 
	{
	  int[] value= new int[n+1];
	  
	 value[0]=1;
	  
	  for(int i=0;i<m;i++)
	  {
		  for(int j=arr[i];j<=n;j++)
		  {
			  value[j]+=value[j-arr[i]];
			  
		  }
		  
	  }
		
		
		return value[n];
	}
}
