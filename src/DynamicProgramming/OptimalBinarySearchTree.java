package DynamicProgramming;

public class OptimalBinarySearchTree {
	public static void main(String[] args) {
		int keys[] = { 10, 12, 20 };
		int freq[] = { 34, 8, 50 };
		int n = keys.length;
		System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));

	}

	private static int optimalSearchTree(int[] keys, int[] freq, int n) {
		return optSearch(freq, 0, n - 1);
	}

	private static int optSearch(int[] freq, int i, int j) {
		if (i == j)
			return freq[i];
		if (i > j)
			return 0;

		int sum = SumOfFreq(freq, i, j);

		int min = Integer.MAX_VALUE;

		for (int x = i; x <= j; x++) {
			int temp = optSearch(freq, i, x - 1) + optSearch(freq, x + 1, j);

			if (temp < min)
				min = temp;

		}

		return sum + min;
	}

	private static int SumOfFreq(int[] freq, int i, int j) {
		int sum = 0;

		for (int x = i; x <= j; x++) {
			sum += freq[x];
		}

		return sum;
	}
}
