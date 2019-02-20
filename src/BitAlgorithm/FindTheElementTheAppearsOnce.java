package BitAlgorithm;

public class FindTheElementTheAppearsOnce {
	public static void main(String[] args) {
		int arr[] = { 3, 3, 2, 3 };
		int n = arr.length;
		System.out.println("The element with single occurrence is " + getSingle(arr, n));

	}

	private static int getSingle(int[] arr, int n) {
		int result = 0;

		for (int i = 0; i < n; i++) {
			result = result ^ arr[i];
		}

		return result;
	}

}
