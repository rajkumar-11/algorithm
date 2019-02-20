package DynamicProgramming;

public class EggDroppingPuzzleUsingDP {
	public static void main(String[] args) {
		int n = 2;
		int k = 36;

		System.out.println("Minimum Number of trails required for no of coins = " + n + "  and number of floors = " + k
				+ " will be equal to " + getNumberOfTrails(n, k));

	}

	private static int getNumberOfTrails(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;

		}

		for (int i = 1; i <= k; i++) {
			dp[1][i] = i;
		}

		for (int i = 2; i <= n; i++) {

			for (int j = 2; j <= k; j++) {
				int min = Integer.MAX_VALUE;

				for (int x = 2; x <= j; x++) {
					int temp = Math.max(dp[i - 1][x - 1], dp[i][j - x]);

					if (temp < min) {
						min = temp;
					}

				}
				dp[i][j] = min + 1;

			}

		}

		
		
		return dp[n][k];
	}
}
