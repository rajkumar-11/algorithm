package Misc;

public class ValidParenthesesExpressionsOfGivenLengthUsingDP {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Total possible expressions of length " + n + " is " + findWays(n));

	}

	private static int findWays(int n) 
	{
		if (n == 1)
			return 1;

		return catalan(n / 2);
	}

	private static int catalan(int n)
	{
		int[] catalan = new int[n + 1];

		catalan[0] = catalan[1] = 1;

		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];

			}

		}

		return catalan[n];
	}

}
