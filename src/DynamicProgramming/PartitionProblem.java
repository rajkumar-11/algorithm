package DynamicProgramming;

public class PartitionProblem {
	public static void main(String[] args) {
		int arr[] = { 13, 1, 2, 3, 4 };
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

		if (sum == 0)
			return true;

		if (n == 0)
			return false;

		return isPossible(arr, n - 1, sum - arr[n - 1]) || isPossible(arr, n - 1, sum);

		// return false;
	}
}
