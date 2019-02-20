package DynamicProgramming;

public class MinimumNumberOfWquaresWhoseSumEqualsToGivenNumberN {
	public static void main(String[] args) {

		System.out.println("Minimum number is squares required for n=" + 6 + "  is " + minSquare(6));
	}

	private static int minSquare(int n) {

		if (n <= 0)
			return 0;

		int sqrt = (int) Math.sqrt(n);

		int res = Integer.MAX_VALUE;

		for (int i = sqrt; i >= 1; i--) {
			if (i * i <= n) {
				int temp = minSquare(n - i * i);

				if (temp + 1 < res) {
					res = temp + 1;
				}
			}

		}

		return res;
	}
}
