package DynamicProgramming;

public class MaximumAs {
	public static void main(String[] args) {
		int N;

		for (N = 1; N <= 20; N++)
			System.out.println("Maximum Number of A's with keystrokes is " + N + "  is=" + findoptimal(N));

	}

	private static int findoptimal(int n) {

		if (n <= 6)
			return n;
		int[] value = new int[n + 1];
		value[1] = 1;
		value[2] = 2;
		value[3] = 3;
		value[4] = 4;
		value[5] = 5;
		value[6] = 6;

		for (int i = 7; i <= n; i++) {
			value[i] = Math.max(2 * value[i - 3], Math.max(3 * value[i - 4], 4 * value[i - 5]));

		}

		return value[n];
	}

}