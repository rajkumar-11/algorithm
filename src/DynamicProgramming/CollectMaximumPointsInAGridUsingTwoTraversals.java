package DynamicProgramming;

public class CollectMaximumPointsInAGridUsingTwoTraversals {
	static int R = 5;
	static int C = 4;

	public static void main(String[] args) {
		int[][] arr = { { 3, 6, 8, 2 }, { 5, 2, 4, 3 }, { 1, 1, 20, 10 }, { 1, 1, 20, 10 }, { 1, 1, 20, 10 }, };

		System.out.println("Maximum collection is " + getMaxCollection(arr));

	}

	private static int getMaxCollection(int[][] arr) {
		int[][][] value = new int[R][C][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < C; k++) {
					value[i][j][k] = -1;

				}

			}

		}

		return getMaxUtil(arr, value, 0, 0, C - 1);

	}

	private static int getMaxUtil(int[][] arr, int[][][] value, int x, int y1, int y2) {
		if (x >= R || y1 >= C || y2 >= C || y1 < 0 || y2 < 0)
			return Integer.MIN_VALUE;

		if (x == R - 1 && y1 == 0 && y2 == C - 1)
			return y1 == y2 ? arr[x][y1] : arr[x][y1] + arr[x][y2];

		if (x == R - 1)
			return Integer.MAX_VALUE;

		if (value[x][y1][y2] != -1)
			return value[x][y1][y2];

		int ans = Integer.MIN_VALUE;

		int temp = (y1 == y2) ? arr[x][y1] : arr[x][y1] + arr[x][y2];

		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1 + 1, y2 + 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1 + 1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1 + 1, y2));

		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1 - 1, y2 + 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1 - 1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1 - 1, y2));

		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1, y2 + 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, value, x + 1, y1, y2));

		return (value[x][y1][y2] = ans);
	}
}
