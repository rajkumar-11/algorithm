package DynamicProgramming;

public class eggDrop {
	public static void main(String[] args) {
		int n = 10, k = 2;
		System.out.println(eggdrop(n, k));
	}

	private static int eggdrop(int n, int k) {
		if (n == 1 || n == 0)
			return n;

		if (k == 1)
			return n;

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {

			int m = Math.max(eggdrop(n - i, k), eggdrop(n - 1, k - 1));

			if (m < min)
				min = m;

		}
		System.out.println("min= " + min);

		return min + 1;
	}
}
