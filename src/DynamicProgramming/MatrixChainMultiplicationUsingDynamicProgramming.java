package DynamicProgramming;

public class MatrixChainMultiplicationUsingDynamicProgramming {
	public static void main(String[] args) {
		int arr[] = new int[] { 40, 20, 30, 10, 30 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));

	}

	private static int MatrixChainOrder(int[] arr, int n) {
		int[][] value = new int[n][n];

		for (int i = 1; i < n; i++) {
			value[i][i] = 0;
		}
		int temp;

		int[][] bracket = new int[n][n];

		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				value[i][j] = Integer.MAX_VALUE;

				for (int k = i; k <= j - 1; k++) {
					temp = value[i][k] + value[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

					// System.out.println("temp= " + temp);

					if (temp < value[i][j]) {
						value[i][j] = temp;
						bracket[i][j] = k;
					}
				}

			}

		}
		char name = 'A';

		System.out.print("Optimal Parenthesization is: ");
		printParentheis(1, n - 1, bracket, name);
		System.out.println();

		return value[1][n - 1];
	}

	private static void printParentheis(int i, int j, int[][] bracket, char name) {

		if (i == j) {
			System.out.print(name);
			name = name++;
			return;
		}
		System.out.print("(");

		printParentheis(i, bracket[i][j], bracket, name);

		printParentheis(bracket[i][j] + 1, j, bracket, name);

		System.out.print(")");

	}

}
