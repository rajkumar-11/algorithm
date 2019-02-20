package SearchingAndSorting;

public class FindTheClosestPairFromTwoSortedArrays {
	public static void main(String[] args) {
		int ar1[] = { 1, 1, 7, 15 };
		int ar2[] = { 1, 1, 1, 1, 8 };
		int m = ar1.length;
		int n = ar2.length;
		int x = 15;
		printClosest(ar1, ar2, m, n, x);
	}

	private static void printClosest(int[] arr1, int[] arr2, int m, int n, int x) {

		int l = 0;
		int r = n - 1;

		// int result = Integer.MAX_VALUE;

		int l_res = 0, r_res = 0;

		int diff = Integer.MAX_VALUE;

		while (l < m && r >= 0) {
			if (Math.abs(arr1[l] + arr2[r] - x) < diff) {

				l_res = l;
				r_res = r;
				diff = Math.abs(arr1[l] + arr2[r] - x);

			}

			if (arr1[l] + arr2[r] > x) {
				r--;
			} else {
				l++;
			}

		}

		System.out.print("The closest pair is [" + arr1[l_res] + ", " + arr2[r_res] + "]");

	}

}
