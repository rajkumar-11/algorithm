package SearchingAndSorting;

public class KthSmallestLargestElementInUnsortedArray {
	public static void main(String[] args) {

		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
		int n = arr.length, k = 4;
		System.out.println("K'th smallest element is " + kthSmallest(arr, 0, n - 1, k));

	}

	private static int kthSmallest(int[] arr, int l, int h, int k) {

		if (k>0 && h - l + 1 >= k) {
			int pos = randomPartition(arr, l, h);

			if (pos - l == k - 1)
				return arr[pos];

			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);

			return kthSmallest(arr, pos + 1, h, k - pos + l - 1);

		}

		return Integer.MAX_VALUE;
	}

	private static int randomPartition(int[] arr, int l, int h) 
	{
		int n = h - l + 1;

		int x = (int) Math.random() * (n - 1);

		swap(arr, l + x, h);

		return partition(arr, l, h);

	}

	private static int partition(int[] arr, int l, int r) {
		int x = arr[r];

		int i = l;

		for (int j = l; j <= r - 1; j++)
		{
			if (arr[j] <= x) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);

		return i;
	}

	private static void swap(int[] arr, int i, int h) {

		int temp = arr[i];
		arr[i] = arr[h];
		arr[h] = temp;

	}
}
