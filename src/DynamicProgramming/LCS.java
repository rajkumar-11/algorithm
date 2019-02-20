package DynamicProgramming;

public class LCS {
	public static void main(String[] args) {
		String s1 = "geeksforgeeks";
		String s2 = "skeegrofskeeg";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));

	}

	private static int lcs(char[] x, char[] y, int m, int n) {
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

		int i = m, j = n;

		StringBuilder sb = new StringBuilder("");

		while (i > 0 && j > 0) {
			if (value[i - 1][j] == value[i][j - 1] && value[i][j] > value[i - 1][j]) {
				sb.append(x[i - 1]);
				i--;
				j--;
				continue;
			}
			if (value[i - 1][j] > value[i][j - 1]) {
				i--;

			} else if (value[i - 1][j] < value[i][j - 1]) {
				j--;

			}

			else {
				j--;
			}

		}
		System.out.println(sb.reverse());

		return value[m][n];
	}

}
