package DynamicProgramming;

public class MaximumSizeSquareSubMatrix 
{
	public static void main(String[] args) 
	{
		int M[][] =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        
   printMaxSubSquare(M);
}

	private static void printMaxSubSquare(int[][] m) 
	{
	   int n= getMaxSquare(m);
	   
	   for(int i=0;i<n;i++)
	   {
		   for(int j=0;j<n;j++)
		   {
			   System.out.print("1 ");
		   }
		   System.out.println();
	   }
		
		
		
	}

	private static int getMaxSquare(int[][] M) 
	{
	   int R=M.length;
	   int C=M[0].length;
	   
	   int dp[][]= new int[R][C];
	   int max=1;
	   
	   for(int i=0;i<R;i++)
	   {
		   for(int j=0;j<C;j++)
		   {
			   if(i==0||j==0)
			   {   dp[i][j]=0;
			         continue;
			   }
			   
			   if(M[i][j]==0)
			   {
				   dp[i][j]=0;
				   continue;
			   }
			   else
			   {
				   dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
				   if(dp[i][j]>max)
				   {
					   max=dp[i][j];
				   }
			   }
			   
		   }
		   
	   }
	   
	   
	   
	   
		
		
		return max;
	}
		
		
	}


