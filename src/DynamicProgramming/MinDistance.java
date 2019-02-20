package DynamicProgramming;

public class MinDistance {

	static int N = 3;

	public static void main(String args[]) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 0, 0, 2, 2));
	}

	private static int minCost(int[][] cost, int x, int y, int a, int b) {
		int[][] temp = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || j == 0)
					temp[i][j] = 0;
				else
					temp[i][j] = cost[i - 1][j - 1]
							+ Math.min(Math.min(temp[i + 1][j], temp[i][j + 1]), temp[i + 1][j + 1]);

			}

		}

		return temp[a][b];
	}

}
