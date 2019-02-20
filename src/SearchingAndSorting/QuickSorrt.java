package SearchingAndSorting;

public class QuickSorrt {
	public static void main(String[] args) {

		int arr[] = { 10, 7, 8, 9, 1, 5, 0, 4, 12, 43, 1 };
		int n = arr.length;
		printArray(arr);

		sort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	private static void sort(int[] arr, int l, int r) {
		// System.out.println("l= " + l + " r= " + r);

		if (l < r) {
			int p = sortUtils(arr, l, r);
			sort(arr, l, p - 1);
			sort(arr, p + 1, r);

		}
	}

	private static int sortUtils(int[] arr, int l, int r) {

		// System.out.println("ll= " + l + " rr= " + r);
		if (r <= l)
			return l;
		int pivot = arr[r];
		int x = l;

		for (int i = l; i <= r - 1; i++) {
			if (arr[i] < arr[r]) {
				int temp = arr[i];
				arr[i] = arr[x];
				arr[x] = temp;
				x++;

			}

		}
		int temp = arr[r];
		arr[r] = arr[x];
		arr[x] = temp;

		return x;

	}

}
