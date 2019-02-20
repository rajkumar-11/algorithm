package DynamicProgramming;

public class Knapsack01 {
	static int max = Integer.MIN_VALUE;

	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		if (n == 0 || w == 0)
			return 0;

		else if (wt[n - 1] > w)
			return knapSack(w, wt, val, n - 1);

		else
			return Math.max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1), knapSack(w, wt, val, n - 1));

	}

}
