package BackTracking;

public class RatInAMaze {
	public static int N = 4;

	public static void main(String[] args) {

		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		solveMaze(maze);

	}

	private static void solveMaze(int[][] maze) {
		int[][] solution = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (isThereAsolution(maze, 0, 0, solution) == false) {
			System.out.println("There is no path which the rat could take to reach destination :(");
			return;

		}

		System.out.println("Yes there is path which the rat could take to reach destination which willl be ");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();

		}

	}

	private static boolean isThereAsolution(int[][] maze, int i, int j, int[][] solution) {

		if (i == N - 1 && j == N - 1 && maze[i][j] == 1) {
			solution[i][j] = 1;
			return true;
		}

		if (isSafe(maze, i, j)) {
			solution[i][j] = 1;
			if (isThereAsolution(maze, i + 1, j, solution) || isThereAsolution(maze, i, j + 1, solution))
				return true;

			solution[i][j] = 0;

		}

		return false;
	}

	private static boolean isSafe(int[][] maze, int i, int j) {
		if (i >= 0 && i <= N - 1 && j >= 0 && j <= N - 1 && maze[i][j] == 1)
			return true;

		return false;
	}
}
