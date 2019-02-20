package SearchingAndSorting;

public class BinaryInsertionSort {
	public static void main(String[] args) {

		final int[] arr = { 37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54 };

		sort(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

	private static void sort(int[] arr)
	{
		for (int i = 1; i < arr.length; ++i) 
		{
			int j = i - 1;
			int selected = arr[i];
			int index = binarySearch(arr, arr[i], 0, j);

			while (j >= index) 
			{
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = selected;
		}

	}

	private static int binarySearch(int[] arr, int x, int l, int h) 
	{
		if (h <= l) {
			return (x > arr[l]) ? (l + 1) : l;

		}

		int m = l + (h - l) / 2;

		if (x == arr[m]) {
			return m + 1;
		}

		if (x > arr[m]) {
			return binarySearch(arr, x, m + 1, h);
		}

		return binarySearch(arr, x, l, m - 1);
	}
}
