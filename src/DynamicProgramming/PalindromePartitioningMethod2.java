package DynamicProgramming;

public class PalindromePartitioningMethod2 {
	public static void main(String[] args) {
		String str = "ababbbabbababa";
		System.out.println("Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion(str));

	}

	private static int minPalPartion(String str) {
		int n = str.length();

		boolean[][] P = new boolean[n][n];
		int[] C = new int[n];

		for (int i = 0; i < n; i++) {
			P[i][i] = true;

		}

		for (int len = 2; len <= n; len++) {

			for (int i = 0; i < n - len + 1; i++) {

				int j = i + len - 1;

				if (len == 2) {
					P[i][j] = str.charAt(i) == str.charAt(j);
				} else {
					P[i][j] = (str.charAt(i) == str.charAt(j) && P[i + 1][j - 1]);
				}

			}

		}

		for (int i = 0; i < n; i++) {
			if (P[0][i] == true) {
				C[i] = 0;
			} else {
				C[i] = Integer.MAX_VALUE;

				for (int k = 0; k < i; k++) {
					if (P[k + 1][i] == true && 1 + C[k] < C[i]) {
						C[i] = 1 + C[k];

					}

				}

			}

		}

		return C[n - 1];

	}
}
