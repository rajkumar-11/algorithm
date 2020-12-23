import java.util.Scanner;

public class NumberOfPiesDynamic {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			int m = s.nextInt();
			int[] arr = new int[m];

			// int m = s.nextInt();

			for (int j = 0; j < m; j++) {
				arr[j] = s.nextInt();
			}
			int n = s.nextInt();

			if (findIfPossible(arr, m, n)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static boolean findIfPossible(int[] arr, int m, int n)
	{
		boolean[][] dp = new boolean[n + 1][m + 1];

		for (int i = 0; i <= m; i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= n; i++) {
			dp[i][0] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= arr[j - 1]) {
					dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
				}

			}

		}
		return dp[n][m];

		// return false;
	}
}
