package DynamicProgramming;

public class KnapSack01UsingDP {
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {

		int[][] value = new int[n + 1][w + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0)
					value[i][j] = 0;
				else if (wt[i - 1] <= j)
					value[i][j] = Math.max((val[i - 1] + value[i - 1][j - wt[i - 1]]), value[i - 1][j]);
				else
					value[i][j] = value[i - 1][j];

			}

		}

		return value[n][w];
	}

}
