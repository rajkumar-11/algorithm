package DynamicProgramming;

public class MinimumCostPolygonTriangulation {
	public static void main(String[] args) {
		Point points[] = new Point[5];

		points[0] = new Point(0, 0);
		points[1] = new Point(1, 0);
		points[2] = new Point(2, 1);
		points[3] = new Point(1, 2);
		points[4] = new Point(0, 2);

		System.out.println(mTC(points, 0, 4));

	}

	private static double mTC(Point[] points, int i, int j) {
		if (j < i + 2)
			return 0;

		double res = Integer.MAX_VALUE;

		for (int k = i + 1; k < j; k++) {
			res = Math.min(res, (mTC(points, i, k) + mTC(points, k, j) + cost(points, i, k, j)));
		}

		return res;
	}

	private static double cost(Point[] points, int i, int k, int j) {

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

class Point {
	int x, y;

	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}

}