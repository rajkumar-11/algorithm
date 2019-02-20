package DynamicProgramming;

public class MinCostPath {
	public static void main(String[] args) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 0, 0));

	}

	private static int minCost(int[][] cost, int i, int j) 
	{
		if (i > 2 || i < 0 || j > 2 || j < 0)
			return Integer.MAX_VALUE;

		if (i == 2 && j == 2)
			return cost[i][j];

		return cost[i][j] + Math.min(minCost(cost, i + 1, j), Math.min(minCost(cost, i + 1, j + 1), minCost(cost, i, j + 1)));
	}
}
