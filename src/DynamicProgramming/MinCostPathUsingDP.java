package DynamicProgramming;

import java.util.Arrays;

public class MinCostPathUsingDP {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 3, 3));

	}

	private static int minCost(int[][] cost, int m, int n) {
		int[][] value = new int[4][4];

		Arrays.fill(value[0], Integer.MAX_VALUE);

		for (int i = 1; i <= m; i++) {
			value[i][0] = Integer.MAX_VALUE;
		}
		value[0][0] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				value[i][j] = cost[i - 1][j - 1]
						+ Math.min(value[i - 1][j - 1], Math.min(value[i - 1][j], value[i][j - 1]));

			}

		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(value[i][j] + " ");
			}
			System.out.println();
		}

		return value[m][n];
	}

}
