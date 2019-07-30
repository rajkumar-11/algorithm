package Warrior;

import java.util.Scanner;

public class Diamond {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int h = s.nextInt();
			int w = s.nextInt();
			// System.out.println("here");
			long totalarea = h * w;
			int x = w / 2;
			int y = (w - 1) / 2;
			int z = (h - 2) / 2;

			long area = ((z + 1) / 4) * x + (z / x) * y;
			System.out.println(totalarea - area);

		}

	}

}
