package SearchingAndSorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 35, 34, 25, 12, 12, 11, 90 };
		insertionSort(arr);
		System.out.println("Sorted array");

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n - 1; i++) {

			int x = arr[i];

			int j = i - 1;

			while (j >= 0 && arr[j] > x) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = x;

			for (int b = 0; b <= i; b++) 
			{
				System.out.print(arr[b] + " ");
			}
			System.out.println();

		}

	}
}
