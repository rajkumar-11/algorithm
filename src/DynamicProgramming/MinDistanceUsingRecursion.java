package DynamicProgramming;

public class MinDistanceUsingRecursion {
	static int N = 3;

	public static void main(String args[]) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 0, 0, 2, 2));
	}

	private static int minCost(int[][] cost, int x, int y, int a, int b) 
	{
		if(x>=3 ||y>=3||x<0 ||y<0)
		 return Integer.MAX_VALUE;
	
		if (x == a && y == b)
			return cost[a][b];

		
				return cost[x][y] + Math.min(Math.min(minCost(cost, x + 1, y, a, b), minCost(cost, x, y + 1, a, b)),
						minCost(cost, x + 1, y + 1, a, b));

		

//		return 0;
	}

}
