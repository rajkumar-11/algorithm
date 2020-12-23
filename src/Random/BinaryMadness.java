import java.math.BigInteger;
import java.util.Scanner;

public class BinaryMadness {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int countOddZero = 0;
			int countOddOne = 0;
			BigInteger x = s.nextBigInteger();
			String string = getStringFromBigInteger(x);
			int n = string.length();
			if (n == 0) {
				System.out.println(1 + " " + 0);
			} else {
				for (int j = 0; j < n; j++) {
					int tempCountOddZero = 0;
					int tempcountOddOne = 0;
					for (int k = j; k < n; k++) {
						if (string.charAt(k) == '0') {
							tempCountOddZero++;

						} else {
							tempcountOddOne++;
						}
						if (tempcountOddOne % 2 != 0) {
							countOddOne++;

						}
						if (tempCountOddZero % 2 != 0) {
							countOddZero++;
						}

					}

				}
				System.out.println(countOddZero + " " + countOddOne);

			}

		}

	}

	private static String getStringFromBigInteger(BigInteger x) {
		String s = "";
		BigInteger two = new BigInteger("2");

		while (x.compareTo(BigInteger.ZERO) > 0) {
			s = x.mod(two) + s;
			x = x.divide(two);

		}

		return s;
	}

}
