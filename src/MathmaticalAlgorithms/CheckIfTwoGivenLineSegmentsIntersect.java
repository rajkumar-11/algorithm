package MathmaticalAlgorithms;

public class CheckIfTwoGivenLineSegmentsIntersect {
	public static void main(String[] args) {
		Point p1 = new Point(10, 0);
		Point q1 = new Point(0, 10);
		Point p2 = new Point(0, 0);
		Point q2 = new Point(10, 10);

		if (doIntersect(p1, q1, p2, q2)) {
			System.out.println("YES");
		} else {
			System.out.println("No");
		}

	}

	private static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		if (o1 != o2 && o3 != o4)
			return true;
		
		 if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
		  
		    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
		    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
		  
		    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
		    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
		  
		     // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
		    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
		
		
		

		return false;
	}

	private static boolean onSegment(Point p, Point q, Point r) 
	{
	 if(q.x<=max(p.x,r.x)&& q.x>=min(p.x,r.x)&& q.y<=max(p.y,r.y)&& q.y>=min(p.y,r.y))
	 {
		return true; 
		 
	 }
		
		
		return false;
	}

	private static int max(int x, int y) {
		
		return x>y?x:y;
	}

	private static int min(int x, int y) 
	{
	
		return x>y?y:x;
	}

	private static int orientation(Point p1, Point p2, Point p3)
	{

		int val= ((p3.x-p2.x)*(p2.y-p1.y))- ((p2.x-p1.x)*(p3.y-p2.y));
		
		if(val==0)
			return 0;
		
		return (val>0)?1:2;
		
	}
}
