package DynamicProgramming;

public class MinimumInitialPointsToReachDestination {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		int points[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int R = 2, C = 2;
		minInitialPoints(points, R, C, 0);

		System.out.println("Minimum Initial Points Required: " + max);

	}

	private static void minInitialPoints(int[][] points, int i, int j, int currentSum)
	{
		if (i < 0 || j < 0)
			return;

		if (i == 0 && j == 0) {
			if (currentSum > max) {
				max = currentSum;
			}

		}

		minInitialPoints(points, i - 1, j, currentSum + points[i][j]);
		minInitialPoints(points, i, j - 1, currentSum + points[i][j]);
	}
}
