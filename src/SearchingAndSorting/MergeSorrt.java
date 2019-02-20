package SearchingAndSorting;

public class MergeSorrt {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7,1,4,53,4 };

		System.out.println("Given Array");
		printArray(arr);

		mergesort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);

	}

	private static void mergesort(int[] arr, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			mergesort(arr, l, m);
			mergesort(arr, m + 1, r);

			merge(arr, l, m, r);

		}

	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		for (int i = 0; i < n1; i++) {
			arr1[i] = arr[l + i];

		}
		for (int i = 0; i < n2; i++) {
			arr2[i] = arr[m + 1 + i];

		}

		int i = 0;
		int j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
				k++;

			} else {
				arr[k] = arr2[j];
				j++;
				k++;

			}
		}

		while (i < n1) {
			arr[k] = arr1[i];
			i++;
			k++;

		}

		while (j < n2) {
			arr[k] = arr2[j];
			j++;
			k++;

		}

	}

	private static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
