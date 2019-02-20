package MathmaticalAlgorithms;

import java.util.Arrays;

public class addTwNumbersInBase14 {
	public static void main(String[] args) {
		String s1 = "12A";
		String s2 = "CD3";

		char[] num1 = s1.toCharArray();
		char[] num2 = s2.toCharArray();

		System.out.println("the result is " + sumBase14(num1, num2));

	}

	private static String sumBase14(char[] num1, char[] num2)
	{
		int n = num1.length;

		char[] result = new char[n + 1];

		Arrays.fill(result, '0');

		for (int i = n - 1; i >= 0; i--)
          {
			int x = getValue(num1[i]);
			int y = getValue(num2[i]);
			System.out.println("x= " + x + " y= " + y);

			// System.out.println("Integer.valueOf(result[i+1]-48=
			// "+Integer.valueOf(result[i+1]-48));

			int z = x + y;
			if (z + Integer.valueOf(result[i + 1] - 48) < 14) {
				System.out.println("value =" + (z + Integer.valueOf(result[i + 1] - 48)));
				result[i + 1] = getCharacter(z + Integer.valueOf(result[i + 1] - 48));

			} else {
				System.out.println("value2 =" + (z + Integer.valueOf(result[i + 1] - 48)));
				result[i + 1] = getCharacter((z + Integer.valueOf(result[i + 1] - 48)) - 14);
				result[i] = '1';

			}

			System.out.println("result =" + String.valueOf(result));
			//

		}

		System.out.println("result =" + String.valueOf(result));
		if (result[0] == '0') {
//			System.out.println("here");
			return String.valueOf(result,1,n);

		} else {
			return String.valueOf(result, 0, n+1);
		}

		// return null;
	}

	private static char getCharacter(int n) {
		System.out.println("n= " + n);
		if (n >= 0 && n <= 9) {
			char x = (char) ('0' + (n));
//			System.out.println("x= " + x);
			return x;
		}

		char y = (char) (64 + (n - 9));
		System.out.println("y= " + y);
		return y;
	}

	private static int getValue(char c) {
		if (c >= '0' && c <= '9')
			return Integer.valueOf(c) - '0';

		return c - 'A' + 10;
	}

}
