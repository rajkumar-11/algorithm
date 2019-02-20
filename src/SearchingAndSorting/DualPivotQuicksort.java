package SearchingAndSorting;

public class DualPivotQuicksort {
	public static void main(String[] args) {
		int arr[] = { 24, 8, 42, 75, 29, 77, 38, 57 };
		printArray(arr);

		System.out.println("After sorting using dual pivot quick sort");

		sort(arr, 0, arr.length - 1);

		printArray(arr);

	}

	private static void sort(int[] arr, int l, int h) {
		if (l < h) {
			int[] temps = Partition(arr, l, h);

			int x = temps[0];
			int y = temps[1];

			sort(arr, l, x - 1);
			sort(arr, x + 1, y - 1);
			sort(arr, y + 1, h);

		}

	}

	private static int[] Partition(int[] arr, int l, int h) {
		if (arr[l] > arr[h]) {
			swap(arr, l, h);
		}
		int k = l + 1;

		int p = arr[l];
		int q = arr[h];

		int g = h - 1;
		int j = l + 1;
		while (k <= g) {
			if (arr[k] < p) {
				swap(arr, j, k);
				j++;
			}

			if (arr[k] >= q) {

				while (arr[g] > q && k < g)
					g--;

				swap(arr, g, k);
				g--;
				if (arr[k] < p) {
					swap(arr, j, k);
					j++;
				}

			}

			k++;
		}
		j--;
		g++;

		swap(arr, j, l);
		swap(arr, g, h);
		int[] temparr = { j, g };

		return temparr;
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
