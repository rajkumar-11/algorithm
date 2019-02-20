package DynamicProgramming;

public class LongestPalindromicSubsequenceUsingDP {
	public static void main(String[] args) {

		String seq = "BBBBB";
		int n = seq.length();
		System.out.println("The lnegth of the lps is " + lps(seq, n));

	}

	private static int lps(String seq, int n) {
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;

		}

		for (int len = 2; len <=n; len++) {
			for (int i = 0; i < n - len+1; i++) {
				int j = i + len-1;

//				System.out.println("i= " + i + " j= " + j);

				if (j - i == 1 && seq.charAt(i) == seq.charAt(j))
				{
					dp[i][j] = 2;

				} else if (seq.charAt(i) == seq.charAt(j)) 
				{
					dp[i][j] = dp[i + 1][j - 1] + 2;

				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);

				}

			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		return dp[0][n-1];
	}
}
