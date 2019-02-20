package DynamicProgramming;

public class MinCostUsingDp {
	public static int INF = Integer.MAX_VALUE, N = 4;

	public static void main(String[] args) {
		int cost[][] = { { 0, 15, 80, 90 }, { INF, 0, 40, 50 }, { INF, INF, 0, 70 }, { INF, INF, INF, 0 } };
		System.out.println("The Minimum cost to reach station " + N + " is " + minCost(cost));

	}

	private static int minCost(int[][] cost) {
		int min = Integer.MAX_VALUE;

		int[] value = new int[N];

		for (int i = 0; i < N; i++) {
			value[i] = INF;
		}
		value[0] = 0;

		for (int i = 0; i < N; i++) {
			int min_value = value[i];
			for (int j = i + 1; j < N; j++) {
				if (value[i] + cost[i][j] < value[j])
					value[j] = value[i] + cost[i][j];

			}
			// value[]

		}

		for (int i = 0; i < N; i++) {
			System.out.println(value[i]);
		}

		return 0;
	}

}
