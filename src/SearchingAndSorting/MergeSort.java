package SearchingAndSorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		mergesort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);

	}

	private static void mergesort(int[] arr, int l, int r) {
		if (r <= l)
			return;

		int m = l + (r - l) / 2;

		mergesort(arr, l, m);
		mergesort(arr, m + 1, r);

		// System.out.println("jais shree ram");

		merge(arr, l, m, r);

	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		System.out.println("n1= " + n1 + " n2= " + n2);

		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		for (int i = 0; i < n1; i++) {
			arr1[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			arr2[j] = arr[m + 1 + j];

		}

		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				k++;
				i++;

			} else if (arr1[i] > arr2[j]) {
				arr[k] = arr2[j];
				k++;
				j++;

			}

		}
		while (i < n1) {
			arr[k] = arr1[i];
			k++;
			i++;

		}
		while (j < n2) {
			arr[k] = arr2[j];
			k++;
			j++;

		}

	}

	private static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");

		}

	}

}
