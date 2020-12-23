import java.util.Arrays;
import java.util.Scanner;

public class pathsBetweenTwoVertices {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String x = sc.next();
			String palindrome = Palindrome(x);
			int[] count = new int[10];

			for (int j = 0; j < palindrome.length(); j++) {
				count[palindrome.charAt(j) - 48]++;
			}
			// System.out.println(Arrays.toString(count));

			int index = 0;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < 9; j++) {
				if (count[j] > max) {
					max = count[j];
					index = j;
				}

			}
			System.out.println(index);

		}

	}

	private static String Palindrome(String x) {
		String result = x;
		for (int j = x.length() - 1; j >= 0; j--) {
			result += x.charAt(j);
		}
		return result;
	}

}
