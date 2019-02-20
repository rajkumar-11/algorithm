package DynamicProgramming;

public class MinimumInitialPointsDestinationDP {
	public static void main(String[] args) {
		int points[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int R = 3, C = 3;

		System.out.println("Minimum Initial Points Required: " + minInitialPoints(points, R, C));

	}

	private static int minInitialPoints(int[][] points, int R, int C) {
		Box[][] dp = new Box[R + 1][C + 1];

		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C; j++) {
				dp[i][j] = new Box();

				if (j == 0 || i == 0) {
					dp[i][j].min = Integer.MIN_VALUE;
				}

			}
		}

		System.out.println(dp[0][2].min);
		System.out.println();

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {

				if (i == 1 && j == 1) {
					dp[i][j].min = points[0][0];
					dp[i][j].value = points[0][0];
					continue;
				}

				boolean flag = dp[i - 1][j].min > dp[i][j - 1].min ? true : false;
				if (flag == true) {
					dp[i][j].value = dp[i - 1][j].value + points[i - 1][j - 1];
					// dp[i][j-1].value+points[i-1][j-1]
					if (dp[i - 1][j].value + points[i - 1][j - 1] < dp[i - 1][j].min) {
						dp[i][j].min = dp[i - 1][j].value + points[i - 1][j - 1];
					} else {
						dp[i][j].min = dp[i - 1][j].min;

					}

				} else {
					dp[i][j].value = dp[i][j - 1].value + points[i - 1][j - 1];

					if (dp[i][j - 1].value + points[i - 1][j - 1] < dp[i][j - 1].min) {
						dp[i][j].min = dp[i][j - 1].value + points[i - 1][j - 1];
					} else {
						dp[i][j].min = dp[i][j - 1].min;
					}

				}

			}

		}

		for (int i = 0; i <= R; i++) {

			for (int j = 0; j <= C; j++) {
				System.out.print(dp[i][j].min + " ");
			}
			System.out.println();

		}

		return 0;
	}
}

class Box {
	int value, min;

}