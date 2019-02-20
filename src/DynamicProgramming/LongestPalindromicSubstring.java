package DynamicProgramming;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + longestPalSubstr(str));

	}

	private static int longestPalSubstr(String str) {
		int n = str.length();

		int[][] dp = new int[n][n];
		boolean[][] TF = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			TF[i][i] = true;

		}
		int start = 0;
		int max = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < n - i + 1; j++) {
				int k = j + i - 1;

				if (i == 2) {
					if (str.charAt(j) == str.charAt(k)) {
						dp[j][k] = 2;
						TF[j][k] = true;
						if (dp[j][k] > max) {
							max = dp[j][k];
							start = j;
						}

					}

				}

				if (str.charAt(j) == str.charAt(k) && TF[j + 1][k - 1]) {
					TF[j][k] = true;
					dp[j][k] = 2 + dp[j + 1][k - 1];

					if (dp[j][k] > max) {
						max = dp[j][k];
						start = j;
					}

				}

			}

		}

		// for(int i=0;i<n;i++)
		// {
		// for(int j=0;j<n;j++)
		// {
		// System.out.print(dp[i][j]+" ");
		// }
		// System.out.println();
		//
		// }

		return max;
	}

}
