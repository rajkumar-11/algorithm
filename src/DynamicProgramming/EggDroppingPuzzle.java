package DynamicProgramming;

public class EggDroppingPuzzle {
	public static void main(String[] args) {
		int n = 2;
		int k = 10;

		System.out.println("Minimum Number of trails required for no of coins = " + n + "  and number of floors = " + k
				+ " will be equal to " + getNumberOfTrails(n, k));

	}

	private static int getNumberOfTrails(int n, int k) {
		if (k == 1 || k == 0)
			return k;

		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= k; i++) {
			int temp = Math.max(getNumberOfTrails(n, k - i), getNumberOfTrails(n - 1, i - 1));
			if (temp < min)
				min = temp;
		}

		return min + 1;

	}
}
