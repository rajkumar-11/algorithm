package DynamicProgramming;

public class MinimumNumberOfJumpsToReachEnd {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };
		int n = arr.length;
		System.out.print("Minimum number of jumps to reach end is " + minJumps(arr, n));

	}

	private static int minJumps(int[] arr, int n) {
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n && j <= i + arr[i]; j++) {

				dp[j] = Math.min(dp[i] + 1, dp[j]);

			}
			// if (dp[n - 1] != 0)
			// return i;

		}
		for (int i = 0; i < n; i++) {
			System.out.print(dp[i] + " ");
		}

		return dp[n - 1];
	}
}
