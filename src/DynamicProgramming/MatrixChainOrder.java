package DynamicProgramming;

class MatrixChainMultiplication {
	static int MatrixChainOrder(int p[], int i, int j) {
		int min = Integer.MAX_VALUE;

		if (i == j)
			return 0;
		// int count=0;
		for (int w = i; w < j; w++) {
			int count = MatrixChainOrder(p, i, w) + MatrixChainOrder(p, w + 1, j) + p[i - 1] * p[j] * p[w];

			if (count < min)
				min = count;

		}

		return min;
	}

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3, 4, 3 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));

	}
}