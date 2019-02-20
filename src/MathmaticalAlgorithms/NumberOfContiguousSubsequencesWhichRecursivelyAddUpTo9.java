package MathmaticalAlgorithms;

public class NumberOfContiguousSubsequencesWhichRecursivelyAddUpTo9 {
	public static void main(String[] args) {
		System.out.println(count9s("4189"));
		System.out.println(count9s("1809"));
	}

	private static int count9s(String number) {
		int count = 0;
		int n = number.length();

		for (int i = 0; i < n; i++) {
			int sum = number.charAt(i) - '0';

			if (number.charAt(i) == '9') {
				count++;
			}

			for (int j = i + 1; j < n; j++) {
				sum = (sum + number.charAt(j) - '0') % 9;

				if (sum == 0)
					count++;

			}

		}

		return count;
	}
}
