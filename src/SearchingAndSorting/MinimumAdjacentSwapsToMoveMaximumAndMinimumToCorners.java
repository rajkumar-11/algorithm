package SearchingAndSorting;

public class MinimumAdjacentSwapsToMoveMaximumAndMinimumToCorners {
	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 3, 5, 5, 2 };
		int n = a.length;
		minimumSwaps(a, n);
	}

	private static void minimumSwaps(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int l = 0;
		int r = n - 1;

		for (int i = 0; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
				l = i;
			}
			if (a[i] < min) {
				min = a[i];
				r = i;

			}

		}
		if (l > r) {
			System.out.println("Minimum swaps required are " + (l + (n - 2 - r)));

		} else {
			System.out.println("Minimum swaps required are " + (l + (n - 1 - r)));

		}

	}

}
