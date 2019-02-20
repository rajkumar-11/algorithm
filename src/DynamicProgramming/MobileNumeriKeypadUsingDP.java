package DynamicProgramming;

import java.util.Arrays;

public class MobileNumeriKeypadUsingDP {
	public static void main(String[] args) {

		char keypad[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };

		System.out.println("Count for number of length " + 5 + " is =" + getCount(keypad, 5));

	}

	private static int getCount(char[][] keypad, int n) {
		int[] values = new int[12];
		int[] valuesCopy = new int[12];

		int[] x = { 0, 1, -1, 0, 0 };
		int[] y = { 0, 0, 0, 1, -1 };

		if (n < 1)
			return 0;

		if (n == 1)
			return 10;

		for (int i = 1; i <= 11; i++) {
			values[i] = 1;
			valuesCopy[i] = 1;

		}

		for (int z = 2; z <= n; z++) {
			for (int i = 1; i <= 9; i++) {
				int a = (i - 1) / 3;
				int b = (i - 1) % 3;

				values[i] = valuesCopy[i];

				if (!isInValid(a + 1, b)) {
					System.out.println("x=" + (a + 1) + " y= " + b + " i= " + i);
					values[i] += valuesCopy[i + 3];
				}
				if (!isInValid(a, b + 1)) {
					values[i] += valuesCopy[i + 1];

				}
				if (!isInValid(a, b - 1)) {
					values[i] += valuesCopy[i - 1];
				}
				if (!isInValid(a - 1, b)) {
					values[i] += valuesCopy[i - 3];
				}

			}
			values[11] = valuesCopy[11];
			values[11] += valuesCopy[8];

			// valuesCopy = values;

			for (int i = 0; i < 12; i++) {
				valuesCopy[i] = values[i];
			}

			Arrays.fill(values, 0);

		}

		for (int i = 0; i < 10; i++) {
			System.out.print(valuesCopy[i] + " ");
		}
		return valuesCopy[1] + valuesCopy[2] + valuesCopy[3] + valuesCopy[4] + valuesCopy[5] + valuesCopy[6]
				+ valuesCopy[7] + valuesCopy[8] + valuesCopy[9] + valuesCopy[11];
	}

	private static boolean isInValid(int i, int j) {
		if (i < 0 || i >= 4 || j < 0 || j >= 3 || (i == 3 && j == 0) || (i == 3 && j == 2))
			return true;

		return false;
	}

}
