package DynamicProgramming;

public class ShortestPossibleCombinationOfTwoStrings {
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
		System.out.println(value[m][n]);

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
				sb.append(x[i - 1]);
				i--;

			} else if (value[i - 1][j] < value[i][j - 1]) {
				sb.append(y[j - 1]);
				j--;

			}

			else {
				sb.append(y[j - 1]);
				j--;
			}

		}

		while (i > 0) {
			sb.append(x[i - 1]);
			i--;
		}

		while (j > 0) {
			sb.append(y[j - 1]);
			j--;
		}

		System.out.println(sb.reverse().toString());

		return m + n - value[m][n];
	}
}
