package Misc;

public class ConstructAnArrayFromItsPairSumArray {
	public static void main(String[] args) {
		int pair[] = { 15, 13, 11, 10, 12, 10, 9, 8, 7, 5 };
		int n = 5;
		// int arr[]= new int[n];
		int[] result = constructArr(pair, n);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");

	}

	private static int[] constructArr(int[] arr, int n) {
		int a = arr[0];
		int b = arr[1];
		int c = arr[n - 1];
//		System.out.println("a= " + a + " b= " + b + " c= " + c);

		// int size = ((n) * (n - 1)) / 2;

		int result[] = new int[n];

		result[0] = (a + b - c) / 2;

		for (int i = 1; i < n; i++) {
			result[i] = arr[i-1] - result[0];

		}

		return result;

	}

}
