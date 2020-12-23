import java.util.Scanner;

public class TheTwoWaterJugPuzzleGeeks {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int m = s.nextInt();
		int n = s.nextInt();
		int d = s.nextInt();

		System.out.println(minimumSteps(m, n, d));

	}

	private static int minimumSteps(int m, int n, int d) {

		if (d % gcdab(m, n) != 0)
			return -1;

		return (Math.min(minimumstepsrequired(m, n, d), minimumstepsrequired(n, m, d)));

	}

	private static int minimumstepsrequired(int m, int n, int d) {

		int x = m;
		int steps = 1;
		int y = 0;
		while (x != d && y != d) 
		{
//			System.out.println("here");
			int min = Math.min(x, n - y);

			x = x - min;
			y = y + min;

//			System.out.println("x= " + x + " y= " + y + " min=" + min+" d== "+d);

			steps++;

			if ((x == d) ||( y == d))
			{	
//				System.out.println("ande");
				break;
			}

			if (x == 0) {
				x = m;
				steps++;
			}
			if (y == n) {
				y = 0;
				steps++;
			}

		}

//		System.out.println("jai shree ram");
		return steps;
	}

	private static int gcdab(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcdab(b, a % b);
	}
}
