package DynamicProgramming;

public class MobileNumeriKeypad {
	public static void main(String[] args) {
		char keypad[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };

		System.out.println("Count for number of length " + 5 + " is =" + getCount(keypad, 5));
	}

	private static int getCount(char[][] keypad, int n) {
		int finalcount = 0;

		for (int i = 1; i <= 9; i++) {
			int x = (i - 1) / 3;
			int y = (i - 1) % 3;

			finalcount += getCountUtil(keypad, x, y, 1, n);
			System.out.println("finalcount= " + finalcount + " x= " + x + "y= " + y);

		}
		finalcount += getCountUtil(keypad, 3, 1, 1, n);
		System.out.println("finalcount= " + finalcount + " x= " + 3 + " y= " + 1);

		return finalcount;
	}

	private static int getCountUtil(char[][] keypad, int i, int j, int count, int n) {
		if (isInValid(i, j)) {
			return 0;
		}
		if (count == n) {
			// System.out.println("i= " + i + " j= " + j);

			return 1;
		}
		return getCountUtil(keypad, i, j, count + 1, n) + getCountUtil(keypad, i + 1, j, count + 1, n)
				+ getCountUtil(keypad, i, j + 1, count + 1, n) + getCountUtil(keypad, i - 1, j, count + 1, n)
				+ getCountUtil(keypad, i, j - 1, count + 1, n);

		// return 0;

	}

	private static boolean isInValid(int i, int j) {
		if (i < 0 || i >= 4 || j < 0 || j >= 3 || (i == 3 && j == 0) || (i == 3 && j == 2))
			return true;

		return false;
	}
}
