package DynamicProgramming;

public class CoinChange {
	static int count = 0;

	public static void main(String[] args) {
		int i, j;
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println(count(arr, m, 4));

	}

	private static int count(int[] arr, int m, int n) {
		if (n == 0) {
			return 1;
		}

		if (n < 0)
			return 0;

		if (m <= 0 && n > 0)
			return 0;

		return count(arr, m, n - arr[m - 1]) + count(arr, m - 1, n);

		// return count;
	}

}
