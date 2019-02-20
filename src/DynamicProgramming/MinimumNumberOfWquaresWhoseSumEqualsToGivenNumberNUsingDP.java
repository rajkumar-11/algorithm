package DynamicProgramming;

import java.util.Arrays;

public class MinimumNumberOfWquaresWhoseSumEqualsToGivenNumberNUsingDP {
	public static void main(String[] args) {
		System.out.println("Minimum number is squares required for n=" + 32 + "  is " + minSquare(32));

	}

	private static int minSquare(int n) {
		int sqrt = (int) Math.sqrt(n);

		int[] values = new int[n + 1];

		Arrays.fill(values, Integer.MAX_VALUE);

		values[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sqrt; j++) {
				if ((j * j) <= i) {
					values[i] = Math.min(values[i], 1 + values[i - (j * j)]);

				}

			}	

		}

		return values[n];
	}

}
