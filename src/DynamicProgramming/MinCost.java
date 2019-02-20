package DynamicProgramming;

public class MinCost {
	public static int INF = Integer.MAX_VALUE, N = 4;

	static int min_answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int cost[][] = { { 0, 15, 80, 90 }, { INF, 0, 40, 50 }, { INF, INF, 0, 70 }, { INF, INF, INF, 0 } };
		minCost(cost, 0, 0, N - 1);

		System.out.println("The Minimum cost to reach station " + N + " is " + min_answer);

	}

	private static int minCost(int[][] cost, int value, int src, int dest) {
		int min = Integer.MAX_VALUE;

		System.out.println(dest + " " + src);

		if (src == N - 1) {
			// System.out.println("value= "+value);
			if (value < min_answer) {
				min_answer = value;
			}
		}

		for (int i = src + 1; i < N; i++) {

			minCost(cost, value + cost[src][i], i, dest);
		}

		return 0;
	}

}
