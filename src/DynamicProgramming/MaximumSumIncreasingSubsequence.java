package DynamicProgramming;

public class MaximumSumIncreasingSubsequence {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println("Sum of maximum sum increasing " + " subsequence is " + maxSumIS(arr, n));

	}

	private static int maxSumIS(int[] arr, int n) 
	{
		
		int[] dp = new int[n];

		for (int i = 0; i < n; i++)
			dp[i] = arr[i];

		for (int i = 0; i < n; i++) {
			int sum = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] + arr[i] > sum)
				{
					sum = dp[j] + arr[i];
				}
				dp[i] = sum;

			}

		}

		for (int i = 0; i < n; i++) {
			System.out.print(dp[i] + " ");
		}

		return dp[n - 1];
	}
}
