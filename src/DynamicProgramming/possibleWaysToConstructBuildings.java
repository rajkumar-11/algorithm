package DynamicProgramming;

public class possibleWaysToConstructBuildings {
	public static void main(String[] args) {
		int N = 10;
		System.out.println("Count of ways for " + N + " sections is " + countWays(N));

	}

	private static int countWays(int n) {
		if (n == 1)
			return 4;

		int countS = 1, countB = 1, prevS, prevB;

		for (int i = 2; i <= n; i++) {
			prevS = countS;
			prevB = countB;

			countS = prevB + prevS;
			countB = prevS;
		}

		int result = countS + countB;

		return result * result;
	}
}
