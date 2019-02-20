package DynamicProgramming;

public class digitNumbersWhoseSumOfDigitsEqualsToGivenSum {
	public static void main(String[] args) {

		int n = 4, sum = 22;
		System.out.println(finalCount(n, sum));

	}

	private static int finalCount(int n, int sum) {
		if (sum > n * 9 || sum < 0)
			return 0;
		if (n == 1)
			return 1;

		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if ((i == 1 && j <= 9) || j == 1 || j == 0) {
					dp[i][j] = 1;
					continue;
				}

				for (int k = 0; k <= 9 && j - k > 0; k++) {
					dp[i][j] += dp[i - 1][j - k];

				}
			}
		}

		

		return dp[n][sum];
	}
}
