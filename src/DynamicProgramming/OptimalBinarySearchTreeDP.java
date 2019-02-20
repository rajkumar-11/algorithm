package DynamicProgramming;

public class OptimalBinarySearchTreeDP {
	public static void main(String[] args) {
		int keys[] = { 10, 12, 20 };
		int freq[] = { 34, 8, 50 };
		int n = keys.length;
		System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));

	}

	private static int optimalSearchTree(int[] keys, int[] freq, int n) {
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = freq[i];
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;

				int min = Integer.MAX_VALUE;

				for (int k = i; k <= j; k++) {
					System.out.println("i= " + i + "j= " + j + "k= " + k);
					int temp = (k > i ? dp[i][k - 1] : 0) + (j > k ? dp[k + 1][j] : 0) + sumOf(freq, i, j);

					if (temp < min)
						min = temp;
				}
				dp[i][j] = min;

			}

		}
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();

		}

		return dp[0][n - 1];
	}

	private static int sumOf(int[] freq, int i, int j) {
		int sum = 0;

		// System.out.println("i= "+i+"j= "+j);

		for (int x = i; x <= j; x++) {
			sum += freq[x];
		}

		return sum;
	}

}
