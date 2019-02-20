package DynamicProgramming;

public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of the shortest supersequence is " + superSeq(X, Y, m, n));

	}

	private static int superSeq(char[] x, char[] y, int m, int n) {
		int[][] value = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					value[i][j] = 1 + value[i - 1][j - 1];
				} else {
					value[i][j] = Math.max(value[i - 1][j], value[i][j - 1]);
				}

			}

		}

		int commonLength = value[m][n];

		return m - commonLength + n;
	}
}
