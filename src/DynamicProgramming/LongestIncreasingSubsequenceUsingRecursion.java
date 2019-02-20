package DynamicProgramming;

public class LongestIncreasingSubsequenceUsingRecursion {
	static int result = Integer.MIN_VALUE;
	static int N = 5;

	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 2, 3 };
		int n = 5;
		System.out.println("lenght of list is =" + lis(arr, n));

	}

	private static int lis(int[] arr, int n) {
		if (n == 1)
			return 1;

		int res, tempMax = 1;

		for (int i = 1; i < n; i++) {
			res = lis(arr, i);

			if (arr[i - 1] < arr[n - 1] && res + 1 > tempMax) {
				tempMax = res + 1;
			}
			System.out.println("n= " + n + " i= " + i + "arr[i-1]= " + arr[i - 1] + " arr[n-1]= " + arr[n - 1] + "res= "
					+ res + " tempMax=" + tempMax + " result= " + result);
		}
		if (tempMax > result)
			result = tempMax;

		return tempMax;

	}
}
