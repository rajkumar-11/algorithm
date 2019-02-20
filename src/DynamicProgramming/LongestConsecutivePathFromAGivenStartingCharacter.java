package DynamicProgramming;

public class LongestConsecutivePathFromAGivenStartingCharacter {
	static int[] x = { 1, 1, -1, 0, 0, 1, -1, -1 };
	static int[] y = { 1, 0, 0, 1, -1, -1, 1, -1 };

	static int C = 3, R = 3;

	static int dp[][] = new int[R][C];

	public static void main(String[] args) {

		char mat[][] = { { 'a', 'c', 'd' }, { 'h', 'b', 'a' }, { 'i', 'g', 'f' } };

		System.out.println(getLen(mat, 'a'));
		System.out.println(getLen(mat, 'e'));
		System.out.println(getLen(mat, 'b'));
		System.out.println(getLen(mat, 'f'));

	}

	private static int getLen(char[][] mat, char c) {

		int ans = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dp[i][j] = -1;

			}

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if (mat[i][j] == c) {
					// System.out.println("here");
					for (int k = 0; k < 8; k++) {
						
						ans = Math.max(ans, 1 + getLenUtils(mat, i + x[k], j + y[k], c));

					}

				}

			}
		}

		return ans;
	}

	private static int getLenUtils(char[][] mat, int i, int j, char prev) {
		if (isInValid(i, j) || !isAdjacent(mat[i][j], prev)) {
			return 0;
		}

		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = 0;

		for (int k = 0; k < 8; k++) {
			ans = Math.max(ans, 1 + getLenUtils(mat, i + x[k], j + y[k], mat[i][j]));

		}
		// System.out.println("Cha maela");

		return (dp[i][j] = ans);
	}

	private static boolean isAdjacent(char d, char prev) {
		if ((d - prev) == 1)
			return true;

		return false;
	}

	private static boolean isInValid(int i, int j) {
		if (i < 0 || i >= C || j < 0 || j >= R)
			return true;

		return false;
	}

}
