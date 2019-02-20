package DynamicProgramming;

public class BinomialCoefficientUsingDynamicProgramming {

	public static void main(String[] args) {
		int n = 10, k = 5;
		System.out.printf("Value of C(%d, %d) is %d ", n, k, binomialCoeff(n, k));
	}

	private static Object binomialCoeff(int n, int k) {
		int[][] value = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i,k); j++) {
				if (j == 0 || j == i)
					value[i][j] = 1;

				else
					value[i][j] = value[i - 1][j - 1] + value[i - 1][j];

			}

		}

		return value[n][k];
	}

}
