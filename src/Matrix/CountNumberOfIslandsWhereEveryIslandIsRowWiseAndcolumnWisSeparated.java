package Matrix;

public class CountNumberOfIslandsWhereEveryIslandIsRowWiseAndcolumnWisSeparated {
	public static void main(String[] args) {
		int m = 6;
		int n = 3;
		int mat[][] = { { 'O', 'O', 'O' }, { 'X', 'X', 'O' }, { 'X', 'X', 'O' }, { 'O', 'O', 'X' }, { 'O', 'O', 'X' },
				{ 'X', 'X', 'O' } };
		System.out.println("Number of rectangular islands is: " + countIslands(mat, m, n));

	}

	private static int countIslands(int[][] mat, int m, int n) 
	{
          int count=0;
		  
		for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(mat[i][j]=='X')
        		{
        			if((i==0||mat[i-1][j]=='O') &&(j==0 ||mat[i][j-1]=='O'))
        				count+=1;
  
        		}
        		
        	}
        }
        
		
		return count;
	}
}
