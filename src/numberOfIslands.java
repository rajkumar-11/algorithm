
public class numberOfIslands {
	public static void main(String[] args) {
		int M[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		countInlands(M);

	}

	private static void countInlands(int[][] M) {
		boolean[][] visited = new boolean[5][5];

		int count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (visited[i][j] == false && M[i][j] == 1) {
					DFS(visited, i, j, M);
					count++;
				}

			}

		}

		System.out.println(count);

	}

	private static void DFS(boolean[][] visited, int row, int column, int[][] m) {

		visited[row][column] = true;
		int[] r = { -1, 1, 0, 0, 1, 1, -1, -1 };
		int[] c = { 0, 0, 1, -1, 1, -1, 1, -1 };

		for (int i = 0; i < 8; i++) {
			if (issafe(visited, row + r[i], column + c[i], m)) {
				DFS(visited, row + r[i], column + c[i], m);
			}
		}

	}

	private static boolean issafe(boolean[][] visited, int i, int j, int[][] m) {
		if (i >= 0 && i < 5 && j >= 0 && j < 5 && !visited[i][j] && m[i][j] == 1)
			return true;
		return false;

	}
}
