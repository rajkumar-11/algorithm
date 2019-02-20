package SearchingAndSorting;

public class SortAnArrayInWaveForm {
	public static void main(String[] args) {
		int arr[] = { 10, 90, 49, 2, 1, 5, 23 };
		int n = arr.length;
		sortInWave(arr, n);
		for (int i : arr)
			System.out.print(i + " ");

	}

	private static void sortInWave(int[] arr, int n) {

		for (int i = 1; i < n - 1; i = i + 2) {
			if (arr[i] > arr[i - 1]) {
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;

			}
		}

	}
}
