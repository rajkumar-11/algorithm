package Tree;

import java.util.Arrays;

public class SegmentTreeRangeMinimumQuery {
	static int[] st;

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 7, 9, 11 };
		int n = arr.length;
		SegmentTreeRangeMinimumQuery tree = new SegmentTreeRangeMinimumQuery();
		tree.constructST(arr, n);
		System.out.println(Arrays.toString(st));

		int qs = 1;
		int qe = 5;

		System.out.println("Minimum of values in range [" + qs + ", " + qe + "] is = " + tree.RMQ(n, qs, qe));

	}

	private int RMQ(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1)
			return Integer.MAX_VALUE;

		return RMQUtil(0, n - 1, qs, qe, 0);
	}

	private int RMQUtil(int ss, int se, int qs, int qe, int si) {
		if (qs <= ss && se <= qe)
			return st[si];

		if (qe < ss || qs > se)
			return Integer.MAX_VALUE;

		int mid = getMid(ss, se);

		return Math.min(RMQUtil(ss, mid, qs, qe, 2 * si + 1), RMQUtil(mid + 1, se, qs, qe, 2 * si + 2));
	}

	private void constructST(int[] arr, int n) {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int size = (2 * (int) Math.pow(2, x)) - 1;
		System.out.println("size =" + size);
		st = new int[13];

		constructSTTUtil(arr, 0, n - 1, 0);

	}

	private int constructSTTUtil(int[] arr, int ss, int se, int si) {
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
		int mid = getMid(ss, se);

		st[si] = Math.min(constructSTTUtil(arr, ss, mid, 2 * si + 1), constructSTTUtil(arr, mid + 1, se, 2 * si + 2));
		return st[si];
	}

	private int getMid(int s, int e) {
		return s + (e - s) / 2;
	}
}
