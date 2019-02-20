import java.util.Scanner;

public class TheTwoWaterJugPuzzle {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int m = s.nextInt();
		int n = s.nextInt();
		int d = s.nextInt();

		int c1 = 0, c2 = 0;
		int y = 0, x = 0;
		while (y != d && x!=d) {
			// System.out.println("y= " + y + " d= " + d);
			if (x == 0) {
				x = m;
				c1++;
			} else if (x != 0)
			{
				y = (y + x);
				if((x+y-m)%n==d)
				{
					c1++;
					break;
				}
				
				x = 0;

				if (y >= n) {
					y = y % n;
					c1 = c1 + 3;
				} else {
					c1 = c1 + 1;
				}
			}
			System.out.println("here  "+ "x= " + x + " y= " + y + " c1= " + c1);

		}
		System.out.println(c1);

		x = 0;
		y = 0;
		while (x != d && y != d) {
			System.out.println("x= " + x + "y= " + y + "d= " + d);
			if (y == 0) {
				y = n;
				c2++;

			} else if (y != 0) {
				x = x + y;
				if ((x + y - m) % n == d) {
					c2=c2+3;
					break;
				}

				y = 0;
				if (x >= m) {
					x = x % m;
					c2 = c2 + 3;
				} else {

					c2 = c2 + 1;
				}

			}

		}
		System.out.println("c2= " + c2);

	}

}
