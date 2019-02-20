package DynamicProgramming;

public class LongestIncreasingSubsequence {
	static int N = 5;

	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 2, 3 };
		int n = 5;
		System.out.println("lenght of list is =" + lis(arr, n));

	}

	private static int lis(int[] arr, int n) {
		int[] lis = new int[N];

		for (int i = 0; i < N; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++)
			{
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;

				}

			}
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++)
		{
			if (lis[i] > max)
				max = lis[i];
		}

		return max;
	}
}
