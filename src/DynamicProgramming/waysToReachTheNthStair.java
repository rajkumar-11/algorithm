package DynamicProgramming;

public class waysToReachTheNthStair {
	public static void main(String[] args) {
		int s = 10, m = 2;
		System.out.println("Number of ways = " + countWays(s, m));

	}

	private static int countWays(int s, int m) {
		int[] dp = new int[s + 1];
		dp[0] = 1;

		for (int i = 1; i <= s; i++) {

			for (int j = 1; j <= 2; j++) {
				if (j <= i) {
					dp[i] += dp[i - j];

				}

			}

		}

		for (int i = 0; i <= s; i++) {
			System.out.print(dp[i] + " ");
		}

		return dp[s];
	}
}
