package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MinimumInitialPointsDestination {
	public static void main(String[] args) {
		int points[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int R = 3, C = 3;

		System.out.println("Minimum Initial Points Required: " + minInitialPoints(points, R, C));

	}

	private static int minInitialPoints(int[][] points, int r, int c) {

		List<Integer> list = new ArrayList<>();

		int min = Integer.MAX_VALUE, sum = 0;

		minInitialPointsUtil(points, 0, 0, r, c, list, sum, min);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		return 0;
	}

	private static void minInitialPointsUtil(int[][] points, int i, int j, int R, int C, List<Integer> list, int sum,
			int min) {

		// System.out.println("i= " + i + " j= " + j+" R= "+R+" C= "+C);
		if (i < 0 || i >= R || j < 0 || j >= C) {
			return;

		}

		// System.out.println("here");
		if (i == R - 1 && j == C - 1) {
			// System.out.println("here 222 ");
			if (sum + points[i][j] < min)
				min = points[i][j] + sum;

			list.add(min);
			return;

		}

		if (sum + points[i][j] < min)
			min = points[i][j] + sum;

		minInitialPointsUtil(points, i + 1, j, R, C, list, sum + points[i][j], min);
		minInitialPointsUtil(points, i, j + 1, R, C, list, sum + points[i][j], min);
		return;
	}

}
