package BackTracking;

public class Sudoku {
	static int N = 9;

	public static void main(String[] args) {
		int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (SolveSudoku(grid) == true)
			printGrid(grid);
		else
			System.out.println("No solution possible");

	}

	private static void printGrid(int[][] grid) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean SolveSudoku(int[][] grid) {
		int row, col;

		int[] temp = findIndex(grid);

		if (temp != null) {
			row = temp[0];
			col = temp[1];

			// if (!findUnAssignedLocation(grid, row, col))
			// return true;
			// System.out.println("here" + "row= " + row + "col= " + col);
			for (int num = 1; num <= 9; num++) {
				// System.out.println("here" + "row= " + row + "col= " + col);
				if (isSafe(grid, row, col, num)) {
					grid[row][col] = num;

					if (SolveSudoku(grid))
						return true;
					grid[row][col] = 0;

				}

			}
		} else {
			return true;

		}

		return false;
	}

	private static int[] findIndex(int[][] grid) {
		int[] temp = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0) {
					temp[0] = i;
					temp[1] = j;
					return temp;

				}

			}
		}

		return null;
	}

	private static boolean isSafe(int[][] grid, int row, int col, int num) {
		return isSafeRow(grid, row, col, num) && isSafeColumn(grid, row, col, num)
				&& isSafeSquare(grid, row - row % 3, col - col % 3, num);

	}

	private static boolean isSafeSquare(int[][] grid, int row, int col, int num) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[row + i][col + j] == num)
					return false;

			}

		}

		return true;
	}

	private static boolean isSafeColumn(int[][] grid, int row, int col, int num) {
		for (int i = 0; i < N; i++) {
			if (grid[i][col] == num)
				return false;
		}

		return true;
	}

	private static boolean isSafeRow(int[][] grid, int row, int col, int num) {
		for (int i = 0; i < N; i++) {
			if (grid[row][i] == num)
				return false;

		}

		return true;
	}

	private static boolean findUnAssignedLocation(int[][] grid, int row, int col) {
		for (row = 0; row < N; row++) {
			for (col = 0; col < N; col++) {
				if (grid[row][col] == 0)
					return true;
			}
		}

		return false;
	}
}
