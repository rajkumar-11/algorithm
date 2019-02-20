package SearchingAndSorting;

public class KClosestElements {
	public static void main(String[] args) {
		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int n = arr.length;
		int x = 35, k = 4;
		printKclosest(arr, x, 4, n);

	}

	private static void printKclosest(int[] arr, int x, int k, int n) {

		if (k > n) {
			System.out.println("Not possible");
			return;
		}

		int l = findCrossOver(arr, x, 0, n - 1);

		int r = l + 1;

		System.out.println("l= " + l);

		if (arr[l] == x) {
			l--;
		}

		int count = 0;

		while (l >= 0 && r < n && count <= k) {
			if (x - arr[l] < arr[r] - x) {
				System.out.print(arr[l--] + " ");
			} else {
				System.out.print(arr[r++] + " ");

			}
			count++;
		}

		if (l < 0) {
			while (count <= k && r < n) {
				System.out.print(arr[r++] + " ");
				count++;
			}
		}
		if (r > -n) {
			while (count <= k && l >= 0) {
				System.out.print(arr[l--] + " ");
				count++;
			}
		}
		// if(count<k)
		// {
		// System.out.println("There are less number of ");
		// }

	}

	private static int findCrossOver(int[] arr, int x, int l, int h) {
		if (arr[l] > x)
			return l;

		if (arr[h] <= x)
			return h;

		int mid = (l + h) / 2;

		if (arr[mid] <= x && arr[mid + 1] > x)
			return mid;

		if (arr[mid] < x)
			return findCrossOver(arr, x, mid + 1, h);

		return findCrossOver(arr, x, l, mid - 1);
	}
}
