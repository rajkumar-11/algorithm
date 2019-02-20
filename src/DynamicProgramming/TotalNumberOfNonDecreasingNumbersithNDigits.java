package DynamicProgramming;

public class TotalNumberOfNonDecreasingNumbersithNDigits {
	public static void main(String[] args) {

		int n = 2;
		System.out.println(countNonDecreasing(n));

	}

	private static int countNonDecreasing(int n) {
		int[][] dp = new int[10][n + 1];

		for (int i = 0; i < 10; i++) {
			dp[i][1] = 1;

		}

		for (int i = 2; i <= n; i++) {
			for (int d = 0; d < 10; d++) {
				for (int k = 0; k <= d; k++) {
					dp[d][i] += dp[k][i - 1];

				}

			}

		}

//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j <= n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += dp[i][n];

		}

		return sum;
	}
}
