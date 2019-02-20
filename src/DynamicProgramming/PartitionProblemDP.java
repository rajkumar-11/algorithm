package DynamicProgramming;

public class PartitionProblemDP {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;
		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two " + "subsets of equal sum");
		else
			System.out.println("Can not be divided into " + "two subsets of equal sum");

	}

	private static boolean findPartition(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0)
			return false;
		else {
			return isPossible(arr, n, sum / 2);

		}

	}

	private static boolean isPossible(int[] arr, int n, int sum) {
		int[] dp = new int[sum + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= sum; j++) {
				dp[j] += dp[j - arr[i]];

			}

		}

		return dp[sum] > 0 ? true : false;
	}
}
