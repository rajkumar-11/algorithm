package DynamicProgramming;

public class LongestCommonSubsequenceUsingPatienceSorting {
	public static void main(String[] args) {
		int A[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int n = A.length;
		System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A, n));

	}

	private static int LongestIncreasingSubsequenceLength(int[] A, int n) {
		int[] tailTable = new int[n];
		int len; // always points empty slot

		tailTable[0] = A[0];
		len = 1;

		for (int i = 1; i < n; i++) {
			if (A[i] < tailTable[0])
				tailTable[0] = A[i];

			else if (A[i] > tailTable[len - 1]) {
				tailTable[len++] = A[i];

			}

			else {
				tailTable[ceil(0, len - 1, tailTable, A[i])] = A[i];

			}

		}

		for (int i = 0; i < len; i++)
			System.out.print(tailTable[i] + " ");
		System.out.println();

		return len;
	}

	private static int ceil(int l, int r, int[] tailTable, int value) {
//		System.out.println("here l= " + l + " r= " + r + " A[i]= " + value);

		while (l<r) {
//			System.out.println("arsenal l=" + l + "  r=" + r);

			int m = l + (r - l) / 2;

			if (tailTable[m] >= value) {
				r = m;

			} else {
				l = m+1;

			}
			// System.out.println("jai");

		}
		return r;
	}
}