package BitAlgorithm;

import MathmaticalAlgorithms.Point;

public class IfTwoRectanglesOverlap {
	public static void main(String[] args) {

		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 10);

		if (doOverlap(l1, r1, l2, r2)) {
			System.out.println("Yes the rectangles overlaps");
		} else {
			System.out.println("No the rectangles do not overlaps");
		}

		// s

	}

	private static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

		if ((r1.x < l2.x) || (r2.x < l1.x))
			return true;

		if ((l2.y < r2.y) || (l1.y < r1.y))
			return true;

		return false;
	}

}

