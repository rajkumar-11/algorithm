package DynamicProgramming;

public class possibleWaysToConstructBuildingsUsingFib {
	public static void main(String[] args) {
		int N = 5;
		System.out.println("Count of ways for " + N + " sections is " + countWays(N));
	}

	private static int countWays(int n) {
		int a = 0, b = 1, c = 1;

		if (n == 1)
			return 4;

		for (int i = 2; i <= n + 2; i++) {
			c = a + b;
			a = b;
			b = c;

		}

		return c * c;
	}
}
