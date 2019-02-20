package DynamicProgramming;

public class MinimumCostPolygonTriangulationUsingDP {
	public static void main(String[] args) {
		Point points[] = new Point[5];

		points[0] = new Point(0, 0);
		points[1] = new Point(1, 0);
		points[2] = new Point(2, 1);
		points[3] = new Point(1, 2);
		points[4] = new Point(0, 2);

		System.out.println(mTC(points, 5));

	}

	private static double mTC(Point[] points, int n) {
		if (n < 3)
			return 0;
		double[][] dp = new double[n][n];

		for (int gap = 2; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {
				dp[i][j] = Integer.MAX_VALUE;

				for (int k = i + 1; k < j; k++) {
					double temp = dp[i][k] + dp[k][j] + cost(points, i, j, k);

					if (temp < dp[i][j]) {
						dp[i][j] = temp;
					}
				}

			}

		}

		return dp[0][n - 1];
	}

	private static double cost(Point[] points, int i, int j, int k) {
		Point p1 = points[i];
		Point p2 = points[k];
		Point p3 = points[j];

		return dist(p1, p2) + dist(p2, p3) + dist(p3, p1);
	}

	private static double dist(Point p1, Point p2) {
		int x = p1.x - p2.x;
		int y = p1.y - p2.y;

		return Math.sqrt(x * x + y * y);
	}

}
