package DynamicProgramming;

public class PalindromePartitioning {
	public static void main(String[] args) {

		String str = "ababbbabbababa";
		System.out.println("Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion(str));

	}

	private static int minPalPartion(String str) {
		int n = str.length();

		boolean[][] P = new boolean[n][n];
		int[][] C = new int[n][n];

		for (int i = 0; i < n; i++) {
			P[i][i] = true;
			C[i][i] = 0;

		}

		for (int len = 2; len <= n; len++) {

			for (int i = 0; i < n - len + 1; i++) {

				int j = i + len - 1;

				if (len == 2) {
					P[i][j] = str.charAt(i) == str.charAt(j);
				} else {
					P[i][j] = (str.charAt(i) == str.charAt(j) && P[i + 1][j - 1]);
				}
				if (P[i][j] == true) {
					C[i][j] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k <= j - 1; k++) {
						if (C[i][k] + C[k + 1][j] + 1 < min) {
							min = C[i][k] + C[k + 1][j] + 1;
						}
					}

					C[i][j] = min;

				}

			}

		}

		return C[0][n - 1];
	}
}
