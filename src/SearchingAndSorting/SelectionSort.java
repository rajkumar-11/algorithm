package SearchingAndSorting;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = {13, 34, 25, 12, 12, 11, 90 };
		selectionsort(arr);
		System.out.println("Sorted array");

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void selectionsort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < min) {
					min = arr[j];
					index = j;

				}

			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;

			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();

		}

	}
}
