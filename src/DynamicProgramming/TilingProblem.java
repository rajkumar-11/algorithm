package DynamicProgramming;

public class TilingProblem {
	public static void main(String[] args) {
		int n = 6;
		System.out.println("the maximum number of variation of tiles will be " + findSolution(n));

	}

	private static int findSolution(int n) {
		if (n <= 2)
			return n;
		int[] fib = new int[n + 1];

		fib[1] = 1;
		fib[2] = 2;

		for (int i = 3; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];

		}

		return fib[n];
	}
}
