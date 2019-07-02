import java.math.BigInteger;
import java.util.Scanner;

public class BinaryMadness {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int x = s.nextInt();
		// System.out.println("x= "+ x);

		for (int i = 0; i < x; i++) {
			BigInteger b = s.nextBigInteger();

			String string = convertToBinaryString(b);
			// System.out.println(string);
			// System.out.println("rajkumar");
			int count = 0;
			int[] arr = new int[string.length()];

			int n = string.length();
			for (int j = 0; j < n; j++) {
				if (string.charAt(j) == '1') {
					arr[j] = 1;
				}

			}

			for (int j = 1; j <= n; j++) {
				int tempcount = 0;

				for (int a = 0; a < j; a++) {
					if (arr[a] == 1) {
						tempcount++;
					}
				}
				if (tempcount % 2 != 0) {
					count++;
				}

				for (int k = j; k < n; k++) {
					if (arr[k - j] == 1) {
						tempcount--;
					}
					if (arr[k] == 1) {
						tempcount++;
					}
					if (tempcount % 2 != 0) {
						count++;
					}

				}

			}
			System.out.println(count);

		}

	}

	private static String convertToBinaryString(BigInteger b) {

		String string = "";

		BigInteger a = new BigInteger("2");

		while (b.compareTo(BigInteger.ZERO) > 0) {
			BigInteger y = b.mod(a);
			string = y + string;
			b = b.divide(a);
		}

		return string;
	}
}
