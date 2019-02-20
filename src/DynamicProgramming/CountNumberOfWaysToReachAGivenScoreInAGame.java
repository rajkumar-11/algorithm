package DynamicProgramming;

public class CountNumberOfWaysToReachAGivenScoreInAGame {
	public static void main(String[] args) {
		int n = 20;
		int[] arr = { 3, 5, 10 };

		System.out.println("Count for " + n + " is " + count(n, arr, 0, 2));

		n = 13;

		System.out.println("Count for " + n + " is " + count(n, arr, 0, 2));

	}

	private static String count(int n, int[] arr, int start, int end) 
	{

		int[] value = new int[n + 1];

		for (int i = 0; i <= end; i++) {
			value[arr[i]] = 1;

		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= end; j++)
			{
				if (i - arr[j] >= 0) {
					value[i] += value[i - arr[j]];

				}
			}

		}
		System.out.println(value[n]);

		return null;
	}
}
