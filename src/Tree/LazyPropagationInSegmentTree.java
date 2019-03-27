package Tree;

import java.util.Arrays;

public class LazyPropagationInSegmentTree {

	static int st[];

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		LazyPropagationInSegmentTree tree = new LazyPropagationInSegmentTree(arr, n);

		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));

		tree.updateValue(arr, n, 1, 3, 20);
		System.out.println("After updating the array");

		System.out.println(Arrays.toString(st));

		System.out.println();

		System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));

	}

	private void updateValue(int[] arr, int n, int us, int ue, int new_val) {
		if (us < 0 || ue >= n - 1 || ue < 0 || us >= n - 1) {
			System.out.println("invalid input");
			return;
		}

		for (int i = us; i <= ue; i++) {
			int diff = new_val - arr[i];
			arr[i] = new_val;
			updateValueUtil(0, n - 1, i, diff, 0);
		}
	}

	private void updateValueUtil(int ss, int se, int i, int diff, int si) {

		if (i < ss || i > se)
			return;

		st[si] += diff;

		if (ss != se) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);

		}
	}

	private int getSum(int n, int qs, int qe) {

		if (qs < 0 || qe > n - 1 || qs > qe)
			return -1;

		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	private int getSumUtil(int ss, int se, int qs, int qe, int si) {
		if (qs <= ss && qe >= se)
			return st[si];

		if (se < qs || ss > qe)
			return 0;

		int mid = getMid(ss, se);
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	}

	public LazyPropagationInSegmentTree(int[] arr, int n) {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int size = (2 * (int) Math.pow(2, x)) - 1;
		// System.out.println("size= "+size);
		st = new int[size];
		contructSUtil(arr, 0, n - 1, 0);
		System.out.println(Arrays.toString(st));

	}

	int contructSUtil(int[] arr, int ss, int se, int si) {
		// System.out.println("si= " + si);
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		int mid = getMid(ss, se);
		// System.out.println("mid= " + mid + " ss= " + ss + " se " + se + " si=
		// " + si);
		st[si] = contructSUtil(arr, ss, mid, si * 2 + 1) + contructSUtil(arr, mid + 1, se, si * 2 + 2);
		return st[si];

	}

	private int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

}
