package SearchingAndSorting;

public class SortnNumbersInRangeFrom0ToN2InLinearTime {
	public static void main(String[] args) {

		// Since array size is 7, elements should be from 0 to 48
		int arr[] = { 40, 12, 45, 32, 33, 1, 22 };
		int n = arr.length;
		System.out.println("Given array");
		printArr(arr, n);

		sort(arr, n);

		System.out.println("Sorted array");
		printArr(arr, n);

	}

	private static void sort(int[] arr, int n) {
		CountingSort(arr, n, 1);

		CountingSort(arr, n, n);

	}

	private static void CountingSort(int[] arr, int n, int exp) {
		int[] output = new int[n];

		int[] count = new int[n];

		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (int i = 1; i < n; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;

		}
		for (int i = 0; i < n; i++)
			arr[i] = output[i];

	}

	private static void printArr(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

}
